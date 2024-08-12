/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.view.KeyEvent
 *  android.view.View
 *  android.view.View$OnKeyListener
 *  com.bigkoo.pickerview.view.BasePickerView
 */
package com.bigkoo.pickerview.view;

import android.view.KeyEvent;
import android.view.View;
import com.bigkoo.pickerview.view.BasePickerView;

class BasePickerView.4
implements View.OnKeyListener {
    final BasePickerView this$0;

    BasePickerView.4(BasePickerView basePickerView) {
        this.this$0 = basePickerView;
    }

    public boolean onKey(View view, int n, KeyEvent keyEvent) {
        if (n != 4) return false;
        if (keyEvent.getAction() != 0) return false;
        if (!this.this$0.isShowing()) return false;
        this.this$0.dismiss();
        return true;
    }
}
