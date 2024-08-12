/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.view.View
 *  androidx.appcompat.app.AppCompatDelegateImpl$ActionModeCallbackWrapperV9
 *  androidx.core.view.ViewCompat
 *  androidx.core.view.ViewPropertyAnimatorListenerAdapter
 */
package androidx.appcompat.app;

import android.view.View;
import androidx.appcompat.app.AppCompatDelegateImpl;
import androidx.core.view.ViewCompat;
import androidx.core.view.ViewPropertyAnimatorListenerAdapter;

class AppCompatDelegateImpl.ActionModeCallbackWrapperV9.1
extends ViewPropertyAnimatorListenerAdapter {
    final AppCompatDelegateImpl.ActionModeCallbackWrapperV9 this$1;

    AppCompatDelegateImpl.ActionModeCallbackWrapperV9.1(AppCompatDelegateImpl.ActionModeCallbackWrapperV9 actionModeCallbackWrapperV9) {
        this.this$1 = actionModeCallbackWrapperV9;
    }

    public void onAnimationEnd(View view) {
        this.this$1.this$0.mActionModeView.setVisibility(8);
        if (this.this$1.this$0.mActionModePopup != null) {
            this.this$1.this$0.mActionModePopup.dismiss();
        } else if (this.this$1.this$0.mActionModeView.getParent() instanceof View) {
            ViewCompat.requestApplyInsets((View)((View)this.this$1.this$0.mActionModeView.getParent()));
        }
        this.this$1.this$0.mActionModeView.killMode();
        this.this$1.this$0.mFadeAnim.setListener(null);
        this.this$1.this$0.mFadeAnim = null;
        ViewCompat.requestApplyInsets((View)this.this$1.this$0.mSubDecor);
    }
}
