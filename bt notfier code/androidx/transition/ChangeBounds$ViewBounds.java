/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.graphics.PointF
 *  android.view.View
 *  androidx.transition.ViewUtils
 */
package androidx.transition;

import android.graphics.PointF;
import android.view.View;
import androidx.transition.ViewUtils;

private static class ChangeBounds.ViewBounds {
    private int mBottom;
    private int mBottomRightCalls;
    private int mLeft;
    private int mRight;
    private int mTop;
    private int mTopLeftCalls;
    private View mView;

    ChangeBounds.ViewBounds(View view) {
        this.mView = view;
    }

    private void setLeftTopRightBottom() {
        ViewUtils.setLeftTopRightBottom((View)this.mView, (int)this.mLeft, (int)this.mTop, (int)this.mRight, (int)this.mBottom);
        this.mTopLeftCalls = 0;
        this.mBottomRightCalls = 0;
    }

    void setBottomRight(PointF pointF) {
        int n;
        this.mRight = Math.round(pointF.x);
        this.mBottom = Math.round(pointF.y);
        this.mBottomRightCalls = n = this.mBottomRightCalls + 1;
        if (this.mTopLeftCalls != n) return;
        this.setLeftTopRightBottom();
    }

    void setTopLeft(PointF pointF) {
        int n;
        this.mLeft = Math.round(pointF.x);
        this.mTop = Math.round(pointF.y);
        this.mTopLeftCalls = n = this.mTopLeftCalls + 1;
        if (n != this.mBottomRightCalls) return;
        this.setLeftTopRightBottom();
    }
}
