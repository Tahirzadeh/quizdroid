package edu.washington.abbast.quizdroid;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Abbas on 2/13/17.
 */

public class Topic {

    private String TITLE, SHORT_DESCR, LONG_DESCR;
    private List<Question> questions;

    public Topic(){

    }

    public Topic(String title, String shortDescription, String longDescription, List<Question> questions){
        this.TITLE = title;
        this.SHORT_DESCR = shortDescription;//"Short description for " + title + " quiz.";
        this.LONG_DESCR = longDescription;//"Long description for " + title + " quiz.";
        this.questions = questions;//new ArrayList<Question>();
    }

    public void setTitle(String title) {
        this.TITLE = title;
    }

    public String getTITLE() {
        return TITLE;
    }

    public void setShortDescription(String shortDescription) {
        this.SHORT_DESCR = shortDescription;
    }

    public String getShortDescription() {
        return SHORT_DESCR;
    }

    public void setLongDescription(String longDescription) {
        this.LONG_DESCR = longDescription;
    }
    public String getLongDescription() {
        return LONG_DESCR;
    }

    public void setQuestions(List<Question> questions) {
        this.questions = questions;
    }

    public List<Question> getQuestions() {
        return questions;
    }

    @Override
    public String toString(){
        return this.TITLE + ": " + this.SHORT_DESCR;
    }
}
