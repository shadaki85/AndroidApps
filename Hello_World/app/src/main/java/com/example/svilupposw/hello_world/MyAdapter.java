package com.example.svilupposw.hello_world;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by svilupposw on 17/03/16.
 */
public class MyAdapter extends BaseAdapter {

    private Context context;
    private ArrayList<String> lista;

    public MyAdapter(Context context, ArrayList<String> lista){
        this.context = context;
        this.lista = lista;
    }

    @Override
    public int getCount() {
        return lista.size();
    }

    @Override
    public Object getItem(int position) {
        return lista.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null)
        {
           convertView = LayoutInflater.from(context).inflate(R.layout.item,parent,false);

        }
        TextView title = (TextView) convertView.findViewById(R.id.title);
        title.setText((String)getItem(position));
        return convertView;
    }
}
