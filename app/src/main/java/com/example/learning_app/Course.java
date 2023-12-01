package com.example.learning_app;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Course extends AppCompatActivity {

    private EditText courseNameEditText, topicNameEditText, topicDescriptionEditText;
    private Button addCourseButton, addTopicButton;
    private FirebaseDataManager firebaseDataManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_course);

        courseNameEditText = findViewById(R.id.editTextCourseName);
        topicNameEditText = findViewById(R.id.editTextTopicName);
        topicDescriptionEditText = findViewById(R.id.editTextTopicDescription);
        addCourseButton = findViewById(R.id.buttonAddCourse);
//        addTopicButton = findViewById(R.id.buttonAddTopic);
        Button back=findViewById(R.id.clogout);
        firebaseDataManager = new FirebaseDataManager();

        addCourseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addCourse();
            }
        });

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(Course.this, "Logged Out!", Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(getApplicationContext(),MainActivity2.class);
                startActivity(intent);
                finishAffinity();
            }
        });
//        addTopicButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                addTopic();
//            }
//        });
    }

    private void addCourse() {
        String courseName = courseNameEditText.getText().toString().trim();
        String topicName = topicNameEditText.getText().toString().trim();
        String topicDescription = topicDescriptionEditText.getText().toString().trim();
        if (!courseName.isEmpty()&& !topicName.isEmpty() && !topicDescription.isEmpty()) {
            firebaseDataManager.addCourse(courseName,topicName, topicDescription);

            Toast.makeText(Course.this, "Course Added successfully", Toast.LENGTH_SHORT).show();

        }
    }

//    private void addTopic() {
//
//        String courseId = "LyYzkpO4L3Aabchb9YMI"; // Get the courseId from somewhere, e.g., from the selected course
//        String topicName = topicNameEditText.getText().toString().trim();
//        String topicDescription = topicDescriptionEditText.getText().toString().trim();
//
//        if (!courseId.isEmpty() && !topicName.isEmpty() && !topicDescription.isEmpty()) {
//            firebaseDataManager.addTopic(courseId, topicName, topicDescription);
//        }
//    }
}
