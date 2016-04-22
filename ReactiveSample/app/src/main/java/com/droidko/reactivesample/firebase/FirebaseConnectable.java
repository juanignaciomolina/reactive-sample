package com.droidko.reactivesample.firebase;

public interface FirebaseConnectable {

    /**
     * Remove listeners for Firebase change events and stop receiving real-time data.
     * It's important to call this method after you are done using a FirebaseConnectable to avoid
     * leaking an open connection to the Firebase server, consuming data & CPU on the client-side
     * and resources server-side (Firebase charges per connected client, so this IS important)
     */
    public void disconnect();

}
