/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.view.View
 *  androidx.appcompat.app.AppCompatDelegateImpl$6
 *  androidx.core.view.ViewPropertyAnimatorListenerAdapter
 */
package androidx.appcompat.app;

import android.view.View;
import androidx.appcompat.app.AppCompatDelegateImpl;
import androidx.core.view.ViewPropertyAnimatorListenerAdapter;

class AppCompatDelegateImpl.1
extends ViewPropertyAnimatorListenerAdapter {
    final AppCompatDelegateImpl.6 this$1;

    AppCompatDelegateImpl.1(AppCompatDelegateImpl.6 var1_1) {
        this.this$1 = var1_1;
    }

    public void onAnimationEnd(View view) {
        this.this$1.this$0.mActionModeView.setAlpha(1.0f);
        this.this$1.this$0.mFadeAnim.setListener(null);
        this.this$1.this$0.mFadeAnim = null;
    }

    public void onAnimationStart(View view) {
        this.this$1.this$0.mActionModeView.setVisibility(0);
    }
}
