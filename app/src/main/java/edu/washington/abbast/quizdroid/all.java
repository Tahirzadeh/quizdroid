package edu.washington.abbast.quizdroid;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class all extends AppCompatActivity {

    private String topic;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all);

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        Bundle bundle = getIntent().getExtras();
        topic = bundle.getString("topicKey");

        overview oFragment = new overview();
        oFragment.setArguments(bundle);
        fragmentTransaction.add(R.id.all_fragment, oFragment);
        fragmentTransaction.commit();
    }

    public void loadQuestionFragment(int questionNum, int correct, int selected, int isAnswer) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        Bundle questionBundle = new Bundle();

        questionBundle.putInt("questions", questionNum);
        questionBundle.putInt("correct", correct);
        questionBundle.putInt("selectedAnswer", selected);
        questionBundle.putInt("isAnswer", isAnswer);

        questionFragment qf = new questionFragment();
        qf.setArguments(questionBundle);

        fragmentTransaction.replace(R.id.all_fragment, qf);
        fragmentTransaction.commit();

    }

    public void loadAnswerFragment(int questionNum, int correct, int selected, int isAnswer) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        Bundle questionBundle = new Bundle();

        questionBundle.putInt("questions", questionNum);
        questionBundle.putInt("correct", correct);
        questionBundle.putInt("selectedAnswer", selected);
        questionBundle.putInt("isAnswer", isAnswer);

        answer af = new answer();
        af.setArguments(questionBundle);

        fragmentTransaction.replace(R.id.all_fragment, af);
        fragmentTransaction.commit();

    }

}
