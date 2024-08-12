/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.recyclerview.widget.BatchingListUpdateCallback
 *  androidx.recyclerview.widget.SortedList$Callback
 */
package androidx.recyclerview.widget;

import androidx.recyclerview.widget.BatchingListUpdateCallback;
import androidx.recyclerview.widget.SortedList;

public static class SortedList.BatchedCallback<T2>
extends SortedList.Callback<T2> {
    private final BatchingListUpdateCallback mBatchingListUpdateCallback;
    final SortedList.Callback<T2> mWrappedCallback;

    public SortedList.BatchedCallback(SortedList.Callback<T2> callback) {
        this.mWrappedCallback = callback;
        this.mBatchingListUpdateCallback = new BatchingListUpdateCallback(callback);
    }

    public boolean areContentsTheSame(T2 T2, T2 T22) {
        return this.mWrappedCallback.areContentsTheSame(T2, T22);
    }

    public boolean areItemsTheSame(T2 T2, T2 T22) {
        return this.mWrappedCallback.areItemsTheSame(T2, T22);
    }

    public int compare(T2 T2, T2 T22) {
        return this.mWrappedCallback.compare(T2, T22);
    }

    public void dispatchLastEvent() {
        this.mBatchingListUpdateCallback.dispatchLastEvent();
    }

    public Object getChangePayload(T2 T2, T2 T22) {
        return this.mWrappedCallback.getChangePayload(T2, T22);
    }

    public void onChanged(int n, int n2) {
        this.mBatchingListUpdateCallback.onChanged(n, n2, null);
    }

    public void onChanged(int n, int n2, Object object) {
        this.mBatchingListUpdateCallback.onChanged(n, n2, object);
    }

    public void onInserted(int n, int n2) {
        this.mBatchingListUpdateCallback.onInserted(n, n2);
    }

    public void onMoved(int n, int n2) {
        this.mBatchingListUpdateCallback.onMoved(n, n2);
    }

    public void onRemoved(int n, int n2) {
        this.mBatchingListUpdateCallback.onRemoved(n, n2);
    }
}
