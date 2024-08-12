/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 */
package androidx.core.content;

import android.content.Context;
import java.io.File;

static class ContextCompat.Api19Impl {
    private ContextCompat.Api19Impl() {
    }

    static File[] getExternalCacheDirs(Context context) {
        return context.getExternalCacheDirs();
    }

    static File[] getExternalFilesDirs(Context context, String string) {
        return context.getExternalFilesDirs(string);
    }

    static File[] getObbDirs(Context context) {
        return context.getObbDirs();
    }
}
