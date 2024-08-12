/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.net.Uri
 *  com.google.android.gms.internal.ads.zzadw
 *  com.google.android.gms.internal.ads.zzagb
 *  com.google.android.gms.internal.ads.zzagh
 *  com.google.android.gms.internal.ads.zzagk
 *  com.google.android.gms.internal.ads.zzaio
 *  com.google.android.gms.internal.ads.zzakt
 *  com.google.android.gms.internal.ads.zzamq
 */
package com.google.android.gms.internal.ads;

import android.net.Uri;
import com.google.android.gms.internal.ads.zzadw;
import com.google.android.gms.internal.ads.zzagb;
import com.google.android.gms.internal.ads.zzagh;
import com.google.android.gms.internal.ads.zzagk;
import com.google.android.gms.internal.ads.zzaio;
import com.google.android.gms.internal.ads.zzakt;
import com.google.android.gms.internal.ads.zzamq;

public final class zzaip {
    public static final Object zza = new Object();
    public static final zzadw<zzaip> zzp;
    private static final Object zzq;
    private static final zzagk zzr;
    public Object zzb = zza;
    public zzagk zzc = zzr;
    public long zzd;
    public long zze;
    public long zzf;
    public boolean zzg;
    public boolean zzh;
    @Deprecated
    public boolean zzi;
    public zzagh zzj;
    public boolean zzk;
    public long zzl;
    public long zzm;
    public int zzn;
    public int zzo;

    static {
        zzq = new Object();
        zzagb zzagb2 = new zzagb();
        zzagb2.zza("com.google.android.exoplayer2.Timeline");
        zzagb2.zzb(Uri.EMPTY);
        zzr = zzagb2.zzc();
        zzp = zzaio.zza;
    }

    public final boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null) return false;
        if (!this.getClass().equals(object.getClass())) {
            return false;
        }
        object = (zzaip)object;
        if (!zzamq.zzc((Object)this.zzb, (Object)((zzaip)object).zzb)) return false;
        if (!zzamq.zzc((Object)this.zzc, (Object)((zzaip)object).zzc)) return false;
        if (!zzamq.zzc(null, null)) return false;
        if (!zzamq.zzc((Object)this.zzj, (Object)((zzaip)object).zzj)) return false;
        if (this.zzd != ((zzaip)object).zzd) return false;
        if (this.zze != ((zzaip)object).zze) return false;
        if (this.zzf != ((zzaip)object).zzf) return false;
        if (this.zzg != ((zzaip)object).zzg) return false;
        if (this.zzh != ((zzaip)object).zzh) return false;
        if (this.zzk != ((zzaip)object).zzk) return false;
        if (this.zzm != ((zzaip)object).zzm) return false;
        if (this.zzn != ((zzaip)object).zzn) return false;
        if (this.zzo != ((zzaip)object).zzo) return false;
        return true;
    }

    public final int hashCode() {
        int n = this.zzb.hashCode();
        int n2 = this.zzc.hashCode();
        zzagh zzagh2 = this.zzj;
        int n3 = zzagh2 == null ? 0 : zzagh2.hashCode();
        long l = this.zzd;
        long l2 = this.zze;
        long l3 = this.zzf;
        int n4 = this.zzg;
        int n5 = this.zzh;
        int n6 = this.zzk;
        long l4 = this.zzm;
        return ((((((((((((n + 217) * 31 + n2) * 961 + n3) * 31 + (int)(l ^ l >>> 32)) * 31 + (int)(l2 >>> 32 ^ l2)) * 31 + (int)(l3 >>> 32 ^ l3)) * 31 + n4) * 31 + n5) * 31 + n6) * 961 + (int)(l4 >>> 32 ^ l4)) * 31 + this.zzn) * 31 + this.zzo) * 31;
    }

    public final zzaip zza(Object object, zzagk zzagk2, Object object2, long l, long l2, long l3, boolean bl, boolean bl2, zzagh zzagh2, long l4, long l5, int n, int n2, long l6) {
        this.zzb = object;
        object = zzagk2 != null ? zzagk2 : zzr;
        this.zzc = object;
        this.zzd = -9223372036854775807L;
        this.zze = -9223372036854775807L;
        this.zzf = -9223372036854775807L;
        this.zzg = bl;
        this.zzh = bl2;
        bl = zzagh2 != null;
        this.zzi = bl;
        this.zzj = zzagh2;
        this.zzl = 0L;
        this.zzm = l5;
        this.zzn = 0;
        this.zzo = 0;
        this.zzk = false;
        return this;
    }

    public final boolean zzb() {
        boolean bl = this.zzi;
        boolean bl2 = this.zzj != null;
        bl2 = bl == bl2;
        zzakt.zzd((boolean)bl2);
        if (this.zzj == null) return false;
        return true;
    }
}
