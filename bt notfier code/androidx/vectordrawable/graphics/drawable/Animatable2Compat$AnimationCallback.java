/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.graphics.drawable.Animatable2$AnimationCallback
 *  android.graphics.drawable.Drawable
 */
package androidx.vectordrawable.graphics.drawable;

import android.graphics.drawable.Animatable2;
import android.graphics.drawable.Drawable;

public static abstract class Animatable2Compat.AnimationCallback {
    Animatable2.AnimationCallback mPlatformCallback;

    Animatable2.AnimationCallback getPlatformCallback() {
        if (this.mPlatformCallback != null) return this.mPlatformCallback;
        this.mPlatformCallback = new /* Unavailable Anonymous Inner Class!! */;
        return this.mPlatformCallback;
    }

    public void onAnimationEnd(Drawable drawable) {
    }

    public void onAnimationStart(Drawable drawable) {
    }
}
