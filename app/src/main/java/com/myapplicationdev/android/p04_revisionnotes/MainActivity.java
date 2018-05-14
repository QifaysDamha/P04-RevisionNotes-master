package com.myapplicationdev.android.p04_revisionnotes;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class MainActivity extends AppCompatActivity {

    EditText editTextNote;
    RadioGroup radioGroupStars;
    RadioButton radio1;
    RadioButton radio2;
    RadioButton radio3;
    RadioButton radio4;
    RadioButton radio5;
    Button buttonInsertNote;
    Button buttonShowList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextNote = (EditText)findViewById(R.id.editTextNote);
        radioGroupStars = (RadioGroup)findViewById(R.id.radioGroupStars);
        radio1 = (RadioButton)findViewById(R.id.radio1);
        radio2 = (RadioButton)findViewById(R.id.radio2);
        radio3 = (RadioButton)findViewById(R.id.radio3);
        radio4 = (RadioButton)findViewById(R.id.radio4);
        radio5 = (RadioButton)findViewById(R.id.radio5);
        buttonInsertNote = (Button)findViewById(R.id.buttonInsertNote);
        buttonShowList = (Button)findViewById(R.id.buttonShowList);

        buttonInsertNote.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DBHelper db = new DBHelper(MainActivity.this);

                if(radio1.isActivated()) {
                    db.insertNote(editTextNote.getText().toString(), 1);
                }else if(radio2.isActivated()){
                    db.insertNote(editTextNote.getText().toString(), 2);
                }else if(radio3.isActivated()){
                    db.insertNote(editTextNote.getText().toString(), 3);
                }else if(radio4.isActivated()){
                    db.insertNote(editTextNote.getText().toString(), 4);
                }else{
                    db.insertNote(editTextNote.getText().toString(), 5);
                }
                db.close();
            }
        });

        buttonShowList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }
}
