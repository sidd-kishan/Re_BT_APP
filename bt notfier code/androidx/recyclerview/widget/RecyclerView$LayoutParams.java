/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.graphics.Rect
 *  android.view.ViewGroup$LayoutParams
 *  android.view.ViewGroup$MarginLayoutParams
 *  androidx.recyclerview.widget.RecyclerView$ViewHolder
 */
package androidx.recyclerview.widget;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;

public static class RecyclerView.LayoutParams
extends ViewGroup.MarginLayoutParams {
    final Rect mDecorInsets = new Rect();
    boolean mInsetsDirty = true;
    boolean mPendingInvalidate = false;
    RecyclerView.ViewHolder mViewHolder;

    public RecyclerView.LayoutParams(int n, int n2) {
        super(n, n2);
    }

    public RecyclerView.LayoutParams(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public RecyclerView.LayoutParams(ViewGroup.LayoutParams layoutParams) {
        super(layoutParams);
    }

    public RecyclerView.LayoutParams(ViewGroup.MarginLayoutParams marginLayoutParams) {
        super(marginLayoutParams);
    }

    public RecyclerView.LayoutParams(RecyclerView.LayoutParams layoutParams) {
        super((ViewGroup.LayoutParams)layoutParams);
    }

    public int getAbsoluteAdapterPosition() {
        return this.mViewHolder.getAbsoluteAdapterPosition();
    }

    public int getBindingAdapterPosition() {
        return this.mViewHolder.getBindingAdapterPosition();
    }

    @Deprecated
    public int getViewAdapterPosition() {
        return this.mViewHolder.getBindingAdapterPosition();
    }

    public int getViewLayoutPosition() {
        return this.mViewHolder.getLayoutPosition();
    }

    @Deprecated
    public int getViewPosition() {
        return this.mViewHolder.getPosition();
    }

    public boolean isItemChanged() {
        return this.mViewHolder.isUpdated();
    }

    public boolean isItemRemoved() {
        return this.mViewHolder.isRemoved();
    }

    public boolean isViewInvalid() {
        return this.mViewHolder.isInvalid();
    }

    public boolean viewNeedsUpdate() {
        return this.mViewHolder.needsUpdate();
    }
}
