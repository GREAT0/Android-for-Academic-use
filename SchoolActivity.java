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
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class SchoolActivity extends AppCompatActivity{


    private Toolbar toolbar;
    private ListView listView;
    public static SharedPreferences sharedPreferences;
    public static String Selected_school;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_school);

        setupUIviews();
        initToolbar();

        setupListView();


    }

    private void setupUIviews() {
        listView = (ListView) findViewById(R.id.lvskl);
        toolbar = (Toolbar) findViewById(R.id.Toolbarskl);
        sharedPreferences = getSharedPreferences("THE_SCHOOL", MODE_PRIVATE);

    }

    private void initToolbar() {
        toolbar = (Toolbar) findViewById(R.id.Toolbarskl);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("SCHOOL");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }


    private void setupListView () {
        final String[] school = getResources().getStringArray(R.array.SCHOOL1);
        SchoolAdapter adapter = new SchoolAdapter(this, R.layout.activity_skl_list, school);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position) {
                    case 0: {
                        startActivity(new Intent(getApplicationContext(), SchoolDet.class));
                        sharedPreferences.edit().putString(Selected_school, "INFORMATION AND COMMUNICATION").apply();
                        break;
                    }
                    case 1: {
                        startActivity(new Intent(getApplicationContext(), SchoolDet.class));
                        sharedPreferences.edit().putString(Selected_school, "ELECTRONIC SCIENCE AND TECHNOLOGY").apply();
                        break;
                    }
                    case 2: {
                        startActivity(new Intent(getApplicationContext(), SchoolDet.class));
                        sharedPreferences.edit().putString(Selected_school, "MECHANICAL ENGINEERING").apply();
                        break;
                    }
                    case 3: {
                        startActivity(new Intent(getApplicationContext(), SchoolDet.class));
                        sharedPreferences.edit().putString(Selected_school, "ELECTRICAL ENGINEERING").apply();
                        break;
                    }
                    case 4: {
                        startActivity(new Intent(getApplicationContext(), SchoolDet.class));
                        sharedPreferences.edit().putString(Selected_school, "PHYSICS").apply();
                        break;
                    }
                    case 5: {
                        startActivity(new Intent(getApplicationContext(), SchoolDet.class));
                        sharedPreferences.edit().putString(Selected_school, "OPTICAL ENGINEERING").apply();
                        break;
                    }
                    case 6: {
                        startActivity(new Intent(getApplicationContext(), SchoolDet.class));
                        sharedPreferences.edit().putString(Selected_school, "INSTRUMENT SCIENCE AND TECHNOLOGY").apply();
                        break;
                    }
                    case 7: {
                        startActivity(new Intent(getApplicationContext(), SchoolDet.class));
                        sharedPreferences.edit().putString(Selected_school, "CONTROL SCIENCE AND ENGINEERING").apply();
                        break;
                    }
                    case 8: {
                        startActivity(new Intent(getApplicationContext(), SchoolDet.class));
                        sharedPreferences.edit().putString(Selected_school, "COMPUTER SCIENCE AND TECHNOLOGY").apply();
                        break;
                    }
                    case 9: {
                        startActivity(new Intent(getApplicationContext(), SchoolDet.class));
                        sharedPreferences.edit().putString(Selected_school, "SOFTWARE ENGINEERING").apply();
                        break;
                    }
                    case 10: {
                        startActivity(new Intent(getApplicationContext(), SchoolDet.class));
                        sharedPreferences.edit().putString(Selected_school, "MATHEMATICS COURSES").apply();
                        break;
                    }
                    case 11: {
                        startActivity(new Intent(getApplicationContext(), SchoolDet.class));
                        sharedPreferences.edit().putString(Selected_school, "BIOMEDICAL ENGINEERING").apply();
                        break;
                    }
                    case 12: {
                        startActivity(new Intent(getApplicationContext(), SchoolDet.class));
                        sharedPreferences.edit().putString(Selected_school, "MANAGEMENT SCIENCE AND ENGINEERING").apply();
                        break;
                    }
                    case 13: {
                        startActivity(new Intent(getApplicationContext(), SchoolDet.class));
                        sharedPreferences.edit().putString(Selected_school, "PUBLIC MANAGEMENT").apply();
                        break;
                    }
                    default:
                        break;
                }
            }
        });

    }

    public class SchoolAdapter extends ArrayAdapter {

        private int resource;
        private LayoutInflater layoutInflater;
        private String[] SCHOOL1;


        public SchoolAdapter(Context context, int resource, String[] objects) {
            super(context, resource, objects);
            this.resource = resource;
            this.SCHOOL1 = objects;
            layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        }

        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            ViewHolder holder;
            if (convertView == null) {
                convertView = layoutInflater.inflate(R.layout.activity_skl_list, parent, false);
            }
                holder = new ViewHolder();
                holder.Tvskl = (TextView) convertView.findViewById(R.id.Tvsll);
                convertView.setTag(holder);
                holder.Tvskl.setText(SCHOOL1[position]);
            holder = (ViewHolder) convertView.getTag();
            return convertView;
            }

        class ViewHolder {
            private TextView Tvskl;
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