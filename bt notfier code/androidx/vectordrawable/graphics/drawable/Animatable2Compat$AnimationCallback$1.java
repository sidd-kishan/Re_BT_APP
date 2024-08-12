/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.graphics.drawable.Animatable2$AnimationCallback
 *  android.graphics.drawable.Drawable
 *  androidx.vectordrawable.graphics.drawable.Animatable2Compat$AnimationCallback
 */
package androidx.vectordrawable.graphics.drawable;

import android.graphics.drawable.Animatable2;
import android.graphics.drawable.Drawable;
import androidx.vectordrawable.graphics.drawable.Animatable2Compat;

class Animatable2Compat.AnimationCallback.1
extends Animatable2.AnimationCallback {
    final Animatable2Compat.AnimationCallback this$0;

    Animatable2Compat.AnimationCallback.1(Animatable2Compat.AnimationCallback animationCallback) {
        this.this$0 = animationCallback;
    }

    public void onAnimationEnd(Drawable drawable) {
        this.this$0.onAnimationEnd(drawable);
    }

    public void onAnimationStart(Drawable drawable) {
        this.this$0.onAnimationStart(drawable);
    }
}
