/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.appcompat.widget.ForwardingListener
 */
package androidx.appcompat.widget;

import androidx.appcompat.widget.ForwardingListener;

private class ForwardingListener.TriggerLongPress
implements Runnable {
    final ForwardingListener this$0;

    ForwardingListener.TriggerLongPress(ForwardingListener forwardingListener) {
        this.this$0 = forwardingListener;
    }

    @Override
    public void run() {
        this.this$0.onLongPress();
    }
}
