/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.graphics.Rect
 *  android.os.Build$VERSION
 *  android.util.Log
 *  android.view.View
 *  android.view.WindowInsets
 *  androidx.core.graphics.Insets
 *  androidx.core.view.WindowInsetsCompat
 *  androidx.core.view.WindowInsetsCompat$Builder
 *  androidx.core.view.WindowInsetsCompat$Impl
 *  androidx.core.view.WindowInsetsCompat$Type
 */
package androidx.core.view;

import android.graphics.Rect;
import android.os.Build;
import android.util.Log;
import android.view.View;
import android.view.WindowInsets;
import androidx.core.graphics.Insets;
import androidx.core.view.WindowInsetsCompat;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Objects;

/*
 * Exception performing whole class analysis ignored.
 */
private static class WindowInsetsCompat.Impl20
extends WindowInsetsCompat.Impl {
    private static Class<?> sAttachInfoClass;
    private static Field sAttachInfoField;
    private static Method sGetViewRootImplMethod;
    private static Class<?> sViewRootImplClass;
    private static Field sVisibleInsetsField;
    private static boolean sVisibleRectReflectionFetched;
    private Insets[] mOverriddenInsets;
    final WindowInsets mPlatformInsets;
    Insets mRootViewVisibleInsets;
    private WindowInsetsCompat mRootWindowInsets;
    private Insets mSystemWindowInsets = null;

    WindowInsetsCompat.Impl20(WindowInsetsCompat windowInsetsCompat, WindowInsets windowInsets) {
        super(windowInsetsCompat);
        this.mPlatformInsets = windowInsets;
    }

    WindowInsetsCompat.Impl20(WindowInsetsCompat windowInsetsCompat, WindowInsetsCompat.Impl20 impl20) {
        this(windowInsetsCompat, new WindowInsets(impl20.mPlatformInsets));
    }

    private Insets getInsets(int n, boolean bl) {
        Insets insets = Insets.NONE;
        int n2 = 1;
        while (n2 <= 256) {
            if ((n & n2) != 0) {
                insets = Insets.max((Insets)insets, (Insets)this.getInsetsForType(n2, bl));
            }
            n2 <<= 1;
        }
        return insets;
    }

    private Insets getRootStableInsets() {
        WindowInsetsCompat windowInsetsCompat = this.mRootWindowInsets;
        if (windowInsetsCompat == null) return Insets.NONE;
        return windowInsetsCompat.getStableInsets();
    }

    private Insets getVisibleInsets(View object) {
        if (Build.VERSION.SDK_INT >= 30) throw new UnsupportedOperationException("getVisibleInsets() should not be called on API >= 30. Use WindowInsets.isVisible() instead.");
        if (!sVisibleRectReflectionFetched) {
            WindowInsetsCompat.Impl20.loadReflectionField();
        }
        Method method = sGetViewRootImplMethod;
        StringBuilder stringBuilder = null;
        if (method == null) return null;
        if (sAttachInfoClass == null) return null;
        if (sVisibleInsetsField == null) return null;
        try {
            object = method.invoke(object, new Object[0]);
            if (object == null) {
                object = new NullPointerException();
                Log.w((String)"WindowInsetsCompat", (String)"Failed to get visible insets. getViewRootImpl() returned null from the provided view. This means that the view is either not attached or the method has been overridden", (Throwable)object);
                return null;
            }
            object = sAttachInfoField.get(object);
            method = (Rect)sVisibleInsetsField.get(object);
            object = stringBuilder;
            if (method == null) return object;
            object = Insets.of((Rect)method);
            return object;
        }
        catch (ReflectiveOperationException reflectiveOperationException) {
            stringBuilder = new StringBuilder();
            stringBuilder.append("Failed to get visible insets. (Reflection error). ");
            stringBuilder.append(reflectiveOperationException.getMessage());
            Log.e((String)"WindowInsetsCompat", (String)stringBuilder.toString(), (Throwable)reflectiveOperationException);
        }
        return null;
    }

    private static void loadReflectionField() {
        try {
            sGetViewRootImplMethod = View.class.getDeclaredMethod("getViewRootImpl", new Class[0]);
            sViewRootImplClass = Class.forName("android.view.ViewRootImpl");
            Class<?> clazz = Class.forName("android.view.View$AttachInfo");
            sAttachInfoClass = clazz;
            sVisibleInsetsField = clazz.getDeclaredField("mVisibleInsets");
            sAttachInfoField = sViewRootImplClass.getDeclaredField("mAttachInfo");
            sVisibleInsetsField.setAccessible(true);
            sAttachInfoField.setAccessible(true);
        }
        catch (ReflectiveOperationException reflectiveOperationException) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Failed to get visible insets. (Reflection error). ");
            stringBuilder.append(reflectiveOperationException.getMessage());
            Log.e((String)"WindowInsetsCompat", (String)stringBuilder.toString(), (Throwable)reflectiveOperationException);
        }
        sVisibleRectReflectionFetched = true;
    }

    void copyRootViewBounds(View view) {
        Insets insets = this.getVisibleInsets(view);
        view = insets;
        if (insets == null) {
            view = Insets.NONE;
        }
        this.setRootViewData((Insets)view);
    }

    void copyWindowDataInto(WindowInsetsCompat windowInsetsCompat) {
        windowInsetsCompat.setRootWindowInsets(this.mRootWindowInsets);
        windowInsetsCompat.setRootViewData(this.mRootViewVisibleInsets);
    }

    public boolean equals(Object object) {
        if (!super.equals(object)) {
            return false;
        }
        object = (WindowInsetsCompat.Impl20)((Object)object);
        return Objects.equals(this.mRootViewVisibleInsets, ((WindowInsetsCompat.Impl20)((Object)object)).mRootViewVisibleInsets);
    }

    public Insets getInsets(int n) {
        return this.getInsets(n, false);
    }

    protected Insets getInsetsForType(int n, boolean bl) {
        int n2;
        if (n == 1) {
            if (!bl) return Insets.of((int)0, (int)this.getSystemWindowInsets().top, (int)0, (int)0);
            return Insets.of((int)0, (int)Math.max(this.getRootStableInsets().top, this.getSystemWindowInsets().top), (int)0, (int)0);
        }
        Insets insets = null;
        Insets insets2 = null;
        if (n != 2) {
            if (n != 8) {
                if (n == 16) return this.getSystemGestureInsets();
                if (n == 32) return this.getMandatorySystemGestureInsets();
                if (n == 64) return this.getTappableElementInsets();
                if (n != 128) {
                    return Insets.NONE;
                }
                insets = this.mRootWindowInsets;
                insets = insets != null ? insets.getDisplayCutout() : this.getDisplayCutout();
                if (insets == null) return Insets.NONE;
                return Insets.of((int)insets.getSafeInsetLeft(), (int)insets.getSafeInsetTop(), (int)insets.getSafeInsetRight(), (int)insets.getSafeInsetBottom());
            }
            Insets[] insetsArray = this.mOverriddenInsets;
            insets = insets2;
            if (insetsArray != null) {
                insets = insetsArray[WindowInsetsCompat.Type.indexOf((int)8)];
            }
            if (insets != null) {
                return insets;
            }
            insets2 = this.getSystemWindowInsets();
            insets = this.getRootStableInsets();
            if (insets2.bottom > insets.bottom) {
                return Insets.of((int)0, (int)0, (int)0, (int)insets2.bottom);
            }
            insets2 = this.mRootViewVisibleInsets;
            if (insets2 == null) return Insets.NONE;
            if (insets2.equals((Object)Insets.NONE)) return Insets.NONE;
            if (this.mRootViewVisibleInsets.bottom <= insets.bottom) return Insets.NONE;
            return Insets.of((int)0, (int)0, (int)0, (int)this.mRootViewVisibleInsets.bottom);
        }
        if (bl) {
            insets = this.getRootStableInsets();
            insets2 = this.getStableInsets();
            return Insets.of((int)Math.max(insets.left, insets2.left), (int)0, (int)Math.max(insets.right, insets2.right), (int)Math.max(insets.bottom, insets2.bottom));
        }
        insets2 = this.getSystemWindowInsets();
        WindowInsetsCompat windowInsetsCompat = this.mRootWindowInsets;
        if (windowInsetsCompat != null) {
            insets = windowInsetsCompat.getStableInsets();
        }
        n = n2 = insets2.bottom;
        if (insets == null) return Insets.of((int)insets2.left, (int)0, (int)insets2.right, (int)n);
        n = Math.min(n2, insets.bottom);
        return Insets.of((int)insets2.left, (int)0, (int)insets2.right, (int)n);
    }

    public Insets getInsetsIgnoringVisibility(int n) {
        return this.getInsets(n, true);
    }

    final Insets getSystemWindowInsets() {
        if (this.mSystemWindowInsets != null) return this.mSystemWindowInsets;
        this.mSystemWindowInsets = Insets.of((int)this.mPlatformInsets.getSystemWindowInsetLeft(), (int)this.mPlatformInsets.getSystemWindowInsetTop(), (int)this.mPlatformInsets.getSystemWindowInsetRight(), (int)this.mPlatformInsets.getSystemWindowInsetBottom());
        return this.mSystemWindowInsets;
    }

    WindowInsetsCompat inset(int n, int n2, int n3, int n4) {
        WindowInsetsCompat.Builder builder = new WindowInsetsCompat.Builder(WindowInsetsCompat.toWindowInsetsCompat((WindowInsets)this.mPlatformInsets));
        builder.setSystemWindowInsets(WindowInsetsCompat.insetInsets((Insets)this.getSystemWindowInsets(), (int)n, (int)n2, (int)n3, (int)n4));
        builder.setStableInsets(WindowInsetsCompat.insetInsets((Insets)this.getStableInsets(), (int)n, (int)n2, (int)n3, (int)n4));
        return builder.build();
    }

    boolean isRound() {
        return this.mPlatformInsets.isRound();
    }

    protected boolean isTypeVisible(int n) {
        if (n == 1) return this.getInsetsForType(n, false).equals((Object)Insets.NONE) ^ true;
        if (n == 2) return this.getInsetsForType(n, false).equals((Object)Insets.NONE) ^ true;
        if (n == 4) return false;
        if (n == 8) return this.getInsetsForType(n, false).equals((Object)Insets.NONE) ^ true;
        if (n == 128) return this.getInsetsForType(n, false).equals((Object)Insets.NONE) ^ true;
        return true;
    }

    boolean isVisible(int n) {
        int n2 = 1;
        while (n2 <= 256) {
            if ((n & n2) != 0 && !this.isTypeVisible(n2)) {
                return false;
            }
            n2 <<= 1;
        }
        return true;
    }

    public void setOverriddenInsets(Insets[] insetsArray) {
        this.mOverriddenInsets = insetsArray;
    }

    void setRootViewData(Insets insets) {
        this.mRootViewVisibleInsets = insets;
    }

    void setRootWindowInsets(WindowInsetsCompat windowInsetsCompat) {
        this.mRootWindowInsets = windowInsetsCompat;
    }
}
