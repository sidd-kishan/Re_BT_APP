/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.view.ViewParent
 *  androidx.appcompat.widget.ForwardingListener
 */
package androidx.appcompat.widget;

import android.view.ViewParent;
import androidx.appcompat.widget.ForwardingListener;

private class ForwardingListener.DisallowIntercept
implements Runnable {
    final ForwardingListener this$0;

    ForwardingListener.DisallowIntercept(ForwardingListener forwardingListener) {
        this.this$0 = forwardingListener;
    }

    @Override
    public void run() {
        ViewParent viewParent = this.this$0.mSrc.getParent();
        if (viewParent == null) return;
        viewParent.requestDisallowInterceptTouchEvent(true);
    }
}
