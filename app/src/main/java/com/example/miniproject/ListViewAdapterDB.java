package com.example.miniproject;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.TextView;

public class ListViewAdapterDB extends CursorAdapter {
    public static final int REQUEST_CODE = 1;
    public ListViewAdapterDB (Context context, Cursor cursor) {
        super(context, cursor, 0);
    }

    @Override
    public View newView(Context context, Cursor cursor, ViewGroup parent) {
        return LayoutInflater.from(context).inflate(R.layout.activity_list_view_content, parent, false);
    }

    @Override
    public void bindView(View view, Context context, Cursor cursor) {
        TextView tvID = (TextView) view.findViewById(R.id.ID);
        TextView tvAddress = (TextView) view.findViewById(R.id.Address);
        TextView tvPhone = (TextView) view.findViewById(R.id.Phone);
        String ID = cursor.getString(cursor.getColumnIndexOrThrow("_id"));
        String address = cursor.getString(cursor.getColumnIndexOrThrow("Address"));
        String phoneNumber = cursor.getString(cursor.getColumnIndexOrThrow("Phone_Number"));
        tvID.setText(ID);
        tvAddress.setText(address);
        tvPhone.setText(phoneNumber);
    }
}
