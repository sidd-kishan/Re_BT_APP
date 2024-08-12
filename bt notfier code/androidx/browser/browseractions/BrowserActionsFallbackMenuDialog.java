/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.animation.Animator$AnimatorListener
 *  android.animation.TimeInterpolator
 *  android.app.Dialog
 *  android.content.Context
 *  android.graphics.drawable.ColorDrawable
 *  android.graphics.drawable.Drawable
 *  android.view.MotionEvent
 *  android.view.View
 *  androidx.interpolator.view.animation.LinearOutSlowInInterpolator
 */
package androidx.browser.browseractions;

import android.animation.Animator;
import android.animation.TimeInterpolator;
import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.view.MotionEvent;
import android.view.View;
import androidx.interpolator.view.animation.LinearOutSlowInInterpolator;

class BrowserActionsFallbackMenuDialog
extends Dialog {
    private static final long ENTER_ANIMATION_DURATION_MS = 250L;
    private static final long EXIT_ANIMATION_DURATION_MS = 150L;
    private final View mContentView;

    BrowserActionsFallbackMenuDialog(Context context, View view) {
        super(context);
        this.mContentView = view;
    }

    static /* synthetic */ void access$001(BrowserActionsFallbackMenuDialog browserActionsFallbackMenuDialog) {
        super.dismiss();
    }

    private void startAnimation(boolean bl) {
        float f = 0.0f;
        float f2 = bl ? 0.0f : 1.0f;
        if (bl) {
            f = 1.0f;
        }
        long l = bl ? 250L : 150L;
        this.mContentView.setScaleX(f2);
        this.mContentView.setScaleY(f2);
        this.mContentView.animate().scaleX(f).scaleY(f).setDuration(l).setInterpolator((TimeInterpolator)new LinearOutSlowInInterpolator()).setListener((Animator.AnimatorListener)new /* Unavailable Anonymous Inner Class!! */).start();
    }

    public void dismiss() {
        this.startAnimation(false);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() != 0) return false;
        this.dismiss();
        return true;
    }

    public void show() {
        this.getWindow().setBackgroundDrawable((Drawable)new ColorDrawable(0));
        this.startAnimation(true);
        super.show();
    }
}
