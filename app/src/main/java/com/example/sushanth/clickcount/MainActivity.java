package com.example.sushanth.clickcount;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView showValue;
    TextView showValue1;
    int counter ;
    int bccounter ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        showValue = (TextView) findViewById(R.id.counterValue);
        showValue1 = (TextView) findViewById(R.id.bcvalue);


    }
    public void countIncrease(View view){
        //On click the Count Value should increase
        counter++;
        showValue.setText(String.valueOf(counter));

    }
    protected void onResume(){
        super.onResume();
        showValue.setText(String.valueOf(counter));
        showValue1.setText(String.valueOf(bccounter));
    }

    protected void onPause(){
        super.onPause();
        //Reference: From blackboard and android developer website
        if(!isChangingConfigurations()){
            bccounter++;
        }

    }

    protected void onSaveInstanceState(Bundle savedInstanceState ){
        super.onSaveInstanceState(savedInstanceState);
        savedInstanceState.putInt("counterstring", counter);
        savedInstanceState.putInt("bgcounterstring", bccounter);


    }

    protected void onRestoreInstanceState(Bundle savedInstanceState){
        super.onRestoreInstanceState(savedInstanceState);
        counter = savedInstanceState.getInt("counterstring");
        bccounter = savedInstanceState.getInt("bgcounterstring");
    }

}


