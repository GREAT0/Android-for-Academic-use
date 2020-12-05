package com.great.moseye;

import androidx.annotation.NonNull;
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
import android.widget.Adapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import static com.great.moseye.R.id.ivISO;
import static com.great.moseye.R.id.parent;

public class IsoActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private ListView listView;
    public static SharedPreferences sharedPreferences;
    public static String Selected_Staff;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_iso);

        setupUIview();
        iniToolbar();

        setuplistView();

    }
    private void setupUIview() {
        listView = (ListView) findViewById(ivISO);
        toolbar = (Toolbar) findViewById(R.id.Toolbariso);
        sharedPreferences = getSharedPreferences("ISO_STAFF", MODE_PRIVATE);

    }

    private void iniToolbar(){
        toolbar = (Toolbar) findViewById(R.id.Toolbariso);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("ISO STAFF");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    private void setuplistView(){
        String[] Staffname = getResources().getStringArray(R.array.ISO);
        String[] Staffpos = getResources().getStringArray(R.array.ISO_staff);
        String[] Contact = getResources().getStringArray(R.array.ISO_Contact);

        String Selected_Staff = IsoActivity.sharedPreferences.getString(IsoActivity.Selected_Staff, null);

        SimpleAdapter simpleAdapter = new SimpleAdapter(this,Staffname,Staffpos,Contact);
        listView.setAdapter(simpleAdapter);
}

    public class  SimpleAdapter extends BaseAdapter{

        private Context mContext;
        private LayoutInflater layoutInflater;
        private TextView Staffname,Staffpos,Contact;
        private String[] StaffnameArray;
        private String[] StaffposArray;
        private String[] ContactArray;
        private ImageView imageView;

        public SimpleAdapter(Context context, String[] Staffname,String[] Staffpos, String[] Contact){
            mContext = context;
            this.StaffnameArray = Staffname;
            this.StaffposArray = Staffpos;
            this.ContactArray = Contact;
            layoutInflater = LayoutInflater.from(context);

        }


        @Override
        public int getCount() {
            return StaffnameArray.length;
        }

        @Override
        public Object getItem(int position) {
            return StaffnameArray[position];
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            if (convertView == null){
                convertView = layoutInflater.inflate(R.layout.activity_iso_single_item,parent, false);
            }
            Staffname = (TextView)convertView.findViewById(R.id.tvStafname);
            Staffpos = (TextView)convertView.findViewById(R.id.tvStaffPos);
            Contact = (TextView)convertView.findViewById(R.id.tvContact);
            imageView = (ImageView)convertView.findViewById(R.id.Isoimage);

            Staffname.setText("Name: "+StaffnameArray[position]);
            Staffpos.setText("Position:" +StaffposArray[position]);
            Contact.setText("Contact:" +ContactArray[position]);

            if (StaffnameArray[position].equalsIgnoreCase("Mr. Cai Mingjun")){
                imageView.setImageResource(R.drawable.cai);
            }else if (StaffnameArray[position].equalsIgnoreCase("Mr. Liu Yang")){
                imageView.setImageResource(R.drawable.yan);
            }else if (StaffnameArray[position].equalsIgnoreCase("Mr. Dong Miao (Daniel)")) {
                imageView.setImageResource(R.drawable.dan);
            }else if (StaffnameArray[position].equalsIgnoreCase("Ms. Zhang Xin (Monica)")) {
                imageView.setImageResource(R.drawable.monica);
            }else if (StaffnameArray[position].equalsIgnoreCase("Ms. Lin Min")) {
                imageView.setImageResource(R.drawable.linmin);
            }else if (StaffnameArray[position].equalsIgnoreCase("Mr. Dong Liang (Filippo)")) {
                imageView.setImageResource(R.drawable.filipo);
            }else if (StaffnameArray[position].equalsIgnoreCase("Ms. Wang Ya")) {
                imageView.setImageResource(R.drawable.wangya);
            }else if (StaffnameArray[position].equalsIgnoreCase("Ms. Zhang Xianoyu")) {
                imageView.setImageResource(R.drawable.download);
            }else if (StaffnameArray[position].equalsIgnoreCase("Ms. Ma Chunxiao (Nora)")){
                imageView.setImageResource(R.drawable.nora);
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
