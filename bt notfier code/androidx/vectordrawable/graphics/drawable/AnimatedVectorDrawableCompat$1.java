/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.graphics.drawable.Drawable
 *  android.graphics.drawable.Drawable$Callback
 *  androidx.vectordrawable.graphics.drawable.AnimatedVectorDrawableCompat
 */
package androidx.vectordrawable.graphics.drawable;

import android.graphics.drawable.Drawable;
import androidx.vectordrawable.graphics.drawable.AnimatedVectorDrawableCompat;

class AnimatedVectorDrawableCompat.1
implements Drawable.Callback {
    final AnimatedVectorDrawableCompat this$0;

    AnimatedVectorDrawableCompat.1(AnimatedVectorDrawableCompat animatedVectorDrawableCompat) {
        this.this$0 = animatedVectorDrawableCompat;
    }

    public void invalidateDrawable(Drawable drawable) {
        this.this$0.invalidateSelf();
    }

    public void scheduleDrawable(Drawable drawable, Runnable runnable, long l) {
        this.this$0.scheduleSelf(runnable, l);
    }

    public void unscheduleDrawable(Drawable drawable, Runnable runnable) {
        this.this$0.unscheduleSelf(runnable);
    }
}
