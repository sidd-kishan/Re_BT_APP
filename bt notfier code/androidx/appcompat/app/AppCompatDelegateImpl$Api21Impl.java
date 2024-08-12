/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.PowerManager
 */
package androidx.appcompat.app;

import android.os.PowerManager;

static class AppCompatDelegateImpl.Api21Impl {
    private AppCompatDelegateImpl.Api21Impl() {
    }

    static boolean isPowerSaveMode(PowerManager powerManager) {
        return powerManager.isPowerSaveMode();
    }
}
