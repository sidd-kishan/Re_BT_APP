/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.core.util.Pools$Pool
 *  androidx.core.util.Pools$SimplePool
 *  androidx.recyclerview.widget.RecyclerView$ItemAnimator$ItemHolderInfo
 */
package androidx.recyclerview.widget;

import androidx.core.util.Pools;
import androidx.recyclerview.widget.RecyclerView;

static class ViewInfoStore.InfoRecord {
    static final int FLAG_APPEAR = 2;
    static final int FLAG_APPEAR_AND_DISAPPEAR = 3;
    static final int FLAG_APPEAR_PRE_AND_POST = 14;
    static final int FLAG_DISAPPEARED = 1;
    static final int FLAG_POST = 8;
    static final int FLAG_PRE = 4;
    static final int FLAG_PRE_AND_POST = 12;
    static Pools.Pool<ViewInfoStore.InfoRecord> sPool = new Pools.SimplePool(20);
    int flags;
    RecyclerView.ItemAnimator.ItemHolderInfo postInfo;
    RecyclerView.ItemAnimator.ItemHolderInfo preInfo;

    private ViewInfoStore.InfoRecord() {
    }

    static void drainCache() {
        while (sPool.acquire() != null) {
        }
    }

    static ViewInfoStore.InfoRecord obtain() {
        ViewInfoStore.InfoRecord infoRecord;
        ViewInfoStore.InfoRecord infoRecord2 = infoRecord = (ViewInfoStore.InfoRecord)sPool.acquire();
        if (infoRecord != null) return infoRecord2;
        infoRecord2 = new ViewInfoStore.InfoRecord();
        return infoRecord2;
    }

    static void recycle(ViewInfoStore.InfoRecord infoRecord) {
        infoRecord.flags = 0;
        infoRecord.preInfo = null;
        infoRecord.postInfo = null;
        sPool.release((Object)infoRecord);
    }
}
