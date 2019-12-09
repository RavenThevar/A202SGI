package com.example.ewallet;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Services extends AppCompatActivity
{
    Button sHome, sAstro, sUnifi, sTNB;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_services);

        Bundle bundle = getIntent().getExtras();
        final String email = bundle.getString("email");

        sHome = findViewById(R.id.sHome);
        sHome.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent intent = new Intent(Services.this, Home.class);
                intent.putExtra("email", email);
                startActivity(intent);
            }
        });

        sAstro = findViewById(R.id.sAstro);
        sAstro.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent intent = new Intent(Services.this, serviceastro.class);
                intent.putExtra("email", email);
                startActivity(intent);
            }
        });

        sUnifi = findViewById(R.id.sUnifi);
        sUnifi.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent intent = new Intent(Services.this, serviceunifi.class);
                intent.putExtra("email", email);
                startActivity(intent);
            }
        });

        sTNB = findViewById(R.id.sTNB);
        sTNB.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent intent = new Intent(Services.this, servicetnb.class);
                intent.putExtra("email", email);
                startActivity(intent);
            }
        });
    }
}
