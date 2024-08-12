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
 *  com.haibin.calendarview.MonthView
 */
package com.haibin.calendarview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import com.haibin.calendarview.Calendar;
import com.haibin.calendarview.CalendarUtil;
import com.haibin.calendarview.MonthView;

public final class DefaultMonthView
extends MonthView {
    private int mPadding;
    private float mRadio;
    private float mSchemeBaseLine;
    private Paint mSchemeBasicPaint;
    private Paint mTextPaint = new Paint();

    public DefaultMonthView(Context context) {
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

    protected void onDrawScheme(Canvas canvas, Calendar calendar, int n, int n2) {
        this.mSchemeBasicPaint.setColor(calendar.getSchemeColor());
        int n3 = this.mItemWidth;
        int n4 = this.mPadding;
        float f = n3 + n - n4;
        float f2 = this.mRadio;
        canvas.drawCircle(f - f2 / 2.0f, (float)(n4 + n2) + f2, f2, this.mSchemeBasicPaint);
        canvas.drawText(calendar.getScheme(), (float)(n + this.mItemWidth - this.mPadding) - this.mRadio / 2.0f - this.getTextWidth(calendar.getScheme()) / 2.0f, (float)(n2 + this.mPadding) + this.mSchemeBaseLine, this.mTextPaint);
    }

    protected boolean onDrawSelected(Canvas canvas, Calendar calendar, int n, int n2, boolean bl) {
        this.mSelectedPaint.setStyle(Paint.Style.FILL);
        int n3 = this.mPadding;
        canvas.drawRect((float)(n + n3), (float)(n3 + n2), (float)(n + this.mItemWidth - this.mPadding), (float)(n2 + this.mItemHeight - this.mPadding), this.mSelectedPaint);
        return true;
    }

    protected void onDrawText(Canvas canvas, Calendar calendar, int n, int n2, boolean bl, boolean bl2) {
        int n3 = n + this.mItemWidth / 2;
        n = n2 - this.mItemHeight / 6;
        if (bl2) {
            int n4 = calendar.getDay();
            float f = n3;
            canvas.drawText(String.valueOf(n4), f, this.mTextBaseLine + (float)n, this.mSelectTextPaint);
            canvas.drawText(calendar.getLunar(), f, this.mTextBaseLine + (float)n2 + (float)(this.mItemHeight / 10), this.mSelectedLunarTextPaint);
        } else if (bl) {
            int n5 = calendar.getDay();
            float f = n3;
            float f2 = this.mTextBaseLine;
            float f3 = n;
            Object object = calendar.isCurrentDay() ? this.mCurDayTextPaint : (calendar.isCurrentMonth() ? this.mSchemeTextPaint : this.mOtherMonthTextPaint);
            canvas.drawText(String.valueOf(n5), f, f2 + f3, object);
            object = calendar.getLunar();
            float f4 = this.mTextBaseLine;
            f3 = n2;
            f2 = this.mItemHeight / 10;
            calendar = calendar.isCurrentDay() ? this.mCurDayLunarTextPaint : this.mSchemeLunarTextPaint;
            canvas.drawText((String)object, f, f4 + f3 + f2, (Paint)calendar);
        } else {
            int n6 = calendar.getDay();
            float f = n3;
            float f5 = this.mTextBaseLine;
            float f6 = n;
            Object object = calendar.isCurrentDay() ? this.mCurDayTextPaint : (calendar.isCurrentMonth() ? this.mCurMonthTextPaint : this.mOtherMonthTextPaint);
            canvas.drawText(String.valueOf(n6), f, f5 + f6, object);
            object = calendar.getLunar();
            f5 = this.mTextBaseLine;
            float f7 = n2;
            f6 = this.mItemHeight / 10;
            calendar = calendar.isCurrentDay() ? this.mCurDayLunarTextPaint : (calendar.isCurrentMonth() ? this.mCurMonthLunarTextPaint : this.mOtherMonthLunarTextPaint);
            canvas.drawText((String)object, f, f5 + f7 + f6, (Paint)calendar);
        }
    }
}
