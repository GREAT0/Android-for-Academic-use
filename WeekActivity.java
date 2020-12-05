package com.great.moseye;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.drawable.shapes.OvalShape;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import androidx.core.widget.ImageViewCompat;

import com.great.moseye.util.LetterImageView;

import java.io.Console;

public class WeekActivity extends AppCompatActivity {


    private Toolbar toolbar;
    private ListView listView;
    public static SharedPreferences sharedPreferences;
    public static String Selected_Day;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_week);

        setupUIviews();
        initToolbar();


        setupListView();
    }

    private void setupUIviews() {
      listView =(ListView) findViewById(R.id.lvWeek);
      toolbar = (Toolbar) findViewById(R.id.ToolbarWeek);
      sharedPreferences = getSharedPreferences("MY DAY", MODE_PRIVATE);
    }
    private void initToolbar(){
         toolbar = (Toolbar) findViewById(R.id.ToolbarWeek);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Weekdays");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }


    private void setupListView (){
        final String[] weekdays = getResources().getStringArray(R.array.Week);

        SimpleAdapter adapter = new SimpleAdapter( this, R.layout.activity_week_single_item, weekdays);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position) {
                    case 0: {
                        startActivity(new Intent(getApplicationContext(), DayDetails.class));
                        sharedPreferences.edit().putString(Selected_Day, "SUNDAY").apply();
                        break;
                    }
                    case 1: {
                        startActivity(new Intent(getApplicationContext(), DayDetails.class));
                        sharedPreferences.edit().putString(Selected_Day, "MONDAY").apply();
                        break;
                    }
                    case 2: {
                        startActivity(new Intent(getApplicationContext(), DayDetails.class));
                        sharedPreferences.edit().putString(Selected_Day, "TUESDAY").apply();
                        break;
                    }
                    case 3: {
                        startActivity(new Intent(getApplicationContext(), DayDetails.class));
                        sharedPreferences.edit().putString(Selected_Day, "WEDNESDAY").apply();
                        break;
                    }
                    case 4: {
                        startActivity(new Intent(getApplicationContext(), DayDetails.class));
                        sharedPreferences.edit().putString(Selected_Day, "THURSDAY").apply();
                        break;
                    }
                    case 5:{
                        startActivity(new Intent(getApplicationContext(), DayDetails.class));
                        sharedPreferences.edit().putString(Selected_Day, "FRIDAY").apply();
                        break;
                }
                    case 6: {
                        startActivity(new Intent(getApplicationContext(), DayDetails.class));
                        sharedPreferences.edit().putString(Selected_Day, "SATURDAY").apply();
                        break;
                    }
                    default:break;
                }
            }
        });
    }


    public class SimpleAdapter extends ArrayAdapter{

        private int resource;
        private LayoutInflater layoutInflater;
        private String[] week = new String[]{};

        public SimpleAdapter(Context context, int resource,String[] objects){
            super(context, resource,objects);
            this.resource = resource;
            this.week = objects;
            layoutInflater = (LayoutInflater)context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        }

        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            ViewHolder holder;
            if(convertView ==null){
                holder = new ViewHolder();
                convertView = layoutInflater.inflate(resource, null);
                holder.ivLogo = (ImageView) convertView.findViewById(R.id.ivImage);
                holder.TvWeek = (TextView) convertView.findViewById(R.id.TvWeek);
                convertView.setTag(holder);

            }else{
                holder = (ViewHolder) convertView.getTag();
            }

            /*holder.ivLogo.setOval(true);
            holder.ivLogo.setLetter(week[position].charAt(0));*/
            holder.TvWeek.setText(week[position]);


            if(week[position].equalsIgnoreCase("SUNDAY")) {
                holder.ivLogo.setImageResource(R.drawable.sun);
            } else if (week[position].equalsIgnoreCase("MONDAY")) {
                holder.ivLogo.setImageResource(R.drawable.mon);
            } else if (week[position].equalsIgnoreCase("TUESDAY")) {
                holder.ivLogo.setImageResource(R.drawable.tues);
            } else if (week[position].equalsIgnoreCase("WEDNESDAY")) {
                holder.ivLogo.setImageResource(R.drawable.wed);
            } else if (week[position].equalsIgnoreCase("THURSDAY")) {
                holder.ivLogo.setImageResource(R.drawable.thlast);
            }else if (week[position].equalsIgnoreCase("FRIDAY")) {
                holder.ivLogo.setImageResource(R.drawable.fri);
            }else if (week[position].equalsIgnoreCase("SATURDAY")) {
                holder.ivLogo.setImageResource(R.drawable.sat);
            }


            return convertView;
        }

        class ViewHolder{
            private ImageView ivLogo;
            private TextView TvWeek;
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
