/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.animation.ValueAnimator
 *  android.animation.ValueAnimator$AnimatorUpdateListener
 *  com.haibin.calendarview.CalendarLayout
 *  com.haibin.calendarview.CalendarLayout$7
 */
package com.haibin.calendarview;

import android.animation.ValueAnimator;
import com.haibin.calendarview.CalendarLayout;

/*
 * Exception performing whole class analysis ignored.
 */
class CalendarLayout.1
implements ValueAnimator.AnimatorUpdateListener {
    final CalendarLayout.7 this$1;

    CalendarLayout.1(CalendarLayout.7 var1_1) {
        this.this$1 = var1_1;
    }

    public void onAnimationUpdate(ValueAnimator valueAnimator) {
        float f = ((Float)valueAnimator.getAnimatedValue()).floatValue() * 1.0f / (float)CalendarLayout.access$000((CalendarLayout)this.this$1.this$0);
        this.this$1.this$0.mMonthView.setTranslationY((float)CalendarLayout.access$100((CalendarLayout)this.this$1.this$0) * f);
        CalendarLayout.access$202((CalendarLayout)this.this$1.this$0, (boolean)true);
    }
}
