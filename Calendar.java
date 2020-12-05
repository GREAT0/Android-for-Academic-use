package com.great.moseye;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.view.menu.MenuAdapter;
import androidx.appcompat.widget.Toolbar;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class Calendar extends AppCompatActivity {
    private ListView listView;
    private Toolbar toolbar;
    public static SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calendar);
        SetupUIviews();
        initToolbar();
        setupListview();
    }
    private void SetupUIviews(){
        listView = (ListView)findViewById(R.id.lvcal);
        toolbar = (Toolbar)findViewById(R.id.Toolbarcal);
        sharedPreferences = getSharedPreferences("calendar", MODE_PRIVATE);

    }
    private void initToolbar(){
        toolbar = (Toolbar)findViewById(R.id.Toolbarcal);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("ACADEMIC CALENDAR");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
    private void setupListview(){
        String[] Cal = getResources().getStringArray(R.array.Calendar);
        String[] Det = getResources().getStringArray(R.array.Calendar1);
        MenuAdapter Adapter = new MenuAdapter(this,Cal,Det);
        listView.setAdapter(Adapter);
    }

    public class MenuAdapter extends BaseAdapter {
        private Context mcontext;
        private int resource;
        private TextView Calendar, Details;
        private LayoutInflater layoutInflater;
        private String[] Cal;
        private String[] Det;

        public MenuAdapter(Context context, String[] Calendar, String[]Details) {
            mcontext = context;
            Cal = Calendar;
            Det = Details;
            layoutInflater = LayoutInflater.from(context);
        }
        @Override
        public int getCount() {
            return Cal.length;
        }

        @Override
        public Object getItem(int position) {
            return Cal[position];
        }

        @Override
        public long getItemId(int position) {
            return position;
        }
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
           /* viewHolder holder;*/
            if (convertView == null) {
               /* holder = new viewHolder();*/
                convertView = layoutInflater.inflate(R.layout.activity_cal_sing, parent, false);
            }
                Calendar = (TextView) convertView.findViewById(R.id.Tvcal);
                Details = (TextView)convertView.findViewById(R.id.CalD);

            Details.setText(Det[position]);
            Calendar.setText(Cal[position]);

            if (Cal[position].equalsIgnoreCase("School Schedule")){
                Det[position].equalsIgnoreCase("details");
            }else if (Cal[position].equalsIgnoreCase("Official Holidays")){
                Det[position].equalsIgnoreCase("details1");
            }else if (Cal[position].equalsIgnoreCase("Full Calendar")){
                Det[position].equalsIgnoreCase("link");
            }

         return convertView;
    }

       /* class viewHolder{
            private TextView tvCal;
            private TextView TvDet;*/
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

