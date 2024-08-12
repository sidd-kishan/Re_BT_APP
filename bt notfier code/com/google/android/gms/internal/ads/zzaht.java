/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzadm
 *  com.google.android.gms.internal.ads.zzagt
 *  com.google.android.gms.internal.ads.zzaiq
 *  com.google.android.gms.internal.ads.zzamq
 *  com.google.android.gms.internal.ads.zzix
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzadm;
import com.google.android.gms.internal.ads.zzagt;
import com.google.android.gms.internal.ads.zzaiq;
import com.google.android.gms.internal.ads.zzamq;
import com.google.android.gms.internal.ads.zzix;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

final class zzaht
extends zzadm {
    private final int zza;
    private final int zzb;
    private final int[] zze;
    private final int[] zzf;
    private final zzaiq[] zzg;
    private final Object[] zzh;
    private final HashMap<Object, Integer> zzi;

    /*
     * Ignored method signature, as it can't be verified against descriptor
     */
    public zzaht(Collection object, zzix zzix2, byte[] byArray) {
        int n = 0;
        super(false, zzix2, null);
        int n2 = object.size();
        this.zze = new int[n2];
        this.zzf = new int[n2];
        this.zzg = new zzaiq[n2];
        this.zzh = new Object[n2];
        this.zzi = new HashMap();
        object = object.iterator();
        n2 = 0;
        int n3 = 0;
        while (true) {
            if (!object.hasNext()) {
                this.zza = n;
                this.zzb = n2;
                return;
            }
            zzix2 = (zzagt)object.next();
            this.zzg[n3] = zzix2.zzc();
            this.zzf[n3] = n;
            this.zze[n3] = n2;
            n += this.zzg[n3].zza();
            n2 += this.zzg[n3].zzg();
            this.zzh[n3] = zzix2.zzb();
            this.zzi.put(this.zzh[n3], n3);
            ++n3;
        }
    }

    public final int zza() {
        return this.zza;
    }

    public final int zzg() {
        return this.zzb;
    }

    protected final int zzl(int n) {
        return zzamq.zzC((int[])this.zze, (int)(n + 1), (boolean)false, (boolean)false);
    }

    protected final int zzm(int n) {
        return zzamq.zzC((int[])this.zzf, (int)(n + 1), (boolean)false, (boolean)false);
    }

    protected final int zzn(Object object) {
        if ((object = this.zzi.get(object)) != null) return (Integer)object;
        return -1;
    }

    protected final zzaiq zzo(int n) {
        return this.zzg[n];
    }

    protected final int zzp(int n) {
        return this.zze[n];
    }

    protected final int zzq(int n) {
        return this.zzf[n];
    }

    protected final Object zzr(int n) {
        return this.zzh[n];
    }

    final List<zzaiq> zzs() {
        return Arrays.asList(this.zzg);
    }
}
