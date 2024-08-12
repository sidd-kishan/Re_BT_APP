/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzamf
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzamf;

public final class zznr {
    public final String zza;

    private zznr(int n, int n2, String string) {
        this.zza = string;
    }

    public static zznr zza(zzamf object) {
        object.zzk(2);
        int n = object.zzn();
        int n2 = n >> 1;
        n = object.zzn() >> 3 | (n & 1) << 5;
        if (n2 != 4 && n2 != 5 && n2 != 7) {
            if (n2 == 8) {
                object = "hev1";
            } else {
                if (n2 != 9) return null;
                object = "avc3";
            }
        } else {
            object = "dvhe";
        }
        String string = n < 10 ? ".0" : ".";
        StringBuilder stringBuilder = new StringBuilder(object.length() + 24 + string.length());
        stringBuilder.append((String)object);
        stringBuilder.append(".0");
        stringBuilder.append(n2);
        stringBuilder.append(string);
        stringBuilder.append(n);
        return new zznr(n2, n, stringBuilder.toString());
    }
}
