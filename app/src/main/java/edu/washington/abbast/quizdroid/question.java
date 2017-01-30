package edu.washington.abbast.quizdroid;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class question extends AppCompatActivity {

    public int qNum;
    public int correctAnswer;
    public String submittedAnswer;
    public int selectedAnswer;
    public int isAnswer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question);

        final Button submitButton = (Button) findViewById(R.id.submit);

        RadioGroup answers = (RadioGroup) findViewById(R.id.answers);

        RadioButton a = (RadioButton) findViewById(R.id.a);
        RadioButton b = (RadioButton) findViewById(R.id.b);
        RadioButton c = (RadioButton) findViewById(R.id.c);
        RadioButton d = (RadioButton) findViewById(R.id.d);

        Bundle bundle = getIntent().getExtras();
        qNum = bundle.getInt("question");
        correctAnswer = bundle.getInt("correct");
        isAnswer = bundle.getInt("isAnswer");
        selectedAnswer = bundle.getInt("selectedAnswer");

        if (isAnswer == 1 && qNum != 3) {
            submitButton.setVisibility(View.VISIBLE);
            submitButton.setText("NEXT");
        } else if(isAnswer == 1 && qNum == 3) {
            submitButton.setVisibility(View.VISIBLE);
            submitButton.setText("FINISH");
        } else {
            submitButton.setText("Submit");
            submitButton.setVisibility(View.INVISIBLE);
        }

        final TextView question = (TextView) findViewById(R.id.question);

        if (qNum == 1) {
            question.setText("What is 5 X 2?");
            a.setText("10");
            b.setText("6");
            c.setText("4");
            d.setText("8");

            if (isAnswer == 1) {
                RadioButton wrong = (RadioButton) findViewById(selectedAnswer);
                wrong.setTextColor(Color.RED);
                a.setTextColor(Color.GREEN);

                TextView total = (TextView) findViewById(R.id.total);
                total.setText("You have answered " + correctAnswer + " out of " + qNum +" answers correctly.");
            }

        } else if (qNum == 2) {
            question.setText("What is 5 + 3?");
            a.setText("9");
            b.setText("8");
            c.setText("10");
            d.setText("11");

            if (isAnswer == 1) {
                RadioButton wrong = (RadioButton) findViewById(selectedAnswer);
                wrong.setTextColor(Color.RED);
                b.setTextColor(Color.GREEN);

                TextView total = (TextView) findViewById(R.id.total);
                total.setText("You have answered " + correctAnswer + " out of " + qNum + " answers  correctly.");
            }
        } else {
            question.setText("What is 60 / 3?");
            a.setText("15");
            b.setText("20");
            c.setText("18");
            d.setText("17");

            if (isAnswer == 1) {
                RadioButton wrong = (RadioButton) findViewById(selectedAnswer);
                wrong.setTextColor(Color.RED);
                b.setTextColor(Color.GREEN);

                TextView total = (TextView) findViewById(R.id.total);
                total.setText("You have answered " + correctAnswer + " out of " + qNum + " answers correctly.");
            }
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
                if (isAnswer == 1) {
                    nextQuestion++;
                }
                if (nextQuestion <= 3) {
                    Intent intent = new Intent(view.getContext(), question.class);
                    intent.putExtra("question", nextQuestion);
                    if (isAnswer == 0) {
                        intent.putExtra("isAnswer", 1);
                    } else {
                        intent.putExtra("isAnswer", 0);
                    }
                    intent.putExtra("selectedAnswer", selectedAnswer);
                    intent.putExtra("correct", correctAnswer);
                    startActivity(intent);
                } else if (nextQuestion > 3){
                    //Finish page
                    Intent intent = new Intent(view.getContext(), MainActivity.class);
                    startActivity(intent);
                }
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
    }


}
