/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.DialogInterface
 *  android.content.DialogInterface$OnDismissListener
 *  com.bigkoo.pickerview.view.BasePickerView
 */
package com.bigkoo.pickerview.view;

import android.content.DialogInterface;
import com.bigkoo.pickerview.view.BasePickerView;

/*
 * Exception performing whole class analysis ignored.
 */
class BasePickerView.6
implements DialogInterface.OnDismissListener {
    final BasePickerView this$0;

    BasePickerView.6(BasePickerView basePickerView) {
        this.this$0 = basePickerView;
    }

    public void onDismiss(DialogInterface dialogInterface) {
        if (BasePickerView.access$300((BasePickerView)this.this$0) == null) return;
        BasePickerView.access$300((BasePickerView)this.this$0).onDismiss((Object)this.this$0);
    }
}
