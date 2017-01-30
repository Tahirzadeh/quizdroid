package edu.washington.abbast.quizdroid;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Overview extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_overview);

        Bundle bundle = getIntent().getExtras();
        String subject = bundle.getString("message");

        Button begin = (Button) findViewById(R.id.begin);
        TextView heading = (TextView) findViewById(R.id.topic);
        TextView description = (TextView) findViewById(R.id.topic_description);
        TextView questions = (TextView) findViewById(R.id.question_count);

        heading.setText(subject);
        initializeDandQ(subject, description, questions);

        begin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), question.class);
                intent.putExtra("question", 1);
                intent.putExtra("isAnswer", 0);
                intent.putExtra("selectedAnswer", 0);
                intent.putExtra("correct", 0);
                startActivity(intent);
            }
        });

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
}
