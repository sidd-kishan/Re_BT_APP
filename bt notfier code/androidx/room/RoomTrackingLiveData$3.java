/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.arch.core.executor.ArchTaskExecutor
 *  androidx.room.InvalidationTracker$Observer
 *  androidx.room.RoomTrackingLiveData
 */
package androidx.room;

import androidx.arch.core.executor.ArchTaskExecutor;
import androidx.room.InvalidationTracker;
import androidx.room.RoomTrackingLiveData;
import java.util.Set;

class RoomTrackingLiveData.3
extends InvalidationTracker.Observer {
    final RoomTrackingLiveData this$0;

    RoomTrackingLiveData.3(RoomTrackingLiveData roomTrackingLiveData, String[] stringArray) {
        this.this$0 = roomTrackingLiveData;
        super(stringArray);
    }

    public void onInvalidated(Set<String> set) {
        ArchTaskExecutor.getInstance().executeOnMainThread(this.this$0.mInvalidationRunnable);
    }
}
