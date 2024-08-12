/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.view.View$MeasureSpec
 *  com.haibin.calendarview.BaseView
 *  com.haibin.calendarview.Calendar
 *  com.haibin.calendarview.CalendarUtil
 *  com.haibin.calendarview.CalendarViewDelegate
 */
package com.haibin.calendarview;

import android.content.Context;
import android.view.View;
import com.haibin.calendarview.BaseView;
import com.haibin.calendarview.Calendar;
import com.haibin.calendarview.CalendarUtil;
import com.haibin.calendarview.CalendarViewDelegate;
import java.util.Iterator;

public abstract class BaseWeekView
extends BaseView {
    public BaseWeekView(Context context) {
        super(context);
    }

    final int getEdgeIndex(boolean bl) {
        int n = 0;
        int n2 = 0;
        while (true) {
            if (n2 >= this.mItems.size()) {
                n2 = n;
                if (!bl) return n2;
                n2 = 6;
                return n2;
            }
            boolean bl2 = this.isInRange((Calendar)this.mItems.get(n2));
            if (bl && bl2) {
                return n2;
            }
            if (!bl && !bl2) {
                return n2 - 1;
            }
            ++n2;
        }
    }

    protected Calendar getIndex() {
        int n;
        int n2 = n = (int)(this.mX - (float)this.mDelegate.getCalendarPadding()) / this.mItemWidth;
        if (n >= 7) {
            n2 = 6;
        }
        if ((n2 = (int)this.mY / this.mItemHeight * 7 + n2) < 0) return null;
        if (n2 >= this.mItems.size()) return null;
        return (Calendar)this.mItems.get(n2);
    }

    final boolean isMinRangeEdge(Calendar calendar) {
        java.util.Calendar calendar2 = java.util.Calendar.getInstance();
        int n = this.mDelegate.getMinYear();
        int n2 = this.mDelegate.getMinYearMonth();
        boolean bl = true;
        calendar2.set(n, n2 - 1, this.mDelegate.getMinYearDay());
        long l = calendar2.getTimeInMillis();
        calendar2.set(calendar.getYear(), calendar.getMonth() - 1, calendar.getDay());
        if (calendar2.getTimeInMillis() < l) return bl;
        bl = false;
        return bl;
    }

    protected void onDestroy() {
    }

    protected void onLoopStart(int n) {
    }

    protected void onMeasure(int n, int n2) {
        super.onMeasure(n, View.MeasureSpec.makeMeasureSpec((int)this.mItemHeight, (int)0x40000000));
    }

    protected void onPreviewHook() {
    }

    final void performClickCalendar(Calendar calendar, boolean bl) {
        Calendar calendar2;
        if (this.mParentLayout == null) return;
        if (this.mDelegate.mInnerListener == null) return;
        if (this.mItems == null) return;
        if (this.mItems.size() == 0) return;
        int n = CalendarUtil.getWeekViewIndexFromCalendar((Calendar)calendar, (int)this.mDelegate.getWeekStart());
        if (this.mItems.contains(this.mDelegate.getCurrentDay())) {
            n = CalendarUtil.getWeekViewIndexFromCalendar((Calendar)this.mDelegate.getCurrentDay(), (int)this.mDelegate.getWeekStart());
        }
        Calendar calendar3 = calendar2 = (Calendar)this.mItems.get(n);
        if (this.mDelegate.getSelectMode() != 0) {
            if (this.mItems.contains(this.mDelegate.mSelectedCalendar)) {
                calendar3 = this.mDelegate.mSelectedCalendar;
            } else {
                this.mCurrentItem = -1;
                calendar3 = calendar2;
            }
        }
        calendar2 = calendar3;
        if (!this.isInRange(calendar3)) {
            n = this.getEdgeIndex(this.isMinRangeEdge(calendar3));
            calendar2 = (Calendar)this.mItems.get(n);
        }
        calendar2.setCurrentDay(calendar2.equals((Object)this.mDelegate.getCurrentDay()));
        this.mDelegate.mInnerListener.onWeekDateSelected(calendar2, false);
        int n2 = CalendarUtil.getWeekFromDayInMonth((Calendar)calendar2, (int)this.mDelegate.getWeekStart());
        this.mParentLayout.updateSelectWeek(n2);
        if (this.mDelegate.mCalendarSelectListener != null && bl && this.mDelegate.getSelectMode() == 0) {
            this.mDelegate.mCalendarSelectListener.onCalendarSelect(calendar2, false);
        }
        this.mParentLayout.updateContentViewTranslateY();
        if (this.mDelegate.getSelectMode() == 0) {
            this.mCurrentItem = n;
        }
        if (!this.mDelegate.isShowYearSelectedLayout && this.mDelegate.mIndexCalendar != null && calendar.getYear() != this.mDelegate.mIndexCalendar.getYear() && this.mDelegate.mYearChangeListener != null) {
            this.mDelegate.mYearChangeListener.onYearChange(this.mDelegate.mIndexCalendar.getYear());
        }
        this.mDelegate.mIndexCalendar = calendar2;
        this.invalidate();
    }

    final void setSelectedCalendar(Calendar calendar) {
        if (this.mDelegate.getSelectMode() == 1 && !calendar.equals((Object)this.mDelegate.mSelectedCalendar)) {
            return;
        }
        this.mCurrentItem = this.mItems.indexOf(calendar);
    }

    final void setup(Calendar calendar) {
        this.mItems = CalendarUtil.initCalendarForWeekView((Calendar)calendar, (CalendarViewDelegate)this.mDelegate, (int)this.mDelegate.getWeekStart());
        this.addSchemesFromMap();
        this.invalidate();
    }

    void updateCurrentDate() {
        if (this.mItems == null) {
            return;
        }
        if (this.mItems.contains(this.mDelegate.getCurrentDay())) {
            Iterator iterator = this.mItems.iterator();
            while (iterator.hasNext()) {
                ((Calendar)iterator.next()).setCurrentDay(false);
            }
            int n = this.mItems.indexOf(this.mDelegate.getCurrentDay());
            ((Calendar)this.mItems.get(n)).setCurrentDay(true);
        }
        this.invalidate();
    }

    final void updateShowMode() {
        this.invalidate();
    }

    final void updateSingleSelect() {
        if (this.mItems.contains(this.mDelegate.mSelectedCalendar)) return;
        this.mCurrentItem = -1;
        this.invalidate();
    }

    final void updateWeekStart() {
        int n = (Integer)this.getTag();
        Calendar calendar = CalendarUtil.getFirstCalendarStartWithMinCalendar((int)this.mDelegate.getMinYear(), (int)this.mDelegate.getMinYearMonth(), (int)this.mDelegate.getMinYearDay(), (int)(n + 1), (int)this.mDelegate.getWeekStart());
        this.setSelectedCalendar(this.mDelegate.mSelectedCalendar);
        this.setup(calendar);
    }
}
