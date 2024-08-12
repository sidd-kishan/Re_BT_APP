/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.ColorStateList
 */
package androidx.core.content;

import android.content.Context;
import android.content.res.ColorStateList;

static class ContextCompat.Api23Impl {
    private ContextCompat.Api23Impl() {
    }

    static int getColor(Context context, int n) {
        return context.getColor(n);
    }

    static ColorStateList getColorStateList(Context context, int n) {
        return context.getColorStateList(n);
    }

    static <T> T getSystemService(Context context, Class<T> clazz) {
        return (T)context.getSystemService(clazz);
    }

    static String getSystemServiceName(Context context, Class<?> clazz) {
        return context.getSystemServiceName(clazz);
    }
}
