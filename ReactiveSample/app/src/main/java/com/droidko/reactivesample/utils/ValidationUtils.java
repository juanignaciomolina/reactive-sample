package com.droidko.reactivesample.utils;

import android.text.TextUtils;

public class ValidationUtils {

    public static final int MIN_PASSWORD_LENGTH = 8;

    public static boolean isValidEmail(CharSequence target) {
        return !TextUtils.isEmpty(target) &&
                android.util.Patterns.EMAIL_ADDRESS.matcher(target).matches();
    }

    public static boolean isValidPassword(String target) {
        if (TextUtils.isEmpty(target)) return false;
        String trimmedPassword = target.trim();
        return trimmedPassword.length() >= MIN_PASSWORD_LENGTH;
    }

}
