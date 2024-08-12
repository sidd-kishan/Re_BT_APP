/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.appcompat.graphics.drawable.AnimatedStateListDrawableCompat$Transition
 *  androidx.vectordrawable.graphics.drawable.AnimatedVectorDrawableCompat
 */
package androidx.appcompat.graphics.drawable;

import androidx.appcompat.graphics.drawable.AnimatedStateListDrawableCompat;
import androidx.vectordrawable.graphics.drawable.AnimatedVectorDrawableCompat;

private static class AnimatedStateListDrawableCompat.AnimatedVectorDrawableTransition
extends AnimatedStateListDrawableCompat.Transition {
    private final AnimatedVectorDrawableCompat mAvd;

    AnimatedStateListDrawableCompat.AnimatedVectorDrawableTransition(AnimatedVectorDrawableCompat animatedVectorDrawableCompat) {
        super(null);
        this.mAvd = animatedVectorDrawableCompat;
    }

    public void start() {
        this.mAvd.start();
    }

    public void stop() {
        this.mAvd.stop();
    }
}
