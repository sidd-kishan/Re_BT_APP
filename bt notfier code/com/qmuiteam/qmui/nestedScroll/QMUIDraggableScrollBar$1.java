/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.qmuiteam.qmui.nestedScroll.QMUIDraggableScrollBar
 */
package com.qmuiteam.qmui.nestedScroll;

import com.qmuiteam.qmui.nestedScroll.QMUIDraggableScrollBar;

class QMUIDraggableScrollBar.1
implements Runnable {
    final QMUIDraggableScrollBar this$0;

    QMUIDraggableScrollBar.1(QMUIDraggableScrollBar qMUIDraggableScrollBar) {
        this.this$0 = qMUIDraggableScrollBar;
    }

    @Override
    public void run() {
        this.this$0.invalidate();
    }
}
