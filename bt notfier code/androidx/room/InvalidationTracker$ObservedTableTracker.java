/*
 * Decompiled with CFR 0.152.
 */
package androidx.room;

import java.util.Arrays;

static class InvalidationTracker.ObservedTableTracker {
    static final int ADD = 1;
    static final int NO_OP = 0;
    static final int REMOVE = 2;
    boolean mNeedsSync;
    boolean mPendingSync;
    final long[] mTableObservers;
    final int[] mTriggerStateChanges;
    final boolean[] mTriggerStates;

    InvalidationTracker.ObservedTableTracker(int n) {
        long[] lArray = new long[n];
        this.mTableObservers = lArray;
        this.mTriggerStates = new boolean[n];
        this.mTriggerStateChanges = new int[n];
        Arrays.fill(lArray, 0L);
        Arrays.fill(this.mTriggerStates, false);
    }

    /*
     * Enabled unnecessary exception pruning
     */
    int[] getTablesToSync() {
        synchronized (this) {
            if (!this.mNeedsSync) return null;
            if (this.mPendingSync) {
                return null;
            }
            int n = this.mTableObservers.length;
            int n2 = 0;
            while (true) {
                int n3 = 1;
                if (n2 >= n) break;
                boolean bl = this.mTableObservers[n2] > 0L;
                if (bl != this.mTriggerStates[n2]) {
                    int[] nArray = this.mTriggerStateChanges;
                    if (!bl) {
                        n3 = 2;
                    }
                    nArray[n2] = n3;
                } else {
                    this.mTriggerStateChanges[n2] = 0;
                }
                this.mTriggerStates[n2] = bl;
                ++n2;
            }
            this.mPendingSync = true;
            this.mNeedsSync = false;
            return this.mTriggerStateChanges;
        }
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Enabled force condition propagation
     */
    boolean onAdded(int ... nArray) {
        synchronized (this) {
            int n = nArray.length;
            int n2 = 0;
            boolean bl = false;
            while (n2 < n) {
                int n3 = nArray[n2];
                {
                    long l = this.mTableObservers[n3];
                    this.mTableObservers[n3] = 1L + l;
                    if (l == 0L) {
                        this.mNeedsSync = true;
                        bl = true;
                    }
                    ++n2;
                }
            }
            return bl;
        }
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Enabled force condition propagation
     */
    boolean onRemoved(int ... nArray) {
        synchronized (this) {
            int n = nArray.length;
            int n2 = 0;
            boolean bl = false;
            while (n2 < n) {
                int n3 = nArray[n2];
                {
                    long l = this.mTableObservers[n3];
                    this.mTableObservers[n3] = l - 1L;
                    if (l == 1L) {
                        this.mNeedsSync = true;
                        bl = true;
                    }
                    ++n2;
                }
            }
            return bl;
        }
    }

    void onSyncCompleted() {
        synchronized (this) {
            this.mPendingSync = false;
            return;
        }
    }
}
