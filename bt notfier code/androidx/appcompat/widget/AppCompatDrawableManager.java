/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.ColorStateList
 *  android.graphics.PorterDuff$Mode
 *  android.graphics.PorterDuffColorFilter
 *  android.graphics.drawable.Drawable
 *  androidx.appcompat.widget.ResourceManagerInternal
 *  androidx.appcompat.widget.ResourceManagerInternal$ResourceManagerHooks
 *  androidx.appcompat.widget.TintInfo
 *  androidx.appcompat.widget.VectorEnabledTintResources
 */
package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import androidx.appcompat.widget.ResourceManagerInternal;
import androidx.appcompat.widget.TintInfo;
import androidx.appcompat.widget.VectorEnabledTintResources;

public final class AppCompatDrawableManager {
    private static final boolean DEBUG = false;
    private static final PorterDuff.Mode DEFAULT_MODE = PorterDuff.Mode.SRC_IN;
    private static AppCompatDrawableManager INSTANCE;
    private static final String TAG = "AppCompatDrawableManag";
    private ResourceManagerInternal mResourceManager;

    static /* synthetic */ PorterDuff.Mode access$000() {
        return DEFAULT_MODE;
    }

    public static AppCompatDrawableManager get() {
        synchronized (AppCompatDrawableManager.class) {
            if (INSTANCE == null) {
                AppCompatDrawableManager.preload();
            }
            AppCompatDrawableManager appCompatDrawableManager = INSTANCE;
            return appCompatDrawableManager;
        }
    }

    public static PorterDuffColorFilter getPorterDuffColorFilter(int n, PorterDuff.Mode mode) {
        synchronized (AppCompatDrawableManager.class) {
            mode = ResourceManagerInternal.getPorterDuffColorFilter((int)n, (PorterDuff.Mode)mode);
            return mode;
        }
    }

    public static void preload() {
        synchronized (AppCompatDrawableManager.class) {
            AppCompatDrawableManager appCompatDrawableManager;
            if (INSTANCE != null) return;
            INSTANCE = appCompatDrawableManager = new AppCompatDrawableManager();
            appCompatDrawableManager.mResourceManager = ResourceManagerInternal.get();
            ResourceManagerInternal resourceManagerInternal = AppCompatDrawableManager.INSTANCE.mResourceManager;
            appCompatDrawableManager = new /* Unavailable Anonymous Inner Class!! */;
            resourceManagerInternal.setHooks((ResourceManagerInternal.ResourceManagerHooks)appCompatDrawableManager);
            return;
        }
    }

    static void tintDrawable(Drawable drawable, TintInfo tintInfo, int[] nArray) {
        ResourceManagerInternal.tintDrawable((Drawable)drawable, (TintInfo)tintInfo, (int[])nArray);
    }

    public Drawable getDrawable(Context context, int n) {
        synchronized (this) {
            context = this.mResourceManager.getDrawable(context, n);
            return context;
        }
    }

    Drawable getDrawable(Context context, int n, boolean bl) {
        synchronized (this) {
            context = this.mResourceManager.getDrawable(context, n, bl);
            return context;
        }
    }

    ColorStateList getTintList(Context context, int n) {
        synchronized (this) {
            context = this.mResourceManager.getTintList(context, n);
            return context;
        }
    }

    public void onConfigurationChanged(Context context) {
        synchronized (this) {
            this.mResourceManager.onConfigurationChanged(context);
            return;
        }
    }

    Drawable onDrawableLoadedFromResources(Context context, VectorEnabledTintResources vectorEnabledTintResources, int n) {
        synchronized (this) {
            context = this.mResourceManager.onDrawableLoadedFromResources(context, vectorEnabledTintResources, n);
            return context;
        }
    }

    boolean tintDrawableUsingColorFilter(Context context, int n, Drawable drawable) {
        return this.mResourceManager.tintDrawableUsingColorFilter(context, n, drawable);
    }
}
