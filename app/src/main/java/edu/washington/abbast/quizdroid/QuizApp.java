package edu.washington.abbast.quizdroid;

import android.app.Application;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Abbas on 2/13/17.
 */

public class QuizApp extends Application implements TopicRepository {

    private static QuizApp singleton;
    public List<Topic> topic;

    public QuizApp(){
        if(singleton == null) {
            singleton = this;
        } else {
            Log.e("QuizApp", "There is already a QuizApp running!");
            throw new RuntimeException();
        }
        topic = new ArrayList<Topic>();
    }

    //private static QuizApp instance = new QuizApp();

    public static QuizApp getInstance() {
        return singleton;
    }

//    public TopicRepository getRepo() {
//        return TopicRepository.getInstance();
//    }

    @Override
    public void onCreate() {
        Log.d("QuizApp onCreate()", "OnCreate Loaded correctly and running.");
    }

    @Override
    public List<Topic> getTopics() {
        return topic;
    }
}
