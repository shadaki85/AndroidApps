package com.example.svilupposw.hello_world;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;

import java.util.Map;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Button clickMe = (Button) findViewById(R.id.login);
        clickMe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                EditText uname = (EditText) findViewById(R.id.username);
                EditText pass = (EditText) findViewById(R.id.password);
                String unameValue = uname.getText().toString();
                String passValue = pass.getText().toString();

                SharedPreferences sp = getApplicationContext().getSharedPreferences(getString(R.string.pref_file_key), Context.MODE_PRIVATE);

                String usr = sp.getString(unameValue, "notfound");
                String psw = sp.getString(passValue, "notfound");

                if (unameValue.equals("") || unameValue.length() < 4) {
                    uname.setText("");
                    uname.setHint("Username too short!");
                    uname.setHintTextColor(getResources().getColor(R.color.colorRed));
                } else if (passValue.equals("") || passValue.length() < 4) {
                    pass.setText("");
                    pass.setHint("Password too short!");
                    pass.setHintTextColor(getResources().getColor(R.color.colorRed));
                } else {
                    if (usr.equals("notfound") || psw.equals("notfound")) {
                        uname.setText("");
                        uname.setHint("Wrong Username or Password!");
                        uname.setHintTextColor(getResources().getColor(R.color.colorRed));
                        pass.setText("");
                        pass.setHint("Wrong Username or Password!");
                        pass.setHintTextColor(getResources().getColor(R.color.colorRed));
                    } else {
                        Intent intent = new Intent(getApplicationContext(), LoggedIn.class);
                        intent.putExtra("username", usr);
                        intent.putExtra("password", psw);
                        startActivity(intent);
                    }
                }
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
