/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.material.floatingactionbutton.FloatingActionButton
 *  com.google.android.material.floatingactionbutton.FloatingActionButton$OnVisibilityChangedListener
 *  com.google.android.material.floatingactionbutton.FloatingActionButtonImpl$InternalVisibilityChangedListener
 */
package com.google.android.material.floatingactionbutton;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.floatingactionbutton.FloatingActionButtonImpl;

class FloatingActionButton.1
implements FloatingActionButtonImpl.InternalVisibilityChangedListener {
    final FloatingActionButton this$0;
    final FloatingActionButton.OnVisibilityChangedListener val$listener;

    FloatingActionButton.1(FloatingActionButton floatingActionButton, FloatingActionButton.OnVisibilityChangedListener onVisibilityChangedListener) {
        this.this$0 = floatingActionButton;
        this.val$listener = onVisibilityChangedListener;
    }

    public void onHidden() {
        this.val$listener.onHidden(this.this$0);
    }

    public void onShown() {
        this.val$listener.onShown(this.this$0);
    }
}
