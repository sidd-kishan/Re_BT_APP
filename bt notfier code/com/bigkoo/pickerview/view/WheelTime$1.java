/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.bigkoo.pickerview.adapter.ArrayWheelAdapter
 *  com.bigkoo.pickerview.utils.ChinaDate
 *  com.bigkoo.pickerview.view.WheelTime
 *  com.contrarywind.adapter.WheelAdapter
 *  com.contrarywind.listener.OnItemSelectedListener
 */
package com.bigkoo.pickerview.view;

import com.bigkoo.pickerview.adapter.ArrayWheelAdapter;
import com.bigkoo.pickerview.utils.ChinaDate;
import com.bigkoo.pickerview.view.WheelTime;
import com.contrarywind.adapter.WheelAdapter;
import com.contrarywind.listener.OnItemSelectedListener;
import java.util.List;

/*
 * Exception performing whole class analysis ignored.
 */
class WheelTime.1
implements OnItemSelectedListener {
    final WheelTime this$0;

    WheelTime.1(WheelTime wheelTime) {
        this.this$0 = wheelTime;
    }

    public void onItemSelected(int n) {
        WheelTime.access$100((WheelTime)this.this$0).setAdapter((WheelAdapter)new ArrayWheelAdapter((List)ChinaDate.getMonths((int)(n += WheelTime.access$000((WheelTime)this.this$0)))));
        if (ChinaDate.leapMonth((int)n) != 0 && WheelTime.access$100((WheelTime)this.this$0).getCurrentItem() > ChinaDate.leapMonth((int)n) - 1) {
            WheelTime.access$100((WheelTime)this.this$0).setCurrentItem(WheelTime.access$100((WheelTime)this.this$0).getCurrentItem() + 1);
        } else {
            WheelTime.access$100((WheelTime)this.this$0).setCurrentItem(WheelTime.access$100((WheelTime)this.this$0).getCurrentItem());
        }
        if (ChinaDate.leapMonth((int)n) != 0 && WheelTime.access$100((WheelTime)this.this$0).getCurrentItem() > ChinaDate.leapMonth((int)n) - 1) {
            if (WheelTime.access$100((WheelTime)this.this$0).getCurrentItem() == ChinaDate.leapMonth((int)n) + 1) {
                WheelTime.access$200((WheelTime)this.this$0).setAdapter((WheelAdapter)new ArrayWheelAdapter((List)ChinaDate.getLunarDays((int)ChinaDate.leapDays((int)n))));
                n = ChinaDate.leapDays((int)n);
            } else {
                WheelTime.access$200((WheelTime)this.this$0).setAdapter((WheelAdapter)new ArrayWheelAdapter((List)ChinaDate.getLunarDays((int)ChinaDate.monthDays((int)n, (int)WheelTime.access$100((WheelTime)this.this$0).getCurrentItem()))));
                n = ChinaDate.monthDays((int)n, (int)WheelTime.access$100((WheelTime)this.this$0).getCurrentItem());
            }
        } else {
            WheelTime.access$200((WheelTime)this.this$0).setAdapter((WheelAdapter)new ArrayWheelAdapter((List)ChinaDate.getLunarDays((int)ChinaDate.monthDays((int)n, (int)(WheelTime.access$100((WheelTime)this.this$0).getCurrentItem() + 1)))));
            n = ChinaDate.monthDays((int)n, (int)(WheelTime.access$100((WheelTime)this.this$0).getCurrentItem() + 1));
        }
        int n2 = WheelTime.access$200((WheelTime)this.this$0).getCurrentItem();
        if (n2 > --n) {
            WheelTime.access$200((WheelTime)this.this$0).setCurrentItem(n);
        }
        if (WheelTime.access$300((WheelTime)this.this$0) == null) return;
        WheelTime.access$300((WheelTime)this.this$0).onTimeSelectChanged();
    }
}
