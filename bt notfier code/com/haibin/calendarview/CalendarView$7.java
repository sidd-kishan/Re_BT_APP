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
class CalendarView.7
extends AnimatorListenerAdapter {
    final CalendarView this$0;

    CalendarView.7(CalendarView calendarView) {
        this.this$0 = calendarView;
    }

    public void onAnimationEnd(Animator animator) {
        super.onAnimationEnd(animator);
        if (CalendarView.access$100((CalendarView)this.this$0).mYearViewChangeListener != null) {
            CalendarView.access$100((CalendarView)this.this$0).mYearViewChangeListener.onYearViewChange(true);
        }
        if (this.this$0.mParentLayout != null) {
            this.this$0.mParentLayout.showContentView();
            if (this.this$0.mParentLayout.isExpand()) {
                CalendarView.access$200((CalendarView)this.this$0).setVisibility(0);
            } else {
                CalendarView.access$000((CalendarView)this.this$0).setVisibility(0);
                this.this$0.mParentLayout.shrink();
            }
        } else {
            CalendarView.access$200((CalendarView)this.this$0).setVisibility(0);
        }
        CalendarView.access$200((CalendarView)this.this$0).clearAnimation();
    }
}
