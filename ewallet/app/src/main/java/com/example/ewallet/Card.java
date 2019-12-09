package com.example.ewallet;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Card extends AppCompatActivity {

    TextView viewEmail;
    Button tHome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_card);

        Bundle bundle = getIntent().getExtras();
        final String email = bundle.getString("email");

        viewEmail = findViewById(R.id.viewEmail);
        viewEmail.setText(email);

        tHome = findViewById(R.id.tHome);
        tHome.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                //startActivity(new Intent(getApplicationContext(), Services.class));
                Intent intent = new Intent(Card.this, Home.class);
                intent.putExtra("email", email);
                startActivity(intent);
            }
        });
    }
}
