/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.view.View
 *  androidx.core.view.ViewCompat
 */
package com.qmuiteam.qmui.util;

import android.view.View;
import androidx.core.view.ViewCompat;

public class QMUIViewOffsetHelper {
    private boolean mHorizontalOffsetEnabled = true;
    private int mLayoutLeft;
    private int mLayoutTop;
    private int mOffsetLeft;
    private int mOffsetTop;
    private boolean mVerticalOffsetEnabled = true;
    private final View mView;

    public QMUIViewOffsetHelper(View view) {
        this.mView = view;
    }

    private void updateOffsets() {
        View view = this.mView;
        ViewCompat.offsetTopAndBottom((View)view, (int)(this.mOffsetTop - (view.getTop() - this.mLayoutTop)));
        view = this.mView;
        ViewCompat.offsetLeftAndRight((View)view, (int)(this.mOffsetLeft - (view.getLeft() - this.mLayoutLeft)));
    }

    public int getLayoutLeft() {
        return this.mLayoutLeft;
    }

    public int getLayoutTop() {
        return this.mLayoutTop;
    }

    public int getLeftAndRightOffset() {
        return this.mOffsetLeft;
    }

    public int getTopAndBottomOffset() {
        return this.mOffsetTop;
    }

    public boolean isHorizontalOffsetEnabled() {
        return this.mHorizontalOffsetEnabled;
    }

    public boolean isVerticalOffsetEnabled() {
        return this.mVerticalOffsetEnabled;
    }

    public void onViewLayout() {
        this.mLayoutTop = this.mView.getTop();
        this.mLayoutLeft = this.mView.getLeft();
        this.updateOffsets();
    }

    public void setHorizontalOffsetEnabled(boolean bl) {
        this.mHorizontalOffsetEnabled = bl;
    }

    public boolean setLeftAndRightOffset(int n) {
        if (!this.mHorizontalOffsetEnabled) return false;
        if (this.mOffsetLeft == n) return false;
        this.mOffsetLeft = n;
        this.updateOffsets();
        return true;
    }

    public boolean setOffset(int n, int n2) {
        if (!this.mHorizontalOffsetEnabled && !this.mVerticalOffsetEnabled) {
            return false;
        }
        if (this.mHorizontalOffsetEnabled && this.mVerticalOffsetEnabled) {
            if (this.mOffsetLeft == n) {
                if (this.mOffsetTop == n2) return false;
            }
            this.mOffsetLeft = n;
            this.mOffsetTop = n2;
            this.updateOffsets();
            return true;
        }
        if (!this.mHorizontalOffsetEnabled) return this.setTopAndBottomOffset(n2);
        return this.setLeftAndRightOffset(n);
    }

    public boolean setTopAndBottomOffset(int n) {
        if (!this.mVerticalOffsetEnabled) return false;
        if (this.mOffsetTop == n) return false;
        this.mOffsetTop = n;
        this.updateOffsets();
        return true;
    }

    public void setVerticalOffsetEnabled(boolean bl) {
        this.mVerticalOffsetEnabled = bl;
    }
}
