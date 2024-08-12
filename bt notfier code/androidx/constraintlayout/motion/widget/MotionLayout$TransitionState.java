/*
 * Decompiled with CFR 0.152.
 */
package androidx.constraintlayout.motion.widget;

static final class MotionLayout.TransitionState
extends Enum<MotionLayout.TransitionState> {
    private static final MotionLayout.TransitionState[] $VALUES;
    public static final /* enum */ MotionLayout.TransitionState FINISHED;
    public static final /* enum */ MotionLayout.TransitionState MOVING;
    public static final /* enum */ MotionLayout.TransitionState SETUP;
    public static final /* enum */ MotionLayout.TransitionState UNDEFINED;

    static {
        MotionLayout.TransitionState transitionState;
        UNDEFINED = new MotionLayout.TransitionState();
        SETUP = new MotionLayout.TransitionState();
        MOVING = new MotionLayout.TransitionState();
        FINISHED = transitionState = new MotionLayout.TransitionState();
        $VALUES = new MotionLayout.TransitionState[]{UNDEFINED, SETUP, MOVING, transitionState};
    }

    public static MotionLayout.TransitionState valueOf(String string) {
        return Enum.valueOf(MotionLayout.TransitionState.class, string);
    }

    public static MotionLayout.TransitionState[] values() {
        return (MotionLayout.TransitionState[])$VALUES.clone();
    }
}
