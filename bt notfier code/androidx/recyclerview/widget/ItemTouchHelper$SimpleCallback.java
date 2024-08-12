/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.recyclerview.widget.ItemTouchHelper$Callback
 *  androidx.recyclerview.widget.RecyclerView
 *  androidx.recyclerview.widget.RecyclerView$ViewHolder
 */
package androidx.recyclerview.widget;

import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.RecyclerView;

public static abstract class ItemTouchHelper.SimpleCallback
extends ItemTouchHelper.Callback {
    private int mDefaultDragDirs;
    private int mDefaultSwipeDirs;

    public ItemTouchHelper.SimpleCallback(int n, int n2) {
        this.mDefaultSwipeDirs = n2;
        this.mDefaultDragDirs = n;
    }

    public int getDragDirs(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder) {
        return this.mDefaultDragDirs;
    }

    public int getMovementFlags(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder) {
        return ItemTouchHelper.SimpleCallback.makeMovementFlags((int)this.getDragDirs(recyclerView, viewHolder), (int)this.getSwipeDirs(recyclerView, viewHolder));
    }

    public int getSwipeDirs(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder) {
        return this.mDefaultSwipeDirs;
    }

    public void setDefaultDragDirs(int n) {
        this.mDefaultDragDirs = n;
    }

    public void setDefaultSwipeDirs(int n) {
        this.mDefaultSwipeDirs = n;
    }
}
