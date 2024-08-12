/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.bigkoo.pickerview.adapter.ArrayWheelAdapter
 *  com.bigkoo.pickerview.view.WheelOptions
 *  com.contrarywind.adapter.WheelAdapter
 *  com.contrarywind.listener.OnItemSelectedListener
 */
package com.bigkoo.pickerview.view;

import com.bigkoo.pickerview.adapter.ArrayWheelAdapter;
import com.bigkoo.pickerview.view.WheelOptions;
import com.contrarywind.adapter.WheelAdapter;
import com.contrarywind.listener.OnItemSelectedListener;
import java.util.List;

/*
 * Exception performing whole class analysis ignored.
 */
class WheelOptions.1
implements OnItemSelectedListener {
    final WheelOptions this$0;

    WheelOptions.1(WheelOptions wheelOptions) {
        this.this$0 = wheelOptions;
    }

    public void onItemSelected(int n) {
        if (WheelOptions.access$000((WheelOptions)this.this$0) == null) {
            if (WheelOptions.access$100((WheelOptions)this.this$0) == null) return;
            WheelOptions.access$100((WheelOptions)this.this$0).onOptionsSelectChanged(WheelOptions.access$200((WheelOptions)this.this$0).getCurrentItem(), 0, 0);
        } else {
            int n2;
            if (!WheelOptions.access$300((WheelOptions)this.this$0)) {
                int n3;
                n2 = n3 = WheelOptions.access$400((WheelOptions)this.this$0).getCurrentItem();
                if (n3 >= ((List)WheelOptions.access$000((WheelOptions)this.this$0).get(n)).size() - 1) {
                    n2 = ((List)WheelOptions.access$000((WheelOptions)this.this$0).get(n)).size() - 1;
                }
            } else {
                n2 = 0;
            }
            WheelOptions.access$400((WheelOptions)this.this$0).setAdapter((WheelAdapter)new ArrayWheelAdapter((List)WheelOptions.access$000((WheelOptions)this.this$0).get(n)));
            WheelOptions.access$400((WheelOptions)this.this$0).setCurrentItem(n2);
            if (WheelOptions.access$500((WheelOptions)this.this$0) != null) {
                WheelOptions.access$600((WheelOptions)this.this$0).onItemSelected(n2);
            } else {
                if (WheelOptions.access$100((WheelOptions)this.this$0) == null) return;
                WheelOptions.access$100((WheelOptions)this.this$0).onOptionsSelectChanged(n, n2, 0);
            }
        }
    }
}
