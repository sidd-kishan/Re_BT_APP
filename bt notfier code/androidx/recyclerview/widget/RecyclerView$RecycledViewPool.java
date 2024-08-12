/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.util.SparseArray
 *  androidx.recyclerview.widget.RecyclerView$Adapter
 *  androidx.recyclerview.widget.RecyclerView$RecycledViewPool$ScrapData
 *  androidx.recyclerview.widget.RecyclerView$ViewHolder
 */
package androidx.recyclerview.widget;

import android.util.SparseArray;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;

public static class RecyclerView.RecycledViewPool {
    private static final int DEFAULT_MAX_SCRAP = 5;
    private int mAttachCount = 0;
    SparseArray<ScrapData> mScrap = new SparseArray();

    private ScrapData getScrapDataForType(int n) {
        ScrapData scrapData;
        ScrapData scrapData2 = scrapData = (ScrapData)this.mScrap.get(n);
        if (scrapData != null) return scrapData2;
        scrapData2 = new ScrapData();
        this.mScrap.put(n, (Object)scrapData2);
        return scrapData2;
    }

    void attach() {
        ++this.mAttachCount;
    }

    public void clear() {
        int n = 0;
        while (n < this.mScrap.size()) {
            ((ScrapData)this.mScrap.valueAt((int)n)).mScrapHeap.clear();
            ++n;
        }
    }

    void detach() {
        --this.mAttachCount;
    }

    void factorInBindTime(int n, long l) {
        ScrapData scrapData = this.getScrapDataForType(n);
        scrapData.mBindRunningAverageNs = this.runningAverage(scrapData.mBindRunningAverageNs, l);
    }

    void factorInCreateTime(int n, long l) {
        ScrapData scrapData = this.getScrapDataForType(n);
        scrapData.mCreateRunningAverageNs = this.runningAverage(scrapData.mCreateRunningAverageNs, l);
    }

    public RecyclerView.ViewHolder getRecycledView(int n) {
        Object object = (ScrapData)this.mScrap.get(n);
        if (object == null) return null;
        if (((ScrapData)object).mScrapHeap.isEmpty()) return null;
        object = ((ScrapData)object).mScrapHeap;
        n = ((ArrayList)object).size() - 1;
        while (n >= 0) {
            if (!((RecyclerView.ViewHolder)((ArrayList)object).get(n)).isAttachedToTransitionOverlay()) {
                return (RecyclerView.ViewHolder)((ArrayList)object).remove(n);
            }
            --n;
        }
        return null;
    }

    public int getRecycledViewCount(int n) {
        return this.getScrapDataForType((int)n).mScrapHeap.size();
    }

    void onAdapterChanged(RecyclerView.Adapter adapter, RecyclerView.Adapter adapter2, boolean bl) {
        if (adapter != null) {
            this.detach();
        }
        if (!bl && this.mAttachCount == 0) {
            this.clear();
        }
        if (adapter2 == null) return;
        this.attach();
    }

    public void putRecycledView(RecyclerView.ViewHolder viewHolder) {
        int n = viewHolder.getItemViewType();
        ArrayList arrayList = this.getScrapDataForType((int)n).mScrapHeap;
        if (((ScrapData)this.mScrap.get((int)n)).mMaxScrap <= arrayList.size()) {
            return;
        }
        viewHolder.resetInternal();
        arrayList.add(viewHolder);
    }

    long runningAverage(long l, long l2) {
        if (l != 0L) return l / 4L * 3L + l2 / 4L;
        return l2;
    }

    public void setMaxRecycledViews(int n, int n2) {
        Object object = this.getScrapDataForType(n);
        ((ScrapData)object).mMaxScrap = n2;
        object = ((ScrapData)object).mScrapHeap;
        while (((ArrayList)object).size() > n2) {
            ((ArrayList)object).remove(((ArrayList)object).size() - 1);
        }
    }

    int size() {
        int n = 0;
        int n2 = 0;
        while (n < this.mScrap.size()) {
            ArrayList arrayList = ((ScrapData)this.mScrap.valueAt((int)n)).mScrapHeap;
            int n3 = n2;
            if (arrayList != null) {
                n3 = n2 + arrayList.size();
            }
            ++n;
            n2 = n3;
        }
        return n2;
    }

    boolean willBindInTime(int n, long l, long l2) {
        long l3 = this.getScrapDataForType((int)n).mBindRunningAverageNs;
        boolean bl = l3 == 0L || l + l3 < l2;
        return bl;
    }

    boolean willCreateInTime(int n, long l, long l2) {
        long l3 = this.getScrapDataForType((int)n).mCreateRunningAverageNs;
        boolean bl = l3 == 0L || l + l3 < l2;
        return bl;
    }
}
