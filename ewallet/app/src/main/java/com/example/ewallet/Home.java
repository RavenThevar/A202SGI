package com.example.ewallet;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toolbar;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class Home extends AppCompatActivity
{
    TextView DisplayName;
    TextView DisplayEmail;
    Button Services, Topup, Card, Transaction, Logout;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        Bundle bundle = getIntent().getExtras();
        final String email = bundle.getString("email");

        DisplayEmail = findViewById(R.id.DisplayEmail);
        DisplayEmail.setText(email);

        Services = findViewById(R.id.Services);
        Services.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                //startActivity(new Intent(getApplicationContext(), Services.class));
                Intent intent = new Intent(Home.this, Services.class);
                intent.putExtra("email", email);
                startActivity(intent);
            }
        });

        Topup = findViewById(R.id.Topup);
        Topup.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                //startActivity(new Intent(getApplicationContext(), Services.class));
                Intent intent = new Intent(Home.this, Topup.class);
                intent.putExtra("email", email);
                startActivity(intent);
            }
        });

        Card = findViewById(R.id.Card);
        Card.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                //startActivity(new Intent(getApplicationContext(), Services.class));
                Intent intent = new Intent(Home.this, Card.class);
                intent.putExtra("email", email);
                startActivity(intent);
            }
        });

        Transaction = findViewById(R.id.Transaction);
        Transaction.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                //startActivity(new Intent(getApplicationContext(), Services.class));
                Intent intent = new Intent(Home.this, Transaction.class);
                intent.putExtra("email", email);
                startActivity(intent);
            }
        });


        Logout = findViewById(R.id.Logout);
        Logout.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                FirebaseAuth.getInstance().signOut();
                startActivity(new Intent(getApplicationContext(), Login.class));
                finish();
            }
        });

    }
}