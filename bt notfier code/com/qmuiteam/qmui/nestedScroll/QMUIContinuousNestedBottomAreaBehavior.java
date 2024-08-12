/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.graphics.Rect
 *  android.view.View
 *  android.view.View$MeasureSpec
 *  androidx.coordinatorlayout.widget.CoordinatorLayout
 *  androidx.coordinatorlayout.widget.CoordinatorLayout$LayoutParams
 *  androidx.core.view.GravityCompat
 *  com.qmuiteam.qmui.nestedScroll.IQMUIContinuousNestedTopView
 *  com.qmuiteam.qmui.nestedScroll.QMUIViewOffsetBehavior
 */
package com.qmuiteam.qmui.nestedScroll;

import android.graphics.Rect;
import android.view.View;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.GravityCompat;
import com.qmuiteam.qmui.nestedScroll.IQMUIContinuousNestedTopView;
import com.qmuiteam.qmui.nestedScroll.QMUIViewOffsetBehavior;
import java.util.List;

public class QMUIContinuousNestedBottomAreaBehavior
extends QMUIViewOffsetBehavior<View> {
    private int mTopInset = 0;
    private final Rect tempRect1 = new Rect();
    private final Rect tempRect2 = new Rect();

    private static int resolveGravity(int n) {
        int n2 = n;
        if (n != 0) return n2;
        n2 = 0x800033;
        return n2;
    }

    protected void layoutChild(CoordinatorLayout coordinatorLayout, View view, int n) {
        List list = coordinatorLayout.getDependencies(view);
        if (!list.isEmpty()) {
            View view2 = (View)list.get(0);
            list = (CoordinatorLayout.LayoutParams)view.getLayoutParams();
            Rect rect = this.tempRect1;
            rect.set(coordinatorLayout.getPaddingLeft() + ((CoordinatorLayout.LayoutParams)list).leftMargin, view2.getBottom() + ((CoordinatorLayout.LayoutParams)list).topMargin, coordinatorLayout.getWidth() - coordinatorLayout.getPaddingRight() - ((CoordinatorLayout.LayoutParams)list).rightMargin, coordinatorLayout.getHeight() + view2.getBottom() - coordinatorLayout.getPaddingBottom() - ((CoordinatorLayout.LayoutParams)list).bottomMargin);
            coordinatorLayout = this.tempRect2;
            GravityCompat.apply((int)QMUIContinuousNestedBottomAreaBehavior.resolveGravity(((CoordinatorLayout.LayoutParams)list).gravity), (int)view.getMeasuredWidth(), (int)view.getMeasuredHeight(), (Rect)rect, (Rect)coordinatorLayout, (int)n);
            view.layout(coordinatorLayout.left, coordinatorLayout.top, coordinatorLayout.right, coordinatorLayout.bottom);
        } else {
            super.layoutChild(coordinatorLayout, view, n);
        }
    }

    public boolean layoutDependsOn(CoordinatorLayout coordinatorLayout, View view, View view2) {
        return view2 instanceof IQMUIContinuousNestedTopView;
    }

    public boolean onDependentViewChanged(CoordinatorLayout coordinatorLayout, View view, View view2) {
        this.setTopAndBottomOffset(view2.getBottom() - this.getLayoutTop());
        return false;
    }

    public boolean onLayoutChild(CoordinatorLayout object, View view, int n) {
        boolean bl = super.onLayoutChild((CoordinatorLayout)object, view, n);
        if ((object = object.getDependencies(view)).isEmpty()) return bl;
        this.setTopAndBottomOffset(((View)object.get(0)).getBottom() - this.getLayoutTop());
        return bl;
    }

    public boolean onMeasureChild(CoordinatorLayout coordinatorLayout, View view, int n, int n2, int n3, int n4) {
        int n5;
        int n6 = view.getLayoutParams().height;
        if (n6 != -1) {
            if (n6 != -2) return false;
        }
        n3 = n5 = View.MeasureSpec.getSize((int)n3);
        if (n5 == 0) {
            n3 = coordinatorLayout.getHeight();
        }
        int n7 = this.mTopInset;
        n5 = n6 == -1 ? 0x40000000 : Integer.MIN_VALUE;
        coordinatorLayout.onMeasureChild(view, n, n2, View.MeasureSpec.makeMeasureSpec((int)(n3 - n7), (int)n5), n4);
        return true;
    }

    public void setTopInset(int n) {
        this.mTopInset = n;
    }
}
