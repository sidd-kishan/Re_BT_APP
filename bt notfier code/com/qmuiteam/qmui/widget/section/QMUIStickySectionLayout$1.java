/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.view.View
 *  android.view.View$OnLayoutChangeListener
 *  com.qmuiteam.qmui.widget.section.QMUIStickySectionLayout
 */
package com.qmuiteam.qmui.widget.section;

import android.view.View;
import com.qmuiteam.qmui.widget.section.QMUIStickySectionLayout;

/*
 * Exception performing whole class analysis ignored.
 */
class QMUIStickySectionLayout.1
implements View.OnLayoutChangeListener {
    final QMUIStickySectionLayout this$0;

    QMUIStickySectionLayout.1(QMUIStickySectionLayout qMUIStickySectionLayout) {
        this.this$0 = qMUIStickySectionLayout;
    }

    public void onLayoutChange(View view, int n, int n2, int n3, int n4, int n5, int n6, int n7, int n8) {
        QMUIStickySectionLayout.access$002((QMUIStickySectionLayout)this.this$0, (int)(n4 - n2));
        if (QMUIStickySectionLayout.access$000((QMUIStickySectionLayout)this.this$0) <= 0) return;
        if (QMUIStickySectionLayout.access$100((QMUIStickySectionLayout)this.this$0) == null) return;
        QMUIStickySectionLayout.access$100((QMUIStickySectionLayout)this.this$0).run();
        QMUIStickySectionLayout.access$102((QMUIStickySectionLayout)this.this$0, null);
    }
}
