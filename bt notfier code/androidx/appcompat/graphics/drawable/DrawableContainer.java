/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.res.ColorStateList
 *  android.content.res.Resources
 *  android.content.res.Resources$Theme
 *  android.graphics.Canvas
 *  android.graphics.ColorFilter
 *  android.graphics.Outline
 *  android.graphics.PorterDuff$Mode
 *  android.graphics.Rect
 *  android.graphics.drawable.Drawable
 *  android.graphics.drawable.Drawable$Callback
 *  android.graphics.drawable.Drawable$ConstantState
 *  android.os.Build$VERSION
 *  android.os.SystemClock
 *  androidx.appcompat.graphics.drawable.DrawableContainer$Api21Impl
 *  androidx.appcompat.graphics.drawable.DrawableContainer$BlockInvalidateCallback
 *  androidx.appcompat.graphics.drawable.DrawableContainer$DrawableContainerState
 *  androidx.core.graphics.drawable.DrawableCompat
 */
package androidx.appcompat.graphics.drawable;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Outline;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.SystemClock;
import androidx.appcompat.graphics.drawable.DrawableContainer;
import androidx.core.graphics.drawable.DrawableCompat;

/*
 * Exception performing whole class analysis ignored.
 */
class DrawableContainer
extends Drawable
implements Drawable.Callback {
    private static final boolean DEBUG = false;
    private static final boolean DEFAULT_DITHER = true;
    private static final String TAG = "DrawableContainer";
    private int mAlpha = 255;
    private Runnable mAnimationRunnable;
    private BlockInvalidateCallback mBlockInvalidateCallback;
    private int mCurIndex = -1;
    private Drawable mCurrDrawable;
    private DrawableContainerState mDrawableContainerState;
    private long mEnterAnimationEnd;
    private long mExitAnimationEnd;
    private boolean mHasAlpha;
    private Rect mHotspotBounds;
    private Drawable mLastDrawable;
    private boolean mMutated;

    DrawableContainer() {
    }

    private void initializeDrawableForDisplay(Drawable drawable) {
        if (this.mBlockInvalidateCallback == null) {
            this.mBlockInvalidateCallback = new BlockInvalidateCallback();
        }
        drawable.setCallback((Drawable.Callback)this.mBlockInvalidateCallback.wrap(drawable.getCallback()));
        try {
            if (this.mDrawableContainerState.mEnterFadeDuration <= 0 && this.mHasAlpha) {
                drawable.setAlpha(this.mAlpha);
            }
            if (this.mDrawableContainerState.mHasColorFilter) {
                drawable.setColorFilter(this.mDrawableContainerState.mColorFilter);
            } else {
                if (this.mDrawableContainerState.mHasTintList) {
                    DrawableCompat.setTintList((Drawable)drawable, (ColorStateList)this.mDrawableContainerState.mTintList);
                }
                if (this.mDrawableContainerState.mHasTintMode) {
                    DrawableCompat.setTintMode((Drawable)drawable, (PorterDuff.Mode)this.mDrawableContainerState.mTintMode);
                }
            }
            drawable.setVisible(this.isVisible(), true);
            drawable.setDither(this.mDrawableContainerState.mDither);
            drawable.setState(this.getState());
            drawable.setLevel(this.getLevel());
            drawable.setBounds(this.getBounds());
            if (Build.VERSION.SDK_INT >= 23) {
                DrawableCompat.setLayoutDirection((Drawable)drawable, (int)DrawableCompat.getLayoutDirection((Drawable)this));
            }
            if (Build.VERSION.SDK_INT >= 19) {
                DrawableCompat.setAutoMirrored((Drawable)drawable, (boolean)this.mDrawableContainerState.mAutoMirrored);
            }
            Rect rect = this.mHotspotBounds;
            if (Build.VERSION.SDK_INT < 21) return;
            if (rect == null) return;
            DrawableCompat.setHotspotBounds((Drawable)drawable, (int)rect.left, (int)rect.top, (int)rect.right, (int)rect.bottom);
            return;
        }
        finally {
            drawable.setCallback(this.mBlockInvalidateCallback.unwrap());
        }
    }

    private boolean needsMirroring() {
        boolean bl = this.isAutoMirrored();
        boolean bl2 = true;
        if (bl && DrawableCompat.getLayoutDirection((Drawable)this) == 1) return bl2;
        bl2 = false;
        return bl2;
    }

    static int resolveDensity(Resources resources, int n) {
        if (resources != null) {
            n = resources.getDisplayMetrics().densityDpi;
        }
        int n2 = n;
        if (n != 0) return n2;
        n2 = 160;
        return n2;
    }

    void animate(boolean bl) {
        int n;
        long l;
        Drawable drawable;
        long l2;
        int n2;
        block8: {
            block6: {
                block5: {
                    block7: {
                        n2 = 1;
                        this.mHasAlpha = true;
                        l2 = SystemClock.uptimeMillis();
                        drawable = this.mCurrDrawable;
                        if (drawable == null) break block5;
                        l = this.mEnterAnimationEnd;
                        if (l == 0L) break block6;
                        if (l > l2) break block7;
                        drawable.setAlpha(this.mAlpha);
                        this.mEnterAnimationEnd = 0L;
                        break block6;
                    }
                    n = (int)((l - l2) * 255L) / this.mDrawableContainerState.mEnterFadeDuration;
                    this.mCurrDrawable.setAlpha((255 - n) * this.mAlpha / 255);
                    n = 1;
                    break block8;
                }
                this.mEnterAnimationEnd = 0L;
            }
            n = 0;
        }
        drawable = this.mLastDrawable;
        if (drawable != null) {
            l = this.mExitAnimationEnd;
            if (l != 0L) {
                if (l <= l2) {
                    drawable.setVisible(false, false);
                    this.mLastDrawable = null;
                    this.mExitAnimationEnd = 0L;
                } else {
                    n = (int)((l - l2) * 255L) / this.mDrawableContainerState.mExitFadeDuration;
                    this.mLastDrawable.setAlpha(n * this.mAlpha / 255);
                    n = n2;
                }
            }
        } else {
            this.mExitAnimationEnd = 0L;
        }
        if (!bl) return;
        if (n == 0) return;
        this.scheduleSelf(this.mAnimationRunnable, l2 + 16L);
    }

    public void applyTheme(Resources.Theme theme) {
        this.mDrawableContainerState.applyTheme(theme);
    }

    public boolean canApplyTheme() {
        return this.mDrawableContainerState.canApplyTheme();
    }

    void clearMutated() {
        this.mDrawableContainerState.clearMutated();
        this.mMutated = false;
    }

    DrawableContainerState cloneConstantState() {
        return this.mDrawableContainerState;
    }

    public void draw(Canvas canvas) {
        Drawable drawable = this.mCurrDrawable;
        if (drawable != null) {
            drawable.draw(canvas);
        }
        if ((drawable = this.mLastDrawable) == null) return;
        drawable.draw(canvas);
    }

    public int getAlpha() {
        return this.mAlpha;
    }

    public int getChangingConfigurations() {
        return super.getChangingConfigurations() | this.mDrawableContainerState.getChangingConfigurations();
    }

    public final Drawable.ConstantState getConstantState() {
        if (!this.mDrawableContainerState.canConstantState()) return null;
        this.mDrawableContainerState.mChangingConfigurations = this.getChangingConfigurations();
        return this.mDrawableContainerState;
    }

    public Drawable getCurrent() {
        return this.mCurrDrawable;
    }

    int getCurrentIndex() {
        return this.mCurIndex;
    }

    public void getHotspotBounds(Rect rect) {
        Rect rect2 = this.mHotspotBounds;
        if (rect2 != null) {
            rect.set(rect2);
        } else {
            super.getHotspotBounds(rect);
        }
    }

    public int getIntrinsicHeight() {
        if (this.mDrawableContainerState.isConstantSize()) {
            return this.mDrawableContainerState.getConstantHeight();
        }
        Drawable drawable = this.mCurrDrawable;
        int n = drawable != null ? drawable.getIntrinsicHeight() : -1;
        return n;
    }

    public int getIntrinsicWidth() {
        if (this.mDrawableContainerState.isConstantSize()) {
            return this.mDrawableContainerState.getConstantWidth();
        }
        Drawable drawable = this.mCurrDrawable;
        int n = drawable != null ? drawable.getIntrinsicWidth() : -1;
        return n;
    }

    public int getMinimumHeight() {
        if (this.mDrawableContainerState.isConstantSize()) {
            return this.mDrawableContainerState.getConstantMinimumHeight();
        }
        Drawable drawable = this.mCurrDrawable;
        int n = drawable != null ? drawable.getMinimumHeight() : 0;
        return n;
    }

    public int getMinimumWidth() {
        if (this.mDrawableContainerState.isConstantSize()) {
            return this.mDrawableContainerState.getConstantMinimumWidth();
        }
        Drawable drawable = this.mCurrDrawable;
        int n = drawable != null ? drawable.getMinimumWidth() : 0;
        return n;
    }

    public int getOpacity() {
        Drawable drawable = this.mCurrDrawable;
        int n = drawable != null && drawable.isVisible() ? this.mDrawableContainerState.getOpacity() : -2;
        return n;
    }

    public void getOutline(Outline outline) {
        Drawable drawable = this.mCurrDrawable;
        if (drawable == null) return;
        Api21Impl.getOutline((Drawable)drawable, (Outline)outline);
    }

    public boolean getPadding(Rect rect) {
        boolean bl;
        int n;
        Rect rect2 = this.mDrawableContainerState.getConstantPadding();
        if (rect2 != null) {
            rect.set(rect2);
            int n2 = rect2.left;
            int n3 = rect2.top;
            n = rect2.bottom;
            bl = (rect2.right | (n2 | n3 | n)) != 0;
        } else {
            rect2 = this.mCurrDrawable;
            bl = rect2 != null ? rect2.getPadding(rect) : super.getPadding(rect);
        }
        if (!this.needsMirroring()) return bl;
        n = rect.left;
        rect.left = rect.right;
        rect.right = n;
        return bl;
    }

    public void invalidateDrawable(Drawable drawable) {
        DrawableContainerState drawableContainerState = this.mDrawableContainerState;
        if (drawableContainerState != null) {
            drawableContainerState.invalidateCache();
        }
        if (drawable != this.mCurrDrawable) return;
        if (this.getCallback() == null) return;
        this.getCallback().invalidateDrawable((Drawable)this);
    }

    public boolean isAutoMirrored() {
        return this.mDrawableContainerState.mAutoMirrored;
    }

    public boolean isStateful() {
        return this.mDrawableContainerState.isStateful();
    }

    public void jumpToCurrentState() {
        boolean bl;
        Drawable drawable = this.mLastDrawable;
        boolean bl2 = true;
        if (drawable != null) {
            drawable.jumpToCurrentState();
            this.mLastDrawable = null;
            bl = true;
        } else {
            bl = false;
        }
        drawable = this.mCurrDrawable;
        if (drawable != null) {
            drawable.jumpToCurrentState();
            if (this.mHasAlpha) {
                this.mCurrDrawable.setAlpha(this.mAlpha);
            }
        }
        if (this.mExitAnimationEnd != 0L) {
            this.mExitAnimationEnd = 0L;
            bl = true;
        }
        if (this.mEnterAnimationEnd != 0L) {
            this.mEnterAnimationEnd = 0L;
            bl = bl2;
        }
        if (!bl) return;
        this.invalidateSelf();
    }

    public Drawable mutate() {
        if (this.mMutated) return this;
        if (super.mutate() != this) return this;
        DrawableContainerState drawableContainerState = this.cloneConstantState();
        drawableContainerState.mutate();
        this.setConstantState(drawableContainerState);
        this.mMutated = true;
        return this;
    }

    protected void onBoundsChange(Rect rect) {
        Drawable drawable = this.mLastDrawable;
        if (drawable != null) {
            drawable.setBounds(rect);
        }
        if ((drawable = this.mCurrDrawable) == null) return;
        drawable.setBounds(rect);
    }

    public boolean onLayoutDirectionChanged(int n) {
        return this.mDrawableContainerState.setLayoutDirection(n, this.getCurrentIndex());
    }

    protected boolean onLevelChange(int n) {
        Drawable drawable = this.mLastDrawable;
        if (drawable != null) {
            return drawable.setLevel(n);
        }
        drawable = this.mCurrDrawable;
        if (drawable == null) return false;
        return drawable.setLevel(n);
    }

    protected boolean onStateChange(int[] nArray) {
        Drawable drawable = this.mLastDrawable;
        if (drawable != null) {
            return drawable.setState(nArray);
        }
        drawable = this.mCurrDrawable;
        if (drawable == null) return false;
        return drawable.setState(nArray);
    }

    public void scheduleDrawable(Drawable drawable, Runnable runnable, long l) {
        if (drawable != this.mCurrDrawable) return;
        if (this.getCallback() == null) return;
        this.getCallback().scheduleDrawable((Drawable)this, runnable, l);
    }

    boolean selectDrawable(int n) {
        Object object;
        if (n == this.mCurIndex) {
            return false;
        }
        long l = SystemClock.uptimeMillis();
        if (this.mDrawableContainerState.mExitFadeDuration > 0) {
            object = this.mLastDrawable;
            if (object != null) {
                object.setVisible(false, false);
            }
            if ((object = this.mCurrDrawable) != null) {
                this.mLastDrawable = object;
                this.mExitAnimationEnd = (long)this.mDrawableContainerState.mExitFadeDuration + l;
            } else {
                this.mLastDrawable = null;
                this.mExitAnimationEnd = 0L;
            }
        } else {
            object = this.mCurrDrawable;
            if (object != null) {
                object.setVisible(false, false);
            }
        }
        if (n >= 0 && n < this.mDrawableContainerState.mNumChildren) {
            this.mCurrDrawable = object = this.mDrawableContainerState.getChild(n);
            this.mCurIndex = n;
            if (object != null) {
                if (this.mDrawableContainerState.mEnterFadeDuration > 0) {
                    this.mEnterAnimationEnd = l + (long)this.mDrawableContainerState.mEnterFadeDuration;
                }
                this.initializeDrawableForDisplay((Drawable)object);
            }
        } else {
            this.mCurrDrawable = null;
            this.mCurIndex = -1;
        }
        if (this.mEnterAnimationEnd != 0L || this.mExitAnimationEnd != 0L) {
            object = this.mAnimationRunnable;
            if (object == null) {
                this.mAnimationRunnable = new /* Unavailable Anonymous Inner Class!! */;
            } else {
                this.unscheduleSelf((Runnable)object);
            }
            this.animate(true);
        }
        this.invalidateSelf();
        return true;
    }

    public void setAlpha(int n) {
        if (this.mHasAlpha) {
            if (this.mAlpha == n) return;
        }
        this.mHasAlpha = true;
        this.mAlpha = n;
        Drawable drawable = this.mCurrDrawable;
        if (drawable == null) return;
        if (this.mEnterAnimationEnd == 0L) {
            drawable.setAlpha(n);
        } else {
            this.animate(false);
        }
    }

    public void setAutoMirrored(boolean bl) {
        if (this.mDrawableContainerState.mAutoMirrored == bl) return;
        this.mDrawableContainerState.mAutoMirrored = bl;
        Drawable drawable = this.mCurrDrawable;
        if (drawable == null) return;
        DrawableCompat.setAutoMirrored((Drawable)drawable, (boolean)this.mDrawableContainerState.mAutoMirrored);
    }

    public void setColorFilter(ColorFilter colorFilter) {
        this.mDrawableContainerState.mHasColorFilter = true;
        if (this.mDrawableContainerState.mColorFilter == colorFilter) return;
        this.mDrawableContainerState.mColorFilter = colorFilter;
        Drawable drawable = this.mCurrDrawable;
        if (drawable == null) return;
        drawable.setColorFilter(colorFilter);
    }

    void setConstantState(DrawableContainerState drawableContainerState) {
        this.mDrawableContainerState = drawableContainerState;
        int n = this.mCurIndex;
        if (n >= 0) {
            drawableContainerState = drawableContainerState.getChild(n);
            this.mCurrDrawable = drawableContainerState;
            if (drawableContainerState != null) {
                this.initializeDrawableForDisplay((Drawable)drawableContainerState);
            }
        }
        this.mLastDrawable = null;
    }

    void setCurrentIndex(int n) {
        this.selectDrawable(n);
    }

    public void setDither(boolean bl) {
        if (this.mDrawableContainerState.mDither == bl) return;
        this.mDrawableContainerState.mDither = bl;
        Drawable drawable = this.mCurrDrawable;
        if (drawable == null) return;
        drawable.setDither(this.mDrawableContainerState.mDither);
    }

    public void setEnterFadeDuration(int n) {
        this.mDrawableContainerState.mEnterFadeDuration = n;
    }

    public void setExitFadeDuration(int n) {
        this.mDrawableContainerState.mExitFadeDuration = n;
    }

    public void setHotspot(float f, float f2) {
        Drawable drawable = this.mCurrDrawable;
        if (drawable == null) return;
        DrawableCompat.setHotspot((Drawable)drawable, (float)f, (float)f2);
    }

    public void setHotspotBounds(int n, int n2, int n3, int n4) {
        Rect rect = this.mHotspotBounds;
        if (rect == null) {
            this.mHotspotBounds = new Rect(n, n2, n3, n4);
        } else {
            rect.set(n, n2, n3, n4);
        }
        rect = this.mCurrDrawable;
        if (rect == null) return;
        DrawableCompat.setHotspotBounds((Drawable)rect, (int)n, (int)n2, (int)n3, (int)n4);
    }

    public void setTintList(ColorStateList colorStateList) {
        this.mDrawableContainerState.mHasTintList = true;
        if (this.mDrawableContainerState.mTintList == colorStateList) return;
        this.mDrawableContainerState.mTintList = colorStateList;
        DrawableCompat.setTintList((Drawable)this.mCurrDrawable, (ColorStateList)colorStateList);
    }

    public void setTintMode(PorterDuff.Mode mode) {
        this.mDrawableContainerState.mHasTintMode = true;
        if (this.mDrawableContainerState.mTintMode == mode) return;
        this.mDrawableContainerState.mTintMode = mode;
        DrawableCompat.setTintMode((Drawable)this.mCurrDrawable, (PorterDuff.Mode)mode);
    }

    public boolean setVisible(boolean bl, boolean bl2) {
        boolean bl3 = super.setVisible(bl, bl2);
        Drawable drawable = this.mLastDrawable;
        if (drawable != null) {
            drawable.setVisible(bl, bl2);
        }
        if ((drawable = this.mCurrDrawable) == null) return bl3;
        drawable.setVisible(bl, bl2);
        return bl3;
    }

    public void unscheduleDrawable(Drawable drawable, Runnable runnable) {
        if (drawable != this.mCurrDrawable) return;
        if (this.getCallback() == null) return;
        this.getCallback().unscheduleDrawable((Drawable)this, runnable);
    }

    final void updateDensity(Resources resources) {
        this.mDrawableContainerState.updateDensity(resources);
    }
}
