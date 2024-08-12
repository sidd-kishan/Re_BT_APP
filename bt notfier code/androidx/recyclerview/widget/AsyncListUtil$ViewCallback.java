/*
 * Decompiled with CFR 0.152.
 */
package androidx.recyclerview.widget;

public static abstract class AsyncListUtil.ViewCallback {
    public static final int HINT_SCROLL_ASC = 2;
    public static final int HINT_SCROLL_DESC = 1;
    public static final int HINT_SCROLL_NONE = 0;

    public void extendRangeInto(int[] nArray, int[] nArray2, int n) {
        int n2 = nArray[1] - nArray[0] + 1;
        int n3 = n2 / 2;
        int n4 = nArray[0];
        int n5 = n == 1 ? n2 : n3;
        nArray2[0] = n4 - n5;
        n5 = nArray[1];
        if (n != 2) {
            n2 = n3;
        }
        nArray2[1] = n5 + n2;
    }

    public abstract void getItemRangeInto(int[] var1);

    public abstract void onDataRefresh();

    public abstract void onItemLoaded(int var1);
}
