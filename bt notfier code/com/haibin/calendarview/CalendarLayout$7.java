/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.animation.Animator$AnimatorListener
 *  android.animation.ObjectAnimator
 *  android.animation.ValueAnimator$AnimatorUpdateListener
 *  com.haibin.calendarview.CalendarLayout
 */
package com.haibin.calendarview;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import com.haibin.calendarview.CalendarLayout;

/*
 * Exception performing whole class analysis ignored.
 */
class CalendarLayout.7
implements Runnable {
    final CalendarLayout this$0;

    CalendarLayout.7(CalendarLayout calendarLayout) {
        this.this$0 = calendarLayout;
    }

    @Override
    public void run() {
        ObjectAnimator objectAnimator = ObjectAnimator.ofFloat((Object)this.this$0.mContentView, (String)"translationY", (float[])new float[]{this.this$0.mContentView.getTranslationY(), -CalendarLayout.access$000((CalendarLayout)this.this$0)});
        objectAnimator.setDuration(0L);
        objectAnimator.addUpdateListener((ValueAnimator.AnimatorUpdateListener)new /* Unavailable Anonymous Inner Class!! */);
        objectAnimator.addListener((Animator.AnimatorListener)new /* Unavailable Anonymous Inner Class!! */);
        objectAnimator.start();
    }
}
