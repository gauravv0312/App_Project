package com.example.application;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;


public class register extends AppCompatActivity {
    
        public static final String TAG="TAG";
    EditText email,password,name,phone;
    Button button;
    ProgressBar progressBar;
    FirebaseAuth fAuth;
    FirebaseFirestore fStore;
    String userID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        email=findViewById(R.id.email);
        password=findViewById(R.id.password);
        button=findViewById(R.id.button);
        name=findViewById(R.id.name);
        phone=findViewById(R.id.phone);
        progressBar=findViewById(R.id.progressBar);
        fAuth=FirebaseAuth.getInstance();
        fStore=FirebaseFirestore.getInstance();
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Email=email.getText().toString().trim();
                String Password=password.getText().toString().trim();
                String Name=name.getText().toString();
                String Phone=phone.getText().toString();
                if (TextUtils.isEmpty(Email)){
                    email.setError("Email is required");
                    return;
                }
                if (TextUtils.isEmpty(Password)){
                    password.setError("Password is required");
                    return;
                }
                if(Password.length()<6)
                {
                    password.setError("Password must be greater or equal to 6 character");
                    return;
                }
                progressBar.setVisibility(View.VISIBLE);

//                Register the user in fire base

                fAuth.createUserWithEmailAndPassword(Email,Password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            Toast.makeText(register.this, "User Created.", Toast.LENGTH_SHORT).show();
                            userID=fAuth.getCurrentUser().getUid();
                            DocumentReference documentReference=fStore.collection("User").document(userID);
                            Map<String,Object> User= new HashMap<>();
                            User.put("fname:",Name);
                            User.put("email",Email);
                            User.put("phone",Phone);
                            documentReference.set(User).addOnSuccessListener(new OnSuccessListener<Void>() {
                                @Override
                                public void onSuccess(Void aVoid) {
                                    Log.d(TAG,"onSuccess: user profile is created for"+ userID);
                                }
                            });
                            startActivity(new Intent(getApplicationContext(),MainActivity.class));
                            }
                        else{
                            Toast.makeText(register.this, "Error !"+task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                            progressBar.setVisibility(View.GONE);
                        }
}
                });

            }
        });
    }
}
