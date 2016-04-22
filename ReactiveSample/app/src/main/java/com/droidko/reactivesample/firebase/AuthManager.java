package com.droidko.reactivesample.firebase;

import com.droidko.reactivesample.firebase.events.FirebaseAuthEvent;
import com.firebase.client.AuthData;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;

import rx.Observable;
import rx.Subscriber;
import rx.schedulers.Schedulers;

public class AuthManager extends FirebaseManager {

    /**
     * Detects synchronously if there is a logged user
     *
     * @return A boolean indicating if there is a logged user
     */
    public static boolean isUserLoggedIn() {
        return getRefRoot().getAuth() != null;
    }

    public static Observable<FirebaseAuthEvent> logInAnonymously() {

        return Observable.create(new Observable.OnSubscribe<FirebaseAuthEvent>() {
            @Override
            public void call(final Subscriber<? super FirebaseAuthEvent> subscriber) {
                try {

                    final Firebase.AuthResultHandler listener = new Firebase.AuthResultHandler() {
                        @Override
                        public void onAuthenticated(AuthData authData) {
                            if (!subscriber.isUnsubscribed()) {
                                subscriber.onNext(new FirebaseAuthEvent(authData, null));
                                subscriber.onCompleted();
                            }
                        }

                        @Override
                        public void onAuthenticationError(FirebaseError firebaseError) {
                            if (!subscriber.isUnsubscribed()) {
                                subscriber.onNext(new FirebaseAuthEvent(null, firebaseError));
                                subscriber.onCompleted();
                            }
                        }
                    };

                    getRefRoot().authAnonymously(listener);

                } catch (Exception e) {
                    if (!subscriber.isUnsubscribed()) subscriber.onError(e);
                }
            }
        }).observeOn(Schedulers.io());

    }


    @Override
    public void disconnect() {
        // This manager doesn't keep any connection open to Firebase
    }
}
