/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.graphics.Canvas
 *  android.graphics.Paint
 *  com.haibin.calendarview.Calendar
 *  com.haibin.calendarview.CalendarUtil
 *  com.haibin.calendarview.R$array
 *  com.haibin.calendarview.YearView
 */
package com.haibin.calendarview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import com.haibin.calendarview.Calendar;
import com.haibin.calendarview.CalendarUtil;
import com.haibin.calendarview.R;
import com.haibin.calendarview.YearView;

public class DefaultYearView
extends YearView {
    private int mTextPadding;

    public DefaultYearView(Context context) {
        super(context);
        this.mTextPadding = CalendarUtil.dipToPx((Context)context, (float)3.0f);
    }

    protected void onDrawMonth(Canvas canvas, int n, int n2, int n3, int n4, int n5, int n6) {
        canvas.drawText(this.getContext().getResources().getStringArray(R.array.month_string_array)[n2 - 1], (float)(n3 + this.mItemWidth / 2 - this.mTextPadding), (float)n4 + this.mMonthTextBaseLine, this.mMonthTextPaint);
    }

    protected void onDrawScheme(Canvas canvas, Calendar calendar, int n, int n2) {
    }

    protected boolean onDrawSelected(Canvas canvas, Calendar calendar, int n, int n2, boolean bl) {
        return false;
    }

    protected void onDrawText(Canvas canvas, Calendar calendar, int n, int n2, boolean bl, boolean bl2) {
        float f = this.mTextBaseLine + (float)n2;
        n += this.mItemWidth / 2;
        if (bl2) {
            n2 = calendar.getDay();
            float f2 = n;
            calendar = bl ? this.mSchemeTextPaint : this.mSelectTextPaint;
            canvas.drawText(String.valueOf(n2), f2, f, (Paint)calendar);
        } else if (bl) {
            n2 = calendar.getDay();
            float f3 = n;
            calendar = calendar.isCurrentDay() ? this.mCurDayTextPaint : (calendar.isCurrentMonth() ? this.mSchemeTextPaint : this.mOtherMonthTextPaint);
            canvas.drawText(String.valueOf(n2), f3, f, (Paint)calendar);
        } else {
            n2 = calendar.getDay();
            float f4 = n;
            calendar = calendar.isCurrentDay() ? this.mCurDayTextPaint : (calendar.isCurrentMonth() ? this.mCurMonthTextPaint : this.mOtherMonthTextPaint);
            canvas.drawText(String.valueOf(n2), f4, f, (Paint)calendar);
        }
    }

    protected void onDrawWeek(Canvas canvas, int n, int n2, int n3, int n4, int n5) {
        canvas.drawText(this.getContext().getResources().getStringArray(R.array.year_view_week_string_array)[n], (float)(n2 + n4 / 2), (float)n3 + this.mWeekTextBaseLine, this.mWeekTextPaint);
    }
}
