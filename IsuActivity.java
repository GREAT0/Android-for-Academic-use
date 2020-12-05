package com.great.moseye;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import androidx.appcompat.widget.Toolbar;

public class IsuActivity extends AppCompatActivity {
    private Toolbar toolbar;
    private ListView listView;
    public static SharedPreferences sharedPreferences;
    public static String Isu_section;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_isu);

        setupUIviews ();

        initToolbar();
        setupListview();
    }

    private void setupUIviews() {
        listView = (ListView) findViewById(R.id.lvisu);
        toolbar = (Toolbar) findViewById(R.id.ToolbarIsu);
        sharedPreferences = getSharedPreferences("ISU", MODE_PRIVATE);
    }
    private void initToolbar () {
        toolbar = (Toolbar) findViewById(R.id.ToolbarIsu);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("ISU MAIN");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
    private void  setupListview () {
        final String[] Isu = getResources().getStringArray(R.array.ISU);

        SimpleAdapter simpleAdapter = new SimpleAdapter(this, R.layout.activiy_isu_sing_iitem,Isu);
        listView.setAdapter(simpleAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position){
                    case 0: {
                        startActivity(new Intent(getApplicationContext(), Isu_Officials.class));
                        sharedPreferences.edit().putString(Isu_section, "ISU OFFICIALS").apply();
                        break;
                    }
                    case 1:{
                        startActivity(new Intent(getApplicationContext(), IsuImpt.class));
                        sharedPreferences.edit().putString(Isu_section, "ISU EVENTS").apply();
                        break;
                    }
                    case 2:{
                        startActivity(new Intent(getApplicationContext(), IsuImpt.class));
                        sharedPreferences.edit().putString(Isu_section, "IMPORTANT CONTACTS").apply();
                        break;
                    }
                    case 3:{
                        startActivity(new Intent(getApplicationContext(), IsuImpt.class));
                        sharedPreferences.edit().putString(Isu_section, "GRADING SYSTEM").apply();
                        break;
                    }
                    case 4:{ startActivity(new Intent(getApplicationContext(), IsuImpt.class));
                        sharedPreferences.edit().putString(Isu_section, "SCHOOL PORTAL").apply();
                        break;
                    }
                    case 5:{ startActivity(new Intent(getApplicationContext(), IsuImpt.class));
                        sharedPreferences.edit().putString(Isu_section, "NOTICE").apply();
                        break;
                    }
                    default:break;
                }
            }
        });
    }

    public class SimpleAdapter extends ArrayAdapter {
        private int resource;
        private LayoutInflater layoutInflater;
        private String[] isu = new String[]{};

        private SimpleAdapter (Context context, int resource,String[] objects ){
            super(context,resource,objects);
            this.resource = resource;
            this.isu = objects;
            layoutInflater = (LayoutInflater)context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        }

        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            viewHolder holder;
            if (convertView == null) {
                holder = new viewHolder();
                convertView = layoutInflater.inflate(resource, null);
                holder.ivIgIsu = (ImageView) convertView.findViewById(R.id.ivIgisu);
                holder.TvIsu = (TextView) convertView.findViewById(R.id.TvIsu);
                convertView.setTag(holder);
            }else {
                holder = (viewHolder) convertView.getTag();
            }
            holder.TvIsu.setText(isu[position]);

            if (isu[position].equalsIgnoreCase("ISU OFFICIALS")){
                holder.ivIgIsu.setImageResource(R.drawable.isu1);
            }else if (isu[position].equalsIgnoreCase("ISU EVENTS")){
                holder.ivIgIsu.setImageResource(R.drawable.isu1);
            }else if (isu[position].equalsIgnoreCase("IMPORTANT CONTACTS")){
                holder.ivIgIsu.setImageResource(R.drawable.isu1);
            }else if (isu[position].equalsIgnoreCase("SCHOOL PORTAL")){
                holder.ivIgIsu.setImageResource(R.drawable.isu1);
            }else if (isu[position].equalsIgnoreCase("NOTICE")){
                holder.ivIgIsu.setImageResource(R.drawable.isu1);
            }else if (isu[position].equalsIgnoreCase("GRADING SYSTEM")){
                holder.ivIgIsu.setImageResource(R.drawable.isu1);
            }
            return convertView;
        }
        class viewHolder{
            private ImageView  ivIgIsu;
            private TextView TvIsu;
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
