package com.example.freep;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class DialogActivity extends AppCompatActivity {

    Button btns1,btns2,btns3,btnback;
    ImageView poster;
    TextView textR;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.comp_dialog);

        final Button btns1 = (Button) findViewById(R.id.btns1);
        final Button btns2 = (Button) findViewById(R.id.btns2);
        final Button btns3 = (Button) findViewById(R.id.btns3);
        final Button btnback = (Button) findViewById(R.id.btnback);

        final TextView textR = (TextView) findViewById(R.id.textR);
        final ImageView poster = (ImageView) findViewById(R.id.poster);



        btns1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent locations = new Intent(Intent.ACTION_VIEW);
                locations.setData(Uri.parse("https://map.naver.com/v5/entry/place/13495857?c=14366882.6503934,4185143.0493016,15,0,0,0,dh"));
                startActivity(locations);
            }
        });
        btns2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent locations = new Intent(Intent.ACTION_VIEW);
                locations.setData(Uri.parse("https://map.naver.com/v5/entry/place/12137077?c=14366882.6503934,4185143.0493016,15,0,0,0,dh"));
                startActivity(locations);
            }
        });
        btns3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent locations = new Intent(Intent.ACTION_VIEW);
                locations.setData(Uri.parse("https://map.naver.com/v5/entry/place/1578889482?c=14366532.9847409,4184897.5208235,15,0,0,0,dh"));
                startActivity(locations);
            }
        });
        btnback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        Intent intent = getIntent();
        String dnum = intent.getStringExtra("dnum");
        String dthSpinner = intent.getStringExtra("dthSpinner");
        String dhour = intent.getStringExtra("dhour");
        String dminute = intent.getStringExtra("dminute");
        String dmSpinner = intent.getStringExtra("dmSpinner");

        textR.setText(dthSpinner+" "+dhour+"시"+dminute+"분 "+dnum+"명  "+dmSpinner);


        if(dmSpinner.equals("매트릭스")){
            poster.setImageResource(R.drawable.matrix);
        }
        else if(dmSpinner.equals("테넷")){
            poster.setImageResource(R.drawable.tenet);
        }
        else if(dmSpinner.equals("스파이더맨")){
            poster.setImageResource(R.drawable.spiderman);
        }





    }



}
