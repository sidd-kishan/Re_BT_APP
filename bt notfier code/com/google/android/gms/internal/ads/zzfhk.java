/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.text.TextUtils
 */
package com.google.android.gms.internal.ads;

import android.text.TextUtils;

public final class zzfhk {
    public static void zza(Object object, String string) {
        if (object == null) throw new IllegalArgumentException(string);
    }

    public static void zzb(String string, String string2) {
        if (TextUtils.isEmpty((CharSequence)string)) throw new IllegalArgumentException(string2);
    }
}
