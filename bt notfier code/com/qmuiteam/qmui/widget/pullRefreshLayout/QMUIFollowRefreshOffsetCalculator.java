/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.qmuiteam.qmui.widget.pullRefreshLayout.QMUIPullRefreshLayout$RefreshOffsetCalculator
 */
package com.qmuiteam.qmui.widget.pullRefreshLayout;

import com.qmuiteam.qmui.widget.pullRefreshLayout.QMUIPullRefreshLayout;

public class QMUIFollowRefreshOffsetCalculator
implements QMUIPullRefreshLayout.RefreshOffsetCalculator {
    public int calculateRefreshOffset(int n, int n2, int n3, int n4, int n5, int n6) {
        return Math.min(n4 - n3, n4 - (n6 / 2 + n3 / 2));
    }
}
