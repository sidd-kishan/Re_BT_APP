/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.recyclerview.widget.AdapterHelper$UpdateOp
 *  androidx.recyclerview.widget.RecyclerView$ViewHolder
 */
package androidx.recyclerview.widget;

import androidx.recyclerview.widget.AdapterHelper;
import androidx.recyclerview.widget.RecyclerView;

static interface AdapterHelper.Callback {
    public RecyclerView.ViewHolder findViewHolder(int var1);

    public void markViewHoldersUpdated(int var1, int var2, Object var3);

    public void offsetPositionsForAdd(int var1, int var2);

    public void offsetPositionsForMove(int var1, int var2);

    public void offsetPositionsForRemovingInvisible(int var1, int var2);

    public void offsetPositionsForRemovingLaidOutOrNewView(int var1, int var2);

    public void onDispatchFirstPass(AdapterHelper.UpdateOp var1);

    public void onDispatchSecondPass(AdapterHelper.UpdateOp var1);
}
