/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.res.Configuration
 *  android.view.ContextThemeWrapper
 */
package androidx.appcompat.app;

import android.content.res.Configuration;
import android.view.ContextThemeWrapper;

private static class AppCompatDelegateImpl.ContextThemeWrapperCompatApi17Impl {
    private AppCompatDelegateImpl.ContextThemeWrapperCompatApi17Impl() {
    }

    static void applyOverrideConfiguration(ContextThemeWrapper contextThemeWrapper, Configuration configuration) {
        contextThemeWrapper.applyOverrideConfiguration(configuration);
    }
}
