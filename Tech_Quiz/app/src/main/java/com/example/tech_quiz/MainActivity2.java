package com.example.tech_quiz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity2 extends AppCompatActivity {
//     Button python;
//     Button java;
//     Button cpulse;
//     Button php;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
    }
    public void python_quiz(View view){
        Toast.makeText(this, "Welcome to Python quiz", Toast.LENGTH_SHORT).show();
        Intent intent=new Intent(this,MainActivity3.class);
        startActivity(intent);
    }
    public void cpulse_quiz(View view){
        Toast.makeText(this, "Welcome to C++ quiz", Toast.LENGTH_SHORT).show();
        Intent intent=new Intent(this,MainActivity5.class);
        startActivity(intent);
    }
    public void java_quiz(View view){
        Toast.makeText(this, "Welcome to Java quiz", Toast.LENGTH_SHORT).show();
        Intent intent=new Intent(this,MainActivity4.class);
        startActivity(intent);
    }
    public void php_quiz(View view){
        Toast.makeText(this, "Welcome to PHP quiz", Toast.LENGTH_SHORT).show();
        Intent intent=new Intent(this,MainActivity6.class);
        startActivity(intent);
    }
}