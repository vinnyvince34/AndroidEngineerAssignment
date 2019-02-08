package com.example.miniproject;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.content.Intent;
import java.util.ArrayList;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    protected Intent mainIntent = new Intent(this, Main3Activity.class);
    protected boolean bButtonAdd;
    protected ArrayList<Users> List;

    public Intent getMainIntent() {
        return  mainIntent;
    }

    private void populateList() {

        Users item1, item2, item3, item4, item5;

        item1 = new Users("1", "A1", "345");
        List.add(item1);

        item2 = new Users("2", "B1", "123");
        List.add(item2);

        item3 = new Users("3", "C3", "093");
        List.add(item3);

        item4 = new Users("4", "D2", "897");
        List.add(item4);

        item5 = new Users("5", "E5", "376");
        List.add(item5);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Button button = (Button) findViewById(R.id.button);
        button.setText("Add");
        List = new ArrayList<Users>();
        ListView lv = (ListView) findViewById(R.id.DataList);
        ListViewAdapter adapter = new ListViewAdapter(this, List);
        lv.setAdapter(adapter);

        populateList();

        adapter.notifyDataSetChanged();

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String sID =  ((TextView)view.findViewById(R.id.ID)).getText().toString();
                String sAddress =  ((TextView)view.findViewById(R.id.Address)).getText().toString();
                String sPhone =  ((TextView)view.findViewById(R.id.Phone)).getText().toString();

                Toast.makeText(getApplicationContext(),
                        "ID : " + sID + "\n"
                                + "Address : " + sAddress + "\n"
                                + "Phone : " + sPhone, Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
