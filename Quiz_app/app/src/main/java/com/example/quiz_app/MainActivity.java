package com.example.quiz_app;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
           private String[] questions={"JAVA introduce in 1843?","Java ia a person?","JAVA is Created with python ?","JAVA has abstraction class ?","JAVA support interface ?"};
           private boolean [] answer={false,false,false,true,true};
           private int index=0;
           private int score=0;
           Button yes;
           Button no;
           TextView textView2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        yes=findViewById(R.id.yes);
        no=findViewById(R.id.no);
        textView2=findViewById(R.id.textView2);
        textView2.setText(questions[index]);
        yes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (index<=questions.length-1)
                {
                    if (answer[index]==true){
                        score++;
                    }
                    index++;
                    if (index<=questions.length-1)
                    {
                            textView2.setText(questions[index]);
                    }
                    else {
                        Toast.makeText(MainActivity.this, "Your score is:"+score, Toast.LENGTH_SHORT).show();
                    }
                }
                else
                {
                    Toast.makeText(MainActivity.this, "You need to restart your app", Toast.LENGTH_SHORT).show();
                }
                }
        });

        no.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (index<=questions.length-1)
                {
                    if (answer[index]==false){
                        score++;
                    }
                    index++;
                    if (index<=questions.length-1)
                    {
                        textView2.setText(questions[index]);
                    }
                    else {
                        Toast.makeText(MainActivity.this, "Your score is:"+score, Toast.LENGTH_SHORT).show();
                    }
                }
                else{
                    Toast.makeText(MainActivity.this, "You need to restart your app", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}