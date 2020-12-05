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
import android.widget.ListView;
import android.widget.TextView;

public class Activity_Res extends AppCompatActivity {
    private ListView listView;
    private Toolbar toolbar;
    public static SharedPreferences sharedPreferences;
    public static String selected_Res;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity__res);

        setupUIviews();
        initToolbar();
        setupListView();
    }
    private void setupUIviews(){
        listView = (ListView)findViewById(R.id.lvRes);
        toolbar = (Toolbar)findViewById(R.id.ToolbarRes);
        sharedPreferences = getSharedPreferences("RESOURCE", MODE_PRIVATE);
    }

    private void initToolbar(){
        toolbar = (Toolbar)findViewById(R.id.ToolbarRes);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("AVAILABLE RESOURCES");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    private void setupListView(){
        final String[] Res = getResources().getStringArray(R.array.Resources);
        ResourceAdapter Adapter = new ResourceAdapter(this,R.layout.activity_res_sing_item,Res);
        listView.setAdapter(Adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            }
        });
    }

    public class ResourceAdapter extends ArrayAdapter{
        private int resource;
        private LayoutInflater layoutInflater;
        private String[] Resources;

        public ResourceAdapter(Context context, int resource,String[] objects){
            super(context,resource,objects);
            this.resource = resource;
            this.Resources = objects;
            layoutInflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        }

        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            ViewHolder holder;
            if (convertView == null){
                convertView = layoutInflater.inflate(R.layout.activity_res_sing_item,parent,false);
            }
            holder = new ViewHolder();
            holder.TvRes = (TextView)convertView.findViewById(R.id.tvRes);
            convertView.setTag(holder);
            holder.TvRes.setText(Resources[position]);
            holder = (ViewHolder)convertView.getTag();
            return  convertView;
        }
        class ViewHolder{
            TextView TvRes;
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
