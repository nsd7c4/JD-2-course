package com.grr.jd2course.controllers;

import com.grr.jd2course.data.Question;
import com.grr.jd2course.exceptions.BadRequestException;
import com.grr.jd2course.exceptions.ExistedQuestion;
import com.grr.jd2course.services.ExaminerServiceImpl;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
public class ExamController {
    private final ExaminerServiceImpl examinerService;

    public ExamController(ExaminerServiceImpl examinerService) {
        this.examinerService = examinerService;
    }

    @GetMapping("/exam/get/{amount}")
    public Collection<Question> getQuestions(@PathVariable("amount") int amount) throws BadRequestException {
        return examinerService.getQuestions(amount);
    }
}
