/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.ads.internal.util.zze
 *  com.google.android.gms.internal.ads.zzbpr
 *  com.google.android.gms.internal.ads.zzcjb
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.util.zze;
import com.google.android.gms.internal.ads.zzbpr;
import com.google.android.gms.internal.ads.zzcjb;
import java.util.Map;

public final class zzclb
implements zzbpr<zzcjb> {
    private static final Integer zzb(Map<String, String> object, String string) {
        int n;
        if (!object.containsKey(string)) {
            return null;
        }
        try {
            n = Integer.parseInt(object.get(string));
        }
        catch (NumberFormatException numberFormatException) {
            object = object.get(string);
            int n2 = String.valueOf(object).length();
            StringBuilder stringBuilder = new StringBuilder(string.length() + 39 + n2);
            stringBuilder.append("Precache invalid numeric parameter '");
            stringBuilder.append(string);
            stringBuilder.append("': ");
            stringBuilder.append((String)object);
            zze.zzi((String)stringBuilder.toString());
            return null;
        }
        return n;
    }
}
