/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.ColorStateList
 *  android.content.res.Resources
 *  android.content.res.Resources$Theme
 *  android.graphics.drawable.Drawable
 *  android.os.Build$VERSION
 *  android.util.Log
 *  android.util.SparseArray
 *  androidx.appcompat.content.res.AppCompatResources$ColorStateListCacheEntry
 *  androidx.appcompat.widget.ResourceManagerInternal
 *  androidx.core.content.ContextCompat
 *  androidx.core.content.res.ColorStateListInflaterCompat
 */
package androidx.appcompat.content.res;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.XmlResourceParser;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.Log;
import android.util.SparseArray;
import android.util.TypedValue;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.appcompat.widget.ResourceManagerInternal;
import androidx.core.content.ContextCompat;
import androidx.core.content.res.ColorStateListInflaterCompat;
import java.util.WeakHashMap;
import org.xmlpull.v1.XmlPullParser;

public final class AppCompatResources {
    private static final String LOG_TAG = "AppCompatResources";
    private static final ThreadLocal<TypedValue> TL_TYPED_VALUE = new ThreadLocal();
    private static final Object sColorStateCacheLock;
    private static final WeakHashMap<Context, SparseArray<ColorStateListCacheEntry>> sColorStateCaches;

    static {
        sColorStateCaches = new WeakHashMap(0);
        sColorStateCacheLock = new Object();
    }

    private AppCompatResources() {
    }

    private static void addColorStateListToCache(Context context, int n, ColorStateList colorStateList) {
        Object object = sColorStateCacheLock;
        synchronized (object) {
            SparseArray sparseArray;
            SparseArray sparseArray2 = sparseArray = sColorStateCaches.get(context);
            if (sparseArray == null) {
                sparseArray2 = new SparseArray();
                sColorStateCaches.put(context, (SparseArray<ColorStateListCacheEntry>)sparseArray2);
            }
            sparseArray = new ColorStateListCacheEntry(colorStateList, context.getResources().getConfiguration());
            sparseArray2.append(n, (Object)sparseArray);
            return;
        }
    }

    private static ColorStateList getCachedColorStateList(Context context, int n) {
        Object object = sColorStateCacheLock;
        synchronized (object) {
            SparseArray<ColorStateListCacheEntry> sparseArray = sColorStateCaches.get(context);
            if (sparseArray == null) return null;
            if (sparseArray.size() <= 0) return null;
            ColorStateListCacheEntry colorStateListCacheEntry = (ColorStateListCacheEntry)sparseArray.get(n);
            if (colorStateListCacheEntry == null) return null;
            if (colorStateListCacheEntry.configuration.equals(context.getResources().getConfiguration())) {
                context = colorStateListCacheEntry.value;
                return context;
            }
            sparseArray.remove(n);
            return null;
        }
    }

    public static ColorStateList getColorStateList(Context context, int n) {
        if (Build.VERSION.SDK_INT >= 23) {
            return context.getColorStateList(n);
        }
        ColorStateList colorStateList = AppCompatResources.getCachedColorStateList(context, n);
        if (colorStateList != null) {
            return colorStateList;
        }
        colorStateList = AppCompatResources.inflateColorStateList(context, n);
        if (colorStateList == null) return ContextCompat.getColorStateList((Context)context, (int)n);
        AppCompatResources.addColorStateListToCache(context, n, colorStateList);
        return colorStateList;
    }

    public static Drawable getDrawable(Context context, int n) {
        return ResourceManagerInternal.get().getDrawable(context, n);
    }

    private static TypedValue getTypedValue() {
        TypedValue typedValue;
        TypedValue typedValue2 = typedValue = TL_TYPED_VALUE.get();
        if (typedValue != null) return typedValue2;
        typedValue2 = new TypedValue();
        TL_TYPED_VALUE.set(typedValue2);
        return typedValue2;
    }

    private static ColorStateList inflateColorStateList(Context context, int n) {
        if (AppCompatResources.isColorInt(context, n)) {
            return null;
        }
        Resources resources = context.getResources();
        XmlResourceParser xmlResourceParser = resources.getXml(n);
        try {
            context = ColorStateListInflaterCompat.createFromXml((Resources)resources, (XmlPullParser)xmlResourceParser, (Resources.Theme)context.getTheme());
            return context;
        }
        catch (Exception exception) {
            Log.e((String)LOG_TAG, (String)"Failed to inflate ColorStateList, leaving it to the framework", (Throwable)exception);
            return null;
        }
    }

    private static boolean isColorInt(Context object, int n) {
        Resources resources = object.getResources();
        object = AppCompatResources.getTypedValue();
        boolean bl = true;
        resources.getValue(n, (TypedValue)object, true);
        if (object.type >= 28 && object.type <= 31) return bl;
        bl = false;
        return bl;
    }
}
