package com.grr.jd2course.controllers;

import com.grr.jd2course.data.Question;
import com.grr.jd2course.exceptions.BadRequestException;
import com.grr.jd2course.exceptions.ExistedQuestion;
import com.grr.jd2course.services.JavaQuestionService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
public class JavaQuestionController {

    private final JavaQuestionService javaQuestionService;

    public JavaQuestionController(JavaQuestionService javaQuestionService) {
        this.javaQuestionService = javaQuestionService;
    }

    @GetMapping("/exam/java")
    public Collection<Question> allQuestions(){
        return javaQuestionService.getAll();
    }

    @GetMapping("/exam/java/add")
    public Question addQuestion(@RequestParam("q") String question,
                                @RequestParam("a") String answer) throws ExistedQuestion {
        return javaQuestionService.add(question, answer);
    }


    @GetMapping("/exam/java/remove")
    public Question removeQuestion(@RequestParam("q") String question,
                                @RequestParam("a") String answer) throws BadRequestException {
        return javaQuestionService.remove(new Question(question,answer));
    }


}
