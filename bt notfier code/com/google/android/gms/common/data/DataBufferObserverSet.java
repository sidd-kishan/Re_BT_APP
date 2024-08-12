/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.common.data.DataBufferObserver
 *  com.google.android.gms.common.data.DataBufferObserver$Observable
 */
package com.google.android.gms.common.data;

import com.google.android.gms.common.data.DataBufferObserver;
import java.util.HashSet;
import java.util.Iterator;

public final class DataBufferObserverSet
implements DataBufferObserver,
DataBufferObserver.Observable {
    private HashSet<DataBufferObserver> zaa = new HashSet();

    public void addObserver(DataBufferObserver dataBufferObserver) {
        this.zaa.add(dataBufferObserver);
    }

    public void clear() {
        this.zaa.clear();
    }

    public boolean hasObservers() {
        if (this.zaa.isEmpty()) return false;
        return true;
    }

    public void onDataChanged() {
        Iterator<DataBufferObserver> iterator = this.zaa.iterator();
        while (iterator.hasNext()) {
            iterator.next().onDataChanged();
        }
    }

    public void onDataRangeChanged(int n, int n2) {
        Iterator<DataBufferObserver> iterator = this.zaa.iterator();
        while (iterator.hasNext()) {
            iterator.next().onDataRangeChanged(n, n2);
        }
    }

    public void onDataRangeInserted(int n, int n2) {
        Iterator<DataBufferObserver> iterator = this.zaa.iterator();
        while (iterator.hasNext()) {
            iterator.next().onDataRangeInserted(n, n2);
        }
    }

    public void onDataRangeMoved(int n, int n2, int n3) {
        Iterator<DataBufferObserver> iterator = this.zaa.iterator();
        while (iterator.hasNext()) {
            iterator.next().onDataRangeMoved(n, n2, n3);
        }
    }

    public void onDataRangeRemoved(int n, int n2) {
        Iterator<DataBufferObserver> iterator = this.zaa.iterator();
        while (iterator.hasNext()) {
            iterator.next().onDataRangeRemoved(n, n2);
        }
    }

    public void removeObserver(DataBufferObserver dataBufferObserver) {
        this.zaa.remove(dataBufferObserver);
    }
}
