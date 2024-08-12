/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 */
package androidx.core.content;

import android.content.Context;
import java.io.File;

static class ContextCompat.Api24Impl {
    private ContextCompat.Api24Impl() {
    }

    static Context createDeviceProtectedStorageContext(Context context) {
        return context.createDeviceProtectedStorageContext();
    }

    static File getDataDir(Context context) {
        return context.getDataDir();
    }

    static boolean isDeviceProtectedStorage(Context context) {
        return context.isDeviceProtectedStorage();
    }
}
