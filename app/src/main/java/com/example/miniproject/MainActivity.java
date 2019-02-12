package com.example.miniproject;

import android.app.Activity;
import android.os.Bundle;
import android.service.autofill.SaveInfo;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.content.Intent;
import java.util.ArrayList;
import java.util.List;

import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    public static final int REQUEST_CODE = 1;
    protected Intent mainIntent = new Intent(this, Main3Activity.class);
    protected ArrayList<Users> List;
    protected ArrayList<Users> uBackup = new ArrayList<Users>();
    protected ListViewAdapter adapter;
    protected int nSelectedIndex = 0;
    public static boolean bEdit = false;
    public static boolean bIntentEmpty = true;
    public static int nListSize = 0;

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
        for(int i = 0; i < List.size(); i++) {
            uBackup.add(List.get(i));
        }
        final ListView lv = (ListView) findViewById(R.id.DataList);
        adapter = new ListViewAdapter(this, List);
        lv.setAdapter(adapter);

        populateList();

        adapter.notifyDataSetChanged();

        nListSize = List.size();

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String sID =  ((TextView)view.findViewById(R.id.ID)).getText().toString();
                String sAddress =  ((TextView)view.findViewById(R.id.Address)).getText().toString();
                String sPhone =  ((TextView)view.findViewById(R.id.Phone)).getText().toString();

                nSelectedIndex = lv.getCheckedItemPosition();

                Toast.makeText(getApplicationContext(),
                        "ID : " + sID + "\n"
                                + "Address : " + sAddress + "\n"
                                + "Phone : " + sPhone, Toast.LENGTH_SHORT).show();
            }
        });

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bEdit = false;
                bIntentEmpty = false;
                Intent intent = new Intent(v.getContext(), Main3Activity.class);
                startActivityForResult(intent, REQUEST_CODE);
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

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == REQUEST_CODE) {
            if(bIntentEmpty == true) {
                Intent intent = getIntent();
            } else {
                if(bEdit == true) {
                    Users receiver = (Users) data.getParcelableExtra("UpdateData");
                    Log.d("MainActivity",List.get(0).getsAddress() + "\n");
                    Log.d("MainActivity",List.get(0).getsPhone() + "\n");
                    if (resultCode == Activity.RESULT_OK) {
                        for(int i = 0; i < List.size(); i++) {
                            if(i == Integer.parseInt(receiver.getsID())) {
                                List.set(Integer.parseInt(receiver.getsID()) - 1, new Users(receiver.getsID(), receiver.getsAddress(), receiver.getsPhone()));
                                adapter.notifyDataSetInvalidated();
                                break;
                            }
                        }
                    } else if (resultCode == Activity.RESULT_CANCELED) {
                        return;
                    }
                } else {
                    Users receiver = (Users) data.getParcelableExtra("AddData");
                    Log.d("MainActivity",List.get(0).getsAddress() + "\n");
                    Log.d("MainActivity",List.get(0).getsPhone() + "\n");
                    if (resultCode == Activity.RESULT_OK) {
                        List.add(List.size(), new Users(Integer.toString(List.size() + 1), receiver.getsAddress(), receiver.getsPhone()));
                        adapter.notifyDataSetInvalidated();
                    } else if (resultCode == Activity.RESULT_CANCELED) {
                        return;
                    }
                }
            }
        }
    }

}
