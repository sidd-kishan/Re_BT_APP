/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.material.snackbar.BaseTransientBottomBar$BaseCallback
 *  com.google.android.material.snackbar.Snackbar
 */
package com.google.android.material.snackbar;

import com.google.android.material.snackbar.BaseTransientBottomBar;
import com.google.android.material.snackbar.Snackbar;

public static class Snackbar.Callback
extends BaseTransientBottomBar.BaseCallback<Snackbar> {
    public static final int DISMISS_EVENT_ACTION = 1;
    public static final int DISMISS_EVENT_CONSECUTIVE = 4;
    public static final int DISMISS_EVENT_MANUAL = 3;
    public static final int DISMISS_EVENT_SWIPE = 0;
    public static final int DISMISS_EVENT_TIMEOUT = 2;

    public void onDismissed(Snackbar snackbar, int n) {
    }

    public void onShown(Snackbar snackbar) {
    }
}
