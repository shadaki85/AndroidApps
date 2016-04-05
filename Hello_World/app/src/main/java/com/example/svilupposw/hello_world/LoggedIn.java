package com.example.svilupposw.hello_world;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;
import android.widget.AdapterView;
import android.view.View;

import java.util.ArrayList;

public class LoggedIn extends AppCompatActivity {

    private boolean showToast = false;
    private MyAdapter lista;
    private ArrayList<String> list;

    private String[] usernames = {"Stefano","Simona","Luca","Giacomo","Sergio","Antonio","Filippo","Massimo","Matteo","Paolo"};
    private String[] emails = {"stefano@gmail.com","simona@gmail.com","luca@gmail.com","giacomo@gmail.com","sergio@gmail.com","antonio@gmail.com","filippo@gmail.com","massimo@gmail.com","matteo@gmail.com","paolo@gmail.com"};
    private String[] descriptions = {
            "Stefano Lorem ipsum dolor sit amet, consectetur adipiscing elit. Ut at est lorem. Nam lobortis elit sit amet magna euismod eleifend. Cras ultrices sodales velit nec ullamcorper. Aliquam erat volutpat. Phasellus eros dolor, gravida vitae tellus ut, consectetur vehicula mauris. Ut massa massa, pretium et ultrices a, malesuada sit amet sapien. Aenean aliquam ligula tellus, quis blandit elit blandit id. Suspendisse porta maximus aliquam. Sed viverra, erat eget auctor dignissim, nulla turpis feugiat eros, tincidunt mattis nisl mi eu nulla. Phasellus egestas mauris ante, eu cursus nisi sollicitudin at. Praesent id nulla nec nisl finibus cursus ut id ex. Donec risus est, sagittis vel vehicula posuere, finibus sit amet lectus. Sed feugiat posuere viverra. Nulla facilisi.",
            "Simona Lorem ipsum dolor sit amet, consectetur adipiscing elit. Ut at est lorem. Nam lobortis elit sit amet magna euismod eleifend. Cras ultrices sodales velit nec ullamcorper. Aliquam erat volutpat. Phasellus eros dolor, gravida vitae tellus ut, consectetur vehicula mauris. Ut massa massa, pretium et ultrices a, malesuada sit amet sapien. Aenean aliquam ligula tellus, quis blandit elit blandit id. Suspendisse porta maximus aliquam. Sed viverra, erat eget auctor dignissim, nulla turpis feugiat eros, tincidunt mattis nisl mi eu nulla. Phasellus egestas mauris ante, eu cursus nisi sollicitudin at. Praesent id nulla nec nisl finibus cursus ut id ex. Donec risus est, sagittis vel vehicula posuere, finibus sit amet lectus. Sed feugiat posuere viverra. Nulla facilisi.",
            "Luca Lorem ipsum dolor sit amet, consectetur adipiscing elit. Ut at est lorem. Nam lobortis elit sit amet magna euismod eleifend. Cras ultrices sodales velit nec ullamcorper. Aliquam erat volutpat. Phasellus eros dolor, gravida vitae tellus ut, consectetur vehicula mauris. Ut massa massa, pretium et ultrices a, malesuada sit amet sapien. Aenean aliquam ligula tellus, quis blandit elit blandit id. Suspendisse porta maximus aliquam. Sed viverra, erat eget auctor dignissim, nulla turpis feugiat eros, tincidunt mattis nisl mi eu nulla. Phasellus egestas mauris ante, eu cursus nisi sollicitudin at. Praesent id nulla nec nisl finibus cursus ut id ex. Donec risus est, sagittis vel vehicula posuere, finibus sit amet lectus. Sed feugiat posuere viverra. Nulla facilisi.",
            "Giacomo Lorem ipsum dolor sit amet, consectetur adipiscing elit. Ut at est lorem. Nam lobortis elit sit amet magna euismod eleifend. Cras ultrices sodales velit nec ullamcorper. Aliquam erat volutpat. Phasellus eros dolor, gravida vitae tellus ut, consectetur vehicula mauris. Ut massa massa, pretium et ultrices a, malesuada sit amet sapien. Aenean aliquam ligula tellus, quis blandit elit blandit id. Suspendisse porta maximus aliquam. Sed viverra, erat eget auctor dignissim, nulla turpis feugiat eros, tincidunt mattis nisl mi eu nulla. Phasellus egestas mauris ante, eu cursus nisi sollicitudin at. Praesent id nulla nec nisl finibus cursus ut id ex. Donec risus est, sagittis vel vehicula posuere, finibus sit amet lectus. Sed feugiat posuere viverra. Nulla facilisi.",
            "Sergio Lorem ipsum dolor sit amet, consectetur adipiscing elit. Ut at est lorem. Nam lobortis elit sit amet magna euismod eleifend. Cras ultrices sodales velit nec ullamcorper. Aliquam erat volutpat. Phasellus eros dolor, gravida vitae tellus ut, consectetur vehicula mauris. Ut massa massa, pretium et ultrices a, malesuada sit amet sapien. Aenean aliquam ligula tellus, quis blandit elit blandit id. Suspendisse porta maximus aliquam. Sed viverra, erat eget auctor dignissim, nulla turpis feugiat eros, tincidunt mattis nisl mi eu nulla. Phasellus egestas mauris ante, eu cursus nisi sollicitudin at. Praesent id nulla nec nisl finibus cursus ut id ex. Donec risus est, sagittis vel vehicula posuere, finibus sit amet lectus. Sed feugiat posuere viverra. Nulla facilisi.",
            "Antonio Lorem ipsum dolor sit amet, consectetur adipiscing elit. Ut at est lorem. Nam lobortis elit sit amet magna euismod eleifend. Cras ultrices sodales velit nec ullamcorper. Aliquam erat volutpat. Phasellus eros dolor, gravida vitae tellus ut, consectetur vehicula mauris. Ut massa massa, pretium et ultrices a, malesuada sit amet sapien. Aenean aliquam ligula tellus, quis blandit elit blandit id. Suspendisse porta maximus aliquam. Sed viverra, erat eget auctor dignissim, nulla turpis feugiat eros, tincidunt mattis nisl mi eu nulla. Phasellus egestas mauris ante, eu cursus nisi sollicitudin at. Praesent id nulla nec nisl finibus cursus ut id ex. Donec risus est, sagittis vel vehicula posuere, finibus sit amet lectus. Sed feugiat posuere viverra. Nulla facilisi.",
            "Filippo Lorem ipsum dolor sit amet, consectetur adipiscing elit. Ut at est lorem. Nam lobortis elit sit amet magna euismod eleifend. Cras ultrices sodales velit nec ullamcorper. Aliquam erat volutpat. Phasellus eros dolor, gravida vitae tellus ut, consectetur vehicula mauris. Ut massa massa, pretium et ultrices a, malesuada sit amet sapien. Aenean aliquam ligula tellus, quis blandit elit blandit id. Suspendisse porta maximus aliquam. Sed viverra, erat eget auctor dignissim, nulla turpis feugiat eros, tincidunt mattis nisl mi eu nulla. Phasellus egestas mauris ante, eu cursus nisi sollicitudin at. Praesent id nulla nec nisl finibus cursus ut id ex. Donec risus est, sagittis vel vehicula posuere, finibus sit amet lectus. Sed feugiat posuere viverra. Nulla facilisi.",
            "Massimo Lorem ipsum dolor sit amet, consectetur adipiscing elit. Ut at est lorem. Nam lobortis elit sit amet magna euismod eleifend. Cras ultrices sodales velit nec ullamcorper. Aliquam erat volutpat. Phasellus eros dolor, gravida vitae tellus ut, consectetur vehicula mauris. Ut massa massa, pretium et ultrices a, malesuada sit amet sapien. Aenean aliquam ligula tellus, quis blandit elit blandit id. Suspendisse porta maximus aliquam. Sed viverra, erat eget auctor dignissim, nulla turpis feugiat eros, tincidunt mattis nisl mi eu nulla. Phasellus egestas mauris ante, eu cursus nisi sollicitudin at. Praesent id nulla nec nisl finibus cursus ut id ex. Donec risus est, sagittis vel vehicula posuere, finibus sit amet lectus. Sed feugiat posuere viverra. Nulla facilisi.",
            "Matteo Lorem ipsum dolor sit amet, consectetur adipiscing elit. Ut at est lorem. Nam lobortis elit sit amet magna euismod eleifend. Cras ultrices sodales velit nec ullamcorper. Aliquam erat volutpat. Phasellus eros dolor, gravida vitae tellus ut, consectetur vehicula mauris. Ut massa massa, pretium et ultrices a, malesuada sit amet sapien. Aenean aliquam ligula tellus, quis blandit elit blandit id. Suspendisse porta maximus aliquam. Sed viverra, erat eget auctor dignissim, nulla turpis feugiat eros, tincidunt mattis nisl mi eu nulla. Phasellus egestas mauris ante, eu cursus nisi sollicitudin at. Praesent id nulla nec nisl finibus cursus ut id ex. Donec risus est, sagittis vel vehicula posuere, finibus sit amet lectus. Sed feugiat posuere viverra. Nulla facilisi.",
            "Paolo Lorem ipsum dolor sit amet, consectetur adipiscing elit. Ut at est lorem. Nam lobortis elit sit amet magna euismod eleifend. Cras ultrices sodales velit nec ullamcorper. Aliquam erat volutpat. Phasellus eros dolor, gravida vitae tellus ut, consectetur vehicula mauris. Ut massa massa, pretium et ultrices a, malesuada sit amet sapien. Aenean aliquam ligula tellus, quis blandit elit blandit id. Suspendisse porta maximus aliquam. Sed viverra, erat eget auctor dignissim, nulla turpis feugiat eros, tincidunt mattis nisl mi eu nulla. Phasellus egestas mauris ante, eu cursus nisi sollicitudin at. Praesent id nulla nec nisl finibus cursus ut id ex. Donec risus est, sagittis vel vehicula posuere, finibus sit amet lectus. Sed feugiat posuere viverra. Nulla facilisi.",
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logged_in);

        Intent intent =  getIntent();
        String uname =  intent.getStringExtra("username");
        String hello = getResources().getString(R.string.hello);
        String wb = getResources().getString(R.string.welcomeback);

        if (showToast) {
            CharSequence text = String.format("%s %s, %s! ->%s", hello, uname, wb,showToast);
            Toast toast = Toast.makeText(getApplicationContext(), text, Toast.LENGTH_LONG);
            toast.show();
            showToast = false;
        } else {
            showToast = true;
        }

        SharedPreferences sp = getApplicationContext().getSharedPreferences(getString(R.string.pref_file_key), Context.MODE_PRIVATE);

        list = new ArrayList<>();

        for (int i=0;i<usernames.length;i++)
        {
            list.add("Nome: "+usernames[i]+"\nEmail: "+emails[i]);
        }
        lista = new MyAdapter(getApplicationContext(),list);
        ListView listView = (ListView) findViewById(R.id.userList);
        listView.setAdapter(lista);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //Toast.makeText(getApplicationContext(), "" + usernames[position], Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getApplicationContext(), SingleUserShow.class);
                intent.putExtra("username", usernames[position]);
                intent.putExtra("email", emails[position]);
                intent.putExtra("description",descriptions[position]);
                startActivity(intent);
            }
        });

    }
}
