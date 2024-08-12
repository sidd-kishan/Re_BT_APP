/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.res.Configuration
 *  android.os.LocaleList
 */
package androidx.appcompat.app;

import android.content.res.Configuration;
import android.os.LocaleList;

static class AppCompatDelegateImpl.Api24Impl {
    private AppCompatDelegateImpl.Api24Impl() {
    }

    static void generateConfigDelta_locale(Configuration configuration, Configuration configuration2, Configuration configuration3) {
        LocaleList localeList;
        if ((configuration = configuration.getLocales()).equals((Object)(localeList = configuration2.getLocales()))) return;
        configuration3.setLocales(localeList);
        configuration3.locale = configuration2.locale;
    }
}
