/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.view.View
 *  androidx.recyclerview.widget.OrientationHelper
 *  androidx.recyclerview.widget.RecyclerView$LayoutManager
 *  androidx.recyclerview.widget.RecyclerView$SmoothScroller
 *  androidx.recyclerview.widget.RecyclerView$SmoothScroller$ScrollVectorProvider
 *  androidx.recyclerview.widget.SnapHelper
 */
package androidx.recyclerview.widget;

import android.view.View;
import androidx.recyclerview.widget.OrientationHelper;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.SnapHelper;

public class PagerSnapHelper
extends SnapHelper {
    private static final int MAX_SCROLL_ON_FLING_DURATION = 100;
    private OrientationHelper mHorizontalHelper;
    private OrientationHelper mVerticalHelper;

    private int distanceToCenter(View view, OrientationHelper orientationHelper) {
        return orientationHelper.getDecoratedStart(view) + orientationHelper.getDecoratedMeasurement(view) / 2 - (orientationHelper.getStartAfterPadding() + orientationHelper.getTotalSpace() / 2);
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

    private OrientationHelper getOrientationHelper(RecyclerView.LayoutManager layoutManager) {
        if (layoutManager.canScrollVertically()) {
            return this.getVerticalHelper(layoutManager);
        }
        if (!layoutManager.canScrollHorizontally()) return null;
        return this.getHorizontalHelper(layoutManager);
    }

    private OrientationHelper getVerticalHelper(RecyclerView.LayoutManager layoutManager) {
        OrientationHelper orientationHelper = this.mVerticalHelper;
        if (orientationHelper != null) {
            if (orientationHelper.mLayoutManager == layoutManager) return this.mVerticalHelper;
        }
        this.mVerticalHelper = OrientationHelper.createVerticalHelper((RecyclerView.LayoutManager)layoutManager);
        return this.mVerticalHelper;
    }

    private boolean isForwardFling(RecyclerView.LayoutManager layoutManager, int n, int n2) {
        boolean bl = layoutManager.canScrollHorizontally();
        boolean bl2 = true;
        boolean bl3 = true;
        if (bl) {
            if (n > 0) return bl3;
            bl3 = false;
            return bl3;
        }
        bl3 = n2 > 0 ? bl2 : false;
        return bl3;
    }

    private boolean isReverseLayout(RecyclerView.LayoutManager layoutManager) {
        boolean bl;
        int n = layoutManager.getItemCount();
        boolean bl2 = layoutManager instanceof RecyclerView.SmoothScroller.ScrollVectorProvider;
        boolean bl3 = bl = false;
        if (!bl2) return bl3;
        layoutManager = ((RecyclerView.SmoothScroller.ScrollVectorProvider)layoutManager).computeScrollVectorForPosition(n - 1);
        bl3 = bl;
        if (layoutManager == null) return bl3;
        if (!(layoutManager.x < 0.0f)) {
            bl3 = bl;
            if (!(layoutManager.y < 0.0f)) return bl3;
        }
        bl3 = true;
        return bl3;
    }

    public int[] calculateDistanceToFinalSnap(RecyclerView.LayoutManager layoutManager, View view) {
        int[] nArray = new int[]{layoutManager.canScrollHorizontally() ? this.distanceToCenter(view, this.getHorizontalHelper(layoutManager)) : 0, layoutManager.canScrollVertically() ? this.distanceToCenter(view, this.getVerticalHelper(layoutManager)) : 0};
        return nArray;
    }

    protected RecyclerView.SmoothScroller createScroller(RecyclerView.LayoutManager layoutManager) {
        if (layoutManager instanceof RecyclerView.SmoothScroller.ScrollVectorProvider) return new /* Unavailable Anonymous Inner Class!! */;
        return null;
    }

    public View findSnapView(RecyclerView.LayoutManager layoutManager) {
        if (layoutManager.canScrollVertically()) {
            return this.findCenterView(layoutManager, this.getVerticalHelper(layoutManager));
        }
        if (!layoutManager.canScrollHorizontally()) return null;
        return this.findCenterView(layoutManager, this.getHorizontalHelper(layoutManager));
    }

    public int findTargetSnapPosition(RecyclerView.LayoutManager layoutManager, int n, int n2) {
        int n3 = layoutManager.getItemCount();
        if (n3 == 0) {
            return -1;
        }
        OrientationHelper orientationHelper = this.getOrientationHelper(layoutManager);
        if (orientationHelper == null) {
            return -1;
        }
        int n4 = Integer.MIN_VALUE;
        int n5 = Integer.MAX_VALUE;
        int n6 = layoutManager.getChildCount();
        View view = null;
        View view2 = null;
        for (int i = 0; i < n6; ++i) {
            View view3;
            int n7;
            View view4 = layoutManager.getChildAt(i);
            if (view4 == null) {
                n7 = n5;
                view3 = view;
            } else {
                int n8 = this.distanceToCenter(view4, orientationHelper);
                int n9 = n4;
                View view5 = view2;
                if (n8 <= 0) {
                    n9 = n4;
                    view5 = view2;
                    if (n8 > n4) {
                        view5 = view4;
                        n9 = n8;
                    }
                }
                n4 = n9;
                n7 = n5;
                view3 = view;
                view2 = view5;
                if (n8 >= 0) {
                    n4 = n9;
                    n7 = n5;
                    view3 = view;
                    view2 = view5;
                    if (n8 < n5) {
                        view2 = view5;
                        view3 = view4;
                        n7 = n8;
                        n4 = n9;
                    }
                }
            }
            n5 = n7;
            view = view3;
        }
        boolean bl = this.isForwardFling(layoutManager, n, n2);
        if (bl && view != null) {
            return layoutManager.getPosition(view);
        }
        if (!bl && view2 != null) {
            return layoutManager.getPosition(view2);
        }
        if (bl) {
            view = view2;
        }
        if (view == null) {
            return -1;
        }
        n2 = layoutManager.getPosition(view);
        n = this.isReverseLayout(layoutManager) == bl ? -1 : 1;
        n = n2 + n;
        if (n < 0) return -1;
        if (n < n3) return n;
        return -1;
    }
}
