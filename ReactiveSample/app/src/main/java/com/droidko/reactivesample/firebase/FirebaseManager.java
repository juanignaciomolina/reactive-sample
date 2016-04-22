package com.droidko.reactivesample.firebase;

import com.droidko.reactivesample.BaseConfiguration;
import com.firebase.client.Firebase;

public abstract class FirebaseManager implements FirebaseConnectable {

    // Constants
    private static final String PATH_USERS = "users";

    // References
    private static final Firebase mRefRoot = new Firebase(BaseConfiguration.FIREBASE_ROOT_URL);
    private static final Firebase mRefUsers = mRefRoot.child(PATH_USERS);

    // ** References accessors **
    public static Firebase getRefRoot() {
        return mRefRoot;
    }

    public static Firebase getRefUsers() {
        return mRefUsers;
    }

}
