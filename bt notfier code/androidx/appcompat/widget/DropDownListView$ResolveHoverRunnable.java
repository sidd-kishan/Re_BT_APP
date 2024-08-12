/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.appcompat.widget.DropDownListView
 */
package androidx.appcompat.widget;

import androidx.appcompat.widget.DropDownListView;

private class DropDownListView.ResolveHoverRunnable
implements Runnable {
    final DropDownListView this$0;

    DropDownListView.ResolveHoverRunnable(DropDownListView dropDownListView) {
        this.this$0 = dropDownListView;
    }

    public void cancel() {
        this.this$0.mResolveHoverRunnable = null;
        this.this$0.removeCallbacks((Runnable)this);
    }

    public void post() {
        this.this$0.post((Runnable)this);
    }

    @Override
    public void run() {
        this.this$0.mResolveHoverRunnable = null;
        this.this$0.drawableStateChanged();
    }
}
