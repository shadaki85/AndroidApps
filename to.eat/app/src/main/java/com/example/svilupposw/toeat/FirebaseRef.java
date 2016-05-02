package com.example.svilupposw.toeat;

import android.app.Application;

import com.firebase.client.Firebase;

public class FirebaseRef extends Application{

    private static final String FIREBASE_URL = "https://toeat1.firebaseio.com/";
    private static Firebase myFirebaseRef;

    @Override
    public void onCreate() {
        super.onCreate();
        Firebase.setAndroidContext(this);
        myFirebaseRef = new Firebase(FIREBASE_URL);
    }

    public static Firebase getMyFirebaseRef() {
        return myFirebaseRef;
    }
}
