/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.bigkoo.pickerview.view.WheelOptions
 *  com.contrarywind.listener.OnItemSelectedListener
 */
package com.bigkoo.pickerview.view;

import com.bigkoo.pickerview.view.WheelOptions;
import com.contrarywind.listener.OnItemSelectedListener;

/*
 * Exception performing whole class analysis ignored.
 */
class WheelOptions.4
implements OnItemSelectedListener {
    final WheelOptions this$0;

    WheelOptions.4(WheelOptions wheelOptions) {
        this.this$0 = wheelOptions;
    }

    public void onItemSelected(int n) {
        WheelOptions.access$100((WheelOptions)this.this$0).onOptionsSelectChanged(n, WheelOptions.access$400((WheelOptions)this.this$0).getCurrentItem(), WheelOptions.access$700((WheelOptions)this.this$0).getCurrentItem());
    }
}