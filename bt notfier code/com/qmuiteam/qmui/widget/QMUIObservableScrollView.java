/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.widget.ScrollView
 *  com.qmuiteam.qmui.widget.QMUIObservableScrollView$OnScrollChangedListener
 */
package com.qmuiteam.qmui.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ScrollView;
import com.qmuiteam.qmui.widget.QMUIObservableScrollView;
import java.util.ArrayList;
import java.util.List;

public class QMUIObservableScrollView
extends ScrollView {
    private List<OnScrollChangedListener> mOnScrollChangedListeners;
    private int mScrollOffset = 0;

    public QMUIObservableScrollView(Context context) {
        super(context);
    }

    public QMUIObservableScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public QMUIObservableScrollView(Context context, AttributeSet attributeSet, int n) {
        super(context, attributeSet, n);
    }

    public void addOnScrollChangedListener(OnScrollChangedListener onScrollChangedListener) {
        if (this.mOnScrollChangedListeners == null) {
            this.mOnScrollChangedListeners = new ArrayList<OnScrollChangedListener>();
        }
        if (this.mOnScrollChangedListeners.contains(onScrollChangedListener)) {
            return;
        }
        this.mOnScrollChangedListeners.add(onScrollChangedListener);
    }

    public int getScrollOffset() {
        return this.mScrollOffset;
    }

    protected void onScrollChanged(int n, int n2, int n3, int n4) {
        super.onScrollChanged(n, n2, n3, n4);
        this.mScrollOffset = n2;
        Object object = this.mOnScrollChangedListeners;
        if (object == null) return;
        if (object.isEmpty()) return;
        object = this.mOnScrollChangedListeners.iterator();
        while (object.hasNext()) {
            ((OnScrollChangedListener)object.next()).onScrollChanged(this, n, n2, n3, n4);
        }
    }

    public void removeOnScrollChangedListener(OnScrollChangedListener onScrollChangedListener) {
        List<OnScrollChangedListener> list = this.mOnScrollChangedListeners;
        if (list == null) {
            return;
        }
        list.remove(onScrollChangedListener);
    }
}
