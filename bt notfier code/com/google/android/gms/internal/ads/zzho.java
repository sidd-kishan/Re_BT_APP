/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Handler
 *  com.google.android.gms.internal.ads.zzadx
 *  com.google.android.gms.internal.ads.zzafv
 *  com.google.android.gms.internal.ads.zzamq
 *  com.google.android.gms.internal.ads.zzgx
 *  com.google.android.gms.internal.ads.zzhc
 *  com.google.android.gms.internal.ads.zzhf
 *  com.google.android.gms.internal.ads.zzhi
 *  com.google.android.gms.internal.ads.zzhj
 *  com.google.android.gms.internal.ads.zzhk
 *  com.google.android.gms.internal.ads.zzhl
 *  com.google.android.gms.internal.ads.zzhm
 *  com.google.android.gms.internal.ads.zzhn
 *  com.google.android.gms.internal.ads.zzhp
 */
package com.google.android.gms.internal.ads;

import android.os.Handler;
import com.google.android.gms.internal.ads.zzadx;
import com.google.android.gms.internal.ads.zzafv;
import com.google.android.gms.internal.ads.zzamq;
import com.google.android.gms.internal.ads.zzgx;
import com.google.android.gms.internal.ads.zzhc;
import com.google.android.gms.internal.ads.zzhf;
import com.google.android.gms.internal.ads.zzhi;
import com.google.android.gms.internal.ads.zzhj;
import com.google.android.gms.internal.ads.zzhk;
import com.google.android.gms.internal.ads.zzhl;
import com.google.android.gms.internal.ads.zzhm;
import com.google.android.gms.internal.ads.zzhn;
import com.google.android.gms.internal.ads.zzhp;
import java.io.IOException;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

public final class zzho {
    public final int zza;
    public final zzhf zzb;
    private final CopyOnWriteArrayList<zzhn> zzc;

    public zzho() {
        this(new CopyOnWriteArrayList<zzhn>(), 0, null, 0L);
    }

    private zzho(CopyOnWriteArrayList<zzhn> copyOnWriteArrayList, int n, zzhf zzhf2, long l) {
        this.zzc = copyOnWriteArrayList;
        this.zza = n;
        this.zzb = zzhf2;
    }

    private static final long zzn(long l) {
        if ((l = zzadx.zza((long)l)) != -9223372036854775807L) return l;
        return -9223372036854775807L;
    }

    public final zzho zza(int n, zzhf zzhf2, long l) {
        return new zzho(this.zzc, n, zzhf2, 0L);
    }

    public final void zzb(Handler handler, zzhp zzhp2) {
        this.zzc.add(new zzhn(handler, zzhp2));
    }

    public final void zzc(zzhp zzhp2) {
        Iterator<zzhn> iterator = this.zzc.iterator();
        while (iterator.hasNext()) {
            zzhn zzhn2 = iterator.next();
            if (zzhn2.zzb != zzhp2) continue;
            this.zzc.remove(zzhn2);
        }
    }

    public final void zzd(zzgx zzgx2, int n, int n2, zzafv zzafv2, int n3, Object object, long l, long l2) {
        this.zze(zzgx2, new zzhc(1, -1, null, 0, null, zzho.zzn(l), zzho.zzn(l2)));
    }

    public final void zze(zzgx zzgx2, zzhc zzhc2) {
        Iterator<zzhn> iterator = this.zzc.iterator();
        while (iterator.hasNext()) {
            zzhn zzhn2 = iterator.next();
            zzhp zzhp2 = zzhn2.zzb;
            zzamq.zzj((Handler)zzhn2.zza, (Runnable)new zzhi(this, zzhp2, zzgx2, zzhc2));
        }
    }

    public final void zzf(zzgx zzgx2, int n, int n2, zzafv zzafv2, int n3, Object object, long l, long l2) {
        this.zzg(zzgx2, new zzhc(1, -1, null, 0, null, zzho.zzn(l), zzho.zzn(l2)));
    }

    public final void zzg(zzgx zzgx2, zzhc zzhc2) {
        Iterator<zzhn> iterator = this.zzc.iterator();
        while (iterator.hasNext()) {
            zzhn zzhn2 = iterator.next();
            zzhp zzhp2 = zzhn2.zzb;
            zzamq.zzj((Handler)zzhn2.zza, (Runnable)new zzhj(this, zzhp2, zzgx2, zzhc2));
        }
    }

    public final void zzh(zzgx zzgx2, int n, int n2, zzafv zzafv2, int n3, Object object, long l, long l2) {
        this.zzi(zzgx2, new zzhc(1, -1, null, 0, null, zzho.zzn(l), zzho.zzn(l2)));
    }

    public final void zzi(zzgx zzgx2, zzhc zzhc2) {
        Iterator<zzhn> iterator = this.zzc.iterator();
        while (iterator.hasNext()) {
            zzhn zzhn2 = iterator.next();
            zzhp zzhp2 = zzhn2.zzb;
            zzamq.zzj((Handler)zzhn2.zza, (Runnable)new zzhk(this, zzhp2, zzgx2, zzhc2));
        }
    }

    public final void zzj(zzgx zzgx2, int n, int n2, zzafv zzafv2, int n3, Object object, long l, long l2, IOException iOException, boolean bl) {
        this.zzk(zzgx2, new zzhc(1, -1, null, 0, null, zzho.zzn(l), zzho.zzn(l2)), iOException, bl);
    }

    public final void zzk(zzgx zzgx2, zzhc zzhc2, IOException iOException, boolean bl) {
        Iterator<zzhn> iterator = this.zzc.iterator();
        while (iterator.hasNext()) {
            zzhn zzhn2 = iterator.next();
            zzhp zzhp2 = zzhn2.zzb;
            zzamq.zzj((Handler)zzhn2.zza, (Runnable)new zzhl(this, zzhp2, zzgx2, zzhc2, iOException, bl));
        }
    }

    public final void zzl(int n, zzafv zzafv2, int n2, Object object, long l) {
        this.zzm(new zzhc(1, n, zzafv2, 0, null, zzho.zzn(l), -9223372036854775807L));
    }

    public final void zzm(zzhc zzhc2) {
        Iterator<zzhn> iterator = this.zzc.iterator();
        while (iterator.hasNext()) {
            zzhn zzhn2 = iterator.next();
            zzhp zzhp2 = zzhn2.zzb;
            zzamq.zzj((Handler)zzhn2.zza, (Runnable)new zzhm(this, zzhp2, zzhc2));
        }
    }
}
