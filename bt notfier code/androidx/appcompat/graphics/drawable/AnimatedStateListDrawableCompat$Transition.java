/*
 * Decompiled with CFR 0.152.
 */
package androidx.appcompat.graphics.drawable;

private static abstract class AnimatedStateListDrawableCompat.Transition {
    private AnimatedStateListDrawableCompat.Transition() {
    }

    public boolean canReverse() {
        return false;
    }

    public void reverse() {
    }

    public abstract void start();

    public abstract void stop();
}
