package edu.washington.abbast.quizdroid;

import android.app.Application;
import android.util.Log;

/**
 * Created by Abbas on 2/13/17.
 */

public class QuizApp extends Application {

    public static final String tag = "QuizApp";

    public QuizApp(){
        //Empty Constructor
    }

    private static QuizApp instance = new QuizApp();

    public static QuizApp getInstance() {
        return instance;
    }

    public TopicRepository getRepo() {
        return TopicRepository.getInstance();
    }

    @Override
    public void onCreate() {
        Log.d(tag, "Loaded correcting and running.");
    }
}
