/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.view.View
 *  androidx.recyclerview.widget.OrientationHelper
 *  androidx.recyclerview.widget.RecyclerView$LayoutManager
 *  androidx.recyclerview.widget.RecyclerView$SmoothScroller$ScrollVectorProvider
 *  androidx.recyclerview.widget.SnapHelper
 */
package androidx.recyclerview.widget;

import android.view.View;
import androidx.recyclerview.widget.OrientationHelper;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.SnapHelper;

public class LinearSnapHelper
extends SnapHelper {
    private static final float INVALID_DISTANCE = 1.0f;
    private OrientationHelper mHorizontalHelper;
    private OrientationHelper mVerticalHelper;

    private float computeDistancePerChild(RecyclerView.LayoutManager layoutManager, OrientationHelper orientationHelper) {
        int n;
        int n2 = layoutManager.getChildCount();
        if (n2 == 0) {
            return 1.0f;
        }
        View view = null;
        View view2 = null;
        int n3 = Integer.MAX_VALUE;
        int n4 = Integer.MIN_VALUE;
        for (int i = 0; i < n2; ++i) {
            int n5;
            View view3;
            View view4 = layoutManager.getChildAt(i);
            int n6 = layoutManager.getPosition(view4);
            if (n6 == -1) {
                view3 = view;
                n5 = n4;
            } else {
                n = n3;
                if (n6 < n3) {
                    view = view4;
                    n = n6;
                }
                view3 = view;
                n3 = n;
                n5 = n4;
                if (n6 > n4) {
                    view2 = view4;
                    n5 = n6;
                    n3 = n;
                    view3 = view;
                }
            }
            view = view3;
            n4 = n5;
        }
        if (view == null) return 1.0f;
        if (view2 == null) {
            return 1.0f;
        }
        n = Math.min(orientationHelper.getDecoratedStart(view), orientationHelper.getDecoratedStart(view2));
        n = Math.max(orientationHelper.getDecoratedEnd(view), orientationHelper.getDecoratedEnd(view2)) - n;
        if (n != 0) return (float)n * 1.0f / (float)(n4 - n3 + 1);
        return 1.0f;
    }

    private int distanceToCenter(View view, OrientationHelper orientationHelper) {
        return orientationHelper.getDecoratedStart(view) + orientationHelper.getDecoratedMeasurement(view) / 2 - (orientationHelper.getStartAfterPadding() + orientationHelper.getTotalSpace() / 2);
    }

    private int estimateNextPositionDiffForFling(RecyclerView.LayoutManager layoutManager, OrientationHelper orientationHelper, int n, int n2) {
        int[] nArray = this.calculateScrollDistance(n, n2);
        float f = this.computeDistancePerChild(layoutManager, orientationHelper);
        if (f <= 0.0f) {
            return 0;
        }
        n = Math.abs(nArray[0]) > Math.abs(nArray[1]) ? nArray[0] : nArray[1];
        return Math.round((float)n / f);
    }

    private View findCenterView(RecyclerView.LayoutManager layoutManager, OrientationHelper orientationHelper) {
        int n = layoutManager.getChildCount();
        View view = null;
        if (n == 0) {
            return null;
        }
        int n2 = orientationHelper.getStartAfterPadding();
        int n3 = orientationHelper.getTotalSpace() / 2;
        int n4 = Integer.MAX_VALUE;
        int n5 = 0;
        while (n5 < n) {
            View view2 = layoutManager.getChildAt(n5);
            int n6 = Math.abs(orientationHelper.getDecoratedStart(view2) + orientationHelper.getDecoratedMeasurement(view2) / 2 - (n2 + n3));
            int n7 = n4;
            if (n6 < n4) {
                view = view2;
                n7 = n6;
            }
            ++n5;
            n4 = n7;
        }
        return view;
    }

    private OrientationHelper getHorizontalHelper(RecyclerView.LayoutManager layoutManager) {
        OrientationHelper orientationHelper = this.mHorizontalHelper;
        if (orientationHelper != null) {
            if (orientationHelper.mLayoutManager == layoutManager) return this.mHorizontalHelper;
        }
        this.mHorizontalHelper = OrientationHelper.createHorizontalHelper((RecyclerView.LayoutManager)layoutManager);
        return this.mHorizontalHelper;
    }

    private OrientationHelper getVerticalHelper(RecyclerView.LayoutManager layoutManager) {
        OrientationHelper orientationHelper = this.mVerticalHelper;
        if (orientationHelper != null) {
            if (orientationHelper.mLayoutManager == layoutManager) return this.mVerticalHelper;
        }
        this.mVerticalHelper = OrientationHelper.createVerticalHelper((RecyclerView.LayoutManager)layoutManager);
        return this.mVerticalHelper;
    }

    public int[] calculateDistanceToFinalSnap(RecyclerView.LayoutManager layoutManager, View view) {
        int[] nArray = new int[]{layoutManager.canScrollHorizontally() ? this.distanceToCenter(view, this.getHorizontalHelper(layoutManager)) : 0, layoutManager.canScrollVertically() ? this.distanceToCenter(view, this.getVerticalHelper(layoutManager)) : 0};
        return nArray;
    }

    public View findSnapView(RecyclerView.LayoutManager layoutManager) {
        if (layoutManager.canScrollVertically()) {
            return this.findCenterView(layoutManager, this.getVerticalHelper(layoutManager));
        }
        if (!layoutManager.canScrollHorizontally()) return null;
        return this.findCenterView(layoutManager, this.getHorizontalHelper(layoutManager));
    }

    public int findTargetSnapPosition(RecyclerView.LayoutManager layoutManager, int n, int n2) {
        int n3;
        if (!(layoutManager instanceof RecyclerView.SmoothScroller.ScrollVectorProvider)) {
            return -1;
        }
        int n4 = layoutManager.getItemCount();
        if (n4 == 0) {
            return -1;
        }
        View view = this.findSnapView(layoutManager);
        if (view == null) {
            return -1;
        }
        int n5 = layoutManager.getPosition(view);
        if (n5 == -1) {
            return -1;
        }
        view = (RecyclerView.SmoothScroller.ScrollVectorProvider)layoutManager;
        int n6 = n4 - 1;
        if ((view = view.computeScrollVectorForPosition(n6)) == null) {
            return -1;
        }
        boolean bl = layoutManager.canScrollHorizontally();
        int n7 = 0;
        if (bl) {
            n = n3 = this.estimateNextPositionDiffForFling(layoutManager, this.getHorizontalHelper(layoutManager), n, 0);
            if (view.x < 0.0f) {
                n = -n3;
            }
        } else {
            n = 0;
        }
        if (layoutManager.canScrollVertically()) {
            n2 = n3 = this.estimateNextPositionDiffForFling(layoutManager, this.getVerticalHelper(layoutManager), 0, n2);
            if (view.y < 0.0f) {
                n2 = -n3;
            }
        } else {
            n2 = 0;
        }
        if (layoutManager.canScrollVertically()) {
            n = n2;
        }
        if (n == 0) {
            return -1;
        }
        if ((n = n5 + n) < 0) {
            n = n7;
        }
        if (n < n4) return n;
        n = n6;
        return n;
    }
}
