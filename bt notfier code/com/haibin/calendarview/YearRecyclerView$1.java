/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.haibin.calendarview.BaseRecyclerAdapter$OnItemClickListener
 *  com.haibin.calendarview.CalendarUtil
 *  com.haibin.calendarview.Month
 *  com.haibin.calendarview.YearRecyclerView
 */
package com.haibin.calendarview;

import com.haibin.calendarview.BaseRecyclerAdapter;
import com.haibin.calendarview.CalendarUtil;
import com.haibin.calendarview.Month;
import com.haibin.calendarview.YearRecyclerView;

/*
 * Exception performing whole class analysis ignored.
 */
class YearRecyclerView.1
implements BaseRecyclerAdapter.OnItemClickListener {
    final YearRecyclerView this$0;

    YearRecyclerView.1(YearRecyclerView yearRecyclerView) {
        this.this$0 = yearRecyclerView;
    }

    public void onItemClick(int n, long l) {
        if (YearRecyclerView.access$000((YearRecyclerView)this.this$0) == null) return;
        if (YearRecyclerView.access$100((YearRecyclerView)this.this$0) == null) return;
        Month month = (Month)YearRecyclerView.access$200((YearRecyclerView)this.this$0).getItem(n);
        if (month == null) {
            return;
        }
        if (!CalendarUtil.isMonthInRange((int)month.getYear(), (int)month.getMonth(), (int)YearRecyclerView.access$100((YearRecyclerView)this.this$0).getMinYear(), (int)YearRecyclerView.access$100((YearRecyclerView)this.this$0).getMinYearMonth(), (int)YearRecyclerView.access$100((YearRecyclerView)this.this$0).getMaxYear(), (int)YearRecyclerView.access$100((YearRecyclerView)this.this$0).getMaxYearMonth())) {
            return;
        }
        YearRecyclerView.access$000((YearRecyclerView)this.this$0).onMonthSelected(month.getYear(), month.getMonth());
        if (YearRecyclerView.access$100((YearRecyclerView)this.this$0).mYearViewChangeListener == null) return;
        YearRecyclerView.access$100((YearRecyclerView)this.this$0).mYearViewChangeListener.onYearViewChange(true);
    }
}
