/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.recyclerview.widget.RecyclerView$ItemAnimator$ItemHolderInfo
 *  androidx.recyclerview.widget.RecyclerView$ViewHolder
 */
package androidx.recyclerview.widget;

import androidx.recyclerview.widget.RecyclerView;

static interface ViewInfoStore.ProcessCallback {
    public void processAppeared(RecyclerView.ViewHolder var1, RecyclerView.ItemAnimator.ItemHolderInfo var2, RecyclerView.ItemAnimator.ItemHolderInfo var3);

    public void processDisappeared(RecyclerView.ViewHolder var1, RecyclerView.ItemAnimator.ItemHolderInfo var2, RecyclerView.ItemAnimator.ItemHolderInfo var3);

    public void processPersistent(RecyclerView.ViewHolder var1, RecyclerView.ItemAnimator.ItemHolderInfo var2, RecyclerView.ItemAnimator.ItemHolderInfo var3);

    public void unused(RecyclerView.ViewHolder var1);
}
