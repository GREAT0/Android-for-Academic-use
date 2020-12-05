package com.great.moseye;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.view.menu.MenuAdapter;
import androidx.appcompat.widget.Toolbar;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.List;

import static com.great.moseye.CourseActivity.Selected_Course;

public class CourseDetails extends AppCompatActivity {

    private ListView listView;
    private Toolbar toolbar;
    private static String[] COMMON_CORE;
    private static String[] ELECTIVE;
    private static String[] INFORMATION;
    private static String[] ELECTRONIC_SCIENCE;
    private static String[] MECHANICAL;
    private static String[] ELECTRICAL;
    private static String[] PHYSICS;
    private static String[] OPTICAL;
    private static String[] INSTRUMENT;
    private static String[] CONTROL;
    private static String[] Computer;
    private static String[] SOFTWARE;
    private static String[] MATHEMATICS;
    private static String[] BIOMEDICAL;
    private static String[] MANAGEMENT_SCIENCE;
    private static String[] PUBLIC_MANAGEMENT;
   /* private String[] PreferredCourse;*/
    private String[] PreferredSchkl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_course_details);

        setupUIviews();
        initToolbar();
        setupListView();
    }

    private void setupUIviews() {
        listView = (ListView) findViewById(R.id.lvCourseD);
        toolbar = findViewById(R.id.ToolbarCourseD);
    }

    private void initToolbar() {
        toolbar = (Toolbar) findViewById(R.id.ToolbarCourseD);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(CourseActivity.sharedPreferences.getString(Selected_Course, null));
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    private void setupListView() {
        COMMON_CORE = getResources().getStringArray(R.array.COMMON_CORE);
        ELECTIVE = getResources().getStringArray(R.array.ELECTIVE);
        INFORMATION = getResources().getStringArray(R.array.INFORMATION);
        ELECTRONIC_SCIENCE = getResources().getStringArray(R.array.ELECTRONIC);
        MECHANICAL = getResources().getStringArray(R.array.MECHANICAL);
        ELECTRICAL = getResources().getStringArray(R.array.ELECTRICAL);
        PHYSICS = getResources().getStringArray(R.array.PHYSICS);
        OPTICAL = getResources().getStringArray(R.array.OPTICAL);
        INSTRUMENT = getResources().getStringArray(R.array.INSTRUMENT);
        CONTROL = getResources().getStringArray(R.array.CONTROL);
        Computer = getResources().getStringArray(R.array.COMPUTER);
        SOFTWARE = getResources().getStringArray(R.array.SOFTWARE);
        MATHEMATICS = getResources().getStringArray(R.array.MATHEMATICS);
        BIOMEDICAL = getResources().getStringArray(R.array.BIOMEDICAL);
        MANAGEMENT_SCIENCE = getResources().getStringArray(R.array.MANAGEMENT);
        PUBLIC_MANAGEMENT = getResources().getStringArray(R.array.PUBLIC_MANAGEMENT);

        String Selected_Course = CourseActivity.sharedPreferences.getString(CourseActivity.Selected_Course, null);
        Log.d("COURSE RECEIVED",Selected_Course);

        if (Selected_Course.equalsIgnoreCase("COMMON COURSES")) {
            Log.d("COURSE Equals",Selected_Course);
            PreferredSchkl = COMMON_CORE;
        } else if (Selected_Course.equalsIgnoreCase("ELECTIVE COMPETENCE DEVELOPMENT")) {
            PreferredSchkl = ELECTIVE;
        } else if (Selected_Course.equalsIgnoreCase("INFORMATION AND COMMUNICATION ENGINEERING")) {
            PreferredSchkl = INFORMATION;
        } else if (Selected_Course.equalsIgnoreCase("ELECTRONIC SCIENCE AND TECHNOLOGY")) {
            PreferredSchkl = ELECTRONIC_SCIENCE;
        } else if (Selected_Course.equalsIgnoreCase("MECHANICAL ENGINEERING")) {
            PreferredSchkl = MECHANICAL;
        } else if (Selected_Course.equalsIgnoreCase("ELECTRICAL ENGINEERING")) {
            PreferredSchkl = ELECTRICAL;
        } else if (Selected_Course.equalsIgnoreCase("PHYSICS")) {
            PreferredSchkl = PHYSICS;
        } else if (Selected_Course.equalsIgnoreCase("OPTICAL ENGINEERING")) {
            PreferredSchkl = OPTICAL;
        } else if (Selected_Course.equalsIgnoreCase("INSTRUMENT SCIENCE AND TECHNOLOGY")) {
            PreferredSchkl = INSTRUMENT;
        } else if (Selected_Course.equalsIgnoreCase("CONTROL SCIENCE AND ENGINEERING")) {
            PreferredSchkl = CONTROL;
        } else if (Selected_Course.equalsIgnoreCase("COMPUTER SCIENCE AND TECHNOLOGY")) {
            PreferredSchkl = Computer;
        } else if (Selected_Course.equalsIgnoreCase("SOFTWARE ENGINEERING")) {
            PreferredSchkl = SOFTWARE;
        } else if (Selected_Course.equalsIgnoreCase("MATHEMATICS COURSES")) {
            PreferredSchkl = MATHEMATICS;
        } else if (Selected_Course.equalsIgnoreCase("BIOMEDICAL ENGINEERING")) {
            PreferredSchkl = BIOMEDICAL;
        } else if (Selected_Course.equalsIgnoreCase("MANAGEMENT SCIENCE AND ENGINEERING")) {
            PreferredSchkl = MANAGEMENT_SCIENCE;
        } else {
            PreferredSchkl = PUBLIC_MANAGEMENT;
        }
        MenuAdapter menuAdapter = new MenuAdapter(this,PreferredSchkl);
        listView.setAdapter(menuAdapter);

    }

    public class MenuAdapter extends BaseAdapter{
        private Context mContext;
        private LayoutInflater layoutInflater;
        private TextView courses_list_TextView;
        private String[] PreferredSchkl;

        public MenuAdapter(Context Context, String[] preferredSchkl) {
            mContext = Context;
            PreferredSchkl = preferredSchkl;
            layoutInflater = LayoutInflater.from(Context);
        }
        @Override
        public int getCount() {
            return PreferredSchkl.length;
        }

        @Override
        public Object getItem(int position) {
            return PreferredSchkl[position];
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            if (convertView == null) {
                convertView = layoutInflater.inflate(R.layout.course_detail_single_item,parent,false);
            }
            courses_list_TextView = (TextView) convertView.findViewById(R.id.tvCourse);
            courses_list_TextView.setText(PreferredSchkl[position]);
            return convertView;
        }
    }
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home :{
                onBackPressed();
            }
        }
        return super.onOptionsItemSelected(item);
    }
}
