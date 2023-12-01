package com.example.learning_app;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class CourseAdapter extends RecyclerView.Adapter<CourseAdapter.ViewHolder> {

    private List<Course2> courses;

    public CourseAdapter(List<Course2> courses) {
        this.courses = courses;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_course, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Course2 course = courses.get(position);
        holder.courseNameTextView.setText(course.getCourseName());
        holder.TopicNameTextView.setText(course.getTopicName());
        holder.TopicDescriptionTextView.setText(course.getTopicDescription());
    }

    @Override
    public int getItemCount() {
        return courses.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView courseNameTextView;
        TextView TopicNameTextView;
        TextView TopicDescriptionTextView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            courseNameTextView = itemView.findViewById(R.id.courseNameTextView);
            TopicNameTextView = itemView.findViewById(R.id.TopicNameTextView);
            TopicDescriptionTextView = itemView.findViewById(R.id.TopicDesscriptionTextView);
        }
    }
}
