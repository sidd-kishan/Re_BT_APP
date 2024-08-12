/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.view.View
 *  androidx.appcompat.app.AppCompatDelegateImpl
 *  androidx.core.view.ViewCompat
 *  androidx.core.view.ViewPropertyAnimatorListener
 */
package androidx.appcompat.app;

import android.view.View;
import androidx.appcompat.app.AppCompatDelegateImpl;
import androidx.core.view.ViewCompat;
import androidx.core.view.ViewPropertyAnimatorListener;

class AppCompatDelegateImpl.6
implements Runnable {
    final AppCompatDelegateImpl this$0;

    AppCompatDelegateImpl.6(AppCompatDelegateImpl appCompatDelegateImpl) {
        this.this$0 = appCompatDelegateImpl;
    }

    @Override
    public void run() {
        this.this$0.mActionModePopup.showAtLocation((View)this.this$0.mActionModeView, 55, 0, 0);
        this.this$0.endOnGoingFadeAnimation();
        if (this.this$0.shouldAnimateActionModeView()) {
            this.this$0.mActionModeView.setAlpha(0.0f);
            AppCompatDelegateImpl appCompatDelegateImpl = this.this$0;
            appCompatDelegateImpl.mFadeAnim = ViewCompat.animate((View)appCompatDelegateImpl.mActionModeView).alpha(1.0f);
            this.this$0.mFadeAnim.setListener((ViewPropertyAnimatorListener)new /* Unavailable Anonymous Inner Class!! */);
        } else {
            this.this$0.mActionModeView.setAlpha(1.0f);
            this.this$0.mActionModeView.setVisibility(0);
        }
    }
}
