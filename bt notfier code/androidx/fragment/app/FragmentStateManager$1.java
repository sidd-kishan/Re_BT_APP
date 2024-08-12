/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.view.View
 *  android.view.View$OnAttachStateChangeListener
 *  androidx.core.view.ViewCompat
 *  androidx.fragment.app.FragmentStateManager
 */
package androidx.fragment.app;

import android.view.View;
import androidx.core.view.ViewCompat;
import androidx.fragment.app.FragmentStateManager;

class FragmentStateManager.1
implements View.OnAttachStateChangeListener {
    final FragmentStateManager this$0;
    final View val$fragmentView;

    FragmentStateManager.1(FragmentStateManager fragmentStateManager, View view) {
        this.this$0 = fragmentStateManager;
        this.val$fragmentView = view;
    }

    public void onViewAttachedToWindow(View view) {
        this.val$fragmentView.removeOnAttachStateChangeListener((View.OnAttachStateChangeListener)this);
        ViewCompat.requestApplyInsets((View)this.val$fragmentView);
    }

    public void onViewDetachedFromWindow(View view) {
    }
}
