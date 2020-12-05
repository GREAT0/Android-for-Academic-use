package com.great.moseye;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.widget.Toolbar;

public class DayDetails extends AppCompatActivity {

    private ListView listView;
    private Toolbar toolbar;
    public static String[] SUNDAY;
    public static String[] MONDAY;
    public static String[] TUESDAY;
    public static String[] WEDNESDAY;
    public static String[] THURSDAY;
    public static String[] FRIDAY;
    public static String[] SATURDAY;
    public static String[] TIME1;
    public static String[] TIME2;
    public static String[] TIME3;
    public static String[] TIME4;
    public static String[] TIME5;
    public static String[] TIME6;
    public static String[] TIME7;
    private String[] PreferredDay;
    private String[] PreferredTime;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_day_details);

        setupUIviews();
        initToolbar();
        setupListView();
    }

    private void setupUIviews(){
        listView = (ListView) findViewById(R.id.lvDayD);
        toolbar = findViewById(R.id.ToolbarDayD);
    }

    private void initToolbar(){
        toolbar = (Toolbar) findViewById(R.id.ToolbarDayD);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(WeekActivity.sharedPreferences.getString(WeekActivity.Selected_Day,null));
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    private void setupListView(){
        SUNDAY = getResources().getStringArray(R.array.SUNDAY);
        MONDAY = getResources().getStringArray(R.array.MONDAY);
        TUESDAY = getResources().getStringArray(R.array.TUESDAY);
        WEDNESDAY = getResources().getStringArray(R.array.WEDNESDAY);
        THURSDAY = getResources().getStringArray(R.array.THURSDAY);
        FRIDAY = getResources().getStringArray(R.array.FRIDAY);
        SATURDAY = getResources().getStringArray(R.array.SATURDAY);

        TIME1 = getResources().getStringArray(R.array.TIME1);
        TIME2 = getResources().getStringArray(R.array.TIME2);
        TIME3 = getResources().getStringArray(R.array.TIME3);
        TIME4 = getResources().getStringArray(R.array.TIME4);
        TIME5 = getResources().getStringArray(R.array.TIME5);
        TIME6 = getResources().getStringArray(R.array.TIME6);
        TIME7 = getResources().getStringArray(R.array.TIME7);

        String Selected_day = WeekActivity.sharedPreferences.getString(WeekActivity.Selected_Day, null);

        if(Selected_day.equalsIgnoreCase("SUNDAY")){
            PreferredDay = SUNDAY;
            PreferredTime = TIME1;
        }else if (Selected_day.equalsIgnoreCase("MONDAY")){
            PreferredDay = MONDAY;
            PreferredTime = TIME2;
        }else if (Selected_day.equalsIgnoreCase("TUESDAY")){
            PreferredDay = TUESDAY;
            PreferredTime = TIME3;
        }else if (Selected_day.equalsIgnoreCase("WEDNESDAY")){
            PreferredDay = WEDNESDAY;
            PreferredTime = TIME4;
        }else if (Selected_day.equalsIgnoreCase("THURSDAY")){
            PreferredDay = THURSDAY;
            PreferredTime = TIME5;
        }else if (Selected_day.equalsIgnoreCase("FRIDAY")){
            PreferredDay = FRIDAY;
            PreferredTime = TIME6;
        }else  {
            PreferredDay = SATURDAY;
            PreferredTime = TIME7;
        }

        MenuAdapter menuAdapter = new MenuAdapter(DayDetails.this, PreferredDay, PreferredTime);
        listView.setAdapter(menuAdapter);
    }
    public class MenuAdapter extends BaseAdapter {

        private Context mContext;
        private LayoutInflater layoutInflater;
        private TextView Periods, Time;
        private String[] PeriodsArray;
        private String[] TimeArray;
        private ImageView imageView;



        public MenuAdapter(Context Context, String[] PeriodsArray, String[] TimeArray) {
            mContext = Context;
            this.PeriodsArray = PeriodsArray;
            this.TimeArray = TimeArray;
            layoutInflater = LayoutInflater.from(Context);
        }

        @Override
        public int getCount() {
            return PeriodsArray.length;
        }

        @Override
        public Object getItem(int position) {
            return PeriodsArray[position];
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            if (convertView == null) {
                convertView = layoutInflater.inflate(R.layout.day_detail_sing_item,parent,false);
            }
            Periods = (TextView) convertView.findViewById(R.id.TvDaydet);
            Time = (TextView) convertView.findViewById(R.id.TvtimeDaydet);
            /*imageView = (ImageView) convertView.findViewById(R.id.ivDaydet);*/

            Periods.setText(PeriodsArray[position]);
            Time.setText(TimeArray[position]);

            if (PeriodsArray[position].equalsIgnoreCase("DEVOTION")) {
                /*imageView.setImageResource(R.drawable.schtim);*/
            } else if (PeriodsArray[position].equalsIgnoreCase("BREAKFAST")) {
                /*imageView.setImageResource(R.drawable.brkfast);*/
            } else if (PeriodsArray[position].equalsIgnoreCase("PERIOD 1")) {
                /*imageView.setImageResource(R.drawable.bbl);*/
            } else if (PeriodsArray[position].equalsIgnoreCase("PERIOD 2")) {
               /* imageView.setImageResource(R.drawable.bbl);*/
            } else if (PeriodsArray[position].equalsIgnoreCase("PERIOD 3")) {
                /*imageView.setImageResource(R.drawable.bbl);*/
            } else if (PeriodsArray[position].equalsIgnoreCase("PERIOD 4")) {
                /*imageView.setImageResource(R.drawable.bbl);*/
            } else if (PeriodsArray[position].equalsIgnoreCase("LUNCH BREAK")) {
                /*imageView.setImageResource(R.drawable.lun);*/
            } else if (PeriodsArray[position].equalsIgnoreCase("PERIOD 5")) {
                /*imageView.setImageResource(R.drawable.bbl);*/
            }else if (PeriodsArray[position].equalsIgnoreCase("PERIOD 6")) {
                    /*imageView.setImageResource(R.drawable.bbl);*/
                } else if (PeriodsArray[position].equalsIgnoreCase("PERIOD 7")) {
                    /*imageView.setImageResource(R.drawable.bbl);*/
                } else if (PeriodsArray[position].equalsIgnoreCase("PERIOD 8")) {
                    /*imageView.setImageResource(R.drawable.bbl);*/
                } else if (PeriodsArray[position].equalsIgnoreCase("DINNER BREAK")) {
                    /*imageView.setImageResource(R.drawable.din);*/
                } else if (PeriodsArray[position].equalsIgnoreCase("PERIOD 9")) {
                    /*imageView.setImageResource(R.drawable.bbl);*/
                } else if (PeriodsArray[position].equalsIgnoreCase("PERIOD 10")) {
                    /*imageView.setImageResource(R.drawable.bbl);*/
            } else if (PeriodsArray[position].equalsIgnoreCase("PERIOD 11")){
                /*imageView.setImageResource(R.drawable.bbl);*/
            }

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
