/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.Resources
 *  android.graphics.Typeface
 *  android.os.Build$VERSION
 *  android.os.CancellationSignal
 *  android.os.Handler
 *  androidx.collection.LruCache
 *  androidx.core.content.res.FontResourcesParserCompat$FamilyResourceEntry
 *  androidx.core.content.res.FontResourcesParserCompat$FontFamilyFilesResourceEntry
 *  androidx.core.content.res.FontResourcesParserCompat$ProviderResourceEntry
 *  androidx.core.content.res.ResourcesCompat$FontCallback
 *  androidx.core.graphics.TypefaceCompat$ResourcesCallbackAdapter
 *  androidx.core.graphics.TypefaceCompatApi21Impl
 *  androidx.core.graphics.TypefaceCompatApi24Impl
 *  androidx.core.graphics.TypefaceCompatApi26Impl
 *  androidx.core.graphics.TypefaceCompatApi28Impl
 *  androidx.core.graphics.TypefaceCompatApi29Impl
 *  androidx.core.graphics.TypefaceCompatBaseImpl
 *  androidx.core.provider.FontRequest
 *  androidx.core.provider.FontsContractCompat
 *  androidx.core.provider.FontsContractCompat$FontInfo
 *  androidx.core.provider.FontsContractCompat$FontRequestCallback
 */
package androidx.core.graphics;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.os.Build;
import android.os.CancellationSignal;
import android.os.Handler;
import androidx.collection.LruCache;
import androidx.core.content.res.FontResourcesParserCompat;
import androidx.core.content.res.ResourcesCompat;
import androidx.core.graphics.TypefaceCompat;
import androidx.core.graphics.TypefaceCompatApi21Impl;
import androidx.core.graphics.TypefaceCompatApi24Impl;
import androidx.core.graphics.TypefaceCompatApi26Impl;
import androidx.core.graphics.TypefaceCompatApi28Impl;
import androidx.core.graphics.TypefaceCompatApi29Impl;
import androidx.core.graphics.TypefaceCompatBaseImpl;
import androidx.core.provider.FontRequest;
import androidx.core.provider.FontsContractCompat;

public class TypefaceCompat {
    private static final LruCache<String, Typeface> sTypefaceCache;
    private static final TypefaceCompatBaseImpl sTypefaceCompatImpl;

    static {
        sTypefaceCompatImpl = Build.VERSION.SDK_INT >= 29 ? new TypefaceCompatApi29Impl() : (Build.VERSION.SDK_INT >= 28 ? new TypefaceCompatApi28Impl() : (Build.VERSION.SDK_INT >= 26 ? new TypefaceCompatApi26Impl() : (Build.VERSION.SDK_INT >= 24 && TypefaceCompatApi24Impl.isUsable() ? new TypefaceCompatApi24Impl() : (Build.VERSION.SDK_INT >= 21 ? new TypefaceCompatApi21Impl() : new TypefaceCompatBaseImpl()))));
        sTypefaceCache = new LruCache(16);
    }

    private TypefaceCompat() {
    }

    public static void clearCache() {
        sTypefaceCache.evictAll();
    }

    public static Typeface create(Context context, Typeface typeface, int n) {
        if (context == null) throw new IllegalArgumentException("Context cannot be null");
        if (Build.VERSION.SDK_INT >= 21) return Typeface.create((Typeface)typeface, (int)n);
        if ((context = TypefaceCompat.getBestFontFromFamily(context, typeface, n)) == null) return Typeface.create((Typeface)typeface, (int)n);
        return context;
    }

    public static Typeface createFromFontInfo(Context context, CancellationSignal cancellationSignal, FontsContractCompat.FontInfo[] fontInfoArray, int n) {
        return sTypefaceCompatImpl.createFromFontInfo(context, cancellationSignal, fontInfoArray, n);
    }

    public static Typeface createFromResourcesFamilyXml(Context context, FontResourcesParserCompat.FamilyResourceEntry familyResourceEntry, Resources resources, int n, int n2, ResourcesCompat.FontCallback fontCallback, Handler handler, boolean bl) {
        if (familyResourceEntry instanceof FontResourcesParserCompat.ProviderResourceEntry) {
            Typeface typeface = TypefaceCompat.getSystemFontFamily((familyResourceEntry = (FontResourcesParserCompat.ProviderResourceEntry)familyResourceEntry).getSystemFontFamilyName());
            if (typeface != null) {
                if (fontCallback == null) return typeface;
                fontCallback.callbackSuccessAsync(typeface, handler);
                return typeface;
            }
            boolean bl2 = bl ? familyResourceEntry.getFetchStrategy() == 0 : fontCallback == null;
            int n3 = bl ? familyResourceEntry.getTimeout() : -1;
            handler = ResourcesCompat.FontCallback.getHandler((Handler)handler);
            fontCallback = new ResourcesCallbackAdapter(fontCallback);
            context = FontsContractCompat.requestFont((Context)context, (FontRequest)familyResourceEntry.getRequest(), (int)n2, (boolean)bl2, (int)n3, (Handler)handler, (FontsContractCompat.FontRequestCallback)fontCallback);
        } else {
            familyResourceEntry = sTypefaceCompatImpl.createFromFontFamilyFilesResourceEntry(context, (FontResourcesParserCompat.FontFamilyFilesResourceEntry)familyResourceEntry, resources, n2);
            context = familyResourceEntry;
            if (fontCallback != null) {
                if (familyResourceEntry != null) {
                    fontCallback.callbackSuccessAsync((Typeface)familyResourceEntry, handler);
                    context = familyResourceEntry;
                } else {
                    fontCallback.callbackFailAsync(-3, handler);
                    context = familyResourceEntry;
                }
            }
        }
        if (context == null) return context;
        sTypefaceCache.put((Object)TypefaceCompat.createResourceUid(resources, n, n2), (Object)context);
        return context;
    }

    public static Typeface createFromResourcesFontFile(Context context, Resources object, int n, String string, int n2) {
        if ((context = sTypefaceCompatImpl.createFromResourcesFontFile(context, object, n, string, n2)) == null) return context;
        object = TypefaceCompat.createResourceUid(object, n, n2);
        sTypefaceCache.put(object, (Object)context);
        return context;
    }

    private static String createResourceUid(Resources resources, int n, int n2) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(resources.getResourcePackageName(n));
        stringBuilder.append("-");
        stringBuilder.append(n);
        stringBuilder.append("-");
        stringBuilder.append(n2);
        return stringBuilder.toString();
    }

    public static Typeface findFromCache(Resources resources, int n, int n2) {
        return (Typeface)sTypefaceCache.get((Object)TypefaceCompat.createResourceUid(resources, n, n2));
    }

    private static Typeface getBestFontFromFamily(Context context, Typeface typeface, int n) {
        if ((typeface = sTypefaceCompatImpl.getFontFamily(typeface)) != null) return sTypefaceCompatImpl.createFromFontFamilyFilesResourceEntry(context, (FontResourcesParserCompat.FontFamilyFilesResourceEntry)typeface, context.getResources(), n);
        return null;
    }

    private static Typeface getSystemFontFamily(String string) {
        String string2;
        String string3 = string2 = null;
        if (string == null) return string3;
        if (string.isEmpty()) {
            string3 = string2;
        } else {
            string = Typeface.create((String)string, (int)0);
            Typeface typeface = Typeface.create((Typeface)Typeface.DEFAULT, (int)0);
            string3 = string2;
            if (string == null) return string3;
            string3 = string2;
            if (string.equals((Object)typeface)) return string3;
            string3 = string;
        }
        return string3;
    }
}
