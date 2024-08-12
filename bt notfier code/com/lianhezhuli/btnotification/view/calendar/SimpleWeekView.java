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
 *  com.haibin.calendarview.WeekView
 */
package com.lianhezhuli.btnotification.view.calendar;

import android.content.Context;
import android.graphics.BlurMaskFilter;
import android.graphics.Canvas;
import android.graphics.MaskFilter;
import android.graphics.Paint;
import com.haibin.calendarview.Calendar;
import com.haibin.calendarview.WeekView;

public class SimpleWeekView
extends WeekView {
    private int mRadius;

    public SimpleWeekView(Context context) {
        super(context);
        this.setLayerType(1, this.mSelectedPaint);
        this.mSelectedPaint.setMaskFilter((MaskFilter)new BlurMaskFilter(25.0f, BlurMaskFilter.Blur.SOLID));
    }

    protected void onDrawScheme(Canvas canvas, Calendar calendar, int n) {
        int n2 = this.mItemWidth / 2;
        int n3 = this.mItemHeight / 2;
        canvas.drawCircle((float)(n + n2), (float)n3, (float)this.mRadius, this.mSchemePaint);
    }

    protected boolean onDrawSelected(Canvas canvas, Calendar calendar, int n, boolean bl) {
        int n2 = this.mItemWidth / 2;
        int n3 = this.mItemHeight / 2;
        canvas.drawCircle((float)(n + n2), (float)n3, (float)this.mRadius, this.mSelectedPaint);
        return false;
    }

    protected void onDrawText(Canvas canvas, Calendar calendar, int n, boolean bl, boolean bl2) {
        float f = this.mTextBaseLine;
        n += this.mItemWidth / 2;
        if (bl2) {
            canvas.drawText(String.valueOf(calendar.getDay()), (float)n, f, this.mSelectTextPaint);
        } else if (bl) {
            int n2 = calendar.getDay();
            float f2 = n;
            if (calendar.isCurrentDay()) {
                calendar = this.mCurDayTextPaint;
            } else {
                calendar.isCurrentMonth();
                calendar = this.mSchemeTextPaint;
            }
            canvas.drawText(String.valueOf(n2), f2, f, (Paint)calendar);
        } else {
            int n3 = calendar.getDay();
            float f3 = n;
            if (calendar.isCurrentDay()) {
                calendar = this.mCurDayTextPaint;
            } else {
                calendar.isCurrentMonth();
                calendar = this.mCurMonthTextPaint;
            }
            canvas.drawText(String.valueOf(n3), f3, f, (Paint)calendar);
        }
    }

    protected void onPreviewHook() {
        this.mRadius = Math.min(this.mItemWidth, this.mItemHeight) / 5 * 2;
        this.mSchemePaint.setStyle(Paint.Style.STROKE);
    }
}
