package com.grr.jd2course.services;

import com.grr.jd2course.data.Question;
import com.grr.jd2course.exceptions.BadRequestException;
import com.grr.jd2course.exceptions.ExistedQuestion;

import java.util.Collection;

public interface QuestionService {
    Question add(String question, String  answer) throws ExistedQuestion;
    Question add(Question question) throws ExistedQuestion;
    Question remove(Question question) throws BadRequestException;
    Collection<Question> getAll();
    Question getRandomQuestion() throws BadRequestException;
}
