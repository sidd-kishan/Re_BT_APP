/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.view.View
 *  android.view.View$OnClickListener
 *  com.bigkoo.pickerview.view.BasePickerView
 */
package com.bigkoo.pickerview.view;

import android.view.View;
import com.bigkoo.pickerview.view.BasePickerView;

class BasePickerView.1
implements View.OnClickListener {
    final BasePickerView this$0;

    BasePickerView.1(BasePickerView basePickerView) {
        this.this$0 = basePickerView;
    }

    public void onClick(View view) {
        this.this$0.dismiss();
    }
}
