package com.great.moseye;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.view.menu.MenuAdapter;
import androidx.appcompat.widget.Toolbar;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class CourseActivity extends AppCompatActivity{


    private Toolbar toolbar;
    private ListView listView;
    public static SharedPreferences sharedPreferences;
    public static String Selected_Course;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_course);

        setupUIviews();
        initToolbar();

        setupListView();


    }

    private void setupUIviews() {
        listView = (ListView) findViewById(R.id.lvCourse);
        toolbar = (Toolbar) findViewById(R.id.Toolbarcourse);
        sharedPreferences = getSharedPreferences("THE_COURSES", MODE_PRIVATE);

    }

    private void initToolbar() {
        toolbar = (Toolbar) findViewById(R.id.Toolbarcourse);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("MAJOR");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }


   private void setupListView () {
       final String[] schoolcourses = getResources().getStringArray(R.array.SCHOOL);
       CourseAdapter adapter = new CourseAdapter(this, R.layout.activity_course_single_item, schoolcourses);
       listView.setAdapter(adapter);



       listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
           @Override
           public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
               switch (position) {
                   case 0: {
                       startActivity(new Intent(getApplicationContext(), CourseDetails.class));
                       sharedPreferences.edit().putString(Selected_Course, "COMMON COURSES").apply();
                       break;
                   }
                   case 1: {
                       startActivity(new Intent(getApplicationContext(), CourseDetails.class));
                       sharedPreferences.edit().putString(Selected_Course, "ELECTIVE COMPETENCE DEVELOPMENT").apply();
                       break;
                   }
                   case 2: {
                       startActivity(new Intent(getApplicationContext(), CourseDetails.class));
                       sharedPreferences.edit().putString(Selected_Course, "INFORMATION AND COMMUNICATION ENGINEERING").apply();
                       break;
                   }
                   case 3: {
                       startActivity(new Intent(getApplicationContext(), CourseDetails.class));
                       sharedPreferences.edit().putString(Selected_Course, "ELECTRONIC SCIENCE AND TECHNOLOGY").apply();
                       break;
                   }
                   case 4: {
                       startActivity(new Intent(getApplicationContext(), CourseDetails.class));
                       sharedPreferences.edit().putString(Selected_Course, "MECHANICAL ENGINEERING").apply();
                       break;
                   }
                   case 5: {
                       startActivity(new Intent(getApplicationContext(), CourseDetails.class));
                       sharedPreferences.edit().putString(Selected_Course, "ELECTRICAL ENGINEERING").apply();
                       break;
                   }
                   case 6: {
                       startActivity(new Intent(getApplicationContext(), CourseDetails.class));
                       sharedPreferences.edit().putString(Selected_Course, "PHYSICS").apply();
                       break;
                   }
                   case 7: {
                       startActivity(new Intent(getApplicationContext(), CourseDetails.class));
                       sharedPreferences.edit().putString(Selected_Course, "OPTICAL ENGINEERING").apply();
                       break;
                   }
                   case 8: {
                       startActivity(new Intent(getApplicationContext(), CourseDetails.class));
                       sharedPreferences.edit().putString(Selected_Course, "INSTRUMENT SCIENCE AND TECHNOLOGY").apply();
                       break;
                   }
                   case 9: {
                       startActivity(new Intent(getApplicationContext(), CourseDetails.class));
                       sharedPreferences.edit().putString(Selected_Course, "CONTROL SCIENCE AND ENGINEERING").apply();
                       break;
                   }
                   case 10: {
                       startActivity(new Intent(getApplicationContext(), CourseDetails.class));
                       sharedPreferences.edit().putString(Selected_Course, "COMPUTER SCIENCE AND TECHNOLOGY").apply();
                       break;
                   }
                   case 11: {
                       startActivity(new Intent(getApplicationContext(), CourseDetails.class));
                       sharedPreferences.edit().putString(Selected_Course, "SOFTWARE ENGINEERING").apply();
                       break;
                   }
                   case 12: {
                       startActivity(new Intent(getApplicationContext(), CourseDetails.class));
                       sharedPreferences.edit().putString(Selected_Course, "MATHEMATICS COURSES").apply();
                       break;
                   }
                   case 13: {
                       startActivity(new Intent(getApplicationContext(), CourseDetails.class));
                       sharedPreferences.edit().putString(Selected_Course, "BIOMEDICAL ENGINEERING").apply();
                       break;
                   }
                   case 14: {
                       startActivity(new Intent(getApplicationContext(), CourseDetails.class));
                       sharedPreferences.edit().putString(Selected_Course, "MANAGEMENT SCIENCE AND ENGINEERING").apply();
                       break;
                   }
                   case 15: {
                       startActivity(new Intent(getApplicationContext(), CourseDetails.class));
                       sharedPreferences.edit().putString(Selected_Course, "PUBLIC MANAGEMENT").apply();
                       break;
                   }
                   default:
                       break;
               }
           }
       });

   }

   public class CourseAdapter extends ArrayAdapter {

       private int resource;
       private LayoutInflater layoutInflater;
       private String[] SCHOOL ;


       public CourseAdapter(Context context, int resource, String[] objects) {
           super(context, resource, objects);
           this.resource = resource;
           this.SCHOOL = objects;
           layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
       }

       @Override
       public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
           ViewHolder holder;
           if (convertView == null) {
               convertView = layoutInflater.inflate(R.layout.activity_course_single_item,parent,false);

           }
           holder = new ViewHolder();
           holder.Tvcor = (TextView) convertView.findViewById(R.id.Tvcor);
           convertView.setTag(holder);

           holder.Tvcor.setText(SCHOOL[position]);
           holder = (ViewHolder) convertView.getTag();

               if (SCHOOL[position].equalsIgnoreCase("COMMON_CORE")) {
                   Log.d("Click","Common Courses");
               } else if (SCHOOL[position].equalsIgnoreCase("ELECTIVE_COMPETENCE")) {
               } else if (SCHOOL[position].equalsIgnoreCase("INFORMATION_AND_COMMUNICATION")) {
               } else if (SCHOOL[position].equalsIgnoreCase("ELECTRONIC_SCIENCE")) {
               } else if (SCHOOL[position].equalsIgnoreCase("MECHANICAL")) {
               } else if (SCHOOL[position].equalsIgnoreCase("ELECTRICAL")) {
               } else if (SCHOOL[position].equalsIgnoreCase("PHYSICS")) {
               } else if (SCHOOL[position].equalsIgnoreCase("OPTICAL")) {
               } else if (SCHOOL[position].equalsIgnoreCase("INSTRUMENT_SCIENCE")) {
               } else if (SCHOOL[position].equalsIgnoreCase("CONTROL_SCIENCE")) {
               } else if (SCHOOL[position].equalsIgnoreCase("COMPUTER_SCIENCE")) {
               } else if (SCHOOL[position].equalsIgnoreCase("SOFTWARE")) {
               } else if (SCHOOL[position].equalsIgnoreCase("MATHEMATICS")) {
               } else if (SCHOOL[position].equalsIgnoreCase("BIOMEDICAL")) {
               } else if (SCHOOL[position].equalsIgnoreCase("MANAGEMENT_SCIENCE")) {
               } else if (SCHOOL[position].equalsIgnoreCase("PUBLIC_MANAGEMENT")) {
               }
           return convertView;
       }

       class ViewHolder {
           private TextView Tvcor;
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