/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.room.InvalidationTracker$Observer
 *  androidx.room.paging.LimitOffsetDataSource
 */
package androidx.room.paging;

import androidx.room.InvalidationTracker;
import androidx.room.paging.LimitOffsetDataSource;
import java.util.Set;

class LimitOffsetDataSource.1
extends InvalidationTracker.Observer {
    final LimitOffsetDataSource this$0;

    LimitOffsetDataSource.1(LimitOffsetDataSource limitOffsetDataSource, String[] stringArray) {
        this.this$0 = limitOffsetDataSource;
        super(stringArray);
    }

    public void onInvalidated(Set<String> set) {
        this.this$0.invalidate();
    }
}
