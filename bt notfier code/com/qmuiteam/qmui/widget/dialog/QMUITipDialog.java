/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.app.Dialog
 *  android.content.Context
 *  android.os.Bundle
 *  android.view.Window
 *  android.view.WindowManager$LayoutParams
 *  com.qmuiteam.qmui.R$style
 */
package com.qmuiteam.qmui.widget.dialog;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import com.qmuiteam.qmui.R;

public class QMUITipDialog
extends Dialog {
    public QMUITipDialog(Context context) {
        this(context, R.style.QMUI_TipDialog);
    }

    public QMUITipDialog(Context context, int n) {
        super(context, n);
        this.setCanceledOnTouchOutside(false);
    }

    private void initDialogWidth() {
        Window window = this.getWindow();
        if (window == null) return;
        WindowManager.LayoutParams layoutParams = window.getAttributes();
        layoutParams.width = -1;
        window.setAttributes(layoutParams);
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.initDialogWidth();
    }
}
