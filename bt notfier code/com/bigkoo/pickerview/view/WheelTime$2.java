/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.bigkoo.pickerview.adapter.ArrayWheelAdapter
 *  com.bigkoo.pickerview.utils.ChinaDate
 *  com.bigkoo.pickerview.view.WheelTime
 *  com.contrarywind.adapter.WheelAdapter
 *  com.contrarywind.listener.OnItemSelectedListener
 *  com.contrarywind.view.WheelView
 */
package com.bigkoo.pickerview.view;

import com.bigkoo.pickerview.adapter.ArrayWheelAdapter;
import com.bigkoo.pickerview.utils.ChinaDate;
import com.bigkoo.pickerview.view.WheelTime;
import com.contrarywind.adapter.WheelAdapter;
import com.contrarywind.listener.OnItemSelectedListener;
import com.contrarywind.view.WheelView;
import java.util.List;

/*
 * Exception performing whole class analysis ignored.
 */
class WheelTime.2
implements OnItemSelectedListener {
    final WheelTime this$0;

    WheelTime.2(WheelTime wheelTime) {
        this.this$0 = wheelTime;
    }

    public void onItemSelected(int n) {
        int n2 = WheelTime.access$400((WheelTime)this.this$0).getCurrentItem() + WheelTime.access$000((WheelTime)this.this$0);
        if (ChinaDate.leapMonth((int)n2) != 0 && n > ChinaDate.leapMonth((int)n2) - 1) {
            if (WheelTime.access$100((WheelTime)this.this$0).getCurrentItem() == ChinaDate.leapMonth((int)n2) + 1) {
                WheelTime.access$200((WheelTime)this.this$0).setAdapter((WheelAdapter)new ArrayWheelAdapter((List)ChinaDate.getLunarDays((int)ChinaDate.leapDays((int)n2))));
                n = ChinaDate.leapDays((int)n2);
            } else {
                WheelTime.access$200((WheelTime)this.this$0).setAdapter((WheelAdapter)new ArrayWheelAdapter((List)ChinaDate.getLunarDays((int)ChinaDate.monthDays((int)n2, (int)n))));
                n = ChinaDate.monthDays((int)n2, (int)n);
            }
        } else {
            WheelView wheelView = WheelTime.access$200((WheelTime)this.this$0);
            wheelView.setAdapter((WheelAdapter)new ArrayWheelAdapter((List)ChinaDate.getLunarDays((int)ChinaDate.monthDays((int)n2, (int)(++n)))));
            n = ChinaDate.monthDays((int)n2, (int)n);
        }
        n2 = WheelTime.access$200((WheelTime)this.this$0).getCurrentItem();
        if (n2 > --n) {
            WheelTime.access$200((WheelTime)this.this$0).setCurrentItem(n);
        }
        if (WheelTime.access$300((WheelTime)this.this$0) == null) return;
        WheelTime.access$300((WheelTime)this.this$0).onTimeSelectChanged();
    }
}
