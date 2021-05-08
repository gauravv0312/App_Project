package com.example.recyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    ArrayList<model> datalist;
    FirebaseFirestore fStore;
    CustomAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView=findViewById(R.id.recyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        datalist=new ArrayList<>();
        adapter=new CustomAdapter(this,datalist);
        recyclerView.setAdapter(adapter);
        fStore=FirebaseFirestore.getInstance();

        fStore.collection("User").get()
                .addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
                    @Override
                    public void onSuccess(QuerySnapshot queryDocumentSnapshots) {
                       List<DocumentSnapshot> list=queryDocumentSnapshots.getDocuments();
                       for (DocumentSnapshot d:list)                  // for reading all object and make a single a object(d)
                       {
                           model obj=d.toObject(model.class);    // model ka ek object bnaya and type caste kar dega model class
                           datalist.add(obj);
                       }
//                        updateing the adpater
                            adapter.notifyAll();
                    }
                });
    }
}
