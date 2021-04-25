package com.example.tech_quiz;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity3 extends AppCompatActivity {
    private String[] python_question={" 1.Python is an interpreted language ?","2.To execute Python statements, the statements must be entered into a file ?","3.Python's print statement writes items to the screen ?","4.Function int retrieves an integer from a program user ?","5.Tuples are immutable data types; lists are mutable data types ?"};
    private boolean[] python_answer={true,false,true,false,true};
    private int index=0;
    private int score=0;
    Button yes;
    Button no;
    TextView textview3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        yes=findViewById(R.id.yes);
        no=findViewById(R.id.no);
        textview3=findViewById(R.id.textview3);
        textview3.setText(python_question[index]);
        yes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(index<=python_question.length-1)
                {
                    if (python_answer[index]=true)
                    {
                        score++;
                    }
                    index++;
                    if (index<=python_question.length-1)
                    {
                        textview3.setText(python_question[index]);
                    }
                    else{
                        Toast.makeText(MainActivity3.this, "Your score is:"+score, Toast.LENGTH_SHORT).show();
                    }
                }
                else
                {
                    Toast.makeText(MainActivity3.this, "You need to restart your app", Toast.LENGTH_SHORT).show();
                }
            }
        });
        no.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(index<=python_question.length-1)
                {
                    if (python_answer[index]=false)
                    {
                        score++;
                    }
                    index++;
                    if (index<=python_question.length-1)
                    {
                        textview3.setText(python_question[index]);
                    }
                    else{
                        Toast.makeText(MainActivity3.this, "Your score is:"+score, Toast.LENGTH_SHORT).show();
                    }
                }
                else
                {
                    Toast.makeText(MainActivity3.this, "You need to restart your app", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}