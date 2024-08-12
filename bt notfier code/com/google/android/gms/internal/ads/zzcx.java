/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzadx
 *  com.google.android.gms.internal.ads.zzahp
 *  com.google.android.gms.internal.ads.zzain
 *  com.google.android.gms.internal.ads.zzaiq
 *  com.google.android.gms.internal.ads.zzflt
 *  com.google.android.gms.internal.ads.zzfoj
 *  com.google.android.gms.internal.ads.zzfom
 *  com.google.android.gms.internal.ads.zzfon
 *  com.google.android.gms.internal.ads.zzhf
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzadx;
import com.google.android.gms.internal.ads.zzahp;
import com.google.android.gms.internal.ads.zzain;
import com.google.android.gms.internal.ads.zzaiq;
import com.google.android.gms.internal.ads.zzflt;
import com.google.android.gms.internal.ads.zzfoj;
import com.google.android.gms.internal.ads.zzfom;
import com.google.android.gms.internal.ads.zzfon;
import com.google.android.gms.internal.ads.zzhf;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

final class zzcx {
    private final zzain zza;
    private zzfoj<zzhf> zzb;
    private zzfon<zzhf, zzaiq> zzc;
    private zzhf zzd;
    private zzhf zze;
    private zzhf zzf;

    public zzcx(zzain zzain2) {
        this.zza = zzain2;
        this.zzb = zzfoj.zzi();
        this.zzc = zzfon.zza();
    }

    static /* synthetic */ zzfoj zza(zzcx zzcx2) {
        return zzcx2.zzb;
    }

    private final void zzj(zzaiq zzaiq2) {
        zzfom zzfom2 = new zzfom();
        if (this.zzb.isEmpty()) {
            this.zzk((zzfom<zzhf, zzaiq>)zzfom2, this.zze, zzaiq2);
            if (!zzflt.zza((Object)this.zzf, (Object)this.zze)) {
                this.zzk((zzfom<zzhf, zzaiq>)zzfom2, this.zzf, zzaiq2);
            }
            if (!zzflt.zza((Object)this.zzd, (Object)this.zze) && !zzflt.zza((Object)this.zzd, (Object)this.zzf)) {
                this.zzk((zzfom<zzhf, zzaiq>)zzfom2, this.zzd, zzaiq2);
            }
        } else {
            for (int i = 0; i < this.zzb.size(); ++i) {
                this.zzk((zzfom<zzhf, zzaiq>)zzfom2, (zzhf)this.zzb.get(i), zzaiq2);
            }
            if (!this.zzb.contains((Object)this.zzd)) {
                this.zzk((zzfom<zzhf, zzaiq>)zzfom2, this.zzd, zzaiq2);
            }
        }
        this.zzc = zzfom2.zzc();
    }

    private final void zzk(zzfom<zzhf, zzaiq> zzfom2, zzhf zzhf2, zzaiq zzaiq2) {
        if (zzhf2 == null) {
            return;
        }
        if (zzaiq2.zzi(zzhf2.zza) != -1) {
            zzfom2.zza((Object)zzhf2, (Object)zzaiq2);
            return;
        }
        zzaiq2 = (zzaiq)this.zzc.get((Object)zzhf2);
        if (zzaiq2 == null) return;
        zzfom2.zza((Object)zzhf2, (Object)zzaiq2);
    }

    private static zzhf zzl(zzahp zzahp2, zzfoj<zzhf> zzfoj2, zzhf zzhf2, zzain zzain2) {
        zzaiq zzaiq2 = zzahp2.zzF();
        int n = zzahp2.zzu();
        Object object = zzaiq2.zzt() ? null : zzaiq2.zzj(n);
        n = !zzahp2.zzA() && !zzaiq2.zzt() ? zzaiq2.zzh(n, zzain2, false).zzf(zzadx.zzb((long)zzahp2.zzx())) : -1;
        int n2 = 0;
        while (true) {
            if (n2 >= zzfoj2.size()) {
                if (!zzfoj2.isEmpty()) return null;
                if (zzhf2 == null) return null;
                if (!zzcx.zzm(zzhf2, object, zzahp2.zzA(), zzahp2.zzB(), zzahp2.zzC(), n)) return null;
                return zzhf2;
            }
            zzain2 = (zzhf)zzfoj2.get(n2);
            if (zzcx.zzm((zzhf)zzain2, object, zzahp2.zzA(), zzahp2.zzB(), zzahp2.zzC(), n)) {
                return zzain2;
            }
            ++n2;
        }
    }

    private static boolean zzm(zzhf zzhf2, Object object, boolean bl, int n, int n2, int n3) {
        boolean bl2 = zzhf2.zza.equals(object);
        boolean bl3 = false;
        if (!bl2) {
            return false;
        }
        if (bl) {
            bl = bl3;
            if (zzhf2.zzb != n) return bl;
            if (zzhf2.zzc != n2) return false;
        } else {
            bl = bl3;
            if (zzhf2.zzb != -1) return bl;
            bl = bl3;
            if (zzhf2.zze != n3) return bl;
        }
        bl = true;
        return bl;
    }

    public final zzhf zzb() {
        return this.zzd;
    }

    public final zzhf zzc() {
        return this.zze;
    }

    public final zzhf zzd() {
        return this.zzf;
    }

    public final zzhf zze() {
        if (this.zzb.isEmpty()) {
            return null;
        }
        Object object = this.zzb;
        if (object instanceof List) {
            if (object.isEmpty()) throw new NoSuchElementException();
            object = object.get(object.size() - 1);
        } else {
            Iterator iterator = object.iterator();
            do {
                object = iterator.next();
            } while (iterator.hasNext());
        }
        return (zzhf)object;
    }

    public final zzaiq zzf(zzhf zzhf2) {
        return (zzaiq)this.zzc.get((Object)zzhf2);
    }

    public final void zzg(zzahp zzahp2) {
        this.zzd = zzcx.zzl(zzahp2, this.zzb, this.zze, this.zza);
    }

    public final void zzh(zzahp zzahp2) {
        this.zzd = zzcx.zzl(zzahp2, this.zzb, this.zze, this.zza);
        this.zzj(zzahp2.zzF());
    }

    public final void zzi(List<zzhf> list, zzhf zzhf2, zzahp zzahp2) {
        this.zzb = zzfoj.zzp(list);
        if (!list.isEmpty()) {
            this.zze = list.get(0);
            if (zzhf2 == null) throw null;
            this.zzf = zzhf2;
        }
        if (this.zzd == null) {
            this.zzd = zzcx.zzl(zzahp2, this.zzb, this.zze, this.zza);
        }
        this.zzj(zzahp2.zzF());
    }
}
