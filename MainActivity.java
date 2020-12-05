package com.great.moseye;



import android.content.Context;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.Toolbar;
import androidx.appcompat.app.AppCompatActivity;

import java.util.Collections;

import static com.great.moseye.R.id.ivISO;


public class MainActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = (ListView) findViewById(R.id.ivMain);

        toolbar = (Toolbar) findViewById(R.id.Toolbarmain);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("G R E M O");
       setupUIview();
       iniToolbar();
       setListview();
    }


    private void setupUIview() {


    }

    private void iniToolbar() {

    }

    private void setListview() {
        String[] title = this.getResources().getStringArray(R.array.Main);
        String[] description = this.getResources().getStringArray(R.array.Description);

        /*SimpleAdapter simpleAdapter;
        simpleAdapter = new SimpleAdapter(this,title,R.layout.main_activity_single_item);
       listView.setAdapter(simpleAdapter);*/
        MenuAdapter menuAdapter = new MenuAdapter(this,title,description);
        listView.setAdapter(menuAdapter);

        Log.d("Array Title",title.toString());

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position){
                    case 0:{
                        Intent intent = new Intent (MainActivity.this,WeekActivity.class);
                        startActivity(intent);
                        break;
                    }
                    case 1: {
                        Intent intent = new Intent( MainActivity.this, CourseActivity.class);
                        startActivity(intent);
                        break;
                    }
                    case 2: {
                        Intent intent = new Intent( MainActivity.this, SchoolActivity.class);
                        startActivity(intent);
                        break;
                    }
                    case 3: {
                        Intent intent = new Intent( MainActivity.this, Calendar.class);
                        startActivity(intent);
                        break;
                    }
                    case 4: {
                        Intent intent = new Intent( MainActivity.this, IsoActivity.class);
                        startActivity(intent);
                        break;
                    }
                    case 5:{
                        Intent intent = new Intent(MainActivity.this,IsuActivity.class);
                        startActivity(intent);
                        break;
                    }
                    case 6:{
                        Intent intent = new Intent(MainActivity.this,Activity_Res.class);
                        startActivity(intent);
                        break;
                    }
                    case 7:{/*Intent intent = new Intent(MainActivity.this,WeekActivity.class);
                        startActivity(intent);*/
                        break;
                    }
                    case 8: Intent intent = new Intent(MainActivity.this,ActivityEnt.class);
                        startActivity(intent);
                        break;
                }
            }
        });
    }

    public class MenuAdapter extends BaseAdapter {

        private Context mContext;
        private LayoutInflater layoutInflater;
        private TextView title, Description;
        private String[] titleArray;
        private String[] DescriptionArray;
        private ImageView imageView;



        public MenuAdapter(Context Context, String[] title, String[] description) {
            mContext = Context;
            titleArray = title;
            DescriptionArray = description;
            layoutInflater = LayoutInflater.from(Context);
        }

        @Override
        public int getCount() {
            return titleArray.length;
        }

        @Override
        public Object getItem(int position) {
            return titleArray[position];
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            if (convertView == null) {
                convertView = layoutInflater.inflate(R.layout.main_activity_single_item,parent,false);
            }
            title = (TextView) convertView.findViewById(R.id.tvMain);
            Description = (TextView) convertView.findViewById(R.id.tvDescription);
            imageView = (ImageView) convertView.findViewById(R.id.ivMain);

            title.setText(titleArray[position]);
            Description.setText(DescriptionArray[position]);

            if (titleArray[position].equalsIgnoreCase("TIMETABLE")) {
                imageView.setImageResource(R.drawable.schtim);
            } else if (titleArray[position].equalsIgnoreCase("COURSES")) {
                imageView.setImageResource(R.drawable.sub);
            } else if (titleArray[position].equalsIgnoreCase("SCHOOLS")) {
                imageView.setImageResource(R.drawable.facultyicon6);
            } else if (titleArray[position].equalsIgnoreCase("CALENDAR")) {
                imageView.setImageResource(R.drawable.image2);
            } else if (titleArray[position].equalsIgnoreCase("ISU")) {
                imageView.setImageResource(R.drawable.disu);
            } else if (titleArray[position].equalsIgnoreCase("ISO")) {
                imageView.setImageResource(R.drawable.download);
            } else if (titleArray[position].equalsIgnoreCase("ENTERTAINMENT")) {
                imageView.setImageResource(R.drawable.entainment);
            } else if (titleArray[position].equalsIgnoreCase("RESOURCES")) {
                imageView.setImageResource(R.drawable.subject);
            } else if (titleArray[position].equalsIgnoreCase("SETTINGS")){
                imageView.setImageResource(R.drawable.setting);
            }

            return convertView;
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.about,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.mainme:
                Intent intent = new Intent(this, menu.class);
                startActivity(intent);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}

