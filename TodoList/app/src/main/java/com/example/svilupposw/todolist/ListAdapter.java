package com.example.svilupposw.todolist;


import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

import com.firebase.client.Firebase;

import java.util.ArrayList;

public class ListAdapter extends BaseAdapter{
    private Context context;

    private ArrayList<DatabaseList> lista;
    private ArrayList<String> indexes;

    public ListAdapter(Context context)
    {
        this.context = context;
        this.lista = new ArrayList<>();
        this.indexes = new ArrayList<>();

    }

    public void addItem(DatabaseList item){
        this.lista.add(item);
        this.indexes.add(item.getUuid());
        notifyDataSetChanged();
    }

    public void removeItem(String key){
        this.lista.remove(this.indexes.indexOf(key));
        indexes.remove(key);
        notifyDataSetChanged();
    }
    @Override
    public int getCount() {
        Log.i("lista size",""+lista.size());
        return lista.size();
    }

    @Override
    public Object getItem(int position) {

        DatabaseList it =  lista.get(position);
        Log.i("Title ",it.getTitle());
        Log.i("Description ",it.getDescription());
        return it;
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
        final TextView title = (TextView) convertView.findViewById(R.id.title);
        final DatabaseList elem = (DatabaseList)getItem(position);
        title.setText(elem.getTitle());

        final TextView description = (TextView) convertView.findViewById(R.id.description);
        description.setText(elem.getDescription());

        final CheckBox cb = (CheckBox) convertView.findViewById(R.id.done);
        cb.setChecked(elem.isDone());

        cb.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                Firebase listRef = DatabaseConnection.getFbRef().child("todolist").child(elem.getUuid()).child("done");

                Firebase ref = listRef.getRef();

                if (isChecked) {
                    Log.i("Key per cancellare", elem.getUuid());
                    elem.setDone(true);
                    ref.setValue(true);

                } else {
                    Log.i("Un-Checked", "Un-Checked");
                    elem.setDone(false);
                    ref.setValue(false);
                }
            }
        });
        cb.setOnLongClickListener(new CompoundButton.OnLongClickListener() {
            Firebase listRef = DatabaseConnection.getFbRef().child("todolist").child(elem.getUuid()).getRef();

            @Override
            public boolean onLongClick(View v) {
                title.setBackgroundResource(R.color.colorRed);
                description.setBackgroundResource(R.color.colorRed);
                new AlertDialog.Builder(context)
                        .setIcon(android.R.drawable.ic_dialog_alert)
                        .setTitle("Cancella impegno")
                        .setMessage("Sei sicuro di voler cancellare '" + elem.getTitle() + "'?")
                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                listRef.setValue(null);
                            }

                        })
                        .setNegativeButton("No", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                title.setBackgroundResource(R.color.colorAqua);
                                description.setBackgroundResource(R.color.colorAqua);
                            }
                        })
                        .show();
                Log.i("Long checkbox click", "LOOOOONG CLICK! removing from database!");
                //listRef.setValue(null);

                return true;
            }
        });
        return convertView;
    }
}
