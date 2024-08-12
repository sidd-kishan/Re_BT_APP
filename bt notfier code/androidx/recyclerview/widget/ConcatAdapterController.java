/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.util.Log
 *  android.view.ViewGroup
 *  androidx.core.util.Preconditions
 *  androidx.recyclerview.widget.ConcatAdapter
 *  androidx.recyclerview.widget.ConcatAdapter$Config
 *  androidx.recyclerview.widget.ConcatAdapter$Config$StableIdMode
 *  androidx.recyclerview.widget.ConcatAdapterController$WrapperAndLocalPosition
 *  androidx.recyclerview.widget.NestedAdapterWrapper
 *  androidx.recyclerview.widget.NestedAdapterWrapper$Callback
 *  androidx.recyclerview.widget.RecyclerView
 *  androidx.recyclerview.widget.RecyclerView$Adapter
 *  androidx.recyclerview.widget.RecyclerView$Adapter$StateRestorationPolicy
 *  androidx.recyclerview.widget.RecyclerView$ViewHolder
 *  androidx.recyclerview.widget.StableIdStorage
 *  androidx.recyclerview.widget.StableIdStorage$IsolatedStableIdStorage
 *  androidx.recyclerview.widget.StableIdStorage$NoStableIdStorage
 *  androidx.recyclerview.widget.StableIdStorage$SharedPoolStableIdStorage
 *  androidx.recyclerview.widget.ViewTypeStorage
 *  androidx.recyclerview.widget.ViewTypeStorage$IsolatedViewTypeStorage
 *  androidx.recyclerview.widget.ViewTypeStorage$SharedIdRangeViewTypeStorage
 */
package androidx.recyclerview.widget;

import android.util.Log;
import android.view.ViewGroup;
import androidx.core.util.Preconditions;
import androidx.recyclerview.widget.ConcatAdapter;
import androidx.recyclerview.widget.ConcatAdapterController;
import androidx.recyclerview.widget.NestedAdapterWrapper;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StableIdStorage;
import androidx.recyclerview.widget.ViewTypeStorage;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.List;

class ConcatAdapterController
implements NestedAdapterWrapper.Callback {
    private List<WeakReference<RecyclerView>> mAttachedRecyclerViews = new ArrayList<WeakReference<RecyclerView>>();
    private final IdentityHashMap<RecyclerView.ViewHolder, NestedAdapterWrapper> mBinderLookup = new IdentityHashMap();
    private final ConcatAdapter mConcatAdapter;
    private WrapperAndLocalPosition mReusableHolder;
    private final ConcatAdapter.Config.StableIdMode mStableIdMode;
    private final StableIdStorage mStableIdStorage;
    private final ViewTypeStorage mViewTypeStorage;
    private List<NestedAdapterWrapper> mWrappers = new ArrayList<NestedAdapterWrapper>();

    ConcatAdapterController(ConcatAdapter concatAdapter, ConcatAdapter.Config config) {
        this.mReusableHolder = new WrapperAndLocalPosition();
        this.mConcatAdapter = concatAdapter;
        this.mViewTypeStorage = config.isolateViewTypes ? new ViewTypeStorage.IsolatedViewTypeStorage() : new ViewTypeStorage.SharedIdRangeViewTypeStorage();
        this.mStableIdMode = config.stableIdMode;
        if (config.stableIdMode == ConcatAdapter.Config.StableIdMode.NO_STABLE_IDS) {
            this.mStableIdStorage = new StableIdStorage.NoStableIdStorage();
        } else if (config.stableIdMode == ConcatAdapter.Config.StableIdMode.ISOLATED_STABLE_IDS) {
            this.mStableIdStorage = new StableIdStorage.IsolatedStableIdStorage();
        } else {
            if (config.stableIdMode != ConcatAdapter.Config.StableIdMode.SHARED_STABLE_IDS) throw new IllegalArgumentException("unknown stable id mode");
            this.mStableIdStorage = new StableIdStorage.SharedPoolStableIdStorage();
        }
    }

    private void calculateAndUpdateStateRestorationPolicy() {
        RecyclerView.Adapter.StateRestorationPolicy stateRestorationPolicy = this.computeStateRestorationPolicy();
        if (stateRestorationPolicy == this.mConcatAdapter.getStateRestorationPolicy()) return;
        this.mConcatAdapter.internalSetStateRestorationPolicy(stateRestorationPolicy);
    }

    private RecyclerView.Adapter.StateRestorationPolicy computeStateRestorationPolicy() {
        NestedAdapterWrapper nestedAdapterWrapper;
        RecyclerView.Adapter.StateRestorationPolicy stateRestorationPolicy;
        Iterator<NestedAdapterWrapper> iterator = this.mWrappers.iterator();
        do {
            if (!iterator.hasNext()) return RecyclerView.Adapter.StateRestorationPolicy.ALLOW;
            nestedAdapterWrapper = iterator.next();
            stateRestorationPolicy = nestedAdapterWrapper.adapter.getStateRestorationPolicy();
            if (stateRestorationPolicy != RecyclerView.Adapter.StateRestorationPolicy.PREVENT) continue;
            return RecyclerView.Adapter.StateRestorationPolicy.PREVENT;
        } while (stateRestorationPolicy != RecyclerView.Adapter.StateRestorationPolicy.PREVENT_WHEN_EMPTY || nestedAdapterWrapper.getCachedItemCount() != 0);
        return RecyclerView.Adapter.StateRestorationPolicy.PREVENT;
    }

    private int countItemsBefore(NestedAdapterWrapper nestedAdapterWrapper) {
        Iterator<NestedAdapterWrapper> iterator = this.mWrappers.iterator();
        int n = 0;
        while (iterator.hasNext()) {
            NestedAdapterWrapper nestedAdapterWrapper2 = iterator.next();
            if (nestedAdapterWrapper2 == nestedAdapterWrapper) return n;
            n += nestedAdapterWrapper2.getCachedItemCount();
        }
        return n;
    }

    private WrapperAndLocalPosition findWrapperAndLocalPosition(int n) {
        Object object;
        if (this.mReusableHolder.mInUse) {
            object = new WrapperAndLocalPosition();
        } else {
            this.mReusableHolder.mInUse = true;
            object = this.mReusableHolder;
        }
        Iterator<NestedAdapterWrapper> iterator = this.mWrappers.iterator();
        int n2 = n;
        while (iterator.hasNext()) {
            NestedAdapterWrapper nestedAdapterWrapper = iterator.next();
            if (nestedAdapterWrapper.getCachedItemCount() > n2) {
                ((WrapperAndLocalPosition)object).mWrapper = nestedAdapterWrapper;
                ((WrapperAndLocalPosition)object).mLocalPosition = n2;
                break;
            }
            n2 -= nestedAdapterWrapper.getCachedItemCount();
        }
        if (((WrapperAndLocalPosition)object).mWrapper != null) {
            return object;
        }
        object = new StringBuilder();
        ((StringBuilder)object).append("Cannot find wrapper for ");
        ((StringBuilder)object).append(n);
        object = new IllegalArgumentException(((StringBuilder)object).toString());
        throw object;
    }

    private NestedAdapterWrapper findWrapperFor(RecyclerView.Adapter<RecyclerView.ViewHolder> adapter) {
        int n = this.indexOfWrapper(adapter);
        if (n != -1) return this.mWrappers.get(n);
        return null;
    }

    private NestedAdapterWrapper getWrapper(RecyclerView.ViewHolder viewHolder) {
        Object object = this.mBinderLookup.get(viewHolder);
        if (object != null) {
            return object;
        }
        object = new StringBuilder();
        ((StringBuilder)object).append("Cannot find wrapper for ");
        ((StringBuilder)object).append(viewHolder);
        ((StringBuilder)object).append(", seems like it is not bound by this adapter: ");
        ((StringBuilder)object).append(this);
        throw new IllegalStateException(((StringBuilder)object).toString());
    }

    private int indexOfWrapper(RecyclerView.Adapter<RecyclerView.ViewHolder> adapter) {
        int n = this.mWrappers.size();
        int n2 = 0;
        while (n2 < n) {
            if (this.mWrappers.get((int)n2).adapter == adapter) {
                return n2;
            }
            ++n2;
        }
        return -1;
    }

    private boolean isAttachedTo(RecyclerView recyclerView) {
        Iterator<WeakReference<RecyclerView>> iterator = this.mAttachedRecyclerViews.iterator();
        do {
            if (!iterator.hasNext()) return false;
        } while (iterator.next().get() != recyclerView);
        return true;
    }

    private void releaseWrapperAndLocalPosition(WrapperAndLocalPosition wrapperAndLocalPosition) {
        wrapperAndLocalPosition.mInUse = false;
        wrapperAndLocalPosition.mWrapper = null;
        wrapperAndLocalPosition.mLocalPosition = -1;
        this.mReusableHolder = wrapperAndLocalPosition;
    }

    boolean addAdapter(int n, RecyclerView.Adapter<RecyclerView.ViewHolder> object) {
        if (n >= 0 && n <= this.mWrappers.size()) {
            if (this.hasStableIds()) {
                Preconditions.checkArgument((boolean)object.hasStableIds(), (Object)"All sub adapters must have stable ids when stable id mode is ISOLATED_STABLE_IDS or SHARED_STABLE_IDS");
            } else if (object.hasStableIds()) {
                Log.w((String)"ConcatAdapter", (String)"Stable ids in the adapter will be ignored as the ConcatAdapter is configured not to have stable ids");
            }
            if (this.findWrapperFor((RecyclerView.Adapter<RecyclerView.ViewHolder>)object) != null) {
                return false;
            }
            NestedAdapterWrapper nestedAdapterWrapper = new NestedAdapterWrapper((RecyclerView.Adapter)object, (NestedAdapterWrapper.Callback)this, this.mViewTypeStorage, this.mStableIdStorage.createStableIdLookup());
            this.mWrappers.add(n, nestedAdapterWrapper);
            Iterator<WeakReference<RecyclerView>> iterator = this.mAttachedRecyclerViews.iterator();
            while (iterator.hasNext()) {
                RecyclerView recyclerView = (RecyclerView)iterator.next().get();
                if (recyclerView == null) continue;
                object.onAttachedToRecyclerView(recyclerView);
            }
            if (nestedAdapterWrapper.getCachedItemCount() > 0) {
                this.mConcatAdapter.notifyItemRangeInserted(this.countItemsBefore(nestedAdapterWrapper), nestedAdapterWrapper.getCachedItemCount());
            }
            this.calculateAndUpdateStateRestorationPolicy();
            return true;
        }
        object = new StringBuilder();
        ((StringBuilder)object).append("Index must be between 0 and ");
        ((StringBuilder)object).append(this.mWrappers.size());
        ((StringBuilder)object).append(". Given:");
        ((StringBuilder)object).append(n);
        object = new IndexOutOfBoundsException(((StringBuilder)object).toString());
        throw object;
    }

    boolean addAdapter(RecyclerView.Adapter<RecyclerView.ViewHolder> adapter) {
        return this.addAdapter(this.mWrappers.size(), adapter);
    }

    public boolean canRestoreState() {
        Iterator<NestedAdapterWrapper> iterator = this.mWrappers.iterator();
        do {
            if (!iterator.hasNext()) return true;
        } while (iterator.next().adapter.canRestoreState());
        return false;
    }

    public RecyclerView.Adapter<? extends RecyclerView.ViewHolder> getBoundAdapter(RecyclerView.ViewHolder viewHolder) {
        if ((viewHolder = this.mBinderLookup.get(viewHolder)) != null) return viewHolder.adapter;
        return null;
    }

    public List<RecyclerView.Adapter<? extends RecyclerView.ViewHolder>> getCopyOfAdapters() {
        if (this.mWrappers.isEmpty()) {
            return Collections.emptyList();
        }
        ArrayList<RecyclerView.Adapter<? extends RecyclerView.ViewHolder>> arrayList = new ArrayList<RecyclerView.Adapter<? extends RecyclerView.ViewHolder>>(this.mWrappers.size());
        Iterator<NestedAdapterWrapper> iterator = this.mWrappers.iterator();
        while (iterator.hasNext()) {
            arrayList.add((RecyclerView.Adapter<? extends RecyclerView.ViewHolder>)iterator.next().adapter);
        }
        return arrayList;
    }

    public long getItemId(int n) {
        WrapperAndLocalPosition wrapperAndLocalPosition = this.findWrapperAndLocalPosition(n);
        long l = wrapperAndLocalPosition.mWrapper.getItemId(wrapperAndLocalPosition.mLocalPosition);
        this.releaseWrapperAndLocalPosition(wrapperAndLocalPosition);
        return l;
    }

    public int getItemViewType(int n) {
        WrapperAndLocalPosition wrapperAndLocalPosition = this.findWrapperAndLocalPosition(n);
        n = wrapperAndLocalPosition.mWrapper.getItemViewType(wrapperAndLocalPosition.mLocalPosition);
        this.releaseWrapperAndLocalPosition(wrapperAndLocalPosition);
        return n;
    }

    public int getLocalAdapterPosition(RecyclerView.Adapter<? extends RecyclerView.ViewHolder> adapter, RecyclerView.ViewHolder viewHolder, int n) {
        Object object = this.mBinderLookup.get(viewHolder);
        if (object == null) {
            return -1;
        }
        int n2 = ((NestedAdapterWrapper)object).adapter.getItemCount();
        if ((n -= this.countItemsBefore((NestedAdapterWrapper)object)) >= 0 && n < n2) {
            return ((NestedAdapterWrapper)object).adapter.findRelativeAdapterPositionIn(adapter, viewHolder, n);
        }
        object = new StringBuilder();
        ((StringBuilder)object).append("Detected inconsistent adapter updates. The local position of the view holder maps to ");
        ((StringBuilder)object).append(n);
        ((StringBuilder)object).append(" which is out of bounds for the adapter with size ");
        ((StringBuilder)object).append(n2);
        ((StringBuilder)object).append(".Make sure to immediately call notify methods in your adapter when you change the backing dataviewHolder:");
        ((StringBuilder)object).append(viewHolder);
        ((StringBuilder)object).append("adapter:");
        ((StringBuilder)object).append(adapter);
        throw new IllegalStateException(((StringBuilder)object).toString());
    }

    public int getTotalCount() {
        Iterator<NestedAdapterWrapper> iterator = this.mWrappers.iterator();
        int n = 0;
        while (iterator.hasNext()) {
            n += iterator.next().getCachedItemCount();
        }
        return n;
    }

    public boolean hasStableIds() {
        boolean bl = this.mStableIdMode != ConcatAdapter.Config.StableIdMode.NO_STABLE_IDS;
        return bl;
    }

    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        if (this.isAttachedTo(recyclerView)) {
            return;
        }
        this.mAttachedRecyclerViews.add(new WeakReference<RecyclerView>(recyclerView));
        Iterator<NestedAdapterWrapper> iterator = this.mWrappers.iterator();
        while (iterator.hasNext()) {
            iterator.next().adapter.onAttachedToRecyclerView(recyclerView);
        }
    }

    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int n) {
        WrapperAndLocalPosition wrapperAndLocalPosition = this.findWrapperAndLocalPosition(n);
        this.mBinderLookup.put(viewHolder, wrapperAndLocalPosition.mWrapper);
        wrapperAndLocalPosition.mWrapper.onBindViewHolder(viewHolder, wrapperAndLocalPosition.mLocalPosition);
        this.releaseWrapperAndLocalPosition(wrapperAndLocalPosition);
    }

    public void onChanged(NestedAdapterWrapper nestedAdapterWrapper) {
        this.mConcatAdapter.notifyDataSetChanged();
        this.calculateAndUpdateStateRestorationPolicy();
    }

    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int n) {
        return this.mViewTypeStorage.getWrapperForGlobalType(n).onCreateViewHolder(viewGroup, n);
    }

    public void onDetachedFromRecyclerView(RecyclerView recyclerView) {
        WeakReference<RecyclerView> weakReference;
        for (int i = this.mAttachedRecyclerViews.size() - 1; i >= 0; --i) {
            weakReference = this.mAttachedRecyclerViews.get(i);
            if (weakReference.get() == null) {
                this.mAttachedRecyclerViews.remove(i);
                continue;
            }
            if (weakReference.get() != recyclerView) continue;
            this.mAttachedRecyclerViews.remove(i);
            break;
        }
        weakReference = this.mWrappers.iterator();
        while (weakReference.hasNext()) {
            ((NestedAdapterWrapper)weakReference.next()).adapter.onDetachedFromRecyclerView(recyclerView);
        }
    }

    public boolean onFailedToRecycleView(RecyclerView.ViewHolder viewHolder) {
        Object object = this.mBinderLookup.remove(viewHolder);
        if (object != null) {
            return ((NestedAdapterWrapper)object).adapter.onFailedToRecycleView(viewHolder);
        }
        object = new StringBuilder();
        ((StringBuilder)object).append("Cannot find wrapper for ");
        ((StringBuilder)object).append(viewHolder);
        ((StringBuilder)object).append(", seems like it is not bound by this adapter: ");
        ((StringBuilder)object).append(this);
        throw new IllegalStateException(((StringBuilder)object).toString());
    }

    public void onItemRangeChanged(NestedAdapterWrapper nestedAdapterWrapper, int n, int n2) {
        int n3 = this.countItemsBefore(nestedAdapterWrapper);
        this.mConcatAdapter.notifyItemRangeChanged(n + n3, n2);
    }

    public void onItemRangeChanged(NestedAdapterWrapper nestedAdapterWrapper, int n, int n2, Object object) {
        int n3 = this.countItemsBefore(nestedAdapterWrapper);
        this.mConcatAdapter.notifyItemRangeChanged(n + n3, n2, object);
    }

    public void onItemRangeInserted(NestedAdapterWrapper nestedAdapterWrapper, int n, int n2) {
        int n3 = this.countItemsBefore(nestedAdapterWrapper);
        this.mConcatAdapter.notifyItemRangeInserted(n + n3, n2);
    }

    public void onItemRangeMoved(NestedAdapterWrapper nestedAdapterWrapper, int n, int n2) {
        int n3 = this.countItemsBefore(nestedAdapterWrapper);
        this.mConcatAdapter.notifyItemMoved(n + n3, n2 + n3);
    }

    public void onItemRangeRemoved(NestedAdapterWrapper nestedAdapterWrapper, int n, int n2) {
        int n3 = this.countItemsBefore(nestedAdapterWrapper);
        this.mConcatAdapter.notifyItemRangeRemoved(n + n3, n2);
    }

    public void onStateRestorationPolicyChanged(NestedAdapterWrapper nestedAdapterWrapper) {
        this.calculateAndUpdateStateRestorationPolicy();
    }

    public void onViewAttachedToWindow(RecyclerView.ViewHolder viewHolder) {
        this.getWrapper((RecyclerView.ViewHolder)viewHolder).adapter.onViewAttachedToWindow(viewHolder);
    }

    public void onViewDetachedFromWindow(RecyclerView.ViewHolder viewHolder) {
        this.getWrapper((RecyclerView.ViewHolder)viewHolder).adapter.onViewDetachedFromWindow(viewHolder);
    }

    public void onViewRecycled(RecyclerView.ViewHolder viewHolder) {
        Object object = this.mBinderLookup.remove(viewHolder);
        if (object != null) {
            ((NestedAdapterWrapper)object).adapter.onViewRecycled(viewHolder);
            return;
        }
        object = new StringBuilder();
        ((StringBuilder)object).append("Cannot find wrapper for ");
        ((StringBuilder)object).append(viewHolder);
        ((StringBuilder)object).append(", seems like it is not bound by this adapter: ");
        ((StringBuilder)object).append(this);
        throw new IllegalStateException(((StringBuilder)object).toString());
    }

    boolean removeAdapter(RecyclerView.Adapter<RecyclerView.ViewHolder> adapter) {
        int n = this.indexOfWrapper(adapter);
        if (n == -1) {
            return false;
        }
        NestedAdapterWrapper nestedAdapterWrapper = this.mWrappers.get(n);
        int n2 = this.countItemsBefore(nestedAdapterWrapper);
        this.mWrappers.remove(n);
        this.mConcatAdapter.notifyItemRangeRemoved(n2, nestedAdapterWrapper.getCachedItemCount());
        Iterator<WeakReference<RecyclerView>> iterator = this.mAttachedRecyclerViews.iterator();
        while (true) {
            if (!iterator.hasNext()) {
                nestedAdapterWrapper.dispose();
                this.calculateAndUpdateStateRestorationPolicy();
                return true;
            }
            RecyclerView recyclerView = (RecyclerView)iterator.next().get();
            if (recyclerView == null) continue;
            adapter.onDetachedFromRecyclerView(recyclerView);
        }
    }
}
