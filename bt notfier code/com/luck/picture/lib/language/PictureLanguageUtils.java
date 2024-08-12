/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.Configuration
 *  android.content.res.Resources
 *  android.os.Build$VERSION
 *  android.util.DisplayMetrics
 *  com.luck.picture.lib.language.LocaleTransform
 *  com.luck.picture.lib.tools.SPUtils
 */
package com.luck.picture.lib.language;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.util.DisplayMetrics;
import com.luck.picture.lib.language.LocaleTransform;
import com.luck.picture.lib.tools.SPUtils;
import java.lang.ref.Reference;
import java.lang.ref.WeakReference;
import java.util.Locale;

public class PictureLanguageUtils {
    private static final String KEY_LOCALE = "KEY_LOCALE";
    private static final String VALUE_FOLLOW_SYSTEM = "VALUE_FOLLOW_SYSTEM";

    private PictureLanguageUtils() {
        throw new UnsupportedOperationException("u can't instantiate me...");
    }

    private static void applyLanguage(Context context, Locale locale) {
        PictureLanguageUtils.applyLanguage(context, locale, false);
    }

    private static void applyLanguage(Context context, Locale locale, boolean bl) {
        if (bl) {
            SPUtils.getPictureSpUtils().put(KEY_LOCALE, VALUE_FOLLOW_SYSTEM);
        } else {
            String string = locale.getLanguage();
            String string2 = locale.getCountry();
            SPUtils sPUtils = SPUtils.getPictureSpUtils();
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(string);
            stringBuilder.append("$");
            stringBuilder.append(string2);
            sPUtils.put(KEY_LOCALE, stringBuilder.toString());
        }
        PictureLanguageUtils.updateLanguage(context, locale);
    }

    private static boolean equals(CharSequence charSequence, CharSequence charSequence2) {
        if (charSequence == charSequence2) {
            return true;
        }
        if (charSequence == null) return false;
        if (charSequence2 == null) return false;
        int n = charSequence.length();
        if (n != charSequence2.length()) return false;
        if (charSequence instanceof String && charSequence2 instanceof String) {
            return charSequence.equals(charSequence2);
        }
        int n2 = 0;
        while (n2 < n) {
            if (charSequence.charAt(n2) != charSequence2.charAt(n2)) {
                return false;
            }
            ++n2;
        }
        return true;
    }

    public static void setAppLanguage(Context object, int n) {
        object = new WeakReference<Context>((Context)object);
        if (n >= 0) {
            PictureLanguageUtils.applyLanguage((Context)((Reference)object).get(), LocaleTransform.getLanguage((int)n));
        } else {
            PictureLanguageUtils.setDefaultLanguage((Context)((Reference)object).get());
        }
    }

    private static void setDefaultLanguage(Context context) {
        Resources resources = context.getResources();
        Configuration configuration = resources.getConfiguration();
        DisplayMetrics displayMetrics = resources.getDisplayMetrics();
        if (Build.VERSION.SDK_INT >= 17) {
            configuration.setLocale(Locale.getDefault());
            context.createConfigurationContext(configuration);
        } else {
            configuration.locale = Locale.getDefault();
        }
        resources.updateConfiguration(configuration, displayMetrics);
    }

    private static void updateLanguage(Context context, Locale locale) {
        Resources resources = context.getResources();
        Configuration configuration = resources.getConfiguration();
        Locale locale2 = configuration.locale;
        if (PictureLanguageUtils.equals(locale2.getLanguage(), locale.getLanguage()) && PictureLanguageUtils.equals(locale2.getCountry(), locale.getCountry())) {
            return;
        }
        locale2 = resources.getDisplayMetrics();
        if (Build.VERSION.SDK_INT >= 17) {
            configuration.setLocale(locale);
            context.createConfigurationContext(configuration);
        } else {
            configuration.locale = locale;
        }
        resources.updateConfiguration(configuration, (DisplayMetrics)locale2);
    }
}
