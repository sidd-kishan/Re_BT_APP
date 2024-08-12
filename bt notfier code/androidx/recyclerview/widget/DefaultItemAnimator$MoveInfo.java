/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.recyclerview.widget.RecyclerView$ViewHolder
 */
package androidx.recyclerview.widget;

import androidx.recyclerview.widget.RecyclerView;

private static class DefaultItemAnimator.MoveInfo {
    public int fromX;
    public int fromY;
    public RecyclerView.ViewHolder holder;
    public int toX;
    public int toY;

    DefaultItemAnimator.MoveInfo(RecyclerView.ViewHolder viewHolder, int n, int n2, int n3, int n4) {
        this.holder = viewHolder;
        this.fromX = n;
        this.fromY = n2;
        this.toX = n3;
        this.toY = n4;
    }
}
