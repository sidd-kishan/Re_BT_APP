/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.util.Log
 *  android.util.SparseIntArray
 *  androidx.recyclerview.widget.AsyncListUtil$DataCallback
 *  androidx.recyclerview.widget.AsyncListUtil$ViewCallback
 *  androidx.recyclerview.widget.MessageThreadUtil
 *  androidx.recyclerview.widget.ThreadUtil$BackgroundCallback
 *  androidx.recyclerview.widget.ThreadUtil$MainThreadCallback
 *  androidx.recyclerview.widget.TileList
 */
package androidx.recyclerview.widget;

import android.util.Log;
import android.util.SparseIntArray;
import androidx.recyclerview.widget.AsyncListUtil;
import androidx.recyclerview.widget.MessageThreadUtil;
import androidx.recyclerview.widget.ThreadUtil;
import androidx.recyclerview.widget.TileList;

public class AsyncListUtil<T> {
    static final boolean DEBUG = false;
    static final String TAG = "AsyncListUtil";
    boolean mAllowScrollHints;
    private final ThreadUtil.BackgroundCallback<T> mBackgroundCallback;
    final ThreadUtil.BackgroundCallback<T> mBackgroundProxy;
    final DataCallback<T> mDataCallback;
    int mDisplayedGeneration = 0;
    int mItemCount = 0;
    private final ThreadUtil.MainThreadCallback<T> mMainThreadCallback;
    final ThreadUtil.MainThreadCallback<T> mMainThreadProxy;
    final SparseIntArray mMissingPositions;
    final int[] mPrevRange;
    int mRequestedGeneration = 0;
    private int mScrollHint = 0;
    final Class<T> mTClass;
    final TileList<T> mTileList;
    final int mTileSize;
    final int[] mTmpRange = new int[2];
    final int[] mTmpRangeExtended;
    final ViewCallback mViewCallback;

    public AsyncListUtil(Class<T> messageThreadUtil, int n, DataCallback<T> dataCallback, ViewCallback viewCallback) {
        this.mPrevRange = new int[2];
        this.mTmpRangeExtended = new int[2];
        this.mMissingPositions = new SparseIntArray();
        this.mMainThreadCallback = new /* Unavailable Anonymous Inner Class!! */;
        this.mBackgroundCallback = new /* Unavailable Anonymous Inner Class!! */;
        this.mTClass = messageThreadUtil;
        this.mTileSize = n;
        this.mDataCallback = dataCallback;
        this.mViewCallback = viewCallback;
        this.mTileList = new TileList(n);
        messageThreadUtil = new MessageThreadUtil();
        this.mMainThreadProxy = messageThreadUtil.getMainThreadProxy(this.mMainThreadCallback);
        this.mBackgroundProxy = messageThreadUtil.getBackgroundProxy(this.mBackgroundCallback);
        this.refresh();
    }

    private boolean isRefreshPending() {
        boolean bl = this.mRequestedGeneration != this.mDisplayedGeneration;
        return bl;
    }

    public T getItem(int n) {
        if (n >= 0 && n < this.mItemCount) {
            Object object = this.mTileList.getItemAt(n);
            if (object != null) return (T)object;
            if (this.isRefreshPending()) return (T)object;
            this.mMissingPositions.put(n, 0);
            return (T)object;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(n);
        stringBuilder.append(" is not within 0 and ");
        stringBuilder.append(this.mItemCount);
        throw new IndexOutOfBoundsException(stringBuilder.toString());
    }

    public int getItemCount() {
        return this.mItemCount;
    }

    void log(String string, Object ... objectArray) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[MAIN] ");
        stringBuilder.append(String.format(string, objectArray));
        Log.d((String)TAG, (String)stringBuilder.toString());
    }

    public void onRangeChanged() {
        if (this.isRefreshPending()) {
            return;
        }
        this.updateRange();
        this.mAllowScrollHints = true;
    }

    public void refresh() {
        int n;
        this.mMissingPositions.clear();
        ThreadUtil.BackgroundCallback<T> backgroundCallback = this.mBackgroundProxy;
        this.mRequestedGeneration = n = this.mRequestedGeneration + 1;
        backgroundCallback.refresh(n);
    }

    void updateRange() {
        int[] nArray;
        int n;
        this.mViewCallback.getItemRangeInto(this.mTmpRange);
        Object object = this.mTmpRange;
        if (object[0] > object[1]) return;
        if (object[0] < 0) return;
        if (object[1] >= this.mItemCount) {
            return;
        }
        if (!this.mAllowScrollHints) {
            this.mScrollHint = 0;
        } else {
            n = object[0];
            nArray = this.mPrevRange;
            if (n <= nArray[1] && nArray[0] <= object[1]) {
                if (object[0] < nArray[0]) {
                    this.mScrollHint = 1;
                } else if (object[0] > nArray[0]) {
                    this.mScrollHint = 2;
                }
            } else {
                this.mScrollHint = 0;
            }
        }
        nArray = this.mPrevRange;
        object = this.mTmpRange;
        nArray[0] = object[0];
        nArray[1] = object[1];
        this.mViewCallback.extendRangeInto(object, this.mTmpRangeExtended, this.mScrollHint);
        object = this.mTmpRangeExtended;
        object[0] = Math.min(this.mTmpRange[0], Math.max(object[0], 0));
        object = this.mTmpRangeExtended;
        object[1] = Math.max(this.mTmpRange[1], Math.min(object[1], this.mItemCount - 1));
        object = this.mBackgroundProxy;
        nArray = this.mTmpRange;
        n = nArray[0];
        int n2 = nArray[1];
        nArray = this.mTmpRangeExtended;
        object.updateRange(n, n2, nArray[0], nArray[1], this.mScrollHint);
    }
}
