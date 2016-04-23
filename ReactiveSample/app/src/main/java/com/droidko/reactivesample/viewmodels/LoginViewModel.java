package com.droidko.reactivesample.viewmodels;

import android.content.Context;
import android.databinding.ObservableField;
import android.databinding.ObservableInt;
import android.util.Log;
import android.view.View;

import com.droidko.reactivesample.R;
import com.droidko.reactivesample.firebase.AuthManager;
import com.droidko.reactivesample.firebase.events.FirebaseAuthEvent;

import rx.Subscriber;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;

public class LoginViewModel implements BaseViewModel {

    // Constants
    private static final String TAG = "LoginVM";

    // Vars
    private Context mContext;
    private Subscription mAuthSubscription;

    // Observable fields
    public ObservableInt mLoadingVisibility;
    public ObservableField<String> mDoneMessage;

    public LoginViewModel(Context context) {
        mContext = context;

        mLoadingVisibility = new ObservableInt(View.INVISIBLE);
        mDoneMessage = new ObservableField<>(mContext.getString(R.string.login_loading));
    }

    public void onClickStart(View view) {
        doAnonymousLogin();
    }

    private void doAnonymousLogin() {

        mLoadingVisibility.set(View.VISIBLE);

        mAuthSubscription = AuthManager
                .logInAnonymously()
                .subscribeOn(AndroidSchedulers.mainThread()) //Probably redundant
                .subscribe(new Subscriber<FirebaseAuthEvent>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        mDoneMessage.set(mContext.getString(R.string.login_message_error));
                        Log.e(TAG, "Auth fail: " + e);
                    }

                    @Override
                    public void onNext(FirebaseAuthEvent firebaseAuthEvent) {
                        if (firebaseAuthEvent.getFirebaseError() != null) {
                            mDoneMessage.set(mContext.getString(R.string.login_message_error));
                            Log.e(TAG, "Auth fail: " + firebaseAuthEvent.getFirebaseError());
                        }
                        else
                            mDoneMessage.set(mContext.getString(R.string.login_message_successful));
                    }
                });
    }

    @Override
    public void destroy() {
        if (mAuthSubscription != null && !mAuthSubscription.isUnsubscribed())
            mAuthSubscription.unsubscribe();
    }
}
