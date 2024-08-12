/*
 * Decompiled with CFR 0.152.
 */
package com.google.android.gms.internal.ads;

import java.util.Arrays;

public final class zzanz {
    public static final zzanz zza = new zzanz(new int[]{2}, 2);
    private final int[] zzb;
    private final int zzc;

    zzanz(int[] nArray, int n) {
        nArray = Arrays.copyOf(nArray, 1);
        this.zzb = nArray;
        Arrays.sort(nArray);
        this.zzc = 2;
    }

    public final boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (!(object instanceof zzanz)) {
            return false;
        }
        object = (zzanz)object;
        if (!Arrays.equals(this.zzb, ((zzanz)object).zzb)) return false;
        int n = ((zzanz)object).zzc;
        return true;
    }

    public final int hashCode() {
        return Arrays.hashCode(this.zzb) * 31 + 2;
    }

    public final String toString() {
        String string = Arrays.toString(this.zzb);
        StringBuilder stringBuilder = new StringBuilder(String.valueOf(string).length() + 67);
        stringBuilder.append("AudioCapabilities[maxChannelCount=2, supportedEncodings=");
        stringBuilder.append(string);
        stringBuilder.append("]");
        return stringBuilder.toString();
    }
}
