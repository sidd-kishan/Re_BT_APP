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

public abstract class WeekView
extends BaseWeekView {
    public WeekView(Context context) {
        super(context);
    }

    public void onClick(View view) {
        if (!this.isClick) {
            return;
        }
        view = this.getIndex();
        if (view == null) {
            return;
        }
        if (this.onCalendarIntercept((Calendar)view)) {
            this.mDelegate.mCalendarInterceptListener.onCalendarInterceptClick((Calendar)view, true);
            return;
        }
        if (!this.isInRange((Calendar)view)) {
            if (this.mDelegate.mCalendarSelectListener == null) return;
            this.mDelegate.mCalendarSelectListener.onCalendarOutOfRange((Calendar)view);
            return;
        }
        this.mCurrentItem = this.mItems.indexOf(view);
        if (this.mDelegate.mInnerListener != null) {
            this.mDelegate.mInnerListener.onWeekDateSelected((Calendar)view, true);
        }
        if (this.mParentLayout != null) {
            int n = CalendarUtil.getWeekFromDayInMonth((Calendar)view, (int)this.mDelegate.getWeekStart());
            this.mParentLayout.updateSelectWeek(n);
        }
        if (this.mDelegate.mCalendarSelectListener != null) {
            this.mDelegate.mCalendarSelectListener.onCalendarSelect((Calendar)view, true);
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
        while (n < this.mItems.size()) {
            int n2 = this.mItemWidth * n + this.mDelegate.getCalendarPadding();
            this.onLoopStart(n2);
            Calendar calendar = (Calendar)this.mItems.get(n);
            boolean bl = n == this.mCurrentItem;
            boolean bl2 = calendar.hasScheme();
            if (bl2) {
                boolean bl3 = bl ? this.onDrawSelected(canvas, calendar, n2, true) : false;
                if (bl3 || !bl) {
                    Paint paint = this.mSchemePaint;
                    int n3 = calendar.getSchemeColor() != 0 ? calendar.getSchemeColor() : this.mDelegate.getSchemeThemeColor();
                    paint.setColor(n3);
                    this.onDrawScheme(canvas, calendar, n2);
                }
            } else if (bl) {
                this.onDrawSelected(canvas, calendar, n2, false);
            }
            this.onDrawText(canvas, calendar, n2, bl2, bl);
            ++n;
        }
    }

    protected abstract void onDrawScheme(Canvas var1, Calendar var2, int var3);

    protected abstract boolean onDrawSelected(Canvas var1, Calendar var2, int var3, boolean var4);

    protected abstract void onDrawText(Canvas var1, Calendar var2, int var3, boolean var4, boolean var5);

    public boolean onLongClick(View view) {
        if (this.mDelegate.mCalendarLongClickListener == null) {
            return false;
        }
        if (!this.isClick) {
            return false;
        }
        view = this.getIndex();
        if (view == null) {
            return false;
        }
        if (this.onCalendarIntercept((Calendar)view)) {
            this.mDelegate.mCalendarInterceptListener.onCalendarInterceptClick((Calendar)view, true);
            return true;
        }
        if (!this.isInRange((Calendar)view)) {
            if (this.mDelegate.mCalendarLongClickListener == null) return true;
            this.mDelegate.mCalendarLongClickListener.onCalendarLongClickOutOfRange((Calendar)view);
            return true;
        }
        if (this.mDelegate.isPreventLongPressedSelected()) {
            if (this.mDelegate.mCalendarLongClickListener == null) return true;
            this.mDelegate.mCalendarLongClickListener.onCalendarLongClick((Calendar)view);
            return true;
        }
        this.mCurrentItem = this.mItems.indexOf(view);
        this.mDelegate.mIndexCalendar = this.mDelegate.mSelectedCalendar;
        if (this.mDelegate.mInnerListener != null) {
            this.mDelegate.mInnerListener.onWeekDateSelected((Calendar)view, true);
        }
        if (this.mParentLayout != null) {
            int n = CalendarUtil.getWeekFromDayInMonth((Calendar)view, (int)this.mDelegate.getWeekStart());
            this.mParentLayout.updateSelectWeek(n);
        }
        if (this.mDelegate.mCalendarSelectListener != null) {
            this.mDelegate.mCalendarSelectListener.onCalendarSelect((Calendar)view, true);
        }
        if (this.mDelegate.mCalendarLongClickListener != null) {
            this.mDelegate.mCalendarLongClickListener.onCalendarLongClick((Calendar)view);
        }
        this.invalidate();
        return true;
    }
}
