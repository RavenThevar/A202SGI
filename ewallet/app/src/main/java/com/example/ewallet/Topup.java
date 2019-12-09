package com.example.ewallet;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Topup extends AppCompatActivity
{
    Button tHome, tPay;
    EditText tAmount;
    TextView DisplayNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_topup);

        Bundle bundle = getIntent().getExtras();
        final String email = bundle.getString("email");

        tHome = findViewById(R.id.tHome);
        tHome.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent intent = new Intent(Topup.this, Home.class);
                intent.putExtra("email", email);
                startActivity(intent);
            }
        });


        tPay = findViewById(R.id.tPay);
        tPay.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                tAmount = findViewById(R.id.tAmount);
                int amount = Integer.parseInt(tAmount.getText().toString().trim());

                DisplayNumber = findViewById(R.id.DisplayNumber);
                DisplayNumber.setText("RM: " + amount);
                Toast.makeText(Topup.this, "Top Up of " + amount + " is successful.!", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
