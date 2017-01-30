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

    public ArrayList<String> subjects = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        subjects.add("Math");
        subjects.add("Physics");
        subjects.add("Marvel Super Heroes");

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, subjects);

        ListView lv = (ListView) findViewById(R.id.list_view);
        lv.setAdapter(adapter);

        AdapterView.OnItemClickListener clickListener = new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                Intent intent = new Intent(view.getContext(), Overview.class);
                String subjects = (String) adapterView.getItemAtPosition(position);
                intent.putExtra("message", subjects);
                startActivity(intent);
            }
        };

        lv.setOnItemClickListener(clickListener);
    }
}
