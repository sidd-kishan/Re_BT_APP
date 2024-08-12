/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.room.RoomTrackingLiveData
 */
package androidx.room;

import androidx.room.RoomTrackingLiveData;

class RoomTrackingLiveData.2
implements Runnable {
    final RoomTrackingLiveData this$0;

    RoomTrackingLiveData.2(RoomTrackingLiveData roomTrackingLiveData) {
        this.this$0 = roomTrackingLiveData;
    }

    @Override
    public void run() {
        boolean bl = this.this$0.hasActiveObservers();
        if (!this.this$0.mInvalid.compareAndSet(false, true)) return;
        if (!bl) return;
        this.this$0.getQueryExecutor().execute(this.this$0.mRefreshRunnable);
    }
}
