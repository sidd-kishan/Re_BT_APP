/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.res.ColorStateList
 *  android.content.res.Resources
 *  android.graphics.Bitmap
 *  android.graphics.Bitmap$Config
 *  android.graphics.Canvas
 *  android.graphics.ColorFilter
 *  android.graphics.Paint
 *  android.graphics.PorterDuff$Mode
 *  android.graphics.Rect
 *  android.graphics.drawable.Drawable
 *  android.graphics.drawable.Drawable$ConstantState
 *  androidx.vectordrawable.graphics.drawable.VectorDrawableCompat
 *  androidx.vectordrawable.graphics.drawable.VectorDrawableCompat$VPathRenderer
 */
package androidx.vectordrawable.graphics.drawable;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import androidx.vectordrawable.graphics.drawable.VectorDrawableCompat;

private static class VectorDrawableCompat.VectorDrawableCompatState
extends Drawable.ConstantState {
    boolean mAutoMirrored;
    boolean mCacheDirty;
    boolean mCachedAutoMirrored;
    Bitmap mCachedBitmap;
    int mCachedRootAlpha;
    int[] mCachedThemeAttrs;
    ColorStateList mCachedTint;
    PorterDuff.Mode mCachedTintMode;
    int mChangingConfigurations;
    Paint mTempPaint;
    ColorStateList mTint = null;
    PorterDuff.Mode mTintMode = VectorDrawableCompat.DEFAULT_TINT_MODE;
    VectorDrawableCompat.VPathRenderer mVPathRenderer;

    public VectorDrawableCompat.VectorDrawableCompatState() {
        this.mVPathRenderer = new VectorDrawableCompat.VPathRenderer();
    }

    public VectorDrawableCompat.VectorDrawableCompatState(VectorDrawableCompat.VectorDrawableCompatState vectorDrawableCompatState) {
        if (vectorDrawableCompatState == null) return;
        this.mChangingConfigurations = vectorDrawableCompatState.mChangingConfigurations;
        this.mVPathRenderer = new VectorDrawableCompat.VPathRenderer(vectorDrawableCompatState.mVPathRenderer);
        if (vectorDrawableCompatState.mVPathRenderer.mFillPaint != null) {
            this.mVPathRenderer.mFillPaint = new Paint(vectorDrawableCompatState.mVPathRenderer.mFillPaint);
        }
        if (vectorDrawableCompatState.mVPathRenderer.mStrokePaint != null) {
            this.mVPathRenderer.mStrokePaint = new Paint(vectorDrawableCompatState.mVPathRenderer.mStrokePaint);
        }
        this.mTint = vectorDrawableCompatState.mTint;
        this.mTintMode = vectorDrawableCompatState.mTintMode;
        this.mAutoMirrored = vectorDrawableCompatState.mAutoMirrored;
    }

    public boolean canReuseBitmap(int n, int n2) {
        if (n != this.mCachedBitmap.getWidth()) return false;
        if (n2 != this.mCachedBitmap.getHeight()) return false;
        return true;
    }

    public boolean canReuseCache() {
        if (this.mCacheDirty) return false;
        if (this.mCachedTint != this.mTint) return false;
        if (this.mCachedTintMode != this.mTintMode) return false;
        if (this.mCachedAutoMirrored != this.mAutoMirrored) return false;
        if (this.mCachedRootAlpha != this.mVPathRenderer.getRootAlpha()) return false;
        return true;
    }

    public void createCachedBitmapIfNeeded(int n, int n2) {
        if (this.mCachedBitmap != null) {
            if (this.canReuseBitmap(n, n2)) return;
        }
        this.mCachedBitmap = Bitmap.createBitmap((int)n, (int)n2, (Bitmap.Config)Bitmap.Config.ARGB_8888);
        this.mCacheDirty = true;
    }

    public void drawCachedBitmapWithRootAlpha(Canvas canvas, ColorFilter colorFilter, Rect rect) {
        colorFilter = this.getPaint(colorFilter);
        canvas.drawBitmap(this.mCachedBitmap, null, rect, (Paint)colorFilter);
    }

    public int getChangingConfigurations() {
        return this.mChangingConfigurations;
    }

    public Paint getPaint(ColorFilter colorFilter) {
        if (!this.hasTranslucentRoot() && colorFilter == null) {
            return null;
        }
        if (this.mTempPaint == null) {
            Paint paint;
            this.mTempPaint = paint = new Paint();
            paint.setFilterBitmap(true);
        }
        this.mTempPaint.setAlpha(this.mVPathRenderer.getRootAlpha());
        this.mTempPaint.setColorFilter(colorFilter);
        return this.mTempPaint;
    }

    public boolean hasTranslucentRoot() {
        boolean bl = this.mVPathRenderer.getRootAlpha() < 255;
        return bl;
    }

    public boolean isStateful() {
        return this.mVPathRenderer.isStateful();
    }

    public Drawable newDrawable() {
        return new VectorDrawableCompat(this);
    }

    public Drawable newDrawable(Resources resources) {
        return new VectorDrawableCompat(this);
    }

    public boolean onStateChanged(int[] nArray) {
        boolean bl = this.mVPathRenderer.onStateChanged(nArray);
        this.mCacheDirty |= bl;
        return bl;
    }

    public void updateCacheStates() {
        this.mCachedTint = this.mTint;
        this.mCachedTintMode = this.mTintMode;
        this.mCachedRootAlpha = this.mVPathRenderer.getRootAlpha();
        this.mCachedAutoMirrored = this.mAutoMirrored;
        this.mCacheDirty = false;
    }

    public void updateCachedBitmap(int n, int n2) {
        this.mCachedBitmap.eraseColor(0);
        Canvas canvas = new Canvas(this.mCachedBitmap);
        this.mVPathRenderer.draw(canvas, n, n2, null);
    }
}
