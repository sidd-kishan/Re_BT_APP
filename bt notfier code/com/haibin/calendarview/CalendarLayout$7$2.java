/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.animation.Animator
 *  android.animation.AnimatorListenerAdapter
 *  com.haibin.calendarview.CalendarLayout
 *  com.haibin.calendarview.CalendarLayout$7
 */
package com.haibin.calendarview;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import com.haibin.calendarview.CalendarLayout;

/*
 * Exception performing whole class analysis ignored.
 */
class CalendarLayout.2
extends AnimatorListenerAdapter {
    final CalendarLayout.7 this$1;

    CalendarLayout.2(CalendarLayout.7 var1_1) {
        this.this$1 = var1_1;
    }

    public void onAnimationEnd(Animator animator) {
        super.onAnimationEnd(animator);
        CalendarLayout.access$202((CalendarLayout)this.this$1.this$0, (boolean)false);
        CalendarLayout.access$602((CalendarLayout)this.this$1.this$0, (boolean)true);
        CalendarLayout.access$700((CalendarLayout)this.this$1.this$0);
        if (CalendarLayout.access$500((CalendarLayout)this.this$1.this$0) == null) return;
        if (CalendarLayout.access$500((CalendarLayout)this.this$1.this$0).mViewChangeListener == null) return;
        CalendarLayout.access$500((CalendarLayout)this.this$1.this$0).mViewChangeListener.onViewChange(false);
    }
}
