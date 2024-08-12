/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.app.AlertDialog
 *  android.app.AlertDialog$Builder
 *  android.content.Context
 *  android.content.DialogInterface$OnClickListener
 *  android.view.View
 *  com.qmuiteam.qmui.widget.dialog.QMUITipDialog
 *  com.qmuiteam.qmui.widget.dialog.QMUITipDialog$Builder
 */
package com.lianhezhuli.btnotification.utils;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.View;
import com.qmuiteam.qmui.widget.dialog.QMUITipDialog;

public class DialogUtils {
    public static QMUITipDialog getTipDialog(Context context, int n, String string) {
        return new QMUITipDialog.Builder(context).setIconType(n).setTipWord((CharSequence)string).create();
    }

    public static AlertDialog showDownloadDialog(Context context, View view) {
        return new AlertDialog.Builder(context).setTitle(2131755105).setView(view).setCancelable(false).create();
    }

    public static AlertDialog showFindPhoneDialog(Context context, DialogInterface.OnClickListener onClickListener) {
        onClickListener = new AlertDialog.Builder(context).setTitle(2131755045).setCancelable(false).setPositiveButton(2131755116, onClickListener).create();
        onClickListener.getWindow().setType(2003);
        onClickListener.getButton(-1).setTextColor(context.getResources().getColor(2131099739));
        onClickListener.show();
        return onClickListener;
    }
}
