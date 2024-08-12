/*
 * Decompiled with CFR 0.152.
 */
package com.google.android.gms.internal.ads;

import java.math.BigInteger;

public final class zzcgg {
    private BigInteger zza = BigInteger.ONE;
    private String zzb = "0";

    public final String zza() {
        synchronized (this) {
            String string = this.zza.toString();
            this.zza = this.zza.add(BigInteger.ONE);
            this.zzb = string;
            return string;
        }
    }

    public final String zzb() {
        synchronized (this) {
            String string = this.zzb;
            return string;
        }
    }
}
