/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.res.Resources
 *  android.content.res.Resources$Theme
 *  android.graphics.drawable.Drawable
 *  android.graphics.drawable.Drawable$ConstantState
 *  androidx.vectordrawable.graphics.drawable.AnimatedVectorDrawableCompat
 */
package androidx.vectordrawable.graphics.drawable;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import androidx.vectordrawable.graphics.drawable.AnimatedVectorDrawableCompat;

private static class AnimatedVectorDrawableCompat.AnimatedVectorDrawableDelegateState
extends Drawable.ConstantState {
    private final Drawable.ConstantState mDelegateState;

    public AnimatedVectorDrawableCompat.AnimatedVectorDrawableDelegateState(Drawable.ConstantState constantState) {
        this.mDelegateState = constantState;
    }

    public boolean canApplyTheme() {
        return this.mDelegateState.canApplyTheme();
    }

    public int getChangingConfigurations() {
        return this.mDelegateState.getChangingConfigurations();
    }

    public Drawable newDrawable() {
        AnimatedVectorDrawableCompat animatedVectorDrawableCompat = new AnimatedVectorDrawableCompat();
        animatedVectorDrawableCompat.mDelegateDrawable = this.mDelegateState.newDrawable();
        animatedVectorDrawableCompat.mDelegateDrawable.setCallback(animatedVectorDrawableCompat.mCallback);
        return animatedVectorDrawableCompat;
    }

    public Drawable newDrawable(Resources resources) {
        AnimatedVectorDrawableCompat animatedVectorDrawableCompat = new AnimatedVectorDrawableCompat();
        animatedVectorDrawableCompat.mDelegateDrawable = this.mDelegateState.newDrawable(resources);
        animatedVectorDrawableCompat.mDelegateDrawable.setCallback(animatedVectorDrawableCompat.mCallback);
        return animatedVectorDrawableCompat;
    }

    public Drawable newDrawable(Resources resources, Resources.Theme theme) {
        AnimatedVectorDrawableCompat animatedVectorDrawableCompat = new AnimatedVectorDrawableCompat();
        animatedVectorDrawableCompat.mDelegateDrawable = this.mDelegateState.newDrawable(resources, theme);
        animatedVectorDrawableCompat.mDelegateDrawable.setCallback(animatedVectorDrawableCompat.mCallback);
        return animatedVectorDrawableCompat;
    }
}
