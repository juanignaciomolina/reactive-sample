package com.droidko.reactivesample;

import android.app.Application;

import com.firebase.client.Firebase;

public class ReactiveApplication extends Application {

    private static ReactiveApplication sReactiveApplication;

    @Override
    public void onCreate() {
        super.onCreate();

        sReactiveApplication = this;

        setUpFirebase();
    }

    /**
     * Gets and instance of the current running application
     *
     * @return An instance of a running ReactiveApplication
     */
    public static ReactiveApplication getInstance() {
        return sReactiveApplication;
    }

    private void setUpFirebase() {
        Firebase.setAndroidContext(getInstance());
    }

}
