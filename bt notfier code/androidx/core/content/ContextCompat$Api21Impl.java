/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.graphics.drawable.Drawable
 */
package androidx.core.content;

import android.content.Context;
import android.graphics.drawable.Drawable;
import java.io.File;

static class ContextCompat.Api21Impl {
    private ContextCompat.Api21Impl() {
    }

    static File getCodeCacheDir(Context context) {
        return context.getCodeCacheDir();
    }

    static Drawable getDrawable(Context context, int n) {
        return context.getDrawable(n);
    }

    static File getNoBackupFilesDir(Context context) {
        return context.getNoBackupFilesDir();
    }
}
