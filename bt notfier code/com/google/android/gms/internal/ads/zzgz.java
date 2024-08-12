/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzagk
 *  com.google.android.gms.internal.ads.zzain
 *  com.google.android.gms.internal.ads.zzaip
 *  com.google.android.gms.internal.ads.zzaiq
 *  com.google.android.gms.internal.ads.zzamq
 *  com.google.android.gms.internal.ads.zzgu
 *  com.google.android.gms.internal.ads.zzha
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzagk;
import com.google.android.gms.internal.ads.zzain;
import com.google.android.gms.internal.ads.zzaip;
import com.google.android.gms.internal.ads.zzaiq;
import com.google.android.gms.internal.ads.zzamq;
import com.google.android.gms.internal.ads.zzgu;
import com.google.android.gms.internal.ads.zzha;

final class zzgz
extends zzgu {
    public static final Object zzb = new Object();
    private final Object zze;
    private final Object zzf;

    private zzgz(zzaiq zzaiq2, Object object, Object object2) {
        super(zzaiq2);
        this.zze = object;
        this.zzf = object2;
    }

    static /* synthetic */ Object zzk(zzgz zzgz2) {
        return zzgz2.zzf;
    }

    public static zzgz zzl(zzagk zzagk2) {
        return new zzgz((zzaiq)new zzha(zzagk2), zzaip.zza, zzb);
    }

    public static zzgz zzm(zzaiq zzaiq2, Object object, Object object2) {
        return new zzgz(zzaiq2, object, object2);
    }

    public final zzaip zzf(int n, zzaip zzaip2, long l) {
        this.zza.zzf(n, zzaip2, l);
        if (!zzamq.zzc((Object)zzaip2.zzb, (Object)this.zze)) return zzaip2;
        zzaip2.zzb = zzaip.zza;
        return zzaip2;
    }

    public final zzain zzh(int n, zzain zzain2, boolean bl) {
        this.zza.zzh(n, zzain2, bl);
        if (!zzamq.zzc((Object)zzain2.zzb, (Object)this.zzf)) return zzain2;
        if (!bl) return zzain2;
        zzain2.zzb = zzb;
        return zzain2;
    }

    public final int zzi(Object object) {
        zzaiq zzaiq2 = this.zza;
        Object object2 = object;
        if (!zzb.equals(object)) return zzaiq2.zzi(object2);
        object2 = this.zzf;
        if (object2 != null) return zzaiq2.zzi(object2);
        object2 = object;
        return zzaiq2.zzi(object2);
    }

    public final Object zzj(int n) {
        Object object;
        Object object2 = object = this.zza.zzj(n);
        if (!zzamq.zzc((Object)object, (Object)this.zzf)) return object2;
        object2 = zzb;
        return object2;
    }

    public final zzgz zzn(zzaiq zzaiq2) {
        return new zzgz(zzaiq2, this.zze, this.zzf);
    }
}
