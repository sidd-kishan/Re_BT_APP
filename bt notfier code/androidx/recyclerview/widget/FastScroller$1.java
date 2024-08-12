/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.recyclerview.widget.FastScroller
 */
package androidx.recyclerview.widget;

import androidx.recyclerview.widget.FastScroller;

class FastScroller.1
implements Runnable {
    final FastScroller this$0;

    FastScroller.1(FastScroller fastScroller) {
        this.this$0 = fastScroller;
    }

    @Override
    public void run() {
        this.this$0.hide(500);
    }
}
