package com.grr.jd2course;

import com.grr.jd2course.exceptions.BadRequestException;
import com.grr.jd2course.exceptions.ExistedQuestion;
import com.grr.jd2course.services.JavaQuestionService;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static com.grr.jd2course.ConstantsForTests.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
public class JavaQuestionServiceTest {

    private final JavaQuestionService out = new JavaQuestionService();


    @Test
    public void shouldAddQuestion() throws ExistedQuestion {
        assertEquals(MAP_OF_QUESTIONS.get(QUESTION_1.getQuestion()) ,out.add(QUESTION_1));
        assertEquals(MAP_OF_QUESTIONS.get(QUESTION_2.getQuestion()) ,out.add(QUESTION_2));
        assertEquals(MAP_OF_QUESTIONS.get(QUESTION_3.getQuestion()) ,out.add(QUESTION_3));
        assertEquals(MAP_OF_QUESTIONS.get(QUESTION_4.getQuestion()) ,out.add(QUESTION_4));
    }

    @Test
    public void shouldReturnExistedQuestionException () throws ExistedQuestion {
        out.add(QUESTION_1);
        out.add(QUESTION_2);
        out.add(QUESTION_3);
        out.add(QUESTION_4);
        assertThrows(ExistedQuestion.class, () -> out.add(QUESTION_1));
        assertThrows(ExistedQuestion.class, () -> out.add(QUESTION_2));
        assertThrows(ExistedQuestion.class, () -> out.add(QUESTION_3));
        assertThrows(ExistedQuestion.class, () -> out.add(QUESTION_4));
    }

    @Test
    public void shouldReturnExistedQuestionExceptionWhenAddinsgStringsAsAParams () throws ExistedQuestion {
        out.add(QUESTION_1);
        out.add(QUESTION_2);
        out.add(QUESTION_3);
        out.add(QUESTION_4);
        assertThrows(ExistedQuestion.class, () -> out.add(Q1,A1));
        assertThrows(ExistedQuestion.class, () -> out.add(Q2,A2));
        assertThrows(ExistedQuestion.class, () -> out.add(Q3,A3));
        assertThrows(ExistedQuestion.class, () -> out.add(Q4,A4));
    }

    @Test
    public void shouldAddQuestionWhenAddingStringsAsAParams() throws ExistedQuestion {
        assertEquals(MAP_OF_QUESTIONS.get(QUESTION_1.getQuestion()) ,out.add(Q1,A1));
        assertEquals(MAP_OF_QUESTIONS.get(QUESTION_2.getQuestion()) ,out.add(Q2,A2));
        assertEquals(MAP_OF_QUESTIONS.get(QUESTION_3.getQuestion()) ,out.add(Q3,A3));
        assertEquals(MAP_OF_QUESTIONS.get(QUESTION_4.getQuestion()) ,out.add(Q4,A4));
    }

    @Test
    public void shouldRemoveQuestions() throws BadRequestException, ExistedQuestion {
        out.add(QUESTION_1);
        out.add(QUESTION_2);
        out.add(QUESTION_3);
        out.add(QUESTION_4);
        assertEquals(MAP_OF_QUESTIONS.get(QUESTION_1.getQuestion()) ,out.remove(QUESTION_1));
        assertEquals(MAP_OF_QUESTIONS.get(QUESTION_2.getQuestion()) ,out.remove(QUESTION_2));
        assertEquals(MAP_OF_QUESTIONS.get(QUESTION_3.getQuestion()) ,out.remove(QUESTION_3));
        assertEquals(MAP_OF_QUESTIONS.get(QUESTION_4.getQuestion()) ,out.remove(QUESTION_4));
    }

    @Test
    public void shouldThrowBasRequestExecptionWhenRemoveQuestions(){
        assertThrows(BadRequestException.class, () -> out.remove(QUESTION_1));
        assertThrows(BadRequestException.class, () -> out.remove(QUESTION_2));
        assertThrows(BadRequestException.class, () -> out.remove(QUESTION_3));
        assertThrows(BadRequestException.class, () -> out.remove(QUESTION_4));
    }

    @Test
    public void shouldReturnArrayList() throws ExistedQuestion {
        out.add(QUESTION_1);
        out.add(QUESTION_2);
        out.add(QUESTION_3);
        out.add(QUESTION_4);
        assertEquals(ArrayList.class, out.getAll().getClass());
    }

}
