package com.droidko.reactivesample.views.activities;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;

import com.droidko.reactivesample.R;

public abstract class BaseActivity extends FragmentActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base);

        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.activity_base_fragment_container, onFragmentRequested())
                .commit();
    }

    /**
     * Provides a method for a sub class to choose which fragment should be loaded in this activity
     *
     * @return A Fragment to be loaded
     */
    protected abstract Fragment onFragmentRequested();
}
