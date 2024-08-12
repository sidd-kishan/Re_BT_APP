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
class CalendarView.6
extends AnimatorListenerAdapter {
    final CalendarView this$0;

    CalendarView.6(CalendarView calendarView) {
        this.this$0 = calendarView;
    }

    public void onAnimationEnd(Animator animator) {
        super.onAnimationEnd(animator);
        CalendarView.access$300((CalendarView)this.this$0).setVisibility(0);
    }
}
