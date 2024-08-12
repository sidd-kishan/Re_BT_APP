/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.graphics.drawable.Animatable
 *  androidx.vectordrawable.graphics.drawable.Animatable2Compat$AnimationCallback
 */
package androidx.vectordrawable.graphics.drawable;

import android.graphics.drawable.Animatable;
import androidx.vectordrawable.graphics.drawable.Animatable2Compat;

public interface Animatable2Compat
extends Animatable {
    public void clearAnimationCallbacks();

    public void registerAnimationCallback(AnimationCallback var1);

    public boolean unregisterAnimationCallback(AnimationCallback var1);
}
