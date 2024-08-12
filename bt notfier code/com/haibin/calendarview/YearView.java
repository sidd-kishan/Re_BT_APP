/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.graphics.Canvas
 *  android.graphics.Paint
 *  android.graphics.Paint$Align
 *  android.graphics.Paint$Style
 *  android.graphics.Rect
 *  android.text.TextUtils
 *  android.view.View
 *  com.haibin.calendarview.Calendar
 *  com.haibin.calendarview.CalendarUtil
 *  com.haibin.calendarview.CalendarViewDelegate
 */
package com.haibin.calendarview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import com.haibin.calendarview.Calendar;
import com.haibin.calendarview.CalendarUtil;
import com.haibin.calendarview.CalendarViewDelegate;
import java.util.Iterator;
import java.util.List;

public abstract class YearView
extends View {
    protected Paint mCurDayLunarTextPaint;
    protected Paint mCurDayTextPaint;
    protected Paint mCurMonthLunarTextPaint;
    protected Paint mCurMonthTextPaint = new Paint();
    CalendarViewDelegate mDelegate;
    protected int mItemHeight;
    protected int mItemWidth;
    List<Calendar> mItems;
    protected int mLineCount;
    protected int mMonth;
    protected float mMonthTextBaseLine;
    protected Paint mMonthTextPaint;
    protected int mNextDiff;
    protected Paint mOtherMonthLunarTextPaint;
    protected Paint mOtherMonthTextPaint = new Paint();
    protected Paint mSchemeLunarTextPaint;
    protected Paint mSchemePaint;
    protected Paint mSchemeTextPaint;
    protected Paint mSelectTextPaint;
    protected Paint mSelectedLunarTextPaint;
    protected Paint mSelectedPaint;
    protected float mTextBaseLine;
    protected int mWeekStart;
    protected float mWeekTextBaseLine;
    protected Paint mWeekTextPaint;
    protected int mYear;

    public YearView(Context context) {
        this(context, null);
    }

    public YearView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mCurMonthLunarTextPaint = new Paint();
        this.mSelectedLunarTextPaint = new Paint();
        this.mOtherMonthLunarTextPaint = new Paint();
        this.mSchemeLunarTextPaint = new Paint();
        this.mSchemePaint = new Paint();
        this.mSelectedPaint = new Paint();
        this.mSchemeTextPaint = new Paint();
        this.mSelectTextPaint = new Paint();
        this.mCurDayTextPaint = new Paint();
        this.mCurDayLunarTextPaint = new Paint();
        this.mMonthTextPaint = new Paint();
        this.mWeekTextPaint = new Paint();
        this.initPaint();
    }

    private void addSchemesFromMap() {
        if (this.mDelegate.mSchemeDatesMap == null) return;
        if (this.mDelegate.mSchemeDatesMap.size() == 0) {
            return;
        }
        Iterator<Calendar> iterator = this.mItems.iterator();
        while (iterator.hasNext()) {
            Calendar calendar = iterator.next();
            if (this.mDelegate.mSchemeDatesMap.containsKey(calendar.toString())) {
                Calendar calendar2 = (Calendar)this.mDelegate.mSchemeDatesMap.get(calendar.toString());
                String string = TextUtils.isEmpty((CharSequence)calendar2.getScheme()) ? this.mDelegate.getSchemeText() : calendar2.getScheme();
                calendar.setScheme(string);
                calendar.setSchemeColor(calendar2.getSchemeColor());
                calendar.setSchemes(calendar2.getSchemes());
                continue;
            }
            calendar.setScheme("");
            calendar.setSchemeColor(0);
            calendar.setSchemes(null);
        }
    }

    private void draw(Canvas canvas, Calendar calendar, int n, int n2, int n3) {
        n2 = n2 * this.mItemWidth + this.mDelegate.getYearViewPadding();
        n3 = n * this.mItemHeight + this.getMonthViewTop();
        boolean bl = calendar.equals((Object)this.mDelegate.mSelectedCalendar);
        boolean bl2 = calendar.hasScheme();
        if (bl2) {
            boolean bl3 = false;
            if (bl) {
                bl3 = this.onDrawSelected(canvas, calendar, n2, n3, true);
            }
            if (bl3 || !bl) {
                Paint paint = this.mSchemePaint;
                n = calendar.getSchemeColor() != 0 ? calendar.getSchemeColor() : this.mDelegate.getSchemeThemeColor();
                paint.setColor(n);
                this.onDrawScheme(canvas, calendar, n2, n3);
            }
        } else if (bl) {
            this.onDrawSelected(canvas, calendar, n2, n3, false);
        }
        this.onDrawText(canvas, calendar, n2, n3, bl2, bl);
    }

    private int getMonthViewTop() {
        return this.mDelegate.getYearViewMonthMarginTop() + this.mDelegate.getYearViewMonthHeight() + this.mDelegate.getYearViewMonthMarginBottom() + this.mDelegate.getYearViewWeekHeight();
    }

    private void initPaint() {
        this.mCurMonthTextPaint.setAntiAlias(true);
        this.mCurMonthTextPaint.setTextAlign(Paint.Align.CENTER);
        this.mCurMonthTextPaint.setColor(-15658735);
        this.mCurMonthTextPaint.setFakeBoldText(true);
        this.mOtherMonthTextPaint.setAntiAlias(true);
        this.mOtherMonthTextPaint.setTextAlign(Paint.Align.CENTER);
        this.mOtherMonthTextPaint.setColor(-1973791);
        this.mOtherMonthTextPaint.setFakeBoldText(true);
        this.mCurMonthLunarTextPaint.setAntiAlias(true);
        this.mCurMonthLunarTextPaint.setTextAlign(Paint.Align.CENTER);
        this.mSelectedLunarTextPaint.setAntiAlias(true);
        this.mSelectedLunarTextPaint.setTextAlign(Paint.Align.CENTER);
        this.mOtherMonthLunarTextPaint.setAntiAlias(true);
        this.mOtherMonthLunarTextPaint.setTextAlign(Paint.Align.CENTER);
        this.mMonthTextPaint.setAntiAlias(true);
        this.mMonthTextPaint.setFakeBoldText(true);
        this.mWeekTextPaint.setAntiAlias(true);
        this.mWeekTextPaint.setFakeBoldText(true);
        this.mWeekTextPaint.setTextAlign(Paint.Align.CENTER);
        this.mSchemeLunarTextPaint.setAntiAlias(true);
        this.mSchemeLunarTextPaint.setTextAlign(Paint.Align.CENTER);
        this.mSchemeTextPaint.setAntiAlias(true);
        this.mSchemeTextPaint.setStyle(Paint.Style.FILL);
        this.mSchemeTextPaint.setTextAlign(Paint.Align.CENTER);
        this.mSchemeTextPaint.setColor(-1223853);
        this.mSchemeTextPaint.setFakeBoldText(true);
        this.mSelectTextPaint.setAntiAlias(true);
        this.mSelectTextPaint.setStyle(Paint.Style.FILL);
        this.mSelectTextPaint.setTextAlign(Paint.Align.CENTER);
        this.mSelectTextPaint.setColor(-1223853);
        this.mSelectTextPaint.setFakeBoldText(true);
        this.mSchemePaint.setAntiAlias(true);
        this.mSchemePaint.setStyle(Paint.Style.FILL);
        this.mSchemePaint.setStrokeWidth(2.0f);
        this.mSchemePaint.setColor(-1052689);
        this.mCurDayTextPaint.setAntiAlias(true);
        this.mCurDayTextPaint.setTextAlign(Paint.Align.CENTER);
        this.mCurDayTextPaint.setColor(-65536);
        this.mCurDayTextPaint.setFakeBoldText(true);
        this.mCurDayLunarTextPaint.setAntiAlias(true);
        this.mCurDayLunarTextPaint.setTextAlign(Paint.Align.CENTER);
        this.mCurDayLunarTextPaint.setColor(-65536);
        this.mCurDayLunarTextPaint.setFakeBoldText(true);
        this.mSelectedPaint.setAntiAlias(true);
        this.mSelectedPaint.setStyle(Paint.Style.FILL);
        this.mSelectedPaint.setStrokeWidth(2.0f);
    }

    private void onDrawMonth(Canvas canvas) {
        this.onDrawMonth(canvas, this.mYear, this.mMonth, this.mDelegate.getYearViewPadding(), this.mDelegate.getYearViewMonthMarginTop(), this.getWidth() - this.mDelegate.getYearViewPadding() * 2, this.mDelegate.getYearViewMonthHeight() + this.mDelegate.getYearViewMonthMarginTop());
    }

    private void onDrawMonthView(Canvas canvas) {
        int n = 0;
        int n2 = 0;
        while (n2 < this.mLineCount) {
            for (int i = 0; i < 7; ++n, ++i) {
                Calendar calendar = this.mItems.get(n);
                if (n > this.mItems.size() - this.mNextDiff) {
                    return;
                }
                if (!calendar.isCurrentMonth()) continue;
                this.draw(canvas, calendar, n2, i, n);
            }
            ++n2;
        }
    }

    private void onDrawWeek(Canvas canvas) {
        int n;
        if (this.mDelegate.getYearViewWeekHeight() <= 0) {
            return;
        }
        int n2 = n = this.mDelegate.getWeekStart();
        if (n > 0) {
            n2 = n - 1;
        }
        int n3 = (this.getWidth() - this.mDelegate.getYearViewPadding() * 2) / 7;
        n = 0;
        while (n < 7) {
            int n4;
            this.onDrawWeek(canvas, n2, this.mDelegate.getYearViewPadding() + n * n3, this.mDelegate.getYearViewMonthHeight() + this.mDelegate.getYearViewMonthMarginTop() + this.mDelegate.getYearViewMonthMarginBottom(), n3, this.mDelegate.getYearViewWeekHeight());
            n2 = n4 = n2 + 1;
            if (n4 >= 7) {
                n2 = 0;
            }
            ++n;
        }
    }

    final void init(int n, int n2) {
        this.mYear = n;
        this.mMonth = n2;
        this.mNextDiff = CalendarUtil.getMonthEndDiff((int)n, (int)n2, (int)this.mDelegate.getWeekStart());
        CalendarUtil.getMonthViewStartDiff((int)this.mYear, (int)this.mMonth, (int)this.mDelegate.getWeekStart());
        this.mItems = CalendarUtil.initCalendarForMonthView((int)this.mYear, (int)this.mMonth, (Calendar)this.mDelegate.getCurrentDay(), (int)this.mDelegate.getWeekStart());
        this.mLineCount = 6;
        this.addSchemesFromMap();
    }

    final void measureSize(int n, int n2) {
        Rect rect = new Rect();
        this.mCurMonthTextPaint.getTextBounds("1", 0, 1, rect);
        int n3 = rect.height() * 12 + this.getMonthViewTop();
        if (n2 < n3) {
            n2 = n3;
        }
        this.getLayoutParams().width = n;
        this.getLayoutParams().height = n2;
        this.mItemHeight = (n2 - this.getMonthViewTop()) / 6;
        rect = this.mCurMonthTextPaint.getFontMetrics();
        this.mTextBaseLine = (float)(this.mItemHeight / 2) - rect.descent + (rect.bottom - rect.top) / 2.0f;
        rect = this.mMonthTextPaint.getFontMetrics();
        this.mMonthTextBaseLine = (float)(this.mDelegate.getYearViewMonthHeight() / 2) - rect.descent + (rect.bottom - rect.top) / 2.0f;
        rect = this.mWeekTextPaint.getFontMetrics();
        this.mWeekTextBaseLine = (float)(this.mDelegate.getYearViewWeekHeight() / 2) - rect.descent + (rect.bottom - rect.top) / 2.0f;
        this.invalidate();
    }

    protected void onDraw(Canvas canvas) {
        this.mItemWidth = (this.getWidth() - this.mDelegate.getYearViewPadding() * 2) / 7;
        this.onPreviewHook();
        this.onDrawMonth(canvas);
        this.onDrawWeek(canvas);
        this.onDrawMonthView(canvas);
    }

    protected abstract void onDrawMonth(Canvas var1, int var2, int var3, int var4, int var5, int var6, int var7);

    protected abstract void onDrawScheme(Canvas var1, Calendar var2, int var3, int var4);

    protected abstract boolean onDrawSelected(Canvas var1, Calendar var2, int var3, int var4, boolean var5);

    protected abstract void onDrawText(Canvas var1, Calendar var2, int var3, int var4, boolean var5, boolean var6);

    protected abstract void onDrawWeek(Canvas var1, int var2, int var3, int var4, int var5, int var6);

    protected void onPreviewHook() {
    }

    final void setup(CalendarViewDelegate calendarViewDelegate) {
        this.mDelegate = calendarViewDelegate;
        this.updateStyle();
    }

    final void updateStyle() {
        CalendarViewDelegate calendarViewDelegate = this.mDelegate;
        if (calendarViewDelegate == null) {
            return;
        }
        this.mCurMonthTextPaint.setTextSize((float)calendarViewDelegate.getYearViewDayTextSize());
        this.mSchemeTextPaint.setTextSize((float)this.mDelegate.getYearViewDayTextSize());
        this.mOtherMonthTextPaint.setTextSize((float)this.mDelegate.getYearViewDayTextSize());
        this.mCurDayTextPaint.setTextSize((float)this.mDelegate.getYearViewDayTextSize());
        this.mSelectTextPaint.setTextSize((float)this.mDelegate.getYearViewDayTextSize());
        this.mSchemeTextPaint.setColor(this.mDelegate.getYearViewSchemeTextColor());
        this.mCurMonthTextPaint.setColor(this.mDelegate.getYearViewDayTextColor());
        this.mOtherMonthTextPaint.setColor(this.mDelegate.getYearViewDayTextColor());
        this.mCurDayTextPaint.setColor(this.mDelegate.getYearViewCurDayTextColor());
        this.mSelectTextPaint.setColor(this.mDelegate.getYearViewSelectTextColor());
        this.mMonthTextPaint.setTextSize((float)this.mDelegate.getYearViewMonthTextSize());
        this.mMonthTextPaint.setColor(this.mDelegate.getYearViewMonthTextColor());
        this.mWeekTextPaint.setColor(this.mDelegate.getYearViewWeekTextColor());
        this.mWeekTextPaint.setTextSize((float)this.mDelegate.getYearViewWeekTextSize());
    }
}
