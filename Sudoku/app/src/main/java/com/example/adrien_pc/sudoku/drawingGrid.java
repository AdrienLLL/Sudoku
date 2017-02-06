package com.example.adrien_pc.sudoku;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.AttributeSet;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;

import static android.R.attr.numColumns;
import static android.R.attr.width;
import static com.example.adrien_pc.sudoku.R.attr.height;

public class drawingGrid extends View implements View.OnTouchListener {

    private int nbCases=9;

    int [][] grid = null;

    int number = 0;


    public drawingGrid(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.setOnTouchListener(this);
    }

    public void setdrawingGrid(int[][] Grid)
    {
        this.grid = Grid;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        Paint p = new Paint();

        for (int i = 1; i<=nbCases ;i++)
        {
            if (i%3 ==0 )
            {
                p.setStrokeWidth(6);
            }
            else{
                p.setStrokeWidth(3);
            }
            canvas.drawLine(getWidth()/9*i,0, getWidth()/9*i, getWidth(), p);
            canvas.drawLine(0, getWidth()/9*i, getWidth(), getWidth()/9*i, p);
        }

        Paint pRect = new Paint();
        pRect.setStyle(Paint.Style.STROKE);
        p.setStrokeWidth(3);
        Paint pString = new Paint();
        pString.setTextSize(80);

        for (int i = 1; i<=nbCases;i++)
        {
            canvas.drawRect(getWidth()/10 * i - 50, getWidth() +50, getWidth()/10*i+50, getWidth()+150, pRect);
            canvas.drawText(String.valueOf(i), getWidth()/10*i-25, getWidth()+125, pString);
        }

        for (int i =0; i <9;i++){
            for (int j = 0 ;j<9; j++){
                if(grid[i][j] != 0){
                    canvas.drawText(String.valueOf(grid[i][j]), getWidth()/9*i+65, getWidth()/9*j+85, pString);
                }
            }
        }
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        int x = (int) event.getX();
        int y = (int) event.getY();

        switch(event.getAction()){
            case MotionEvent.ACTION_DOWN :
                for(int i = 1; i<=9; i++){
                    if(x>= getWidth()/10*i-50 && x<= getWidth()/10*i+50 && y >= getWidth()+50&& y <= getWidth()+150)
                    {
                        number=i;
                    }
                }
                Log.d("num", String.valueOf(number));
                break;
            case MotionEvent.ACTION_UP:
                int X = x/(getWidth()/9);
                int Y = y/(getWidth()/9);
                if (X<9 && Y<9){
                    grid[X][Y] = number;
                    Log.d("num", String.valueOf(number));
                }

                invalidate();

                Log.d("X", String.valueOf(X));
                Log.d("Y", String.valueOf(Y));
                number=0;
                break;
        }
        this.invalidate();
        return true;
    }


}
