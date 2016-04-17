package com.droidko.reactivesample.fragments;

import android.os.Bundle;

import com.droidko.reactivesample.R;

public class HomeFragment extends  BaseFragment {

    public static HomeFragment newInstance() {
        
        Bundle args = new Bundle();
        
        HomeFragment fragment = new HomeFragment();
        fragment.setArguments(args);
        return fragment;
    }
    
    @Override
    protected int onLayoutRequested() {
        return R.layout.fragment_home;
    }
    
}
