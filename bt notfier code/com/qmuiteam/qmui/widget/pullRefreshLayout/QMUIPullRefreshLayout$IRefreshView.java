/*
 * Decompiled with CFR 0.152.
 */
package com.qmuiteam.qmui.widget.pullRefreshLayout;

public static interface QMUIPullRefreshLayout.IRefreshView {
    public void doRefresh();

    public void onPull(int var1, int var2, int var3);

    public void stop();
}
