package com.droidko.reactivesample.viewmodels;

import android.content.Context;

import rx.Observable;
import rx.schedulers.Schedulers;

public class HomeViewModel implements BaseViewModel {

    // Vars
    private Context mContext;

    public HomeViewModel(Context context) {
        mContext = context;
    }

    public Observable<String> startFetching() {
        // TODO: 23/4/16 REMOVE THIS MOCKED DATA
        return Observable
                .just(
                "http://res.cloudinary.com/voltfeed/image/upload/c_limit,h_1920,q_90,w_1080/v1443067055/netnh0fzb30ta0823qgr.webp",
                "http://res.cloudinary.com/voltfeed/image/upload/c_limit,h_1920,q_90,w_1080/v1439677894/vbideshn9wvsjgljbmbn.webp",
                "http://res.cloudinary.com/voltfeed/image/upload/c_limit,h_1920,q_90,w_1080/v1439679289/m6l4rxkpjxhzni9dqfq1.webp")
                .observeOn(Schedulers.io());
    }

    @Override
    public void destroy() {

    }
}
