package com.droidko.reactivesample.utils;


import android.animation.ValueAnimator;
import android.support.v4.graphics.ColorUtils;
import android.view.View;

import java.util.Random;

public class Colorify {

    // Constants
    public static final float HUE_MIN = 0.0f;
    public static final float HUE_MAX = 360.0f;
    public static final float LIGHTNESS_MIN = 0.25f;
    public static final float LIGHTNESS_MAX = 0.75f;

    public static ValueAnimator setCyclicBackgroundColor(View targetView) {

        ValueAnimator anim = ValueAnimator.ofFloat(0, 1);   // animate from 0 to 1
        anim.setDuration(36000);

        final float[] hsl  = new float[3];                  // transition color

        final Random random = new Random();

        hsl[0] = 0.0f; // Initial Hue at 0 degrees
        hsl[1] = 1.0f; // 100% of Saturation
        hsl[2] = 0.5f; // 50% of Lightness as an initial value (new values will be generated randomly)

        anim.addUpdateListener(new ValueAnimator.AnimatorUpdateListener(){
            @Override public void onAnimationUpdate(ValueAnimator animation) {
                if (animation.getAnimatedFraction() == 0 )
                    hsl[2] = random.nextFloat() * (LIGHTNESS_MAX - LIGHTNESS_MIN) + LIGHTNESS_MIN;
                hsl[0] = HUE_MAX * animation.getAnimatedFraction();
                targetView.setBackgroundColor(ColorUtils.HSLToColor(hsl));
            }
        });

        anim.setRepeatCount(ValueAnimator.INFINITE);
        anim.setRepeatMode(ValueAnimator.REVERSE);
        return anim;
    }

    public static int getRandomColor() {
        final float[] hsl  = new float[3];
        final Random random = new Random();

        // Random value for hue
        hsl[0] = random.nextFloat() * (HUE_MAX - HUE_MIN) + HUE_MIN;

        // 100% of Saturation
        hsl[1] = 1.0f;

        // Random value for lightness
        hsl[2] = random.nextFloat() * (LIGHTNESS_MAX - LIGHTNESS_MIN) + LIGHTNESS_MIN;

        return ColorUtils.HSLToColor(hsl);
    }

}
