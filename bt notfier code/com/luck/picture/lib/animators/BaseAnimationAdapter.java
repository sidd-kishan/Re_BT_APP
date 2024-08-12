/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.animation.Animator
 *  android.animation.TimeInterpolator
 *  android.view.View
 *  android.view.ViewGroup
 *  android.view.animation.Interpolator
 *  android.view.animation.LinearInterpolator
 *  androidx.recyclerview.widget.RecyclerView
 *  androidx.recyclerview.widget.RecyclerView$Adapter
 *  androidx.recyclerview.widget.RecyclerView$AdapterDataObserver
 *  androidx.recyclerview.widget.RecyclerView$ViewHolder
 *  com.luck.picture.lib.animators.ViewHelper
 */
package com.luck.picture.lib.animators;

import android.animation.Animator;
import android.animation.TimeInterpolator;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import androidx.recyclerview.widget.RecyclerView;
import com.luck.picture.lib.animators.ViewHelper;

public abstract class BaseAnimationAdapter
extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private boolean isFirstOnly = true;
    private RecyclerView.Adapter<RecyclerView.ViewHolder> mAdapter;
    private int mDuration = 250;
    private Interpolator mInterpolator = new LinearInterpolator();
    private int mLastPosition = -1;

    public BaseAnimationAdapter(RecyclerView.Adapter<RecyclerView.ViewHolder> adapter) {
        this.mAdapter = adapter;
    }

    protected abstract Animator[] getAnimators(View var1);

    public int getItemCount() {
        return this.mAdapter.getItemCount();
    }

    public long getItemId(int n) {
        return this.mAdapter.getItemId(n);
    }

    public int getItemViewType(int n) {
        return this.mAdapter.getItemViewType(n);
    }

    public RecyclerView.Adapter<RecyclerView.ViewHolder> getWrappedAdapter() {
        return this.mAdapter;
    }

    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
        this.mAdapter.onAttachedToRecyclerView(recyclerView);
    }

    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder2, int n) {
        int n2;
        this.mAdapter.onBindViewHolder(viewHolder2, n2);
        int n3 = viewHolder2.getAdapterPosition();
        if (this.isFirstOnly && n3 <= this.mLastPosition) {
            ViewHelper.clear((View)viewHolder2.itemView);
        } else {
            for (Animator animator : this.getAnimators(viewHolder2.itemView)) {
                animator.setDuration((long)this.mDuration).start();
                animator.setInterpolator((TimeInterpolator)this.mInterpolator);
            }
            this.mLastPosition = n3;
        }
    }

    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int n) {
        return this.mAdapter.onCreateViewHolder(viewGroup, n);
    }

    public void onDetachedFromRecyclerView(RecyclerView recyclerView) {
        super.onDetachedFromRecyclerView(recyclerView);
        this.mAdapter.onDetachedFromRecyclerView(recyclerView);
    }

    public void onViewAttachedToWindow(RecyclerView.ViewHolder viewHolder) {
        super.onViewAttachedToWindow(viewHolder);
        this.mAdapter.onViewAttachedToWindow(viewHolder);
    }

    public void onViewDetachedFromWindow(RecyclerView.ViewHolder viewHolder) {
        super.onViewDetachedFromWindow(viewHolder);
        this.mAdapter.onViewDetachedFromWindow(viewHolder);
    }

    public void onViewRecycled(RecyclerView.ViewHolder viewHolder) {
        this.mAdapter.onViewRecycled(viewHolder);
        super.onViewRecycled(viewHolder);
    }

    public void registerAdapterDataObserver(RecyclerView.AdapterDataObserver adapterDataObserver) {
        super.registerAdapterDataObserver(adapterDataObserver);
        this.mAdapter.registerAdapterDataObserver(adapterDataObserver);
    }

    public void setDuration(int n) {
        this.mDuration = n;
    }

    public void setFirstOnly(boolean bl) {
        this.isFirstOnly = bl;
    }

    public void setInterpolator(Interpolator interpolator) {
        this.mInterpolator = interpolator;
    }

    public void setStartPosition(int n) {
        this.mLastPosition = n;
    }

    public void unregisterAdapterDataObserver(RecyclerView.AdapterDataObserver adapterDataObserver) {
        super.unregisterAdapterDataObserver(adapterDataObserver);
        this.mAdapter.unregisterAdapterDataObserver(adapterDataObserver);
    }
}
