/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.animation.Animator
 *  android.animation.Animator$AnimatorListener
 *  android.graphics.drawable.Drawable
 *  android.view.View
 *  com.qmuiteam.qmui.util.QMUIViewHelper
 */
package com.qmuiteam.qmui.util;

import android.animation.Animator;
import android.graphics.drawable.Drawable;
import android.view.View;
import com.qmuiteam.qmui.util.QMUIViewHelper;

/*
 * Exception performing whole class analysis ignored.
 */
static final class QMUIViewHelper.2
implements Animator.AnimatorListener {
    final Runnable val$endAction;
    final Drawable val$oldBgDrawable;
    final View val$v;

    QMUIViewHelper.2(View view, Drawable drawable, Runnable runnable) {
        this.val$v = view;
        this.val$oldBgDrawable = drawable;
        this.val$endAction = runnable;
    }

    public void onAnimationCancel(Animator animator) {
    }

    public void onAnimationEnd(Animator object) {
        QMUIViewHelper.setBackgroundKeepingPadding((View)this.val$v, (Drawable)this.val$oldBgDrawable);
        object = this.val$endAction;
        if (object == null) return;
        object.run();
    }

    public void onAnimationRepeat(Animator animator) {
    }

    public void onAnimationStart(Animator animator) {
    }
}
