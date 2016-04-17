package com.droidko.reactivesample.activities;

import android.support.v4.app.Fragment;

import com.droidko.reactivesample.fragments.LoginFragment;

public class LoginActivity extends BaseActivity {

    @Override
    protected Fragment onFragmentRequested() {
        return LoginFragment.newInstance();
    }

}
