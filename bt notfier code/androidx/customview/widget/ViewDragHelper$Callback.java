/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.view.View
 */
package androidx.customview.widget;

import android.view.View;

public static abstract class ViewDragHelper.Callback {
    public int clampViewPositionHorizontal(View view, int n, int n2) {
        return 0;
    }

    public int clampViewPositionVertical(View view, int n, int n2) {
        return 0;
    }

    public int getOrderedChildIndex(int n) {
        return n;
    }

    public int getViewHorizontalDragRange(View view) {
        return 0;
    }

    public int getViewVerticalDragRange(View view) {
        return 0;
    }

    public void onEdgeDragStarted(int n, int n2) {
    }

    public boolean onEdgeLock(int n) {
        return false;
    }

    public void onEdgeTouched(int n, int n2) {
    }

    public void onViewCaptured(View view, int n) {
    }

    public void onViewDragStateChanged(int n) {
    }

    public void onViewPositionChanged(View view, int n, int n2, int n3, int n4) {
    }

    public void onViewReleased(View view, float f, float f2) {
    }

    public abstract boolean tryCaptureView(View var1, int var2);
}
