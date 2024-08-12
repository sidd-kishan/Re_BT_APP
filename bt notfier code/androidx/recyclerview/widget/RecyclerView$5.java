/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.view.View
 *  android.view.ViewGroup$LayoutParams
 *  androidx.recyclerview.widget.ChildHelper$Callback
 *  androidx.recyclerview.widget.RecyclerView
 *  androidx.recyclerview.widget.RecyclerView$ViewHolder
 */
package androidx.recyclerview.widget;

import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.ChildHelper;
import androidx.recyclerview.widget.RecyclerView;

/*
 * Exception performing whole class analysis ignored.
 */
class RecyclerView.5
implements ChildHelper.Callback {
    final RecyclerView this$0;

    RecyclerView.5(RecyclerView recyclerView) {
        this.this$0 = recyclerView;
    }

    public void addView(View view, int n) {
        this.this$0.addView(view, n);
        this.this$0.dispatchChildAttached(view);
    }

    public void attachViewToParent(View object, int n, ViewGroup.LayoutParams layoutParams) {
        RecyclerView.ViewHolder viewHolder = RecyclerView.getChildViewHolderInt((View)object);
        if (viewHolder != null) {
            if (!viewHolder.isTmpDetached() && !viewHolder.shouldIgnore()) {
                object = new StringBuilder();
                ((StringBuilder)object).append("Called attach on a child which is not detached: ");
                ((StringBuilder)object).append(viewHolder);
                ((StringBuilder)object).append(this.this$0.exceptionLabel());
                throw new IllegalArgumentException(((StringBuilder)object).toString());
            }
            viewHolder.clearTmpDetachFlag();
        }
        RecyclerView.access$000((RecyclerView)this.this$0, (View)object, (int)n, (ViewGroup.LayoutParams)layoutParams);
    }

    public void detachViewFromParent(int n) {
        View view = this.getChildAt(n);
        if (view != null && (view = RecyclerView.getChildViewHolderInt((View)view)) != null) {
            if (view.isTmpDetached() && !view.shouldIgnore()) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("called detach on an already detached child ");
                stringBuilder.append(view);
                stringBuilder.append(this.this$0.exceptionLabel());
                throw new IllegalArgumentException(stringBuilder.toString());
            }
            view.addFlags(256);
        }
        RecyclerView.access$100((RecyclerView)this.this$0, (int)n);
    }

    public View getChildAt(int n) {
        return this.this$0.getChildAt(n);
    }

    public int getChildCount() {
        return this.this$0.getChildCount();
    }

    public RecyclerView.ViewHolder getChildViewHolder(View view) {
        return RecyclerView.getChildViewHolderInt((View)view);
    }

    public int indexOfChild(View view) {
        return this.this$0.indexOfChild(view);
    }

    public void onEnteredHiddenState(View view) {
        if ((view = RecyclerView.getChildViewHolderInt((View)view)) == null) return;
        view.onEnteredHiddenState(this.this$0);
    }

    public void onLeftHiddenState(View view) {
        if ((view = RecyclerView.getChildViewHolderInt((View)view)) == null) return;
        view.onLeftHiddenState(this.this$0);
    }

    public void removeAllViews() {
        int n = this.getChildCount();
        int n2 = 0;
        while (true) {
            if (n2 >= n) {
                this.this$0.removeAllViews();
                return;
            }
            View view = this.getChildAt(n2);
            this.this$0.dispatchChildDetached(view);
            view.clearAnimation();
            ++n2;
        }
    }

    public void removeViewAt(int n) {
        View view = this.this$0.getChildAt(n);
        if (view != null) {
            this.this$0.dispatchChildDetached(view);
            view.clearAnimation();
        }
        this.this$0.removeViewAt(n);
    }
}
