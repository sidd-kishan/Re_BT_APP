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

class OrientationHelper.2
extends OrientationHelper {
    OrientationHelper.2(RecyclerView.LayoutManager layoutManager) {
        super(layoutManager, null);
    }

    public int getDecoratedEnd(View view) {
        RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams)view.getLayoutParams();
        return this.mLayoutManager.getDecoratedBottom(view) + layoutParams.bottomMargin;
    }

    public int getDecoratedMeasurement(View view) {
        RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams)view.getLayoutParams();
        return this.mLayoutManager.getDecoratedMeasuredHeight(view) + layoutParams.topMargin + layoutParams.bottomMargin;
    }

    public int getDecoratedMeasurementInOther(View view) {
        RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams)view.getLayoutParams();
        return this.mLayoutManager.getDecoratedMeasuredWidth(view) + layoutParams.leftMargin + layoutParams.rightMargin;
    }

    public int getDecoratedStart(View view) {
        RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams)view.getLayoutParams();
        return this.mLayoutManager.getDecoratedTop(view) - layoutParams.topMargin;
    }

    public int getEnd() {
        return this.mLayoutManager.getHeight();
    }

    public int getEndAfterPadding() {
        return this.mLayoutManager.getHeight() - this.mLayoutManager.getPaddingBottom();
    }

    public int getEndPadding() {
        return this.mLayoutManager.getPaddingBottom();
    }

    public int getMode() {
        return this.mLayoutManager.getHeightMode();
    }

    public int getModeInOther() {
        return this.mLayoutManager.getWidthMode();
    }

    public int getStartAfterPadding() {
        return this.mLayoutManager.getPaddingTop();
    }

    public int getTotalSpace() {
        return this.mLayoutManager.getHeight() - this.mLayoutManager.getPaddingTop() - this.mLayoutManager.getPaddingBottom();
    }

    public int getTransformedEndWithDecoration(View view) {
        this.mLayoutManager.getTransformedBoundingBox(view, true, this.mTmpRect);
        return this.mTmpRect.bottom;
    }

    public int getTransformedStartWithDecoration(View view) {
        this.mLayoutManager.getTransformedBoundingBox(view, true, this.mTmpRect);
        return this.mTmpRect.top;
    }

    public void offsetChild(View view, int n) {
        view.offsetTopAndBottom(n);
    }

    public void offsetChildren(int n) {
        this.mLayoutManager.offsetChildrenVertical(n);
    }
}
