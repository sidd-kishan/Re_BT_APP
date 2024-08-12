/*
 * Decompiled with CFR 0.152.
 */
package androidx.recyclerview.widget;

import java.lang.reflect.Array;

public static class TileList.Tile<T> {
    public int mItemCount;
    public final T[] mItems;
    TileList.Tile<T> mNext;
    public int mStartPosition;

    public TileList.Tile(Class<T> clazz, int n) {
        this.mItems = (Object[])Array.newInstance(clazz, n);
    }

    boolean containsPosition(int n) {
        int n2 = this.mStartPosition;
        boolean bl = n2 <= n && n < n2 + this.mItemCount;
        return bl;
    }

    T getByPosition(int n) {
        return this.mItems[n - this.mStartPosition];
    }
}
