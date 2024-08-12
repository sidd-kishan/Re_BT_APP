/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.lifecycle.LiveData
 *  androidx.room.RoomDatabase
 *  androidx.room.RoomTrackingLiveData
 */
package androidx.room;

import androidx.lifecycle.LiveData;
import androidx.room.RoomDatabase;
import androidx.room.RoomTrackingLiveData;
import java.util.Collections;
import java.util.IdentityHashMap;
import java.util.Set;
import java.util.concurrent.Callable;

class InvalidationLiveDataContainer {
    private final RoomDatabase mDatabase;
    final Set<LiveData> mLiveDataSet = Collections.newSetFromMap(new IdentityHashMap());

    InvalidationLiveDataContainer(RoomDatabase roomDatabase) {
        this.mDatabase = roomDatabase;
    }

    <T> LiveData<T> create(String[] stringArray, boolean bl, Callable<T> callable) {
        return new RoomTrackingLiveData(this.mDatabase, this, bl, callable, stringArray);
    }

    void onActive(LiveData liveData) {
        this.mLiveDataSet.add(liveData);
    }

    void onInactive(LiveData liveData) {
        this.mLiveDataSet.remove(liveData);
    }
}
