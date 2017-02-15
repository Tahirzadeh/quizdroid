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
public class overview extends Fragment {

    private String topic;
    private Activity hostActivity;

    public overview() {
        // Required empty public constructor
    }

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if(getArguments() != null) {
            topic = getArguments().getString("topicKey");
        }
        hostActivity = getActivity();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_overview2, container, false);

        Button begin = (Button) view.findViewById(R.id.fragment_begin);
        TextView heading = (TextView) view.findViewById(R.id.fragment_topic);
        TextView description = (TextView) view.findViewById(R.id.fragment_description);
        TextView questions = (TextView) view.findViewById(R.id.fragment_question);

        heading.setText(topic);
        initializeDandQ(topic, description, questions);


        begin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(hostActivity instanceof all) {
                    ((all) hostActivity).loadQuestionFragment(1, 0, 0, 0);
                }
            }
        });
        // Inflate the layout for this fragment
        return view;
    }

    private void initializeDandQ(String topic, TextView d, TextView q) {
        d.setText("You have selected the topic '" + topic + "'. You will be asked questions pertaining" +
                " to this subject matter.");
        q.setText("There are 3 questions in this section. \n\nAre you ready?");
//        if(topic.equals("Math")) {
//            d.setText("You chose Math. You will be asked arithmetic questions.");
//        } else if (topic.equals("Physics")) {
//            d.setText("You chose Physics. You will be asked questions regarding physics equations" +
//                    "and concepts");
//        } else { //Marvel Super Heroes
//            d.setText("You chose Marvel Super Heroes. You will be asked questions regarding Super Heroes");
//        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

}
