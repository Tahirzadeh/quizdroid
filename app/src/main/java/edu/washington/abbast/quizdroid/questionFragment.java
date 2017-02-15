package edu.washington.abbast.quizdroid;


import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class questionFragment extends Fragment {

    private Activity hostActivity;
    public int questionNum, correctAnswer, selectedAnswer, isAnswer;
    public String submittedAnswer;



    public questionFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if(getArguments() != null) {
            questionNum = getArguments().getInt("questions");
            correctAnswer = getArguments().getInt("correct");
            selectedAnswer = getArguments().getInt("selectedAnswer");
            isAnswer = getArguments().getInt("isAnswer");
        }
        hostActivity = getActivity();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_question2, container, false);

        final Button submitButton = (Button) view.findViewById(R.id.submit);

        RadioGroup answers = (RadioGroup) view.findViewById(R.id.answers);

        RadioButton a = (RadioButton) view.findViewById(R.id.a);
        RadioButton b = (RadioButton) view.findViewById(R.id.b);
        RadioButton c = (RadioButton) view.findViewById(R.id.c);
        RadioButton d = (RadioButton) view.findViewById(R.id.d);

        a.setEnabled(true);
        b.setEnabled(true);
        c.setEnabled(true);
        d.setEnabled(true);

        submitButton.setText("Submit");
        submitButton.setVisibility(View.INVISIBLE);

        final TextView question = (TextView) view.findViewById(R.id.question);

        if(questionNum == 1) {
            question.setText("What is 5 x 2?");
            a.setText("10");
            b.setText("6");
            c.setText("8");
            d.setText("11");
        } else if (questionNum == 2) {
            question.setText("What is 5 + 3?");
            a.setText("10");
            b.setText("8");
            c.setText("6");
            d.setText("11");
        } else {
            question.setText("What is 60 / 3?");
            a.setText("15");
            b.setText("17");
            c.setText("18");
            d.setText("20");
        }

        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(isAnswer == 0) {
                    if(questionNum == 1) { //answers given which question it is
                        if(submittedAnswer.toLowerCase().equals("a")) {
                            correctAnswer++;
                        }
                    } else if(questionNum == 2) {
                        if(submittedAnswer.toLowerCase().equals("b")) {
                            correctAnswer++;
                        }
                    } else { //questionNum == 3
                        if(submittedAnswer.toLowerCase().equals("d")) {
                            correctAnswer++;
                        }
                    }
                }

                int nextQuestion = questionNum;
                if(nextQuestion <= 3) {
                    if(hostActivity instanceof all) {
                        ((all) hostActivity).loadAnswerFragment(nextQuestion, correctAnswer, selectedAnswer, 1);
                    }
                } else { //if nextQuestion > 3
                    Intent intent = new Intent(view.getContext(), MainActivity.class);
                    startActivity(intent);
                }
            }
        });

        answers.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                submitButton.setVisibility(View.VISIBLE);
                submittedAnswer = getResources().getResourceEntryName(checkedId);
                selectedAnswer = checkedId;
                submitButton.setText("Submit");
            }
        });

        // Inflate the layout for this fragment
        return view;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

}
