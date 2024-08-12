/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.view.View$MeasureSpec
 *  androidx.recyclerview.widget.GridLayoutManager
 *  androidx.recyclerview.widget.RecyclerView
 *  androidx.recyclerview.widget.RecyclerView$Adapter
 *  androidx.recyclerview.widget.RecyclerView$LayoutManager
 *  com.haibin.calendarview.BaseRecyclerAdapter$OnItemClickListener
 *  com.haibin.calendarview.CalendarUtil
 *  com.haibin.calendarview.CalendarViewDelegate
 *  com.haibin.calendarview.Month
 *  com.haibin.calendarview.YearRecyclerView$OnMonthSelectedListener
 *  com.haibin.calendarview.YearView
 *  com.haibin.calendarview.YearViewAdapter
 */
package com.haibin.calendarview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.haibin.calendarview.BaseRecyclerAdapter;
import com.haibin.calendarview.CalendarUtil;
import com.haibin.calendarview.CalendarViewDelegate;
import com.haibin.calendarview.Month;
import com.haibin.calendarview.YearRecyclerView;
import com.haibin.calendarview.YearView;
import com.haibin.calendarview.YearViewAdapter;
import java.util.Calendar;
import java.util.Iterator;

public final class YearRecyclerView
extends RecyclerView {
    private YearViewAdapter mAdapter;
    private CalendarViewDelegate mDelegate;
    private OnMonthSelectedListener mListener;

    public YearRecyclerView(Context context) {
        this(context, null);
    }

    public YearRecyclerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mAdapter = new YearViewAdapter(context);
        this.setLayoutManager((RecyclerView.LayoutManager)new GridLayoutManager(context, 3));
        this.setAdapter((RecyclerView.Adapter)this.mAdapter);
        this.mAdapter.setOnItemClickListener((BaseRecyclerAdapter.OnItemClickListener)new /* Unavailable Anonymous Inner Class!! */);
    }

    static /* synthetic */ OnMonthSelectedListener access$000(YearRecyclerView yearRecyclerView) {
        return yearRecyclerView.mListener;
    }

    static /* synthetic */ CalendarViewDelegate access$100(YearRecyclerView yearRecyclerView) {
        return yearRecyclerView.mDelegate;
    }

    static /* synthetic */ YearViewAdapter access$200(YearRecyclerView yearRecyclerView) {
        return yearRecyclerView.mAdapter;
    }

    final void init(int n) {
        Calendar calendar = Calendar.getInstance();
        int n2 = 1;
        while (n2 <= 12) {
            calendar.set(n, n2 - 1, 1);
            int n3 = CalendarUtil.getMonthDaysCount((int)n, (int)n2);
            Month month = new Month();
            month.setDiff(CalendarUtil.getMonthViewStartDiff((int)n, (int)n2, (int)this.mDelegate.getWeekStart()));
            month.setCount(n3);
            month.setMonth(n2);
            month.setYear(n);
            this.mAdapter.addItem((Object)month);
            ++n2;
        }
    }

    protected void onMeasure(int n, int n2) {
        super.onMeasure(n, n2);
        n2 = View.MeasureSpec.getSize((int)n2);
        n = View.MeasureSpec.getSize((int)n);
        this.mAdapter.setYearViewSize(n / 3, n2 / 4);
    }

    final void setOnMonthSelectedListener(OnMonthSelectedListener onMonthSelectedListener) {
        this.mListener = onMonthSelectedListener;
    }

    final void setup(CalendarViewDelegate calendarViewDelegate) {
        this.mDelegate = calendarViewDelegate;
        this.mAdapter.setup(calendarViewDelegate);
    }

    final void updateStyle() {
        int n = 0;
        while (n < this.getChildCount()) {
            YearView yearView = (YearView)this.getChildAt(n);
            yearView.updateStyle();
            yearView.invalidate();
            ++n;
        }
    }

    final void updateWeekStart() {
        Iterator iterator = this.mAdapter.getItems().iterator();
        while (iterator.hasNext()) {
            Month month = (Month)iterator.next();
            month.setDiff(CalendarUtil.getMonthViewStartDiff((int)month.getYear(), (int)month.getMonth(), (int)this.mDelegate.getWeekStart()));
        }
    }
}
