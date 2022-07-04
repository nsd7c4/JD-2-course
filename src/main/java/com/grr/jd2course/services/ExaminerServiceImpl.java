package com.grr.jd2course.services;

import com.grr.jd2course.data.Question;
import com.grr.jd2course.exceptions.BadRequestException;
import com.grr.jd2course.exceptions.ExistedQuestion;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ExaminerServiceImpl implements ExaminerService{

    private final QuestionService questionService;

    public ExaminerServiceImpl(QuestionService questionService) {
        this.questionService = questionService;
    }

    @Override
    public Collection<Question> getQuestions(int amount) throws BadRequestException {
        Collection<Question> result = questionService.getAll();
        Collections.shuffle((List<?>) result);
        if (result.size()<amount){
            throw  new BadRequestException();
        }
        return result.stream().limit(amount).collect(Collectors.toList());
    }
}
