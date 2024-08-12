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
import java.util.List;

/*
 * Exception performing whole class analysis ignored.
 */
class WheelTime.4
implements OnItemSelectedListener {
    final WheelTime this$0;
    final List val$list_big;
    final List val$list_little;

    WheelTime.4(WheelTime wheelTime, List list, List list2) {
        this.this$0 = wheelTime;
        this.val$list_big = list;
        this.val$list_little = list2;
    }

    public void onItemSelected(int n) {
        ++n;
        if (WheelTime.access$000((WheelTime)this.this$0) == WheelTime.access$600((WheelTime)this.this$0)) {
            n = n + WheelTime.access$700((WheelTime)this.this$0) - 1;
            if (WheelTime.access$700((WheelTime)this.this$0) == WheelTime.access$800((WheelTime)this.this$0)) {
                WheelTime wheelTime = this.this$0;
                WheelTime.access$1100((WheelTime)wheelTime, (int)WheelTime.access$500((WheelTime)wheelTime), (int)n, (int)WheelTime.access$900((WheelTime)this.this$0), (int)WheelTime.access$1000((WheelTime)this.this$0), (List)this.val$list_big, (List)this.val$list_little);
            } else if (WheelTime.access$700((WheelTime)this.this$0) == n) {
                WheelTime wheelTime = this.this$0;
                WheelTime.access$1100((WheelTime)wheelTime, (int)WheelTime.access$500((WheelTime)wheelTime), (int)n, (int)WheelTime.access$900((WheelTime)this.this$0), (int)31, (List)this.val$list_big, (List)this.val$list_little);
            } else if (WheelTime.access$800((WheelTime)this.this$0) == n) {
                WheelTime wheelTime = this.this$0;
                WheelTime.access$1100((WheelTime)wheelTime, (int)WheelTime.access$500((WheelTime)wheelTime), (int)n, (int)1, (int)WheelTime.access$1000((WheelTime)this.this$0), (List)this.val$list_big, (List)this.val$list_little);
            } else {
                WheelTime wheelTime = this.this$0;
                WheelTime.access$1100((WheelTime)wheelTime, (int)WheelTime.access$500((WheelTime)wheelTime), (int)n, (int)1, (int)31, (List)this.val$list_big, (List)this.val$list_little);
            }
        } else if (WheelTime.access$500((WheelTime)this.this$0) == WheelTime.access$000((WheelTime)this.this$0)) {
            if ((n = n + WheelTime.access$700((WheelTime)this.this$0) - 1) == WheelTime.access$700((WheelTime)this.this$0)) {
                WheelTime wheelTime = this.this$0;
                WheelTime.access$1100((WheelTime)wheelTime, (int)WheelTime.access$500((WheelTime)wheelTime), (int)n, (int)WheelTime.access$900((WheelTime)this.this$0), (int)31, (List)this.val$list_big, (List)this.val$list_little);
            } else {
                WheelTime wheelTime = this.this$0;
                WheelTime.access$1100((WheelTime)wheelTime, (int)WheelTime.access$500((WheelTime)wheelTime), (int)n, (int)1, (int)31, (List)this.val$list_big, (List)this.val$list_little);
            }
        } else if (WheelTime.access$500((WheelTime)this.this$0) == WheelTime.access$600((WheelTime)this.this$0)) {
            if (n == WheelTime.access$800((WheelTime)this.this$0)) {
                WheelTime wheelTime = this.this$0;
                WheelTime.access$1100((WheelTime)wheelTime, (int)WheelTime.access$500((WheelTime)wheelTime), (int)(WheelTime.access$100((WheelTime)this.this$0).getCurrentItem() + 1), (int)1, (int)WheelTime.access$1000((WheelTime)this.this$0), (List)this.val$list_big, (List)this.val$list_little);
            } else {
                WheelTime wheelTime = this.this$0;
                WheelTime.access$1100((WheelTime)wheelTime, (int)WheelTime.access$500((WheelTime)wheelTime), (int)(WheelTime.access$100((WheelTime)this.this$0).getCurrentItem() + 1), (int)1, (int)31, (List)this.val$list_big, (List)this.val$list_little);
            }
        } else {
            WheelTime wheelTime = this.this$0;
            WheelTime.access$1100((WheelTime)wheelTime, (int)WheelTime.access$500((WheelTime)wheelTime), (int)n, (int)1, (int)31, (List)this.val$list_big, (List)this.val$list_little);
        }
        if (WheelTime.access$300((WheelTime)this.this$0) == null) return;
        WheelTime.access$300((WheelTime)this.this$0).onTimeSelectChanged();
    }
}
