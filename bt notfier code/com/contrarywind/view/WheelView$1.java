/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.contrarywind.view.WheelView
 */
package com.contrarywind.view;

import com.contrarywind.view.WheelView;

/*
 * Exception performing whole class analysis ignored.
 */
class WheelView.1
implements Runnable {
    final WheelView this$0;

    WheelView.1(WheelView wheelView) {
        this.this$0 = wheelView;
    }

    @Override
    public void run() {
        WheelView.access$000((WheelView)this.this$0).onItemSelected(this.this$0.getCurrentItem());
    }
}
