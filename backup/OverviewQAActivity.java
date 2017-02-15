package edu.washington.abbast.quizdroid;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class OverviewQAActivity extends AppCompatActivity {

    private String topic;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_fragment_overview__qn);

        android.support.v4.app.FragmentManager fragmentManager = getSupportFragmentManager();
        android.support.v4.app.FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        Bundle bundle = getIntent().getExtras();
        topic = bundle.getString("message");

        OverviewFragment of = new OverviewFragment();
        of.setArguments(bundle);
        fragmentTransaction.add(R.id.overview_fragment, of);
        fragmentTransaction.commit();
    }

    public void loadQuestionFragment(int qNumber, int correct, int selected, int isAnswer) {
        android.support.v4.app.FragmentManager fragmentManager = getSupportFragmentManager();
        android.support.v4.app.FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        Bundle questionBundle = new Bundle();

        questionBundle.putInt("questions", qNumber);
        questionBundle.putInt("correct", correct);
        questionBundle.putInt("selectedAnswer", selected);
        questionBundle.putInt("isAnswer", isAnswer);

        questionFragment qf = new questionFragment();
        qf.setArguments(questionBundle);

        fragmentTransaction.replace(R.id.overview_fragment, qf);
        fragmentTransaction.commit();
    }

    public void loadAnswerFragment(int qNumber, int correct, int selected, int isAnswer) {
        android.support.v4.app.FragmentManager fragmentManager = getSupportFragmentManager();
        android.support.v4.app.FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        Bundle questionBundle = new Bundle();

        questionBundle.putInt("questions", qNumber);
        questionBundle.putInt("correct", correct);
        questionBundle.putInt("selectedAnswer", selected);
        questionBundle.putInt("isAnswer", isAnswer);

        answer af = new answer();
        af.setArguments(questionBundle);

        fragmentTransaction.replace(R.id.overview_fragment, af);
        fragmentTransaction.commit();
    }
}
