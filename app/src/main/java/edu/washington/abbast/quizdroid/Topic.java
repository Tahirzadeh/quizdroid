package edu.washington.abbast.quizdroid;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Abbas on 2/13/17.
 */

public class Topic {
    public String title;
    public String shortDescr;
    public String longDescr;
    public List<Question> questions;

    public Topic(){
        this("");
    }

    public Topic(String title){
        this.title = title;
        this.shortDescr = "Short description for " + title + " quiz.";
        this.longDescr = "Long description for " + title + " quiz.";
        this.questions = new ArrayList<Question>();
        questions.add(new Question());
        questions.add(new Question());
        questions.add(new Question());
    }

    @Override
    public String toString(){
        return this.title + ": " + this.shortDescr;
    }
}
