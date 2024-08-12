/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.icu.util.ULocale
 *  android.os.Build$VERSION
 *  android.util.Log
 */
package androidx.core.text;

import android.icu.util.ULocale;
import android.os.Build;
import android.util.Log;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Locale;

public final class ICUCompat {
    private static final String TAG = "ICUCompat";
    private static Method sAddLikelySubtagsMethod;
    private static Method sGetScriptMethod;

    static {
        if (Build.VERSION.SDK_INT < 21) {
            try {
                Class<?> clazz = Class.forName("libcore.icu.ICU");
                if (clazz == null) return;
                sGetScriptMethod = clazz.getMethod("getScript", String.class);
                sAddLikelySubtagsMethod = clazz.getMethod("addLikelySubtags", String.class);
            }
            catch (Exception exception) {
                sGetScriptMethod = null;
                sAddLikelySubtagsMethod = null;
                Log.w((String)TAG, (Throwable)exception);
            }
        } else {
            if (Build.VERSION.SDK_INT >= 24) return;
            try {
                sAddLikelySubtagsMethod = Class.forName("libcore.icu.ICU").getMethod("addLikelySubtags", Locale.class);
            }
            catch (Exception exception) {
                throw new IllegalStateException(exception);
            }
        }
    }

    private ICUCompat() {
    }

    private static String addLikelySubtags(Locale object) {
        object = ((Locale)object).toString();
        try {
            if (sAddLikelySubtagsMethod == null) return object;
            String string = (String)sAddLikelySubtagsMethod.invoke(null, object);
            return string;
        }
        catch (InvocationTargetException invocationTargetException) {
            Log.w((String)TAG, (Throwable)invocationTargetException);
        }
        catch (IllegalAccessException illegalAccessException) {
            Log.w((String)TAG, (Throwable)illegalAccessException);
        }
        return object;
    }

    private static String getScript(String string) {
        try {
            if (sGetScriptMethod == null) return null;
            string = (String)sGetScriptMethod.invoke(null, string);
            return string;
        }
        catch (InvocationTargetException invocationTargetException) {
            Log.w((String)TAG, (Throwable)invocationTargetException);
        }
        catch (IllegalAccessException illegalAccessException) {
            Log.w((String)TAG, (Throwable)illegalAccessException);
        }
        return null;
    }

    public static String maximizeAndGetScript(Locale object) {
        if (Build.VERSION.SDK_INT >= 24) {
            return ULocale.addLikelySubtags((ULocale)ULocale.forLocale((Locale)object)).getScript();
        }
        if (Build.VERSION.SDK_INT < 21) {
            if ((object = ICUCompat.addLikelySubtags((Locale)object)) == null) return null;
            return ICUCompat.getScript((String)object);
        }
        try {
            String string = ((Locale)sAddLikelySubtagsMethod.invoke(null, object)).getScript();
            return string;
        }
        catch (IllegalAccessException illegalAccessException) {
            Log.w((String)TAG, (Throwable)illegalAccessException);
        }
        catch (InvocationTargetException invocationTargetException) {
            Log.w((String)TAG, (Throwable)invocationTargetException);
        }
        return ((Locale)object).getScript();
    }
}
