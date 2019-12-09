package com.example.ewallet;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.ewallet.ui.main.PageViewModel;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


public class serviceunifi extends AppCompatActivity
{
    Button sHome, sPay;
    EditText sAccount, sAmount;
    DatabaseReference reff;
    Payment payment;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_serviceunifi);

        Bundle bundle = getIntent().getExtras();
        final String email = bundle.getString("email");

        reff = FirebaseDatabase.getInstance().getReference().child("payment");

        payment = new Payment();

        sHome = findViewById(R.id.sHome);
        sHome.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent intent = new Intent(serviceunifi.this, Services.class);
                intent.putExtra("email", email);
                startActivity(intent);

            }
        });

        sPay = findViewById(R.id.sPay);
        sPay.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                //final int account = Integer.parseInt(sAccount.getText().toString().trim());
                sAccount = findViewById(R.id.sAccount);
                sAmount = findViewById(R.id.sAmount);
                String account = sAccount.getText().toString().trim();
                String amount = sAmount.getText().toString().trim();

                payment.setAccount(account);
                payment.setAmount(amount);
                payment.setEmail(email);
                payment.setType("Unifi");

                reff.push().setValue(payment);
                Toast.makeText(serviceunifi.this, "Payment of RM " + amount + " to Unifi is successful.!", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(serviceunifi.this, Services.class);
                intent.putExtra("email", email);
                startActivity(intent);
            }
        });
    }
}
