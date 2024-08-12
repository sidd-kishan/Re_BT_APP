/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.recyclerview.widget.TileList$Tile
 */
package androidx.recyclerview.widget;

import androidx.recyclerview.widget.TileList;

public static interface ThreadUtil.BackgroundCallback<T> {
    public void loadTile(int var1, int var2);

    public void recycleTile(TileList.Tile<T> var1);

    public void refresh(int var1);

    public void updateRange(int var1, int var2, int var3, int var4, int var5);
}
