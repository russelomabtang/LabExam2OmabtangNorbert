package com.omabtang.labexam2omabtangnorbert;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class MainActivity extends AppCompatActivity {
    CheckBox checkBox;
    CheckBox checkBox2;
    CheckBox checkBox3;
    CheckBox checkBox4;
    CheckBox checkBox5;
    CheckBox checkBox6;
    CheckBox checkBox7;
    CheckBox checkBox8;
    EditText c1;
    Button button1;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        checkBox = findViewById(R.id.checkBox);
        checkBox2 = findViewById(R.id.checkBox2);
        checkBox3 = findViewById(R.id.checkBox3);
        checkBox4 = findViewById(R.id.checkBox4);
        checkBox5 = findViewById(R.id.checkBox5);
        checkBox6 = findViewById(R.id.checkBox6);
        checkBox7 = findViewById(R.id.checkBox7);
        checkBox8 = findViewById(R.id.checkBox8);
        c1 = findViewById(R.id.editText1);
        button1 = findViewById(R.id.button1);

    }

    public void onNext(View view)
    {
        Intent intent = new Intent(this, SecondActivity.class);
        startActivity(intent);
    }

    public void onSave(View v)
    {
        String subjectString = "";

        if(checkBox.isChecked())
        {
            String text=checkBox.getText().toString();
            subjectString = subjectString + "\n" + text + "\n";
        }
        if(checkBox2.isChecked())
        {
            String text=checkBox2.getText().toString();
            subjectString = subjectString + text + "\n";
        }
        if(checkBox3.isChecked())
        {
            String text=checkBox3.getText().toString();
            subjectString = subjectString + text + "\n";
        }
        if(checkBox4.isChecked())
        {
            String text=checkBox4.getText().toString();
            subjectString = subjectString + text + "\n";
        }
        if(checkBox5.isChecked())
        {
            String text=checkBox5.getText().toString();
            subjectString = subjectString + text + "\n";
        }
        if(checkBox6.isChecked())
        {
            String text=checkBox6.getText().toString();
            subjectString = subjectString + text + "\n";
        }
        if(checkBox7.isChecked())
        {
            String text=checkBox7.getText().toString();
            subjectString = subjectString + text + "\n";
        }
        if(checkBox8.isChecked())
        {
            String text=checkBox8.getText().toString();
            subjectString = subjectString + text;
        }

        String comment = c1.getText().toString();

        FileOutputStream fos;
        FileOutputStream fos2;
        try {
            fos = openFileOutput("subjects.txt", MODE_PRIVATE);
            OutputStreamWriter out = new OutputStreamWriter(fos);
            out.write(subjectString);
            out.close();
            fos.close();
            fos2 = openFileOutput("comment.txt", MODE_PRIVATE);
            OutputStreamWriter out2 = new OutputStreamWriter(fos2);
            out2.write(comment);
            out2.close();
            fos2.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Toast.makeText(this, "Data Saved... " , Toast.LENGTH_LONG).show();

    }
}