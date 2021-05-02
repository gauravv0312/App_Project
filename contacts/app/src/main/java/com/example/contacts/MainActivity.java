package com.example.contacts;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.provider.ContactsContract;

public class MainActivity extends AppCompatActivity {
    Contact o1=new Contact(1,"8854082108","gautam");
    Contact o2=new Contact(2,"9996629014","gauarv");
    Contact o3=new Contact(3,"9996629014","gauarv");
    Contact o4=new Contact(4,"9996629014","gauarv");
    Contact o5=new Contact(5,"9996629014","gauarv");
    Contact o6=new Contact(6,"9996629014","gauarv");
    Contact o7=new Contact(7,"9996629014","gauarv");
    Contact o8=new Contact(8,"9996629014","gauarv");
    Contact o9=new Contact(9,"9996629014","gauarv");
    Contact o10=new Contact(10,"9996629014","gauarv");
    Contact [] contacts={o1,o2,o3,o4,o5,o6,o7,o8,o9,o10};
    RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView=findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        CustomAdapter ad=new CustomAdapter(contacts);
        recyclerView.setAdapter(ad);
        recyclerView.addItemDecoration(new DividerItemDecoration(this,DividerItemDecoration.VERTICAL));
    }
}