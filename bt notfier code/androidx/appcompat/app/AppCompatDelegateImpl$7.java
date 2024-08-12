/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.view.View
 *  androidx.appcompat.app.AppCompatDelegateImpl
 *  androidx.core.view.ViewCompat
 *  androidx.core.view.ViewPropertyAnimatorListenerAdapter
 */
package androidx.appcompat.app;

import android.view.View;
import androidx.appcompat.app.AppCompatDelegateImpl;
import androidx.core.view.ViewCompat;
import androidx.core.view.ViewPropertyAnimatorListenerAdapter;

class AppCompatDelegateImpl.7
extends ViewPropertyAnimatorListenerAdapter {
    final AppCompatDelegateImpl this$0;

    AppCompatDelegateImpl.7(AppCompatDelegateImpl appCompatDelegateImpl) {
        this.this$0 = appCompatDelegateImpl;
    }

    public void onAnimationEnd(View view) {
        this.this$0.mActionModeView.setAlpha(1.0f);
        this.this$0.mFadeAnim.setListener(null);
        this.this$0.mFadeAnim = null;
    }

    public void onAnimationStart(View view) {
        this.this$0.mActionModeView.setVisibility(0);
        this.this$0.mActionModeView.sendAccessibilityEvent(32);
        if (!(this.this$0.mActionModeView.getParent() instanceof View)) return;
        ViewCompat.requestApplyInsets((View)((View)this.this$0.mActionModeView.getParent()));
    }
}
