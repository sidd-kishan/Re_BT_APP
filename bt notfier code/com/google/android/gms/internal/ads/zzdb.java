/*
 * Decompiled with CFR 0.152.
 */
package com.google.android.gms.internal.ads;

import java.util.Arrays;

public final class zzdb {
    public static final zzdb zza = new zzdb(new int[]{2}, 8);
    private static final zzdb zzb = new zzdb(new int[]{2, 5, 6}, 8);
    private final int[] zzc;
    private final int zzd;

    public zzdb(int[] nArray, int n) {
        nArray = Arrays.copyOf(nArray, nArray.length);
        this.zzc = nArray;
        Arrays.sort(nArray);
        this.zzd = 8;
    }

    public final boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (!(object instanceof zzdb)) {
            return false;
        }
        object = (zzdb)object;
        if (!Arrays.equals(this.zzc, ((zzdb)object).zzc)) return false;
        int n = ((zzdb)object).zzd;
        return true;
    }

    public final int hashCode() {
        return Arrays.hashCode(this.zzc) * 31 + 8;
    }

    public final String toString() {
        String string = Arrays.toString(this.zzc);
        StringBuilder stringBuilder = new StringBuilder(String.valueOf(string).length() + 67);
        stringBuilder.append("AudioCapabilities[maxChannelCount=8, supportedEncodings=");
        stringBuilder.append(string);
        stringBuilder.append("]");
        return stringBuilder.toString();
    }
}
