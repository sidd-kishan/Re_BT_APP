/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Bundle
 *  com.google.android.gms.common.internal.Preconditions
 *  com.google.android.gms.internal.ads.zzbdl
 *  com.google.android.gms.internal.ads.zzerx
 */
package com.google.android.gms.internal.ads;

import android.os.Bundle;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.ads.zzbdl;
import com.google.android.gms.internal.ads.zzerx;

public final class zzemt
implements zzerx<Bundle> {
    public final zzbdl zza;
    public final String zzb;
    public final boolean zzc;
    public final String zzd;
    public final float zze;
    public final int zzf;
    public final int zzg;
    public final String zzh;
    public final boolean zzi;

    public zzemt(zzbdl zzbdl2, String string, boolean bl, String string2, float f, int n, int n2, String string3, boolean bl2) {
        Preconditions.checkNotNull((Object)zzbdl2, (Object)"the adSize must not be null");
        this.zza = zzbdl2;
        this.zzb = string;
        this.zzc = bl;
        this.zzd = string2;
        this.zze = f;
        this.zzf = n;
        this.zzg = n2;
        this.zzh = string3;
        this.zzi = bl2;
    }
}
