/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.view.View
 *  com.google.android.material.bottomsheet.BottomSheetBehavior$BottomSheetCallback
 *  com.google.android.material.bottomsheet.BottomSheetDialog
 */
package com.google.android.material.bottomsheet;

import android.view.View;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.bottomsheet.BottomSheetDialog;

class BottomSheetDialog.4
extends BottomSheetBehavior.BottomSheetCallback {
    final BottomSheetDialog this$0;

    BottomSheetDialog.4(BottomSheetDialog bottomSheetDialog) {
        this.this$0 = bottomSheetDialog;
    }

    public void onSlide(View view, float f) {
    }

    public void onStateChanged(View view, int n) {
        if (n != 5) return;
        this.this$0.cancel();
    }
}
