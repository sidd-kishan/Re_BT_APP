/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Handler$Callback
 *  android.os.Message
 *  com.google.android.material.snackbar.SnackbarManager
 *  com.google.android.material.snackbar.SnackbarManager$SnackbarRecord
 */
package com.google.android.material.snackbar;

import android.os.Handler;
import android.os.Message;
import com.google.android.material.snackbar.SnackbarManager;

class SnackbarManager.1
implements Handler.Callback {
    final SnackbarManager this$0;

    SnackbarManager.1(SnackbarManager snackbarManager) {
        this.this$0 = snackbarManager;
    }

    public boolean handleMessage(Message message) {
        if (message.what != 0) {
            return false;
        }
        this.this$0.handleTimeout((SnackbarManager.SnackbarRecord)message.obj);
        return true;
    }
}
