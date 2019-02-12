package com.example.miniproject;

import android.os.Parcelable;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

//Add Page
public class Main2Activity extends AppCompatActivity {
    Intent intent;
    Users toAdd = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        intent = getIntent();
        toAdd = new Users();
        ActionBar actionBar =getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }

        final TextInputEditText AddressInput = (TextInputEditText) findViewById(R.id.AddressInput);
        final TextInputEditText PhoneInput = (TextInputEditText) findViewById(R.id.PhoneInput);
        Button SaveBtn = (Button) findViewById(R.id.AddBtn);

        SaveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String sNewAddress = String.valueOf(AddressInput.getText());
                String sNewPhone = String.valueOf(PhoneInput.getText());
                Log.d("Main3Activity",MainActivity.nListSize + "\n");
                toAdd.setsID(Integer.toString(MainActivity.nListSize + 1));
                toAdd.setsAddress(sNewAddress);
                toAdd.setsPhone(sNewPhone);
                Log.d("Main3Activity",toAdd.getsAddress() + "\n");
                Log.d("Main3Activity",toAdd.getsPhone() + "\n");
                Intent passIntent = new Intent(v.getContext(), MainActivity.class).putExtra("AddData", (Parcelable) toAdd);
                setResult(RESULT_OK, passIntent);
                finish();
            }
        });
    }

    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()) {
            case android.R.id.home:
                Intent exitIntent = new Intent();
                startActivity(exitIntent);
                finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        return true;
    }
}
