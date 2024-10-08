/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.recyclerview.widget.ListUpdateCallback
 */
package androidx.recyclerview.widget;

import androidx.recyclerview.widget.ListUpdateCallback;

public class BatchingListUpdateCallback
implements ListUpdateCallback {
    private static final int TYPE_ADD = 1;
    private static final int TYPE_CHANGE = 3;
    private static final int TYPE_NONE = 0;
    private static final int TYPE_REMOVE = 2;
    int mLastEventCount = -1;
    Object mLastEventPayload = null;
    int mLastEventPosition = -1;
    int mLastEventType = 0;
    final ListUpdateCallback mWrapped;

    public BatchingListUpdateCallback(ListUpdateCallback listUpdateCallback) {
        this.mWrapped = listUpdateCallback;
    }

    public void dispatchLastEvent() {
        int n = this.mLastEventType;
        if (n == 0) {
            return;
        }
        if (n != 1) {
            if (n != 2) {
                if (n == 3) {
                    this.mWrapped.onChanged(this.mLastEventPosition, this.mLastEventCount, this.mLastEventPayload);
                }
            } else {
                this.mWrapped.onRemoved(this.mLastEventPosition, this.mLastEventCount);
            }
        } else {
            this.mWrapped.onInserted(this.mLastEventPosition, this.mLastEventCount);
        }
        this.mLastEventPayload = null;
        this.mLastEventType = 0;
    }

    public void onChanged(int n, int n2, Object object) {
        int n3;
        int n4;
        int n5;
        if (this.mLastEventType == 3 && n <= (n5 = this.mLastEventPosition) + (n4 = this.mLastEventCount) && (n3 = n + n2) >= n5 && this.mLastEventPayload == object) {
            this.mLastEventPosition = Math.min(n, n5);
            this.mLastEventCount = Math.max(n4 + n5, n3) - this.mLastEventPosition;
            return;
        }
        this.dispatchLastEvent();
        this.mLastEventPosition = n;
        this.mLastEventCount = n2;
        this.mLastEventPayload = object;
        this.mLastEventType = 3;
    }

    public void onInserted(int n, int n2) {
        int n3;
        int n4;
        if (this.mLastEventType == 1 && n >= (n4 = this.mLastEventPosition) && n <= n4 + (n3 = this.mLastEventCount)) {
            this.mLastEventCount = n3 + n2;
            this.mLastEventPosition = Math.min(n, n4);
            return;
        }
        this.dispatchLastEvent();
        this.mLastEventPosition = n;
        this.mLastEventCount = n2;
        this.mLastEventType = 1;
    }

    public void onMoved(int n, int n2) {
        this.dispatchLastEvent();
        this.mWrapped.onMoved(n, n2);
    }

    public void onRemoved(int n, int n2) {
        int n3;
        if (this.mLastEventType == 2 && (n3 = this.mLastEventPosition) >= n && n3 <= n + n2) {
            this.mLastEventCount += n2;
            this.mLastEventPosition = n;
            return;
        }
        this.dispatchLastEvent();
        this.mLastEventPosition = n;
        this.mLastEventCount = n2;
        this.mLastEventType = 2;
    }
}
