/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.view.View
 *  com.google.android.material.bottomsheet.BottomSheetBehavior
 */
package com.google.android.material.bottomsheet;

import android.view.View;
import com.google.android.material.bottomsheet.BottomSheetBehavior;

class BottomSheetBehavior.1
implements Runnable {
    final BottomSheetBehavior this$0;
    final View val$child;
    final int val$finalState;

    BottomSheetBehavior.1(BottomSheetBehavior bottomSheetBehavior, View view, int n) {
        this.this$0 = bottomSheetBehavior;
        this.val$child = view;
        this.val$finalState = n;
    }

    @Override
    public void run() {
        this.this$0.startSettlingAnimation(this.val$child, this.val$finalState);
    }
}
