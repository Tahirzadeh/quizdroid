package edu.washington.abbast.quizdroid;


import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class OverviewFragment extends Fragment {

    private String topic;
    private Activity hostActivity;

    public OverviewFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_overview, container, false);

        Button begin = (Button) view.findViewById(R.id.begin);
        TextView heading = (TextView) view.findViewById(R.id.topic);
        TextView description = (TextView) view.findViewById(R.id.topic_description);
        TextView questions = (TextView) view.findViewById(R.id.question_count);

        heading.setText(topic);
        initializeDandQ(topic, description, questions);

        begin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(hostActivity instanceof OverviewQAActivity) {
                    ((OverviewQAActivity) hostActivity).loadQuestionFragment(1,0,0,0);
                }
            }
        });

        return view;
    }

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if(getArguments() != null) {
            topic = getArguments().getString("message");
        }

        hostActivity = getActivity();
    }

    private void initializeDandQ(String topic, TextView description, TextView questions) {
        if(topic.equals("Math")) {
            description.setText("You have selected the subject 'Math'. Here, you will be asked " +
                    "simple arithmetic questions!");
        } else if(topic.equals("Physics")) {
            description.setText("You have selected the subject 'Physics'. Here, you will be asked " +
                    "questions regarding equations and definitions in this subject.");
        } else {
            description.setText("You have selected the subject 'Marvel Super Heroes'. Here, you " +
                    "will be asked questions regarding characters pertaining to Marvel.");
        }
        questions.setText("There are 3 questions in this section.");
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }
}
