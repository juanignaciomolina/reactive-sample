package com.droidko.reactivesample.utils;


import android.animation.ValueAnimator;
import android.support.v4.graphics.ColorUtils;
import android.view.View;

import java.util.Random;

public class AnimationUtils {


    public static ValueAnimator setAdvancedCyclicBackgroundColor(View targetView) {

        ValueAnimator anim = ValueAnimator.ofFloat(0, 1);   // animate from 0 to 1
        anim.setDuration(36000);

        final float[] hsl  = new float[3];                  // transition color

        final float lightness_min = 0.25f;
        final float lightness_max = 0.75f;

        final Random random = new Random();

        hsl[0] = 0.0f; // Initial Hue at 0 degrees
        hsl[1] = 1.0f; // 100% of Saturation
        hsl[2] = 0.5f; // 50% of Lightness as an initial value (new values will be generated randomly)

        anim.addUpdateListener(new ValueAnimator.AnimatorUpdateListener(){
            @Override public void onAnimationUpdate(ValueAnimator animation) {
                if (animation.getAnimatedFraction() == 0 )
                    hsl[2] = random.nextFloat() * (lightness_max - lightness_min) + lightness_min;
                hsl[0] = 360 * animation.getAnimatedFraction();
                targetView.setBackgroundColor(ColorUtils.HSLToColor(hsl));
            }
        });

        anim.setRepeatCount(ValueAnimator.INFINITE);
        anim.setRepeatMode(ValueAnimator.REVERSE);
        return anim;
    }

}
