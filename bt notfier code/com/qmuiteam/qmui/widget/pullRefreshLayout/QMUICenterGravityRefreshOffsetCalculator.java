/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.qmuiteam.qmui.widget.pullRefreshLayout.QMUIPullRefreshLayout$RefreshOffsetCalculator
 */
package com.qmuiteam.qmui.widget.pullRefreshLayout;

import com.qmuiteam.qmui.widget.pullRefreshLayout.QMUIPullRefreshLayout;

public class QMUICenterGravityRefreshOffsetCalculator
implements QMUIPullRefreshLayout.RefreshOffsetCalculator {
    public int calculateRefreshOffset(int n, int n2, int n3, int n4, int n5, int n6) {
        if (n4 >= n3) return (n4 - n3) / 2;
        return n4 - n3;
    }
}
