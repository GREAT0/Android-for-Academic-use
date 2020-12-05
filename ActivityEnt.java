package com.great.moseye;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class ActivityEnt extends AppCompatActivity {
    private ListView listView;
    private Toolbar toolbar;
    public static SharedPreferences sharedPreferences;
    public static String[] entertain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ent);
        setupUIviews();
        initToolbar();
        setupListview();
    }
    private void setupUIviews(){
        listView = (ListView)findViewById(R.id.lvEnt);
        toolbar = (Toolbar)findViewById(R.id.ToolbarEnt);
        sharedPreferences = getSharedPreferences("ENT",MODE_PRIVATE);
    }
    private void initToolbar(){
        toolbar = (Toolbar)findViewById(R.id.ToolbarEnt);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Entertainment");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
    private void setupListview(){
        final String[] Ent = getResources().getStringArray(R.array.Entertain);
        SimpleAdapter Adapter = new SimpleAdapter (this,R.layout.activity_ent_sing, Ent);
        listView.setAdapter(Adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

            }
        });
    }
    private class SimpleAdapter extends ArrayAdapter{
        private int resource;
        private LayoutInflater layoutInflater;
        private String[] uestc = new String[]{};

        public SimpleAdapter(Context context, int resource,String[] objects){
            super(context,resource,objects);
            this.resource = resource;
            this.uestc = objects;
            layoutInflater = (LayoutInflater)context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        }

        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            viewHololder holder;
            if (convertView == null){
                holder = new viewHololder();
                convertView = layoutInflater.inflate(resource,null);
                holder.IvEnt = (ImageView) convertView.findViewById(R.id.ivent);
                holder.TvEnt = (TextView)convertView.findViewById(R.id.Tvent);
                convertView.setTag(holder);


            }else {
                holder = (viewHololder) convertView.getTag();
            }
                holder.TvEnt.setText(uestc[position]);

                if (uestc[position].equalsIgnoreCase("Photos")) {
                    holder.IvEnt.setImageResource(R.drawable.entainment);
                }else if (uestc[position].equalsIgnoreCase("Videos")) {
                    holder.IvEnt.setImageResource(R.drawable.entainment);
                }else if (uestc[position].equalsIgnoreCase("Audio")){
                    holder.IvEnt.setImageResource(R.drawable.entainment);
            }
            return convertView;
        }
        class viewHololder {
            private ImageView IvEnt;
            private TextView TvEnt;
        }
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home: {
                onBackPressed();
            }
        }
        return super.onOptionsItemSelected(item);
    }
}
