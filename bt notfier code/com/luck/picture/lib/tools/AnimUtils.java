/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.animation.Animator
 *  android.animation.AnimatorSet
 *  android.animation.ObjectAnimator
 *  android.view.View
 *  android.view.animation.Animation
 *  android.view.animation.RotateAnimation
 *  android.widget.ImageView
 */
package com.luck.picture.lib.tools;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;

public class AnimUtils {
    private static final int DURATION = 450;

    public static void disZoom(View view, boolean bl) {
        if (!bl) return;
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(new Animator[]{ObjectAnimator.ofFloat((Object)view, (String)"scaleX", (float[])new float[]{1.12f, 1.0f}), ObjectAnimator.ofFloat((Object)view, (String)"scaleY", (float[])new float[]{1.12f, 1.0f})});
        animatorSet.setDuration(450L);
        animatorSet.start();
    }

    public static void rotateArrow(ImageView imageView, boolean bl) {
        RotateAnimation rotateAnimation = new RotateAnimation(180.0f, 360.0f, (float)imageView.getWidth() / 2.0f, (float)imageView.getHeight() / 2.0f);
        rotateAnimation.setDuration(350L);
        imageView.startAnimation((Animation)rotateAnimation);
    }

    public static void zoom(View view, boolean bl) {
        if (!bl) return;
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(new Animator[]{ObjectAnimator.ofFloat((Object)view, (String)"scaleX", (float[])new float[]{1.0f, 1.12f}), ObjectAnimator.ofFloat((Object)view, (String)"scaleY", (float[])new float[]{1.0f, 1.12f})});
        animatorSet.setDuration(450L);
        animatorSet.start();
    }
}
