/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.text.TextUtils
 *  com.haibin.calendarview.Calendar
 *  com.haibin.calendarview.CalendarUtil
 *  com.haibin.calendarview.CalendarView$OnCalendarInterceptListener
 *  com.haibin.calendarview.CalendarView$OnCalendarLongClickListener
 *  com.haibin.calendarview.CalendarView$OnCalendarMultiSelectListener
 *  com.haibin.calendarview.CalendarView$OnCalendarRangeSelectListener
 *  com.haibin.calendarview.CalendarView$OnCalendarSelectListener
 *  com.haibin.calendarview.CalendarView$OnInnerDateSelectedListener
 *  com.haibin.calendarview.CalendarView$OnMonthChangeListener
 *  com.haibin.calendarview.CalendarView$OnViewChangeListener
 *  com.haibin.calendarview.CalendarView$OnWeekChangeListener
 *  com.haibin.calendarview.CalendarView$OnYearChangeListener
 *  com.haibin.calendarview.CalendarView$OnYearViewChangeListener
 *  com.haibin.calendarview.DefaultMonthView
 *  com.haibin.calendarview.DefaultWeekView
 *  com.haibin.calendarview.DefaultYearView
 *  com.haibin.calendarview.LunarCalendar
 *  com.haibin.calendarview.R$styleable
 *  com.haibin.calendarview.WeekBar
 */
package com.haibin.calendarview;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import com.haibin.calendarview.Calendar;
import com.haibin.calendarview.CalendarUtil;
import com.haibin.calendarview.CalendarView;
import com.haibin.calendarview.DefaultMonthView;
import com.haibin.calendarview.DefaultWeekView;
import com.haibin.calendarview.DefaultYearView;
import com.haibin.calendarview.LunarCalendar;
import com.haibin.calendarview.R;
import com.haibin.calendarview.WeekBar;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

final class CalendarViewDelegate {
    static final int FIRST_DAY_OF_MONTH = 0;
    static final int LAST_MONTH_VIEW_SELECT_DAY = 1;
    static final int LAST_MONTH_VIEW_SELECT_DAY_IGNORE_CURRENT = 2;
    private static final int MAX_YEAR = 2099;
    static final int MIN_YEAR = 1900;
    static final int MODE_ALL_MONTH = 0;
    static final int MODE_FIT_MONTH = 2;
    static final int MODE_ONLY_CURRENT_MONTH = 1;
    static final int SELECT_MODE_DEFAULT = 0;
    static final int SELECT_MODE_MULTI = 3;
    static final int SELECT_MODE_RANGE = 2;
    static final int SELECT_MODE_SINGLE = 1;
    static final int WEEK_START_WITH_MON = 2;
    static final int WEEK_START_WITH_SAT = 7;
    static final int WEEK_START_WITH_SUN = 1;
    private boolean isFullScreenCalendar;
    boolean isShowYearSelectedLayout;
    CalendarView.OnCalendarInterceptListener mCalendarInterceptListener;
    private int mCalendarItemHeight;
    CalendarView.OnCalendarLongClickListener mCalendarLongClickListener;
    CalendarView.OnCalendarMultiSelectListener mCalendarMultiSelectListener;
    private int mCalendarPadding;
    CalendarView.OnCalendarRangeSelectListener mCalendarRangeSelectListener;
    CalendarView.OnCalendarSelectListener mCalendarSelectListener;
    private int mCurDayLunarTextColor;
    private int mCurDayTextColor;
    private int mCurMonthLunarTextColor;
    private Calendar mCurrentDate;
    private int mCurrentMonthTextColor;
    int mCurrentMonthViewItem;
    private int mDayTextSize;
    private int mDefaultCalendarSelectDay;
    Calendar mIndexCalendar;
    CalendarView.OnInnerDateSelectedListener mInnerListener;
    private int mLunarTextSize;
    private int mMaxMultiSelectSize;
    private int mMaxSelectRange;
    private int mMaxYear;
    private int mMaxYearDay;
    private int mMaxYearMonth;
    private int mMinSelectRange;
    private int mMinYear;
    private int mMinYearDay;
    private int mMinYearMonth;
    CalendarView.OnMonthChangeListener mMonthChangeListener;
    private Class<?> mMonthViewClass;
    private String mMonthViewClassPath;
    private boolean mMonthViewScrollable;
    private int mMonthViewShowMode;
    private int mOtherMonthLunarTextColor;
    private int mOtherMonthTextColor;
    Map<String, Calendar> mSchemeDatesMap;
    private int mSchemeLunarTextColor;
    private String mSchemeText;
    private int mSchemeTextColor;
    private int mSchemeThemeColor;
    private int mSelectMode;
    Calendar mSelectedCalendar;
    Map<String, Calendar> mSelectedCalendars = new HashMap<String, Calendar>();
    Calendar mSelectedEndRangeCalendar;
    private int mSelectedLunarTextColor;
    Calendar mSelectedStartRangeCalendar;
    private int mSelectedTextColor;
    private int mSelectedThemeColor;
    CalendarView.OnViewChangeListener mViewChangeListener;
    private int mWeekBackground;
    private Class<?> mWeekBarClass;
    private String mWeekBarClassPath;
    private int mWeekBarHeight;
    CalendarView.OnWeekChangeListener mWeekChangeListener;
    private int mWeekLineBackground;
    private int mWeekLineMargin;
    private int mWeekStart;
    private int mWeekTextColor;
    private int mWeekTextSize;
    private Class<?> mWeekViewClass;
    private String mWeekViewClassPath;
    private boolean mWeekViewScrollable;
    CalendarView.OnYearChangeListener mYearChangeListener;
    private int mYearViewBackground;
    CalendarView.OnYearViewChangeListener mYearViewChangeListener;
    private Class<?> mYearViewClass;
    private String mYearViewClassPath;
    private int mYearViewCurDayTextColor;
    private int mYearViewDayTextColor;
    private int mYearViewDayTextSize;
    private int mYearViewMonthHeight;
    private int mYearViewMonthMarginBottom;
    private int mYearViewMonthMarginTop;
    private int mYearViewMonthTextColor;
    private int mYearViewMonthTextSize;
    private int mYearViewPadding;
    private int mYearViewSchemeTextColor;
    private boolean mYearViewScrollable;
    private int mYearViewSelectTextColor;
    private int mYearViewWeekHeight;
    private int mYearViewWeekTextColor;
    private int mYearViewWeekTextSize;
    private boolean preventLongPressedSelected;

    CalendarViewDelegate(Context context, AttributeSet attributeSet) {
        int n;
        String string;
        attributeSet = context.obtainStyledAttributes(attributeSet, R.styleable.CalendarView);
        LunarCalendar.init((Context)context);
        this.mCalendarPadding = (int)attributeSet.getDimension(R.styleable.CalendarView_calendar_padding, 0.0f);
        this.mSchemeTextColor = attributeSet.getColor(R.styleable.CalendarView_scheme_text_color, -1);
        this.mSchemeLunarTextColor = attributeSet.getColor(R.styleable.CalendarView_scheme_lunar_text_color, -1973791);
        this.mSchemeThemeColor = attributeSet.getColor(R.styleable.CalendarView_scheme_theme_color, 1355796431);
        this.mMonthViewClassPath = attributeSet.getString(R.styleable.CalendarView_month_view);
        this.mYearViewClassPath = attributeSet.getString(R.styleable.CalendarView_year_view);
        this.mWeekViewClassPath = attributeSet.getString(R.styleable.CalendarView_week_view);
        this.mWeekBarClassPath = attributeSet.getString(R.styleable.CalendarView_week_bar_view);
        this.mWeekTextSize = attributeSet.getDimensionPixelSize(R.styleable.CalendarView_week_text_size, CalendarUtil.dipToPx((Context)context, (float)12.0f));
        this.mWeekBarHeight = (int)attributeSet.getDimension(R.styleable.CalendarView_week_bar_height, CalendarUtil.dipToPx((Context)context, (float)40.0f));
        this.mWeekLineMargin = (int)attributeSet.getDimension(R.styleable.CalendarView_week_line_margin, CalendarUtil.dipToPx((Context)context, (float)0.0f));
        this.mSchemeText = string = attributeSet.getString(R.styleable.CalendarView_scheme_text);
        if (TextUtils.isEmpty((CharSequence)string)) {
            this.mSchemeText = "\u8bb0";
        }
        this.mMonthViewScrollable = attributeSet.getBoolean(R.styleable.CalendarView_month_view_scrollable, true);
        this.mWeekViewScrollable = attributeSet.getBoolean(R.styleable.CalendarView_week_view_scrollable, true);
        this.mYearViewScrollable = attributeSet.getBoolean(R.styleable.CalendarView_year_view_scrollable, true);
        this.mDefaultCalendarSelectDay = attributeSet.getInt(R.styleable.CalendarView_month_view_auto_select_day, 0);
        this.mMonthViewShowMode = attributeSet.getInt(R.styleable.CalendarView_month_view_show_mode, 0);
        this.mWeekStart = attributeSet.getInt(R.styleable.CalendarView_week_start_with, 1);
        this.mSelectMode = attributeSet.getInt(R.styleable.CalendarView_select_mode, 0);
        this.mMaxMultiSelectSize = attributeSet.getInt(R.styleable.CalendarView_max_multi_select_size, Integer.MAX_VALUE);
        this.mMinSelectRange = attributeSet.getInt(R.styleable.CalendarView_min_select_range, -1);
        this.mMaxSelectRange = n = attributeSet.getInt(R.styleable.CalendarView_max_select_range, -1);
        this.setSelectRange(this.mMinSelectRange, n);
        this.mWeekBackground = attributeSet.getColor(R.styleable.CalendarView_week_background, -1);
        this.mWeekLineBackground = attributeSet.getColor(R.styleable.CalendarView_week_line_background, 0);
        this.mYearViewBackground = attributeSet.getColor(R.styleable.CalendarView_year_view_background, -1);
        this.mWeekTextColor = attributeSet.getColor(R.styleable.CalendarView_week_text_color, -13421773);
        this.mCurDayTextColor = attributeSet.getColor(R.styleable.CalendarView_current_day_text_color, -65536);
        this.mCurDayLunarTextColor = attributeSet.getColor(R.styleable.CalendarView_current_day_lunar_text_color, -65536);
        this.mSelectedThemeColor = attributeSet.getColor(R.styleable.CalendarView_selected_theme_color, 1355796431);
        this.mSelectedTextColor = attributeSet.getColor(R.styleable.CalendarView_selected_text_color, -15658735);
        this.mSelectedLunarTextColor = attributeSet.getColor(R.styleable.CalendarView_selected_lunar_text_color, -15658735);
        this.mCurrentMonthTextColor = attributeSet.getColor(R.styleable.CalendarView_current_month_text_color, -15658735);
        this.mOtherMonthTextColor = attributeSet.getColor(R.styleable.CalendarView_other_month_text_color, -1973791);
        this.mCurMonthLunarTextColor = attributeSet.getColor(R.styleable.CalendarView_current_month_lunar_text_color, -1973791);
        this.mOtherMonthLunarTextColor = attributeSet.getColor(R.styleable.CalendarView_other_month_lunar_text_color, -1973791);
        this.mMinYear = attributeSet.getInt(R.styleable.CalendarView_min_year, 1971);
        this.mMaxYear = attributeSet.getInt(R.styleable.CalendarView_max_year, 2055);
        this.mMinYearMonth = attributeSet.getInt(R.styleable.CalendarView_min_year_month, 1);
        this.mMaxYearMonth = attributeSet.getInt(R.styleable.CalendarView_max_year_month, 12);
        this.mMinYearDay = attributeSet.getInt(R.styleable.CalendarView_min_year_day, 1);
        this.mMaxYearDay = attributeSet.getInt(R.styleable.CalendarView_max_year_day, -1);
        this.mDayTextSize = attributeSet.getDimensionPixelSize(R.styleable.CalendarView_day_text_size, CalendarUtil.dipToPx((Context)context, (float)16.0f));
        this.mLunarTextSize = attributeSet.getDimensionPixelSize(R.styleable.CalendarView_lunar_text_size, CalendarUtil.dipToPx((Context)context, (float)10.0f));
        this.mCalendarItemHeight = (int)attributeSet.getDimension(R.styleable.CalendarView_calendar_height, CalendarUtil.dipToPx((Context)context, (float)56.0f));
        this.isFullScreenCalendar = attributeSet.getBoolean(R.styleable.CalendarView_calendar_match_parent, false);
        this.mYearViewMonthTextSize = attributeSet.getDimensionPixelSize(R.styleable.CalendarView_year_view_month_text_size, CalendarUtil.dipToPx((Context)context, (float)18.0f));
        this.mYearViewDayTextSize = attributeSet.getDimensionPixelSize(R.styleable.CalendarView_year_view_day_text_size, CalendarUtil.dipToPx((Context)context, (float)7.0f));
        this.mYearViewMonthTextColor = attributeSet.getColor(R.styleable.CalendarView_year_view_month_text_color, -15658735);
        this.mYearViewDayTextColor = attributeSet.getColor(R.styleable.CalendarView_year_view_day_text_color, -15658735);
        this.mYearViewSchemeTextColor = attributeSet.getColor(R.styleable.CalendarView_year_view_scheme_color, this.mSchemeThemeColor);
        this.mYearViewWeekTextColor = attributeSet.getColor(R.styleable.CalendarView_year_view_week_text_color, -13421773);
        this.mYearViewCurDayTextColor = attributeSet.getColor(R.styleable.CalendarView_year_view_current_day_text_color, this.mCurDayTextColor);
        this.mYearViewSelectTextColor = attributeSet.getColor(R.styleable.CalendarView_year_view_select_text_color, -13421773);
        this.mYearViewWeekTextSize = attributeSet.getDimensionPixelSize(R.styleable.CalendarView_year_view_week_text_size, CalendarUtil.dipToPx((Context)context, (float)8.0f));
        this.mYearViewMonthHeight = attributeSet.getDimensionPixelSize(R.styleable.CalendarView_year_view_month_height, CalendarUtil.dipToPx((Context)context, (float)32.0f));
        this.mYearViewWeekHeight = attributeSet.getDimensionPixelSize(R.styleable.CalendarView_year_view_week_height, CalendarUtil.dipToPx((Context)context, (float)0.0f));
        this.mYearViewPadding = (int)attributeSet.getDimension(R.styleable.CalendarView_year_view_padding, CalendarUtil.dipToPx((Context)context, (float)6.0f));
        this.mYearViewMonthMarginTop = (int)attributeSet.getDimension(R.styleable.CalendarView_year_view_month_margin_top, CalendarUtil.dipToPx((Context)context, (float)4.0f));
        this.mYearViewMonthMarginBottom = (int)attributeSet.getDimension(R.styleable.CalendarView_year_view_month_margin_bottom, CalendarUtil.dipToPx((Context)context, (float)4.0f));
        if (this.mMinYear <= 1900) {
            this.mMinYear = 1900;
        }
        if (this.mMaxYear >= 2099) {
            this.mMaxYear = 2099;
        }
        attributeSet.recycle();
        this.init();
    }

    private void init() {
        this.mCurrentDate = new Calendar();
        Class<Object> clazz = new Date();
        this.mCurrentDate.setYear(CalendarUtil.getDate((String)"yyyy", (Date)((Object)clazz)));
        this.mCurrentDate.setMonth(CalendarUtil.getDate((String)"MM", (Date)((Object)clazz)));
        this.mCurrentDate.setDay(CalendarUtil.getDate((String)"dd", (Date)((Object)clazz)));
        this.mCurrentDate.setCurrentDay(true);
        LunarCalendar.setupLunarCalendar((Calendar)this.mCurrentDate);
        this.setRange(this.mMinYear, this.mMinYearMonth, this.mMaxYear, this.mMaxYearMonth);
        try {
            if (TextUtils.isEmpty((CharSequence)this.mWeekBarClassPath)) {
                clazz = WeekBar.class;
                this.mWeekBarClass = WeekBar.class;
            } else {
                clazz = Class.forName(this.mWeekBarClassPath);
            }
            this.mWeekBarClass = clazz;
        }
        catch (Exception exception) {
            exception.printStackTrace();
        }
        try {
            if (TextUtils.isEmpty((CharSequence)this.mYearViewClassPath)) {
                clazz = DefaultYearView.class;
                this.mYearViewClass = DefaultYearView.class;
            } else {
                clazz = Class.forName(this.mYearViewClassPath);
            }
            this.mYearViewClass = clazz;
        }
        catch (Exception exception) {
            exception.printStackTrace();
        }
        try {
            clazz = TextUtils.isEmpty((CharSequence)this.mMonthViewClassPath) ? DefaultMonthView.class : Class.forName(this.mMonthViewClassPath);
            this.mMonthViewClass = clazz;
        }
        catch (Exception exception) {
            exception.printStackTrace();
        }
        try {
            clazz = TextUtils.isEmpty((CharSequence)this.mWeekViewClassPath) ? DefaultWeekView.class : Class.forName(this.mWeekViewClassPath);
            this.mWeekViewClass = clazz;
        }
        catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    private void setRange(int n, int n2, int n3, int n4) {
        this.mMinYear = n;
        this.mMinYearMonth = n2;
        this.mMaxYear = n3;
        this.mMaxYearMonth = n4;
        if (n3 < this.mCurrentDate.getYear()) {
            this.mMaxYear = this.mCurrentDate.getYear();
        }
        if (this.mMaxYearDay == -1) {
            this.mMaxYearDay = CalendarUtil.getMonthDaysCount((int)this.mMaxYear, (int)this.mMaxYearMonth);
        }
        this.mCurrentMonthViewItem = (this.mCurrentDate.getYear() - this.mMinYear) * 12 + this.mCurrentDate.getMonth() - this.mMinYearMonth;
    }

    final void addSchemes(Map<String, Calendar> map) {
        if (map == null) return;
        if (map.size() == 0) {
            return;
        }
        if (this.mSchemeDatesMap == null) {
            this.mSchemeDatesMap = new HashMap<String, Calendar>();
        }
        Iterator<String> iterator = map.keySet().iterator();
        while (iterator.hasNext()) {
            String string = iterator.next();
            if (this.mSchemeDatesMap.containsKey(string)) {
                this.mSchemeDatesMap.remove(string);
            }
            this.mSchemeDatesMap.put(string, map.get(string));
        }
    }

    final void addSchemesFromMap(List<Calendar> object) {
        Calendar calendar = this.mSchemeDatesMap;
        if (calendar == null) return;
        if (calendar.size() == 0) {
            return;
        }
        Iterator<Calendar> iterator = object.iterator();
        while (iterator.hasNext()) {
            Calendar calendar2 = iterator.next();
            if (this.mSchemeDatesMap.containsKey(calendar2.toString())) {
                calendar = this.mSchemeDatesMap.get(calendar2.toString());
                object = TextUtils.isEmpty((CharSequence)calendar.getScheme()) ? this.getSchemeText() : calendar.getScheme();
                calendar2.setScheme((String)object);
                calendar2.setSchemeColor(calendar.getSchemeColor());
                calendar2.setSchemes(calendar.getSchemes());
                continue;
            }
            calendar2.setScheme("");
            calendar2.setSchemeColor(0);
            calendar2.setSchemes(null);
        }
    }

    final void clearSelectRange() {
        this.mSelectedStartRangeCalendar = null;
        this.mSelectedEndRangeCalendar = null;
    }

    void clearSelectedScheme() {
        this.mSelectedCalendar.clearScheme();
    }

    Calendar createCurrentDate() {
        Calendar calendar = new Calendar();
        calendar.setYear(this.mCurrentDate.getYear());
        calendar.setWeek(this.mCurrentDate.getWeek());
        calendar.setMonth(this.mCurrentDate.getMonth());
        calendar.setDay(this.mCurrentDate.getDay());
        calendar.setCurrentDay(true);
        LunarCalendar.setupLunarCalendar((Calendar)calendar);
        return calendar;
    }

    int getCalendarItemHeight() {
        return this.mCalendarItemHeight;
    }

    int getCalendarPadding() {
        return this.mCalendarPadding;
    }

    int getCurDayLunarTextColor() {
        return this.mCurDayLunarTextColor;
    }

    int getCurDayTextColor() {
        return this.mCurDayTextColor;
    }

    Calendar getCurrentDay() {
        return this.mCurrentDate;
    }

    int getCurrentMonthLunarTextColor() {
        return this.mCurMonthLunarTextColor;
    }

    int getCurrentMonthTextColor() {
        return this.mCurrentMonthTextColor;
    }

    int getDayTextSize() {
        return this.mDayTextSize;
    }

    int getDefaultCalendarSelectDay() {
        return this.mDefaultCalendarSelectDay;
    }

    int getLunarTextSize() {
        return this.mLunarTextSize;
    }

    int getMaxMultiSelectSize() {
        return this.mMaxMultiSelectSize;
    }

    final Calendar getMaxRangeCalendar() {
        Calendar calendar = new Calendar();
        calendar.setYear(this.mMaxYear);
        calendar.setMonth(this.mMaxYearMonth);
        calendar.setDay(this.mMaxYearDay);
        calendar.setCurrentDay(calendar.equals((Object)this.mCurrentDate));
        LunarCalendar.setupLunarCalendar((Calendar)calendar);
        return calendar;
    }

    int getMaxSelectRange() {
        return this.mMaxSelectRange;
    }

    int getMaxYear() {
        return this.mMaxYear;
    }

    int getMaxYearDay() {
        return this.mMaxYearDay;
    }

    int getMaxYearMonth() {
        return this.mMaxYearMonth;
    }

    final Calendar getMinRangeCalendar() {
        Calendar calendar = new Calendar();
        calendar.setYear(this.mMinYear);
        calendar.setMonth(this.mMinYearMonth);
        calendar.setDay(this.mMinYearDay);
        calendar.setCurrentDay(calendar.equals((Object)this.mCurrentDate));
        LunarCalendar.setupLunarCalendar((Calendar)calendar);
        return calendar;
    }

    int getMinSelectRange() {
        return this.mMinSelectRange;
    }

    int getMinYear() {
        return this.mMinYear;
    }

    int getMinYearDay() {
        return this.mMinYearDay;
    }

    int getMinYearMonth() {
        return this.mMinYearMonth;
    }

    Class<?> getMonthViewClass() {
        return this.mMonthViewClass;
    }

    int getMonthViewShowMode() {
        return this.mMonthViewShowMode;
    }

    int getOtherMonthLunarTextColor() {
        return this.mOtherMonthLunarTextColor;
    }

    int getOtherMonthTextColor() {
        return this.mOtherMonthTextColor;
    }

    int getSchemeLunarTextColor() {
        return this.mSchemeLunarTextColor;
    }

    String getSchemeText() {
        return this.mSchemeText;
    }

    int getSchemeTextColor() {
        return this.mSchemeTextColor;
    }

    int getSchemeThemeColor() {
        return this.mSchemeThemeColor;
    }

    final List<Calendar> getSelectCalendarRange() {
        if (this.mSelectMode != 2) {
            return null;
        }
        ArrayList<Calendar> arrayList = new ArrayList<Calendar>();
        if (this.mSelectedStartRangeCalendar == null) return arrayList;
        if (this.mSelectedEndRangeCalendar == null) return arrayList;
        java.util.Calendar calendar = java.util.Calendar.getInstance();
        calendar.set(this.mSelectedStartRangeCalendar.getYear(), this.mSelectedStartRangeCalendar.getMonth() - 1, this.mSelectedStartRangeCalendar.getDay());
        calendar.set(this.mSelectedEndRangeCalendar.getYear(), this.mSelectedEndRangeCalendar.getMonth() - 1, this.mSelectedEndRangeCalendar.getDay());
        long l = calendar.getTimeInMillis();
        for (long i = calendar.getTimeInMillis(); i <= l; i += 86400000L) {
            calendar.setTimeInMillis(i);
            Calendar calendar2 = new Calendar();
            calendar2.setYear(calendar.get(1));
            calendar2.setMonth(calendar.get(2) + 1);
            calendar2.setDay(calendar.get(5));
            LunarCalendar.setupLunarCalendar((Calendar)calendar2);
            this.updateCalendarScheme(calendar2);
            CalendarView.OnCalendarInterceptListener onCalendarInterceptListener = this.mCalendarInterceptListener;
            if (onCalendarInterceptListener != null && onCalendarInterceptListener.onCalendarIntercept(calendar2)) continue;
            arrayList.add(calendar2);
        }
        this.addSchemesFromMap(arrayList);
        return arrayList;
    }

    int getSelectMode() {
        return this.mSelectMode;
    }

    int getSelectedLunarTextColor() {
        return this.mSelectedLunarTextColor;
    }

    int getSelectedTextColor() {
        return this.mSelectedTextColor;
    }

    int getSelectedThemeColor() {
        return this.mSelectedThemeColor;
    }

    int getWeekBackground() {
        return this.mWeekBackground;
    }

    Class<?> getWeekBarClass() {
        return this.mWeekBarClass;
    }

    int getWeekBarHeight() {
        return this.mWeekBarHeight;
    }

    int getWeekLineBackground() {
        return this.mWeekLineBackground;
    }

    int getWeekLineMargin() {
        return this.mWeekLineMargin;
    }

    int getWeekStart() {
        return this.mWeekStart;
    }

    int getWeekTextColor() {
        return this.mWeekTextColor;
    }

    int getWeekTextSize() {
        return this.mWeekTextSize;
    }

    Class<?> getWeekViewClass() {
        return this.mWeekViewClass;
    }

    int getYearViewBackground() {
        return this.mYearViewBackground;
    }

    Class<?> getYearViewClass() {
        return this.mYearViewClass;
    }

    String getYearViewClassPath() {
        return this.mYearViewClassPath;
    }

    int getYearViewCurDayTextColor() {
        return this.mYearViewCurDayTextColor;
    }

    int getYearViewDayTextColor() {
        return this.mYearViewDayTextColor;
    }

    int getYearViewDayTextSize() {
        return this.mYearViewDayTextSize;
    }

    int getYearViewMonthHeight() {
        return this.mYearViewMonthHeight;
    }

    int getYearViewMonthMarginBottom() {
        return this.mYearViewMonthMarginBottom;
    }

    int getYearViewMonthMarginTop() {
        return this.mYearViewMonthMarginTop;
    }

    int getYearViewMonthTextColor() {
        return this.mYearViewMonthTextColor;
    }

    int getYearViewMonthTextSize() {
        return this.mYearViewMonthTextSize;
    }

    int getYearViewPadding() {
        return this.mYearViewPadding;
    }

    int getYearViewSchemeTextColor() {
        return this.mYearViewSchemeTextColor;
    }

    int getYearViewSelectTextColor() {
        return this.mYearViewSelectTextColor;
    }

    int getYearViewWeekHeight() {
        return this.mYearViewWeekHeight;
    }

    int getYearViewWeekTextColor() {
        return this.mYearViewWeekTextColor;
    }

    int getYearViewWeekTextSize() {
        return this.mYearViewWeekTextSize;
    }

    boolean isFullScreenCalendar() {
        return this.isFullScreenCalendar;
    }

    boolean isMonthViewScrollable() {
        return this.mMonthViewScrollable;
    }

    boolean isPreventLongPressedSelected() {
        return this.preventLongPressedSelected;
    }

    boolean isWeekViewScrollable() {
        return this.mWeekViewScrollable;
    }

    boolean isYearViewScrollable() {
        return this.mYearViewScrollable;
    }

    void setCalendarItemHeight(int n) {
        this.mCalendarItemHeight = n;
    }

    void setDefaultCalendarSelectDay(int n) {
        this.mDefaultCalendarSelectDay = n;
    }

    void setMaxMultiSelectSize(int n) {
        this.mMaxMultiSelectSize = n;
    }

    void setMonthViewClass(Class<?> clazz) {
        this.mMonthViewClass = clazz;
    }

    void setMonthViewScrollable(boolean bl) {
        this.mMonthViewScrollable = bl;
    }

    void setMonthViewShowMode(int n) {
        this.mMonthViewShowMode = n;
    }

    void setPreventLongPressedSelected(boolean bl) {
        this.preventLongPressedSelected = bl;
    }

    void setRange(int n, int n2, int n3, int n4, int n5, int n6) {
        this.mMinYear = n;
        this.mMinYearMonth = n2;
        this.mMinYearDay = n3;
        this.mMaxYear = n4;
        this.mMaxYearMonth = n5;
        this.mMaxYearDay = n6;
        if (n6 == -1) {
            this.mMaxYearDay = CalendarUtil.getMonthDaysCount((int)n4, (int)n5);
        }
        this.mCurrentMonthViewItem = (this.mCurrentDate.getYear() - this.mMinYear) * 12 + this.mCurrentDate.getMonth() - this.mMinYearMonth;
    }

    void setSchemeColor(int n, int n2, int n3) {
        this.mSchemeThemeColor = n;
        this.mSchemeTextColor = n2;
        this.mSchemeLunarTextColor = n3;
    }

    void setSelectColor(int n, int n2, int n3) {
        this.mSelectedThemeColor = n;
        this.mSelectedTextColor = n2;
        this.mSelectedLunarTextColor = n3;
    }

    void setSelectMode(int n) {
        this.mSelectMode = n;
    }

    final void setSelectRange(int n, int n2) {
        if (n > n2 && n2 > 0) {
            this.mMaxSelectRange = n;
            this.mMinSelectRange = n;
            return;
        }
        this.mMinSelectRange = n <= 0 ? -1 : n;
        this.mMaxSelectRange = n2 <= 0 ? -1 : n2;
    }

    void setTextColor(int n, int n2, int n3, int n4, int n5) {
        this.mCurDayTextColor = n;
        this.mOtherMonthTextColor = n3;
        this.mCurrentMonthTextColor = n2;
        this.mCurMonthLunarTextColor = n4;
        this.mOtherMonthLunarTextColor = n5;
    }

    void setThemeColor(int n, int n2) {
        this.mSelectedThemeColor = n;
        this.mSchemeThemeColor = n2;
    }

    void setWeekBarClass(Class<?> clazz) {
        this.mWeekBarClass = clazz;
    }

    void setWeekStart(int n) {
        this.mWeekStart = n;
    }

    void setWeekViewClass(Class<?> clazz) {
        this.mWeekViewClass = clazz;
    }

    void setWeekViewScrollable(boolean bl) {
        this.mWeekViewScrollable = bl;
    }

    void setYearViewScrollable(boolean bl) {
        this.mYearViewScrollable = bl;
    }

    void setYearViewTextColor(int n, int n2, int n3) {
        this.mYearViewMonthTextColor = n;
        this.mYearViewDayTextColor = n2;
        this.mYearViewSchemeTextColor = n3;
    }

    final void updateCalendarScheme(Calendar calendar) {
        if (calendar == null) {
            return;
        }
        Object object = this.mSchemeDatesMap;
        if (object == null) return;
        if (object.size() == 0) return;
        object = calendar.toString();
        if (!this.mSchemeDatesMap.containsKey(object)) return;
        calendar.mergeScheme(this.mSchemeDatesMap.get(object), this.getSchemeText());
    }

    void updateCurrentDay() {
        Date date = new Date();
        this.mCurrentDate.setYear(CalendarUtil.getDate((String)"yyyy", (Date)date));
        this.mCurrentDate.setMonth(CalendarUtil.getDate((String)"MM", (Date)date));
        this.mCurrentDate.setDay(CalendarUtil.getDate((String)"dd", (Date)date));
        LunarCalendar.setupLunarCalendar((Calendar)this.mCurrentDate);
    }

    final void updateSelectCalendarScheme() {
        Object object = this.mSchemeDatesMap;
        if (object != null && object.size() > 0) {
            object = this.mSelectedCalendar.toString();
            if (!this.mSchemeDatesMap.containsKey(object)) return;
            object = this.mSchemeDatesMap.get(object);
            this.mSelectedCalendar.mergeScheme((Calendar)object, this.getSchemeText());
        } else {
            this.clearSelectedScheme();
        }
    }
}
