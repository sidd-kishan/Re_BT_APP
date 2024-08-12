/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.DialogInterface
 *  android.content.DialogInterface$OnClickListener
 *  android.os.Handler
 *  android.os.Message
 */
package androidx.appcompat.app;

import android.content.DialogInterface;
import android.os.Handler;
import android.os.Message;
import java.lang.ref.WeakReference;

private static final class AlertController.ButtonHandler
extends Handler {
    private static final int MSG_DISMISS_DIALOG = 1;
    private WeakReference<DialogInterface> mDialog;

    public AlertController.ButtonHandler(DialogInterface dialogInterface) {
        this.mDialog = new WeakReference<DialogInterface>(dialogInterface);
    }

    public void handleMessage(Message message) {
        int n = message.what;
        if (n != -3 && n != -2 && n != -1) {
            if (n != 1) return;
            ((DialogInterface)message.obj).dismiss();
        } else {
            ((DialogInterface.OnClickListener)message.obj).onClick((DialogInterface)this.mDialog.get(), message.what);
        }
    }
}
