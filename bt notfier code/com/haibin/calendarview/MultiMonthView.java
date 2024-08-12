/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.graphics.Canvas
 *  android.graphics.Paint
 *  android.view.View
 *  com.haibin.calendarview.BaseMonthView
 *  com.haibin.calendarview.Calendar
 *  com.haibin.calendarview.CalendarUtil
 */
package com.haibin.calendarview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.View;
import com.haibin.calendarview.BaseMonthView;
import com.haibin.calendarview.Calendar;
import com.haibin.calendarview.CalendarUtil;

public abstract class MultiMonthView
extends BaseMonthView {
    public MultiMonthView(Context context) {
        super(context);
    }

    private void draw(Canvas canvas, Calendar calendar, int n, int n2) {
        n2 = n2 * this.mItemWidth + this.mDelegate.getCalendarPadding();
        int n3 = n * this.mItemHeight;
        this.onLoopStart(n2, n3);
        boolean bl = this.isCalendarSelected(calendar);
        boolean bl2 = calendar.hasScheme();
        boolean bl3 = this.isSelectPreCalendar(calendar);
        boolean bl4 = this.isSelectNextCalendar(calendar);
        if (bl2) {
            boolean bl5 = false;
            if (bl) {
                bl5 = this.onDrawSelected(canvas, calendar, n2, n3, true, bl3, bl4);
            }
            if (bl5 || !bl) {
                Paint paint = this.mSchemePaint;
                n = calendar.getSchemeColor() != 0 ? calendar.getSchemeColor() : this.mDelegate.getSchemeThemeColor();
                paint.setColor(n);
                this.onDrawScheme(canvas, calendar, n2, n3, true);
            }
        } else if (bl) {
            this.onDrawSelected(canvas, calendar, n2, n3, false, bl3, bl4);
        }
        this.onDrawText(canvas, calendar, n2, n3, bl2, bl);
    }

    protected boolean isCalendarSelected(Calendar calendar) {
        boolean bl = !this.onCalendarIntercept(calendar) && this.mDelegate.mSelectedCalendars.containsKey(calendar.toString());
        return bl;
    }

    protected final boolean isSelectNextCalendar(Calendar calendar) {
        calendar = CalendarUtil.getNextCalendar((Calendar)calendar);
        this.mDelegate.updateCalendarScheme(calendar);
        return this.isCalendarSelected(calendar);
    }

    protected final boolean isSelectPreCalendar(Calendar calendar) {
        calendar = CalendarUtil.getPreCalendar((Calendar)calendar);
        this.mDelegate.updateCalendarScheme(calendar);
        return this.isCalendarSelected(calendar);
    }

    public void onClick(View view) {
        if (!this.isClick) {
            return;
        }
        view = this.getIndex();
        if (view == null) {
            return;
        }
        if (this.mDelegate.getMonthViewShowMode() == 1 && !view.isCurrentMonth()) {
            return;
        }
        if (this.onCalendarIntercept((Calendar)view)) {
            this.mDelegate.mCalendarInterceptListener.onCalendarInterceptClick((Calendar)view, true);
            return;
        }
        if (!this.isInRange((Calendar)view)) {
            if (this.mDelegate.mCalendarMultiSelectListener == null) return;
            this.mDelegate.mCalendarMultiSelectListener.onCalendarMultiSelectOutOfRange((Calendar)view);
            return;
        }
        String string = view.toString();
        if (this.mDelegate.mSelectedCalendars.containsKey(string)) {
            this.mDelegate.mSelectedCalendars.remove(string);
        } else {
            if (this.mDelegate.mSelectedCalendars.size() >= this.mDelegate.getMaxMultiSelectSize()) {
                if (this.mDelegate.mCalendarMultiSelectListener == null) return;
                this.mDelegate.mCalendarMultiSelectListener.onMultiSelectOutOfSize((Calendar)view, this.mDelegate.getMaxMultiSelectSize());
                return;
            }
            this.mDelegate.mSelectedCalendars.put(string, view);
        }
        this.mCurrentItem = this.mItems.indexOf(view);
        if (!view.isCurrentMonth() && this.mMonthViewPager != null) {
            int n = this.mMonthViewPager.getCurrentItem();
            n = this.mCurrentItem < 7 ? --n : ++n;
            this.mMonthViewPager.setCurrentItem(n);
        }
        if (this.mDelegate.mInnerListener != null) {
            this.mDelegate.mInnerListener.onMonthDateSelected((Calendar)view, true);
        }
        if (this.mParentLayout != null) {
            if (view.isCurrentMonth()) {
                this.mParentLayout.updateSelectPosition(this.mItems.indexOf(view));
            } else {
                this.mParentLayout.updateSelectWeek(CalendarUtil.getWeekFromDayInMonth((Calendar)view, (int)this.mDelegate.getWeekStart()));
            }
        }
        if (this.mDelegate.mCalendarMultiSelectListener == null) return;
        this.mDelegate.mCalendarMultiSelectListener.onCalendarMultiSelect((Calendar)view, this.mDelegate.mSelectedCalendars.size(), this.mDelegate.getMaxMultiSelectSize());
    }

    protected void onDraw(Canvas canvas) {
        if (this.mLineCount == 0) {
            return;
        }
        this.mItemWidth = (this.getWidth() - this.mDelegate.getCalendarPadding() * 2) / 7;
        this.onPreviewHook();
        int n = this.mLineCount;
        int n2 = 0;
        int n3 = 0;
        while (n2 < this.mLineCount) {
            for (int i = 0; i < 7; ++n3, ++i) {
                Calendar calendar = (Calendar)this.mItems.get(n3);
                if (this.mDelegate.getMonthViewShowMode() == 1) {
                    if (n3 > this.mItems.size() - this.mNextDiff) {
                        return;
                    }
                    if (!calendar.isCurrentMonth()) {
                        continue;
                    }
                } else if (this.mDelegate.getMonthViewShowMode() == 2 && n3 >= n * 7) {
                    return;
                }
                this.draw(canvas, calendar, n2, i);
            }
            ++n2;
        }
    }

    protected abstract void onDrawScheme(Canvas var1, Calendar var2, int var3, int var4, boolean var5);

    protected abstract boolean onDrawSelected(Canvas var1, Calendar var2, int var3, int var4, boolean var5, boolean var6, boolean var7);

    protected abstract void onDrawText(Canvas var1, Calendar var2, int var3, int var4, boolean var5, boolean var6);

    public boolean onLongClick(View view) {
        return false;
    }
}
