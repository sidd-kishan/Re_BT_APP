/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.res.Configuration
 */
package androidx.appcompat.app;

import android.content.res.Configuration;

static class AppCompatDelegateImpl.Api26Impl {
    private AppCompatDelegateImpl.Api26Impl() {
    }

    static void generateConfigDelta_colorMode(Configuration configuration, Configuration configuration2, Configuration configuration3) {
        if ((configuration.colorMode & 3) != (configuration2.colorMode & 3)) {
            configuration3.colorMode |= configuration2.colorMode & 3;
        }
        if ((configuration.colorMode & 0xC) == (configuration2.colorMode & 0xC)) return;
        configuration3.colorMode |= configuration2.colorMode & 0xC;
    }
}
