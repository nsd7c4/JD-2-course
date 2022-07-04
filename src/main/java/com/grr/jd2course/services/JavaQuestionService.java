package com.grr.jd2course.services;

import com.grr.jd2course.data.Question;
import com.grr.jd2course.exceptions.BadRequestException;
import com.grr.jd2course.exceptions.ExistedQuestion;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.Collection;
import java.util.stream.Collectors;

@Service
@Repository
public class JavaQuestionService implements QuestionService{
    private final Map<String, Question> QuestionsList = new HashMap<>(Map.of(
//            "Java_Q_1", new Question("Java_Q_1","Java_A_1"),
//            "Java_Q_2", new Question("Java_Q_2","Java_A_2"),
//            "Java_Q_3", new Question("Java_Q_3","Java_A_3"),
//            "Java_Q_4", new Question("Java_Q_4","Java_A_4")
    ));


    @Override
    public Question add(String question, String answer) throws ExistedQuestion {
        Question result = new Question(question,answer);
        this.add(result);
        return result;
    }


    @Override
    public Question add(Question question) throws ExistedQuestion {
        if (QuestionsList.containsKey(question.getQuestion())){
            throw new ExistedQuestion();
        }
        QuestionsList.put(question.getQuestion(),question);
        return question;
    }

    @Override
    public Question remove(Question question) throws BadRequestException {
        Question result = QuestionsList.get(question.getQuestion());
        if (!QuestionsList.containsKey(question.getQuestion())) {
            throw new BadRequestException();
        }
        QuestionsList.remove(question.getQuestion());
        return result;
    }

    @Override
    public Collection<Question> getAll() {
        return new ArrayList<>(QuestionsList.values());
    }

    @Override
    public Question getRandomQuestion() throws BadRequestException {
        if (QuestionsList.size() == 0) {
            throw  new BadRequestException();
        }
        ArrayList<Question> result = (ArrayList<Question>) this.getAll();
        Collections.shuffle(result);
        return result.get(0);
    }

}
