/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.view.View
 *  androidx.coordinatorlayout.widget.CoordinatorLayout
 *  androidx.coordinatorlayout.widget.CoordinatorLayout$Behavior
 *  com.qmuiteam.qmui.util.QMUIViewOffsetHelper
 */
package com.qmuiteam.qmui.nestedScroll;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.qmuiteam.qmui.util.QMUIViewOffsetHelper;

public class QMUIViewOffsetBehavior<V extends View>
extends CoordinatorLayout.Behavior<V> {
    private int tempLeftRightOffset = 0;
    private int tempTopBottomOffset = 0;
    private QMUIViewOffsetHelper viewOffsetHelper;

    public QMUIViewOffsetBehavior() {
    }

    public QMUIViewOffsetBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public int getLayoutLeft() {
        QMUIViewOffsetHelper qMUIViewOffsetHelper = this.viewOffsetHelper;
        if (qMUIViewOffsetHelper == null) return 0;
        return qMUIViewOffsetHelper.getLayoutLeft();
    }

    public int getLayoutTop() {
        QMUIViewOffsetHelper qMUIViewOffsetHelper = this.viewOffsetHelper;
        if (qMUIViewOffsetHelper == null) return 0;
        return qMUIViewOffsetHelper.getLayoutTop();
    }

    public int getLeftAndRightOffset() {
        QMUIViewOffsetHelper qMUIViewOffsetHelper = this.viewOffsetHelper;
        int n = qMUIViewOffsetHelper != null ? qMUIViewOffsetHelper.getLeftAndRightOffset() : 0;
        return n;
    }

    public int getTopAndBottomOffset() {
        QMUIViewOffsetHelper qMUIViewOffsetHelper = this.viewOffsetHelper;
        int n = qMUIViewOffsetHelper != null ? qMUIViewOffsetHelper.getTopAndBottomOffset() : 0;
        return n;
    }

    public boolean isHorizontalOffsetEnabled() {
        QMUIViewOffsetHelper qMUIViewOffsetHelper = this.viewOffsetHelper;
        boolean bl = qMUIViewOffsetHelper != null && qMUIViewOffsetHelper.isHorizontalOffsetEnabled();
        return bl;
    }

    public boolean isVerticalOffsetEnabled() {
        QMUIViewOffsetHelper qMUIViewOffsetHelper = this.viewOffsetHelper;
        boolean bl = qMUIViewOffsetHelper != null && qMUIViewOffsetHelper.isVerticalOffsetEnabled();
        return bl;
    }

    protected void layoutChild(CoordinatorLayout coordinatorLayout, V v, int n) {
        coordinatorLayout.onLayoutChild(v, n);
    }

    public boolean onLayoutChild(CoordinatorLayout coordinatorLayout, V v, int n) {
        this.layoutChild(coordinatorLayout, v, n);
        if (this.viewOffsetHelper == null) {
            this.viewOffsetHelper = new QMUIViewOffsetHelper(v);
        }
        this.viewOffsetHelper.onViewLayout();
        n = this.tempTopBottomOffset;
        if (n != 0) {
            this.viewOffsetHelper.setTopAndBottomOffset(n);
            this.tempTopBottomOffset = 0;
        }
        if ((n = this.tempLeftRightOffset) == 0) return true;
        this.viewOffsetHelper.setLeftAndRightOffset(n);
        this.tempLeftRightOffset = 0;
        return true;
    }

    public void setHorizontalOffsetEnabled(boolean bl) {
        QMUIViewOffsetHelper qMUIViewOffsetHelper = this.viewOffsetHelper;
        if (qMUIViewOffsetHelper == null) return;
        qMUIViewOffsetHelper.setHorizontalOffsetEnabled(bl);
    }

    public boolean setLeftAndRightOffset(int n) {
        QMUIViewOffsetHelper qMUIViewOffsetHelper = this.viewOffsetHelper;
        if (qMUIViewOffsetHelper != null) {
            return qMUIViewOffsetHelper.setLeftAndRightOffset(n);
        }
        this.tempLeftRightOffset = n;
        return false;
    }

    public boolean setTopAndBottomOffset(int n) {
        QMUIViewOffsetHelper qMUIViewOffsetHelper = this.viewOffsetHelper;
        if (qMUIViewOffsetHelper != null) {
            return qMUIViewOffsetHelper.setTopAndBottomOffset(n);
        }
        this.tempTopBottomOffset = n;
        return false;
    }

    public void setVerticalOffsetEnabled(boolean bl) {
        QMUIViewOffsetHelper qMUIViewOffsetHelper = this.viewOffsetHelper;
        if (qMUIViewOffsetHelper == null) return;
        qMUIViewOffsetHelper.setVerticalOffsetEnabled(bl);
    }
}
