/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.view.View
 *  com.google.android.material.snackbar.BaseTransientBottomBar
 *  com.google.android.material.snackbar.BaseTransientBottomBar$OnLayoutChangeListener
 */
package com.google.android.material.snackbar;

import android.view.View;
import com.google.android.material.snackbar.BaseTransientBottomBar;

class BaseTransientBottomBar.7
implements BaseTransientBottomBar.OnLayoutChangeListener {
    final BaseTransientBottomBar this$0;

    BaseTransientBottomBar.7(BaseTransientBottomBar baseTransientBottomBar) {
        this.this$0 = baseTransientBottomBar;
    }

    public void onLayoutChange(View view, int n, int n2, int n3, int n4) {
        this.this$0.view.setOnLayoutChangeListener(null);
        if (this.this$0.shouldAnimate()) {
            this.this$0.animateViewIn();
        } else {
            this.this$0.onViewShown();
        }
    }
}
