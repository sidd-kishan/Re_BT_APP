/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.animation.Animator
 *  android.animation.AnimatorListenerAdapter
 *  com.haibin.calendarview.CalendarLayout
 */
package com.haibin.calendarview;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import com.haibin.calendarview.CalendarLayout;

/*
 * Exception performing whole class analysis ignored.
 */
class CalendarLayout.4
extends AnimatorListenerAdapter {
    final CalendarLayout this$0;

    CalendarLayout.4(CalendarLayout calendarLayout) {
        this.this$0 = calendarLayout;
    }

    public void onAnimationEnd(Animator animator) {
        super.onAnimationEnd(animator);
        CalendarLayout.access$202((CalendarLayout)this.this$0, (boolean)false);
        if (CalendarLayout.access$300((CalendarLayout)this.this$0) == 2) {
            this.this$0.requestLayout();
        }
        CalendarLayout.access$400((CalendarLayout)this.this$0, (boolean)true);
        if (CalendarLayout.access$500((CalendarLayout)this.this$0).mViewChangeListener != null && CalendarLayout.access$600((CalendarLayout)this.this$0)) {
            CalendarLayout.access$500((CalendarLayout)this.this$0).mViewChangeListener.onViewChange(true);
        }
        CalendarLayout.access$602((CalendarLayout)this.this$0, (boolean)false);
    }
}
