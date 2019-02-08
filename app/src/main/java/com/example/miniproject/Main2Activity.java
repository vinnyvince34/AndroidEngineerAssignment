package com.example.miniproject;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.Button;

//Add Page
public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Intent intent = getIntent();
//        Button rtn1 = (Button) findViewById(R.id.returnBtn);
//
//        rtn1.setOnClickListener(new View.OnClickListener() {
//            Intent AIntent = new Intent();
//
//            @Override
//            public void onClick(View v) {
//                startActivity(AIntent);
//            }
//        });
    }
}
