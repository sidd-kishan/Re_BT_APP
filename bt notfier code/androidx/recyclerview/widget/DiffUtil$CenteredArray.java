/*
 * Decompiled with CFR 0.152.
 */
package androidx.recyclerview.widget;

import java.util.Arrays;

static class DiffUtil.CenteredArray {
    private final int[] mData;
    private final int mMid;

    DiffUtil.CenteredArray(int n) {
        int[] nArray = new int[n];
        this.mData = nArray;
        this.mMid = nArray.length / 2;
    }

    int[] backingData() {
        return this.mData;
    }

    public void fill(int n) {
        Arrays.fill(this.mData, n);
    }

    int get(int n) {
        return this.mData[n + this.mMid];
    }

    void set(int n, int n2) {
        this.mData[n + this.mMid] = n2;
    }
}
