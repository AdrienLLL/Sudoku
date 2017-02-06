package com.example.adrien_pc.sudoku;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Path;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import com.example.adrien_pc.sudoku.vGrille;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static android.R.attr.level;

public class GridChoice extends Activity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_grid_choice);

        final ListView listGrille = (ListView) findViewById(R.id.maListe);

        String level = (String) this.getIntent().getExtras().get("level");

        final List<vGrille> grilles = new ArrayList();

        InputStream inputStream;
        if("1".equals(level)){
            inputStream = getResources().openRawResource(R.raw.sudogrid1);
        }else if("2".equals(level)){
            inputStream = getResources().openRawResource(R.raw.sudogrid2);
        }else{
            inputStream = getResources().openRawResource(R.raw.sudogrid3);
        }

        BufferedReader inputStreamReader = new BufferedReader(new InputStreamReader(inputStream));

        int i = 1;
        String line ="";

        do {
            try {
                line = inputStreamReader.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }

            grilles.add(new vGrille(Integer.parseInt(level), i, 0, line));
            i++;

        }while (line != null);


        MyAdapter adapter = new MyAdapter(this, grilles);
        listGrille.setAdapter(adapter);

        listGrille.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                final vGrille grille = grilles.get(position);
                AlertDialog.Builder builder = new AlertDialog.Builder(GridChoice.this);
                builder.setTitle("Info");
                builder.setMessage(grille.getNumber() + ":" + grille.getDone());
                builder.setCancelable(false);
                builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {

                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });

                builder.setNegativeButton("Continue", new DialogInterface.OnClickListener() {

                    public void onClick(DialogInterface dialog, int which) {
                        Intent intent = new Intent(GridChoice.this, Grid.class);
                        intent.putExtra("grid", grille.getGrid());
                        startActivity(intent);
                    }
                });

                AlertDialog alert = builder.create();
                alert.show();
            }
        });
    }




}
