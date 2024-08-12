/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Handler
 *  android.os.Looper
 *  com.google.android.gms.internal.ads.zzaiq
 *  com.google.android.gms.internal.ads.zzakt
 *  com.google.android.gms.internal.ads.zzay
 *  com.google.android.gms.internal.ads.zzfa
 *  com.google.android.gms.internal.ads.zzfb
 *  com.google.android.gms.internal.ads.zzhf
 *  com.google.android.gms.internal.ads.zzhg
 *  com.google.android.gms.internal.ads.zzhh
 *  com.google.android.gms.internal.ads.zzho
 *  com.google.android.gms.internal.ads.zzhp
 */
package com.google.android.gms.internal.ads;

import android.os.Handler;
import android.os.Looper;
import com.google.android.gms.internal.ads.zzaiq;
import com.google.android.gms.internal.ads.zzakt;
import com.google.android.gms.internal.ads.zzay;
import com.google.android.gms.internal.ads.zzfa;
import com.google.android.gms.internal.ads.zzfb;
import com.google.android.gms.internal.ads.zzhf;
import com.google.android.gms.internal.ads.zzhg;
import com.google.android.gms.internal.ads.zzhh;
import com.google.android.gms.internal.ads.zzho;
import com.google.android.gms.internal.ads.zzhp;
import java.util.ArrayList;
import java.util.HashSet;

public abstract class zzgi
implements zzhh {
    private final ArrayList<zzhg> zza = new ArrayList(1);
    private final HashSet<zzhg> zzb = new HashSet(1);
    private final zzho zzc = new zzho();
    private final zzfa zzd = new zzfa();
    private Looper zze;
    private zzaiq zzf;

    protected void zzF() {
    }

    protected abstract void zza(zzay var1);

    protected void zzc() {
    }

    protected abstract void zzd();

    protected final void zze(zzaiq zzaiq2) {
        this.zzf = zzaiq2;
        ArrayList<zzhg> arrayList = this.zza;
        int n = arrayList.size();
        int n2 = 0;
        while (n2 < n) {
            ((zzhg)arrayList.get(n2)).zza((zzhh)this, zzaiq2);
            ++n2;
        }
    }

    protected final zzho zzf(zzhf zzhf2) {
        return this.zzc.zza(0, zzhf2, 0L);
    }

    protected final zzho zzg(int n, zzhf zzhf2, long l) {
        return this.zzc.zza(n, zzhf2, 0L);
    }

    protected final zzfa zzh(zzhf zzhf2) {
        return this.zzd.zza(0, zzhf2);
    }

    protected final zzfa zzi(int n, zzhf zzhf2) {
        return this.zzd.zza(n, zzhf2);
    }

    protected final boolean zzj() {
        if (this.zzb.isEmpty()) return false;
        return true;
    }

    public final void zzk(Handler handler, zzhp zzhp2) {
        if (zzhp2 == null) throw null;
        this.zzc.zzb(handler, zzhp2);
    }

    public final void zzl(zzhp zzhp2) {
        this.zzc.zzc(zzhp2);
    }

    public final void zzm(Handler handler, zzfb zzfb2) {
        if (zzfb2 == null) throw null;
        this.zzd.zzb(handler, zzfb2);
    }

    public final void zzn(zzfb zzfb2) {
        this.zzd.zzc(zzfb2);
    }

    public final void zzo(zzhg zzhg2, zzay zzay2) {
        boolean bl;
        Looper looper = Looper.myLooper();
        Looper looper2 = this.zze;
        boolean bl2 = bl = true;
        if (looper2 != null) {
            bl2 = looper2 == looper ? bl : false;
        }
        zzakt.zza((boolean)bl2);
        looper2 = this.zzf;
        this.zza.add(zzhg2);
        if (this.zze == null) {
            this.zze = looper;
            this.zzb.add(zzhg2);
            this.zza(zzay2);
            return;
        }
        if (looper2 == null) return;
        this.zzp(zzhg2);
        zzhg2.zza((zzhh)this, (zzaiq)looper2);
    }

    public final void zzp(zzhg zzhg2) {
        if (this.zze == null) throw null;
        boolean bl = this.zzb.isEmpty();
        this.zzb.add(zzhg2);
        if (!bl) return;
        this.zzF();
    }

    public final void zzq(zzhg zzhg2) {
        boolean bl = this.zzb.isEmpty();
        this.zzb.remove(zzhg2);
        if (!(bl ^ true)) return;
        if (!this.zzb.isEmpty()) return;
        this.zzc();
    }

    public final void zzr(zzhg zzhg2) {
        this.zza.remove(zzhg2);
        if (this.zza.isEmpty()) {
            this.zze = null;
            this.zzf = null;
            this.zzb.clear();
            this.zzd();
            return;
        }
        this.zzq(zzhg2);
    }

    public final zzaiq zzs() {
        return null;
    }

    public final boolean zzt() {
        return true;
    }
}
