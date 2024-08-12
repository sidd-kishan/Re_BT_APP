/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.graphics.Canvas
 *  android.graphics.Paint
 *  android.graphics.Paint$Align
 *  android.graphics.Paint$Style
 *  com.haibin.calendarview.Calendar
 *  com.haibin.calendarview.CalendarUtil
 *  com.haibin.calendarview.WeekView
 */
package com.haibin.calendarview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import com.haibin.calendarview.Calendar;
import com.haibin.calendarview.CalendarUtil;
import com.haibin.calendarview.WeekView;

public final class DefaultWeekView
extends WeekView {
    private int mPadding;
    private float mRadio;
    private float mSchemeBaseLine;
    private Paint mSchemeBasicPaint;
    private Paint mTextPaint = new Paint();

    public DefaultWeekView(Context context) {
        super(context);
        this.mSchemeBasicPaint = new Paint();
        this.mTextPaint.setTextSize((float)CalendarUtil.dipToPx((Context)context, (float)8.0f));
        this.mTextPaint.setColor(-1);
        this.mTextPaint.setAntiAlias(true);
        this.mTextPaint.setFakeBoldText(true);
        this.mSchemeBasicPaint.setAntiAlias(true);
        this.mSchemeBasicPaint.setStyle(Paint.Style.FILL);
        this.mSchemeBasicPaint.setTextAlign(Paint.Align.CENTER);
        this.mSchemeBasicPaint.setColor(-1223853);
        this.mSchemeBasicPaint.setFakeBoldText(true);
        this.mRadio = CalendarUtil.dipToPx((Context)this.getContext(), (float)7.0f);
        this.mPadding = CalendarUtil.dipToPx((Context)this.getContext(), (float)4.0f);
        context = this.mSchemeBasicPaint.getFontMetrics();
        this.mSchemeBaseLine = this.mRadio - context.descent + (context.bottom - context.top) / 2.0f + (float)CalendarUtil.dipToPx((Context)this.getContext(), (float)1.0f);
    }

    private float getTextWidth(String string) {
        return this.mTextPaint.measureText(string);
    }

    protected void onDrawScheme(Canvas canvas, Calendar calendar, int n) {
        this.mSchemeBasicPaint.setColor(calendar.getSchemeColor());
        int n2 = this.mItemWidth;
        int n3 = this.mPadding;
        float f = n2 + n - n3;
        float f2 = this.mRadio;
        canvas.drawCircle(f - f2 / 2.0f, (float)n3 + f2, f2, this.mSchemeBasicPaint);
        canvas.drawText(calendar.getScheme(), (float)(n + this.mItemWidth - this.mPadding) - this.mRadio / 2.0f - this.getTextWidth(calendar.getScheme()) / 2.0f, (float)this.mPadding + this.mSchemeBaseLine, this.mTextPaint);
    }

    protected boolean onDrawSelected(Canvas canvas, Calendar calendar, int n, boolean bl) {
        this.mSelectedPaint.setStyle(Paint.Style.FILL);
        int n2 = this.mPadding;
        canvas.drawRect((float)(n + n2), (float)n2, (float)(n + this.mItemWidth - this.mPadding), (float)(this.mItemHeight - this.mPadding), this.mSelectedPaint);
        return true;
    }

    protected void onDrawText(Canvas canvas, Calendar calendar, int n, boolean bl, boolean bl2) {
        n += this.mItemWidth / 2;
        int n2 = -this.mItemHeight / 6;
        if (bl2) {
            int n3 = calendar.getDay();
            float f = n;
            canvas.drawText(String.valueOf(n3), f, this.mTextBaseLine + (float)n2, this.mSelectTextPaint);
            canvas.drawText(calendar.getLunar(), f, this.mTextBaseLine + (float)(this.mItemHeight / 10), this.mSelectedLunarTextPaint);
        } else if (bl) {
            int n4 = calendar.getDay();
            float f = n;
            float f2 = this.mTextBaseLine;
            float f3 = n2;
            Object object = calendar.isCurrentDay() ? this.mCurDayTextPaint : (calendar.isCurrentMonth() ? this.mSchemeTextPaint : this.mOtherMonthTextPaint);
            canvas.drawText(String.valueOf(n4), f, f2 + f3, object);
            object = calendar.getLunar();
            f3 = this.mTextBaseLine;
            f2 = this.mItemHeight / 10;
            calendar = calendar.isCurrentDay() ? this.mCurDayLunarTextPaint : this.mSchemeLunarTextPaint;
            canvas.drawText((String)object, f, f3 + f2, (Paint)calendar);
        } else {
            int n5 = calendar.getDay();
            float f = n;
            float f4 = this.mTextBaseLine;
            float f5 = n2;
            Object object = calendar.isCurrentDay() ? this.mCurDayTextPaint : (calendar.isCurrentMonth() ? this.mCurMonthTextPaint : this.mOtherMonthTextPaint);
            canvas.drawText(String.valueOf(n5), f, f4 + f5, object);
            object = calendar.getLunar();
            f4 = this.mTextBaseLine;
            f5 = this.mItemHeight / 10;
            calendar = calendar.isCurrentDay() ? this.mCurDayLunarTextPaint : (calendar.isCurrentMonth() ? this.mCurMonthLunarTextPaint : this.mOtherMonthLunarTextPaint);
            canvas.drawText((String)object, f, f4 + f5, (Paint)calendar);
        }
    }
}
