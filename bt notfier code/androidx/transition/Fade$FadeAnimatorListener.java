/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.animation.Animator
 *  android.animation.AnimatorListenerAdapter
 *  android.view.View
 *  androidx.core.view.ViewCompat
 *  androidx.transition.ViewUtils
 */
package androidx.transition;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import androidx.core.view.ViewCompat;
import androidx.transition.ViewUtils;

private static class Fade.FadeAnimatorListener
extends AnimatorListenerAdapter {
    private boolean mLayerTypeChanged = false;
    private final View mView;

    Fade.FadeAnimatorListener(View view) {
        this.mView = view;
    }

    public void onAnimationEnd(Animator animator) {
        ViewUtils.setTransitionAlpha((View)this.mView, (float)1.0f);
        if (!this.mLayerTypeChanged) return;
        this.mView.setLayerType(0, null);
    }

    public void onAnimationStart(Animator animator) {
        if (!ViewCompat.hasOverlappingRendering((View)this.mView)) return;
        if (this.mView.getLayerType() != 0) return;
        this.mLayerTypeChanged = true;
        this.mView.setLayerType(2, null);
    }
}
