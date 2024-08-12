/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.view.MotionEvent
 *  android.view.View$MeasureSpec
 *  androidx.viewpager.widget.PagerAdapter
 *  androidx.viewpager.widget.ViewPager
 *  androidx.viewpager.widget.ViewPager$OnPageChangeListener
 *  com.haibin.calendarview.BaseWeekView
 *  com.haibin.calendarview.Calendar
 *  com.haibin.calendarview.CalendarLayout
 *  com.haibin.calendarview.CalendarUtil
 *  com.haibin.calendarview.CalendarViewDelegate
 *  com.haibin.calendarview.LunarCalendar
 *  com.haibin.calendarview.WeekViewPager$WeekViewPagerAdapter
 */
package com.haibin.calendarview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.haibin.calendarview.BaseWeekView;
import com.haibin.calendarview.Calendar;
import com.haibin.calendarview.CalendarLayout;
import com.haibin.calendarview.CalendarUtil;
import com.haibin.calendarview.CalendarViewDelegate;
import com.haibin.calendarview.LunarCalendar;
import com.haibin.calendarview.WeekViewPager;
import java.util.List;

public final class WeekViewPager
extends ViewPager {
    private boolean isUpdateWeekView;
    private boolean isUsingScrollToCalendar = false;
    private CalendarViewDelegate mDelegate;
    CalendarLayout mParentLayout;
    private int mWeekCount;

    public WeekViewPager(Context context) {
        this(context, null);
    }

    public WeekViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    static /* synthetic */ boolean access$100(WeekViewPager weekViewPager) {
        return weekViewPager.isUsingScrollToCalendar;
    }

    static /* synthetic */ boolean access$102(WeekViewPager weekViewPager, boolean bl) {
        weekViewPager.isUsingScrollToCalendar = bl;
        return bl;
    }

    static /* synthetic */ CalendarViewDelegate access$200(WeekViewPager weekViewPager) {
        return weekViewPager.mDelegate;
    }

    static /* synthetic */ int access$300(WeekViewPager weekViewPager) {
        return weekViewPager.mWeekCount;
    }

    static /* synthetic */ boolean access$400(WeekViewPager weekViewPager) {
        return weekViewPager.isUpdateWeekView;
    }

    private void init() {
        this.mWeekCount = CalendarUtil.getWeekCountBetweenBothCalendar((int)this.mDelegate.getMinYear(), (int)this.mDelegate.getMinYearMonth(), (int)this.mDelegate.getMinYearDay(), (int)this.mDelegate.getMaxYear(), (int)this.mDelegate.getMaxYearMonth(), (int)this.mDelegate.getMaxYearDay(), (int)this.mDelegate.getWeekStart());
        this.setAdapter((PagerAdapter)new WeekViewPagerAdapter(this, null));
        this.addOnPageChangeListener((ViewPager.OnPageChangeListener)new /* Unavailable Anonymous Inner Class!! */);
    }

    final void clearMultiSelect() {
        int n = 0;
        while (n < this.getChildCount()) {
            BaseWeekView baseWeekView = (BaseWeekView)this.getChildAt(n);
            baseWeekView.mCurrentItem = -1;
            baseWeekView.invalidate();
            ++n;
        }
    }

    final void clearSelectRange() {
        int n = 0;
        while (n < this.getChildCount()) {
            ((BaseWeekView)this.getChildAt(n)).invalidate();
            ++n;
        }
    }

    final void clearSingleSelect() {
        int n = 0;
        while (n < this.getChildCount()) {
            BaseWeekView baseWeekView = (BaseWeekView)this.getChildAt(n);
            baseWeekView.mCurrentItem = -1;
            baseWeekView.invalidate();
            ++n;
        }
    }

    List<Calendar> getCurrentWeekCalendars() {
        List list = CalendarUtil.getWeekCalendars((Calendar)this.mDelegate.mIndexCalendar, (CalendarViewDelegate)this.mDelegate);
        this.mDelegate.addSchemesFromMap(list);
        return list;
    }

    void notifyDataSetChanged() {
        this.mWeekCount = CalendarUtil.getWeekCountBetweenBothCalendar((int)this.mDelegate.getMinYear(), (int)this.mDelegate.getMinYearMonth(), (int)this.mDelegate.getMinYearDay(), (int)this.mDelegate.getMaxYear(), (int)this.mDelegate.getMaxYearMonth(), (int)this.mDelegate.getMaxYearDay(), (int)this.mDelegate.getWeekStart());
        this.getAdapter().notifyDataSetChanged();
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        boolean bl = this.mDelegate.isWeekViewScrollable() && super.onInterceptTouchEvent(motionEvent);
        return bl;
    }

    protected void onMeasure(int n, int n2) {
        super.onMeasure(n, View.MeasureSpec.makeMeasureSpec((int)this.mDelegate.getCalendarItemHeight(), (int)0x40000000));
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean bl = this.mDelegate.isWeekViewScrollable() && super.onTouchEvent(motionEvent);
        return bl;
    }

    void scrollToCalendar(int n, int n2, int n3, boolean bl) {
        this.isUsingScrollToCalendar = true;
        Calendar calendar = new Calendar();
        calendar.setYear(n);
        calendar.setMonth(n2);
        calendar.setDay(n3);
        calendar.setCurrentDay(calendar.equals((Object)this.mDelegate.getCurrentDay()));
        LunarCalendar.setupLunarCalendar((Calendar)calendar);
        this.mDelegate.mIndexCalendar = calendar;
        this.mDelegate.mSelectedCalendar = calendar;
        this.mDelegate.updateSelectCalendarScheme();
        this.updateSelected(calendar, bl);
        if (this.mDelegate.mInnerListener != null) {
            this.mDelegate.mInnerListener.onWeekDateSelected(calendar, false);
        }
        if (this.mDelegate.mCalendarSelectListener != null) {
            this.mDelegate.mCalendarSelectListener.onCalendarSelect(calendar, false);
        }
        n = CalendarUtil.getWeekFromDayInMonth((Calendar)calendar, (int)this.mDelegate.getWeekStart());
        this.mParentLayout.updateSelectWeek(n);
    }

    void scrollToCurrent(boolean bl) {
        this.isUsingScrollToCalendar = true;
        int n = CalendarUtil.getWeekFromCalendarStartWithMinCalendar((Calendar)this.mDelegate.getCurrentDay(), (int)this.mDelegate.getMinYear(), (int)this.mDelegate.getMinYearMonth(), (int)this.mDelegate.getMinYearDay(), (int)this.mDelegate.getWeekStart()) - 1;
        if (this.getCurrentItem() == n) {
            this.isUsingScrollToCalendar = false;
        }
        this.setCurrentItem(n, bl);
        BaseWeekView baseWeekView = (BaseWeekView)this.findViewWithTag(n);
        if (baseWeekView != null) {
            baseWeekView.performClickCalendar(this.mDelegate.getCurrentDay(), false);
            baseWeekView.setSelectedCalendar(this.mDelegate.getCurrentDay());
            baseWeekView.invalidate();
        }
        if (this.mDelegate.mCalendarSelectListener != null && this.getVisibility() == 0) {
            this.mDelegate.mCalendarSelectListener.onCalendarSelect(this.mDelegate.mSelectedCalendar, false);
        }
        if (this.getVisibility() == 0) {
            this.mDelegate.mInnerListener.onWeekDateSelected(this.mDelegate.getCurrentDay(), false);
        }
        n = CalendarUtil.getWeekFromDayInMonth((Calendar)this.mDelegate.getCurrentDay(), (int)this.mDelegate.getWeekStart());
        this.mParentLayout.updateSelectWeek(n);
    }

    void setup(CalendarViewDelegate calendarViewDelegate) {
        this.mDelegate = calendarViewDelegate;
        this.init();
    }

    void updateCurrentDate() {
        int n = 0;
        while (n < this.getChildCount()) {
            ((BaseWeekView)this.getChildAt(n)).updateCurrentDate();
            ++n;
        }
    }

    void updateDefaultSelect() {
        BaseWeekView baseWeekView = (BaseWeekView)this.findViewWithTag(this.getCurrentItem());
        if (baseWeekView == null) return;
        baseWeekView.setSelectedCalendar(this.mDelegate.mSelectedCalendar);
        baseWeekView.invalidate();
    }

    final void updateItemHeight() {
        int n = 0;
        while (n < this.getChildCount()) {
            BaseWeekView baseWeekView = (BaseWeekView)this.getChildAt(n);
            baseWeekView.updateItemHeight();
            baseWeekView.requestLayout();
            ++n;
        }
    }

    void updateRange() {
        this.isUpdateWeekView = true;
        this.notifyDataSetChanged();
        this.isUpdateWeekView = false;
        if (this.getVisibility() != 0) {
            return;
        }
        this.isUsingScrollToCalendar = true;
        Calendar calendar = this.mDelegate.mSelectedCalendar;
        this.updateSelected(calendar, false);
        if (this.mDelegate.mInnerListener != null) {
            this.mDelegate.mInnerListener.onWeekDateSelected(calendar, false);
        }
        if (this.mDelegate.mCalendarSelectListener != null) {
            this.mDelegate.mCalendarSelectListener.onCalendarSelect(calendar, false);
        }
        int n = CalendarUtil.getWeekFromDayInMonth((Calendar)calendar, (int)this.mDelegate.getWeekStart());
        this.mParentLayout.updateSelectWeek(n);
    }

    void updateScheme() {
        int n = 0;
        while (n < this.getChildCount()) {
            ((BaseWeekView)this.getChildAt(n)).update();
            ++n;
        }
    }

    void updateSelected() {
        int n = 0;
        while (n < this.getChildCount()) {
            BaseWeekView baseWeekView = (BaseWeekView)this.getChildAt(n);
            baseWeekView.setSelectedCalendar(this.mDelegate.mSelectedCalendar);
            baseWeekView.invalidate();
            ++n;
        }
    }

    void updateSelected(Calendar calendar, boolean bl) {
        int n = CalendarUtil.getWeekFromCalendarStartWithMinCalendar((Calendar)calendar, (int)this.mDelegate.getMinYear(), (int)this.mDelegate.getMinYearMonth(), (int)this.mDelegate.getMinYearDay(), (int)this.mDelegate.getWeekStart());
        boolean bl2 = true;
        if (this.getCurrentItem() == --n) {
            bl2 = false;
        }
        this.isUsingScrollToCalendar = bl2;
        this.setCurrentItem(n, bl);
        BaseWeekView baseWeekView = (BaseWeekView)this.findViewWithTag(n);
        if (baseWeekView == null) return;
        baseWeekView.setSelectedCalendar(calendar);
        baseWeekView.invalidate();
    }

    void updateShowMode() {
        int n = 0;
        while (n < this.getChildCount()) {
            ((BaseWeekView)this.getChildAt(n)).updateShowMode();
            ++n;
        }
    }

    void updateSingleSelect() {
        if (this.mDelegate.getSelectMode() == 0) {
            return;
        }
        int n = 0;
        while (n < this.getChildCount()) {
            ((BaseWeekView)this.getChildAt(n)).updateSingleSelect();
            ++n;
        }
    }

    final void updateStyle() {
        int n = 0;
        while (n < this.getChildCount()) {
            BaseWeekView baseWeekView = (BaseWeekView)this.getChildAt(n);
            baseWeekView.updateStyle();
            baseWeekView.invalidate();
            ++n;
        }
    }

    void updateWeekStart() {
        int n;
        int n2 = this.getAdapter().getCount();
        this.mWeekCount = n = CalendarUtil.getWeekCountBetweenBothCalendar((int)this.mDelegate.getMinYear(), (int)this.mDelegate.getMinYearMonth(), (int)this.mDelegate.getMinYearDay(), (int)this.mDelegate.getMaxYear(), (int)this.mDelegate.getMaxYearMonth(), (int)this.mDelegate.getMaxYearDay(), (int)this.mDelegate.getWeekStart());
        if (n2 != n) {
            this.isUpdateWeekView = true;
            this.getAdapter().notifyDataSetChanged();
        }
        n = 0;
        while (true) {
            if (n >= this.getChildCount()) {
                this.isUpdateWeekView = false;
                this.updateSelected(this.mDelegate.mSelectedCalendar, false);
                return;
            }
            ((BaseWeekView)this.getChildAt(n)).updateWeekStart();
            ++n;
        }
    }

    void updateWeekViewClass() {
        this.isUpdateWeekView = true;
        this.getAdapter().notifyDataSetChanged();
        this.isUpdateWeekView = false;
    }
}
