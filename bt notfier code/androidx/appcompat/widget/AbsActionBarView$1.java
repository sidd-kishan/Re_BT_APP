/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.appcompat.widget.AbsActionBarView
 */
package androidx.appcompat.widget;

import androidx.appcompat.widget.AbsActionBarView;

class AbsActionBarView.1
implements Runnable {
    final AbsActionBarView this$0;

    AbsActionBarView.1(AbsActionBarView absActionBarView) {
        this.this$0 = absActionBarView;
    }

    @Override
    public void run() {
        this.this$0.showOverflowMenu();
    }
}
