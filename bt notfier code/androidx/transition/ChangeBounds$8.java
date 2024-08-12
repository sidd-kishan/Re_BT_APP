/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.animation.Animator
 *  android.animation.AnimatorListenerAdapter
 *  android.graphics.Rect
 *  android.view.View
 *  androidx.core.view.ViewCompat
 *  androidx.transition.ChangeBounds
 *  androidx.transition.ViewUtils
 */
package androidx.transition;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.graphics.Rect;
import android.view.View;
import androidx.core.view.ViewCompat;
import androidx.transition.ChangeBounds;
import androidx.transition.ViewUtils;

class ChangeBounds.8
extends AnimatorListenerAdapter {
    private boolean mIsCanceled;
    final ChangeBounds this$0;
    final int val$endBottom;
    final int val$endLeft;
    final int val$endRight;
    final int val$endTop;
    final Rect val$finalClip;
    final View val$view;

    ChangeBounds.8(ChangeBounds changeBounds, View view, Rect rect, int n, int n2, int n3, int n4) {
        this.this$0 = changeBounds;
        this.val$view = view;
        this.val$finalClip = rect;
        this.val$endLeft = n;
        this.val$endTop = n2;
        this.val$endRight = n3;
        this.val$endBottom = n4;
    }

    public void onAnimationCancel(Animator animator) {
        this.mIsCanceled = true;
    }

    public void onAnimationEnd(Animator animator) {
        if (this.mIsCanceled) return;
        ViewCompat.setClipBounds((View)this.val$view, (Rect)this.val$finalClip);
        ViewUtils.setLeftTopRightBottom((View)this.val$view, (int)this.val$endLeft, (int)this.val$endTop, (int)this.val$endRight, (int)this.val$endBottom);
    }
}
