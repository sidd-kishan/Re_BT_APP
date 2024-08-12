/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.res.ColorStateList
 *  android.graphics.Canvas
 *  android.graphics.ColorFilter
 *  android.graphics.PorterDuff$Mode
 *  android.graphics.Rect
 *  android.graphics.Region
 *  android.graphics.drawable.Drawable
 *  android.graphics.drawable.Drawable$Callback
 *  androidx.core.graphics.drawable.DrawableCompat
 */
package androidx.appcompat.graphics.drawable;

import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.drawable.Drawable;
import androidx.core.graphics.drawable.DrawableCompat;

public class DrawableWrapper
extends Drawable
implements Drawable.Callback {
    private Drawable mDrawable;

    public DrawableWrapper(Drawable drawable) {
        this.setWrappedDrawable(drawable);
    }

    public void draw(Canvas canvas) {
        this.mDrawable.draw(canvas);
    }

    public int getChangingConfigurations() {
        return this.mDrawable.getChangingConfigurations();
    }

    public Drawable getCurrent() {
        return this.mDrawable.getCurrent();
    }

    public int getIntrinsicHeight() {
        return this.mDrawable.getIntrinsicHeight();
    }

    public int getIntrinsicWidth() {
        return this.mDrawable.getIntrinsicWidth();
    }

    public int getMinimumHeight() {
        return this.mDrawable.getMinimumHeight();
    }

    public int getMinimumWidth() {
        return this.mDrawable.getMinimumWidth();
    }

    public int getOpacity() {
        return this.mDrawable.getOpacity();
    }

    public boolean getPadding(Rect rect) {
        return this.mDrawable.getPadding(rect);
    }

    public int[] getState() {
        return this.mDrawable.getState();
    }

    public Region getTransparentRegion() {
        return this.mDrawable.getTransparentRegion();
    }

    public Drawable getWrappedDrawable() {
        return this.mDrawable;
    }

    public void invalidateDrawable(Drawable drawable) {
        this.invalidateSelf();
    }

    public boolean isAutoMirrored() {
        return DrawableCompat.isAutoMirrored((Drawable)this.mDrawable);
    }

    public boolean isStateful() {
        return this.mDrawable.isStateful();
    }

    public void jumpToCurrentState() {
        this.mDrawable.jumpToCurrentState();
    }

    protected void onBoundsChange(Rect rect) {
        this.mDrawable.setBounds(rect);
    }

    protected boolean onLevelChange(int n) {
        return this.mDrawable.setLevel(n);
    }

    public void scheduleDrawable(Drawable drawable, Runnable runnable, long l) {
        this.scheduleSelf(runnable, l);
    }

    public void setAlpha(int n) {
        this.mDrawable.setAlpha(n);
    }

    public void setAutoMirrored(boolean bl) {
        DrawableCompat.setAutoMirrored((Drawable)this.mDrawable, (boolean)bl);
    }

    public void setChangingConfigurations(int n) {
        this.mDrawable.setChangingConfigurations(n);
    }

    public void setColorFilter(ColorFilter colorFilter) {
        this.mDrawable.setColorFilter(colorFilter);
    }

    public void setDither(boolean bl) {
        this.mDrawable.setDither(bl);
    }

    public void setFilterBitmap(boolean bl) {
        this.mDrawable.setFilterBitmap(bl);
    }

    public void setHotspot(float f, float f2) {
        DrawableCompat.setHotspot((Drawable)this.mDrawable, (float)f, (float)f2);
    }

    public void setHotspotBounds(int n, int n2, int n3, int n4) {
        DrawableCompat.setHotspotBounds((Drawable)this.mDrawable, (int)n, (int)n2, (int)n3, (int)n4);
    }

    public boolean setState(int[] nArray) {
        return this.mDrawable.setState(nArray);
    }

    public void setTint(int n) {
        DrawableCompat.setTint((Drawable)this.mDrawable, (int)n);
    }

    public void setTintList(ColorStateList colorStateList) {
        DrawableCompat.setTintList((Drawable)this.mDrawable, (ColorStateList)colorStateList);
    }

    public void setTintMode(PorterDuff.Mode mode) {
        DrawableCompat.setTintMode((Drawable)this.mDrawable, (PorterDuff.Mode)mode);
    }

    public boolean setVisible(boolean bl, boolean bl2) {
        bl = super.setVisible(bl, bl2) || this.mDrawable.setVisible(bl, bl2);
        return bl;
    }

    public void setWrappedDrawable(Drawable drawable) {
        Drawable drawable2 = this.mDrawable;
        if (drawable2 != null) {
            drawable2.setCallback(null);
        }
        this.mDrawable = drawable;
        if (drawable == null) return;
        drawable.setCallback((Drawable.Callback)this);
    }

    public void unscheduleDrawable(Drawable drawable, Runnable runnable) {
        this.unscheduleSelf(runnable);
    }
}
