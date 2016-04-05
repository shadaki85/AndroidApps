package com.example.svilupposw.hello_world;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class SingleUserShow extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_single_user_show);
        SharedPreferences sp = getApplicationContext().getSharedPreferences(getString(R.string.pref_file_key), Context.MODE_PRIVATE);
        Intent intent =  getIntent();
        String email = intent.getStringExtra("email");
        String description = intent.getStringExtra("description");
        String uname =  intent.getStringExtra("username");

        TextView user = (TextView) findViewById(R.id.usernameResult);
        user.setText(uname);
        TextView mail = (TextView) findViewById(R.id.emailResult);
        mail.setText(email);
        TextView desc = (TextView) findViewById(R.id.profileDetails);
        desc.setText(description);
    }
}
