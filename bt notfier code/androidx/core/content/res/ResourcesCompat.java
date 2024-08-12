/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.ColorStateList
 *  android.content.res.Resources
 *  android.content.res.Resources$NotFoundException
 *  android.content.res.Resources$Theme
 *  android.graphics.Typeface
 *  android.graphics.drawable.Drawable
 *  android.os.Build$VERSION
 *  android.os.Handler
 *  android.util.Log
 *  android.util.SparseArray
 *  androidx.core.content.res.ColorStateListInflaterCompat
 *  androidx.core.content.res.FontResourcesParserCompat
 *  androidx.core.content.res.FontResourcesParserCompat$FamilyResourceEntry
 *  androidx.core.content.res.ResourcesCompat$ColorStateListCacheEntry
 *  androidx.core.content.res.ResourcesCompat$ColorStateListCacheKey
 *  androidx.core.content.res.ResourcesCompat$FontCallback
 *  androidx.core.content.res.ResourcesCompat$ImplApi29
 *  androidx.core.graphics.TypefaceCompat
 *  androidx.core.util.Preconditions
 */
package androidx.core.content.res;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.XmlResourceParser;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Handler;
import android.util.Log;
import android.util.SparseArray;
import android.util.TypedValue;
import androidx.core.content.res.ColorStateListInflaterCompat;
import androidx.core.content.res.FontResourcesParserCompat;
import androidx.core.content.res.ResourcesCompat;
import androidx.core.graphics.TypefaceCompat;
import androidx.core.util.Preconditions;
import java.io.IOException;
import java.util.WeakHashMap;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/*
 * Exception performing whole class analysis ignored.
 */
public final class ResourcesCompat {
    public static final int ID_NULL = 0;
    private static final String TAG = "ResourcesCompat";
    private static final Object sColorStateCacheLock;
    private static final WeakHashMap<ColorStateListCacheKey, SparseArray<ColorStateListCacheEntry>> sColorStateCaches;
    private static final ThreadLocal<TypedValue> sTempTypedValue;

    static {
        sTempTypedValue = new ThreadLocal();
        sColorStateCaches = new WeakHashMap(0);
        sColorStateCacheLock = new Object();
    }

    private ResourcesCompat() {
    }

    private static void addColorStateListToCache(ColorStateListCacheKey colorStateListCacheKey, int n, ColorStateList colorStateList) {
        Object object = sColorStateCacheLock;
        synchronized (object) {
            SparseArray sparseArray;
            SparseArray sparseArray2 = sparseArray = sColorStateCaches.get(colorStateListCacheKey);
            if (sparseArray == null) {
                sparseArray2 = new SparseArray();
                sColorStateCaches.put(colorStateListCacheKey, (SparseArray<ColorStateListCacheEntry>)sparseArray2);
            }
            sparseArray = new ColorStateListCacheEntry(colorStateList, colorStateListCacheKey.mResources.getConfiguration());
            sparseArray2.append(n, (Object)sparseArray);
            return;
        }
    }

    private static ColorStateList getCachedColorStateList(ColorStateListCacheKey colorStateListCacheKey, int n) {
        Object object = sColorStateCacheLock;
        synchronized (object) {
            SparseArray<ColorStateListCacheEntry> sparseArray = sColorStateCaches.get(colorStateListCacheKey);
            if (sparseArray == null) return null;
            if (sparseArray.size() <= 0) return null;
            ColorStateListCacheEntry colorStateListCacheEntry = (ColorStateListCacheEntry)sparseArray.get(n);
            if (colorStateListCacheEntry == null) return null;
            if (colorStateListCacheEntry.mConfiguration.equals(colorStateListCacheKey.mResources.getConfiguration())) {
                colorStateListCacheKey = colorStateListCacheEntry.mValue;
                return colorStateListCacheKey;
            }
            sparseArray.remove(n);
            return null;
        }
    }

    public static Typeface getCachedFont(Context context, int n) throws Resources.NotFoundException {
        if (!context.isRestricted()) return ResourcesCompat.loadFont(context, n, new TypedValue(), 0, null, null, false, true);
        return null;
    }

    public static int getColor(Resources resources, int n, Resources.Theme theme) throws Resources.NotFoundException {
        if (Build.VERSION.SDK_INT < 23) return resources.getColor(n);
        return resources.getColor(n, theme);
    }

    public static ColorStateList getColorStateList(Resources resources, int n, Resources.Theme theme) throws Resources.NotFoundException {
        if (Build.VERSION.SDK_INT >= 23) {
            return resources.getColorStateList(n, theme);
        }
        ColorStateListCacheKey colorStateListCacheKey = new ColorStateListCacheKey(resources, theme);
        ColorStateList colorStateList = ResourcesCompat.getCachedColorStateList(colorStateListCacheKey, n);
        if (colorStateList != null) {
            return colorStateList;
        }
        if ((theme = ResourcesCompat.inflateColorStateList(resources, n, theme)) == null) return resources.getColorStateList(n);
        ResourcesCompat.addColorStateListToCache(colorStateListCacheKey, n, (ColorStateList)theme);
        return theme;
    }

    public static Drawable getDrawable(Resources resources, int n, Resources.Theme theme) throws Resources.NotFoundException {
        if (Build.VERSION.SDK_INT < 21) return resources.getDrawable(n);
        return resources.getDrawable(n, theme);
    }

    public static Drawable getDrawableForDensity(Resources resources, int n, int n2, Resources.Theme theme) throws Resources.NotFoundException {
        if (Build.VERSION.SDK_INT >= 21) {
            return resources.getDrawableForDensity(n, n2, theme);
        }
        if (Build.VERSION.SDK_INT < 15) return resources.getDrawable(n);
        return resources.getDrawableForDensity(n, n2);
    }

    public static float getFloat(Resources object, int n) {
        if (Build.VERSION.SDK_INT >= 29) {
            return ImplApi29.getFloat((Resources)object, (int)n);
        }
        TypedValue typedValue = ResourcesCompat.getTypedValue();
        object.getValue(n, typedValue, true);
        if (typedValue.type == 4) {
            return typedValue.getFloat();
        }
        object = new StringBuilder();
        ((StringBuilder)object).append("Resource ID #0x");
        ((StringBuilder)object).append(Integer.toHexString(n));
        ((StringBuilder)object).append(" type #0x");
        ((StringBuilder)object).append(Integer.toHexString(typedValue.type));
        ((StringBuilder)object).append(" is not valid");
        throw new Resources.NotFoundException(((StringBuilder)object).toString());
    }

    public static Typeface getFont(Context context, int n) throws Resources.NotFoundException {
        if (!context.isRestricted()) return ResourcesCompat.loadFont(context, n, new TypedValue(), 0, null, null, false, false);
        return null;
    }

    public static Typeface getFont(Context context, int n, TypedValue typedValue, int n2, FontCallback fontCallback) throws Resources.NotFoundException {
        if (!context.isRestricted()) return ResourcesCompat.loadFont(context, n, typedValue, n2, fontCallback, null, true, false);
        return null;
    }

    public static void getFont(Context context, int n, FontCallback fontCallback, Handler handler) throws Resources.NotFoundException {
        Preconditions.checkNotNull((Object)fontCallback);
        if (context.isRestricted()) {
            fontCallback.callbackFailAsync(-4, handler);
            return;
        }
        ResourcesCompat.loadFont(context, n, new TypedValue(), 0, fontCallback, handler, false, false);
    }

    private static TypedValue getTypedValue() {
        TypedValue typedValue;
        TypedValue typedValue2 = typedValue = sTempTypedValue.get();
        if (typedValue != null) return typedValue2;
        typedValue2 = new TypedValue();
        sTempTypedValue.set(typedValue2);
        return typedValue2;
    }

    private static ColorStateList inflateColorStateList(Resources resources, int n, Resources.Theme theme) {
        if (ResourcesCompat.isColorInt(resources, n)) {
            return null;
        }
        XmlResourceParser xmlResourceParser = resources.getXml(n);
        try {
            resources = ColorStateListInflaterCompat.createFromXml((Resources)resources, (XmlPullParser)xmlResourceParser, (Resources.Theme)theme);
            return resources;
        }
        catch (Exception exception) {
            Log.e((String)"ResourcesCompat", (String)"Failed to inflate ColorStateList, leaving it to the framework", (Throwable)exception);
            return null;
        }
    }

    private static boolean isColorInt(Resources resources, int n) {
        TypedValue typedValue = ResourcesCompat.getTypedValue();
        boolean bl = true;
        resources.getValue(n, typedValue, true);
        if (typedValue.type >= 28 && typedValue.type <= 31) return bl;
        bl = false;
        return bl;
    }

    private static Typeface loadFont(Context object, int n, TypedValue typedValue, int n2, FontCallback fontCallback, Handler handler, boolean bl, boolean bl2) {
        Resources resources = object.getResources();
        resources.getValue(n, typedValue, true);
        object = ResourcesCompat.loadFont((Context)object, resources, typedValue, n, n2, fontCallback, handler, bl, bl2);
        if (object != null) return object;
        if (fontCallback != null) return object;
        if (bl2) {
            return object;
        }
        object = new StringBuilder();
        ((StringBuilder)object).append("Font resource ID #0x");
        ((StringBuilder)object).append(Integer.toHexString(n));
        ((StringBuilder)object).append(" could not be retrieved.");
        throw new Resources.NotFoundException(((StringBuilder)object).toString());
    }

    private static Typeface loadFont(Context object, Resources object2, TypedValue object3, int n, int n2, FontCallback fontCallback, Handler handler, boolean bl, boolean bl2) {
        if (((TypedValue)object3).string == null) {
            object = new StringBuilder();
            ((StringBuilder)object).append("Resource \"");
            ((StringBuilder)object).append(object2.getResourceName(n));
            ((StringBuilder)object).append("\" (");
            ((StringBuilder)object).append(Integer.toHexString(n));
            ((StringBuilder)object).append(") is not a Font: ");
            ((StringBuilder)object).append(object3);
            throw new Resources.NotFoundException(((StringBuilder)object).toString());
        }
        object3 = ((TypedValue)object3).string.toString();
        if (!((String)object3).startsWith("res/")) {
            if (fontCallback == null) return null;
            fontCallback.callbackFailAsync(-3, handler);
            return null;
        }
        Typeface typeface = TypefaceCompat.findFromCache((Resources)object2, (int)n, (int)n2);
        if (typeface != null) {
            if (fontCallback == null) return typeface;
            fontCallback.callbackSuccessAsync(typeface, handler);
            return typeface;
        }
        if (bl2) {
            return null;
        }
        try {
            if (((String)object3).toLowerCase().endsWith(".xml")) {
                typeface = FontResourcesParserCompat.parse((XmlPullParser)object2.getXml(n), (Resources)object2);
                if (typeface != null) return TypefaceCompat.createFromResourcesFamilyXml((Context)object, (FontResourcesParserCompat.FamilyResourceEntry)typeface, (Resources)object2, (int)n, (int)n2, (FontCallback)fontCallback, (Handler)handler, (boolean)bl);
                Log.e((String)"ResourcesCompat", (String)"Failed to find font-family tag");
                if (fontCallback == null) return null;
                fontCallback.callbackFailAsync(-3, handler);
                return null;
            }
            object = TypefaceCompat.createFromResourcesFontFile((Context)object, (Resources)object2, (int)n, (String)object3, (int)n2);
            if (fontCallback == null) return object;
            if (object != null) {
                fontCallback.callbackSuccessAsync((Typeface)object, handler);
            } else {
                fontCallback.callbackFailAsync(-3, handler);
            }
            return object;
        }
        catch (IOException iOException) {
            object2 = new StringBuilder();
            ((StringBuilder)object2).append("Failed to read xml resource ");
            ((StringBuilder)object2).append((String)object3);
            Log.e((String)"ResourcesCompat", (String)((StringBuilder)object2).toString(), (Throwable)iOException);
        }
        catch (XmlPullParserException xmlPullParserException) {
            object = new StringBuilder();
            ((StringBuilder)object).append("Failed to parse xml resource ");
            ((StringBuilder)object).append((String)object3);
            Log.e((String)"ResourcesCompat", (String)((StringBuilder)object).toString(), (Throwable)xmlPullParserException);
        }
        if (fontCallback == null) return null;
        fontCallback.callbackFailAsync(-3, handler);
        return null;
    }
}
