/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.app.Dialog
 *  android.content.Context
 *  android.os.Bundle
 *  com.luck.picture.lib.R$layout
 *  com.luck.picture.lib.R$style
 */
package com.luck.picture.lib.dialog;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import com.luck.picture.lib.R;

public class PictureLoadingDialog
extends Dialog {
    public PictureLoadingDialog(Context context) {
        super(context, R.style.Picture_Theme_AlertDialog);
        this.setCancelable(true);
        this.setCanceledOnTouchOutside(false);
        context = this.getWindow();
        if (context == null) return;
        context.setWindowAnimations(R.style.PictureThemeDialogWindowStyle);
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.setContentView(R.layout.picture_alert_dialog);
    }
}
