/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.view.MotionEvent
 *  android.view.View
 *  androidx.coordinatorlayout.widget.CoordinatorLayout
 *  com.google.android.material.behavior.SwipeDismissBehavior
 *  com.google.android.material.snackbar.BaseTransientBottomBar
 *  com.google.android.material.snackbar.BaseTransientBottomBar$BehaviorDelegate
 */
package com.google.android.material.snackbar;

import android.view.MotionEvent;
import android.view.View;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.google.android.material.behavior.SwipeDismissBehavior;
import com.google.android.material.snackbar.BaseTransientBottomBar;

public static class BaseTransientBottomBar.Behavior
extends SwipeDismissBehavior<View> {
    private final BaseTransientBottomBar.BehaviorDelegate delegate = new BaseTransientBottomBar.BehaviorDelegate((SwipeDismissBehavior)this);

    static /* synthetic */ void access$000(BaseTransientBottomBar.Behavior behavior, BaseTransientBottomBar baseTransientBottomBar) {
        behavior.setBaseTransientBottomBar(baseTransientBottomBar);
    }

    private void setBaseTransientBottomBar(BaseTransientBottomBar<?> baseTransientBottomBar) {
        this.delegate.setBaseTransientBottomBar(baseTransientBottomBar);
    }

    public boolean canSwipeDismissView(View view) {
        return this.delegate.canSwipeDismissView(view);
    }

    public boolean onInterceptTouchEvent(CoordinatorLayout coordinatorLayout, View view, MotionEvent motionEvent) {
        this.delegate.onInterceptTouchEvent(coordinatorLayout, view, motionEvent);
        return super.onInterceptTouchEvent(coordinatorLayout, view, motionEvent);
    }
}
