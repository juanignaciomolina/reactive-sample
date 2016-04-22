package com.droidko.reactivesample.viewmodels;

import android.content.Context;

import com.droidko.reactivesample.firebase.AuthManager;
import com.droidko.reactivesample.firebase.events.FirebaseAuthEvent;

import rx.Subscriber;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;

public class LoginViewModel implements BaseViewModel {

    // Vars
    private Context mContext;
    private Subscription mAuthSubscription;

    public LoginViewModel(Context context) {
        mContext = context;
    }

    public void onClickStart() {
        doAnonymousLogin();
    }

    private void doAnonymousLogin() {
        mAuthSubscription = AuthManager
                .logInAnonymously()
                .subscribeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<FirebaseAuthEvent>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(FirebaseAuthEvent firebaseAuthEvent) {
                        // Do something on login...
                    }
                });
    }

    @Override
    public void destroy() {
        if (mAuthSubscription != null && !mAuthSubscription.isUnsubscribed())
            mAuthSubscription.unsubscribe();
    }
}
