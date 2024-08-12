/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.view.View
 *  android.view.View$OnClickListener
 *  com.google.android.material.snackbar.Snackbar
 */
package com.google.android.material.snackbar;

import android.view.View;
import com.google.android.material.snackbar.Snackbar;

class Snackbar.1
implements View.OnClickListener {
    final Snackbar this$0;
    final View.OnClickListener val$listener;

    Snackbar.1(Snackbar snackbar, View.OnClickListener onClickListener) {
        this.this$0 = snackbar;
        this.val$listener = onClickListener;
    }

    public void onClick(View view) {
        this.val$listener.onClick(view);
        this.this$0.dispatchDismiss(1);
    }
}
