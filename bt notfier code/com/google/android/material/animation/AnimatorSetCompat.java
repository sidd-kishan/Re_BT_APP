/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.animation.Animator
 *  android.animation.AnimatorSet
 *  android.animation.ValueAnimator
 */
package com.google.android.material.animation;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import java.util.List;

public class AnimatorSetCompat {
    public static void playTogether(AnimatorSet animatorSet, List<Animator> list) {
        int n = list.size();
        long l = 0L;
        int n2 = 0;
        while (true) {
            Animator animator;
            if (n2 >= n) {
                animator = ValueAnimator.ofInt((int[])new int[]{0, 0});
                animator.setDuration(l);
                list.add(0, animator);
                animatorSet.playTogether(list);
                return;
            }
            animator = list.get(n2);
            l = Math.max(l, animator.getStartDelay() + animator.getDuration());
            ++n2;
        }
    }
}
