/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.view.MotionEvent
 *  android.view.View
 *  android.view.View$MeasureSpec
 *  android.view.WindowManager
 *  androidx.viewpager.widget.PagerAdapter
 *  androidx.viewpager.widget.ViewPager
 *  com.haibin.calendarview.CalendarViewDelegate
 *  com.haibin.calendarview.YearRecyclerView
 *  com.haibin.calendarview.YearRecyclerView$OnMonthSelectedListener
 */
package com.haibin.calendarview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.haibin.calendarview.CalendarViewDelegate;
import com.haibin.calendarview.YearRecyclerView;

public final class YearViewPager
extends ViewPager {
    static final boolean $assertionsDisabled = false;
    private boolean isUpdateYearView;
    private CalendarViewDelegate mDelegate;
    private YearRecyclerView.OnMonthSelectedListener mListener;
    private int mYearCount;

    public YearViewPager(Context context) {
        this(context, null);
    }

    public YearViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    static /* synthetic */ int access$000(YearViewPager yearViewPager) {
        return yearViewPager.mYearCount;
    }

    static /* synthetic */ boolean access$100(YearViewPager yearViewPager) {
        return yearViewPager.isUpdateYearView;
    }

    static /* synthetic */ CalendarViewDelegate access$200(YearViewPager yearViewPager) {
        return yearViewPager.mDelegate;
    }

    static /* synthetic */ YearRecyclerView.OnMonthSelectedListener access$300(YearViewPager yearViewPager) {
        return yearViewPager.mListener;
    }

    private static int getHeight(Context object, View view) {
        int n = ((WindowManager)object.getSystemService("window")).getDefaultDisplay().getHeight();
        object = new int[2];
        view.getLocationInWindow((int[])object);
        view.getLocationOnScreen((int[])object);
        return n - object[1];
    }

    void notifyDataSetChanged() {
        this.mYearCount = this.mDelegate.getMaxYear() - this.mDelegate.getMinYear() + 1;
        this.getAdapter().notifyDataSetChanged();
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        boolean bl = this.mDelegate.isYearViewScrollable() && super.onInterceptTouchEvent(motionEvent);
        return bl;
    }

    protected void onMeasure(int n, int n2) {
        super.onMeasure(n, View.MeasureSpec.makeMeasureSpec((int)YearViewPager.getHeight(this.getContext(), (View)this), (int)0x40000000));
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean bl = this.mDelegate.isYearViewScrollable() && super.onTouchEvent(motionEvent);
        return bl;
    }

    void scrollToYear(int n, boolean bl) {
        this.setCurrentItem(n - this.mDelegate.getMinYear(), bl);
    }

    public void setCurrentItem(int n) {
        this.setCurrentItem(n, false);
    }

    public void setCurrentItem(int n, boolean bl) {
        if (Math.abs(this.getCurrentItem() - n) > 1) {
            super.setCurrentItem(n, false);
        } else {
            super.setCurrentItem(n, false);
        }
    }

    final void setOnMonthSelectedListener(YearRecyclerView.OnMonthSelectedListener onMonthSelectedListener) {
        this.mListener = onMonthSelectedListener;
    }

    void setup(CalendarViewDelegate calendarViewDelegate) {
        this.mDelegate = calendarViewDelegate;
        this.mYearCount = calendarViewDelegate.getMaxYear() - this.mDelegate.getMinYear() + 1;
        this.setAdapter((PagerAdapter)new /* Unavailable Anonymous Inner Class!! */);
        this.setCurrentItem(this.mDelegate.getCurrentDay().getYear() - this.mDelegate.getMinYear());
    }

    final void update() {
        int n = 0;
        while (n < this.getChildCount()) {
            ((YearRecyclerView)this.getChildAt(n)).getAdapter().notifyDataSetChanged();
            ++n;
        }
    }

    final void updateRange() {
        this.isUpdateYearView = true;
        this.notifyDataSetChanged();
        this.isUpdateYearView = false;
    }

    final void updateStyle() {
        int n = 0;
        while (n < this.getChildCount()) {
            ((YearRecyclerView)this.getChildAt(n)).updateStyle();
            ++n;
        }
    }

    final void updateWeekStart() {
        int n = 0;
        while (n < this.getChildCount()) {
            YearRecyclerView yearRecyclerView = (YearRecyclerView)this.getChildAt(n);
            yearRecyclerView.updateWeekStart();
            yearRecyclerView.getAdapter().notifyDataSetChanged();
            ++n;
        }
    }
}
