/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzakt
 *  com.google.android.gms.internal.ads.zznv
 *  com.google.android.gms.internal.ads.zzoi
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzakt;
import com.google.android.gms.internal.ads.zznv;
import com.google.android.gms.internal.ads.zzoi;

final class zzpv
extends zzoi {
    private final long zza;

    public zzpv(zznv zznv2, long l) {
        super(zznv2);
        boolean bl = zznv2.zzn() >= l;
        zzakt.zza((boolean)bl);
        this.zza = l;
    }

    public final long zzm() {
        return super.zzm() - this.zza;
    }

    public final long zzn() {
        return super.zzn() - this.zza;
    }

    public final long zzo() {
        return super.zzo() - this.zza;
    }
}
