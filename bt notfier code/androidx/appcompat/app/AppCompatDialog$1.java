/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.view.KeyEvent
 *  androidx.appcompat.app.AppCompatDialog
 *  androidx.core.view.KeyEventDispatcher$Component
 */
package androidx.appcompat.app;

import android.view.KeyEvent;
import androidx.appcompat.app.AppCompatDialog;
import androidx.core.view.KeyEventDispatcher;

class AppCompatDialog.1
implements KeyEventDispatcher.Component {
    final AppCompatDialog this$0;

    AppCompatDialog.1(AppCompatDialog appCompatDialog) {
        this.this$0 = appCompatDialog;
    }

    public boolean superDispatchKeyEvent(KeyEvent keyEvent) {
        return this.this$0.superDispatchKeyEvent(keyEvent);
    }
}
