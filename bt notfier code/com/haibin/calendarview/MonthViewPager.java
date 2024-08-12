/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.view.MotionEvent
 *  android.view.ViewGroup$LayoutParams
 *  androidx.viewpager.widget.PagerAdapter
 *  androidx.viewpager.widget.ViewPager
 *  androidx.viewpager.widget.ViewPager$OnPageChangeListener
 *  com.haibin.calendarview.BaseMonthView
 *  com.haibin.calendarview.Calendar
 *  com.haibin.calendarview.CalendarLayout
 *  com.haibin.calendarview.CalendarUtil
 *  com.haibin.calendarview.CalendarViewDelegate
 *  com.haibin.calendarview.LunarCalendar
 *  com.haibin.calendarview.MonthViewPager$MonthViewPagerAdapter
 *  com.haibin.calendarview.WeekBar
 *  com.haibin.calendarview.WeekViewPager
 */
package com.haibin.calendarview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewGroup;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.haibin.calendarview.BaseMonthView;
import com.haibin.calendarview.Calendar;
import com.haibin.calendarview.CalendarLayout;
import com.haibin.calendarview.CalendarUtil;
import com.haibin.calendarview.CalendarViewDelegate;
import com.haibin.calendarview.LunarCalendar;
import com.haibin.calendarview.MonthViewPager;
import com.haibin.calendarview.WeekBar;
import com.haibin.calendarview.WeekViewPager;
import java.util.List;

public final class MonthViewPager
extends ViewPager {
    private boolean isUpdateMonthView;
    private boolean isUsingScrollToCalendar = false;
    private int mCurrentViewHeight;
    private CalendarViewDelegate mDelegate;
    private int mMonthCount;
    private int mNextViewHeight;
    CalendarLayout mParentLayout;
    private int mPreViewHeight;
    WeekBar mWeekBar;
    WeekViewPager mWeekPager;

    public MonthViewPager(Context context) {
        this(context, null);
    }

    public MonthViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    static /* synthetic */ CalendarViewDelegate access$100(MonthViewPager monthViewPager) {
        return monthViewPager.mDelegate;
    }

    static /* synthetic */ int access$200(MonthViewPager monthViewPager) {
        return monthViewPager.mPreViewHeight;
    }

    static /* synthetic */ int access$300(MonthViewPager monthViewPager) {
        return monthViewPager.mCurrentViewHeight;
    }

    static /* synthetic */ int access$400(MonthViewPager monthViewPager) {
        return monthViewPager.mNextViewHeight;
    }

    static /* synthetic */ void access$500(MonthViewPager monthViewPager, int n, int n2) {
        monthViewPager.updateMonthViewHeight(n, n2);
    }

    static /* synthetic */ boolean access$600(MonthViewPager monthViewPager) {
        return monthViewPager.isUsingScrollToCalendar;
    }

    static /* synthetic */ boolean access$602(MonthViewPager monthViewPager, boolean bl) {
        monthViewPager.isUsingScrollToCalendar = bl;
        return bl;
    }

    static /* synthetic */ int access$700(MonthViewPager monthViewPager) {
        return monthViewPager.mMonthCount;
    }

    static /* synthetic */ boolean access$800(MonthViewPager monthViewPager) {
        return monthViewPager.isUpdateMonthView;
    }

    private void init() {
        this.mMonthCount = (this.mDelegate.getMaxYear() - this.mDelegate.getMinYear()) * 12 - this.mDelegate.getMinYearMonth() + 1 + this.mDelegate.getMaxYearMonth();
        this.setAdapter((PagerAdapter)new MonthViewPagerAdapter(this, null));
        this.addOnPageChangeListener((ViewPager.OnPageChangeListener)new /* Unavailable Anonymous Inner Class!! */);
    }

    private void updateMonthViewHeight(int n, int n2) {
        if (this.mDelegate.getMonthViewShowMode() == 0) {
            this.getLayoutParams().height = this.mCurrentViewHeight = this.mDelegate.getCalendarItemHeight() * 6;
            return;
        }
        if (this.mParentLayout != null) {
            if (this.getVisibility() != 0) {
                ViewGroup.LayoutParams layoutParams = this.getLayoutParams();
                layoutParams.height = CalendarUtil.getMonthViewHeight((int)n, (int)n2, (int)this.mDelegate.getCalendarItemHeight(), (int)this.mDelegate.getWeekStart(), (int)this.mDelegate.getMonthViewShowMode());
                this.setLayoutParams(layoutParams);
            }
            this.mParentLayout.updateContentViewTranslateY();
        }
        this.mCurrentViewHeight = CalendarUtil.getMonthViewHeight((int)n, (int)n2, (int)this.mDelegate.getCalendarItemHeight(), (int)this.mDelegate.getWeekStart(), (int)this.mDelegate.getMonthViewShowMode());
        if (n2 == 1) {
            this.mPreViewHeight = CalendarUtil.getMonthViewHeight((int)(n - 1), (int)12, (int)this.mDelegate.getCalendarItemHeight(), (int)this.mDelegate.getWeekStart(), (int)this.mDelegate.getMonthViewShowMode());
            this.mNextViewHeight = CalendarUtil.getMonthViewHeight((int)n, (int)2, (int)this.mDelegate.getCalendarItemHeight(), (int)this.mDelegate.getWeekStart(), (int)this.mDelegate.getMonthViewShowMode());
        } else {
            this.mPreViewHeight = CalendarUtil.getMonthViewHeight((int)n, (int)(n2 - 1), (int)this.mDelegate.getCalendarItemHeight(), (int)this.mDelegate.getWeekStart(), (int)this.mDelegate.getMonthViewShowMode());
            this.mNextViewHeight = n2 == 12 ? CalendarUtil.getMonthViewHeight((int)(n + 1), (int)1, (int)this.mDelegate.getCalendarItemHeight(), (int)this.mDelegate.getWeekStart(), (int)this.mDelegate.getMonthViewShowMode()) : CalendarUtil.getMonthViewHeight((int)n, (int)(n2 + 1), (int)this.mDelegate.getCalendarItemHeight(), (int)this.mDelegate.getWeekStart(), (int)this.mDelegate.getMonthViewShowMode());
        }
    }

    final void clearMultiSelect() {
        int n = 0;
        while (n < this.getChildCount()) {
            BaseMonthView baseMonthView = (BaseMonthView)this.getChildAt(n);
            baseMonthView.mCurrentItem = -1;
            baseMonthView.invalidate();
            ++n;
        }
    }

    final void clearSelectRange() {
        int n = 0;
        while (n < this.getChildCount()) {
            ((BaseMonthView)this.getChildAt(n)).invalidate();
            ++n;
        }
    }

    final void clearSingleSelect() {
        int n = 0;
        while (n < this.getChildCount()) {
            BaseMonthView baseMonthView = (BaseMonthView)this.getChildAt(n);
            baseMonthView.mCurrentItem = -1;
            baseMonthView.invalidate();
            ++n;
        }
    }

    List<Calendar> getCurrentMonthCalendars() {
        BaseMonthView baseMonthView = (BaseMonthView)this.findViewWithTag(this.getCurrentItem());
        if (baseMonthView != null) return baseMonthView.mItems;
        return null;
    }

    void notifyDataSetChanged() {
        this.mMonthCount = (this.mDelegate.getMaxYear() - this.mDelegate.getMinYear()) * 12 - this.mDelegate.getMinYearMonth() + 1 + this.mDelegate.getMaxYearMonth();
        this.getAdapter().notifyDataSetChanged();
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        boolean bl = this.mDelegate.isMonthViewScrollable() && super.onInterceptTouchEvent(motionEvent);
        return bl;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean bl = this.mDelegate.isMonthViewScrollable() && super.onTouchEvent(motionEvent);
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
        n = (calendar.getYear() - this.mDelegate.getMinYear()) * 12 + calendar.getMonth() - this.mDelegate.getMinYearMonth();
        if (this.getCurrentItem() == n) {
            this.isUsingScrollToCalendar = false;
        }
        this.setCurrentItem(n, bl);
        BaseMonthView baseMonthView = (BaseMonthView)this.findViewWithTag(n);
        if (baseMonthView != null) {
            baseMonthView.setSelectedCalendar(this.mDelegate.mIndexCalendar);
            baseMonthView.invalidate();
            CalendarLayout calendarLayout = this.mParentLayout;
            if (calendarLayout != null) {
                calendarLayout.updateSelectPosition(baseMonthView.getSelectedIndex(this.mDelegate.mIndexCalendar));
            }
        }
        if (this.mParentLayout != null) {
            n = CalendarUtil.getWeekFromDayInMonth((Calendar)calendar, (int)this.mDelegate.getWeekStart());
            this.mParentLayout.updateSelectWeek(n);
        }
        if (this.mDelegate.mCalendarSelectListener != null) {
            this.mDelegate.mCalendarSelectListener.onCalendarSelect(calendar, false);
        }
        if (this.mDelegate.mInnerListener != null) {
            this.mDelegate.mInnerListener.onMonthDateSelected(calendar, false);
        }
        this.updateSelected();
    }

    void scrollToCurrent(boolean bl) {
        this.isUsingScrollToCalendar = true;
        int n = (this.mDelegate.getCurrentDay().getYear() - this.mDelegate.getMinYear()) * 12 + this.mDelegate.getCurrentDay().getMonth() - this.mDelegate.getMinYearMonth();
        if (this.getCurrentItem() == n) {
            this.isUsingScrollToCalendar = false;
        }
        this.setCurrentItem(n, bl);
        BaseMonthView baseMonthView = (BaseMonthView)this.findViewWithTag(n);
        if (baseMonthView != null) {
            baseMonthView.setSelectedCalendar(this.mDelegate.getCurrentDay());
            baseMonthView.invalidate();
            CalendarLayout calendarLayout = this.mParentLayout;
            if (calendarLayout != null) {
                calendarLayout.updateSelectPosition(baseMonthView.getSelectedIndex(this.mDelegate.getCurrentDay()));
            }
        }
        if (this.mDelegate.mCalendarSelectListener == null) return;
        if (this.getVisibility() != 0) return;
        this.mDelegate.mCalendarSelectListener.onCalendarSelect(this.mDelegate.mSelectedCalendar, false);
    }

    public void setCurrentItem(int n) {
        this.setCurrentItem(n, true);
    }

    public void setCurrentItem(int n, boolean bl) {
        if (Math.abs(this.getCurrentItem() - n) > 1) {
            super.setCurrentItem(n, false);
        } else {
            super.setCurrentItem(n, bl);
        }
    }

    void setup(CalendarViewDelegate calendarViewDelegate) {
        this.mDelegate = calendarViewDelegate;
        this.updateMonthViewHeight(calendarViewDelegate.getCurrentDay().getYear(), this.mDelegate.getCurrentDay().getMonth());
        calendarViewDelegate = this.getLayoutParams();
        calendarViewDelegate.height = this.mCurrentViewHeight;
        this.setLayoutParams((ViewGroup.LayoutParams)calendarViewDelegate);
        this.init();
    }

    void updateCurrentDate() {
        int n = 0;
        while (n < this.getChildCount()) {
            ((BaseMonthView)this.getChildAt(n)).updateCurrentDate();
            ++n;
        }
    }

    void updateDefaultSelect() {
        CalendarLayout calendarLayout;
        int n;
        BaseMonthView baseMonthView = (BaseMonthView)this.findViewWithTag(this.getCurrentItem());
        if (baseMonthView == null) return;
        baseMonthView.mCurrentItem = n = baseMonthView.getSelectedIndex(this.mDelegate.mSelectedCalendar);
        if (n >= 0 && (calendarLayout = this.mParentLayout) != null) {
            calendarLayout.updateSelectPosition(n);
        }
        baseMonthView.invalidate();
    }

    final void updateItemHeight() {
        BaseMonthView baseMonthView;
        int n;
        for (n = 0; n < this.getChildCount(); ++n) {
            baseMonthView = (BaseMonthView)this.getChildAt(n);
            baseMonthView.updateItemHeight();
            baseMonthView.requestLayout();
        }
        n = this.mDelegate.mIndexCalendar.getYear();
        int n2 = this.mDelegate.mIndexCalendar.getMonth();
        this.mCurrentViewHeight = CalendarUtil.getMonthViewHeight((int)n, (int)n2, (int)this.mDelegate.getCalendarItemHeight(), (int)this.mDelegate.getWeekStart(), (int)this.mDelegate.getMonthViewShowMode());
        if (n2 == 1) {
            this.mPreViewHeight = CalendarUtil.getMonthViewHeight((int)(n - 1), (int)12, (int)this.mDelegate.getCalendarItemHeight(), (int)this.mDelegate.getWeekStart(), (int)this.mDelegate.getMonthViewShowMode());
            this.mNextViewHeight = CalendarUtil.getMonthViewHeight((int)n, (int)2, (int)this.mDelegate.getCalendarItemHeight(), (int)this.mDelegate.getWeekStart(), (int)this.mDelegate.getMonthViewShowMode());
        } else {
            this.mPreViewHeight = CalendarUtil.getMonthViewHeight((int)n, (int)(n2 - 1), (int)this.mDelegate.getCalendarItemHeight(), (int)this.mDelegate.getWeekStart(), (int)this.mDelegate.getMonthViewShowMode());
            this.mNextViewHeight = n2 == 12 ? CalendarUtil.getMonthViewHeight((int)(n + 1), (int)1, (int)this.mDelegate.getCalendarItemHeight(), (int)this.mDelegate.getWeekStart(), (int)this.mDelegate.getMonthViewShowMode()) : CalendarUtil.getMonthViewHeight((int)n, (int)(n2 + 1), (int)this.mDelegate.getCalendarItemHeight(), (int)this.mDelegate.getWeekStart(), (int)this.mDelegate.getMonthViewShowMode());
        }
        baseMonthView = this.getLayoutParams();
        baseMonthView.height = this.mCurrentViewHeight;
        this.setLayoutParams((ViewGroup.LayoutParams)baseMonthView);
    }

    void updateMonthViewClass() {
        this.isUpdateMonthView = true;
        this.getAdapter().notifyDataSetChanged();
        this.isUpdateMonthView = false;
    }

    final void updateRange() {
        this.isUpdateMonthView = true;
        this.notifyDataSetChanged();
        this.isUpdateMonthView = false;
        if (this.getVisibility() != 0) {
            return;
        }
        this.isUsingScrollToCalendar = false;
        Calendar calendar = this.mDelegate.mSelectedCalendar;
        int n = (calendar.getYear() - this.mDelegate.getMinYear()) * 12 + calendar.getMonth() - this.mDelegate.getMinYearMonth();
        this.setCurrentItem(n, false);
        BaseMonthView baseMonthView = (BaseMonthView)this.findViewWithTag(n);
        if (baseMonthView != null) {
            baseMonthView.setSelectedCalendar(this.mDelegate.mIndexCalendar);
            baseMonthView.invalidate();
            CalendarLayout calendarLayout = this.mParentLayout;
            if (calendarLayout != null) {
                calendarLayout.updateSelectPosition(baseMonthView.getSelectedIndex(this.mDelegate.mIndexCalendar));
            }
        }
        if (this.mParentLayout != null) {
            n = CalendarUtil.getWeekFromDayInMonth((Calendar)calendar, (int)this.mDelegate.getWeekStart());
            this.mParentLayout.updateSelectWeek(n);
        }
        if (this.mDelegate.mInnerListener != null) {
            this.mDelegate.mInnerListener.onMonthDateSelected(calendar, false);
        }
        if (this.mDelegate.mCalendarSelectListener != null) {
            this.mDelegate.mCalendarSelectListener.onCalendarSelect(calendar, false);
        }
        this.updateSelected();
    }

    void updateScheme() {
        int n = 0;
        while (n < this.getChildCount()) {
            ((BaseMonthView)this.getChildAt(n)).update();
            ++n;
        }
    }

    void updateSelected() {
        int n = 0;
        while (n < this.getChildCount()) {
            BaseMonthView baseMonthView = (BaseMonthView)this.getChildAt(n);
            baseMonthView.setSelectedCalendar(this.mDelegate.mSelectedCalendar);
            baseMonthView.invalidate();
            ++n;
        }
    }

    void updateShowMode() {
        BaseMonthView baseMonthView;
        int n;
        for (n = 0; n < this.getChildCount(); ++n) {
            baseMonthView = (BaseMonthView)this.getChildAt(n);
            baseMonthView.updateShowMode();
            baseMonthView.requestLayout();
        }
        if (this.mDelegate.getMonthViewShowMode() == 0) {
            this.mCurrentViewHeight = n = this.mDelegate.getCalendarItemHeight() * 6;
            this.mNextViewHeight = n;
            this.mPreViewHeight = n;
        } else {
            this.updateMonthViewHeight(this.mDelegate.mSelectedCalendar.getYear(), this.mDelegate.mSelectedCalendar.getMonth());
        }
        baseMonthView = this.getLayoutParams();
        baseMonthView.height = this.mCurrentViewHeight;
        this.setLayoutParams((ViewGroup.LayoutParams)baseMonthView);
        baseMonthView = this.mParentLayout;
        if (baseMonthView == null) return;
        baseMonthView.updateContentViewTranslateY();
    }

    final void updateStyle() {
        int n = 0;
        while (n < this.getChildCount()) {
            BaseMonthView baseMonthView = (BaseMonthView)this.getChildAt(n);
            baseMonthView.updateStyle();
            baseMonthView.invalidate();
            ++n;
        }
    }

    void updateWeekStart() {
        BaseMonthView baseMonthView;
        int n;
        for (n = 0; n < this.getChildCount(); ++n) {
            baseMonthView = (BaseMonthView)this.getChildAt(n);
            baseMonthView.updateWeekStart();
            baseMonthView.requestLayout();
        }
        this.updateMonthViewHeight(this.mDelegate.mSelectedCalendar.getYear(), this.mDelegate.mSelectedCalendar.getMonth());
        baseMonthView = this.getLayoutParams();
        baseMonthView.height = this.mCurrentViewHeight;
        this.setLayoutParams((ViewGroup.LayoutParams)baseMonthView);
        if (this.mParentLayout != null) {
            n = CalendarUtil.getWeekFromDayInMonth((Calendar)this.mDelegate.mSelectedCalendar, (int)this.mDelegate.getWeekStart());
            this.mParentLayout.updateSelectWeek(n);
        }
        this.updateSelected();
    }
}
