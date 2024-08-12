/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.graphics.Rect
 *  androidx.core.view.WindowInsetsCompat
 *  com.qmuiteam.qmui.widget.QMUIAppBarLayout
 */
package com.qmuiteam.qmui.widget;

import android.graphics.Rect;
import androidx.core.view.WindowInsetsCompat;
import com.qmuiteam.qmui.widget.QMUIAppBarLayout;

class QMUIAppBarLayout.1
extends WindowInsetsCompat {
    final QMUIAppBarLayout this$0;
    final Rect val$insets;

    QMUIAppBarLayout.1(QMUIAppBarLayout qMUIAppBarLayout, WindowInsetsCompat windowInsetsCompat, Rect rect) {
        this.this$0 = qMUIAppBarLayout;
        this.val$insets = rect;
        super(windowInsetsCompat);
    }

    public int getSystemWindowInsetTop() {
        return this.val$insets.top;
    }
}
