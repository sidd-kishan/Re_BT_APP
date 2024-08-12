/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.SharedPreferences
 */
package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.SharedPreferences;

public final class zzbjf {
    public static final SharedPreferences zza(Context context) {
        return context.getSharedPreferences("google_ads_flags", 0);
    }
}
