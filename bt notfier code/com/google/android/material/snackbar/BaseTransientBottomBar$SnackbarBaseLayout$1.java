/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.core.view.accessibility.AccessibilityManagerCompat$TouchExplorationStateChangeListener
 *  com.google.android.material.snackbar.BaseTransientBottomBar$SnackbarBaseLayout
 */
package com.google.android.material.snackbar;

import androidx.core.view.accessibility.AccessibilityManagerCompat;
import com.google.android.material.snackbar.BaseTransientBottomBar;

/*
 * Exception performing whole class analysis ignored.
 */
class BaseTransientBottomBar.SnackbarBaseLayout.1
implements AccessibilityManagerCompat.TouchExplorationStateChangeListener {
    final BaseTransientBottomBar.SnackbarBaseLayout this$0;

    BaseTransientBottomBar.SnackbarBaseLayout.1(BaseTransientBottomBar.SnackbarBaseLayout snackbarBaseLayout) {
        this.this$0 = snackbarBaseLayout;
    }

    public void onTouchExplorationStateChanged(boolean bl) {
        BaseTransientBottomBar.SnackbarBaseLayout.access$300((BaseTransientBottomBar.SnackbarBaseLayout)this.this$0, (boolean)bl);
    }
}
