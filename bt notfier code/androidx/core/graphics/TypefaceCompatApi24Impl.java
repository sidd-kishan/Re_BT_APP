/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.Resources
 *  android.graphics.Typeface
 *  android.net.Uri
 *  android.os.CancellationSignal
 *  android.util.Log
 *  androidx.collection.SimpleArrayMap
 *  androidx.core.content.res.FontResourcesParserCompat$FontFamilyFilesResourceEntry
 *  androidx.core.content.res.FontResourcesParserCompat$FontFileResourceEntry
 *  androidx.core.graphics.TypefaceCompatBaseImpl
 *  androidx.core.graphics.TypefaceCompatUtil
 *  androidx.core.provider.FontsContractCompat$FontInfo
 */
package androidx.core.graphics;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.CancellationSignal;
import android.util.Log;
import androidx.collection.SimpleArrayMap;
import androidx.core.content.res.FontResourcesParserCompat;
import androidx.core.graphics.TypefaceCompatBaseImpl;
import androidx.core.graphics.TypefaceCompatUtil;
import androidx.core.provider.FontsContractCompat;
import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.Executable;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.util.List;

class TypefaceCompatApi24Impl
extends TypefaceCompatBaseImpl {
    private static final String ADD_FONT_WEIGHT_STYLE_METHOD = "addFontWeightStyle";
    private static final String CREATE_FROM_FAMILIES_WITH_DEFAULT_METHOD = "createFromFamiliesWithDefault";
    private static final String FONT_FAMILY_CLASS = "android.graphics.FontFamily";
    private static final String TAG = "TypefaceCompatApi24Impl";
    private static final Method sAddFontWeightStyle;
    private static final Method sCreateFromFamiliesWithDefault;
    private static final Class<?> sFontFamily;
    private static final Constructor<?> sFontFamilyCtor;

    static {
        Executable executable;
        Constructor<?> constructor;
        Class<?> clazz;
        Constructor<?> constructor2;
        block3: {
            constructor2 = null;
            try {
                clazz = Class.forName(FONT_FAMILY_CLASS);
                constructor = clazz.getConstructor(new Class[0]);
                Method method = clazz.getMethod(ADD_FONT_WEIGHT_STYLE_METHOD, ByteBuffer.class, Integer.TYPE, List.class, Integer.TYPE, Boolean.TYPE);
                executable = Typeface.class.getMethod(CREATE_FROM_FAMILIES_WITH_DEFAULT_METHOD, Array.newInstance(clazz, 1).getClass());
                constructor2 = constructor;
                constructor = executable;
                executable = method;
                break block3;
            }
            catch (NoSuchMethodException noSuchMethodException) {
            }
            catch (ClassNotFoundException classNotFoundException) {
                // empty catch block
            }
            Log.e((String)TAG, (String)executable.getClass().getName(), (Throwable)((Object)executable));
            clazz = null;
            executable = constructor = null;
        }
        sFontFamilyCtor = constructor2;
        sFontFamily = clazz;
        sAddFontWeightStyle = executable;
        sCreateFromFamiliesWithDefault = constructor;
    }

    TypefaceCompatApi24Impl() {
    }

    private static boolean addFontWeightStyle(Object object, ByteBuffer byteBuffer, int n, int n2, boolean bl) {
        try {
            bl = (Boolean)sAddFontWeightStyle.invoke(object, byteBuffer, n, null, n2, bl);
            return bl;
        }
        catch (IllegalAccessException | InvocationTargetException reflectiveOperationException) {
            return false;
        }
    }

    private static Typeface createFromFamiliesWithDefault(Object object) {
        try {
            Object object2 = Array.newInstance(sFontFamily, 1);
            Array.set(object2, 0, object);
            object = (Typeface)sCreateFromFamiliesWithDefault.invoke(null, object2);
            return object;
        }
        catch (IllegalAccessException | InvocationTargetException reflectiveOperationException) {
            return null;
        }
    }

    public static boolean isUsable() {
        if (sAddFontWeightStyle == null) {
            Log.w((String)TAG, (String)"Unable to collect necessary private methods.Fallback to legacy implementation.");
        }
        boolean bl = sAddFontWeightStyle != null;
        return bl;
    }

    private static Object newFamily() {
        try {
            Object obj = sFontFamilyCtor.newInstance(new Object[0]);
            return obj;
        }
        catch (IllegalAccessException | InstantiationException | InvocationTargetException reflectiveOperationException) {
            return null;
        }
    }

    public Typeface createFromFontFamilyFilesResourceEntry(Context context, FontResourcesParserCompat.FontFamilyFilesResourceEntry object, Resources resources, int n) {
        Object object2 = TypefaceCompatApi24Impl.newFamily();
        if (object2 == null) {
            return null;
        }
        FontResourcesParserCompat.FontFileResourceEntry[] fontFileResourceEntryArray = object.getEntries();
        int n2 = fontFileResourceEntryArray.length;
        n = 0;
        while (n < n2) {
            FontResourcesParserCompat.FontFileResourceEntry fontFileResourceEntry = fontFileResourceEntryArray[n];
            object = TypefaceCompatUtil.copyToDirectBuffer((Context)context, (Resources)resources, (int)fontFileResourceEntry.getResourceId());
            if (object == null) {
                return null;
            }
            if (!TypefaceCompatApi24Impl.addFontWeightStyle(object2, (ByteBuffer)object, fontFileResourceEntry.getTtcIndex(), fontFileResourceEntry.getWeight(), fontFileResourceEntry.isItalic())) {
                return null;
            }
            ++n;
        }
        return TypefaceCompatApi24Impl.createFromFamiliesWithDefault(object2);
    }

    public Typeface createFromFontInfo(Context context, CancellationSignal cancellationSignal, FontsContractCompat.FontInfo[] fontInfoArray, int n) {
        Object object = TypefaceCompatApi24Impl.newFamily();
        if (object == null) {
            return null;
        }
        SimpleArrayMap simpleArrayMap = new SimpleArrayMap();
        int n2 = fontInfoArray.length;
        int n3 = 0;
        while (true) {
            ByteBuffer byteBuffer;
            if (n3 >= n2) {
                context = TypefaceCompatApi24Impl.createFromFamiliesWithDefault(object);
                if (context != null) return Typeface.create((Typeface)context, (int)n);
                return null;
            }
            FontsContractCompat.FontInfo fontInfo = fontInfoArray[n3];
            Uri uri = fontInfo.getUri();
            ByteBuffer byteBuffer2 = byteBuffer = (ByteBuffer)simpleArrayMap.get((Object)uri);
            if (byteBuffer == null) {
                byteBuffer2 = TypefaceCompatUtil.mmap((Context)context, (CancellationSignal)cancellationSignal, (Uri)uri);
                simpleArrayMap.put((Object)uri, (Object)byteBuffer2);
            }
            if (byteBuffer2 == null) {
                return null;
            }
            if (!TypefaceCompatApi24Impl.addFontWeightStyle(object, byteBuffer2, fontInfo.getTtcIndex(), fontInfo.getWeight(), fontInfo.isItalic())) {
                return null;
            }
            ++n3;
        }
    }
}
