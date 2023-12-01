package com.example.learning_app;
import android.os.Bundle;
import androidx.annotation.NonNull;
import android.widget.Button;
import android.widget.Toast;
import android.view.View;
import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;
import java.util.ArrayList;
import java.util.List;


public class MainActivity3 extends AppCompatActivity {

    private RecyclerView recyclerView;
    private CourseAdapter courseAdapter;
    private List<Course2> courses;
//    Button back=findViewById(R.id.logout);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        courses = new ArrayList<>();
        courseAdapter = new CourseAdapter(courses);
        recyclerView.setAdapter(courseAdapter);
        Button back=findViewById(R.id.logout);
        // Load courses from Firestore
        loadCourses();
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(MainActivity3.this, "Logged Out!", Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(getApplicationContext(),MainActivity2.class);
                startActivity(intent);
                finishAffinity();
            }
        });


    }


    private void loadCourses() {
        FirebaseFirestore db = FirebaseFirestore.getInstance();
        db.collection("courses")
                .get()
                .addOnCompleteListener(task -> {
                    if (task.isSuccessful()) {
                        courses.clear();
                        for (QueryDocumentSnapshot document : task.getResult()) {
                            Course2 course = document.toObject(Course2.class);
                            courses.add(course);
                        }
                        courseAdapter.notifyDataSetChanged();
                    } else {
                        // Handle errors
                    }
                });



    }


}
