/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzflg
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzflg;

final class zzflh
extends zzflg {
    private final char zza;

    zzflh(char c) {
        this.zza = c;
    }

    public final String toString() {
        Object object;
        int n = this.zza;
        char[] cArray = object = new char[6];
        object[0] = 92;
        cArray[1] = 117;
        cArray[2] = 0;
        cArray[3] = 0;
        cArray[4] = 0;
        cArray[5] = 0;
        int n2 = 0;
        while (true) {
            if (n2 >= 4) {
                object = String.copyValueOf(object);
                StringBuilder stringBuilder = new StringBuilder(String.valueOf(object).length() + 18);
                stringBuilder.append("CharMatcher.is('");
                stringBuilder.append((String)object);
                stringBuilder.append("')");
                return stringBuilder.toString();
            }
            object[5 - n2] = "0123456789ABCDEF".charAt(n & 0xF);
            n >>= 4;
            ++n2;
        }
    }

    public final boolean zza(char c) {
        if (c != this.zza) return false;
        return true;
    }
}
