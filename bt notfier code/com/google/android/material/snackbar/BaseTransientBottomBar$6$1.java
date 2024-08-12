/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.material.snackbar.BaseTransientBottomBar$6
 */
package com.google.android.material.snackbar;

import com.google.android.material.snackbar.BaseTransientBottomBar;

class BaseTransientBottomBar.1
implements Runnable {
    final BaseTransientBottomBar.6 this$1;

    BaseTransientBottomBar.1(BaseTransientBottomBar.6 var1_1) {
        this.this$1 = var1_1;
    }

    @Override
    public void run() {
        this.this$1.this$0.onViewHidden(3);
    }
}
