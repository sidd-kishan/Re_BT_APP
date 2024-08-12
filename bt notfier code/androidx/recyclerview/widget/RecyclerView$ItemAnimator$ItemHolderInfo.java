/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.recyclerview.widget.RecyclerView$ViewHolder
 */
package androidx.recyclerview.widget;

import androidx.recyclerview.widget.RecyclerView;

public static class RecyclerView.ItemAnimator.ItemHolderInfo {
    public int bottom;
    public int changeFlags;
    public int left;
    public int right;
    public int top;

    public RecyclerView.ItemAnimator.ItemHolderInfo setFrom(RecyclerView.ViewHolder viewHolder) {
        return this.setFrom(viewHolder, 0);
    }

    public RecyclerView.ItemAnimator.ItemHolderInfo setFrom(RecyclerView.ViewHolder viewHolder, int n) {
        viewHolder = viewHolder.itemView;
        this.left = viewHolder.getLeft();
        this.top = viewHolder.getTop();
        this.right = viewHolder.getRight();
        this.bottom = viewHolder.getBottom();
        return this;
    }
}
