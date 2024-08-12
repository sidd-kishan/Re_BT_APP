/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.recyclerview.widget.TileList$Tile
 */
package androidx.recyclerview.widget;

import androidx.recyclerview.widget.TileList;

public static interface ThreadUtil.MainThreadCallback<T> {
    public void addTile(int var1, TileList.Tile<T> var2);

    public void removeTile(int var1, int var2);

    public void updateItemCount(int var1, int var2);
}
