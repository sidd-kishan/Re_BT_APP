/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.res.Resources$Theme
 *  android.graphics.PorterDuff$Mode
 *  android.graphics.Rect
 *  android.graphics.Region
 *  android.graphics.drawable.Drawable
 *  androidx.core.graphics.drawable.DrawableCompat
 *  androidx.core.graphics.drawable.TintAwareDrawable
 */
package androidx.vectordrawable.graphics.drawable;

import android.content.res.Resources;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.drawable.Drawable;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.graphics.drawable.TintAwareDrawable;

abstract class VectorDrawableCommon
extends Drawable
implements TintAwareDrawable {
    Drawable mDelegateDrawable;

    VectorDrawableCommon() {
    }

    public void applyTheme(Resources.Theme theme) {
        Drawable drawable = this.mDelegateDrawable;
        if (drawable == null) return;
        DrawableCompat.applyTheme((Drawable)drawable, (Resources.Theme)theme);
    }

    public void clearColorFilter() {
        Drawable drawable = this.mDelegateDrawable;
        if (drawable != null) {
            drawable.clearColorFilter();
            return;
        }
        super.clearColorFilter();
    }

    public Drawable getCurrent() {
        Drawable drawable = this.mDelegateDrawable;
        if (drawable == null) return super.getCurrent();
        return drawable.getCurrent();
    }

    public int getMinimumHeight() {
        Drawable drawable = this.mDelegateDrawable;
        if (drawable == null) return super.getMinimumHeight();
        return drawable.getMinimumHeight();
    }

    public int getMinimumWidth() {
        Drawable drawable = this.mDelegateDrawable;
        if (drawable == null) return super.getMinimumWidth();
        return drawable.getMinimumWidth();
    }

    public boolean getPadding(Rect rect) {
        Drawable drawable = this.mDelegateDrawable;
        if (drawable == null) return super.getPadding(rect);
        return drawable.getPadding(rect);
    }

    public int[] getState() {
        Drawable drawable = this.mDelegateDrawable;
        if (drawable == null) return super.getState();
        return drawable.getState();
    }

    public Region getTransparentRegion() {
        Drawable drawable = this.mDelegateDrawable;
        if (drawable == null) return super.getTransparentRegion();
        return drawable.getTransparentRegion();
    }

    public void jumpToCurrentState() {
        Drawable drawable = this.mDelegateDrawable;
        if (drawable == null) return;
        DrawableCompat.jumpToCurrentState((Drawable)drawable);
    }

    protected void onBoundsChange(Rect rect) {
        Drawable drawable = this.mDelegateDrawable;
        if (drawable != null) {
            drawable.setBounds(rect);
            return;
        }
        super.onBoundsChange(rect);
    }

    protected boolean onLevelChange(int n) {
        Drawable drawable = this.mDelegateDrawable;
        if (drawable == null) return super.onLevelChange(n);
        return drawable.setLevel(n);
    }

    public void setChangingConfigurations(int n) {
        Drawable drawable = this.mDelegateDrawable;
        if (drawable != null) {
            drawable.setChangingConfigurations(n);
            return;
        }
        super.setChangingConfigurations(n);
    }

    public void setColorFilter(int n, PorterDuff.Mode mode) {
        Drawable drawable = this.mDelegateDrawable;
        if (drawable != null) {
            drawable.setColorFilter(n, mode);
            return;
        }
        super.setColorFilter(n, mode);
    }

    public void setFilterBitmap(boolean bl) {
        Drawable drawable = this.mDelegateDrawable;
        if (drawable == null) return;
        drawable.setFilterBitmap(bl);
    }

    public void setHotspot(float f, float f2) {
        Drawable drawable = this.mDelegateDrawable;
        if (drawable == null) return;
        DrawableCompat.setHotspot((Drawable)drawable, (float)f, (float)f2);
    }

    public void setHotspotBounds(int n, int n2, int n3, int n4) {
        Drawable drawable = this.mDelegateDrawable;
        if (drawable == null) return;
        DrawableCompat.setHotspotBounds((Drawable)drawable, (int)n, (int)n2, (int)n3, (int)n4);
    }

    public boolean setState(int[] nArray) {
        Drawable drawable = this.mDelegateDrawable;
        if (drawable == null) return super.setState(nArray);
        return drawable.setState(nArray);
    }
}
