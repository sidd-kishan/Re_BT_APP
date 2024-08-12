/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.animation.Animator
 *  android.animation.AnimatorInflater
 *  android.animation.ObjectAnimator
 *  android.animation.StateListAnimator
 *  android.content.Context
 *  android.view.View
 *  android.view.ViewOutlineProvider
 *  com.google.android.material.R$attr
 *  com.google.android.material.R$integer
 *  com.google.android.material.internal.ThemeEnforcement
 */
package com.google.android.material.appbar;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.ObjectAnimator;
import android.animation.StateListAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewOutlineProvider;
import com.google.android.material.R;
import com.google.android.material.internal.ThemeEnforcement;

class ViewUtilsLollipop {
    private static final int[] STATE_LIST_ANIM_ATTRS = new int[]{16843848};

    ViewUtilsLollipop() {
    }

    static void setBoundsViewOutlineProvider(View view) {
        view.setOutlineProvider(ViewOutlineProvider.BOUNDS);
    }

    static void setDefaultAppBarLayoutStateListAnimator(View view, float f) {
        int n = view.getResources().getInteger(R.integer.app_bar_elevation_anim_duration);
        StateListAnimator stateListAnimator = new StateListAnimator();
        int n2 = R.attr.state_liftable;
        int n3 = -R.attr.state_lifted;
        ObjectAnimator objectAnimator = ObjectAnimator.ofFloat((Object)view, (String)"elevation", (float[])new float[]{0.0f});
        long l = n;
        objectAnimator = objectAnimator.setDuration(l);
        stateListAnimator.addState(new int[]{0x101000E, n2, n3}, (Animator)objectAnimator);
        objectAnimator = ObjectAnimator.ofFloat((Object)view, (String)"elevation", (float[])new float[]{f}).setDuration(l);
        stateListAnimator.addState(new int[]{0x101000E}, (Animator)objectAnimator);
        objectAnimator = ObjectAnimator.ofFloat((Object)view, (String)"elevation", (float[])new float[]{0.0f}).setDuration(0L);
        stateListAnimator.addState(new int[0], (Animator)objectAnimator);
        view.setStateListAnimator(stateListAnimator);
    }

    static void setStateListAnimatorFromAttrs(View view, AttributeSet attributeSet, int n, int n2) {
        Context context = view.getContext();
        attributeSet = ThemeEnforcement.obtainStyledAttributes((Context)context, (AttributeSet)attributeSet, (int[])STATE_LIST_ANIM_ATTRS, (int)n, (int)n2, (int[])new int[0]);
        try {
            if (!attributeSet.hasValue(0)) return;
            view.setStateListAnimator(AnimatorInflater.loadStateListAnimator((Context)context, (int)attributeSet.getResourceId(0, 0)));
            return;
        }
        finally {
            attributeSet.recycle();
        }
    }
}
