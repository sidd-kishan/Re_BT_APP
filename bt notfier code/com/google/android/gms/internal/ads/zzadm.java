/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.util.Pair
 *  com.google.android.gms.internal.ads.zzain
 *  com.google.android.gms.internal.ads.zzaip
 *  com.google.android.gms.internal.ads.zzaiq
 *  com.google.android.gms.internal.ads.zzix
 */
package com.google.android.gms.internal.ads;

import android.util.Pair;
import com.google.android.gms.internal.ads.zzain;
import com.google.android.gms.internal.ads.zzaip;
import com.google.android.gms.internal.ads.zzaiq;
import com.google.android.gms.internal.ads.zzix;

public abstract class zzadm
extends zzaiq {
    private final int zza;
    private final zzix zzb;

    public zzadm(boolean bl, zzix zzix2, byte[] byArray) {
        this.zzb = zzix2;
        this.zza = zzix2.zza();
    }

    private final int zzs(int n, boolean bl) {
        int n2 = -1;
        if (bl) {
            n = this.zzb.zzb(n);
        } else {
            if (n < this.zza - 1) return n + 1;
            n = n2;
        }
        return n;
    }

    private final int zzx(int n, boolean bl) {
        int n2 = -1;
        if (bl) {
            n = this.zzb.zzc(n);
        } else {
            if (n > 0) return n - 1;
            n = n2;
        }
        return n;
    }

    public final int zzb(int n, int n2, boolean bl) {
        int n3;
        int n4 = this.zzm(n);
        int n5 = this.zzq(n4);
        zzaiq zzaiq2 = this.zzo(n4);
        n = zzaiq2.zzb(n - n5, n3 = n2 == 2 ? 0 : n2, bl);
        if (n != -1) {
            return n5 + n;
        }
        n = this.zzs(n4, bl);
        while (n != -1 && this.zzo(n).zzt()) {
            n = this.zzs(n, bl);
        }
        if (n != -1) {
            return this.zzq(n) + this.zzo(n).zze(bl);
        }
        if (n2 != 2) return -1;
        return this.zze(bl);
    }

    public final int zzc(int n, int n2, boolean bl) {
        n2 = this.zzm(n);
        int n3 = this.zzq(n2);
        n = this.zzo(n2).zzc(n - n3, 0, false);
        if (n != -1) {
            return n3 + n;
        }
        n = this.zzx(n2, false);
        while (n != -1 && this.zzo(n).zzt()) {
            n = this.zzx(n, false);
        }
        if (n == -1) return -1;
        return this.zzq(n) + this.zzo(n).zzd(false);
    }

    public final int zzd(boolean bl) {
        int n;
        int n2 = this.zza;
        if (n2 == 0) {
            return -1;
        }
        n2 = bl ? this.zzb.zzd() : --n2;
        do {
            if (!this.zzo(n2).zzt()) return this.zzq(n2) + this.zzo(n2).zzd(bl);
            n2 = n = this.zzx(n2, bl);
        } while (n != -1);
        return -1;
    }

    public final int zze(boolean bl) {
        int n;
        if (this.zza == 0) {
            return -1;
        }
        int n2 = bl ? this.zzb.zze() : 0;
        do {
            if (!this.zzo(n2).zzt()) return this.zzq(n2) + this.zzo(n2).zze(bl);
            n2 = n = this.zzs(n2, bl);
        } while (n != -1);
        return -1;
    }

    public final zzaip zzf(int n, zzaip zzaip2, long l) {
        Object object;
        int n2 = this.zzm(n);
        int n3 = this.zzq(n2);
        int n4 = this.zzp(n2);
        this.zzo(n2).zzf(n - n3, zzaip2, l);
        Object object2 = object = this.zzr(n2);
        if (!zzaip.zza.equals(zzaip2.zzb)) {
            object2 = Pair.create((Object)object, (Object)zzaip2.zzb);
        }
        zzaip2.zzb = object2;
        zzaip2.zzn += n4;
        zzaip2.zzo += n4;
        return zzaip2;
    }

    public final zzain zzh(int n, zzain zzain2, boolean bl) {
        int n2 = this.zzl(n);
        int n3 = this.zzq(n2);
        int n4 = this.zzp(n2);
        this.zzo(n2).zzh(n - n4, zzain2, bl);
        zzain2.zzc += n3;
        if (!bl) return zzain2;
        Object object = this.zzr(n2);
        Object object2 = zzain2.zzb;
        if (object2 == null) throw null;
        zzain2.zzb = Pair.create((Object)object, (Object)object2);
        return zzain2;
    }

    public final int zzi(Object object) {
        if (!(object instanceof Pair)) return -1;
        Object object2 = (Pair)object;
        object = object2.first;
        object2 = object2.second;
        int n = this.zzn(object);
        if (n == -1) {
            return -1;
        }
        int n2 = this.zzo(n).zzi(object2);
        if (n2 != -1) return this.zzp(n) + n2;
        return -1;
    }

    public final Object zzj(int n) {
        int n2 = this.zzl(n);
        int n3 = this.zzp(n2);
        Object object = this.zzo(n2).zzj(n - n3);
        return Pair.create((Object)this.zzr(n2), (Object)object);
    }

    protected abstract int zzl(int var1);

    protected abstract int zzm(int var1);

    protected abstract int zzn(Object var1);

    protected abstract zzaiq zzo(int var1);

    protected abstract int zzp(int var1);

    protected abstract int zzq(int var1);

    protected abstract Object zzr(int var1);

    public final zzain zzy(Object object, zzain zzain2) {
        Object object2 = (Pair)object;
        Object object3 = object2.first;
        object2 = object2.second;
        int n = this.zzn(object3);
        int n2 = this.zzq(n);
        this.zzo(n).zzy(object2, zzain2);
        zzain2.zzc += n2;
        zzain2.zzb = object;
        return zzain2;
    }
}
