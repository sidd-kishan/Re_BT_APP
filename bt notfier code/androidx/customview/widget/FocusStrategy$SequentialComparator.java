/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.graphics.Rect
 *  androidx.customview.widget.FocusStrategy$BoundsAdapter
 */
package androidx.customview.widget;

import android.graphics.Rect;
import androidx.customview.widget.FocusStrategy;
import java.util.Comparator;

private static class FocusStrategy.SequentialComparator<T>
implements Comparator<T> {
    private final FocusStrategy.BoundsAdapter<T> mAdapter;
    private final boolean mIsLayoutRtl;
    private final Rect mTemp1 = new Rect();
    private final Rect mTemp2 = new Rect();

    FocusStrategy.SequentialComparator(boolean bl, FocusStrategy.BoundsAdapter<T> boundsAdapter) {
        this.mIsLayoutRtl = bl;
        this.mAdapter = boundsAdapter;
    }

    @Override
    public int compare(T t, T t2) {
        Rect rect = this.mTemp1;
        Rect rect2 = this.mTemp2;
        this.mAdapter.obtainBounds(t, rect);
        this.mAdapter.obtainBounds(t2, rect2);
        int n = rect.top;
        int n2 = rect2.top;
        int n3 = -1;
        if (n < n2) {
            return -1;
        }
        if (rect.top > rect2.top) {
            return 1;
        }
        if (rect.left < rect2.left) {
            if (!this.mIsLayoutRtl) return n3;
            n3 = 1;
            return n3;
        }
        if (rect.left > rect2.left) {
            if (this.mIsLayoutRtl) return n3;
            n3 = 1;
            return n3;
        }
        if (rect.bottom < rect2.bottom) {
            return -1;
        }
        if (rect.bottom > rect2.bottom) {
            return 1;
        }
        if (rect.right < rect2.right) {
            if (!this.mIsLayoutRtl) return n3;
            n3 = 1;
            return n3;
        }
        if (rect.right <= rect2.right) return 0;
        if (this.mIsLayoutRtl) return n3;
        n3 = 1;
        return n3;
    }
}
