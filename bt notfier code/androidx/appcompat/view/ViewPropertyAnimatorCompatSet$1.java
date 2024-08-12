/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.view.View
 *  androidx.appcompat.view.ViewPropertyAnimatorCompatSet
 *  androidx.core.view.ViewPropertyAnimatorListenerAdapter
 */
package androidx.appcompat.view;

import android.view.View;
import androidx.appcompat.view.ViewPropertyAnimatorCompatSet;
import androidx.core.view.ViewPropertyAnimatorListenerAdapter;

class ViewPropertyAnimatorCompatSet.1
extends ViewPropertyAnimatorListenerAdapter {
    private int mProxyEndCount;
    private boolean mProxyStarted;
    final ViewPropertyAnimatorCompatSet this$0;

    ViewPropertyAnimatorCompatSet.1(ViewPropertyAnimatorCompatSet viewPropertyAnimatorCompatSet) {
        this.this$0 = viewPropertyAnimatorCompatSet;
        this.mProxyStarted = false;
        this.mProxyEndCount = 0;
    }

    public void onAnimationEnd(View view) {
        int n;
        this.mProxyEndCount = n = this.mProxyEndCount + 1;
        if (n != this.this$0.mAnimators.size()) return;
        if (this.this$0.mListener != null) {
            this.this$0.mListener.onAnimationEnd(null);
        }
        this.onEnd();
    }

    public void onAnimationStart(View view) {
        if (this.mProxyStarted) {
            return;
        }
        this.mProxyStarted = true;
        if (this.this$0.mListener == null) return;
        this.this$0.mListener.onAnimationStart(null);
    }

    void onEnd() {
        this.mProxyEndCount = 0;
        this.mProxyStarted = false;
        this.this$0.onAnimationsEnded();
    }
}
