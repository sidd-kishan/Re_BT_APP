/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.constraintlayout.motion.widget.MotionLayout
 */
package androidx.constraintlayout.motion.widget;

import androidx.constraintlayout.motion.widget.MotionLayout;

public static interface MotionLayout.TransitionListener {
    public void onTransitionChange(MotionLayout var1, int var2, int var3, float var4);

    public void onTransitionCompleted(MotionLayout var1, int var2);

    public void onTransitionStarted(MotionLayout var1, int var2, int var3);

    public void onTransitionTrigger(MotionLayout var1, int var2, boolean var3, float var4);
}
