package com.example.io;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import static android.R.layout.simple_spinner_item;
import static android.widget.ArrayAdapter.createFromResource;

public class MainActivity extends AppCompatActivity {


    Button submit;
    EditText et;
    TextView tv;
    EditText ph;
    RadioButton r1;
    RadioButton r2;
    String gender;
    CheckBox java,python, android;
    Spinner sp_district, sp_mandal;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        submit = findViewById(R.id.button);
        et = findViewById(R.id.editText);
        tv = findViewById(R.id.newth);
        ph = findViewById(R.id.phone);
        r1 = findViewById(R.id.radioButton);
        r2 = findViewById(R.id.radioButton2);
        java = findViewById(R.id.java);
        python = findViewById(R.id.python);
        android = findViewById(R.id.android);
        sp_district=findViewById(R.id.district);
        sp_mandal=findViewById(R.id.mandal);


        @SuppressLint("ResourceType") ArrayAdapter<CharSequence> adapter =
                createFromResource(MainActivity.this,R.array.districts , simple_spinner_item);

        sp_district.setAdapter(adapter);

        sp_district.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                switch(i){
                    case 0:
                        Toast.makeText(getApplicationContext(),"Select option",Toast.LENGTH_SHORT).show();

                    case 1:
                        ArrayAdapter<CharSequence> ant_mandals=
                                ArrayAdapter.createFromResource(MainActivity.this, R.array.Anantapur_Mnadals, simple_spinner_item);

                    case 2:
                        ArrayAdapter<CharSequence> knl_mandals=
                                ArrayAdapter.createFromResource(MainActivity.this, R.array.Kurnool_mandals, simple_spinner_item);

                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });




        submit.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View view) {


                final String name = et.getText().toString();
                final int num = Integer.parseInt(ph.getText().toString());


                if (r1.isChecked()==true){
                    gender = r1.getText().toString();

                }
                if (r2.isChecked()){
                    gender= r2.getText().toString();

                }
                StringBuilder builder = new StringBuilder();

                if(java.isChecked()){
                    builder.append(java.getText().toString()+ "\n");
                }
                if(python.isChecked()){
                    builder.append(python.getText().toString() + "\n");
                }
                if(android.isChecked()){
                    builder.append(android.getText().toString() + "\n");
                }



                String selecteddistrict = sp_district.getSelectedItem().toString();
                String selectedmandal = sp_mandal.getSelectedItem().toString();


                tv.setText(name + "\n" + num + "\n" + gender + "\n" + builder + "\n" + selecteddistrict + "\n" + selectedmandal);




            }
        });


    }
}