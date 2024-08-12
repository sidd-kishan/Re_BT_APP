/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.material.snackbar.BaseTransientBottomBar
 *  com.google.android.material.snackbar.SnackbarManager$Callback
 */
package com.google.android.material.snackbar;

import com.google.android.material.snackbar.BaseTransientBottomBar;
import com.google.android.material.snackbar.SnackbarManager;

class BaseTransientBottomBar.4
implements SnackbarManager.Callback {
    final BaseTransientBottomBar this$0;

    BaseTransientBottomBar.4(BaseTransientBottomBar baseTransientBottomBar) {
        this.this$0 = baseTransientBottomBar;
    }

    public void dismiss(int n) {
        BaseTransientBottomBar.handler.sendMessage(BaseTransientBottomBar.handler.obtainMessage(1, n, 0, (Object)this.this$0));
    }

    public void show() {
        BaseTransientBottomBar.handler.sendMessage(BaseTransientBottomBar.handler.obtainMessage(0, (Object)this.this$0));
    }
}
