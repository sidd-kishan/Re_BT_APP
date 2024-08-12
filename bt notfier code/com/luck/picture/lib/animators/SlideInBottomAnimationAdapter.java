/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.animation.Animator
 *  android.animation.ObjectAnimator
 *  android.view.View
 *  androidx.recyclerview.widget.RecyclerView$Adapter
 *  com.luck.picture.lib.animators.BaseAnimationAdapter
 */
package com.luck.picture.lib.animators;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.luck.picture.lib.animators.BaseAnimationAdapter;

public class SlideInBottomAnimationAdapter
extends BaseAnimationAdapter {
    public SlideInBottomAnimationAdapter(RecyclerView.Adapter adapter) {
        super(adapter);
    }

    protected Animator[] getAnimators(View view) {
        return new Animator[]{ObjectAnimator.ofFloat((Object)view, (String)"translationY", (float[])new float[]{view.getMeasuredHeight(), 0.0f})};
    }
}
