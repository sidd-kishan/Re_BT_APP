/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.graphics.drawable.Drawable
 *  android.graphics.drawable.Drawable$Callback
 */
package androidx.appcompat.graphics.drawable;

import android.graphics.drawable.Drawable;

static class DrawableContainer.BlockInvalidateCallback
implements Drawable.Callback {
    private Drawable.Callback mCallback;

    DrawableContainer.BlockInvalidateCallback() {
    }

    public void invalidateDrawable(Drawable drawable) {
    }

    public void scheduleDrawable(Drawable drawable, Runnable runnable, long l) {
        Drawable.Callback callback = this.mCallback;
        if (callback == null) return;
        callback.scheduleDrawable(drawable, runnable, l);
    }

    public void unscheduleDrawable(Drawable drawable, Runnable runnable) {
        Drawable.Callback callback = this.mCallback;
        if (callback == null) return;
        callback.unscheduleDrawable(drawable, runnable);
    }

    public Drawable.Callback unwrap() {
        Drawable.Callback callback = this.mCallback;
        this.mCallback = null;
        return callback;
    }

    public DrawableContainer.BlockInvalidateCallback wrap(Drawable.Callback callback) {
        this.mCallback = callback;
        return this;
    }
}
