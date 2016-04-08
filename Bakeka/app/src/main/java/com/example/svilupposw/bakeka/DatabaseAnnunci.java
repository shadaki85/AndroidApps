package com.example.svilupposw.bakeka;

import android.app.Application;
import com.firebase.client.Firebase;


public class DatabaseAnnunci extends Application {
    private static final String FIREBASE_URL = "https://bakeka.firebaseio.com/";
    private static Firebase myRF;
    @Override
    public void onCreate() {
        super.onCreate();
        Firebase.setAndroidContext(this);
        myRF = new Firebase(FIREBASE_URL);
    }
    public static Firebase getFbRef() {
        return myRF;
    }
}
