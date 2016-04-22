package com.droidko.reactivesample.views.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public abstract class BaseFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        return inflater.inflate(onLayoutRequested(), container, false);
    }

    /**
     * Provides a method for a sub class to choose which layout should be loaded in this fragment
     *
     * @return A layout's XML id (e.g: R.layout.example_layout)
     */
    protected abstract int onLayoutRequested();

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        onInitialize(view);
        onDataBinding(view);
        onPrepareUi(view);
    }

    /**
     * Lifecycle callback for fragment initialization
     */
    protected void onInitialize(View rootView) { };

    /**
     * Lifecycle callback for getting a reference of the DatBinding generated class
     */
    protected void onDataBinding(View rootView) { };

    /**
     * Lifecycle callback for making modifications on the UI after the initialization and the
     * DataBinding are both complete
     */
    protected void onPrepareUi(View rootView) { };

}
