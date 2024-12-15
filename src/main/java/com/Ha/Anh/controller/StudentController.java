package com.Ha.Anh.controller;

import com.Ha.Anh.dto.StudentGradeDto;
import com.Ha.Anh.model.Grade;
import com.Ha.Anh.model.Subject;
import com.Ha.Anh.repository.GradeRepository;
import com.Ha.Anh.repository.SubjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private GradeRepository gradeRepository;

    @Autowired
    private SubjectRepository subjectRepository;

    // Trang chính dành cho Student
    @GetMapping
    public String studentPage() {
        return "student"; // Trang chính cho sinh viên
    }

    // Trang Quản lý điểm
    @GetMapping("/manage-grade")
    public String pointManagementPage(Model model) {
        // Lấy danh sách môn học để hiển thị trong dropdown
        List<Subject> subjects = subjectRepository.findAll();
        model.addAttribute("subjects", subjects);
        return "manage_grade"; // Trang Quản lý điểm
    }

    // Phương thức trả về danh sách điểm của sinh viên theo subjectId
    @GetMapping("/manage-grade/students")
    @ResponseBody
    public List<StudentGradeDto> getGradesBySubjectId(@RequestParam("subjectId") String subjectId) {
        try {
            List<Grade> grades = gradeRepository.findById_SubjectID(subjectId);
            return grades.stream()
                    .map(grade -> new StudentGradeDto(
                            grade.getId().getStudentID(),
                            grade.getStudent().getStudentName(),
                            grade.getRegularGrade1(),
                            grade.getRegularGrade2(),
                            grade.getFinalGrade(),
                            grade.getAbsentHours(),
                            grade.getExamCondition()))
                    .collect(Collectors.toList());
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Error while fetching grades");
        }
    }

}
