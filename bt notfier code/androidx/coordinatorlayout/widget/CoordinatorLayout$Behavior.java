/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.graphics.Rect
 *  android.os.Parcelable
 *  android.view.MotionEvent
 *  android.view.View
 *  android.view.View$BaseSavedState
 *  androidx.coordinatorlayout.widget.CoordinatorLayout
 *  androidx.coordinatorlayout.widget.CoordinatorLayout$LayoutParams
 *  androidx.core.view.WindowInsetsCompat
 */
package androidx.coordinatorlayout.widget;

import android.content.Context;
import android.graphics.Rect;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.WindowInsetsCompat;

public static abstract class CoordinatorLayout.Behavior<V extends View> {
    public CoordinatorLayout.Behavior() {
    }

    public CoordinatorLayout.Behavior(Context context, AttributeSet attributeSet) {
    }

    public static Object getTag(View view) {
        return ((CoordinatorLayout.LayoutParams)view.getLayoutParams()).mBehaviorTag;
    }

    public static void setTag(View view, Object object) {
        ((CoordinatorLayout.LayoutParams)view.getLayoutParams()).mBehaviorTag = object;
    }

    public boolean blocksInteractionBelow(CoordinatorLayout coordinatorLayout, V v) {
        boolean bl = this.getScrimOpacity(coordinatorLayout, v) > 0.0f;
        return bl;
    }

    public boolean getInsetDodgeRect(CoordinatorLayout coordinatorLayout, V v, Rect rect) {
        return false;
    }

    public int getScrimColor(CoordinatorLayout coordinatorLayout, V v) {
        return -16777216;
    }

    public float getScrimOpacity(CoordinatorLayout coordinatorLayout, V v) {
        return 0.0f;
    }

    public boolean layoutDependsOn(CoordinatorLayout coordinatorLayout, V v, View view) {
        return false;
    }

    public WindowInsetsCompat onApplyWindowInsets(CoordinatorLayout coordinatorLayout, V v, WindowInsetsCompat windowInsetsCompat) {
        return windowInsetsCompat;
    }

    public void onAttachedToLayoutParams(CoordinatorLayout.LayoutParams layoutParams) {
    }

    public boolean onDependentViewChanged(CoordinatorLayout coordinatorLayout, V v, View view) {
        return false;
    }

    public void onDependentViewRemoved(CoordinatorLayout coordinatorLayout, V v, View view) {
    }

    public void onDetachedFromLayoutParams() {
    }

    public boolean onInterceptTouchEvent(CoordinatorLayout coordinatorLayout, V v, MotionEvent motionEvent) {
        return false;
    }

    public boolean onLayoutChild(CoordinatorLayout coordinatorLayout, V v, int n) {
        return false;
    }

    public boolean onMeasureChild(CoordinatorLayout coordinatorLayout, V v, int n, int n2, int n3, int n4) {
        return false;
    }

    public boolean onNestedFling(CoordinatorLayout coordinatorLayout, V v, View view, float f, float f2, boolean bl) {
        return false;
    }

    public boolean onNestedPreFling(CoordinatorLayout coordinatorLayout, V v, View view, float f, float f2) {
        return false;
    }

    @Deprecated
    public void onNestedPreScroll(CoordinatorLayout coordinatorLayout, V v, View view, int n, int n2, int[] nArray) {
    }

    public void onNestedPreScroll(CoordinatorLayout coordinatorLayout, V v, View view, int n, int n2, int[] nArray, int n3) {
        if (n3 != 0) return;
        this.onNestedPreScroll(coordinatorLayout, v, view, n, n2, nArray);
    }

    @Deprecated
    public void onNestedScroll(CoordinatorLayout coordinatorLayout, V v, View view, int n, int n2, int n3, int n4) {
    }

    public void onNestedScroll(CoordinatorLayout coordinatorLayout, V v, View view, int n, int n2, int n3, int n4, int n5) {
        if (n5 != 0) return;
        this.onNestedScroll(coordinatorLayout, v, view, n, n2, n3, n4);
    }

    @Deprecated
    public void onNestedScrollAccepted(CoordinatorLayout coordinatorLayout, V v, View view, View view2, int n) {
    }

    public void onNestedScrollAccepted(CoordinatorLayout coordinatorLayout, V v, View view, View view2, int n, int n2) {
        if (n2 != 0) return;
        this.onNestedScrollAccepted(coordinatorLayout, v, view, view2, n);
    }

    public boolean onRequestChildRectangleOnScreen(CoordinatorLayout coordinatorLayout, V v, Rect rect, boolean bl) {
        return false;
    }

    public void onRestoreInstanceState(CoordinatorLayout coordinatorLayout, V v, Parcelable parcelable) {
    }

    public Parcelable onSaveInstanceState(CoordinatorLayout coordinatorLayout, V v) {
        return View.BaseSavedState.EMPTY_STATE;
    }

    @Deprecated
    public boolean onStartNestedScroll(CoordinatorLayout coordinatorLayout, V v, View view, View view2, int n) {
        return false;
    }

    public boolean onStartNestedScroll(CoordinatorLayout coordinatorLayout, V v, View view, View view2, int n, int n2) {
        if (n2 != 0) return false;
        return this.onStartNestedScroll(coordinatorLayout, v, view, view2, n);
    }

    @Deprecated
    public void onStopNestedScroll(CoordinatorLayout coordinatorLayout, V v, View view) {
    }

    public void onStopNestedScroll(CoordinatorLayout coordinatorLayout, V v, View view, int n) {
        if (n != 0) return;
        this.onStopNestedScroll(coordinatorLayout, v, view);
    }

    public boolean onTouchEvent(CoordinatorLayout coordinatorLayout, V v, MotionEvent motionEvent) {
        return false;
    }
}
