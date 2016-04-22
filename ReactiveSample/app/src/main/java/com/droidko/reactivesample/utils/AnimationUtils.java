package com.droidko.reactivesample.utils;


import android.view.View;

public class AnimationUtils {

    public static void setCyclicBackgroundColor(View targetView) {

        /*Resources res = ReactiveApplication.getInstance().getResources();

        ArrayList<Integer> colorsList = new ArrayList<>();

        colorsList.add(R.color.red);
        colorsList.add(R.color.blue);
        colorsList.add(R.color.yellow);
        colorsList.add(R.color.emerald);

        AnimationSet animationSet = new AnimationSet()

        while (colorsList.iterator().hasNext()) {

        }

        int colorFrom = getResources().getColor(R.color.red);
        int colorTo = getResources().getColor(R.color.blue);

        ValueAnimator colorAnimation = ValueAnimator.ofObject(new ArgbEvaluator(), colorFrom, colorTo);
        colorAnimation.setDuration(5000); // milliseconds
        colorAnimation.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {

            @Override
            public void onAnimationUpdate(ValueAnimator animator) {
                targetView.setBackgroundColor((int) animator.getAnimatedValue());
            }

        });
        colorAnimation.start();*/
    }

}
