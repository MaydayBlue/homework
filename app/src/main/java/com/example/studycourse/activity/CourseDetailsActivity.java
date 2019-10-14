package com.example.studycourse.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.studycourse.MainActivity;
import com.example.studycourse.R;

public class CourseDetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_course_details);

        TextView tv_course_id;
        TextView tv_teacher;
        TextView tv_school;
        TextView tv_date;
        TextView tv_description;

        tv_course_id=(TextView) findViewById(R.id.tv_course_id);
        tv_teacher=(TextView) findViewById(R.id.tv_teacher);
        tv_school=(TextView) findViewById(R.id.tv_school);
        tv_date=(TextView) findViewById(R.id.tv_date);
        tv_description=(TextView) findViewById(R.id.tv_description);

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();

        String course = bundle.getString("courseid");
        String teacher = bundle.getString("teacher");
        String school = bundle.getString("school");
        String date = bundle.getString("date");
        String description = bundle.getString("description");

        tv_course_id.setText(course);
        tv_teacher.setText(teacher);
        tv_school.setText(school);
        tv_date.setText(date);
        tv_description.setText(description);
    }

    public void onReturnClick(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}
