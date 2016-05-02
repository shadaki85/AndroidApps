package com.example.svilupposw.toeat;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class Loggedin extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loggedin);
        Intent intent =  getIntent();
        String uuid = intent.getStringExtra("uuid");
        String displayName = intent.getStringExtra("displayName");
        CharSequence text = String.format("Hello %s, your UUID is: %s!", displayName, uuid);
        Toast toast = Toast.makeText(getApplicationContext(), text, Toast.LENGTH_LONG);
        toast.show();
    }
}
