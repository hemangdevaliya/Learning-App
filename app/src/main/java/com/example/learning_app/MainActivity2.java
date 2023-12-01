package com.example.learning_app;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity2 extends AppCompatActivity {

    private EditText emailEditText, passwordEditText;
    private Button loginButton;

    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        emailEditText = findViewById(R.id.username);
        passwordEditText = findViewById(R.id.password);
        loginButton = findViewById(R.id.loginbtn);

        mAuth = FirebaseAuth.getInstance();

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loginUser();
            }
        });
    }

    private void loginUser() {
        String email = emailEditText.getText().toString().trim();
        String password = passwordEditText.getText().toString().trim();

        if(email.equals("admin@gmail.com") && password.equals("12345678")){
            Intent myIntent = new Intent(MainActivity2.this,Course.class);



            startActivity(myIntent);
        }

        mAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, task -> {
                    if (task.isSuccessful()) {
                        // Login successful, go to the new activity
                        FirebaseUser user = mAuth.getCurrentUser();
                        if (user != null) {
                            // Here, you can start the new activity
                            Toast.makeText(MainActivity2.this, "Login Successful", Toast.LENGTH_SHORT).show();
                            Intent myIntent = new Intent(MainActivity2.this,MainActivity3.class);



                            startActivity(myIntent);
//                            startActivity(new Intent(MainActivity2.this, MainActivity3.class));
                            finish();
                        }
                    } else {
                        Toast.makeText(MainActivity2.this, "Login Failed.", Toast.LENGTH_SHORT).show();

                        // If login fails, display a message to the user.
                        // You can handle specific error cases if needed.
                        // For example:
                        // if (task.getException() instanceof FirebaseAuthInvalidCredentialsException) {
                        //     // Handle invalid credentials
                        // }
                    }
                });
    }
}
