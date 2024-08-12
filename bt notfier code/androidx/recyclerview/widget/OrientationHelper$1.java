/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.view.View
 *  androidx.recyclerview.widget.OrientationHelper
 *  androidx.recyclerview.widget.RecyclerView$LayoutManager
 *  androidx.recyclerview.widget.RecyclerView$LayoutParams
 */
package androidx.recyclerview.widget;

import android.view.View;
import androidx.recyclerview.widget.OrientationHelper;
import androidx.recyclerview.widget.RecyclerView;

class OrientationHelper.1
extends OrientationHelper {
    OrientationHelper.1(RecyclerView.LayoutManager layoutManager) {
        super(layoutManager, null);
    }

    public int getDecoratedEnd(View view) {
        RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams)view.getLayoutParams();
        return this.mLayoutManager.getDecoratedRight(view) + layoutParams.rightMargin;
    }

    public int getDecoratedMeasurement(View view) {
        RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams)view.getLayoutParams();
        return this.mLayoutManager.getDecoratedMeasuredWidth(view) + layoutParams.leftMargin + layoutParams.rightMargin;
    }

    public int getDecoratedMeasurementInOther(View view) {
        RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams)view.getLayoutParams();
        return this.mLayoutManager.getDecoratedMeasuredHeight(view) + layoutParams.topMargin + layoutParams.bottomMargin;
    }

    public int getDecoratedStart(View view) {
        RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams)view.getLayoutParams();
        return this.mLayoutManager.getDecoratedLeft(view) - layoutParams.leftMargin;
    }

    public int getEnd() {
        return this.mLayoutManager.getWidth();
    }

    public int getEndAfterPadding() {
        return this.mLayoutManager.getWidth() - this.mLayoutManager.getPaddingRight();
    }

    public int getEndPadding() {
        return this.mLayoutManager.getPaddingRight();
    }

    public int getMode() {
        return this.mLayoutManager.getWidthMode();
    }

    public int getModeInOther() {
        return this.mLayoutManager.getHeightMode();
    }

    public int getStartAfterPadding() {
        return this.mLayoutManager.getPaddingLeft();
    }

    public int getTotalSpace() {
        return this.mLayoutManager.getWidth() - this.mLayoutManager.getPaddingLeft() - this.mLayoutManager.getPaddingRight();
    }

    public int getTransformedEndWithDecoration(View view) {
        this.mLayoutManager.getTransformedBoundingBox(view, true, this.mTmpRect);
        return this.mTmpRect.right;
    }

    public int getTransformedStartWithDecoration(View view) {
        this.mLayoutManager.getTransformedBoundingBox(view, true, this.mTmpRect);
        return this.mTmpRect.left;
    }

    public void offsetChild(View view, int n) {
        view.offsetLeftAndRight(n);
    }

    public void offsetChildren(int n) {
        this.mLayoutManager.offsetChildrenHorizontal(n);
    }
}
