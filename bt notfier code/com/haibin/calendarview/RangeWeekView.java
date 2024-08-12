/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.graphics.Canvas
 *  android.graphics.Paint
 *  android.view.View
 *  com.haibin.calendarview.BaseWeekView
 *  com.haibin.calendarview.Calendar
 *  com.haibin.calendarview.CalendarUtil
 */
package com.haibin.calendarview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.View;
import com.haibin.calendarview.BaseWeekView;
import com.haibin.calendarview.Calendar;
import com.haibin.calendarview.CalendarUtil;

public abstract class RangeWeekView
extends BaseWeekView {
    public RangeWeekView(Context context) {
        super(context);
    }

    protected boolean isCalendarSelected(Calendar calendar) {
        Calendar calendar2 = this.mDelegate.mSelectedStartRangeCalendar;
        boolean bl = false;
        boolean bl2 = false;
        if (calendar2 == null) {
            return false;
        }
        if (this.onCalendarIntercept(calendar)) {
            return false;
        }
        if (this.mDelegate.mSelectedEndRangeCalendar == null) {
            if (calendar.compareTo(this.mDelegate.mSelectedStartRangeCalendar) != 0) return bl2;
            bl2 = true;
            return bl2;
        }
        bl2 = bl;
        if (calendar.compareTo(this.mDelegate.mSelectedStartRangeCalendar) < 0) return bl2;
        bl2 = bl;
        if (calendar.compareTo(this.mDelegate.mSelectedEndRangeCalendar) > 0) return bl2;
        bl2 = true;
        return bl2;
    }

    protected final boolean isSelectNextCalendar(Calendar calendar) {
        calendar = CalendarUtil.getNextCalendar((Calendar)calendar);
        this.mDelegate.updateCalendarScheme(calendar);
        boolean bl = this.mDelegate.mSelectedStartRangeCalendar != null && this.isCalendarSelected(calendar);
        return bl;
    }

    protected final boolean isSelectPreCalendar(Calendar calendar) {
        calendar = CalendarUtil.getPreCalendar((Calendar)calendar);
        this.mDelegate.updateCalendarScheme(calendar);
        boolean bl = this.mDelegate.mSelectedStartRangeCalendar != null && this.isCalendarSelected(calendar);
        return bl;
    }

    public void onClick(View view) {
        int n;
        if (!this.isClick) {
            return;
        }
        Calendar calendar = this.getIndex();
        if (calendar == null) {
            return;
        }
        boolean bl = this.onCalendarIntercept(calendar);
        boolean bl2 = true;
        if (bl) {
            this.mDelegate.mCalendarInterceptListener.onCalendarInterceptClick(calendar, true);
            return;
        }
        if (!this.isInRange(calendar)) {
            if (this.mDelegate.mCalendarRangeSelectListener == null) return;
            this.mDelegate.mCalendarRangeSelectListener.onCalendarSelectOutOfRange(calendar);
            return;
        }
        if (this.mDelegate.mSelectedStartRangeCalendar != null && this.mDelegate.mSelectedEndRangeCalendar == null) {
            n = CalendarUtil.differ((Calendar)calendar, (Calendar)this.mDelegate.mSelectedStartRangeCalendar);
            if (n >= 0 && this.mDelegate.getMinSelectRange() != -1 && this.mDelegate.getMinSelectRange() > n + 1) {
                if (this.mDelegate.mCalendarRangeSelectListener == null) return;
                this.mDelegate.mCalendarRangeSelectListener.onSelectOutOfRange(calendar, true);
                return;
            }
            if (this.mDelegate.getMaxSelectRange() != -1 && this.mDelegate.getMaxSelectRange() < CalendarUtil.differ((Calendar)calendar, (Calendar)this.mDelegate.mSelectedStartRangeCalendar) + 1) {
                if (this.mDelegate.mCalendarRangeSelectListener == null) return;
                this.mDelegate.mCalendarRangeSelectListener.onSelectOutOfRange(calendar, false);
                return;
            }
        }
        if (this.mDelegate.mSelectedStartRangeCalendar != null && this.mDelegate.mSelectedEndRangeCalendar == null) {
            n = calendar.compareTo(this.mDelegate.mSelectedStartRangeCalendar);
            if (this.mDelegate.getMinSelectRange() == -1 && n <= 0) {
                this.mDelegate.mSelectedStartRangeCalendar = calendar;
                this.mDelegate.mSelectedEndRangeCalendar = null;
            } else if (n < 0) {
                this.mDelegate.mSelectedStartRangeCalendar = calendar;
                this.mDelegate.mSelectedEndRangeCalendar = null;
            } else {
                this.mDelegate.mSelectedEndRangeCalendar = n == 0 && this.mDelegate.getMinSelectRange() == 1 ? calendar : calendar;
            }
        } else {
            this.mDelegate.mSelectedStartRangeCalendar = calendar;
            this.mDelegate.mSelectedEndRangeCalendar = null;
        }
        this.mCurrentItem = this.mItems.indexOf(calendar);
        if (this.mDelegate.mInnerListener != null) {
            this.mDelegate.mInnerListener.onWeekDateSelected(calendar, true);
        }
        if (this.mParentLayout != null) {
            n = CalendarUtil.getWeekFromDayInMonth((Calendar)calendar, (int)this.mDelegate.getWeekStart());
            this.mParentLayout.updateSelectWeek(n);
        }
        if (this.mDelegate.mCalendarRangeSelectListener != null) {
            view = this.mDelegate.mCalendarRangeSelectListener;
            if (this.mDelegate.mSelectedEndRangeCalendar == null) {
                bl2 = false;
            }
            view.onCalendarRangeSelect(calendar, bl2);
        }
        this.invalidate();
    }

    protected void onDraw(Canvas canvas) {
        if (this.mItems.size() == 0) {
            return;
        }
        this.mItemWidth = (this.getWidth() - this.mDelegate.getCalendarPadding() * 2) / 7;
        this.onPreviewHook();
        int n = 0;
        while (n < 7) {
            int n2 = this.mItemWidth * n + this.mDelegate.getCalendarPadding();
            this.onLoopStart(n2);
            Calendar calendar = (Calendar)this.mItems.get(n);
            boolean bl = this.isCalendarSelected(calendar);
            boolean bl2 = this.isSelectPreCalendar(calendar);
            boolean bl3 = this.isSelectNextCalendar(calendar);
            boolean bl4 = calendar.hasScheme();
            if (bl4) {
                bl2 = bl ? this.onDrawSelected(canvas, calendar, n2, true, bl2, bl3) : false;
                if (bl2 || !bl) {
                    Paint paint = this.mSchemePaint;
                    int n3 = calendar.getSchemeColor() != 0 ? calendar.getSchemeColor() : this.mDelegate.getSchemeThemeColor();
                    paint.setColor(n3);
                    this.onDrawScheme(canvas, calendar, n2, bl);
                }
            } else if (bl) {
                this.onDrawSelected(canvas, calendar, n2, false, bl2, bl3);
            }
            this.onDrawText(canvas, calendar, n2, bl4, bl);
            ++n;
        }
    }

    protected abstract void onDrawScheme(Canvas var1, Calendar var2, int var3, boolean var4);

    protected abstract boolean onDrawSelected(Canvas var1, Calendar var2, int var3, boolean var4, boolean var5, boolean var6);

    protected abstract void onDrawText(Canvas var1, Calendar var2, int var3, boolean var4, boolean var5);

    public boolean onLongClick(View view) {
        return false;
    }
}
