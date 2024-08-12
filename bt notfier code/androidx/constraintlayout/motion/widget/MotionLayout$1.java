/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.view.View
 *  androidx.constraintlayout.motion.widget.MotionLayout
 */
package androidx.constraintlayout.motion.widget;

import android.view.View;
import androidx.constraintlayout.motion.widget.MotionLayout;

class MotionLayout.1
implements Runnable {
    final MotionLayout this$0;
    final View val$target;

    MotionLayout.1(MotionLayout motionLayout, View view) {
        this.this$0 = motionLayout;
        this.val$target = view;
    }

    @Override
    public void run() {
        this.val$target.setNestedScrollingEnabled(true);
    }
}
