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
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

public class IsuImpt extends AppCompatActivity {
    private Toolbar toolbar;
    private ListView listView;
    private static String[] Important;
    private static String[] Events;
    private static String[] Portal;
    private static String[] Grading;
    private static String[] Notice;
    private SharedPreferences sharedPreferences;
    private String[] Selected_Official;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_isu_impt);

        setupUIviews();
        initToolbar();
        setupListview();
    }

    private void setupUIviews(){
        listView = (ListView)findViewById(R.id.LvImpt);
        toolbar = (Toolbar)findViewById(R.id.ToolbarImpt);
        sharedPreferences = getSharedPreferences("IMPORTANT",MODE_PRIVATE);
    }
    private void initToolbar(){
        toolbar = (Toolbar)findViewById(R.id.ToolbarImpt);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(IsuActivity.sharedPreferences.getString(IsuActivity.Isu_section,null));
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
    private void setupListview(){
        Important = getResources().getStringArray(R.array.Important_Contacts);
        Events = getResources().getStringArray(R.array.Events);
        Portal = getResources().getStringArray(R.array.Portal);
        Grading = getResources().getStringArray(R.array.Grading);
        Notice = getResources().getStringArray(R.array.Notice);

        String Isu_section = IsuActivity.sharedPreferences.getString(IsuActivity.Isu_section,null);


       /* if (Isu_section.equalsIgnoreCase("ISU OFFICIALS")) {
          *//*  Log.d("COURSE Equals",Isu_section);*//*
            Selected_Official = Official;
        } else */if (Isu_section.equalsIgnoreCase("ISU EVENTS")) {
            Selected_Official = Events;
        } else if (Isu_section.equalsIgnoreCase("IMPORTANT CONTACTS")) {
            Selected_Official = Important;
        } else if (Isu_section.equalsIgnoreCase("GRADING SYSTEM")) {
            Selected_Official = Grading;
        } else if (Isu_section.equalsIgnoreCase("SCHOOL PORTAL")) {
            Selected_Official = Portal;
        } else if (Isu_section.equalsIgnoreCase("NOTICE")) {
            Selected_Official = Notice;
        }
        MenuAdapter Adapter = new MenuAdapter (this, Selected_Official);
        listView.setAdapter(Adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

            }
        });

    }
    public class MenuAdapter extends BaseAdapter {
        private Context mcontext;
        private TextView ImptCon;
        private LayoutInflater layoutInflater;
        private String[] Selected_Official;


        public MenuAdapter (Context context, String[] selected_Official){
            mcontext = context;
            Selected_Official = selected_Official;
            this.layoutInflater = LayoutInflater.from(context);
            /*layoutInflater =  (LayoutInflater)context.getSystemService(context.LAYOUT_INFLATER_SERVICE);*/
        }

        @Override
        public int getCount() {
            return Selected_Official.length;
        }

        @Override
        public Object getItem(int position) {
            return Selected_Official[position];
        }

        @Override
        public long getItemId(int position) {
            return position;
        }
        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            /*ViewHolder holder;*/
            if (convertView == null){
               /* holder = new ViewHolder();*/
                convertView = layoutInflater.inflate(R.layout.activity_impt_list, parent,false);
            }
                ImptCon = (TextView)convertView.findViewById(R.id.Tvimpt) ;

                ImptCon.setText(Selected_Official[position]);
               /* holder.tvimpt = (TextView)findViewById(R.id.Tvimpt);*/
                /*convertView.setTag(holder);*/
               /* holder = (ViewHolder)convertView.getTag();*/

           /* holder.tvimpt.setText(ImptConArray[position]);*/

            /*if (Selected_Official[position].equalsIgnoreCase("Hospital")){
            }else if (Im[position].equalsIgnoreCase("Fire")){
            }else if (ImptConArray[position].equalsIgnoreCase("Security")){
            }else if (ImptConArray[position].equalsIgnoreCase("Contact 4")){
            }else if (ImptConArray[position].equalsIgnoreCase("Contact 5")){
            }else if (ImptConArray[position].equalsIgnoreCase("Contact 6")){
            }else if (ImptConArray[position].equalsIgnoreCase("Contact 7")){
            }*/
            return convertView;

        }
        /*class ViewHolder{
            private TextView tvimpt;*//*
        }*/
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
