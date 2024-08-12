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

public class AlphaInAnimationAdapter
extends BaseAnimationAdapter {
    private static final float DEFAULT_ALPHA_FROM = 0.0f;
    private final float mFrom;

    public AlphaInAnimationAdapter(RecyclerView.Adapter adapter) {
        this(adapter, 0.0f);
    }

    public AlphaInAnimationAdapter(RecyclerView.Adapter adapter, float f) {
        super(adapter);
        this.mFrom = f;
    }

    protected Animator[] getAnimators(View view) {
        return new Animator[]{ObjectAnimator.ofFloat((Object)view, (String)"alpha", (float[])new float[]{this.mFrom, 1.0f})};
    }
}
