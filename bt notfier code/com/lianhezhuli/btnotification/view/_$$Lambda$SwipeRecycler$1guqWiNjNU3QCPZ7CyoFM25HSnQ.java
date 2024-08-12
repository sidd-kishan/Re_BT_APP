/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.animation.ValueAnimator
 *  android.animation.ValueAnimator$AnimatorUpdateListener
 *  android.view.View
 *  com.lianhezhuli.btnotification.view.SwipeRecycler
 */
package com.lianhezhuli.btnotification.view;

import android.animation.ValueAnimator;
import android.view.View;
import com.lianhezhuli.btnotification.view.SwipeRecycler;

public final class _$$Lambda$SwipeRecycler$1guqWiNjNU3QCPZ7CyoFM25HSnQ
implements ValueAnimator.AnimatorUpdateListener {
    private final SwipeRecycler f$0;
    private final View f$1;

    public /* synthetic */ _$$Lambda$SwipeRecycler$1guqWiNjNU3QCPZ7CyoFM25HSnQ(SwipeRecycler swipeRecycler, View view) {
        this.f$0 = swipeRecycler;
        this.f$1 = view;
    }

    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        this.f$0.lambda$playBack$0$SwipeRecycler(this.f$1, valueAnimator);
    }
}
