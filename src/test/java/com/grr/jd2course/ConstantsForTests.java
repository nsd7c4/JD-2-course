package com.grr.jd2course;

import com.grr.jd2course.data.Question;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ConstantsForTests {

    public static int QUESTIONS_COUNT = 4;

    public static String Q1 = "Java_Q_1";
    public static String A1 = "Java_A_1";
    public static Question QUESTION_1= new Question(Q1,A1);

    public static String Q2 = "Java_Q_2";
    public static String A2 = "Java_A_2";
    public static Question QUESTION_2= new Question(Q2,A2);

    public static String Q3 = "Java_Q_3";
    public static String A3 = "Java_A_3";
    public static Question QUESTION_3= new Question(Q3,A3);

    public static String Q4 = "Java_Q_4";
    public static String A4 = "Java_A_4";
    public static Question QUESTION_4= new Question(Q4,A4);

    public static final Map<String, Question> MAP_OF_QUESTIONS = new HashMap<>(Map.of(
            Q1, QUESTION_1,
            Q2, QUESTION_2,
            Q3, QUESTION_3,
            Q4, QUESTION_4
            ));

    public static final ArrayList<Question> MOCK_LIST = new ArrayList<>(MAP_OF_QUESTIONS.values());
}
