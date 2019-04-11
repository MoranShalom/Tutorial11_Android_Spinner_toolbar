package com.example.tutorial11_spinner_toolbar;

import android.content.SharedPreferences;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.support.v7.widget.Toolbar;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Toolbar myToolbar;
    private Spinner mySpinner;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myToolbar= (Toolbar) findViewById(R.id.toolbar);
        mySpinner=(Spinner) findViewById(R.id.spinner);

        myToolbar.setTitle(getResources().getString(R.string.app_name));



        //create arry adapter for the listview- must!!!
        ArrayAdapter<String> mAdapter= new ArrayAdapter<String>(MainActivity.this,
               // android.R.layout.simple_list_item_1,- the title on the spinner on the toolbar will be the first item of the spinner
                // android.R.layout- this will color the text of the spinner on the toolbar in defult color- black
               R.layout.custom_spinner_item, // this layout we just created is for the color white
                getResources().getStringArray(R.array.countries));

        mAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mySpinner.setAdapter(mAdapter);

        mySpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MainActivity.this,
                                    mySpinner.getSelectedItem().toString(),
                        Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


    }


}
