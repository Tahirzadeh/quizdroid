package edu.washington.abbast.quizdroid;


import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
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

    public int qNum;
    public int correctAnswer;
    public String submittedAnswer;
    public int selectedAnswer;
    public int isAnswer;

    public questionFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if(getArguments() != null) {
//            Bundle bundle = getActivity().getIntent().getExtras();
//            qNum = bundle.getInt("question");
//            correctAnswer = bundle.getInt("correct");
//            isAnswer = bundle.getInt("isAnswer");
//            selectedAnswer = bundle.getInt("selectedAnswer");
            qNum = getArguments().getInt("questions");
            correctAnswer = getArguments().getInt("correct");
            selectedAnswer = getArguments().getInt("selectedAnswer");
            isAnswer = getArguments().getInt("isAnswer");
        }
        hostActivity = getActivity();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View view = inflater.inflate(R.layout.fragment_question, container, false);

        //Fragment insertion (copy paste from old code)
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

//        if (isAnswer == 1 && qNum != 3) {
//            submitButton.setVisibility(View.VISIBLE);
//            submitButton.setText("NEXT");
//        } else if(isAnswer == 1 && qNum == 3) {
//            submitButton.setVisibility(View.VISIBLE);
//            submitButton.setText("FINISH");
//        } else {
//            submitButton.setText("Submit");
//            submitButton.setVisibility(View.INVISIBLE);
//        }

        final TextView question = (TextView) view.findViewById(R.id.question);

        if (qNum == 1) {
            question.setText("What is 5 X 2?");
            a.setText("10");
            b.setText("6");
            c.setText("4");
            d.setText("8");

//            if (isAnswer == 1) {
//                RadioButton wrong = (RadioButton) view.findViewById(selectedAnswer);
//                wrong.setTextColor(Color.RED);
//                a.setTextColor(Color.GREEN);
//
//                TextView total = (TextView) view.findViewById(R.id.total);
//                total.setText("You have answered " + correctAnswer + " out of " + qNum +" answers correctly.");
//            }

        } else if (qNum == 2) {
            question.setText("What is 5 + 3?");
            a.setText("9");
            b.setText("8");
            c.setText("10");
            d.setText("11");

//            if (isAnswer == 1) {
//                RadioButton wrong = (RadioButton) view.findViewById(selectedAnswer);
//                wrong.setTextColor(Color.RED);
//                b.setTextColor(Color.GREEN);
//
//                TextView total = (TextView) view.findViewById(R.id.total);
//                total.setText("You have answered " + correctAnswer + " out of " + qNum + " answers  correctly.");
//            }

        } else {
            question.setText("What is 60 / 3?");
            a.setText("15");
            b.setText("20");
            c.setText("18");
            d.setText("17");

//            if (isAnswer == 1) {
//                RadioButton wrong = (RadioButton) view.findViewById(selectedAnswer);
//                wrong.setTextColor(Color.RED);
//                b.setTextColor(Color.GREEN);
//
//                TextView total = (TextView) view.findViewById(R.id.total);
//                total.setText("You have answered " + correctAnswer + " out of " + qNum + " answers correctly.");
//            }
        }


        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (isAnswer == 0) {
                    if (qNum == 1) {
                        if (submittedAnswer.toLowerCase().equals("a")) {
                            correctAnswer++;
                        }
                    } else if (qNum == 2) {
                        if (submittedAnswer.toLowerCase().equals("b")) {
                            correctAnswer++;
                        }
                    } else {
                        if (submittedAnswer.toLowerCase().equals("b")) {
                            correctAnswer++;
                        }
                    }
                }

                int nextQuestion = qNum;

                if (nextQuestion <= 3) {
                    if(hostActivity instanceof OverviewQAActivity) {
                        ((OverviewQAActivity) hostActivity).loadAnswerFragment(nextQuestion,
                                correctAnswer, selectedAnswer, 1);
                    } else if (nextQuestion > 3) {
                        Intent intent = new Intent(view.getContext(), MainActivity.class);
                        startActivity(intent);
                    }
                }
//                if (isAnswer == 1) {
//                    nextQuestion++;
//                }
//                if (nextQuestion <= 3) {
//                    Intent intent = new Intent(view.getContext(), question.class);
//                    intent.putExtra("question", nextQuestion);
//                    if (isAnswer == 0) {
//                        intent.putExtra("isAnswer", 1);
//                    } else {
//                        intent.putExtra("isAnswer", 0);
//                    }
//                    intent.putExtra("selectedAnswer", selectedAnswer);
//                    intent.putExtra("correct", correctAnswer);
//                    startActivity(intent);
//                } else if (nextQuestion > 3){
//                    //Finish page
//                    Intent intent = new Intent(view.getContext(), MainActivity.class);
//                    startActivity(intent);
//                }
            }
        });

        answers.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener()
        {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                submitButton.setVisibility(View.VISIBLE);
                submittedAnswer = getResources().getResourceEntryName(checkedId);
                selectedAnswer = checkedId;
                submitButton.setText("Submit");

            }
        });

        return view;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

}
