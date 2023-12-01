package com.example.learning_app;

import androidx.annotation.NonNull;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;

public class FirebaseDataManager {

    private FirebaseFirestore db;

    public FirebaseDataManager() {
        // Initialize Firestore
        db = FirebaseFirestore.getInstance();
    }

    public void addCourse(String courseName,String topicName, String topicDescription) {
        // Create a new course document with a generated ID
        db.collection("courses")
                .add(new Course2(courseName,topicName,topicDescription))
                .addOnCompleteListener(new OnCompleteListener<DocumentReference>() {
                    @Override
                    public void onComplete(@NonNull Task<DocumentReference> task) {
                        if (task.isSuccessful()) {
                            // Log success if needed
                            System.out.println("Added");
                        } else {
                            // Handle the error
                            System.out.println("Error");
                        }
                    }
                });
    }

//    public void addTopic(String courseId, String topicName, String topicDescription) {
//        // Create a new topic document with a generated ID
//        db.collection("courses").document(courseId)
//                .collection("topics")
//                .add(new Topic2(topicName, topicDescription))
//                .addOnCompleteListener(new OnCompleteListener<DocumentReference>() {
//                    @Override
//                    public void onComplete(@NonNull Task<DocumentReference> task) {
//                        if (task.isSuccessful()) {
//                            String courseId = task.getResult().getDocuments().get(0).getId();
//
//                            // Log success if needed
//                            System.out.println("Course Added");
//                        } else {
//                            // Handle the error
//                            System.out.println("error");
//                        }
//                    }
//                });
//    }

//public void addTopic(String courseName, String topicName, String topicDescription) {
//    // Query to find the course document based on the course name
//    db.collection("courses")
//            .whereEqualTo("courseName", courseName)
//            .get()
//            .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
//                @Override
//                public void onComplete(@NonNull Task<QuerySnapshot> task) {
//                    if (task.isSuccessful() && !task.getResult().isEmpty()) {
//                        // Assuming there is only one course with the given name
//                        String courseId = task.getResult().getDocuments().get(0).getId();
//                        FirebaseDataManager firebaseDataManager = null;
//                        firebaseDataManager.addTopic(courseId, topicName, topicDescription);
//                    } else {
//                        // Handle the error or inform the user that the course was not found
//                    }
//                }
//            });
//}
}