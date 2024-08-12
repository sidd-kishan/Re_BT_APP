/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.material.snackbar.SnackbarManager$Callback
 */
package com.google.android.material.snackbar;

import com.google.android.material.snackbar.SnackbarManager;
import java.lang.ref.WeakReference;

private static class SnackbarManager.SnackbarRecord {
    final WeakReference<SnackbarManager.Callback> callback;
    int duration;
    boolean paused;

    SnackbarManager.SnackbarRecord(int n, SnackbarManager.Callback callback) {
        this.callback = new WeakReference<SnackbarManager.Callback>(callback);
        this.duration = n;
    }

    boolean isSnackbar(SnackbarManager.Callback callback) {
        boolean bl = callback != null && this.callback.get() == callback;
        return bl;
    }
}
