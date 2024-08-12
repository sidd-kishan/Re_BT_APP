/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.qmuiteam.qmui.widget.section.QMUIStickySectionLayout
 */
package com.qmuiteam.qmui.widget.section;

import com.qmuiteam.qmui.widget.section.QMUIStickySectionLayout;

class QMUIStickySectionLayout.3
implements Runnable {
    final QMUIStickySectionLayout this$0;
    final int val$position;
    final boolean val$scrollToTop;

    QMUIStickySectionLayout.3(QMUIStickySectionLayout qMUIStickySectionLayout, int n, boolean bl) {
        this.this$0 = qMUIStickySectionLayout;
        this.val$position = n;
        this.val$scrollToTop = bl;
    }

    @Override
    public void run() {
        this.this$0.scrollToPosition(this.val$position, false, this.val$scrollToTop);
    }
}
