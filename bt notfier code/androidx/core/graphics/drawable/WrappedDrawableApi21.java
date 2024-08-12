/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.res.ColorStateList
 *  android.content.res.Resources
 *  android.graphics.Outline
 *  android.graphics.PorterDuff$Mode
 *  android.graphics.Rect
 *  android.graphics.drawable.Drawable
 *  android.graphics.drawable.DrawableContainer
 *  android.graphics.drawable.GradientDrawable
 *  android.graphics.drawable.InsetDrawable
 *  android.graphics.drawable.RippleDrawable
 *  android.os.Build$VERSION
 *  android.util.Log
 *  androidx.core.graphics.drawable.WrappedDrawableApi14
 *  androidx.core.graphics.drawable.WrappedDrawableState
 */
package androidx.core.graphics.drawable;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Outline;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.DrawableContainer;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build;
import android.util.Log;
import androidx.core.graphics.drawable.WrappedDrawableApi14;
import androidx.core.graphics.drawable.WrappedDrawableState;
import java.lang.reflect.Method;

class WrappedDrawableApi21
extends WrappedDrawableApi14 {
    private static final String TAG = "WrappedDrawableApi21";
    private static Method sIsProjectedDrawableMethod;

    WrappedDrawableApi21(Drawable drawable) {
        super(drawable);
        this.findAndCacheIsProjectedDrawableMethod();
    }

    WrappedDrawableApi21(WrappedDrawableState wrappedDrawableState, Resources resources) {
        super(wrappedDrawableState, resources);
        this.findAndCacheIsProjectedDrawableMethod();
    }

    private void findAndCacheIsProjectedDrawableMethod() {
        if (sIsProjectedDrawableMethod != null) return;
        try {
            sIsProjectedDrawableMethod = Drawable.class.getDeclaredMethod("isProjected", new Class[0]);
        }
        catch (Exception exception) {
            Log.w((String)TAG, (String)"Failed to retrieve Drawable#isProjected() method", (Throwable)exception);
        }
    }

    public Rect getDirtyBounds() {
        return this.mDrawable.getDirtyBounds();
    }

    public void getOutline(Outline outline) {
        this.mDrawable.getOutline(outline);
    }

    protected boolean isCompatTintEnabled() {
        boolean bl;
        int n = Build.VERSION.SDK_INT;
        boolean bl2 = bl = false;
        if (n != 21) return bl2;
        Drawable drawable = this.mDrawable;
        if (!(drawable instanceof GradientDrawable || drawable instanceof DrawableContainer || drawable instanceof InsetDrawable)) {
            bl2 = bl;
            if (!(drawable instanceof RippleDrawable)) return bl2;
        }
        bl2 = true;
        return bl2;
    }

    public boolean isProjected() {
        if (this.mDrawable == null) return false;
        Method method = sIsProjectedDrawableMethod;
        if (method == null) return false;
        try {
            boolean bl = (Boolean)method.invoke(this.mDrawable, new Object[0]);
            return bl;
        }
        catch (Exception exception) {
            Log.w((String)TAG, (String)"Error calling Drawable#isProjected() method", (Throwable)exception);
        }
        return false;
    }

    public void setHotspot(float f, float f2) {
        this.mDrawable.setHotspot(f, f2);
    }

    public void setHotspotBounds(int n, int n2, int n3, int n4) {
        this.mDrawable.setHotspotBounds(n, n2, n3, n4);
    }

    public boolean setState(int[] nArray) {
        if (!super.setState(nArray)) return false;
        this.invalidateSelf();
        return true;
    }

    public void setTint(int n) {
        if (this.isCompatTintEnabled()) {
            super.setTint(n);
        } else {
            this.mDrawable.setTint(n);
        }
    }

    public void setTintList(ColorStateList colorStateList) {
        if (this.isCompatTintEnabled()) {
            super.setTintList(colorStateList);
        } else {
            this.mDrawable.setTintList(colorStateList);
        }
    }

    public void setTintMode(PorterDuff.Mode mode) {
        if (this.isCompatTintEnabled()) {
            super.setTintMode(mode);
        } else {
            this.mDrawable.setTintMode(mode);
        }
    }
}
