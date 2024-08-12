/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.view.View
 *  android.view.ViewGroup$LayoutParams
 *  androidx.recyclerview.widget.ChildHelper$Bucket
 *  androidx.recyclerview.widget.ChildHelper$Callback
 *  androidx.recyclerview.widget.RecyclerView$ViewHolder
 */
package androidx.recyclerview.widget;

import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.ChildHelper;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

class ChildHelper {
    private static final boolean DEBUG = false;
    private static final String TAG = "ChildrenHelper";
    final Bucket mBucket;
    final Callback mCallback;
    final List<View> mHiddenViews;

    ChildHelper(Callback callback) {
        this.mCallback = callback;
        this.mBucket = new Bucket();
        this.mHiddenViews = new ArrayList<View>();
    }

    private int getOffset(int n) {
        if (n < 0) {
            return -1;
        }
        int n2 = this.mCallback.getChildCount();
        int n3 = n;
        while (n3 < n2) {
            int n4 = n - (n3 - this.mBucket.countOnesBefore(n3));
            if (n4 == 0) {
                while (this.mBucket.get(n3)) {
                    ++n3;
                }
                return n3;
            }
            n3 += n4;
        }
        return -1;
    }

    private void hideViewInternal(View view) {
        this.mHiddenViews.add(view);
        this.mCallback.onEnteredHiddenState(view);
    }

    private boolean unhideViewInternal(View view) {
        if (!this.mHiddenViews.remove(view)) return false;
        this.mCallback.onLeftHiddenState(view);
        return true;
    }

    void addView(View view, int n, boolean bl) {
        n = n < 0 ? this.mCallback.getChildCount() : this.getOffset(n);
        this.mBucket.insert(n, bl);
        if (bl) {
            this.hideViewInternal(view);
        }
        this.mCallback.addView(view, n);
    }

    void addView(View view, boolean bl) {
        this.addView(view, -1, bl);
    }

    void attachViewToParent(View view, int n, ViewGroup.LayoutParams layoutParams, boolean bl) {
        n = n < 0 ? this.mCallback.getChildCount() : this.getOffset(n);
        this.mBucket.insert(n, bl);
        if (bl) {
            this.hideViewInternal(view);
        }
        this.mCallback.attachViewToParent(view, n, layoutParams);
    }

    void detachViewFromParent(int n) {
        n = this.getOffset(n);
        this.mBucket.remove(n);
        this.mCallback.detachViewFromParent(n);
    }

    View findHiddenNonRemovedView(int n) {
        int n2 = this.mHiddenViews.size();
        int n3 = 0;
        while (n3 < n2) {
            View view = this.mHiddenViews.get(n3);
            RecyclerView.ViewHolder viewHolder = this.mCallback.getChildViewHolder(view);
            if (viewHolder.getLayoutPosition() == n && !viewHolder.isInvalid() && !viewHolder.isRemoved()) {
                return view;
            }
            ++n3;
        }
        return null;
    }

    View getChildAt(int n) {
        n = this.getOffset(n);
        return this.mCallback.getChildAt(n);
    }

    int getChildCount() {
        return this.mCallback.getChildCount() - this.mHiddenViews.size();
    }

    View getUnfilteredChildAt(int n) {
        return this.mCallback.getChildAt(n);
    }

    int getUnfilteredChildCount() {
        return this.mCallback.getChildCount();
    }

    void hide(View view) {
        int n = this.mCallback.indexOfChild(view);
        if (n >= 0) {
            this.mBucket.set(n);
            this.hideViewInternal(view);
            return;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("view is not a child, cannot hide ");
        stringBuilder.append(view);
        throw new IllegalArgumentException(stringBuilder.toString());
    }

    int indexOfChild(View view) {
        int n = this.mCallback.indexOfChild(view);
        if (n == -1) {
            return -1;
        }
        if (!this.mBucket.get(n)) return n - this.mBucket.countOnesBefore(n);
        return -1;
    }

    boolean isHidden(View view) {
        return this.mHiddenViews.contains(view);
    }

    void removeAllViewsUnfiltered() {
        this.mBucket.reset();
        int n = this.mHiddenViews.size() - 1;
        while (true) {
            if (n < 0) {
                this.mCallback.removeAllViews();
                return;
            }
            this.mCallback.onLeftHiddenState(this.mHiddenViews.get(n));
            this.mHiddenViews.remove(n);
            --n;
        }
    }

    void removeView(View view) {
        int n = this.mCallback.indexOfChild(view);
        if (n < 0) {
            return;
        }
        if (this.mBucket.remove(n)) {
            this.unhideViewInternal(view);
        }
        this.mCallback.removeViewAt(n);
    }

    void removeViewAt(int n) {
        View view = this.mCallback.getChildAt(n = this.getOffset(n));
        if (view == null) {
            return;
        }
        if (this.mBucket.remove(n)) {
            this.unhideViewInternal(view);
        }
        this.mCallback.removeViewAt(n);
    }

    boolean removeViewIfHidden(View view) {
        int n = this.mCallback.indexOfChild(view);
        if (n == -1) {
            this.unhideViewInternal(view);
            return true;
        }
        if (!this.mBucket.get(n)) return false;
        this.mBucket.remove(n);
        this.unhideViewInternal(view);
        this.mCallback.removeViewAt(n);
        return true;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.mBucket.toString());
        stringBuilder.append(", hidden list:");
        stringBuilder.append(this.mHiddenViews.size());
        return stringBuilder.toString();
    }

    void unhide(View view) {
        int n = this.mCallback.indexOfChild(view);
        if (n < 0) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("view is not a child, cannot hide ");
            stringBuilder.append(view);
            throw new IllegalArgumentException(stringBuilder.toString());
        }
        if (this.mBucket.get(n)) {
            this.mBucket.clear(n);
            this.unhideViewInternal(view);
            return;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("trying to unhide a view that was not hidden");
        stringBuilder.append(view);
        throw new RuntimeException(stringBuilder.toString());
    }
}
