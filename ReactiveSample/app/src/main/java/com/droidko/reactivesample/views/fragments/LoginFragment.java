package com.droidko.reactivesample.views.fragments;

import android.animation.ValueAnimator;
import android.databinding.DataBindingUtil;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;

import com.droidko.reactivesample.R;
import com.droidko.reactivesample.databinding.FragmentLoginBinding;
import com.droidko.reactivesample.viewmodels.LoginViewModel;

public class LoginFragment extends BaseFragment {

    // Vars
    private FragmentLoginBinding mBinding;
    private LoginViewModel mViewModel;

    public static LoginFragment newInstance() {

        Bundle args = new Bundle();

        LoginFragment fragment = new LoginFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    protected int onLayoutRequested() {
        return R.layout.fragment_login;
    }

    @Override
    protected void onInitialize(View rootView) {
        mViewModel = new LoginViewModel(getContext());
    }

    @Override
    protected void onDataBinding(View rootView) {
        mBinding = DataBindingUtil.setContentView(getActivity(), R.layout.fragment_login);

        mBinding.setViewModel(mViewModel);
    }

    @Override
    protected void onPrepareUi(View rootView) {
        startBackgroundColorChange();
    }

    private void startBackgroundColorChange() {
        ValueAnimator anim = ValueAnimator.ofFloat(0, 1);   // animate from 0 to 1
        anim.setDuration(36000);

        final float[] hsv  = new float[3];                  // transition color

        hsv[0] = 0; // Initial Hue at 0 degrees
        hsv[1] = 191; // 75% of Saturation
        hsv[2] = 191; // 75% of Value

        anim.addUpdateListener(new ValueAnimator.AnimatorUpdateListener(){
            @Override public void onAnimationUpdate(ValueAnimator animation) {
                hsv[0] = 255 * animation.getAnimatedFraction();
                mBinding.rootLayout.setBackgroundColor(Color.HSVToColor(hsv));
            }
        });

        anim.setRepeatCount(ValueAnimator.INFINITE);
        anim.setRepeatMode(ValueAnimator.REVERSE);
        anim.start();
    }
}
