package com.example.sharetext;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {


    EditText et1;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et1 = findViewById(R.id.et);


    }

    public void share(View view) {

        Intent msgintent = new Intent(Intent.ACTION_SEND);
        msgintent.setType("text/plain");
        msgintent.putExtra(Intent.EXTRA_TEXT, et1.getText().toString());
        startActivity(Intent.createChooser(msgintent, "chooser title"));

    }
}