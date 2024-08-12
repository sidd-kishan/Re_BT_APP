/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.view.View
 *  androidx.core.view.ViewCompat
 *  com.google.android.material.bottomsheet.BottomSheetBehavior
 */
package com.google.android.material.bottomsheet;

import android.view.View;
import androidx.core.view.ViewCompat;
import com.google.android.material.bottomsheet.BottomSheetBehavior;

private class BottomSheetBehavior.SettleRunnable
implements Runnable {
    private final int targetState;
    final BottomSheetBehavior this$0;
    private final View view;

    BottomSheetBehavior.SettleRunnable(BottomSheetBehavior bottomSheetBehavior, View view, int n) {
        this.this$0 = bottomSheetBehavior;
        this.view = view;
        this.targetState = n;
    }

    @Override
    public void run() {
        if (this.this$0.viewDragHelper != null && this.this$0.viewDragHelper.continueSettling(true)) {
            ViewCompat.postOnAnimation((View)this.view, (Runnable)this);
        } else {
            this.this$0.setStateInternal(this.targetState);
        }
    }
}
