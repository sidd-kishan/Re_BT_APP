/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.res.Configuration
 *  android.os.Build$VERSION
 *  android.os.LocaleList
 *  androidx.core.os.LocaleListCompat
 */
package androidx.core.os;

import android.content.res.Configuration;
import android.os.Build;
import android.os.LocaleList;
import androidx.core.os.LocaleListCompat;
import java.util.Locale;

public final class ConfigurationCompat {
    private ConfigurationCompat() {
    }

    public static LocaleListCompat getLocales(Configuration configuration) {
        if (Build.VERSION.SDK_INT < 24) return LocaleListCompat.create((Locale[])new Locale[]{configuration.locale});
        return LocaleListCompat.wrap((LocaleList)configuration.getLocales());
    }
}
