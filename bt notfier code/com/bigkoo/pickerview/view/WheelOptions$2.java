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
class WheelOptions.2
implements OnItemSelectedListener {
    final WheelOptions this$0;

    WheelOptions.2(WheelOptions wheelOptions) {
        this.this$0 = wheelOptions;
    }

    public void onItemSelected(int n) {
        List list = WheelOptions.access$500((WheelOptions)this.this$0);
        int n2 = 0;
        if (list != null) {
            int n3;
            int n4 = n3 = WheelOptions.access$200((WheelOptions)this.this$0).getCurrentItem();
            if (n3 >= WheelOptions.access$500((WheelOptions)this.this$0).size() - 1) {
                n4 = WheelOptions.access$500((WheelOptions)this.this$0).size() - 1;
            }
            n3 = n;
            if (n >= ((List)WheelOptions.access$000((WheelOptions)this.this$0).get(n4)).size() - 1) {
                n3 = ((List)WheelOptions.access$000((WheelOptions)this.this$0).get(n4)).size() - 1;
            }
            n = n2;
            if (!WheelOptions.access$300((WheelOptions)this.this$0)) {
                n = WheelOptions.access$700((WheelOptions)this.this$0).getCurrentItem() >= ((List)((List)WheelOptions.access$500((WheelOptions)this.this$0).get(n4)).get(n3)).size() - 1 ? ((List)((List)WheelOptions.access$500((WheelOptions)this.this$0).get(n4)).get(n3)).size() - 1 : WheelOptions.access$700((WheelOptions)this.this$0).getCurrentItem();
            }
            WheelOptions.access$700((WheelOptions)this.this$0).setAdapter((WheelAdapter)new ArrayWheelAdapter((List)((List)WheelOptions.access$500((WheelOptions)this.this$0).get(WheelOptions.access$200((WheelOptions)this.this$0).getCurrentItem())).get(n3)));
            WheelOptions.access$700((WheelOptions)this.this$0).setCurrentItem(n);
            if (WheelOptions.access$100((WheelOptions)this.this$0) == null) return;
            WheelOptions.access$100((WheelOptions)this.this$0).onOptionsSelectChanged(WheelOptions.access$200((WheelOptions)this.this$0).getCurrentItem(), n3, n);
        } else {
            if (WheelOptions.access$100((WheelOptions)this.this$0) == null) return;
            WheelOptions.access$100((WheelOptions)this.this$0).onOptionsSelectChanged(WheelOptions.access$200((WheelOptions)this.this$0).getCurrentItem(), n, 0);
        }
    }
}
