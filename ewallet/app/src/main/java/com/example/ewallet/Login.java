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

public class Login extends AppCompatActivity
{
    EditText lEmail, lPassword;
    TextView lDesc;
    Button lLogin2;
    ProgressBar lProgress;
    FirebaseAuth fAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        lEmail = findViewById(R.id.lEmail);
        lPassword = findViewById(R.id.lPassword);
        lDesc = findViewById(R.id.lDesc);
        lLogin2 = findViewById(R.id.lLogin2);
        lProgress = findViewById(R.id.lProgress);
        fAuth = FirebaseAuth.getInstance();

        lLogin2.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                final String email = lEmail.getText().toString().trim();
                String password = lPassword.getText().toString().trim();

                if (TextUtils.isEmpty(email))
                {
                    lEmail.setError("An Email is required.");
                    return;
                }

                if (TextUtils.isEmpty(password))
                {
                    lPassword.setError("A Password is required.");
                    return;
                }

                if (password.length() < 6)
                {
                    lPassword.setError("Password must be longer than 6 characters");
                    return;
                }

                lProgress.setVisibility(View.VISIBLE);

                // User Authentication

                fAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>()
                {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task)
                    {
                        if(task.isSuccessful())
                        {
                            Toast.makeText(Login.this, "Login is Successful.!", Toast.LENGTH_SHORT).show();
                            //startActivity(new Intent(getApplicationContext(), Home.class));
                            Intent intent = new Intent(Login.this, Home.class);
                            intent.putExtra("email", email);
                            startActivity(intent);
                            lProgress.setVisibility(View.GONE);
                        }

                        else
                        {
                            Toast.makeText(Login.this, "No such user found. Check login details again.!" + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                            lProgress.setVisibility(View.GONE);
                        }
                    }
                });
            }
        });

        lDesc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                startActivity(new Intent(getApplicationContext(), Register.class));
            }
        });
    }
}
