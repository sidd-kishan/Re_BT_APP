/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.view.View
 *  androidx.core.view.OnApplyWindowInsetsListener
 *  androidx.core.view.WindowInsetsCompat
 *  com.qmuiteam.qmui.widget.QMUICollapsingTopBarLayout
 */
package com.qmuiteam.qmui.widget;

import android.view.View;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.WindowInsetsCompat;
import com.qmuiteam.qmui.widget.QMUICollapsingTopBarLayout;

/*
 * Exception performing whole class analysis ignored.
 */
class QMUICollapsingTopBarLayout.1
implements OnApplyWindowInsetsListener {
    final QMUICollapsingTopBarLayout this$0;

    QMUICollapsingTopBarLayout.1(QMUICollapsingTopBarLayout qMUICollapsingTopBarLayout) {
        this.this$0 = qMUICollapsingTopBarLayout;
    }

    public WindowInsetsCompat onApplyWindowInsets(View view, WindowInsetsCompat windowInsetsCompat) {
        return QMUICollapsingTopBarLayout.access$000((QMUICollapsingTopBarLayout)this.this$0, (WindowInsetsCompat)windowInsetsCompat);
    }
}
