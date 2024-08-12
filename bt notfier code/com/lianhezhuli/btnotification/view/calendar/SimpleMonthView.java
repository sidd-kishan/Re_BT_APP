/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.graphics.BlurMaskFilter
 *  android.graphics.BlurMaskFilter$Blur
 *  android.graphics.Canvas
 *  android.graphics.MaskFilter
 *  android.graphics.Paint
 *  android.graphics.Paint$Style
 *  com.haibin.calendarview.Calendar
 *  com.haibin.calendarview.MonthView
 */
package com.lianhezhuli.btnotification.view.calendar;

import android.content.Context;
import android.graphics.BlurMaskFilter;
import android.graphics.Canvas;
import android.graphics.MaskFilter;
import android.graphics.Paint;
import com.haibin.calendarview.Calendar;
import com.haibin.calendarview.MonthView;

public class SimpleMonthView
extends MonthView {
    private int mRadius;

    public SimpleMonthView(Context context) {
        super(context);
        this.setLayerType(1, this.mSelectedPaint);
        this.mSelectedPaint.setMaskFilter((MaskFilter)new BlurMaskFilter(25.0f, BlurMaskFilter.Blur.SOLID));
    }

    protected void onDrawScheme(Canvas canvas, Calendar calendar, int n, int n2) {
        int n3 = this.mItemWidth / 2;
        int n4 = this.mItemHeight / 2;
        canvas.drawCircle((float)(n + n3), (float)(n2 + n4), (float)this.mRadius, this.mSchemePaint);
    }

    protected boolean onDrawSelected(Canvas canvas, Calendar calendar, int n, int n2, boolean bl) {
        int n3 = this.mItemWidth / 2;
        int n4 = this.mItemHeight / 2;
        canvas.drawCircle((float)(n + n3), (float)(n2 + n4), (float)this.mRadius, this.mSelectedPaint);
        return false;
    }

    protected void onDrawText(Canvas canvas, Calendar calendar, int n, int n2, boolean bl, boolean bl2) {
        float f = this.mTextBaseLine + (float)n2;
        n += this.mItemWidth / 2;
        if (bl2) {
            canvas.drawText(String.valueOf(calendar.getDay()), (float)n, f, this.mSelectTextPaint);
        } else if (bl) {
            n2 = calendar.getDay();
            float f2 = n;
            calendar = calendar.isCurrentDay() ? this.mCurDayTextPaint : (calendar.isCurrentMonth() ? this.mSchemeTextPaint : this.mOtherMonthTextPaint);
            canvas.drawText(String.valueOf(n2), f2, f, (Paint)calendar);
        } else {
            n2 = calendar.getDay();
            float f3 = n;
            calendar = calendar.isCurrentDay() ? this.mCurDayTextPaint : (calendar.isCurrentMonth() ? this.mCurMonthTextPaint : this.mOtherMonthTextPaint);
            canvas.drawText(String.valueOf(n2), f3, f, (Paint)calendar);
        }
    }

    protected void onLoopStart(int n, int n2) {
    }

    protected void onPreviewHook() {
        this.mRadius = Math.min(this.mItemWidth, this.mItemHeight) / 5 * 2;
        this.mSchemePaint.setStyle(Paint.Style.STROKE);
    }
}
