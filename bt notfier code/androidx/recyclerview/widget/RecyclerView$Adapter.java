/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.view.ViewGroup
 *  androidx.core.os.TraceCompat
 *  androidx.recyclerview.widget.RecyclerView
 *  androidx.recyclerview.widget.RecyclerView$7
 *  androidx.recyclerview.widget.RecyclerView$Adapter$StateRestorationPolicy
 *  androidx.recyclerview.widget.RecyclerView$AdapterDataObservable
 *  androidx.recyclerview.widget.RecyclerView$AdapterDataObserver
 *  androidx.recyclerview.widget.RecyclerView$LayoutParams
 *  androidx.recyclerview.widget.RecyclerView$ViewHolder
 */
package androidx.recyclerview.widget;

import android.view.ViewGroup;
import androidx.core.os.TraceCompat;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public static abstract class RecyclerView.Adapter<VH extends RecyclerView.ViewHolder> {
    private boolean mHasStableIds = false;
    private final RecyclerView.AdapterDataObservable mObservable = new RecyclerView.AdapterDataObservable();
    private StateRestorationPolicy mStateRestorationPolicy = StateRestorationPolicy.ALLOW;

    public final void bindViewHolder(VH object, int n) {
        boolean bl = ((RecyclerView.ViewHolder)object).mBindingAdapter == null;
        if (bl) {
            ((RecyclerView.ViewHolder)object).mPosition = n;
            if (this.hasStableIds()) {
                ((RecyclerView.ViewHolder)object).mItemId = this.getItemId(n);
            }
            object.setFlags(1, 519);
            TraceCompat.beginSection((String)"RV OnBindView");
        }
        ((RecyclerView.ViewHolder)object).mBindingAdapter = this;
        this.onBindViewHolder(object, n, object.getUnmodifiedPayloads());
        if (!bl) return;
        object.clearPayload();
        object = ((RecyclerView.ViewHolder)object).itemView.getLayoutParams();
        if (object instanceof RecyclerView.LayoutParams) {
            ((RecyclerView.LayoutParams)object).mInsetsDirty = true;
        }
        TraceCompat.endSection();
    }

    boolean canRestoreState() {
        boolean bl;
        int n = RecyclerView.7.$SwitchMap$androidx$recyclerview$widget$RecyclerView$Adapter$StateRestorationPolicy[this.mStateRestorationPolicy.ordinal()];
        boolean bl2 = bl = false;
        if (n == 1) return bl2;
        if (n != 2) {
            return true;
        }
        bl2 = bl;
        if (this.getItemCount() <= 0) return bl2;
        bl2 = true;
        return bl2;
    }

    public final VH createViewHolder(ViewGroup object, int n) {
        try {
            TraceCompat.beginSection((String)"RV CreateView");
            object = this.onCreateViewHolder((ViewGroup)object, n);
            if (object.itemView.getParent() == null) {
                object.mItemViewType = n;
                return (VH)object;
            }
            object = new IllegalStateException("ViewHolder views must not be attached when created. Ensure that you are not passing 'true' to the attachToRoot parameter of LayoutInflater.inflate(..., boolean attachToRoot)");
            throw object;
        }
        finally {
            TraceCompat.endSection();
        }
    }

    public int findRelativeAdapterPositionIn(RecyclerView.Adapter<? extends RecyclerView.ViewHolder> adapter, RecyclerView.ViewHolder viewHolder, int n) {
        if (adapter != this) return -1;
        return n;
    }

    public abstract int getItemCount();

    public long getItemId(int n) {
        return -1L;
    }

    public int getItemViewType(int n) {
        return 0;
    }

    public final StateRestorationPolicy getStateRestorationPolicy() {
        return this.mStateRestorationPolicy;
    }

    public final boolean hasObservers() {
        return this.mObservable.hasObservers();
    }

    public final boolean hasStableIds() {
        return this.mHasStableIds;
    }

    public final void notifyDataSetChanged() {
        this.mObservable.notifyChanged();
    }

    public final void notifyItemChanged(int n) {
        this.mObservable.notifyItemRangeChanged(n, 1);
    }

    public final void notifyItemChanged(int n, Object object) {
        this.mObservable.notifyItemRangeChanged(n, 1, object);
    }

    public final void notifyItemInserted(int n) {
        this.mObservable.notifyItemRangeInserted(n, 1);
    }

    public final void notifyItemMoved(int n, int n2) {
        this.mObservable.notifyItemMoved(n, n2);
    }

    public final void notifyItemRangeChanged(int n, int n2) {
        this.mObservable.notifyItemRangeChanged(n, n2);
    }

    public final void notifyItemRangeChanged(int n, int n2, Object object) {
        this.mObservable.notifyItemRangeChanged(n, n2, object);
    }

    public final void notifyItemRangeInserted(int n, int n2) {
        this.mObservable.notifyItemRangeInserted(n, n2);
    }

    public final void notifyItemRangeRemoved(int n, int n2) {
        this.mObservable.notifyItemRangeRemoved(n, n2);
    }

    public final void notifyItemRemoved(int n) {
        this.mObservable.notifyItemRangeRemoved(n, 1);
    }

    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
    }

    public abstract void onBindViewHolder(VH var1, int var2);

    public void onBindViewHolder(VH VH, int n, List<Object> list) {
        this.onBindViewHolder(VH, n);
    }

    public abstract VH onCreateViewHolder(ViewGroup var1, int var2);

    public void onDetachedFromRecyclerView(RecyclerView recyclerView) {
    }

    public boolean onFailedToRecycleView(VH VH) {
        return false;
    }

    public void onViewAttachedToWindow(VH VH) {
    }

    public void onViewDetachedFromWindow(VH VH) {
    }

    public void onViewRecycled(VH VH) {
    }

    public void registerAdapterDataObserver(RecyclerView.AdapterDataObserver adapterDataObserver) {
        this.mObservable.registerObserver((Object)adapterDataObserver);
    }

    public void setHasStableIds(boolean bl) {
        if (this.hasObservers()) throw new IllegalStateException("Cannot change whether this adapter has stable IDs while the adapter has registered observers.");
        this.mHasStableIds = bl;
    }

    public void setStateRestorationPolicy(StateRestorationPolicy stateRestorationPolicy) {
        this.mStateRestorationPolicy = stateRestorationPolicy;
        this.mObservable.notifyStateRestorationPolicyChanged();
    }

    public void unregisterAdapterDataObserver(RecyclerView.AdapterDataObserver adapterDataObserver) {
        this.mObservable.unregisterObserver((Object)adapterDataObserver);
    }
}
