package com.example.miniproject;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Parcelable;
import android.support.annotation.Nullable;
import android.support.design.widget.TextInputEditText;
import android.support.v4.app.NavUtils;
import android.support.v7.app.ActionBar;
import android.util.Log;
import android.view.Menu;
import android.widget.SpinnerAdapter;
import android.widget.TextView;
import android.widget.Toolbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

//Edit Page
public class Main3Activity extends AppCompatActivity {
    Intent intent;
    Users toEdit = null;
    Users toAdd = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        final TextInputEditText AddressInput = (TextInputEditText) findViewById(R.id.AddressInput);
        final TextInputEditText PhoneInput = (TextInputEditText) findViewById(R.id.PhoneInput);
        Button SaveBtn = (Button) findViewById(R.id.SaveBtn);
        TextView textView = (TextView) findViewById(R.id.TextView);
        ActionBar actionBar =getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
        if(MainActivity.bEdit == true) {
            intent = getIntent();
            toEdit = (Users) intent.getParcelableExtra("EditUser");

            textView.setText("Edit User");
            AddressInput.setText(toEdit.getsAddress());
            PhoneInput.setText(toEdit.getsPhone());

            SaveBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String sNewAddress = String.valueOf(AddressInput.getText());
                    String sNewPhone = String.valueOf(PhoneInput.getText());
                    toEdit.setsAddress(sNewAddress);
                    toEdit.setsPhone(sNewPhone);
                    Intent passIntent = new Intent(v.getContext(), MainActivity.class).putExtra("UpdateData", (Parcelable) toEdit);
                    setResult(RESULT_OK, passIntent);
                    finish();
                }
            });
        } else {
            intent = getIntent();
            toAdd = new Users();

            textView.setText("Add User");

            SaveBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String sNewAddress = String.valueOf(AddressInput.getText());
                    String sNewPhone = String.valueOf(PhoneInput.getText());
                    toAdd.setsID(Integer.toString(MainActivity.nListSize + 1));
                    toAdd.setsAddress(sNewAddress);
                    toAdd.setsPhone(sNewPhone);
                    Intent passIntent = new Intent(v.getContext(), MainActivity.class).putExtra("AddData", (Parcelable) toAdd);
                    setResult(RESULT_OK, passIntent);
                    finish();
                }
            });
        }
    }

    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()) {
            case android.R.id.home:
                MainActivity.bIntentEmpty = true;
                Intent exitIntent = new Intent(this, MainActivity.class);
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
