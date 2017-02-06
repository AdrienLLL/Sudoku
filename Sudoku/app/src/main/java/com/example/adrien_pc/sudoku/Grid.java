package com.example.adrien_pc.sudoku;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

public class Grid extends Activity{

    int[][] grid = new int[9][9];

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_load_grid);

        String _grid = (String) this.getIntent().getExtras().get("grid");
        int k = 1;

        for(int i=0; i<9;i++){
            for (int j = 0; j < 9; j++){
                grid[j][i] = Integer.parseInt(_grid.charAt(k)+"");
                k++;

            }
        }

        drawingGrid dGrid = (drawingGrid) findViewById(R.id.dessin);
        dGrid.setdrawingGrid(grid);
    }
}
