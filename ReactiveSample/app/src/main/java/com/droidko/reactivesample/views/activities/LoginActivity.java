package com.droidko.reactivesample.views.activities;

import android.support.v4.app.Fragment;

import com.droidko.reactivesample.views.fragments.LoginFragment;

public class LoginActivity extends BaseActivity {

    @Override
    protected Fragment onFragmentRequested() {
        return LoginFragment.newInstance();
    }

}
