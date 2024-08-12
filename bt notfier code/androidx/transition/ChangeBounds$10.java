/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.animation.Animator
 *  android.animation.AnimatorListenerAdapter
 *  android.graphics.drawable.BitmapDrawable
 *  android.graphics.drawable.Drawable
 *  android.view.View
 *  android.view.ViewGroup
 *  androidx.transition.ChangeBounds
 *  androidx.transition.ViewUtils
 */
package androidx.transition;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import androidx.transition.ChangeBounds;
import androidx.transition.ViewUtils;

class ChangeBounds.10
extends AnimatorListenerAdapter {
    final ChangeBounds this$0;
    final BitmapDrawable val$drawable;
    final ViewGroup val$sceneRoot;
    final float val$transitionAlpha;
    final View val$view;

    ChangeBounds.10(ChangeBounds changeBounds, ViewGroup viewGroup, BitmapDrawable bitmapDrawable, View view, float f) {
        this.this$0 = changeBounds;
        this.val$sceneRoot = viewGroup;
        this.val$drawable = bitmapDrawable;
        this.val$view = view;
        this.val$transitionAlpha = f;
    }

    public void onAnimationEnd(Animator animator) {
        ViewUtils.getOverlay((View)this.val$sceneRoot).remove((Drawable)this.val$drawable);
        ViewUtils.setTransitionAlpha((View)this.val$view, (float)this.val$transitionAlpha);
    }
}
