/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.constraintlayout.motion.widget.MotionLayout$TransitionState
 */
package androidx.constraintlayout.motion.widget;

import androidx.constraintlayout.motion.widget.MotionLayout;

/*
 * Exception performing whole class analysis ignored.
 */
static class MotionLayout.2 {
    static final int[] $SwitchMap$androidx$constraintlayout$motion$widget$MotionLayout$TransitionState;

    /*
     * Enabled force condition propagation
     */
    static {
        int[] nArray = new int[MotionLayout.TransitionState.values().length];
        $SwitchMap$androidx$constraintlayout$motion$widget$MotionLayout$TransitionState = nArray;
        try {
            nArray[MotionLayout.TransitionState.UNDEFINED.ordinal()] = 1;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            MotionLayout.2.$SwitchMap$androidx$constraintlayout$motion$widget$MotionLayout$TransitionState[MotionLayout.TransitionState.SETUP.ordinal()] = 2;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            MotionLayout.2.$SwitchMap$androidx$constraintlayout$motion$widget$MotionLayout$TransitionState[MotionLayout.TransitionState.MOVING.ordinal()] = 3;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            MotionLayout.2.$SwitchMap$androidx$constraintlayout$motion$widget$MotionLayout$TransitionState[MotionLayout.TransitionState.FINISHED.ordinal()] = 4;
            return;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            return;
        }
    }
}
