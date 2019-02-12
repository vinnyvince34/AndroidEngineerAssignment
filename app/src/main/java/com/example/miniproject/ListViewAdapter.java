package com.example.miniproject;

import android.content.Intent;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.app.Activity;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import java.util.ArrayList;

public class ListViewAdapter extends BaseAdapter {
    public static final int REQUEST_CODE = 1;
    public ArrayList<Users> List;
    Activity activity;

    public ListViewAdapter(Activity activity, ArrayList<Users> List) {
        super();
        this.activity = activity;
        this.List = List;
    }

    @Override
    public int getCount() {
        return List.size();
    }

    @Override
    public Object getItem(int position) {
        return List.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    private class ViewHolder {
        TextView tvID;
        TextView tvAddress;
        TextView tvPhone;
        Button btnEdit;
        ListView lv;
    }

    public View getView(final int position, View convertView, final ViewGroup parent) {

        final ViewHolder holder;
        LayoutInflater inflater = activity.getLayoutInflater();

        if (convertView == null) {
            convertView = inflater.inflate(R.layout.activity_list_view_content, null);
            holder = new ViewHolder();
            holder.tvID = (TextView) convertView.findViewById(R.id.ID);
            holder.tvAddress = (TextView) convertView.findViewById(R.id.Address);
            holder.tvPhone = (TextView) convertView
                    .findViewById(R.id.Phone);
            holder.btnEdit = (Button) convertView.findViewById(R.id.edit);
            holder.lv = (ListView) convertView.findViewById(R.id.DataList);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        Users item = List.get(position);
        holder.tvID.setText(item.getsID().toString());
        holder.tvAddress.setText(item.getsAddress().toString());
        holder.tvPhone.setText(item.getsPhone().toString());

        holder.btnEdit.setTag(convertView);
        holder.btnEdit.setTag(position);
        holder.btnEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity.bEdit = true;
                MainActivity.bIntentEmpty = false;
                Intent intent=new Intent(v.getContext(), Main3Activity.class).putExtra("EditUser", (Parcelable) List.get(position));
                activity.startActivityForResult(intent, REQUEST_CODE);
            }
        });

        return convertView;
    }
}
