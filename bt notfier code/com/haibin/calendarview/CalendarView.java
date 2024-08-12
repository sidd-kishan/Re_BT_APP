/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.animation.Animator$AnimatorListener
 *  android.animation.TimeInterpolator
 *  android.content.Context
 *  android.os.Bundle
 *  android.os.Parcelable
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.View$MeasureSpec
 *  android.view.ViewGroup
 *  android.view.ViewGroup$LayoutParams
 *  android.view.animation.LinearInterpolator
 *  android.widget.FrameLayout
 *  android.widget.FrameLayout$LayoutParams
 *  androidx.viewpager.widget.ViewPager$OnPageChangeListener
 *  com.haibin.calendarview.Calendar
 *  com.haibin.calendarview.CalendarLayout
 *  com.haibin.calendarview.CalendarUtil
 *  com.haibin.calendarview.CalendarView$OnCalendarInterceptListener
 *  com.haibin.calendarview.CalendarView$OnCalendarLongClickListener
 *  com.haibin.calendarview.CalendarView$OnCalendarMultiSelectListener
 *  com.haibin.calendarview.CalendarView$OnCalendarRangeSelectListener
 *  com.haibin.calendarview.CalendarView$OnCalendarSelectListener
 *  com.haibin.calendarview.CalendarView$OnMonthChangeListener
 *  com.haibin.calendarview.CalendarView$OnViewChangeListener
 *  com.haibin.calendarview.CalendarView$OnWeekChangeListener
 *  com.haibin.calendarview.CalendarView$OnYearChangeListener
 *  com.haibin.calendarview.CalendarView$OnYearViewChangeListener
 *  com.haibin.calendarview.CalendarViewDelegate
 *  com.haibin.calendarview.MonthViewPager
 *  com.haibin.calendarview.R$id
 *  com.haibin.calendarview.R$layout
 *  com.haibin.calendarview.WeekBar
 *  com.haibin.calendarview.WeekViewPager
 *  com.haibin.calendarview.YearRecyclerView$OnMonthSelectedListener
 *  com.haibin.calendarview.YearViewPager
 */
package com.haibin.calendarview;

import android.animation.Animator;
import android.animation.TimeInterpolator;
import android.content.Context;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.LinearInterpolator;
import android.widget.FrameLayout;
import androidx.viewpager.widget.ViewPager;
import com.haibin.calendarview.Calendar;
import com.haibin.calendarview.CalendarLayout;
import com.haibin.calendarview.CalendarUtil;
import com.haibin.calendarview.CalendarView;
import com.haibin.calendarview.CalendarViewDelegate;
import com.haibin.calendarview.MonthViewPager;
import com.haibin.calendarview.R;
import com.haibin.calendarview.WeekBar;
import com.haibin.calendarview.WeekViewPager;
import com.haibin.calendarview.YearRecyclerView;
import com.haibin.calendarview.YearViewPager;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CalendarView
extends FrameLayout {
    private final CalendarViewDelegate mDelegate;
    private MonthViewPager mMonthPager;
    CalendarLayout mParentLayout;
    private WeekBar mWeekBar;
    private View mWeekLine;
    private WeekViewPager mWeekPager;
    private YearViewPager mYearViewPager;

    public CalendarView(Context context) {
        this(context, null);
    }

    public CalendarView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mDelegate = new CalendarViewDelegate(context, attributeSet);
        this.init(context);
    }

    static /* synthetic */ WeekViewPager access$000(CalendarView calendarView) {
        return calendarView.mWeekPager;
    }

    static /* synthetic */ CalendarViewDelegate access$100(CalendarView calendarView) {
        return calendarView.mDelegate;
    }

    static /* synthetic */ MonthViewPager access$200(CalendarView calendarView) {
        return calendarView.mMonthPager;
    }

    static /* synthetic */ WeekBar access$300(CalendarView calendarView) {
        return calendarView.mWeekBar;
    }

    static /* synthetic */ void access$400(CalendarView calendarView, int n) {
        calendarView.closeSelectLayout(n);
    }

    static /* synthetic */ YearViewPager access$500(CalendarView calendarView) {
        return calendarView.mYearViewPager;
    }

    private void closeSelectLayout(int n) {
        this.mYearViewPager.setVisibility(8);
        this.mWeekBar.setVisibility(0);
        if (n == this.mMonthPager.getCurrentItem()) {
            if (this.mDelegate.mCalendarSelectListener != null && this.mDelegate.getSelectMode() != 1) {
                this.mDelegate.mCalendarSelectListener.onCalendarSelect(this.mDelegate.mSelectedCalendar, false);
            }
        } else {
            this.mMonthPager.setCurrentItem(n, false);
        }
        this.mWeekBar.animate().translationY(0.0f).setInterpolator((TimeInterpolator)new LinearInterpolator()).setDuration(280L).setListener((Animator.AnimatorListener)new /* Unavailable Anonymous Inner Class!! */);
        this.mMonthPager.animate().scaleX(1.0f).scaleY(1.0f).setDuration(180L).setInterpolator((TimeInterpolator)new LinearInterpolator()).setListener((Animator.AnimatorListener)new /* Unavailable Anonymous Inner Class!! */);
    }

    private void init(Context context) {
        WeekViewPager weekViewPager;
        LayoutInflater.from((Context)context).inflate(R.layout.cv_layout_calendar_view, (ViewGroup)this, true);
        FrameLayout frameLayout = (FrameLayout)this.findViewById(R.id.frameContent);
        this.mWeekPager = weekViewPager = (WeekViewPager)this.findViewById(R.id.vp_week);
        weekViewPager.setup(this.mDelegate);
        try {
            this.mWeekBar = (WeekBar)this.mDelegate.getWeekBarClass().getConstructor(Context.class).newInstance(this.getContext());
        }
        catch (Exception exception) {
            exception.printStackTrace();
        }
        frameLayout.addView((View)this.mWeekBar, 2);
        this.mWeekBar.setup(this.mDelegate);
        this.mWeekBar.onWeekStartChange(this.mDelegate.getWeekStart());
        frameLayout = this.findViewById(R.id.line);
        this.mWeekLine = frameLayout;
        frameLayout.setBackgroundColor(this.mDelegate.getWeekLineBackground());
        frameLayout = (FrameLayout.LayoutParams)this.mWeekLine.getLayoutParams();
        frameLayout.setMargins(this.mDelegate.getWeekLineMargin(), this.mDelegate.getWeekBarHeight(), this.mDelegate.getWeekLineMargin(), 0);
        this.mWeekLine.setLayoutParams((ViewGroup.LayoutParams)frameLayout);
        frameLayout = (MonthViewPager)this.findViewById(R.id.vp_month);
        this.mMonthPager = frameLayout;
        frameLayout.mWeekPager = this.mWeekPager;
        this.mMonthPager.mWeekBar = this.mWeekBar;
        frameLayout = (FrameLayout.LayoutParams)this.mMonthPager.getLayoutParams();
        frameLayout.setMargins(0, this.mDelegate.getWeekBarHeight() + CalendarUtil.dipToPx((Context)context, (float)1.0f), 0, 0);
        this.mWeekPager.setLayoutParams((ViewGroup.LayoutParams)frameLayout);
        context = (YearViewPager)this.findViewById(R.id.selectLayout);
        this.mYearViewPager = context;
        context.setBackgroundColor(this.mDelegate.getYearViewBackground());
        this.mYearViewPager.addOnPageChangeListener((ViewPager.OnPageChangeListener)new /* Unavailable Anonymous Inner Class!! */);
        this.mDelegate.mInnerListener = new /* Unavailable Anonymous Inner Class!! */;
        if (this.mDelegate.getSelectMode() == 0) {
            if (this.isInRange(this.mDelegate.getCurrentDay())) {
                context = this.mDelegate;
                context.mSelectedCalendar = context.createCurrentDate();
            } else {
                context = this.mDelegate;
                context.mSelectedCalendar = context.getMinRangeCalendar();
            }
        } else {
            this.mDelegate.mSelectedCalendar = new Calendar();
        }
        context = this.mDelegate;
        context.mIndexCalendar = context.mSelectedCalendar;
        this.mWeekBar.onDateSelected(this.mDelegate.mSelectedCalendar, this.mDelegate.getWeekStart(), false);
        this.mMonthPager.setup(this.mDelegate);
        this.mMonthPager.setCurrentItem(this.mDelegate.mCurrentMonthViewItem);
        this.mYearViewPager.setOnMonthSelectedListener((YearRecyclerView.OnMonthSelectedListener)new /* Unavailable Anonymous Inner Class!! */);
        this.mYearViewPager.setup(this.mDelegate);
        this.mWeekPager.updateSelected(this.mDelegate.createCurrentDate(), false);
    }

    private void setShowMode(int n) {
        if (n != 0 && n != 1 && n != 2) {
            return;
        }
        if (this.mDelegate.getMonthViewShowMode() == n) {
            return;
        }
        this.mDelegate.setMonthViewShowMode(n);
        this.mWeekPager.updateShowMode();
        this.mMonthPager.updateShowMode();
        this.mWeekPager.notifyDataSetChanged();
    }

    private void setWeekStart(int n) {
        if (n != 1 && n != 2 && n != 7) {
            return;
        }
        if (n == this.mDelegate.getWeekStart()) {
            return;
        }
        this.mDelegate.setWeekStart(n);
        this.mWeekBar.onWeekStartChange(n);
        this.mWeekBar.onDateSelected(this.mDelegate.mSelectedCalendar, n, false);
        this.mWeekPager.updateWeekStart();
        this.mMonthPager.updateWeekStart();
        this.mYearViewPager.updateWeekStart();
    }

    private void showSelectLayout(int n) {
        CalendarLayout calendarLayout = this.mParentLayout;
        if (calendarLayout != null && calendarLayout.mContentView != null && !this.mParentLayout.isExpand()) {
            this.mParentLayout.expand();
        }
        this.mWeekPager.setVisibility(8);
        this.mDelegate.isShowYearSelectedLayout = true;
        calendarLayout = this.mParentLayout;
        if (calendarLayout != null) {
            calendarLayout.hideContentView();
        }
        this.mWeekBar.animate().translationY((float)(-this.mWeekBar.getHeight())).setInterpolator((TimeInterpolator)new LinearInterpolator()).setDuration(260L).setListener((Animator.AnimatorListener)new /* Unavailable Anonymous Inner Class!! */);
        this.mMonthPager.animate().scaleX(0.0f).scaleY(0.0f).setDuration(260L).setInterpolator((TimeInterpolator)new LinearInterpolator()).setListener((Animator.AnimatorListener)new /* Unavailable Anonymous Inner Class!! */);
    }

    public final void addSchemeDate(Calendar calendar) {
        if (calendar == null) return;
        if (!calendar.isAvailable()) return;
        if (this.mDelegate.mSchemeDatesMap == null) {
            this.mDelegate.mSchemeDatesMap = new HashMap();
        }
        if (this.mDelegate.mSchemeDatesMap.containsKey(calendar.toString())) {
            this.mDelegate.mSchemeDatesMap.remove(calendar.toString());
        }
        this.mDelegate.mSchemeDatesMap.put(calendar.toString(), calendar);
        this.mDelegate.updateSelectCalendarScheme();
        this.mYearViewPager.update();
        this.mMonthPager.updateScheme();
        this.mWeekPager.updateScheme();
    }

    public final void addSchemeDate(Map<String, Calendar> map) {
        if (this.mDelegate == null) return;
        if (map == null) return;
        if (map.size() == 0) return;
        if (this.mDelegate.mSchemeDatesMap == null) {
            this.mDelegate.mSchemeDatesMap = new HashMap();
        }
        this.mDelegate.addSchemes(map);
        this.mDelegate.updateSelectCalendarScheme();
        this.mYearViewPager.update();
        this.mMonthPager.updateScheme();
        this.mWeekPager.updateScheme();
    }

    public final void clearMultiSelect() {
        this.mDelegate.mSelectedCalendars.clear();
        this.mMonthPager.clearMultiSelect();
        this.mWeekPager.clearMultiSelect();
    }

    public final void clearSchemeDate() {
        this.mDelegate.mSchemeDatesMap = null;
        this.mDelegate.clearSelectedScheme();
        this.mYearViewPager.update();
        this.mMonthPager.updateScheme();
        this.mWeekPager.updateScheme();
    }

    public final void clearSelectRange() {
        this.mDelegate.clearSelectRange();
        this.mMonthPager.clearSelectRange();
        this.mWeekPager.clearSelectRange();
    }

    public final void clearSingleSelect() {
        this.mDelegate.mSelectedCalendar = new Calendar();
        this.mMonthPager.clearSingleSelect();
        this.mWeekPager.clearSingleSelect();
    }

    public void closeYearSelectLayout() {
        if (this.mYearViewPager.getVisibility() == 8) {
            return;
        }
        this.closeSelectLayout((this.mDelegate.mSelectedCalendar.getYear() - this.mDelegate.getMinYear()) * 12 + this.mDelegate.mSelectedCalendar.getMonth() - this.mDelegate.getMinYearMonth());
        this.mDelegate.isShowYearSelectedLayout = false;
    }

    public int getCurDay() {
        return this.mDelegate.getCurrentDay().getDay();
    }

    public int getCurMonth() {
        return this.mDelegate.getCurrentDay().getMonth();
    }

    public int getCurYear() {
        return this.mDelegate.getCurrentDay().getYear();
    }

    public List<Calendar> getCurrentMonthCalendars() {
        return this.mMonthPager.getCurrentMonthCalendars();
    }

    public List<Calendar> getCurrentWeekCalendars() {
        return this.mWeekPager.getCurrentWeekCalendars();
    }

    public final int getMaxMultiSelectSize() {
        return this.mDelegate.getMaxMultiSelectSize();
    }

    public Calendar getMaxRangeCalendar() {
        return this.mDelegate.getMaxRangeCalendar();
    }

    public final int getMaxSelectRange() {
        return this.mDelegate.getMaxSelectRange();
    }

    public Calendar getMinRangeCalendar() {
        return this.mDelegate.getMinRangeCalendar();
    }

    public final int getMinSelectRange() {
        return this.mDelegate.getMinSelectRange();
    }

    public MonthViewPager getMonthViewPager() {
        return this.mMonthPager;
    }

    public final List<Calendar> getMultiSelectCalendars() {
        ArrayList<Calendar> arrayList = new ArrayList<Calendar>();
        if (this.mDelegate.mSelectedCalendars.size() == 0) {
            return arrayList;
        }
        arrayList.addAll(this.mDelegate.mSelectedCalendars.values());
        Collections.sort(arrayList);
        return arrayList;
    }

    public final List<Calendar> getSelectCalendarRange() {
        return this.mDelegate.getSelectCalendarRange();
    }

    public Calendar getSelectedCalendar() {
        return this.mDelegate.mSelectedCalendar;
    }

    public WeekViewPager getWeekViewPager() {
        return this.mWeekPager;
    }

    protected final boolean isInRange(Calendar calendar) {
        CalendarViewDelegate calendarViewDelegate = this.mDelegate;
        boolean bl = calendarViewDelegate != null && CalendarUtil.isCalendarInRange((Calendar)calendar, (CalendarViewDelegate)calendarViewDelegate);
        return bl;
    }

    public boolean isSingleSelectMode() {
        int n = this.mDelegate.getSelectMode();
        boolean bl = true;
        if (n == 1) return bl;
        bl = false;
        return bl;
    }

    public boolean isYearSelectLayoutVisible() {
        boolean bl = this.mYearViewPager.getVisibility() == 0;
        return bl;
    }

    protected void onAttachedToWindow() {
        CalendarLayout calendarLayout;
        super.onAttachedToWindow();
        if (this.getParent() == null) return;
        if (!(this.getParent() instanceof CalendarLayout)) return;
        this.mParentLayout = calendarLayout = (CalendarLayout)this.getParent();
        this.mMonthPager.mParentLayout = calendarLayout;
        this.mWeekPager.mParentLayout = this.mParentLayout;
        this.mParentLayout.mWeekBar = this.mWeekBar;
        this.mParentLayout.setup(this.mDelegate);
        this.mParentLayout.initStatus();
    }

    protected final boolean onCalendarIntercept(Calendar calendar) {
        boolean bl = this.mDelegate.mCalendarInterceptListener != null && this.mDelegate.mCalendarInterceptListener.onCalendarIntercept(calendar);
        return bl;
    }

    protected void onMeasure(int n, int n2) {
        int n3 = View.MeasureSpec.getSize((int)n2);
        CalendarViewDelegate calendarViewDelegate = this.mDelegate;
        if (calendarViewDelegate != null && calendarViewDelegate.isFullScreenCalendar()) {
            this.setCalendarItemHeight((n3 - this.mDelegate.getWeekBarHeight()) / 6);
            super.onMeasure(n, n2);
            return;
        }
        super.onMeasure(n, n2);
    }

    protected void onRestoreInstanceState(Parcelable parcelable) {
        parcelable = (Bundle)parcelable;
        Parcelable parcelable2 = parcelable.getParcelable("super");
        this.mDelegate.mSelectedCalendar = (Calendar)parcelable.getSerializable("selected_calendar");
        this.mDelegate.mIndexCalendar = (Calendar)parcelable.getSerializable("index_calendar");
        if (this.mDelegate.mCalendarSelectListener != null) {
            this.mDelegate.mCalendarSelectListener.onCalendarSelect(this.mDelegate.mSelectedCalendar, false);
        }
        if (this.mDelegate.mIndexCalendar != null) {
            this.scrollToCalendar(this.mDelegate.mIndexCalendar.getYear(), this.mDelegate.mIndexCalendar.getMonth(), this.mDelegate.mIndexCalendar.getDay());
        }
        this.update();
        super.onRestoreInstanceState(parcelable2);
    }

    protected Parcelable onSaveInstanceState() {
        if (this.mDelegate == null) {
            return super.onSaveInstanceState();
        }
        Bundle bundle = new Bundle();
        bundle.putParcelable("super", super.onSaveInstanceState());
        bundle.putSerializable("selected_calendar", (Serializable)this.mDelegate.mSelectedCalendar);
        bundle.putSerializable("index_calendar", (Serializable)this.mDelegate.mIndexCalendar);
        return bundle;
    }

    public final void putMultiSelect(Calendar ... calendarArray) {
        if (calendarArray == null) return;
        if (calendarArray.length == 0) return;
        for (Calendar calendar : calendarArray) {
            if (calendar == null || this.mDelegate.mSelectedCalendars.containsKey(calendar.toString())) continue;
            this.mDelegate.mSelectedCalendars.put(calendar.toString(), calendar);
        }
        this.update();
    }

    public final void removeMultiSelect(Calendar ... calendarArray) {
        if (calendarArray == null) return;
        if (calendarArray.length == 0) return;
        for (Calendar calendar : calendarArray) {
            if (calendar == null || !this.mDelegate.mSelectedCalendars.containsKey(calendar.toString())) continue;
            this.mDelegate.mSelectedCalendars.remove(calendar.toString());
        }
        this.update();
    }

    public final void removeSchemeDate(Calendar calendar) {
        if (calendar == null) {
            return;
        }
        if (this.mDelegate.mSchemeDatesMap == null) return;
        if (this.mDelegate.mSchemeDatesMap.size() == 0) return;
        if (this.mDelegate.mSchemeDatesMap.containsKey(calendar.toString())) {
            this.mDelegate.mSchemeDatesMap.remove(calendar.toString());
        }
        if (this.mDelegate.mSelectedCalendar.equals((Object)calendar)) {
            this.mDelegate.clearSelectedScheme();
        }
        this.mYearViewPager.update();
        this.mMonthPager.updateScheme();
        this.mWeekPager.updateScheme();
    }

    public void scrollToCalendar(int n, int n2, int n3) {
        this.scrollToCalendar(n, n2, n3, false);
    }

    public void scrollToCalendar(int n, int n2, int n3, boolean bl) {
        Calendar calendar = new Calendar();
        calendar.setYear(n);
        calendar.setMonth(n2);
        calendar.setDay(n3);
        if (!calendar.isAvailable()) {
            return;
        }
        if (!this.isInRange(calendar)) {
            return;
        }
        if (this.mDelegate.mCalendarInterceptListener != null && this.mDelegate.mCalendarInterceptListener.onCalendarIntercept(calendar)) {
            this.mDelegate.mCalendarInterceptListener.onCalendarInterceptClick(calendar, false);
            return;
        }
        if (this.mWeekPager.getVisibility() == 0) {
            this.mWeekPager.scrollToCalendar(n, n2, n3, bl);
        } else {
            this.mMonthPager.scrollToCalendar(n, n2, n3, bl);
        }
    }

    public void scrollToCurrent() {
        this.scrollToCurrent(false);
    }

    public void scrollToCurrent(boolean bl) {
        if (!this.isInRange(this.mDelegate.getCurrentDay())) {
            return;
        }
        Calendar calendar = this.mDelegate.createCurrentDate();
        if (this.mDelegate.mCalendarInterceptListener != null && this.mDelegate.mCalendarInterceptListener.onCalendarIntercept(calendar)) {
            this.mDelegate.mCalendarInterceptListener.onCalendarInterceptClick(calendar, false);
            return;
        }
        calendar = this.mDelegate;
        calendar.mSelectedCalendar = calendar.createCurrentDate();
        calendar = this.mDelegate;
        calendar.mIndexCalendar = calendar.mSelectedCalendar;
        this.mDelegate.updateSelectCalendarScheme();
        this.mWeekBar.onDateSelected(this.mDelegate.mSelectedCalendar, this.mDelegate.getWeekStart(), false);
        if (this.mMonthPager.getVisibility() == 0) {
            this.mMonthPager.scrollToCurrent(bl);
            this.mWeekPager.updateSelected(this.mDelegate.mIndexCalendar, false);
        } else {
            this.mWeekPager.scrollToCurrent(bl);
        }
        this.mYearViewPager.scrollToYear(this.mDelegate.getCurrentDay().getYear(), bl);
    }

    public void scrollToNext() {
        this.scrollToNext(false);
    }

    public void scrollToNext(boolean bl) {
        if (this.isYearSelectLayoutVisible()) {
            YearViewPager yearViewPager = this.mYearViewPager;
            yearViewPager.setCurrentItem(yearViewPager.getCurrentItem() + 1, bl);
        } else if (this.mWeekPager.getVisibility() == 0) {
            WeekViewPager weekViewPager = this.mWeekPager;
            weekViewPager.setCurrentItem(weekViewPager.getCurrentItem() + 1, bl);
        } else {
            MonthViewPager monthViewPager = this.mMonthPager;
            monthViewPager.setCurrentItem(monthViewPager.getCurrentItem() + 1, bl);
        }
    }

    public void scrollToPre() {
        this.scrollToPre(false);
    }

    public void scrollToPre(boolean bl) {
        if (this.isYearSelectLayoutVisible()) {
            YearViewPager yearViewPager = this.mYearViewPager;
            yearViewPager.setCurrentItem(yearViewPager.getCurrentItem() - 1, bl);
        } else if (this.mWeekPager.getVisibility() == 0) {
            WeekViewPager weekViewPager = this.mWeekPager;
            weekViewPager.setCurrentItem(weekViewPager.getCurrentItem() - 1, bl);
        } else {
            MonthViewPager monthViewPager = this.mMonthPager;
            monthViewPager.setCurrentItem(monthViewPager.getCurrentItem() - 1, bl);
        }
    }

    public void scrollToSelectCalendar() {
        if (!this.mDelegate.mSelectedCalendar.isAvailable()) {
            return;
        }
        this.scrollToCalendar(this.mDelegate.mSelectedCalendar.getYear(), this.mDelegate.mSelectedCalendar.getMonth(), this.mDelegate.mSelectedCalendar.getDay(), false);
    }

    public void scrollToYear(int n) {
        this.scrollToYear(n, false);
    }

    public void scrollToYear(int n, boolean bl) {
        if (this.mYearViewPager.getVisibility() != 0) {
            return;
        }
        this.mYearViewPager.scrollToYear(n, bl);
    }

    public void setAllMode() {
        this.setShowMode(0);
    }

    public void setBackground(int n, int n2, int n3) {
        this.mWeekBar.setBackgroundColor(n2);
        this.mYearViewPager.setBackgroundColor(n);
        this.mWeekLine.setBackgroundColor(n3);
    }

    public final void setCalendarItemHeight(int n) {
        if (this.mDelegate.getCalendarItemHeight() == n) {
            return;
        }
        this.mDelegate.setCalendarItemHeight(n);
        this.mMonthPager.updateItemHeight();
        this.mWeekPager.updateItemHeight();
        CalendarLayout calendarLayout = this.mParentLayout;
        if (calendarLayout == null) {
            return;
        }
        calendarLayout.updateCalendarItemHeight();
    }

    public final void setDefaultMonthViewSelectDay() {
        this.mDelegate.setDefaultCalendarSelectDay(0);
    }

    public void setFixMode() {
        this.setShowMode(2);
    }

    public final void setLastMonthViewSelectDay() {
        this.mDelegate.setDefaultCalendarSelectDay(1);
    }

    public final void setLastMonthViewSelectDayIgnoreCurrent() {
        this.mDelegate.setDefaultCalendarSelectDay(2);
    }

    public final void setMaxMultiSelectSize(int n) {
        this.mDelegate.setMaxMultiSelectSize(n);
    }

    public final void setMonthView(Class<?> clazz) {
        if (clazz == null) {
            return;
        }
        if (this.mDelegate.getMonthViewClass().equals(clazz)) {
            return;
        }
        this.mDelegate.setMonthViewClass(clazz);
        this.mMonthPager.updateMonthViewClass();
    }

    public final void setMonthViewScrollable(boolean bl) {
        this.mDelegate.setMonthViewScrollable(bl);
    }

    public final void setOnCalendarInterceptListener(OnCalendarInterceptListener onCalendarInterceptListener) {
        if (onCalendarInterceptListener == null) {
            this.mDelegate.mCalendarInterceptListener = null;
        }
        if (onCalendarInterceptListener == null) return;
        if (this.mDelegate.getSelectMode() == 0) return;
        this.mDelegate.mCalendarInterceptListener = onCalendarInterceptListener;
        if (!onCalendarInterceptListener.onCalendarIntercept(this.mDelegate.mSelectedCalendar)) {
            return;
        }
        this.mDelegate.mSelectedCalendar = new Calendar();
    }

    public void setOnCalendarLongClickListener(OnCalendarLongClickListener onCalendarLongClickListener) {
        this.mDelegate.mCalendarLongClickListener = onCalendarLongClickListener;
    }

    public void setOnCalendarLongClickListener(OnCalendarLongClickListener onCalendarLongClickListener, boolean bl) {
        this.mDelegate.mCalendarLongClickListener = onCalendarLongClickListener;
        this.mDelegate.setPreventLongPressedSelected(bl);
    }

    public final void setOnCalendarMultiSelectListener(OnCalendarMultiSelectListener onCalendarMultiSelectListener) {
        this.mDelegate.mCalendarMultiSelectListener = onCalendarMultiSelectListener;
    }

    public final void setOnCalendarRangeSelectListener(OnCalendarRangeSelectListener onCalendarRangeSelectListener) {
        this.mDelegate.mCalendarRangeSelectListener = onCalendarRangeSelectListener;
    }

    public void setOnCalendarSelectListener(OnCalendarSelectListener onCalendarSelectListener) {
        this.mDelegate.mCalendarSelectListener = onCalendarSelectListener;
        if (this.mDelegate.mCalendarSelectListener == null) {
            return;
        }
        if (this.mDelegate.getSelectMode() != 0) {
            return;
        }
        if (!this.isInRange(this.mDelegate.mSelectedCalendar)) {
            return;
        }
        this.mDelegate.updateSelectCalendarScheme();
    }

    public void setOnMonthChangeListener(OnMonthChangeListener onMonthChangeListener) {
        this.mDelegate.mMonthChangeListener = onMonthChangeListener;
    }

    public void setOnViewChangeListener(OnViewChangeListener onViewChangeListener) {
        this.mDelegate.mViewChangeListener = onViewChangeListener;
    }

    public void setOnWeekChangeListener(OnWeekChangeListener onWeekChangeListener) {
        this.mDelegate.mWeekChangeListener = onWeekChangeListener;
    }

    public void setOnYearChangeListener(OnYearChangeListener onYearChangeListener) {
        this.mDelegate.mYearChangeListener = onYearChangeListener;
    }

    public void setOnYearViewChangeListener(OnYearViewChangeListener onYearViewChangeListener) {
        this.mDelegate.mYearViewChangeListener = onYearViewChangeListener;
    }

    public void setOnlyCurrentMode() {
        this.setShowMode(1);
    }

    public void setRange(int n, int n2, int n3, int n4, int n5, int n6) {
        if (CalendarUtil.compareTo((int)n, (int)n2, (int)n3, (int)n4, (int)n5, (int)n6) > 0) {
            return;
        }
        this.mDelegate.setRange(n, n2, n3, n4, n5, n6);
        this.mWeekPager.notifyDataSetChanged();
        this.mYearViewPager.notifyDataSetChanged();
        this.mMonthPager.notifyDataSetChanged();
        if (!this.isInRange(this.mDelegate.mSelectedCalendar)) {
            CalendarViewDelegate calendarViewDelegate = this.mDelegate;
            calendarViewDelegate.mSelectedCalendar = calendarViewDelegate.getMinRangeCalendar();
            this.mDelegate.updateSelectCalendarScheme();
            calendarViewDelegate = this.mDelegate;
            calendarViewDelegate.mIndexCalendar = calendarViewDelegate.mSelectedCalendar;
        }
        this.mWeekPager.updateRange();
        this.mMonthPager.updateRange();
        this.mYearViewPager.updateRange();
    }

    public void setSchemeColor(int n, int n2, int n3) {
        CalendarViewDelegate calendarViewDelegate = this.mDelegate;
        if (calendarViewDelegate == null) return;
        if (this.mMonthPager == null) return;
        if (this.mWeekPager == null) return;
        calendarViewDelegate.setSchemeColor(n, n2, n3);
        this.mMonthPager.updateStyle();
        this.mWeekPager.updateStyle();
    }

    public final void setSchemeDate(Map<String, Calendar> map) {
        this.mDelegate.mSchemeDatesMap = map;
        this.mDelegate.updateSelectCalendarScheme();
        this.mYearViewPager.update();
        this.mMonthPager.updateScheme();
        this.mWeekPager.updateScheme();
    }

    public final void setSelectCalendarRange(int n, int n2, int n3, int n4, int n5, int n6) {
        if (this.mDelegate.getSelectMode() != 2) {
            return;
        }
        Calendar calendar = new Calendar();
        calendar.setYear(n);
        calendar.setMonth(n2);
        calendar.setDay(n3);
        Calendar calendar2 = new Calendar();
        calendar2.setYear(n4);
        calendar2.setMonth(n5);
        calendar2.setDay(n6);
        this.setSelectCalendarRange(calendar, calendar2);
    }

    public final void setSelectCalendarRange(Calendar calendar, Calendar calendar2) {
        if (this.mDelegate.getSelectMode() != 2) {
            return;
        }
        if (calendar == null) return;
        if (calendar2 == null) return;
        if (this.onCalendarIntercept(calendar)) {
            if (this.mDelegate.mCalendarInterceptListener == null) return;
            this.mDelegate.mCalendarInterceptListener.onCalendarInterceptClick(calendar, false);
            return;
        }
        if (this.onCalendarIntercept(calendar2)) {
            if (this.mDelegate.mCalendarInterceptListener == null) return;
            this.mDelegate.mCalendarInterceptListener.onCalendarInterceptClick(calendar2, false);
            return;
        }
        int n = calendar2.differ(calendar);
        if (n < 0) {
            return;
        }
        if (!this.isInRange(calendar)) return;
        if (!this.isInRange(calendar2)) return;
        if (this.mDelegate.getMinSelectRange() != -1 && this.mDelegate.getMinSelectRange() > n + 1) {
            if (this.mDelegate.mCalendarRangeSelectListener == null) return;
            this.mDelegate.mCalendarRangeSelectListener.onSelectOutOfRange(calendar2, true);
            return;
        }
        if (this.mDelegate.getMaxSelectRange() != -1 && this.mDelegate.getMaxSelectRange() < n + 1) {
            if (this.mDelegate.mCalendarRangeSelectListener == null) return;
            this.mDelegate.mCalendarRangeSelectListener.onSelectOutOfRange(calendar2, false);
            return;
        }
        if (this.mDelegate.getMinSelectRange() == -1 && n == 0) {
            this.mDelegate.mSelectedStartRangeCalendar = calendar;
            this.mDelegate.mSelectedEndRangeCalendar = null;
            if (this.mDelegate.mCalendarRangeSelectListener != null) {
                this.mDelegate.mCalendarRangeSelectListener.onCalendarRangeSelect(calendar, false);
            }
            this.scrollToCalendar(calendar.getYear(), calendar.getMonth(), calendar.getDay());
            return;
        }
        this.mDelegate.mSelectedStartRangeCalendar = calendar;
        this.mDelegate.mSelectedEndRangeCalendar = calendar2;
        if (this.mDelegate.mCalendarRangeSelectListener != null) {
            this.mDelegate.mCalendarRangeSelectListener.onCalendarRangeSelect(calendar, false);
            this.mDelegate.mCalendarRangeSelectListener.onCalendarRangeSelect(calendar2, true);
        }
        this.scrollToCalendar(calendar.getYear(), calendar.getMonth(), calendar.getDay());
    }

    public final void setSelectDefaultMode() {
        if (this.mDelegate.getSelectMode() == 0) {
            return;
        }
        CalendarViewDelegate calendarViewDelegate = this.mDelegate;
        calendarViewDelegate.mSelectedCalendar = calendarViewDelegate.mIndexCalendar;
        this.mDelegate.setSelectMode(0);
        this.mWeekBar.onDateSelected(this.mDelegate.mSelectedCalendar, this.mDelegate.getWeekStart(), false);
        this.mMonthPager.updateDefaultSelect();
        this.mWeekPager.updateDefaultSelect();
    }

    public final void setSelectEndCalendar(int n, int n2, int n3) {
        if (this.mDelegate.getSelectMode() != 2) {
            return;
        }
        if (this.mDelegate.mSelectedStartRangeCalendar == null) {
            return;
        }
        Calendar calendar = new Calendar();
        calendar.setYear(n);
        calendar.setMonth(n2);
        calendar.setDay(n3);
        this.setSelectEndCalendar(calendar);
    }

    public final void setSelectEndCalendar(Calendar calendar) {
        if (this.mDelegate.getSelectMode() != 2) {
            return;
        }
        if (this.mDelegate.mSelectedStartRangeCalendar == null) {
            return;
        }
        this.setSelectCalendarRange(this.mDelegate.mSelectedStartRangeCalendar, calendar);
    }

    public void setSelectMultiMode() {
        if (this.mDelegate.getSelectMode() == 3) {
            return;
        }
        this.mDelegate.setSelectMode(3);
        this.clearMultiSelect();
    }

    public final void setSelectRange(int n, int n2) {
        if (n > n2) {
            return;
        }
        this.mDelegate.setSelectRange(n, n2);
    }

    public void setSelectRangeMode() {
        if (this.mDelegate.getSelectMode() == 2) {
            return;
        }
        this.mDelegate.setSelectMode(2);
        this.clearSelectRange();
    }

    public void setSelectSingleMode() {
        if (this.mDelegate.getSelectMode() == 1) {
            return;
        }
        this.mDelegate.setSelectMode(1);
        this.mWeekPager.updateSelected();
        this.mMonthPager.updateSelected();
    }

    public final void setSelectStartCalendar(int n, int n2, int n3) {
        if (this.mDelegate.getSelectMode() != 2) {
            return;
        }
        Calendar calendar = new Calendar();
        calendar.setYear(n);
        calendar.setMonth(n2);
        calendar.setDay(n3);
        this.setSelectStartCalendar(calendar);
    }

    public final void setSelectStartCalendar(Calendar calendar) {
        if (this.mDelegate.getSelectMode() != 2) {
            return;
        }
        if (calendar == null) {
            return;
        }
        if (!this.isInRange(calendar)) {
            if (this.mDelegate.mCalendarRangeSelectListener == null) return;
            this.mDelegate.mCalendarRangeSelectListener.onSelectOutOfRange(calendar, true);
            return;
        }
        if (this.onCalendarIntercept(calendar)) {
            if (this.mDelegate.mCalendarInterceptListener == null) return;
            this.mDelegate.mCalendarInterceptListener.onCalendarInterceptClick(calendar, false);
            return;
        }
        this.mDelegate.mSelectedEndRangeCalendar = null;
        this.mDelegate.mSelectedStartRangeCalendar = calendar;
        this.scrollToCalendar(calendar.getYear(), calendar.getMonth(), calendar.getDay());
    }

    public void setSelectedColor(int n, int n2, int n3) {
        CalendarViewDelegate calendarViewDelegate = this.mDelegate;
        if (calendarViewDelegate == null) return;
        if (this.mMonthPager == null) return;
        if (this.mWeekPager == null) return;
        calendarViewDelegate.setSelectColor(n, n2, n3);
        this.mMonthPager.updateStyle();
        this.mWeekPager.updateStyle();
    }

    public void setTextColor(int n, int n2, int n3, int n4, int n5) {
        CalendarViewDelegate calendarViewDelegate = this.mDelegate;
        if (calendarViewDelegate == null) return;
        if (this.mMonthPager == null) return;
        if (this.mWeekPager == null) return;
        calendarViewDelegate.setTextColor(n, n2, n3, n4, n5);
        this.mMonthPager.updateStyle();
        this.mWeekPager.updateStyle();
    }

    public void setThemeColor(int n, int n2) {
        CalendarViewDelegate calendarViewDelegate = this.mDelegate;
        if (calendarViewDelegate == null) return;
        if (this.mMonthPager == null) return;
        if (this.mWeekPager == null) return;
        calendarViewDelegate.setThemeColor(n, n2);
        this.mMonthPager.updateStyle();
        this.mWeekPager.updateStyle();
    }

    public void setWeeColor(int n, int n2) {
        WeekBar weekBar = this.mWeekBar;
        if (weekBar == null) {
            return;
        }
        weekBar.setBackgroundColor(n);
        this.mWeekBar.setTextColor(n2);
    }

    public final void setWeekBar(Class<?> clazz) {
        if (clazz == null) {
            return;
        }
        if (this.mDelegate.getWeekBarClass().equals(clazz)) {
            return;
        }
        this.mDelegate.setWeekBarClass(clazz);
        FrameLayout frameLayout = (FrameLayout)this.findViewById(R.id.frameContent);
        frameLayout.removeView((View)this.mWeekBar);
        try {
            this.mWeekBar = (WeekBar)clazz.getConstructor(Context.class).newInstance(this.getContext());
        }
        catch (Exception exception) {
            exception.printStackTrace();
        }
        frameLayout.addView((View)this.mWeekBar, 2);
        this.mWeekBar.setup(this.mDelegate);
        this.mWeekBar.onWeekStartChange(this.mDelegate.getWeekStart());
        this.mMonthPager.mWeekBar = this.mWeekBar;
        this.mWeekBar.onDateSelected(this.mDelegate.mSelectedCalendar, this.mDelegate.getWeekStart(), false);
    }

    public void setWeekStarWithMon() {
        this.setWeekStart(2);
    }

    public void setWeekStarWithSat() {
        this.setWeekStart(7);
    }

    public void setWeekStarWithSun() {
        this.setWeekStart(1);
    }

    public final void setWeekView(Class<?> clazz) {
        if (clazz == null) {
            return;
        }
        if (this.mDelegate.getWeekBarClass().equals(clazz)) {
            return;
        }
        this.mDelegate.setWeekViewClass(clazz);
        this.mWeekPager.updateWeekViewClass();
    }

    public final void setWeekViewScrollable(boolean bl) {
        this.mDelegate.setWeekViewScrollable(bl);
    }

    public final void setYearViewScrollable(boolean bl) {
        this.mDelegate.setYearViewScrollable(bl);
    }

    public void setYearViewTextColor(int n, int n2, int n3) {
        CalendarViewDelegate calendarViewDelegate = this.mDelegate;
        if (calendarViewDelegate == null) return;
        if (this.mYearViewPager == null) return;
        calendarViewDelegate.setYearViewTextColor(n, n2, n3);
        this.mYearViewPager.updateStyle();
    }

    public void showYearSelectLayout(int n) {
        this.showSelectLayout(n);
    }

    public final void update() {
        this.mWeekBar.onWeekStartChange(this.mDelegate.getWeekStart());
        this.mYearViewPager.update();
        this.mMonthPager.updateScheme();
        this.mWeekPager.updateScheme();
    }

    public final void updateCurrentDate() {
        if (this.mDelegate == null) return;
        if (this.mMonthPager == null) return;
        if (this.mWeekPager == null) return;
        int n = java.util.Calendar.getInstance().get(5);
        if (this.getCurDay() == n) {
            return;
        }
        this.mDelegate.updateCurrentDay();
        this.mMonthPager.updateCurrentDate();
        this.mWeekPager.updateCurrentDate();
    }

    public void updateWeekBar() {
        this.mWeekBar.onWeekStartChange(this.mDelegate.getWeekStart());
    }
}
