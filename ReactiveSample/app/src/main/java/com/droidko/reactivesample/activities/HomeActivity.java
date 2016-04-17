package com.droidko.reactivesample.activities;

import android.support.v4.app.Fragment;

import com.droidko.reactivesample.fragments.HomeFragment;

public class HomeActivity extends BaseActivity {

    @Override
    protected Fragment onFragmentRequested() {
        return HomeFragment.newInstance();
    }

}
