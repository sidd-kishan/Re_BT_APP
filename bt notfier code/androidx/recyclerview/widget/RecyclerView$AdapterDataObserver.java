/*
 * Decompiled with CFR 0.152.
 */
package androidx.recyclerview.widget;

public static abstract class RecyclerView.AdapterDataObserver {
    public void onChanged() {
    }

    public void onItemRangeChanged(int n, int n2) {
    }

    public void onItemRangeChanged(int n, int n2, Object object) {
        this.onItemRangeChanged(n, n2);
    }

    public void onItemRangeInserted(int n, int n2) {
    }

    public void onItemRangeMoved(int n, int n2, int n3) {
    }

    public void onItemRangeRemoved(int n, int n2) {
    }

    public void onStateRestorationPolicyChanged() {
    }
}
