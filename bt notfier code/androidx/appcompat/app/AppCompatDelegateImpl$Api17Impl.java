/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.Configuration
 */
package androidx.appcompat.app;

import android.content.Context;
import android.content.res.Configuration;

static class AppCompatDelegateImpl.Api17Impl {
    private AppCompatDelegateImpl.Api17Impl() {
    }

    static Context createConfigurationContext(Context context, Configuration configuration) {
        return context.createConfigurationContext(configuration);
    }

    static void generateConfigDelta_densityDpi(Configuration configuration, Configuration configuration2, Configuration configuration3) {
        if (configuration.densityDpi == configuration2.densityDpi) return;
        configuration3.densityDpi = configuration2.densityDpi;
    }
}
