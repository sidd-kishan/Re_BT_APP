/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.view.View
 *  androidx.appcompat.widget.AbsActionBarView
 *  androidx.core.view.ViewPropertyAnimatorCompat
 *  androidx.core.view.ViewPropertyAnimatorListener
 */
package androidx.appcompat.widget;

import android.view.View;
import androidx.appcompat.widget.AbsActionBarView;
import androidx.core.view.ViewPropertyAnimatorCompat;
import androidx.core.view.ViewPropertyAnimatorListener;

/*
 * Exception performing whole class analysis ignored.
 */
protected class AbsActionBarView.VisibilityAnimListener
implements ViewPropertyAnimatorListener {
    private boolean mCanceled;
    int mFinalVisibility;
    final AbsActionBarView this$0;

    protected AbsActionBarView.VisibilityAnimListener(AbsActionBarView absActionBarView) {
        this.this$0 = absActionBarView;
        this.mCanceled = false;
    }

    public void onAnimationCancel(View view) {
        this.mCanceled = true;
    }

    public void onAnimationEnd(View view) {
        if (this.mCanceled) {
            return;
        }
        this.this$0.mVisibilityAnim = null;
        AbsActionBarView.access$101((AbsActionBarView)this.this$0, (int)this.mFinalVisibility);
    }

    public void onAnimationStart(View view) {
        AbsActionBarView.access$001((AbsActionBarView)this.this$0, (int)0);
        this.mCanceled = false;
    }

    public AbsActionBarView.VisibilityAnimListener withFinalVisibility(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, int n) {
        this.this$0.mVisibilityAnim = viewPropertyAnimatorCompat;
        this.mFinalVisibility = n;
        return this;
    }
}
