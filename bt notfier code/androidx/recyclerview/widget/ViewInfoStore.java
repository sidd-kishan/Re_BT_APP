/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.collection.LongSparseArray
 *  androidx.collection.SimpleArrayMap
 *  androidx.recyclerview.widget.RecyclerView$ItemAnimator$ItemHolderInfo
 *  androidx.recyclerview.widget.RecyclerView$ViewHolder
 *  androidx.recyclerview.widget.ViewInfoStore$InfoRecord
 *  androidx.recyclerview.widget.ViewInfoStore$ProcessCallback
 */
package androidx.recyclerview.widget;

import androidx.collection.LongSparseArray;
import androidx.collection.SimpleArrayMap;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.ViewInfoStore;

/*
 * Exception performing whole class analysis ignored.
 */
class ViewInfoStore {
    private static final boolean DEBUG = false;
    final SimpleArrayMap<RecyclerView.ViewHolder, InfoRecord> mLayoutHolderMap = new SimpleArrayMap();
    final LongSparseArray<RecyclerView.ViewHolder> mOldChangedHolders = new LongSparseArray();

    ViewInfoStore() {
    }

    private RecyclerView.ItemAnimator.ItemHolderInfo popFromLayoutStep(RecyclerView.ViewHolder viewHolder, int n) {
        int n2 = this.mLayoutHolderMap.indexOfKey((Object)viewHolder);
        if (n2 < 0) {
            return null;
        }
        InfoRecord infoRecord = (InfoRecord)this.mLayoutHolderMap.valueAt(n2);
        if (infoRecord == null) return null;
        if ((infoRecord.flags & n) == 0) return null;
        infoRecord.flags &= ~n;
        if (n == 4) {
            viewHolder = infoRecord.preInfo;
        } else {
            if (n != 8) throw new IllegalArgumentException("Must provide flag PRE or POST");
            viewHolder = infoRecord.postInfo;
        }
        if ((infoRecord.flags & 0xC) != 0) return viewHolder;
        this.mLayoutHolderMap.removeAt(n2);
        InfoRecord.recycle((InfoRecord)infoRecord);
        return viewHolder;
    }

    void addToAppearedInPreLayoutHolders(RecyclerView.ViewHolder viewHolder, RecyclerView.ItemAnimator.ItemHolderInfo itemHolderInfo) {
        InfoRecord infoRecord;
        InfoRecord infoRecord2 = infoRecord = (InfoRecord)this.mLayoutHolderMap.get((Object)viewHolder);
        if (infoRecord == null) {
            infoRecord2 = InfoRecord.obtain();
            this.mLayoutHolderMap.put((Object)viewHolder, (Object)infoRecord2);
        }
        infoRecord2.flags |= 2;
        infoRecord2.preInfo = itemHolderInfo;
    }

    void addToDisappearedInLayout(RecyclerView.ViewHolder viewHolder) {
        InfoRecord infoRecord;
        InfoRecord infoRecord2 = infoRecord = (InfoRecord)this.mLayoutHolderMap.get((Object)viewHolder);
        if (infoRecord == null) {
            infoRecord2 = InfoRecord.obtain();
            this.mLayoutHolderMap.put((Object)viewHolder, (Object)infoRecord2);
        }
        infoRecord2.flags |= 1;
    }

    void addToOldChangeHolders(long l, RecyclerView.ViewHolder viewHolder) {
        this.mOldChangedHolders.put(l, (Object)viewHolder);
    }

    void addToPostLayout(RecyclerView.ViewHolder viewHolder, RecyclerView.ItemAnimator.ItemHolderInfo itemHolderInfo) {
        InfoRecord infoRecord;
        InfoRecord infoRecord2 = infoRecord = (InfoRecord)this.mLayoutHolderMap.get((Object)viewHolder);
        if (infoRecord == null) {
            infoRecord2 = InfoRecord.obtain();
            this.mLayoutHolderMap.put((Object)viewHolder, (Object)infoRecord2);
        }
        infoRecord2.postInfo = itemHolderInfo;
        infoRecord2.flags |= 8;
    }

    void addToPreLayout(RecyclerView.ViewHolder viewHolder, RecyclerView.ItemAnimator.ItemHolderInfo itemHolderInfo) {
        InfoRecord infoRecord;
        InfoRecord infoRecord2 = infoRecord = (InfoRecord)this.mLayoutHolderMap.get((Object)viewHolder);
        if (infoRecord == null) {
            infoRecord2 = InfoRecord.obtain();
            this.mLayoutHolderMap.put((Object)viewHolder, (Object)infoRecord2);
        }
        infoRecord2.preInfo = itemHolderInfo;
        infoRecord2.flags |= 4;
    }

    void clear() {
        this.mLayoutHolderMap.clear();
        this.mOldChangedHolders.clear();
    }

    RecyclerView.ViewHolder getFromOldChangeHolders(long l) {
        return (RecyclerView.ViewHolder)this.mOldChangedHolders.get(l);
    }

    boolean isDisappearing(RecyclerView.ViewHolder viewHolder) {
        viewHolder = (InfoRecord)this.mLayoutHolderMap.get((Object)viewHolder);
        boolean bl = true;
        if (viewHolder != null && (viewHolder.flags & 1) != 0) return bl;
        bl = false;
        return bl;
    }

    boolean isInPreLayout(RecyclerView.ViewHolder viewHolder) {
        boolean bl = (viewHolder = (InfoRecord)this.mLayoutHolderMap.get((Object)viewHolder)) != null && (viewHolder.flags & 4) != 0;
        return bl;
    }

    void onDetach() {
        InfoRecord.drainCache();
    }

    public void onViewDetached(RecyclerView.ViewHolder viewHolder) {
        this.removeFromDisappearedInLayout(viewHolder);
    }

    RecyclerView.ItemAnimator.ItemHolderInfo popFromPostLayout(RecyclerView.ViewHolder viewHolder) {
        return this.popFromLayoutStep(viewHolder, 8);
    }

    RecyclerView.ItemAnimator.ItemHolderInfo popFromPreLayout(RecyclerView.ViewHolder viewHolder) {
        return this.popFromLayoutStep(viewHolder, 4);
    }

    void process(ProcessCallback processCallback) {
        int n = this.mLayoutHolderMap.size() - 1;
        while (n >= 0) {
            RecyclerView.ViewHolder viewHolder = (RecyclerView.ViewHolder)this.mLayoutHolderMap.keyAt(n);
            InfoRecord infoRecord = (InfoRecord)this.mLayoutHolderMap.removeAt(n);
            if ((infoRecord.flags & 3) == 3) {
                processCallback.unused(viewHolder);
            } else if ((infoRecord.flags & 1) != 0) {
                if (infoRecord.preInfo == null) {
                    processCallback.unused(viewHolder);
                } else {
                    processCallback.processDisappeared(viewHolder, infoRecord.preInfo, infoRecord.postInfo);
                }
            } else if ((infoRecord.flags & 0xE) == 14) {
                processCallback.processAppeared(viewHolder, infoRecord.preInfo, infoRecord.postInfo);
            } else if ((infoRecord.flags & 0xC) == 12) {
                processCallback.processPersistent(viewHolder, infoRecord.preInfo, infoRecord.postInfo);
            } else if ((infoRecord.flags & 4) != 0) {
                processCallback.processDisappeared(viewHolder, infoRecord.preInfo, null);
            } else if ((infoRecord.flags & 8) != 0) {
                processCallback.processAppeared(viewHolder, infoRecord.preInfo, infoRecord.postInfo);
            } else {
                int n2 = infoRecord.flags;
            }
            InfoRecord.recycle((InfoRecord)infoRecord);
            --n;
        }
    }

    void removeFromDisappearedInLayout(RecyclerView.ViewHolder viewHolder) {
        if ((viewHolder = (InfoRecord)this.mLayoutHolderMap.get((Object)viewHolder)) == null) {
            return;
        }
        viewHolder.flags &= 0xFFFFFFFE;
    }

    void removeViewHolder(RecyclerView.ViewHolder viewHolder) {
        for (int i = this.mOldChangedHolders.size() - 1; i >= 0; --i) {
            if (viewHolder != this.mOldChangedHolders.valueAt(i)) continue;
            this.mOldChangedHolders.removeAt(i);
            break;
        }
        if ((viewHolder = (InfoRecord)this.mLayoutHolderMap.remove((Object)viewHolder)) == null) return;
        InfoRecord.recycle((InfoRecord)viewHolder);
    }
}
