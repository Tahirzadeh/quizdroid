package edu.washington.abbast.quizdroid;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Abbas on 2/13/17.
 */

public class Question {

    private String QUESTION, OPTION1, OPTION2, OPTION3, OPTION4;
    private int CORRECT_ANSWER;
//    public String question;
//    public List<String> answers;
//    public int correct;

    public Question(String question, String option1, String option2, String option3,
                    String option4, int answer){
        QUESTION = question;
        OPTION1 = option1;
        OPTION2 = option2;
        OPTION3 = option3;
        OPTION4 = option4;
        CORRECT_ANSWER = answer;

//        question = "Question?";
//        answers = new ArrayList<String>();
//        answers.add("Answer 1");
//        answers.add("Answer 2");
//        answers.add("Answer 3");
//        answers.add("Answer 4");
//        correct = 3;
    }

    public String getQUESTION() {
        return QUESTION;
    }

    public void setQUESTION(String questionText) {
        QUESTION = questionText;
    }

    public String getOPTION1() {
        return OPTION1;
    }

    public void setOPTION1(String option1) {
        OPTION1 = option1;
    }

    public String getOPTION2() {
        return OPTION2;
    }

    public void setOPTION2(String option2) {
        OPTION1 = option2;
    }

    public String getOPTION3() {
        return OPTION3;
    }

    public void setOPTION3(String option3) {
        OPTION1 = option3;
    }

    public String getOPTION4() {
        return OPTION4;
    }

    public void setOPTION4(String option4) {
        OPTION1 = option4;
    }

    public int getAnswer() {
        return CORRECT_ANSWER;
    }

    public void setAnswer(int answer) {
        CORRECT_ANSWER = answer;
    }
}
