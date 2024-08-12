/*
 * Decompiled with CFR 0.152.
 */
package androidx.recyclerview.widget;

public static abstract class AsyncListUtil.DataCallback<T> {
    public abstract void fillData(T[] var1, int var2, int var3);

    public int getMaxCachedTiles() {
        return 10;
    }

    public void recycleData(T[] TArray, int n) {
    }

    public abstract int refreshData();
}
