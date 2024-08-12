/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.view.View
 *  com.google.android.material.snackbar.BaseTransientBottomBar
 *  com.google.android.material.snackbar.BaseTransientBottomBar$OnAttachStateChangeListener
 */
package com.google.android.material.snackbar;

import android.view.View;
import com.google.android.material.snackbar.BaseTransientBottomBar;

class BaseTransientBottomBar.6
implements BaseTransientBottomBar.OnAttachStateChangeListener {
    final BaseTransientBottomBar this$0;

    BaseTransientBottomBar.6(BaseTransientBottomBar baseTransientBottomBar) {
        this.this$0 = baseTransientBottomBar;
    }

    public void onViewAttachedToWindow(View view) {
    }

    public void onViewDetachedFromWindow(View view) {
        if (!this.this$0.isShownOrQueued()) return;
        BaseTransientBottomBar.handler.post((Runnable)new /* Unavailable Anonymous Inner Class!! */);
    }
}
