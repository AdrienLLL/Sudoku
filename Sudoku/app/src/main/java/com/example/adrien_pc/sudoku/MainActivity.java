package com.example.adrien_pc.sudoku;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements  View.OnClickListener{

    Activity context = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btaction1 = (Button)findViewById(R.id.LEVEL1);
        btaction1.setOnClickListener(this);
        Button btaction2 = (Button)findViewById(R.id.LEVEL2);
        btaction2.setOnClickListener(this);

    }

    public void onClick(View v)
    {
        Intent intent = new Intent(this, GridChoice.class);
        Bundle bun = new Bundle();
        switch(v.getId()){

            case R.id.LEVEL1 :
                intent.putExtras(bun);
                startActivity(intent);
                break;

            case R.id.LEVEL2 :
                intent.putExtras(bun);
                startActivity(intent);
                break;
        }
    }
}
