package edu.washington.abbast.quizdroid;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.content.Intent;
import android.view.View;

import java.util.*;

public class MainActivity extends AppCompatActivity {

//    public ArrayList<String> subjects = new ArrayList<>();
    public String[] topics = {"Math", "Physics", "Marvel Super Heroes"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        subjects.add("Math");
//        subjects.add("Physics");
//        subjects.add("Marvel Super Heroes");

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, topics);

        ListView listView = (ListView) findViewById(R.id.list_view);
        listView.setAdapter(adapter);

        AdapterView.OnItemClickListener listener = new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                Intent intent = new Intent(view.getContext(), all.class);
                String topics = (String) adapterView.getItemAtPosition(position);
                intent.putExtra("topicKey", topics);
                startActivity(intent);
            }
        };

        listView.setOnItemClickListener(listener);
    }
}
