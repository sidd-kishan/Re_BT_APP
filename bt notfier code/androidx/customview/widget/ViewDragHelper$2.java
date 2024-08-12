/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.customview.widget.ViewDragHelper
 */
package androidx.customview.widget;

import androidx.customview.widget.ViewDragHelper;

class ViewDragHelper.2
implements Runnable {
    final ViewDragHelper this$0;

    ViewDragHelper.2(ViewDragHelper viewDragHelper) {
        this.this$0 = viewDragHelper;
    }

    @Override
    public void run() {
        this.this$0.setDragState(0);
    }
}
