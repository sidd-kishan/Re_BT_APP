/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.view.MotionEvent
 *  android.view.View
 *  android.view.View$OnTouchListener
 *  com.bigkoo.pickerview.view.BasePickerView
 */
package com.bigkoo.pickerview.view;

import android.view.MotionEvent;
import android.view.View;
import com.bigkoo.pickerview.view.BasePickerView;

class BasePickerView.5
implements View.OnTouchListener {
    final BasePickerView this$0;

    BasePickerView.5(BasePickerView basePickerView) {
        this.this$0 = basePickerView;
    }

    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() != 0) return false;
        this.this$0.dismiss();
        return false;
    }
}
