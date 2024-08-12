/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.view.View
 *  android.view.ViewGroup
 *  androidx.core.util.Pools$Pool
 *  androidx.core.util.Pools$SimplePool
 *  com.qmuiteam.qmui.R$id
 */
package com.qmuiteam.qmui.widget;

import android.view.View;
import android.view.ViewGroup;
import androidx.core.util.Pools;
import com.qmuiteam.qmui.R;
import java.util.ArrayList;
import java.util.List;

public abstract class QMUIItemViewsAdapter<T, V extends View> {
    private Pools.Pool<V> mCachePool;
    private List<T> mItemData = new ArrayList<T>();
    private ViewGroup mParentView;
    private List<V> mViews = new ArrayList<V>();

    public QMUIItemViewsAdapter(ViewGroup viewGroup) {
        this.mParentView = viewGroup;
    }

    private V getView() {
        Object object = this.mCachePool;
        object = object != null ? (View)object.acquire() : null;
        Object object2 = object;
        if (object != null) return (V)object2;
        object2 = this.createView(this.mParentView);
        return (V)object2;
    }

    public QMUIItemViewsAdapter<T, V> addItem(T t) {
        this.mItemData.add(t);
        return this;
    }

    protected abstract void bind(T var1, V var2, int var3);

    public void clear() {
        this.mItemData.clear();
        this.detach(this.mViews.size());
    }

    protected abstract V createView(ViewGroup var1);

    public void detach(int n) {
        int n2 = this.mViews.size();
        while (n2 > 0) {
            Object object;
            if (n <= 0) return;
            View view = (View)this.mViews.remove(n2 - 1);
            if (this.mCachePool == null) {
                this.mCachePool = new Pools.SimplePool(12);
            }
            if ((object = view.getTag(R.id.qmui_view_can_not_cache_tag)) == null || !((Boolean)object).booleanValue()) {
                try {
                    this.mCachePool.release((Object)view);
                }
                catch (Exception exception) {}
            }
            this.mParentView.removeView(view);
            --n2;
            --n;
        }
    }

    public T getItem(int n) {
        List<T> list = this.mItemData;
        if (list == null) {
            return null;
        }
        if (n < 0) return null;
        if (n < list.size()) return this.mItemData.get(n);
        return null;
    }

    public int getSize() {
        List<T> list = this.mItemData;
        if (list != null) return list.size();
        return 0;
    }

    public List<V> getViews() {
        return this.mViews;
    }

    public void replaceItem(int n, T t) throws IllegalAccessException {
        if (n >= this.mItemData.size()) throw new IllegalAccessException("\u66ff\u6362\u6570\u636e\u4e0d\u5b58\u5728");
        if (n < 0) throw new IllegalAccessException("\u66ff\u6362\u6570\u636e\u4e0d\u5b58\u5728");
        this.mItemData.set(n, t);
    }

    public void setup() {
        Object object;
        int n;
        int n2 = this.mItemData.size();
        int n3 = this.mViews.size();
        int n4 = 0;
        if (n3 > n2) {
            this.detach(n3 - n2);
            n = n4;
        } else {
            n = n4;
            if (n3 < n2) {
                int n5 = 0;
                while (true) {
                    n = n4;
                    if (n5 >= n2 - n3) break;
                    object = this.getView();
                    this.mParentView.addView(object);
                    this.mViews.add(object);
                    ++n5;
                }
            }
        }
        while (true) {
            if (n >= n2) {
                this.mParentView.invalidate();
                this.mParentView.requestLayout();
                return;
            }
            object = (View)this.mViews.get(n);
            this.bind(this.mItemData.get(n), object, n);
            ++n;
        }
    }
}
