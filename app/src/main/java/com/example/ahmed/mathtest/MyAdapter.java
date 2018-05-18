package com.example.ahmed.mathtest;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by AHMED on 18/05/2018.
 */

public class MyAdapter extends BaseAdapter {
    ArrayList<List_Item> items = new ArrayList<>();
    Context context;

    public MyAdapter(ArrayList<List_Item> items, Context context) {
        this.items = items;
        this.context = context;
    }

    @Override
    public int getCount() {
        return items.size();
    }

    @Override
    public Object getItem(int i) {
        return items.get(i).out_item;
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View v = LayoutInflater.from(context).inflate(R.layout.list_item, viewGroup, false);

        TextView t = v.findViewById(R.id.out_item);
        t.setText(items.get(i).out_item);
        return v;
    }
}
