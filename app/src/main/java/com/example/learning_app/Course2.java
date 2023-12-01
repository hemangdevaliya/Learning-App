package com.example.learning_app;

// Course.java
public class Course2 {
    private String courseName;
    private String topicName;
    private String topicDescription;
    public Course2() {
        // Default constructor required for calls to DataSnapshot.getValue(Course.class)
    }

    public Course2(String courseName,String topicName, String topicDescription) {
        this.courseName = courseName;
        this.topicName = topicName;
        this.topicDescription = topicDescription;
    }

    public String getCourseName() {
        return courseName;
    }
    public String getTopicName() {
        return topicName;
    }

    public String getTopicDescription() {
        return topicDescription;
    }

}

// Topic.java
