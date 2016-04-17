package com.droidko.reactivesample.utils;

import android.app.Activity;
import android.content.Intent;

import java.io.Serializable;

public class NavigationUtils {

    public static class IntentObject {
        private String reference;
        private Serializable object;

        public IntentObject(String reference, Serializable object) {
            this.reference = reference;
            this.object = object;
        }
    }

    public static void jumpTo(Activity activity, Class clazz) {
        activity.startActivity(new Intent(activity, clazz));
    }

    public static void jumpTo(Activity activity, Class clazz, IntentObject... intentObjects) {
        Intent i = new Intent(activity, clazz);
        for (IntentObject intentObject : intentObjects) {
            i.putExtra(intentObject.reference, intentObject.object);
        }
        activity.startActivity(i);
    }

}
