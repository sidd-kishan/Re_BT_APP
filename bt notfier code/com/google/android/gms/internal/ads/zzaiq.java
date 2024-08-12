/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.util.Log
 *  android.util.Pair
 *  com.google.android.gms.internal.ads.zzadw
 *  com.google.android.gms.internal.ads.zzaik
 *  com.google.android.gms.internal.ads.zzail
 *  com.google.android.gms.internal.ads.zzain
 *  com.google.android.gms.internal.ads.zzaip
 *  com.google.android.gms.internal.ads.zzakt
 */
package com.google.android.gms.internal.ads;

import android.util.Log;
import android.util.Pair;
import com.google.android.gms.internal.ads.zzadw;
import com.google.android.gms.internal.ads.zzaik;
import com.google.android.gms.internal.ads.zzail;
import com.google.android.gms.internal.ads.zzain;
import com.google.android.gms.internal.ads.zzaip;
import com.google.android.gms.internal.ads.zzakt;

public abstract class zzaiq {
    public static final zzaiq zzc = new zzail();
    public static final zzadw<zzaiq> zzd = zzaik.zza;

    protected zzaiq() {
    }

    public final boolean equals(Object object) {
        int n;
        if (this == object) {
            return true;
        }
        if (!(object instanceof zzaiq)) {
            return false;
        }
        zzaiq zzaiq2 = (zzaiq)object;
        if (zzaiq2.zza() != this.zza()) return false;
        if (zzaiq2.zzg() != this.zzg()) {
            return false;
        }
        zzaip zzaip2 = new zzaip();
        zzain zzain2 = new zzain();
        zzaip zzaip3 = new zzaip();
        object = new zzain();
        for (n = 0; n < this.zza(); ++n) {
            if (this.zzf(n, zzaip2, 0L).equals((Object)zzaiq2.zzf(n, zzaip3, 0L))) continue;
            return false;
        }
        n = 0;
        while (n < this.zzg()) {
            if (!this.zzh(n, zzain2, true).equals((Object)zzaiq2.zzh(n, (zzain)object, true))) {
                return false;
            }
            ++n;
        }
        return true;
    }

    public final int hashCode() {
        int n;
        zzaip zzaip2 = new zzaip();
        zzain zzain2 = new zzain();
        int n2 = this.zza() + 217;
        int n3 = 0;
        for (n = 0; n < this.zza(); ++n) {
            n2 = n2 * 31 + this.zzf(n, zzaip2, 0L).hashCode();
        }
        n2 = n2 * 31 + this.zzg();
        n = n3;
        while (n < this.zzg()) {
            n2 = n2 * 31 + this.zzh(n, zzain2, true).hashCode();
            ++n;
        }
        return n2;
    }

    public abstract int zza();

    public int zzb(int n, int n2, boolean bl) {
        if (n2 == 0) {
            if (n != this.zzd(bl)) return n + 1;
            return -1;
        }
        if (n2 == 1) return n;
        if (n2 != 2) throw new IllegalStateException();
        n = n == this.zzd(bl) ? this.zze(bl) : ++n;
        return n;
    }

    public int zzc(int n, int n2, boolean bl) {
        if (n != this.zze(false)) return n - 1;
        return -1;
    }

    public int zzd(boolean bl) {
        if (!this.zzt()) return this.zza() - 1;
        return -1;
    }

    public int zze(boolean bl) {
        if (!this.zzt()) return 0;
        return -1;
    }

    public abstract zzaip zzf(int var1, zzaip var2, long var3);

    public abstract int zzg();

    public abstract zzain zzh(int var1, zzain var2, boolean var3);

    public abstract int zzi(Object var1);

    public abstract Object zzj(int var1);

    public final boolean zzt() {
        if (this.zza() != 0) return false;
        return true;
    }

    public final int zzu(int n, zzain zzain2, zzaip zzaip2, int n2, boolean bl) {
        int n3 = this.zzh((int)n, (zzain)zzain2, (boolean)false).zzc;
        if (this.zzf((int)n3, (zzaip)zzaip2, (long)0L).zzo != n) return n + 1;
        n = this.zzb(n3, n2, bl);
        if (n != -1) return this.zzf((int)n, (zzaip)zzaip2, (long)0L).zzn;
        return -1;
    }

    public final Pair<Object, Long> zzv(zzaip pair, zzain zzain2, int n, long l) {
        if ((pair = this.zzw((zzaip)pair, zzain2, n, l, 0L)) == null) throw null;
        return pair;
    }

    public final Pair<Object, Long> zzw(zzaip object, zzain zzain2, int n, long l, long l2) {
        zzakt.zzc((int)n, (int)0, (int)this.zza());
        this.zzf(n, (zzaip)object, l2);
        l2 = l;
        if (l == -9223372036854775807L) {
            l = object.zzl;
            l2 = 0L;
        }
        n = object.zzn;
        this.zzh(n, zzain2, false);
        while (n < object.zzo) {
            l = zzain2.zze;
            if (l2 == 0L) break;
            int n2 = n + 1;
            l = this.zzh((int)n2, (zzain)zzain2, (boolean)false).zze;
            if (l2 < 0L) break;
            n = n2;
        }
        this.zzh(n, zzain2, true);
        l = zzain2.zze;
        long l3 = zzain2.zzd;
        l = l2;
        if (l3 != -9223372036854775807L) {
            l = Math.min(l2, l3 - 1L);
        }
        if ((l = Math.max(0L, l)) == 9L) {
            Log.e((String)"XXX", (String)"YYY");
        }
        if ((object = zzain2.zzb) == null) throw null;
        return Pair.create((Object)object, (Object)l);
    }

    public zzain zzy(Object object, zzain zzain2) {
        return this.zzh(this.zzi(object), zzain2, true);
    }
}
