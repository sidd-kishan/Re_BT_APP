/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.res.Resources
 *  android.content.res.Resources$Theme
 *  android.graphics.drawable.Drawable
 *  android.graphics.drawable.Drawable$ConstantState
 *  android.graphics.drawable.VectorDrawable
 *  androidx.vectordrawable.graphics.drawable.VectorDrawableCompat
 */
package androidx.vectordrawable.graphics.drawable;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.VectorDrawable;
import androidx.vectordrawable.graphics.drawable.VectorDrawableCompat;

private static class VectorDrawableCompat.VectorDrawableDelegateState
extends Drawable.ConstantState {
    private final Drawable.ConstantState mDelegateState;

    public VectorDrawableCompat.VectorDrawableDelegateState(Drawable.ConstantState constantState) {
        this.mDelegateState = constantState;
    }

    public boolean canApplyTheme() {
        return this.mDelegateState.canApplyTheme();
    }

    public int getChangingConfigurations() {
        return this.mDelegateState.getChangingConfigurations();
    }

    public Drawable newDrawable() {
        VectorDrawableCompat vectorDrawableCompat = new VectorDrawableCompat();
        vectorDrawableCompat.mDelegateDrawable = (VectorDrawable)this.mDelegateState.newDrawable();
        return vectorDrawableCompat;
    }

    public Drawable newDrawable(Resources resources) {
        VectorDrawableCompat vectorDrawableCompat = new VectorDrawableCompat();
        vectorDrawableCompat.mDelegateDrawable = (VectorDrawable)this.mDelegateState.newDrawable(resources);
        return vectorDrawableCompat;
    }

    public Drawable newDrawable(Resources resources, Resources.Theme theme) {
        VectorDrawableCompat vectorDrawableCompat = new VectorDrawableCompat();
        vectorDrawableCompat.mDelegateDrawable = (VectorDrawable)this.mDelegateState.newDrawable(resources, theme);
        return vectorDrawableCompat;
    }
}
