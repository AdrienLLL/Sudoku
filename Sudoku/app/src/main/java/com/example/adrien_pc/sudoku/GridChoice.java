package com.example.adrien_pc.sudoku;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static android.R.id.list;

public class GridChoice extends AppCompatActivity implements AdapterView.OnItemClickListener {

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            Intent defineIntent = new Intent(GridChoice.this, loadGrid.class);
            startActivity(defineIntent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        Bundle bun = this.getIntent().getExtras();
        setContentView(R.layout.content_grid_choice);

        if (bun != null){
            ListView liste = (ListView)findViewById(R.id.maListe);
            ArrayList<vGrille> listGrille = new ArrayList<vGrille>();
            Random rand = new Random();

            for(int i =0; i<10 ;i++){
                listGrille.add(new vGrille(bun.getInt("LevelKey"),i,rand.nextInt(100)));
                toString();
            }
            MyAdapter adapter = new MyAdapter(this, listGrille);
            liste.setAdapter(adapter);
            liste.setOnItemClickListener(this);
        }

    }

}

 class vGrille{
     int level;
     int number;
     int Done;

    public vGrille(int level, int num, int done){
        this.level = level;
        this.number=num;
        this.Done=done;
    }

     public vGrille(){}

    public String toString(){
        return "level : " + " " + level + " " + "Number : " + " " + number + " " + "Done : " + " " + Done;
    }
}
