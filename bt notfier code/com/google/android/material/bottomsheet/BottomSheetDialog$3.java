/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.view.MotionEvent
 *  android.view.View
 *  android.view.View$OnTouchListener
 *  com.google.android.material.bottomsheet.BottomSheetDialog
 */
package com.google.android.material.bottomsheet;

import android.view.MotionEvent;
import android.view.View;
import com.google.android.material.bottomsheet.BottomSheetDialog;

class BottomSheetDialog.3
implements View.OnTouchListener {
    final BottomSheetDialog this$0;

    BottomSheetDialog.3(BottomSheetDialog bottomSheetDialog) {
        this.this$0 = bottomSheetDialog;
    }

    public boolean onTouch(View view, MotionEvent motionEvent) {
        return true;
    }
}
