/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.graphics.Rect
 *  android.view.View
 *  androidx.recyclerview.widget.RecyclerView$LayoutManager
 */
package androidx.recyclerview.widget;

import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;

public abstract class OrientationHelper {
    public static final int HORIZONTAL = 0;
    private static final int INVALID_SIZE = Integer.MIN_VALUE;
    public static final int VERTICAL = 1;
    private int mLastTotalSpace = Integer.MIN_VALUE;
    protected final RecyclerView.LayoutManager mLayoutManager;
    final Rect mTmpRect = new Rect();

    private OrientationHelper(RecyclerView.LayoutManager layoutManager) {
        this.mLayoutManager = layoutManager;
    }

    public static OrientationHelper createHorizontalHelper(RecyclerView.LayoutManager layoutManager) {
        return new /* Unavailable Anonymous Inner Class!! */;
    }

    public static OrientationHelper createOrientationHelper(RecyclerView.LayoutManager layoutManager, int n) {
        if (n == 0) return OrientationHelper.createHorizontalHelper(layoutManager);
        if (n != 1) throw new IllegalArgumentException("invalid orientation");
        return OrientationHelper.createVerticalHelper(layoutManager);
    }

    public static OrientationHelper createVerticalHelper(RecyclerView.LayoutManager layoutManager) {
        return new /* Unavailable Anonymous Inner Class!! */;
    }

    public abstract int getDecoratedEnd(View var1);

    public abstract int getDecoratedMeasurement(View var1);

    public abstract int getDecoratedMeasurementInOther(View var1);

    public abstract int getDecoratedStart(View var1);

    public abstract int getEnd();

    public abstract int getEndAfterPadding();

    public abstract int getEndPadding();

    public RecyclerView.LayoutManager getLayoutManager() {
        return this.mLayoutManager;
    }

    public abstract int getMode();

    public abstract int getModeInOther();

    public abstract int getStartAfterPadding();

    public abstract int getTotalSpace();

    public int getTotalSpaceChange() {
        int n = Integer.MIN_VALUE == this.mLastTotalSpace ? 0 : this.getTotalSpace() - this.mLastTotalSpace;
        return n;
    }

    public abstract int getTransformedEndWithDecoration(View var1);

    public abstract int getTransformedStartWithDecoration(View var1);

    public abstract void offsetChild(View var1, int var2);

    public abstract void offsetChildren(int var1);

    public void onLayoutComplete() {
        this.mLastTotalSpace = this.getTotalSpace();
    }
}
