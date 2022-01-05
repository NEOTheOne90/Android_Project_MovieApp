package com.example.freep;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TimePicker;

public class MainActivity extends AppCompatActivity {

    Spinner mSpinner, thSpinner;
    EditText nump;
    Button RButton;

    TimePicker timePicker1;

    String moviess = "매트릭스";
    String theaterss = "롯데시네마 서면";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("영화 예매");

        final EditText nump = (EditText) findViewById(R.id.nump);
        final Button RButton = (Button) findViewById(R.id.RButton);

        final TimePicker timePicker1 = (TimePicker) findViewById(R.id.timePicker1);
        timePicker1.setIs24HourView(true);


        final Spinner mSpinner= findViewById(R.id.mSpinner);
        final String[] movies= {"매트릭스","테넷","스파이더맨"};
        ArrayAdapter<String> adapter1= new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, movies);
        mSpinner.setAdapter(adapter1);

        mSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                moviess = parent.getItemAtPosition(position).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        final Spinner thSpinner= findViewById(R.id.thSpinner);
        final String[] theaters= {"롯데시네마 서면점","롯데시네마 부산본점","CGV 서면삼정타워점"};
        ArrayAdapter<String> adapter2= new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, theaters);
        thSpinner.setAdapter(adapter2);

        thSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                theaterss = parent.getItemAtPosition(position).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        RButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, DialogActivity.class);

                String tmpnump = nump.getText().toString();
                intent.putExtra("dnum",tmpnump);
//                nump.setText("");

                String tmpthSpinner = thSpinner.getSelectedItem().toString();
                intent.putExtra("dthSpinner",tmpthSpinner);

                String tmptimepicker = timePicker1.getCurrentHour().toString();
                intent.putExtra("dhour",tmptimepicker);

                String tmptimepicker2 = timePicker1.getCurrentMinute().toString();
                intent.putExtra("dminute",tmptimepicker2);

                String tmpmSpinner = mSpinner.getSelectedItem().toString();
                intent.putExtra("dmSpinner",tmpmSpinner);


                startActivity(intent);
            }
        });



    }

}