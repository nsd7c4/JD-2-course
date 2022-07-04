package com.grr.jd2course;

import com.grr.jd2course.data.Question;
import com.grr.jd2course.exceptions.BadRequestException;
import com.grr.jd2course.exceptions.ExistedQuestion;
import com.grr.jd2course.services.ExaminerServiceImpl;
import com.grr.jd2course.services.JavaQuestionService;
import com.grr.jd2course.services.QuestionService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collection;

import static org.mockito.Mockito.*;
import static com.grr.jd2course.ConstantsForTests.*;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class ExaminerServiceImplTest {
    @InjectMocks
    private ExaminerServiceImpl out;

    @Mock
    private JavaQuestionService questionServiceMock;

    @Test
    public void shouldReturnCollection() throws BadRequestException {
        assertEquals(out.getQuestions(QUESTIONS_COUNT) , MOCK_LIST);
    }

    @Test
    public void shouldReturnExceptionWhenExceededTotalQuestionCount(){
        assertThrows(BadRequestException.class, () -> out.getQuestions(QUESTIONS_COUNT+1));
    }

    @BeforeEach
    public void addQuestionsToMockService() {
        when(questionServiceMock.getAll())
                .thenReturn(MOCK_LIST);
    }
}
