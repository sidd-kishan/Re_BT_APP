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
class CalendarLayout.6
extends AnimatorListenerAdapter {
    final CalendarLayout this$0;

    CalendarLayout.6(CalendarLayout calendarLayout) {
        this.this$0 = calendarLayout;
    }

    public void onAnimationEnd(Animator animator) {
        super.onAnimationEnd(animator);
        CalendarLayout.access$202((CalendarLayout)this.this$0, (boolean)false);
        CalendarLayout.access$700((CalendarLayout)this.this$0);
        CalendarLayout.access$602((CalendarLayout)this.this$0, (boolean)true);
    }
}
