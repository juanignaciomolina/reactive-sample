package com.droidko.reactivesample.firebase.events;

import com.firebase.client.AuthData;
import com.firebase.client.FirebaseError;

public class FirebaseAuthEvent {

    private AuthData mAuthData;
    private FirebaseError mFirebaseError;

    public FirebaseAuthEvent(AuthData authData, FirebaseError firebaseError) {
        mAuthData = authData;
        mFirebaseError = firebaseError;
    }

    public AuthData getAuthData() {
        return mAuthData;
    }

    public FirebaseError getFirebaseError() {
        return mFirebaseError;
    }
}
