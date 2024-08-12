/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Handler$Callback
 *  android.os.Message
 *  com.google.android.material.snackbar.BaseTransientBottomBar
 */
package com.google.android.material.snackbar;

import android.os.Handler;
import android.os.Message;
import com.google.android.material.snackbar.BaseTransientBottomBar;

static final class BaseTransientBottomBar.1
implements Handler.Callback {
    BaseTransientBottomBar.1() {
    }

    public boolean handleMessage(Message message) {
        int n = message.what;
        if (n == 0) {
            ((BaseTransientBottomBar)message.obj).showView();
            return true;
        }
        if (n != 1) {
            return false;
        }
        ((BaseTransientBottomBar)message.obj).hideView(message.arg1);
        return true;
    }
}
