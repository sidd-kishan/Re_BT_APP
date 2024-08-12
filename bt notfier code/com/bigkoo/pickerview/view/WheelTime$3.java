/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.bigkoo.pickerview.adapter.NumericWheelAdapter
 *  com.bigkoo.pickerview.view.WheelTime
 *  com.contrarywind.adapter.WheelAdapter
 *  com.contrarywind.listener.OnItemSelectedListener
 */
package com.bigkoo.pickerview.view;

import com.bigkoo.pickerview.adapter.NumericWheelAdapter;
import com.bigkoo.pickerview.view.WheelTime;
import com.contrarywind.adapter.WheelAdapter;
import com.contrarywind.listener.OnItemSelectedListener;
import java.util.List;

/*
 * Exception performing whole class analysis ignored.
 */
class WheelTime.3
implements OnItemSelectedListener {
    final WheelTime this$0;
    final List val$list_big;
    final List val$list_little;

    WheelTime.3(WheelTime wheelTime, List list, List list2) {
        this.this$0 = wheelTime;
        this.val$list_big = list;
        this.val$list_little = list2;
    }

    public void onItemSelected(int n) {
        int n2 = n + WheelTime.access$000((WheelTime)this.this$0);
        WheelTime.access$502((WheelTime)this.this$0, (int)n2);
        n = WheelTime.access$100((WheelTime)this.this$0).getCurrentItem();
        if (WheelTime.access$000((WheelTime)this.this$0) == WheelTime.access$600((WheelTime)this.this$0)) {
            WheelTime.access$100((WheelTime)this.this$0).setAdapter((WheelAdapter)new NumericWheelAdapter(WheelTime.access$700((WheelTime)this.this$0), WheelTime.access$800((WheelTime)this.this$0)));
            int n3 = n;
            if (n > WheelTime.access$100((WheelTime)this.this$0).getAdapter().getItemsCount() - 1) {
                n3 = WheelTime.access$100((WheelTime)this.this$0).getAdapter().getItemsCount() - 1;
                WheelTime.access$100((WheelTime)this.this$0).setCurrentItem(n3);
            }
            n = n3 + WheelTime.access$700((WheelTime)this.this$0);
            if (WheelTime.access$700((WheelTime)this.this$0) == WheelTime.access$800((WheelTime)this.this$0)) {
                WheelTime wheelTime = this.this$0;
                WheelTime.access$1100((WheelTime)wheelTime, (int)n2, (int)n, (int)WheelTime.access$900((WheelTime)wheelTime), (int)WheelTime.access$1000((WheelTime)this.this$0), (List)this.val$list_big, (List)this.val$list_little);
            } else if (n == WheelTime.access$700((WheelTime)this.this$0)) {
                WheelTime wheelTime = this.this$0;
                WheelTime.access$1100((WheelTime)wheelTime, (int)n2, (int)n, (int)WheelTime.access$900((WheelTime)wheelTime), (int)31, (List)this.val$list_big, (List)this.val$list_little);
            } else if (n == WheelTime.access$800((WheelTime)this.this$0)) {
                WheelTime wheelTime = this.this$0;
                WheelTime.access$1100((WheelTime)wheelTime, (int)n2, (int)n, (int)1, (int)WheelTime.access$1000((WheelTime)wheelTime), (List)this.val$list_big, (List)this.val$list_little);
            } else {
                WheelTime.access$1100((WheelTime)this.this$0, (int)n2, (int)n, (int)1, (int)31, (List)this.val$list_big, (List)this.val$list_little);
            }
        } else if (n2 == WheelTime.access$000((WheelTime)this.this$0)) {
            WheelTime.access$100((WheelTime)this.this$0).setAdapter((WheelAdapter)new NumericWheelAdapter(WheelTime.access$700((WheelTime)this.this$0), 12));
            int n4 = n;
            if (n > WheelTime.access$100((WheelTime)this.this$0).getAdapter().getItemsCount() - 1) {
                n4 = WheelTime.access$100((WheelTime)this.this$0).getAdapter().getItemsCount() - 1;
                WheelTime.access$100((WheelTime)this.this$0).setCurrentItem(n4);
            }
            if ((n = n4 + WheelTime.access$700((WheelTime)this.this$0)) == WheelTime.access$700((WheelTime)this.this$0)) {
                WheelTime wheelTime = this.this$0;
                WheelTime.access$1100((WheelTime)wheelTime, (int)n2, (int)n, (int)WheelTime.access$900((WheelTime)wheelTime), (int)31, (List)this.val$list_big, (List)this.val$list_little);
            } else {
                WheelTime.access$1100((WheelTime)this.this$0, (int)n2, (int)n, (int)1, (int)31, (List)this.val$list_big, (List)this.val$list_little);
            }
        } else if (n2 == WheelTime.access$600((WheelTime)this.this$0)) {
            WheelTime.access$100((WheelTime)this.this$0).setAdapter((WheelAdapter)new NumericWheelAdapter(1, WheelTime.access$800((WheelTime)this.this$0)));
            int n5 = n;
            if (n > WheelTime.access$100((WheelTime)this.this$0).getAdapter().getItemsCount() - 1) {
                n5 = WheelTime.access$100((WheelTime)this.this$0).getAdapter().getItemsCount() - 1;
                WheelTime.access$100((WheelTime)this.this$0).setCurrentItem(n5);
            }
            if ((n = 1 + n5) == WheelTime.access$800((WheelTime)this.this$0)) {
                WheelTime wheelTime = this.this$0;
                WheelTime.access$1100((WheelTime)wheelTime, (int)n2, (int)n, (int)1, (int)WheelTime.access$1000((WheelTime)wheelTime), (List)this.val$list_big, (List)this.val$list_little);
            } else {
                WheelTime.access$1100((WheelTime)this.this$0, (int)n2, (int)n, (int)1, (int)31, (List)this.val$list_big, (List)this.val$list_little);
            }
        } else {
            WheelTime.access$100((WheelTime)this.this$0).setAdapter((WheelAdapter)new NumericWheelAdapter(1, 12));
            WheelTime wheelTime = this.this$0;
            WheelTime.access$1100((WheelTime)wheelTime, (int)n2, (int)(1 + WheelTime.access$100((WheelTime)wheelTime).getCurrentItem()), (int)1, (int)31, (List)this.val$list_big, (List)this.val$list_little);
        }
        if (WheelTime.access$300((WheelTime)this.this$0) == null) return;
        WheelTime.access$300((WheelTime)this.this$0).onTimeSelectChanged();
    }
}
