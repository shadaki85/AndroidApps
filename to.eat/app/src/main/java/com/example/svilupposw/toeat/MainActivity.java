package com.example.svilupposw.toeat;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.firebase.client.AuthData;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;

import java.util.Map;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//
//        fbRef.createUser("bobtony@firebase.com", "correcthorsebatterystaple", new
//                Firebase.ValueResultHandler<Map<String, Object>>() {
//                    @Override
//                    public void onSuccess(Map<String, Object> result) {
//                        System.out.println("Successfully created user account with uid: " + result.get("uid"));
//                        //l’utente è stato creato correttamente, ma occorre successivamente effettuare il login!
//                    }
//
//                    @Override
//                    public void onError(FirebaseError firebaseError) {
//                        // there was an error
//                    }
//                });
        Button clickMe = (Button) findViewById(R.id.login);
        clickMe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                EditText email = (EditText) findViewById(R.id.email);
                EditText pass = (EditText) findViewById(R.id.password);
                final String emailValue = email.getText().toString();
                String passValue = pass.getText().toString();

                boolean typeError = false;

                if (TextUtils.isEmpty(emailValue) || !emailValue.contains("@")) {
                    typeError = true;
                    email.setText("");
                    email.setHint("Formato email errato!");
                    email.setHintTextColor(getResources().getColor(R.color.colorRed));
                }
                if (TextUtils.isEmpty(passValue) || passValue.length() < 4) {
                    typeError = true;
                    pass.setText("");
                    pass.setHint("Password troppo corta!");
                    pass.setHintTextColor(getResources().getColor(R.color.colorRed));
                }

                if(!typeError) {
                    Firebase fbRef = FirebaseRef.getMyFirebaseRef();
                    fbRef.authWithPassword(emailValue, passValue, new Firebase.AuthResultHandler()
                    {

                        @Override
                        public void onAuthenticated(AuthData authData) {
                            //System.out.println("User ID: " + authData.getUid() + ", Provider: " + authData.getProvider());
                            Intent intent = new Intent(getApplicationContext(), Loggedin.class);
                            intent.putExtra("uuid", authData.getUid());
                            intent.putExtra("displayName", emailValue);
                            startActivity(intent);
                        }

                        @Override
                        public void onAuthenticationError(FirebaseError firebaseError) {
                            Toast toast = Toast.makeText(getApplicationContext(), "Email o password errata!", Toast.LENGTH_LONG);
                            toast.show();
                        }
                    });
                }
            }
        });
    }
}
