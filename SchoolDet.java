package com.great.moseye;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.view.menu.MenuAdapter;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import androidx.appcompat.widget.Toolbar;


public class SchoolDet extends AppCompatActivity {
    private Toolbar toolbar;
    private ListView listview;
    public static String[] Staff;
    public static String[] Description;
    public static String[] Contact;
    public static String[] Staff1;
    public static String[] Staff2;
    public static String[] Staff3;
    public static String[] Staff4;
    public static String[] Staff5;
    public static String[] Staff6;
    public static String[] Staff7;
    public static String[] Staff8;
    public static String[] Staff9;
    public static String[] Staff10;
    public static String[] Staff11;
    public static String[] Staff12;
    public static String[] Staff13;
    public static String[] Description1;
    public static String[] Description2 ;
    public static String[] Description3;
    public static String[] Description4;
    public static String[] Description5;
    public static String[]Description13;
    public static String[] Description6;
    public static String[] Description7;
    public static String[] Description8;
    public static String[] Description9;
    public static String[] Description10;
    public static String[] Description11;
    public static String[] Description12;
    public static String[] Contact1;
    public static String[] Contact2;
    public static String[] Contact3;
    public static String[] Contact4;
    public static String[] Contact5;
    public static String[] Contact6;
    public static String[] Contact7;
    public static String[] Contact8;
    public static String[] Contact9;
    public static String[] Contact10;
    public static String[] Contact11;
    public static String[] Contact12;
    public static String[] Contact13;
    public static Drawable Info;
    private String[] Preferredstaff;
    private String[] Preferredarea;
    private String[] Preferredinfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_school_det);

        setupUIViews();
        initToolbar();
        setupListView();

    }
    private void setupUIViews(){
        listview = (ListView) findViewById(R.id.lvSchoolD);
        toolbar = (Toolbar) findViewById(R.id.ToolbarSchoolD);
    }

    private void initToolbar(){
        toolbar = (Toolbar)  findViewById(R.id.ToolbarSchoolD);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(SchoolActivity.sharedPreferences.getString(SchoolActivity.Selected_school,"LECTURERS"));
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    private void setupListView(){
        Staff = getResources().getStringArray( R.array.Staff_1);
       Description = getResources().getStringArray(R.array.Description_1);
       Contact = getResources().getStringArray(R.array.Contact_1);
        Staff1 = getResources().getStringArray(R.array.Staff_2);
        Staff2 = getResources().getStringArray(R.array.Staff_3);
        Staff3 = getResources().getStringArray(R.array.Staff_4);
        Staff4 = getResources().getStringArray(R.array.Staff_5);
        Staff5 = getResources().getStringArray(R.array.Staff_6);
        Staff6 = getResources().getStringArray(R.array.Staff_7);
        Staff7 = getResources().getStringArray(R.array.Staff_8);
        Staff8 = getResources().getStringArray(R.array.Staff_9);
        Staff9 = getResources().getStringArray(R.array.Staff_10);
        Staff10 = getResources().getStringArray(R.array.Staff_11);
        Staff11 = getResources().getStringArray(R.array.Staff_12);
        Staff12 = getResources().getStringArray(R.array.Staff_13);
        Staff13 = getResources().getStringArray(R.array.Staff_14);

        Description1 = getResources().getStringArray(R.array.Description_2);
        Description2 = getResources().getStringArray(R.array.Description_3);
        Description3 = getResources().getStringArray(R.array.Description_4);
        Description4 = getResources().getStringArray(R.array.Description_5);
        Description5 = getResources().getStringArray(R.array.Description_6);
        Description6 = getResources().getStringArray(R.array.Description_7);
        Description7 = getResources().getStringArray(R.array.Description_8);
        Description8 = getResources().getStringArray(R.array.Description_9);
        Description9 = getResources().getStringArray(R.array.Description_10);
        Description10 = getResources().getStringArray(R.array.Description_11);
        Description11 = getResources().getStringArray(R.array.Description_12);
        Description12 = getResources().getStringArray(R.array.Description_13);
        Description13 = getResources().getStringArray(R.array.Description_14);

        Contact1 = getResources().getStringArray(R.array.Contact_2);
        Contact2 = getResources().getStringArray(R.array.Contact_3);
        Contact3 = getResources().getStringArray(R.array.Contact_4);
        Contact4 = getResources().getStringArray(R.array.Contact_5);
        Contact5 = getResources().getStringArray(R.array.Contact_6);
        Contact6 = getResources().getStringArray(R.array.Contact_7);
        Contact7 = getResources().getStringArray(R.array.Contact_8);
        Contact8 = getResources().getStringArray(R.array.Contact_9);
        Contact9 = getResources().getStringArray(R.array.Contact_10);
        Contact10 = getResources().getStringArray(R.array.Contact_11);
        Contact11 = getResources().getStringArray(R.array.Contact_12);
        Contact12 = getResources().getStringArray(R.array.Contact_13);
        Contact13 = getResources().getStringArray(R.array.Contact_14);

        /*Info = getResources().getDrawable(R.drawable.Info);
*/
        String Selected_school = SchoolActivity.sharedPreferences.getString(SchoolActivity.Selected_school,"Prof");


        if (Selected_school.equalsIgnoreCase("INFORMATION AND COMMUNICATION") ){
            Preferredstaff = Staff;
            Preferredarea = Description;
            Preferredinfo = Contact;
            /*prefrredimag = Info;*/
        }else if (Selected_school.equalsIgnoreCase("ELECTRONIC SCIENCE AND TECHNOLOGY")){
            Preferredstaff = Staff1;
            Preferredarea = Description1;
            Preferredinfo = Contact1;
        }else if (Selected_school.equalsIgnoreCase("MECHANICAL ENGINEERING")){
            Preferredstaff = Staff2;
            Preferredarea = Description2;
            Preferredinfo = Contact2;
        }else if (Selected_school.equalsIgnoreCase("ELECTRICAL ENGINEERING")){
            Preferredstaff = Staff3;
            Preferredarea = Description3;
            Preferredinfo = Contact3;
        }else if (Selected_school.equalsIgnoreCase("PHYSICS")){
            Preferredstaff = Staff4;
            Preferredarea = Description4;
            Preferredinfo = Contact4;
        }else if (Selected_school.equalsIgnoreCase("OPTICAL ENGINEERING")){
            Preferredstaff = Staff5;
            Preferredarea = Description5;
            Preferredinfo = Contact5;
        }else if (Selected_school.equalsIgnoreCase("INSTRUMENT SCIENCE AND TECHNOLOGY")){
            Preferredstaff = Staff6;
            Preferredarea = Description6;
            Preferredinfo = Contact6;
        }else if (Selected_school.equalsIgnoreCase("CONTROL SCIENCE AND ENGINEERING")){
            Preferredstaff = Staff7;
            Preferredarea = Description7;
            Preferredinfo = Contact7;
        }else if (Selected_school.equalsIgnoreCase("COMPUTER SCIENCE AND TECHNOLOGY")){
            Preferredstaff = Staff8;
            Preferredarea = Description8;
            Preferredinfo = Contact8;
        }else if (Selected_school.equalsIgnoreCase("SOFTWARE ENGINEERING")){
            Preferredstaff = Staff9;
            Preferredarea = Description9;
            Preferredinfo = Contact9;
        }else if (Selected_school.equalsIgnoreCase("MATHEMATICS COURSES")){
            Preferredstaff = Staff10;
            Preferredarea = Description10;
            Preferredinfo = Contact10;
        }else if (Selected_school.equalsIgnoreCase("BIOMEDICAL ENGINEERING")){
            Preferredstaff = Staff11;
            Preferredarea = Description11;
            Preferredinfo = Contact11;
        }else if (Selected_school.equalsIgnoreCase("MANAGEMENT SCIENCE AND ENGINEERING")){
            Preferredstaff = Staff12;
            Preferredarea = Description12;
            Preferredinfo = Contact12;
        }else {
            Preferredstaff = Staff13;
            Preferredarea = Description13;
            Preferredinfo = Contact13;
        }
        MenuAdapter menuAdapter = new MenuAdapter (SchoolDet.this,Preferredstaff,Preferredarea,Preferredinfo);
        listview.setAdapter(menuAdapter);
    }

    public class MenuAdapter extends BaseAdapter {
        private Context mContext;
        private LayoutInflater layoutInflater;
        private TextView ResearchArea, Lecturer, contact;
        private String[] Description;
        private String[] Staff;
        private String[] Contact;


        public MenuAdapter(Context Context, String[] Staff, String[] Description, String[] Contact) {
            mContext = Context;
            this.Description = Description;
            this.Staff =  Staff;
            this.Contact = Contact;
            layoutInflater = LayoutInflater.from(Context);
        }

        @Override
        public int getCount() {
            return Staff.length;
        }

        @Override
        public Object getItem(int position) {
            return Staff[position];
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            if (convertView == null) {
                convertView = layoutInflater.inflate(R.layout.activity_school_sing_item,parent, false);
            }

            Lecturer = (TextView) convertView.findViewById(R.id.TvSkl);
            ResearchArea = (TextView) convertView.findViewById(R.id.tvskl);
            contact = (TextView) convertView.findViewById(R.id.tvRef);
         /*   imageView = (ImageView) convertView.findViewById(R.id.ivlec)*/;

            Lecturer.setText( "Name:" +Staff[position]);
            ResearchArea.setText("Research Interest:" +Description[position]);
            contact.setText("Contact:" +Contact[position]);

            if (Staff[position].equalsIgnoreCase("Name ")) {
            } else if (Staff[position].equalsIgnoreCase("Research Area ")) {
            } else if (Staff[position].equalsIgnoreCase("Contact Info ")) {
           /* } else if (Staff[position].equalsIgnoreCase("ELECTRICAL ENGINEERING")) {
                imageView.setImageResource(R.drawable.bbl);
            } else if (Staff[position].equalsIgnoreCase("PHYSICS")) {
                imageView.setImageResource(R.drawable.bbl);
            } else if (Staff[position].equalsIgnoreCase("OPTICAL ENGINEERING")) {
                imageView.setImageResource(R.drawable.bbl);
            } else if (Staff[position].equalsIgnoreCase("INSTRUMENT SCIENCE AND TECHNOLOGY")) {
                imageView.setImageResource(R.drawable.lun);
            } else if (Staff[position].equalsIgnoreCase("CONTROL SCIENCE AND ENGINEERING")) {
                imageView.setImageResource(R.drawable.bbl);
            } else if (Staff[position].equalsIgnoreCase("COMPUTER SCIENCE AND TECHNOLOGY")) {
                imageView.setImageResource(R.drawable.bbl);
            } else if (Staff[position].equalsIgnoreCase("SOFTWARE ENGINEERING")) {
                imageView.setImageResource(R.drawable.bbl);
            } else if (Staff[position].equalsIgnoreCase("MATHEMATICS COURSES")) {
                imageView.setImageResource(R.drawable.bbl);
            } else if (Staff[position].equalsIgnoreCase("BIOMEDICAL ENGINEERING")) {
                imageView.setImageResource(R.drawable.din);
            } else if (Staff[position].equalsIgnoreCase("MANAGEMENT SCIENCE AND ENGINEERING")) {
                imageView.setImageResource(R.drawable.bbl);
            } else if (Staff[position].equalsIgnoreCase("PUBLIC MANAGEMENT")) {
                imageView.setImageResource(R.drawable.bbl);*/
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
