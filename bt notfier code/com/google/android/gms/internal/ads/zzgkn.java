/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.util.Log
 *  com.google.android.gms.internal.ads.zzgks
 */
package com.google.android.gms.internal.ads;

import android.util.Log;
import com.google.android.gms.internal.ads.zzgks;

public final class zzgkn
extends zzgks {
    final String zza;

    public zzgkn(String string) {
        this.zza = string;
    }

    public final void zza(String string) {
        String string2 = this.zza;
        StringBuilder stringBuilder = new StringBuilder(String.valueOf(string2).length() + 1 + String.valueOf(string).length());
        stringBuilder.append(string2);
        stringBuilder.append(":");
        stringBuilder.append(string);
        Log.d((String)"isoparser", (String)stringBuilder.toString());
    }
}
