/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.view.View
 *  androidx.core.view.ViewCompat
 *  com.google.android.material.behavior.SwipeDismissBehavior
 */
package com.google.android.material.behavior;

import android.view.View;
import androidx.core.view.ViewCompat;
import com.google.android.material.behavior.SwipeDismissBehavior;

private class SwipeDismissBehavior.SettleRunnable
implements Runnable {
    private final boolean dismiss;
    final SwipeDismissBehavior this$0;
    private final View view;

    SwipeDismissBehavior.SettleRunnable(SwipeDismissBehavior swipeDismissBehavior, View view, boolean bl) {
        this.this$0 = swipeDismissBehavior;
        this.view = view;
        this.dismiss = bl;
    }

    @Override
    public void run() {
        if (this.this$0.viewDragHelper != null && this.this$0.viewDragHelper.continueSettling(true)) {
            ViewCompat.postOnAnimation((View)this.view, (Runnable)this);
        } else {
            if (!this.dismiss) return;
            if (this.this$0.listener == null) return;
            this.this$0.listener.onDismiss(this.view);
        }
    }
}
