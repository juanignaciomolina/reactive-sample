package com.droidko.reactivesample.firebase;

import com.droidko.reactivesample.BaseConfiguration;
import com.droidko.reactivesample.firebase.events.FirebaseAuthEvent;
import com.droidko.reactivesample.models.User;
import com.firebase.client.AuthData;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;

import rx.Observable;
import rx.Subscriber;
import rx.schedulers.Schedulers;

public class FirebaseManager {

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

    // ** Util methods **

    /**
     * Util method to create a new user on Firebase
     *
     * @param userToCreate An instance of User to be stored in the DB
     * @param fbcl A Firebase.CompletionListener with a callback of the operation
     * @return A String with the ID of the new user in the DB
     */
    public static String createNewUser(User userToCreate, Firebase.CompletionListener fbcl) {
        Firebase newUserRef = getRefUsers().push();
        newUserRef.setValue(userToCreate, fbcl);
        return newUserRef.getKey();
    }

    // ** Auth methods **

    /**
     * Detects synchronously if there is a logged user
     *
     * @return A boolean indicating if there is a logged user
     */
    public static boolean isUserLoggedIn() {
        return getRefRoot().getAuth() != null;
    }

    public static Observable<FirebaseAuthEvent> logInWithEmail(final String email,
                                                               final String password) {

        return Observable.create(new Observable.OnSubscribe<FirebaseAuthEvent>() {
            @Override
            public void call(final Subscriber<? super FirebaseAuthEvent> subscriber) {
                try {

                    final Firebase.AuthResultHandler listener = new Firebase.AuthResultHandler() {
                        @Override
                        public void onAuthenticated(AuthData authData) {
                            if (!subscriber.isUnsubscribed())
                                subscriber.onNext(new FirebaseAuthEvent(authData, null));
                            else
                                getRefRoot().removeAuthStateListener();
                        }

                        @Override
                        public void onAuthenticationError(FirebaseError firebaseError) {
                            subscriber.onNext(new FirebaseAuthEvent(null, firebaseError));
                        }
                    };

                    getRefRoot().authWithPassword(email, password, listener);

                } catch (Exception e) {
                    subscriber.onError(e);
                }
            }
        }).observeOn(Schedulers.io());

    }

}
