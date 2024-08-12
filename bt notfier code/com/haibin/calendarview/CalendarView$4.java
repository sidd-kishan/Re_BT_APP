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
class CalendarView.4
extends AnimatorListenerAdapter {
    final CalendarView this$0;
    final int val$year;

    CalendarView.4(CalendarView calendarView, int n) {
        this.this$0 = calendarView;
        this.val$year = n;
    }

    public void onAnimationEnd(Animator animator) {
        super.onAnimationEnd(animator);
        CalendarView.access$300((CalendarView)this.this$0).setVisibility(8);
        CalendarView.access$500((CalendarView)this.this$0).setVisibility(0);
        CalendarView.access$500((CalendarView)this.this$0).scrollToYear(this.val$year, false);
        if (this.this$0.mParentLayout == null) return;
        if (this.this$0.mParentLayout.mContentView == null) return;
        this.this$0.mParentLayout.expand();
    }
}
