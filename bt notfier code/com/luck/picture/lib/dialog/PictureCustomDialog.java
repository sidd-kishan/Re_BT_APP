/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.app.Dialog
 *  android.content.Context
 *  android.view.WindowManager$LayoutParams
 *  com.luck.picture.lib.R$style
 */
package com.luck.picture.lib.dialog;

import android.app.Dialog;
import android.content.Context;
import android.view.WindowManager;
import com.luck.picture.lib.R;

public class PictureCustomDialog
extends Dialog {
    public PictureCustomDialog(Context context, int n) {
        super(context, R.style.Picture_Theme_Dialog);
        this.setContentView(n);
        context = this.getWindow();
        if (context == null) return;
        WindowManager.LayoutParams layoutParams = context.getAttributes();
        layoutParams.width = -2;
        layoutParams.height = -2;
        layoutParams.gravity = 17;
        context.setAttributes(layoutParams);
    }
}
