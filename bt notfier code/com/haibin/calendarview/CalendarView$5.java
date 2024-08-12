/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.animation.Animator
 *  android.animation.AnimatorListenerAdapter
 *  com.haibin.calendarview.CalendarView
 */
package com.haibin.calendarview;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import com.haibin.calendarview.CalendarView;

/*
 * Exception performing whole class analysis ignored.
 */
class CalendarView.5
extends AnimatorListenerAdapter {
    final CalendarView this$0;

    CalendarView.5(CalendarView calendarView) {
        this.this$0 = calendarView;
    }

    public void onAnimationEnd(Animator animator) {
        super.onAnimationEnd(animator);
        if (CalendarView.access$100((CalendarView)this.this$0).mYearViewChangeListener == null) return;
        CalendarView.access$100((CalendarView)this.this$0).mYearViewChangeListener.onYearViewChange(false);
    }
}
