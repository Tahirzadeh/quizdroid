package edu.washington.abbast.quizdroid;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Abbas on 2/13/17.
 */

public interface TopicRepository {

    public List<Topic> getTopics();

//    private List<Topic> topics;
//
//    private TopicRepository() {
//        topics = new ArrayList<Topic>();
//        topics.add(new Topic("Math"));
//        topics.add(new Topic("Physics"));
//        topics.add(new Topic("Marvel Supher Heroes"));
//
//    }
//
//    private static TopicRepository instance = new TopicRepository();
//
//    public static TopicRepository getInstance() {
//        return instance;
//    }
//
//    public List<Topic> getTopics() {
//        return topics;
//    }
}
