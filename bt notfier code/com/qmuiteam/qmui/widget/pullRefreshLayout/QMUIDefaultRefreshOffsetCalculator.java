/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.qmuiteam.qmui.widget.pullRefreshLayout.QMUIPullRefreshLayout$RefreshOffsetCalculator
 */
package com.qmuiteam.qmui.widget.pullRefreshLayout;

import com.qmuiteam.qmui.widget.pullRefreshLayout.QMUIPullRefreshLayout;

public class QMUIDefaultRefreshOffsetCalculator
implements QMUIPullRefreshLayout.RefreshOffsetCalculator {
    public int calculateRefreshOffset(int n, int n2, int n3, int n4, int n5, int n6) {
        if (n4 >= n6) {
            n = n2;
        } else {
            if (n4 <= n5) return n;
            float f = (float)(n4 - n5) * 1.0f / (float)(n6 - n5);
            n = (int)((float)n + f * (float)(n2 - n));
        }
        return n;
    }
}
