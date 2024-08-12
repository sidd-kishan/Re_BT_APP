/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.view.View
 *  com.google.android.material.behavior.SwipeDismissBehavior$OnDismissListener
 *  com.google.android.material.snackbar.BaseTransientBottomBar
 *  com.google.android.material.snackbar.SnackbarManager
 */
package com.google.android.material.snackbar;

import android.view.View;
import com.google.android.material.behavior.SwipeDismissBehavior;
import com.google.android.material.snackbar.BaseTransientBottomBar;
import com.google.android.material.snackbar.SnackbarManager;

class BaseTransientBottomBar.5
implements SwipeDismissBehavior.OnDismissListener {
    final BaseTransientBottomBar this$0;

    BaseTransientBottomBar.5(BaseTransientBottomBar baseTransientBottomBar) {
        this.this$0 = baseTransientBottomBar;
    }

    public void onDismiss(View view) {
        view.setVisibility(8);
        this.this$0.dispatchDismiss(0);
    }

    public void onDragStateChanged(int n) {
        if (n != 0) {
            if (n != 1 && n != 2) return;
            SnackbarManager.getInstance().pauseTimeout(this.this$0.managerCallback);
        } else {
            SnackbarManager.getInstance().restoreTimeoutIfPaused(this.this$0.managerCallback);
        }
    }
}
