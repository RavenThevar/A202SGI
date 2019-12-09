package com.example.ewallet;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Register extends AppCompatActivity
{
    EditText rEmail, rName, rPassword;
    TextView rTitle, rRegistration, rDesc;
    Button rRegister;
    ProgressBar rProgress;
    FirebaseAuth fAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        rName = findViewById(R.id.rName);
        rEmail = findViewById(R.id.rEmail);
        rPassword = findViewById(R.id.rPassword);
        rDesc = findViewById(R.id.rDesc);
        rRegister = findViewById(R.id.rRegister);

        fAuth = FirebaseAuth.getInstance();
        rProgress = findViewById(R.id.rProgress);

        if(fAuth.getCurrentUser() != null)
        {
            startActivity(new Intent(getApplicationContext(), Home.class));
            finish();
        }

        rRegister.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                final String name = rName.getText().toString().trim();
                final String email = rEmail.getText().toString().trim();
                String password = rPassword.getText().toString().trim();

                if (TextUtils.isEmpty(name))
                {
                    rName.setError("Your Name is required.");
                    return;
                }

                if (TextUtils.isEmpty(email))
                {
                    rEmail.setError("An Email is required.");
                    return;
                }

                if (TextUtils.isEmpty(password))
                {
                    rPassword.setError("A Password is required.");
                    return;
                }

                if (password.length() < 6)
                {
                    rPassword.setError("Password must be longer than 6 characters");
                    return;
                }

                rProgress.setVisibility(View.VISIBLE);

                // Registering the user in Firebase

                fAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>()
                {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) 
                    {
                        if(task.isSuccessful())
                        {
                            Toast.makeText(Register.this, "User Created", Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(Register.this, Home.class);
                            intent.putExtra("email", email);
                            startActivity(intent);
                            rProgress.setVisibility(View.GONE);
                        }

                        else
                        {
                            Toast.makeText(Register.this, "An Error had occured" + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                            rProgress.setVisibility(View.GONE);
                        }
                    }
                });
            }
        });

        rDesc.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                startActivity(new Intent(getApplicationContext(), Login.class));
            }
        });
    }
}
