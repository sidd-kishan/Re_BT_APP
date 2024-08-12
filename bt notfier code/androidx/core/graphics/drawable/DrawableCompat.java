/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.res.ColorStateList
 *  android.content.res.Resources
 *  android.content.res.Resources$Theme
 *  android.graphics.ColorFilter
 *  android.graphics.PorterDuff$Mode
 *  android.graphics.drawable.Drawable
 *  android.graphics.drawable.DrawableContainer
 *  android.graphics.drawable.DrawableContainer$DrawableContainerState
 *  android.graphics.drawable.InsetDrawable
 *  android.os.Build$VERSION
 *  android.util.Log
 *  androidx.core.graphics.drawable.TintAwareDrawable
 *  androidx.core.graphics.drawable.WrappedDrawable
 *  androidx.core.graphics.drawable.WrappedDrawableApi14
 *  androidx.core.graphics.drawable.WrappedDrawableApi21
 */
package androidx.core.graphics.drawable;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.DrawableContainer;
import android.graphics.drawable.InsetDrawable;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import androidx.core.graphics.drawable.TintAwareDrawable;
import androidx.core.graphics.drawable.WrappedDrawable;
import androidx.core.graphics.drawable.WrappedDrawableApi14;
import androidx.core.graphics.drawable.WrappedDrawableApi21;
import java.io.IOException;
import java.lang.reflect.Method;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

public final class DrawableCompat {
    private static final String TAG = "DrawableCompat";
    private static Method sGetLayoutDirectionMethod;
    private static boolean sGetLayoutDirectionMethodFetched;
    private static Method sSetLayoutDirectionMethod;
    private static boolean sSetLayoutDirectionMethodFetched;

    private DrawableCompat() {
    }

    public static void applyTheme(Drawable drawable, Resources.Theme theme) {
        if (Build.VERSION.SDK_INT < 21) return;
        drawable.applyTheme(theme);
    }

    public static boolean canApplyTheme(Drawable drawable) {
        if (Build.VERSION.SDK_INT < 21) return false;
        return drawable.canApplyTheme();
    }

    /*
     * Enabled force condition propagation
     */
    public static void clearColorFilter(Drawable drawable) {
        if (Build.VERSION.SDK_INT >= 23) {
            drawable.clearColorFilter();
            return;
        }
        if (Build.VERSION.SDK_INT < 21) {
            drawable.clearColorFilter();
            return;
        }
        drawable.clearColorFilter();
        if (drawable instanceof InsetDrawable) {
            DrawableCompat.clearColorFilter(((InsetDrawable)drawable).getDrawable());
            return;
        }
        if (drawable instanceof WrappedDrawable) {
            DrawableCompat.clearColorFilter(((WrappedDrawable)drawable).getWrappedDrawable());
            return;
        }
        if (!(drawable instanceof DrawableContainer)) return;
        if ((drawable = (DrawableContainer.DrawableContainerState)((DrawableContainer)drawable).getConstantState()) == null) return;
        int n = 0;
        int n2 = drawable.getChildCount();
        while (n < n2) {
            Drawable drawable2 = drawable.getChild(n);
            if (drawable2 != null) {
                DrawableCompat.clearColorFilter(drawable2);
            }
            ++n;
        }
    }

    public static int getAlpha(Drawable drawable) {
        if (Build.VERSION.SDK_INT < 19) return 0;
        return drawable.getAlpha();
    }

    public static ColorFilter getColorFilter(Drawable drawable) {
        if (Build.VERSION.SDK_INT < 21) return null;
        return drawable.getColorFilter();
    }

    public static int getLayoutDirection(Drawable drawable) {
        Method method;
        if (Build.VERSION.SDK_INT >= 23) {
            return drawable.getLayoutDirection();
        }
        if (Build.VERSION.SDK_INT < 17) return 0;
        if (!sGetLayoutDirectionMethodFetched) {
            try {
                sGetLayoutDirectionMethod = method = Drawable.class.getDeclaredMethod("getLayoutDirection", new Class[0]);
                method.setAccessible(true);
            }
            catch (NoSuchMethodException noSuchMethodException) {
                Log.i((String)TAG, (String)"Failed to retrieve getLayoutDirection() method", (Throwable)noSuchMethodException);
            }
            sGetLayoutDirectionMethodFetched = true;
        }
        if ((method = sGetLayoutDirectionMethod) == null) return 0;
        try {
            int n = (Integer)method.invoke(drawable, new Object[0]);
            return n;
        }
        catch (Exception exception) {
            Log.i((String)TAG, (String)"Failed to invoke getLayoutDirection() via reflection", (Throwable)exception);
            sGetLayoutDirectionMethod = null;
        }
        return 0;
    }

    public static void inflate(Drawable drawable, Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) throws XmlPullParserException, IOException {
        if (Build.VERSION.SDK_INT >= 21) {
            drawable.inflate(resources, xmlPullParser, attributeSet, theme);
        } else {
            drawable.inflate(resources, xmlPullParser, attributeSet);
        }
    }

    public static boolean isAutoMirrored(Drawable drawable) {
        if (Build.VERSION.SDK_INT < 19) return false;
        return drawable.isAutoMirrored();
    }

    @Deprecated
    public static void jumpToCurrentState(Drawable drawable) {
        drawable.jumpToCurrentState();
    }

    public static void setAutoMirrored(Drawable drawable, boolean bl) {
        if (Build.VERSION.SDK_INT < 19) return;
        drawable.setAutoMirrored(bl);
    }

    public static void setHotspot(Drawable drawable, float f, float f2) {
        if (Build.VERSION.SDK_INT < 21) return;
        drawable.setHotspot(f, f2);
    }

    public static void setHotspotBounds(Drawable drawable, int n, int n2, int n3, int n4) {
        if (Build.VERSION.SDK_INT < 21) return;
        drawable.setHotspotBounds(n, n2, n3, n4);
    }

    public static boolean setLayoutDirection(Drawable drawable, int n) {
        Method method;
        if (Build.VERSION.SDK_INT >= 23) {
            return drawable.setLayoutDirection(n);
        }
        if (Build.VERSION.SDK_INT < 17) return false;
        if (!sSetLayoutDirectionMethodFetched) {
            try {
                sSetLayoutDirectionMethod = method = Drawable.class.getDeclaredMethod("setLayoutDirection", Integer.TYPE);
                method.setAccessible(true);
            }
            catch (NoSuchMethodException noSuchMethodException) {
                Log.i((String)TAG, (String)"Failed to retrieve setLayoutDirection(int) method", (Throwable)noSuchMethodException);
            }
            sSetLayoutDirectionMethodFetched = true;
        }
        if ((method = sSetLayoutDirectionMethod) == null) return false;
        try {
            method.invoke(drawable, n);
            return true;
        }
        catch (Exception exception) {
            Log.i((String)TAG, (String)"Failed to invoke setLayoutDirection(int) via reflection", (Throwable)exception);
            sSetLayoutDirectionMethod = null;
        }
        return false;
    }

    public static void setTint(Drawable drawable, int n) {
        if (Build.VERSION.SDK_INT >= 21) {
            drawable.setTint(n);
        } else {
            if (!(drawable instanceof TintAwareDrawable)) return;
            ((TintAwareDrawable)drawable).setTint(n);
        }
    }

    public static void setTintList(Drawable drawable, ColorStateList colorStateList) {
        if (Build.VERSION.SDK_INT >= 21) {
            drawable.setTintList(colorStateList);
        } else {
            if (!(drawable instanceof TintAwareDrawable)) return;
            ((TintAwareDrawable)drawable).setTintList(colorStateList);
        }
    }

    public static void setTintMode(Drawable drawable, PorterDuff.Mode mode) {
        if (Build.VERSION.SDK_INT >= 21) {
            drawable.setTintMode(mode);
        } else {
            if (!(drawable instanceof TintAwareDrawable)) return;
            ((TintAwareDrawable)drawable).setTintMode(mode);
        }
    }

    public static <T extends Drawable> T unwrap(Drawable drawable) {
        Drawable drawable2 = drawable;
        if (!(drawable instanceof WrappedDrawable)) return (T)drawable2;
        drawable2 = ((WrappedDrawable)drawable).getWrappedDrawable();
        return (T)drawable2;
    }

    public static Drawable wrap(Drawable drawable) {
        if (Build.VERSION.SDK_INT >= 23) {
            return drawable;
        }
        if (Build.VERSION.SDK_INT >= 21) {
            if (drawable instanceof TintAwareDrawable) return drawable;
            return new WrappedDrawableApi21(drawable);
        }
        if (drawable instanceof TintAwareDrawable) return drawable;
        return new WrappedDrawableApi14(drawable);
    }
}
