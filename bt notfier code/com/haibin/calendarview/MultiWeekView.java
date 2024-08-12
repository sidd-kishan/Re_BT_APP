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

public abstract class MultiWeekView
extends BaseWeekView {
    public MultiWeekView(Context context) {
        super(context);
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

    public void onClick(View object) {
        if (!this.isClick) {
            return;
        }
        Calendar calendar = this.getIndex();
        if (calendar == null) {
            return;
        }
        if (this.onCalendarIntercept(calendar)) {
            this.mDelegate.mCalendarInterceptListener.onCalendarInterceptClick(calendar, true);
            return;
        }
        if (!this.isInRange(calendar)) {
            if (this.mDelegate.mCalendarMultiSelectListener == null) return;
            this.mDelegate.mCalendarMultiSelectListener.onCalendarMultiSelectOutOfRange(calendar);
            return;
        }
        object = calendar.toString();
        if (this.mDelegate.mSelectedCalendars.containsKey(object)) {
            this.mDelegate.mSelectedCalendars.remove(object);
        } else {
            if (this.mDelegate.mSelectedCalendars.size() >= this.mDelegate.getMaxMultiSelectSize()) {
                if (this.mDelegate.mCalendarMultiSelectListener == null) return;
                this.mDelegate.mCalendarMultiSelectListener.onMultiSelectOutOfSize(calendar, this.mDelegate.getMaxMultiSelectSize());
                return;
            }
            this.mDelegate.mSelectedCalendars.put(object, calendar);
        }
        this.mCurrentItem = this.mItems.indexOf(calendar);
        if (this.mDelegate.mInnerListener != null) {
            this.mDelegate.mInnerListener.onWeekDateSelected(calendar, true);
        }
        if (this.mParentLayout != null) {
            int n = CalendarUtil.getWeekFromDayInMonth((Calendar)calendar, (int)this.mDelegate.getWeekStart());
            this.mParentLayout.updateSelectWeek(n);
        }
        if (this.mDelegate.mCalendarMultiSelectListener != null) {
            this.mDelegate.mCalendarMultiSelectListener.onCalendarMultiSelect(calendar, this.mDelegate.mSelectedCalendars.size(), this.mDelegate.getMaxMultiSelectSize());
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
                bl3 = bl ? this.onDrawSelected(canvas, calendar, n2, true, bl2, bl3) : false;
                if (bl3 || !bl) {
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
