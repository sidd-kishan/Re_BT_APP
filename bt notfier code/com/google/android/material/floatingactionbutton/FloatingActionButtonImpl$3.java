/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.view.ViewTreeObserver$OnPreDrawListener
 *  com.google.android.material.floatingactionbutton.FloatingActionButtonImpl
 */
package com.google.android.material.floatingactionbutton;

import android.view.ViewTreeObserver;
import com.google.android.material.floatingactionbutton.FloatingActionButtonImpl;

class FloatingActionButtonImpl.3
implements ViewTreeObserver.OnPreDrawListener {
    final FloatingActionButtonImpl this$0;

    FloatingActionButtonImpl.3(FloatingActionButtonImpl floatingActionButtonImpl) {
        this.this$0 = floatingActionButtonImpl;
    }

    public boolean onPreDraw() {
        this.this$0.onPreDraw();
        return true;
    }
}
