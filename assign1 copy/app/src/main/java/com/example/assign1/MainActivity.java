package com.example.assign1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button b1;
    Button b2;
    Button b3;
    Button b4;
    TextView dis;
    int count =0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        b1 = findViewById(R.id.button);
        b2 = findViewById(R.id.button2);
        b3 = findViewById(R.id.button3);
        b4 = findViewById(R.id.button4);
        dis = findViewById(R.id.tv);



        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                count++;
                dis.setText(""+ count);
            }
        });

        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                count--;
                dis.setText(""+ count);
            }
        });

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                count= 0;
                dis.setText(""+count);
            }
        });

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(),"Count is:  "+ count,Toast.LENGTH_SHORT).show();
            }
        });

        if(savedInstanceState!=null){
            String s = savedInstanceState.getString("P");
            count = Integer.parseInt(s);
            dis.setText(""+ count);



        }



    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString("P",dis.getText().toString());
    }
}