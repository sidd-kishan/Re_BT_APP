/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.res.ColorStateList
 *  android.content.res.Resources
 *  android.graphics.PorterDuff$Mode
 *  android.graphics.drawable.Drawable
 *  android.graphics.drawable.Drawable$ConstantState
 *  android.os.Build$VERSION
 *  androidx.core.graphics.drawable.WrappedDrawableApi14
 *  androidx.core.graphics.drawable.WrappedDrawableApi21
 */
package androidx.core.graphics.drawable;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Build;
import androidx.core.graphics.drawable.WrappedDrawableApi14;
import androidx.core.graphics.drawable.WrappedDrawableApi21;

final class WrappedDrawableState
extends Drawable.ConstantState {
    int mChangingConfigurations;
    Drawable.ConstantState mDrawableState;
    ColorStateList mTint = null;
    PorterDuff.Mode mTintMode = WrappedDrawableApi14.DEFAULT_TINT_MODE;

    WrappedDrawableState(WrappedDrawableState wrappedDrawableState) {
        if (wrappedDrawableState == null) return;
        this.mChangingConfigurations = wrappedDrawableState.mChangingConfigurations;
        this.mDrawableState = wrappedDrawableState.mDrawableState;
        this.mTint = wrappedDrawableState.mTint;
        this.mTintMode = wrappedDrawableState.mTintMode;
    }

    boolean canConstantState() {
        boolean bl = this.mDrawableState != null;
        return bl;
    }

    public int getChangingConfigurations() {
        int n = this.mChangingConfigurations;
        Drawable.ConstantState constantState = this.mDrawableState;
        int n2 = constantState != null ? constantState.getChangingConfigurations() : 0;
        return n | n2;
    }

    public Drawable newDrawable() {
        return this.newDrawable(null);
    }

    public Drawable newDrawable(Resources resources) {
        if (Build.VERSION.SDK_INT < 21) return new WrappedDrawableApi14(this, resources);
        return new WrappedDrawableApi21(this, resources);
    }
}
