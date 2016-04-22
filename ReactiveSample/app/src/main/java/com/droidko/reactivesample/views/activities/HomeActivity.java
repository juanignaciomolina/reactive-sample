package com.droidko.reactivesample.views.activities;

import android.support.v4.app.Fragment;

import com.droidko.reactivesample.views.fragments.HomeFragment;

public class HomeActivity extends BaseActivity {

    @Override
    protected Fragment onFragmentRequested() {
        return HomeFragment.newInstance();
    }

}
