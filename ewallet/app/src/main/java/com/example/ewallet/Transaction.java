package com.example.ewallet;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class Transaction extends AppCompatActivity {
    RecyclerView recyclerView;
    List<Model> main_list;
    RecyclerView.Adapter adapter;

    Button trbutton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transaction);

        Bundle bundle = getIntent().getExtras();
        final String email = bundle.getString("email");

        trbutton = findViewById(R.id.trbutton);
        trbutton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent intent = new Intent(Transaction.this, Home.class);
                intent.putExtra("email", email);
                startActivity(intent);

            }
        });

        main_list = new ArrayList<>();

        recyclerView = findViewById(R.id.recycler);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        main_list.add(new Model("TNB","ABF4234", "RM 23"));
        main_list.add(new Model("Unifi", "BNM34234", "Rm 129"));
        main_list.add(new Model("Astro", "PLOK34234", "RM 79"));
        main_list.add(new Model("Astro", "PLOK34234", "RM 79"));
        main_list.add(new Model("TNB", "ABF4234", "RM 50"));
        main_list.add(new Model("Unifi", "BNM34234", "RM 129"));

        adapter=new CustomeAdapter(main_list, getApplicationContext());
        recyclerView.setAdapter(adapter);
    }

}