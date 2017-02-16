package edu.washington.abbast.quizdroid;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Abbas on 2/13/17.
 */

public class Question {
    public String question;
    public List<String> answers;
    public int correct;

    public Question(){
        question = "Question?";
        answers = new ArrayList<String>();
        answers.add("Answer 1");
        answers.add("Answer 2");
        answers.add("Answer 3");
        answers.add("Answer 4");
        correct = 3;
    }
}
