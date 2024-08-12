/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.bigkoo.pickerview.view.WheelTime
 *  com.contrarywind.listener.OnItemSelectedListener
 */
package com.bigkoo.pickerview.view;

import com.bigkoo.pickerview.view.WheelTime;
import com.contrarywind.listener.OnItemSelectedListener;

/*
 * Exception performing whole class analysis ignored.
 */
class WheelTime.5
implements OnItemSelectedListener {
    final WheelTime this$0;

    WheelTime.5(WheelTime wheelTime) {
        this.this$0 = wheelTime;
    }

    public void onItemSelected(int n) {
        WheelTime.access$300((WheelTime)this.this$0).onTimeSelectChanged();
    }
}
