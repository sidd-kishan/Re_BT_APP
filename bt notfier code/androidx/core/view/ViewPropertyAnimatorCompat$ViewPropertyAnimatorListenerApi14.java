/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Build$VERSION
 *  android.view.View
 *  androidx.core.view.ViewPropertyAnimatorCompat
 *  androidx.core.view.ViewPropertyAnimatorListener
 */
package androidx.core.view;

import android.os.Build;
import android.view.View;
import androidx.core.view.ViewPropertyAnimatorCompat;
import androidx.core.view.ViewPropertyAnimatorListener;

static class ViewPropertyAnimatorCompat.ViewPropertyAnimatorListenerApi14
implements ViewPropertyAnimatorListener {
    boolean mAnimEndCalled;
    ViewPropertyAnimatorCompat mVpa;

    ViewPropertyAnimatorCompat.ViewPropertyAnimatorListenerApi14(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat) {
        this.mVpa = viewPropertyAnimatorCompat;
    }

    public void onAnimationCancel(View view) {
        Object object = view.getTag(0x7E000000);
        object = object instanceof ViewPropertyAnimatorListener ? (ViewPropertyAnimatorListener)object : null;
        if (object == null) return;
        object.onAnimationCancel(view);
    }

    public void onAnimationEnd(View view) {
        Object object;
        int n = this.mVpa.mOldLayerType;
        ViewPropertyAnimatorListener viewPropertyAnimatorListener = null;
        if (n > -1) {
            view.setLayerType(this.mVpa.mOldLayerType, null);
            this.mVpa.mOldLayerType = -1;
        }
        if (Build.VERSION.SDK_INT < 16) {
            if (this.mAnimEndCalled) return;
        }
        if (this.mVpa.mEndAction != null) {
            object = this.mVpa.mEndAction;
            this.mVpa.mEndAction = null;
            object.run();
        }
        if ((object = view.getTag(0x7E000000)) instanceof ViewPropertyAnimatorListener) {
            viewPropertyAnimatorListener = (ViewPropertyAnimatorListener)object;
        }
        if (viewPropertyAnimatorListener != null) {
            viewPropertyAnimatorListener.onAnimationEnd(view);
        }
        this.mAnimEndCalled = true;
    }

    public void onAnimationStart(View view) {
        Object object;
        this.mAnimEndCalled = false;
        int n = this.mVpa.mOldLayerType;
        ViewPropertyAnimatorListener viewPropertyAnimatorListener = null;
        if (n > -1) {
            view.setLayerType(2, null);
        }
        if (this.mVpa.mStartAction != null) {
            object = this.mVpa.mStartAction;
            this.mVpa.mStartAction = null;
            object.run();
        }
        if ((object = view.getTag(0x7E000000)) instanceof ViewPropertyAnimatorListener) {
            viewPropertyAnimatorListener = (ViewPropertyAnimatorListener)object;
        }
        if (viewPropertyAnimatorListener == null) return;
        viewPropertyAnimatorListener.onAnimationStart(view);
    }
}
