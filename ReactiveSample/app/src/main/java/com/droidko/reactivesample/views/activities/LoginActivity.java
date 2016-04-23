package com.droidko.reactivesample.views.activities;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.View;

import com.droidko.reactivesample.views.fragments.LoginFragment;

public class LoginActivity extends BaseActivity {

    @Override
    protected Fragment onFragmentRequested() {
        return LoginFragment.newInstance();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Allow drawing behind the status bar on this activity
        getWindow().getDecorView().setSystemUiVisibility(
                View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                        | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN);
    }
}
