package com.Ha.Anh.service;

import com.Ha.Anh.dto.StudentGradeDto;
import com.Ha.Anh.model.Grade;
import com.Ha.Anh.repository.GradeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class GradeService {

    @Autowired
    private GradeRepository gradeRepository;

    @GetMapping("/manage-grade/students")
    @ResponseBody
    public List<StudentGradeDto> getGradesBySubjectId(@RequestParam("subjectId") String subjectId) {
        // Lấy danh sách Grade từ repository theo subjectId
        List<Grade> grades = gradeRepository.findById_SubjectID(subjectId);

        // Chuyển đổi dữ liệu thành DTO để trả về cho frontend
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
    }

}
