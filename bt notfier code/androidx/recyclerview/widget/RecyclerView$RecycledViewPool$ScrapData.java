/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.recyclerview.widget.RecyclerView$ViewHolder
 */
package androidx.recyclerview.widget;

import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;

static class RecyclerView.RecycledViewPool.ScrapData {
    long mBindRunningAverageNs = 0L;
    long mCreateRunningAverageNs = 0L;
    int mMaxScrap = 5;
    final ArrayList<RecyclerView.ViewHolder> mScrapHeap = new ArrayList();

    RecyclerView.RecycledViewPool.ScrapData() {
    }
}
