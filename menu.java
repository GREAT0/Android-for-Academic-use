package com.great.moseye;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Context;
import android.content.SharedPreferences;
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

public class menu extends AppCompatActivity {
   private ListView listView;
    private Toolbar  toolbar;
    public static SharedPreferences sharedPreferences;
    public static String Menu_men;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        setupUIview();
        iniToolbar();

        setuplistView();
    }
    private void setupUIview() {
        listView = (ListView) findViewById(R.id.lvDev);
        toolbar = (Toolbar) findViewById(R.id.ToolbarDev);
        sharedPreferences = getSharedPreferences("Builders", MODE_PRIVATE);
    }
    private void iniToolbar(){
        toolbar = (Toolbar) findViewById(R.id.ToolbarDev);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("About us");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
    private void setuplistView(){
        String[] Great = getResources().getStringArray(R.array.Menu);
        String[] Des = getResources().getStringArray(R.array.Des);

        String Menu_men = menu.sharedPreferences.getString(menu.Menu_men,null);

        SimpleAdapter adapter = new SimpleAdapter(this,Great,Des);
        listView.setAdapter(adapter);
    }
    public class SimpleAdapter extends BaseAdapter {
        private Context ncontext;
        private LayoutInflater layoutInflater;
        private TextView Great,Des;
        private String[] Garray;
        private String[] Desarray;
        private ImageView imageView;

        public SimpleAdapter ( Context context,String[] Great, String[] Des){
            ncontext = context;
            this.Garray = Great;
            this.Desarray = Des;
            layoutInflater = LayoutInflater.from(context);
        }
        @Override
        public int getCount() {
            return Garray.length;
        }

        @Override
        public Object getItem(int position) {
            return Garray[position];
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            if (convertView == null){
                convertView = layoutInflater.inflate(R.layout.activity_menu_sing,parent, false);
            }
            Great = (TextView)convertView.findViewById(R.id.tvDevname);
            Des = (TextView)convertView.findViewById(R.id.tvDevskl);
           /* imageView = (ImageView)convertView.findViewById(R.id.Dvimage);*/

            Great.setText("Name: "+Garray[position]);
            Des.setText( Desarray[position]);

            if (Garray[position].equalsIgnoreCase("Name 1")){
                imageView.setImageResource(R.drawable.download);
            }else if (Garray[position].equalsIgnoreCase("Name 2")){
                imageView.setImageResource(R.drawable.download);
            }else if (Garray[position].equalsIgnoreCase("Name 3")) {
                imageView.setImageResource(R.drawable.download);
           /* }else if (StaffnameArray[position].equalsIgnoreCase("Ms. Zhang Xin (Monica)")) {
                imageView.setImageResource(R.drawable.monica);
            }else if (StaffnameArray[position].equalsIgnoreCase("Ms. Lin Min")) {
                imageView.setImageResource(R.drawable.download);
            }else if (StaffnameArray[position].equalsIgnoreCase("Mr. Dong Liang (Filippo)")) {
                imageView.setImageResource(R.drawable.filipo);
            }else if (StaffnameArray[position].equalsIgnoreCase("Ms. Wang Ya")) {
                imageView.setImageResource(R.drawable.iso_staf);
            }else if (StaffnameArray[position].equalsIgnoreCase("Ms. Zhang Xianoyu")) {
                imageView.setImageResource(R.drawable.download);
            }else if (StaffnameArray[position].equalsIgnoreCase("Ms. Ma Chunxiao (Nora)")){
                imageView.setImageResource(R.drawable.download);*/
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
