package com.example.svilupposw.todolist;

import android.app.Application;
import com.firebase.client.Firebase;

public class
        DatabaseConnection extends Application {
    private static final String FIREBASE_URL = "https://dazzling-inferno-7615.firebaseio.com/";
    private static Firebase fbRef;
    @Override
    public void onCreate() {
        super.onCreate();
        Firebase.setAndroidContext(this);
        fbRef = new Firebase(FIREBASE_URL);
    }
    public static Firebase getFbRef() {
        return fbRef;
    }
}
