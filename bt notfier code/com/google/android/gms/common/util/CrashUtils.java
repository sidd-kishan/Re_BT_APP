/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.util.Log
 *  com.google.android.gms.common.internal.Preconditions
 */
package com.google.android.gms.common.util;

import android.content.Context;
import android.util.Log;
import com.google.android.gms.common.internal.Preconditions;

public final class CrashUtils {
    private static final String[] zza = new String[]{"android.", "com.android.", "dalvik.", "java.", "javax."};

    public static boolean addDynamiteErrorToDropBox(Context context, Throwable throwable) {
        try {
            Preconditions.checkNotNull((Object)context);
            Preconditions.checkNotNull((Object)throwable);
        }
        catch (Exception exception) {
            Log.e((String)"CrashUtils", (String)"Error adding exception to DropBox!", (Throwable)exception);
        }
        return false;
    }
}
