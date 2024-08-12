/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.app.AlertDialog$Builder
 *  android.app.Dialog
 *  android.content.Context
 *  android.content.DialogInterface
 *  android.content.DialogInterface$OnClickListener
 *  android.os.Bundle
 *  org.greenrobot.eventbus.util.ErrorDialogManager
 */
package org.greenrobot.eventbus.util;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import org.greenrobot.eventbus.util.ErrorDialogManager;

public class ErrorDialogFragments {
    public static int ERROR_DIALOG_ICON;
    public static Class<?> EVENT_TYPE_ON_CLICK;

    public static Dialog createDialog(Context context, Bundle bundle, DialogInterface.OnClickListener onClickListener) {
        context = new AlertDialog.Builder(context);
        context.setTitle((CharSequence)bundle.getString("de.greenrobot.eventbus.errordialog.title"));
        context.setMessage((CharSequence)bundle.getString("de.greenrobot.eventbus.errordialog.message"));
        int n = ERROR_DIALOG_ICON;
        if (n != 0) {
            context.setIcon(n);
        }
        context.setPositiveButton(17039370, onClickListener);
        return context.create();
    }

    public static void handleOnClick(DialogInterface object, int n, Activity activity, Bundle bundle) {
        object = EVENT_TYPE_ON_CLICK;
        if (object != null) {
            try {
                object = object.newInstance();
            }
            catch (Exception exception) {
                throw new RuntimeException("Event cannot be constructed", exception);
            }
            ErrorDialogManager.factory.config.getEventBus().post(object);
        }
        if (!bundle.getBoolean("de.greenrobot.eventbus.errordialog.finish_after_dialog", false)) return;
        if (activity == null) return;
        activity.finish();
    }
}
