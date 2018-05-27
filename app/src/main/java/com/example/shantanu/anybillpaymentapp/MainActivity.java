package com.example.shantanu.anybillpaymentapp;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    //for back pressed exit
    public void onBackPressed(){
        final AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        builder.setTitle("EXIT LAUNCHER");
        builder.setMessage("Are you sure want to exit?");
        builder.setPositiveButton("YES", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                finishAffinity();
            }
        });
        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        builder.show();
    }

    //defining space
    Spinner spinner;
    String[] languages = {"HINDI","ENGLISH"};
    String lang;
    TextView textView;
    Button button1,button2,button3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //registering space
        spinner = (Spinner) findViewById(R.id.spinner);
        button1 = (Button) findViewById(R.id.button1);
        button2 = (Button) findViewById(R.id.button2);
        button3 = (Button) findViewById(R.id.button3);

        //spinner for languages
        CustomAdapter customAdapter = new CustomAdapter(getApplicationContext(),languages);
        spinner.setAdapter(customAdapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                lang = languages[position];
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        //button listeners
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               Intent intent1 = new Intent(MainActivity.this,Main2Activity.class);
               startActivity(intent1);
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Intent intent2 = new Intent(MainActivity.this,Main2Activity.class);
               // startActivity(intent2);
            }
        });

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Intent intent3 = new Intent(MainActivity.this,Main2Activity.class);
                //startActivity(intent3);
            }
        });
    }

    //custom list view
    class CustomAdapter extends BaseAdapter {
        Context context;
        String[] slang;
        LayoutInflater inflter;

         CustomAdapter(Context applicationContext, String[] la) {
            this.context = applicationContext;
            this.slang = la;
            inflter = (LayoutInflater.from(applicationContext));
        }

        @Override
        public int getCount() {
            return slang.length;
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View view, ViewGroup viewGroup) {

            view = inflter.inflate(R.layout.custom_list,null);
           textView = (TextView) view.findViewById(R.id.textView4);
            textView.setText(slang[position]);
            return view;
        }
    }
}
