/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.app.Dialog
 *  android.content.Context
 *  android.content.res.TypedArray
 *  android.os.Build$VERSION
 *  android.os.Bundle
 *  android.view.Window
 *  android.view.WindowManager$LayoutParams
 *  com.qmuiteam.qmui.R$style
 */
package com.qmuiteam.qmui.widget.dialog;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.res.TypedArray;
import android.os.Build;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import com.qmuiteam.qmui.R;

public class QMUIDialog
extends Dialog {
    private Context mBaseContext;
    boolean mCancelable = true;
    private boolean mCanceledOnTouchOutside = true;
    private boolean mCanceledOnTouchOutsideSet;

    public QMUIDialog(Context context) {
        this(context, R.style.QMUI_Dialog);
    }

    public QMUIDialog(Context context, int n) {
        super(context, n);
        this.mBaseContext = context;
        this.init();
    }

    private void init() {
        this.setCancelable(true);
        this.setCanceledOnTouchOutside(true);
    }

    private void initDialog() {
        Window window = this.getWindow();
        if (window == null) {
            return;
        }
        WindowManager.LayoutParams layoutParams = window.getAttributes();
        layoutParams.width = -1;
        layoutParams.gravity = 17;
        window.setAttributes(layoutParams);
    }

    void cancelOutSide() {
        if (!this.mCancelable) return;
        if (!this.isShowing()) return;
        if (!this.shouldWindowCloseOnTouchOutside()) return;
        this.cancel();
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.initDialog();
    }

    public void setCancelable(boolean bl) {
        super.setCancelable(bl);
        this.mCancelable = bl;
    }

    public void setCanceledOnTouchOutside(boolean bl) {
        super.setCanceledOnTouchOutside(bl);
        if (bl && !this.mCancelable) {
            this.mCancelable = true;
        }
        this.mCanceledOnTouchOutside = bl;
        this.mCanceledOnTouchOutsideSet = true;
    }

    boolean shouldWindowCloseOnTouchOutside() {
        if (this.mCanceledOnTouchOutsideSet) return this.mCanceledOnTouchOutside;
        if (Build.VERSION.SDK_INT < 11) {
            this.mCanceledOnTouchOutside = true;
        } else {
            TypedArray typedArray = this.getContext().obtainStyledAttributes(new int[]{16843611});
            this.mCanceledOnTouchOutside = typedArray.getBoolean(0, true);
            typedArray.recycle();
        }
        this.mCanceledOnTouchOutsideSet = true;
        return this.mCanceledOnTouchOutside;
    }

    public void show() {
        super.show();
    }

    public void showWithImmersiveCheck() {
        Context context = this.mBaseContext;
        if (!(context instanceof Activity)) {
            super.show();
            return;
        }
        this.showWithImmersiveCheck((Activity)context);
    }

    public void showWithImmersiveCheck(Activity activity) {
        Window window = this.getWindow();
        if (window == null) {
            return;
        }
        int n = activity.getWindow().getDecorView().getSystemUiVisibility();
        if ((n & 0x400) != 1024 && (n & 4) != 4) {
            super.show();
        } else {
            window.setFlags(8, 8);
            window.getDecorView().setSystemUiVisibility(activity.getWindow().getDecorView().getSystemUiVisibility());
            super.show();
            window.clearFlags(8);
        }
    }
}
