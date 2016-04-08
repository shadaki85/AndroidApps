package com.example.svilupposw.bakeka;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.firebase.client.Firebase;

import java.util.Date;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        /*
        Firebase annunciRef = DatabaseAnnunci.getFbRef().child("annunci");
        Firebase newAnnuncioRef = annunciRef.push();
        AnnuncioModel annuncio = new AnnuncioModel("titolo","descr",new Date());
        newAnnuncioRef.setValue(annuncio);
        annuncio.setUuid(newAnnuncioRef.getKey());
        */

    }
}
