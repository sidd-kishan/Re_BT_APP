/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.view.ViewGroup
 *  androidx.recyclerview.widget.ConcatAdapter$Config
 *  androidx.recyclerview.widget.ConcatAdapterController
 *  androidx.recyclerview.widget.RecyclerView
 *  androidx.recyclerview.widget.RecyclerView$Adapter
 *  androidx.recyclerview.widget.RecyclerView$Adapter$StateRestorationPolicy
 *  androidx.recyclerview.widget.RecyclerView$ViewHolder
 */
package androidx.recyclerview.widget;

import android.view.ViewGroup;
import androidx.recyclerview.widget.ConcatAdapter;
import androidx.recyclerview.widget.ConcatAdapterController;
import androidx.recyclerview.widget.RecyclerView;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public final class ConcatAdapter
extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    static final String TAG = "ConcatAdapter";
    private final ConcatAdapterController mController;

    public ConcatAdapter(Config object, List<? extends RecyclerView.Adapter<? extends RecyclerView.ViewHolder>> list) {
        this.mController = new ConcatAdapterController(this, (Config)object);
        object = list.iterator();
        while (true) {
            if (!object.hasNext()) {
                super.setHasStableIds(this.mController.hasStableIds());
                return;
            }
            this.addAdapter((RecyclerView.Adapter<? extends RecyclerView.ViewHolder>)((RecyclerView.Adapter)object.next()));
        }
    }

    @SafeVarargs
    public ConcatAdapter(Config config, RecyclerView.Adapter<? extends RecyclerView.ViewHolder> ... adapterArray) {
        this(config, Arrays.asList(adapterArray));
    }

    public ConcatAdapter(List<? extends RecyclerView.Adapter<? extends RecyclerView.ViewHolder>> list) {
        this(Config.DEFAULT, list);
    }

    @SafeVarargs
    public ConcatAdapter(RecyclerView.Adapter<? extends RecyclerView.ViewHolder> ... adapterArray) {
        this(Config.DEFAULT, adapterArray);
    }

    public boolean addAdapter(int n, RecyclerView.Adapter<? extends RecyclerView.ViewHolder> adapter) {
        return this.mController.addAdapter(n, adapter);
    }

    public boolean addAdapter(RecyclerView.Adapter<? extends RecyclerView.ViewHolder> adapter) {
        return this.mController.addAdapter(adapter);
    }

    public int findRelativeAdapterPositionIn(RecyclerView.Adapter<? extends RecyclerView.ViewHolder> adapter, RecyclerView.ViewHolder viewHolder, int n) {
        return this.mController.getLocalAdapterPosition(adapter, viewHolder, n);
    }

    public List<? extends RecyclerView.Adapter<? extends RecyclerView.ViewHolder>> getAdapters() {
        return Collections.unmodifiableList(this.mController.getCopyOfAdapters());
    }

    public int getItemCount() {
        return this.mController.getTotalCount();
    }

    public long getItemId(int n) {
        return this.mController.getItemId(n);
    }

    public int getItemViewType(int n) {
        return this.mController.getItemViewType(n);
    }

    void internalSetStateRestorationPolicy(RecyclerView.Adapter.StateRestorationPolicy stateRestorationPolicy) {
        super.setStateRestorationPolicy(stateRestorationPolicy);
    }

    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        this.mController.onAttachedToRecyclerView(recyclerView);
    }

    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int n) {
        this.mController.onBindViewHolder(viewHolder, n);
    }

    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int n) {
        return this.mController.onCreateViewHolder(viewGroup, n);
    }

    public void onDetachedFromRecyclerView(RecyclerView recyclerView) {
        this.mController.onDetachedFromRecyclerView(recyclerView);
    }

    public boolean onFailedToRecycleView(RecyclerView.ViewHolder viewHolder) {
        return this.mController.onFailedToRecycleView(viewHolder);
    }

    public void onViewAttachedToWindow(RecyclerView.ViewHolder viewHolder) {
        this.mController.onViewAttachedToWindow(viewHolder);
    }

    public void onViewDetachedFromWindow(RecyclerView.ViewHolder viewHolder) {
        this.mController.onViewDetachedFromWindow(viewHolder);
    }

    public void onViewRecycled(RecyclerView.ViewHolder viewHolder) {
        this.mController.onViewRecycled(viewHolder);
    }

    public boolean removeAdapter(RecyclerView.Adapter<? extends RecyclerView.ViewHolder> adapter) {
        return this.mController.removeAdapter(adapter);
    }

    public void setHasStableIds(boolean bl) {
        throw new UnsupportedOperationException("Calling setHasStableIds is not allowed on the ConcatAdapter. Use the Config object passed in the constructor to control this behavior");
    }

    public void setStateRestorationPolicy(RecyclerView.Adapter.StateRestorationPolicy stateRestorationPolicy) {
        throw new UnsupportedOperationException("Calling setStateRestorationPolicy is not allowed on the ConcatAdapter. This value is inferred from added adapters");
    }
}
