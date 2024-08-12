/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.database.Observable
 *  androidx.recyclerview.widget.RecyclerView$AdapterDataObserver
 */
package androidx.recyclerview.widget;

import android.database.Observable;
import androidx.recyclerview.widget.RecyclerView;

static class RecyclerView.AdapterDataObservable
extends Observable<RecyclerView.AdapterDataObserver> {
    RecyclerView.AdapterDataObservable() {
    }

    public boolean hasObservers() {
        return this.mObservers.isEmpty() ^ true;
    }

    public void notifyChanged() {
        int n = this.mObservers.size() - 1;
        while (n >= 0) {
            ((RecyclerView.AdapterDataObserver)this.mObservers.get(n)).onChanged();
            --n;
        }
    }

    public void notifyItemMoved(int n, int n2) {
        int n3 = this.mObservers.size() - 1;
        while (n3 >= 0) {
            ((RecyclerView.AdapterDataObserver)this.mObservers.get(n3)).onItemRangeMoved(n, n2, 1);
            --n3;
        }
    }

    public void notifyItemRangeChanged(int n, int n2) {
        this.notifyItemRangeChanged(n, n2, null);
    }

    public void notifyItemRangeChanged(int n, int n2, Object object) {
        int n3 = this.mObservers.size() - 1;
        while (n3 >= 0) {
            ((RecyclerView.AdapterDataObserver)this.mObservers.get(n3)).onItemRangeChanged(n, n2, object);
            --n3;
        }
    }

    public void notifyItemRangeInserted(int n, int n2) {
        int n3 = this.mObservers.size() - 1;
        while (n3 >= 0) {
            ((RecyclerView.AdapterDataObserver)this.mObservers.get(n3)).onItemRangeInserted(n, n2);
            --n3;
        }
    }

    public void notifyItemRangeRemoved(int n, int n2) {
        int n3 = this.mObservers.size() - 1;
        while (n3 >= 0) {
            ((RecyclerView.AdapterDataObserver)this.mObservers.get(n3)).onItemRangeRemoved(n, n2);
            --n3;
        }
    }

    public void notifyStateRestorationPolicyChanged() {
        int n = this.mObservers.size() - 1;
        while (n >= 0) {
            ((RecyclerView.AdapterDataObserver)this.mObservers.get(n)).onStateRestorationPolicyChanged();
            --n;
        }
    }
}
