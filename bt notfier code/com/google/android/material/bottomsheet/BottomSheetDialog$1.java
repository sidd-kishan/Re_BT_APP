/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.view.View
 *  android.view.View$OnClickListener
 *  com.google.android.material.bottomsheet.BottomSheetDialog
 */
package com.google.android.material.bottomsheet;

import android.view.View;
import com.google.android.material.bottomsheet.BottomSheetDialog;

class BottomSheetDialog.1
implements View.OnClickListener {
    final BottomSheetDialog this$0;

    BottomSheetDialog.1(BottomSheetDialog bottomSheetDialog) {
        this.this$0 = bottomSheetDialog;
    }

    public void onClick(View view) {
        if (!this.this$0.cancelable) return;
        if (!this.this$0.isShowing()) return;
        if (!this.this$0.shouldWindowCloseOnTouchOutside()) return;
        this.this$0.cancel();
    }
}
