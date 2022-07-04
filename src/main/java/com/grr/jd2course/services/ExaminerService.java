package com.grr.jd2course.services;

import com.grr.jd2course.data.Question;
import com.grr.jd2course.exceptions.BadRequestException;
import com.grr.jd2course.exceptions.ExistedQuestion;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.Collection;


public interface ExaminerService {
    Collection<Question> getQuestions(int amount) throws BadRequestException, ExistedQuestion;
}
