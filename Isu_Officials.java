package com.great.moseye;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import androidx.appcompat.widget.Toolbar;

public class Isu_Officials extends AppCompatActivity {

    private ListView listView;
    private Toolbar toolbar;
    public static SharedPreferences sharedPreferences;
    private  String[] Selected_Official;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_isu__officials);
        setupUIviews();
        initToolbar();
        setupListview();
    }
    private void setupUIviews(){
        listView = (ListView)findViewById(R.id.ivIsuo);
        toolbar = (Toolbar)findViewById(R.id.Toolbarisuo);
        sharedPreferences = getSharedPreferences("ISU OFFICIALS", MODE_PRIVATE);

    }
    private void initToolbar(){
        toolbar = (Toolbar)findViewById(R.id.Toolbarisuo);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(IsuActivity.sharedPreferences.getString(IsuActivity.Isu_section,null));
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    private void setupListview(){
        String[] IsuOname = getResources().getStringArray(R.array.ISU_OFF);
        String[] IsuPos = getResources().getStringArray(R.array.ISU_Pos);
        String[] Contact = getResources().getStringArray(R.array.ISU_Contact);

    /*    String Isu_section = IsuActivity.sharedPreferences.getString(IsuActivity.Isu_section, null);

        if (Isu_section.equalsIgnoreCase("ISU OFFICIALS")) {
            Log.d("COURSE Equals",Isu_section);
            PreferredCourse = COMMON_CORE_MATHEMATICAL_AND_OTHER_OPTIONAL_COURSES;
            Selected_Official = Official;

        } else if (Isu_section.equalsIgnoreCase("ISU EVENTS")) {
            PreferredCourse = ELECTIVE_COMPETENCE_DEVELOPMENT;
            Selected_Official = Events;
        } else if (Isu_section.equalsIgnoreCase("IMPORTANT CONTACTS")) {
            PreferredCourse = INFORMATION_AND_COMMUNICATION_ENGINEERING;
            Selected_Official = Important;
        } else if (Isu_section.equalsIgnoreCase("GRADING SYSTEM")) {
            PreferredCourse = ELECTRONIC_SCIENCE_AND_TECHNOLOGY;
            Selected_Official = Grading;
        } else if (Isu_section.equalsIgnoreCase("SCHOOL PORTAL")) {
            PreferredCourse = MECHANICAL_ENGINEERING;
            Selected_Official = Portal;
        } else if (Isu_section.equalsIgnoreCase("NOTICE")) {
            PreferredCourse = ELECTRONIC_SCIENCE;
            Selected_Official = Notice;*/

        MenuAdapter adapter = new MenuAdapter(Isu_Officials.this, IsuOname, IsuPos, Contact);
        listView.setAdapter(adapter);
    }
    public class MenuAdapter extends BaseAdapter {
        private Context mcontext;
        private LayoutInflater layoutInflater;
        private TextView IsuOname, IsuPos, Contact;
        private String[] IsuOnameArray;
        private String[] IsuPosArray;
        private String[] ContactArray;
        private ImageView imageView;

        public MenuAdapter(Context context, String[] IsuOname, String[] IsuPos, String[] Contact) {
            mcontext = context;
            this.layoutInflater = LayoutInflater.from(context);
            this.IsuOnameArray = IsuOname;
            this.IsuPosArray = IsuPos;
            this.ContactArray = Contact;
        }

        @Override
        public int getCount() {
            return IsuOnameArray.length;
        }

        @Override
        public Object getItem(int position) {
            return IsuOnameArray[position];
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            if (convertView == null) {
                convertView = layoutInflater.inflate(R.layout.isuof_sing_item, parent, false);
            }
            IsuOname = (TextView) convertView.findViewById(R.id.tvIsuOname);
            IsuPos = (TextView) convertView.findViewById(R.id.tvIsuPos);
            Contact = (TextView) convertView.findViewById(R.id.tvContactIs);
            imageView = (ImageView) convertView.findViewById(R.id.Isuoimage);

            IsuOname.setText("Name: " + IsuOnameArray[position]);
            IsuPos.setText("Position: " + IsuPosArray[position]);
            Contact.setText("Contact: " + ContactArray[position]);

            if (IsuOnameArray[position].equalsIgnoreCase("Ukwuoma Chiagoziem Chima")) {
                imageView.setImageResource(R.drawable.pachi);
            } else if (IsuOnameArray[position].equalsIgnoreCase("Gurupira Takudzwa E A")) {
                imageView.setImageResource(R.drawable.taku);
            } else if (IsuOnameArray[position].equalsIgnoreCase("Kenneth Coker")) {
                imageView.setImageResource(R.drawable.ken);
            } else if (IsuOnameArray[position].equalsIgnoreCase("Nimo Benjamin Darkwa")) {
                imageView.setImageResource(R.drawable.nimo2);
            } else if (IsuOnameArray[position].equalsIgnoreCase("Michael Wilson Aidoo")) {
                imageView.setImageResource(R.drawable.aca_offi);
            } else if (IsuOnameArray[position].equalsIgnoreCase("Ali Naveed")) {
                imageView.setImageResource(R.drawable.alina);
            } else if (IsuOnameArray[position].equalsIgnoreCase("Agness George Sambali")) {
                imageView.setImageResource(R.drawable.agnes);
            } else if (IsuOnameArray[position].equalsIgnoreCase("Kellil Nebiat Hiruy")) {
                imageView.setImageResource(R.drawable.welfare);
            } else if (IsuOnameArray[position].equalsIgnoreCase("Ataher Al Imran")) {
                imageView.setImageResource(R.drawable.ather);
            } else if (IsuOnameArray[position].equalsIgnoreCase("Mahi Rifat Bin")) {
                imageView.setImageResource(R.drawable.vpacad);
            } else if (IsuOnameArray[position].equalsIgnoreCase("Hora Gada Gashe")) {
                imageView.setImageResource(R.drawable.vp_ug_aff);
            } else if (IsuOnameArray[position].equalsIgnoreCase("Kossoko Yemissola Nadjath")) {
                imageView.setImageResource(R.drawable.yemi);
            } else if (IsuOnameArray[position].equalsIgnoreCase("Abdulrahman M Ibrahim")) {
                imageView.setImageResource(R.drawable.wefareug);

            }
            return convertView;
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
