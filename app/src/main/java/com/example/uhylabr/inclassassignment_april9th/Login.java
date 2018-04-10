package com.example.uhylabr.inclassassignment_april9th;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Login extends AppCompatActivity {

    private EditText usernameEditText;
    private EditText passwordEditText;
    private String username;
    private String password;
    private FirebaseAuth mAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        usernameEditText = (EditText) findViewById(R.id.username);
        passwordEditText = (EditText) findViewById(R.id.password);
        mAuth = FirebaseAuth.getInstance();
    }

    public void login (View view){
        username = usernameEditText.getText().toString();
        password = passwordEditText.getText().toString();

        mAuth.signInWithEmailAndPassword(username, password).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (!task.isSuccessful()) {
                    // Sign in success, update UI with the signed-in user's information
                    Toast.makeText(Login.this, task.getException().toString(), Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(Login.this, "Login Successful!",
                            Toast.LENGTH_SHORT).show();
                    finish();

            }
        }
        });}


    public void signUp (View view){
        username = usernameEditText.getText().toString();
        password = passwordEditText.getText().toString();

        mAuth.createUserWithEmailAndPassword(username, password).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (!task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            Toast.makeText(Login.this, task.getException().toString(), Toast.LENGTH_SHORT).show();
                        } else {
                            Toast.makeText(Login.this, "Signed Up Successful!",
                                    Toast.LENGTH_SHORT).show();
                            finish();

                        }

                    }
});}}
