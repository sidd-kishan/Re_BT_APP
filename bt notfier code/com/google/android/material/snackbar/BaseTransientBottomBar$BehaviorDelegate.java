/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.view.MotionEvent
 *  android.view.View
 *  androidx.coordinatorlayout.widget.CoordinatorLayout
 *  com.google.android.material.behavior.SwipeDismissBehavior
 *  com.google.android.material.snackbar.BaseTransientBottomBar
 *  com.google.android.material.snackbar.BaseTransientBottomBar$SnackbarBaseLayout
 *  com.google.android.material.snackbar.SnackbarManager
 *  com.google.android.material.snackbar.SnackbarManager$Callback
 */
package com.google.android.material.snackbar;

import android.view.MotionEvent;
import android.view.View;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.google.android.material.behavior.SwipeDismissBehavior;
import com.google.android.material.snackbar.BaseTransientBottomBar;
import com.google.android.material.snackbar.SnackbarManager;

public static class BaseTransientBottomBar.BehaviorDelegate {
    private SnackbarManager.Callback managerCallback;

    public BaseTransientBottomBar.BehaviorDelegate(SwipeDismissBehavior<?> swipeDismissBehavior) {
        swipeDismissBehavior.setStartAlphaSwipeDistance(0.1f);
        swipeDismissBehavior.setEndAlphaSwipeDistance(0.6f);
        swipeDismissBehavior.setSwipeDirection(0);
    }

    public boolean canSwipeDismissView(View view) {
        return view instanceof BaseTransientBottomBar.SnackbarBaseLayout;
    }

    public void onInterceptTouchEvent(CoordinatorLayout coordinatorLayout, View view, MotionEvent motionEvent) {
        int n = motionEvent.getActionMasked();
        if (n != 0) {
            if (n != 1 && n != 3) return;
            SnackbarManager.getInstance().restoreTimeoutIfPaused(this.managerCallback);
        } else {
            if (!coordinatorLayout.isPointInChildBounds(view, (int)motionEvent.getX(), (int)motionEvent.getY())) return;
            SnackbarManager.getInstance().pauseTimeout(this.managerCallback);
        }
    }

    public void setBaseTransientBottomBar(BaseTransientBottomBar<?> baseTransientBottomBar) {
        this.managerCallback = baseTransientBottomBar.managerCallback;
    }
}
