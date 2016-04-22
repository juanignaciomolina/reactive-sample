package com.droidko.reactivesample.viewmodels;

public interface BaseViewModel {

    /**
     * This method should be called whenever you are done using the ViewModel and should
     * contain some code cleanup logic
     */
    void destroy();
}
