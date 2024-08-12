/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.view.View$MeasureSpec
 *  com.haibin.calendarview.BaseView
 *  com.haibin.calendarview.Calendar
 *  com.haibin.calendarview.CalendarUtil
 *  com.haibin.calendarview.MonthViewPager
 */
package com.haibin.calendarview;

import android.content.Context;
import android.view.View;
import com.haibin.calendarview.BaseView;
import com.haibin.calendarview.Calendar;
import com.haibin.calendarview.CalendarUtil;
import com.haibin.calendarview.MonthViewPager;
import java.util.Iterator;

public abstract class BaseMonthView
extends BaseView {
    protected int mHeight;
    protected int mLineCount;
    protected int mMonth;
    MonthViewPager mMonthViewPager;
    protected int mNextDiff;
    protected int mYear;

    public BaseMonthView(Context context) {
        super(context);
    }

    private void initCalendar() {
        this.mNextDiff = CalendarUtil.getMonthEndDiff((int)this.mYear, (int)this.mMonth, (int)this.mDelegate.getWeekStart());
        int n = CalendarUtil.getMonthViewStartDiff((int)this.mYear, (int)this.mMonth, (int)this.mDelegate.getWeekStart());
        int n2 = CalendarUtil.getMonthDaysCount((int)this.mYear, (int)this.mMonth);
        this.mItems = CalendarUtil.initCalendarForMonthView((int)this.mYear, (int)this.mMonth, (Calendar)this.mDelegate.getCurrentDay(), (int)this.mDelegate.getWeekStart());
        this.mCurrentItem = this.mItems.contains(this.mDelegate.getCurrentDay()) ? this.mItems.indexOf(this.mDelegate.getCurrentDay()) : this.mItems.indexOf(this.mDelegate.mSelectedCalendar);
        if (this.mCurrentItem > 0 && this.mDelegate.mCalendarInterceptListener != null && this.mDelegate.mCalendarInterceptListener.onCalendarIntercept(this.mDelegate.mSelectedCalendar)) {
            this.mCurrentItem = -1;
        }
        this.mLineCount = this.mDelegate.getMonthViewShowMode() == 0 ? 6 : (n + n2 + this.mNextDiff) / 7;
        this.addSchemesFromMap();
        this.invalidate();
    }

    protected Calendar getIndex() {
        int n;
        if (this.mItemWidth == 0) return null;
        if (this.mItemHeight == 0) {
            return null;
        }
        int n2 = n = (int)(this.mX - (float)this.mDelegate.getCalendarPadding()) / this.mItemWidth;
        if (n >= 7) {
            n2 = 6;
        }
        if ((n2 = (int)this.mY / this.mItemHeight * 7 + n2) < 0) return null;
        if (n2 >= this.mItems.size()) return null;
        return (Calendar)this.mItems.get(n2);
    }

    protected final int getSelectedIndex(Calendar calendar) {
        return this.mItems.indexOf(calendar);
    }

    final void initMonthWithDate(int n, int n2) {
        this.mYear = n;
        this.mMonth = n2;
        this.initCalendar();
        this.mHeight = CalendarUtil.getMonthViewHeight((int)n, (int)n2, (int)this.mItemHeight, (int)this.mDelegate.getWeekStart(), (int)this.mDelegate.getMonthViewShowMode());
    }

    protected void onDestroy() {
    }

    protected void onLoopStart(int n, int n2) {
    }

    protected void onMeasure(int n, int n2) {
        if (this.mLineCount != 0) {
            n2 = View.MeasureSpec.makeMeasureSpec((int)this.mHeight, (int)0x40000000);
        }
        super.onMeasure(n, n2);
    }

    protected void onPreviewHook() {
    }

    final void setSelectedCalendar(Calendar calendar) {
        this.mCurrentItem = this.mItems.indexOf(calendar);
    }

    void updateCurrentDate() {
        if (this.mItems == null) {
            return;
        }
        if (this.mItems.contains(this.mDelegate.getCurrentDay())) {
            Iterator iterator = this.mItems.iterator();
            while (iterator.hasNext()) {
                ((Calendar)iterator.next()).setCurrentDay(false);
            }
            int n = this.mItems.indexOf(this.mDelegate.getCurrentDay());
            ((Calendar)this.mItems.get(n)).setCurrentDay(true);
        }
        this.invalidate();
    }

    void updateItemHeight() {
        super.updateItemHeight();
        this.mHeight = CalendarUtil.getMonthViewHeight((int)this.mYear, (int)this.mMonth, (int)this.mItemHeight, (int)this.mDelegate.getWeekStart(), (int)this.mDelegate.getMonthViewShowMode());
    }

    final void updateShowMode() {
        this.mLineCount = CalendarUtil.getMonthViewLineCount((int)this.mYear, (int)this.mMonth, (int)this.mDelegate.getWeekStart(), (int)this.mDelegate.getMonthViewShowMode());
        this.mHeight = CalendarUtil.getMonthViewHeight((int)this.mYear, (int)this.mMonth, (int)this.mItemHeight, (int)this.mDelegate.getWeekStart(), (int)this.mDelegate.getMonthViewShowMode());
        this.invalidate();
    }

    final void updateWeekStart() {
        this.initCalendar();
        this.mHeight = CalendarUtil.getMonthViewHeight((int)this.mYear, (int)this.mMonth, (int)this.mItemHeight, (int)this.mDelegate.getWeekStart(), (int)this.mDelegate.getMonthViewShowMode());
    }
}
