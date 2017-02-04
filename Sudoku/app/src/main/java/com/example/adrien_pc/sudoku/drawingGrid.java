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

    private static final String TAG = "Sudoku";
    private int top, bottom, left, right;
    private int XOFSelection = 0;
    private int YOFSelection = 0;
    private float tileWidth = 0f;
    private float tileHeight = 0f;
    private Rect rect = null;
    private GridChoice mParams;


    public drawingGrid(Context context, AttributeSet attrs) {
        super(context,attrs);
        //this.setOnTouchListener(this);
    }

    private void select(int x, int y){
        XOFSelection = Math.min(Math.max(x, 0),8);
        YOFSelection = Math.min(Math.max(y, 0),8);

        invalidate();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        Paint p = new Paint();
        p.setColor(Color.BLACK);
        p.setStyle(Paint.Style.STROKE);

        int gm = 100;

        for (int r = 0; r<9 ;r++)
        {
            for(int c=0; c<9 ;c++){
                top = r*gm;
                bottom=top+gm;
                left=c*gm;
                right=left+gm;
                canvas.drawRect(left, top, right, bottom, p);
            }
        }
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        super.onTouchEvent(event);

        switch(event.getAction()){
            case MotionEvent.ACTION_DOWN :
                int x = (int) (event.getX()/tileWidth);
                int y = (int) (event.getY()/tileHeight);
                select(x,y);
                break;
            case MotionEvent.ACTION_UP:
                break;
            case MotionEvent.ACTION_MOVE:
                break;
        }
        return true;
    }

    private void getRect(int x, int y, Rect rect) {
        rect.set((int) (x * width), (int) (y * height), (int) (x * width + width), (int) (y * height + height));
    }


}
