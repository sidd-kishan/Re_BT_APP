/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.view.View
 *  com.bigkoo.pickerview.view.BasePickerView
 */
package com.bigkoo.pickerview.view;

import android.view.View;
import com.bigkoo.pickerview.view.BasePickerView;

/*
 * Exception performing whole class analysis ignored.
 */
class BasePickerView.3
implements Runnable {
    final BasePickerView this$0;

    BasePickerView.3(BasePickerView basePickerView) {
        this.this$0 = basePickerView;
    }

    @Override
    public void run() {
        this.this$0.mPickerOptions.decorView.removeView((View)BasePickerView.access$000((BasePickerView)this.this$0));
        BasePickerView.access$102((BasePickerView)this.this$0, (boolean)false);
        BasePickerView.access$202((BasePickerView)this.this$0, (boolean)false);
        if (BasePickerView.access$300((BasePickerView)this.this$0) == null) return;
        BasePickerView.access$300((BasePickerView)this.this$0).onDismiss((Object)this.this$0);
    }
}
