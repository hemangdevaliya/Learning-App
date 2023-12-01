package com.example.learning_app;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.os.Handler;
import android.widget.Toast;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {

    private EditText nameEditText, emailEditText, passwordEditText, mobileEditText;
    private Button registerButton,loginButton;

    private FirebaseAuth mAuth;
    private DatabaseReference mDatabase;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        // Simulate a delay (e.g., network call) and hide the loader when done
        nameEditText = findViewById(R.id.editTextName);
        emailEditText = findViewById(R.id.editTextEmail);
        passwordEditText = findViewById(R.id.editTextPassword);
        mobileEditText = findViewById(R.id.editTextMobile);
        registerButton = findViewById(R.id.btnRegister);
        loginButton = findViewById(R.id.gotologin);
        mAuth = FirebaseAuth.getInstance();
        mDatabase = FirebaseDatabase.getInstance().getReference().child("Users");

        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                registerUser();
            }
        });
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(MainActivity.this,MainActivity2.class);



                startActivity(myIntent);
            }
        });

    }



    private void registerUser() {
        final String name = nameEditText.getText().toString().trim();
        final String email = emailEditText.getText().toString().trim();
        final String password = passwordEditText.getText().toString().trim();
        final String mobile = mobileEditText.getText().toString().trim();

        mAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, task -> {
                    if (task.isSuccessful()) {
                        // Successfully registered user, now store additional information in the database
                        String userId = mAuth.getCurrentUser().getUid();
                        DatabaseReference currentUserDb = mDatabase.child(userId);
                        currentUserDb.child("name").setValue(name);
                        currentUserDb.child("email").setValue(email);
                        currentUserDb.child("mobile").setValue(mobile);

                        // You can add more fields as needed

                        // Redirect to the main activity or perform any other actions
                        // For example:
                        Toast.makeText(MainActivity.this, "Registration Successful", Toast.LENGTH_SHORT).show();

                        Intent myIntent = new Intent(MainActivity.this,MainActivity2.class);



                        startActivity(myIntent);
                             finish();
                    } else {
                        // If registration fails, display a message to the user.
                        // You can handle specific error cases if needed.
                        // For example:
                        // if (task.getException() instanceof FirebaseAuthUserCollisionException) {
                        //     // Handle account collision
                        // }
                    }
                });
    }
}
