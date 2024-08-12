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

public abstract class MonthView
extends BaseMonthView {
    public MonthView(Context context) {
        super(context);
    }

    private void draw(Canvas canvas, Calendar calendar, int n, int n2, int n3) {
        n2 = n2 * this.mItemWidth + this.mDelegate.getCalendarPadding();
        int n4 = n * this.mItemHeight;
        this.onLoopStart(n2, n4);
        n = this.mCurrentItem;
        boolean bl = false;
        boolean bl2 = n3 == n;
        boolean bl3 = calendar.hasScheme();
        if (bl3) {
            if (bl2) {
                bl = this.onDrawSelected(canvas, calendar, n2, n4, true);
            }
            if (bl || !bl2) {
                Paint paint = this.mSchemePaint;
                n = calendar.getSchemeColor() != 0 ? calendar.getSchemeColor() : this.mDelegate.getSchemeThemeColor();
                paint.setColor(n);
                this.onDrawScheme(canvas, calendar, n2, n4);
            }
        } else if (bl2) {
            this.onDrawSelected(canvas, calendar, n2, n4, false);
        }
        this.onDrawText(canvas, calendar, n2, n4, bl3, bl2);
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
            if (this.mDelegate.mCalendarSelectListener == null) return;
            this.mDelegate.mCalendarSelectListener.onCalendarOutOfRange((Calendar)view);
            return;
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
        if (this.mDelegate.mCalendarSelectListener == null) return;
        this.mDelegate.mCalendarSelectListener.onCalendarSelect((Calendar)view, true);
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
        while (n3 < this.mLineCount) {
            for (int i = 0; i < 7; ++n2, ++i) {
                Calendar calendar = (Calendar)this.mItems.get(n2);
                if (this.mDelegate.getMonthViewShowMode() == 1) {
                    if (n2 > this.mItems.size() - this.mNextDiff) {
                        return;
                    }
                    if (!calendar.isCurrentMonth()) {
                        continue;
                    }
                } else if (this.mDelegate.getMonthViewShowMode() == 2 && n2 >= n * 7) {
                    return;
                }
                this.draw(canvas, calendar, n3, i, n2);
            }
            ++n3;
        }
    }

    protected abstract void onDrawScheme(Canvas var1, Calendar var2, int var3, int var4);

    protected abstract boolean onDrawSelected(Canvas var1, Calendar var2, int var3, int var4, boolean var5);

    protected abstract void onDrawText(Canvas var1, Calendar var2, int var3, int var4, boolean var5, boolean var6);

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
        if (this.mDelegate.getMonthViewShowMode() == 1 && !view.isCurrentMonth()) {
            return false;
        }
        if (this.onCalendarIntercept((Calendar)view)) {
            this.mDelegate.mCalendarInterceptListener.onCalendarInterceptClick((Calendar)view, true);
            return false;
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
