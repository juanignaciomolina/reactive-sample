package com.droidko.reactivesample.fragments;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import com.droidko.reactivesample.R;
import com.droidko.reactivesample.utils.ValidationUtils;

import butterknife.Bind;
import butterknife.BindString;
import butterknife.OnClick;

public class LoginFragment extends BaseFragment {

    // Views
    @Bind(R.id.fragment_login_email)        EditText    mEmail;
    @Bind(R.id.fragment_login_password)     EditText    mPassword;
    @Bind(R.id.fragment_login_button)       Button      mDoLoginButton;

    // Resources
    @BindString(R.string.login_error_invalid_email)     String  mInvalidEmailMessage;
    @BindString(R.string.login_error_invalid_password)  String  mInvalidPasswordMessage;

    public static LoginFragment newInstance() {

        Bundle args = new Bundle();

        LoginFragment fragment = new LoginFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    protected int onLayoutRequested() {
        return R.layout.fragment_login;
    }

    @OnClick(R.id.fragment_login_button)
    protected void requestLogin() {
        if (!validateInputFields()) return;


    }

    private boolean validateInputFields() {

        if (!ValidationUtils.isValidEmail(mEmail.getText())) {
            mEmail.setError(mInvalidEmailMessage);
            return false;
        }
        if (!ValidationUtils.isValidPassword(mPassword.getText().toString())) {
            mPassword.setError(mInvalidPasswordMessage);
            return false;
        }

        return true;
    }
}
