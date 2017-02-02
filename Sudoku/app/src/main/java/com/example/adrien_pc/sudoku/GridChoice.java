package com.example.adrien_pc.sudoku;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.List;

public class GridChoice extends AppCompatActivity {

    class monObject{

        public monObject(){

        }
        public String toString(){
            return " TOTO";
        }
    }
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        Bundle bun = this.getIntent().getExtras();
        Log.d("Message", bun.toString());
        setContentView(R.layout.content_grid_choice);

        ListView liste = (ListView)findViewById(R.id.maListe);
        // String[] values = new String[] {"E1","E2"};
        monObject[] values = new monObject[2];
        values[0] = new monObject();
        values[1] = new monObject();
        ArrayAdapter<monObject> adapter = new ArrayAdapter<monObject>(this,
                android.R.layout.simple_list_item_1,android.R.id.text1,values);
        liste.setAdapter(adapter);
    }

}
