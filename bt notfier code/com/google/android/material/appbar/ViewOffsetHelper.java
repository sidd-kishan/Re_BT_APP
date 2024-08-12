/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.view.View
 *  androidx.core.view.ViewCompat
 */
package com.google.android.material.appbar;

import android.view.View;
import androidx.core.view.ViewCompat;

class ViewOffsetHelper {
    private int layoutLeft;
    private int layoutTop;
    private int offsetLeft;
    private int offsetTop;
    private final View view;

    public ViewOffsetHelper(View view) {
        this.view = view;
    }

    private void updateOffsets() {
        View view = this.view;
        ViewCompat.offsetTopAndBottom((View)view, (int)(this.offsetTop - (view.getTop() - this.layoutTop)));
        view = this.view;
        ViewCompat.offsetLeftAndRight((View)view, (int)(this.offsetLeft - (view.getLeft() - this.layoutLeft)));
    }

    public int getLayoutLeft() {
        return this.layoutLeft;
    }

    public int getLayoutTop() {
        return this.layoutTop;
    }

    public int getLeftAndRightOffset() {
        return this.offsetLeft;
    }

    public int getTopAndBottomOffset() {
        return this.offsetTop;
    }

    public void onViewLayout() {
        this.layoutTop = this.view.getTop();
        this.layoutLeft = this.view.getLeft();
        this.updateOffsets();
    }

    public boolean setLeftAndRightOffset(int n) {
        if (this.offsetLeft == n) return false;
        this.offsetLeft = n;
        this.updateOffsets();
        return true;
    }

    public boolean setTopAndBottomOffset(int n) {
        if (this.offsetTop == n) return false;
        this.offsetTop = n;
        this.updateOffsets();
        return true;
    }
}
