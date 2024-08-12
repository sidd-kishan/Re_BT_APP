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

class CalendarLayout.9
extends AnimatorListenerAdapter {
    final CalendarLayout this$0;

    CalendarLayout.9(CalendarLayout calendarLayout) {
        this.this$0 = calendarLayout;
    }

    public void onAnimationEnd(Animator animator) {
        super.onAnimationEnd(animator);
        this.this$0.mContentView.setVisibility(4);
        this.this$0.mContentView.clearAnimation();
    }
}
