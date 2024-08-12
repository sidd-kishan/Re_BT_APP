/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Handler
 *  android.util.Pair
 *  com.google.android.gms.internal.ads.zzagu
 *  com.google.android.gms.internal.ads.zzagv
 *  com.google.android.gms.internal.ads.zzagw
 *  com.google.android.gms.internal.ads.zzagx
 *  com.google.android.gms.internal.ads.zzagy
 *  com.google.android.gms.internal.ads.zzaht
 *  com.google.android.gms.internal.ads.zzaiq
 *  com.google.android.gms.internal.ads.zzakt
 *  com.google.android.gms.internal.ads.zzaln
 *  com.google.android.gms.internal.ads.zzamq
 *  com.google.android.gms.internal.ads.zzay
 *  com.google.android.gms.internal.ads.zzcy
 *  com.google.android.gms.internal.ads.zzfa
 *  com.google.android.gms.internal.ads.zzfb
 *  com.google.android.gms.internal.ads.zzgy
 *  com.google.android.gms.internal.ads.zzhb
 *  com.google.android.gms.internal.ads.zzhe
 *  com.google.android.gms.internal.ads.zzhf
 *  com.google.android.gms.internal.ads.zzhg
 *  com.google.android.gms.internal.ads.zzhh
 *  com.google.android.gms.internal.ads.zzho
 *  com.google.android.gms.internal.ads.zzhp
 *  com.google.android.gms.internal.ads.zzix
 *  com.google.android.gms.internal.ads.zzko
 */
package com.google.android.gms.internal.ads;

import android.os.Handler;
import android.util.Pair;
import com.google.android.gms.internal.ads.zzagu;
import com.google.android.gms.internal.ads.zzagv;
import com.google.android.gms.internal.ads.zzagw;
import com.google.android.gms.internal.ads.zzagx;
import com.google.android.gms.internal.ads.zzagy;
import com.google.android.gms.internal.ads.zzaht;
import com.google.android.gms.internal.ads.zzaiq;
import com.google.android.gms.internal.ads.zzakt;
import com.google.android.gms.internal.ads.zzaln;
import com.google.android.gms.internal.ads.zzamq;
import com.google.android.gms.internal.ads.zzay;
import com.google.android.gms.internal.ads.zzcy;
import com.google.android.gms.internal.ads.zzfa;
import com.google.android.gms.internal.ads.zzfb;
import com.google.android.gms.internal.ads.zzgy;
import com.google.android.gms.internal.ads.zzhb;
import com.google.android.gms.internal.ads.zzhe;
import com.google.android.gms.internal.ads.zzhf;
import com.google.android.gms.internal.ads.zzhg;
import com.google.android.gms.internal.ads.zzhh;
import com.google.android.gms.internal.ads.zzho;
import com.google.android.gms.internal.ads.zzhp;
import com.google.android.gms.internal.ads.zzix;
import com.google.android.gms.internal.ads.zzko;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

final class zzagz {
    private final List<zzagx> zza;
    private final IdentityHashMap<zzhe, zzagx> zzb;
    private final Map<Object, zzagx> zzc;
    private final zzagy zzd;
    private final zzho zze;
    private final zzfa zzf;
    private final HashMap<zzagx, zzagw> zzg;
    private final Set<zzagx> zzh;
    private boolean zzi;
    private zzay zzj;
    private zzix zzk;

    public zzagz(zzagy zzagy2, zzcy zzcy2, Handler handler) {
        this.zzd = zzagy2;
        this.zzk = new zzix(0);
        this.zzb = new IdentityHashMap();
        this.zzc = new HashMap<Object, zzagx>();
        this.zza = new ArrayList<zzagx>();
        this.zze = new zzho();
        this.zzf = new zzfa();
        this.zzg = new HashMap();
        this.zzh = new HashSet<zzagx>();
        this.zze.zzb(handler, (zzhp)zzcy2);
        this.zzf.zzb(handler, (zzfb)zzcy2);
    }

    static /* synthetic */ zzho zza(zzagz zzagz2) {
        return zzagz2.zze;
    }

    static /* synthetic */ zzfa zzb(zzagz zzagz2) {
        return zzagz2.zzf;
    }

    private final void zzp() {
        Iterator<zzagx> iterator = this.zzh.iterator();
        while (iterator.hasNext()) {
            zzagx zzagx2 = iterator.next();
            if (!zzagx2.zzc.isEmpty()) continue;
            this.zzq(zzagx2);
            iterator.remove();
        }
    }

    private final void zzq(zzagx zzagx2) {
        if ((zzagx2 = this.zzg.get(zzagx2)) == null) return;
        zzagx2.zza.zzq(zzagx2.zzb);
    }

    private final void zzr(int n, int n2) {
        int n3;
        while ((n3 = n2 - 1) >= n) {
            zzagx zzagx2 = this.zza.remove(n3);
            this.zzc.remove(zzagx2.zzb);
            this.zzs(n3, -zzagx2.zza.zzy().zza());
            zzagx2.zze = true;
            n2 = n3;
            if (!this.zzi) continue;
            this.zzu(zzagx2);
            n2 = n3;
        }
    }

    private final void zzs(int n, int n2) {
        while (n < this.zza.size()) {
            zzagx zzagx2 = this.zza.get(n);
            zzagx2.zzd += n2;
            ++n;
        }
    }

    private final void zzt(zzagx zzagx2) {
        zzhb zzhb2 = zzagx2.zza;
        zzagu zzagu2 = new zzagu(this);
        zzagv zzagv2 = new zzagv(this, zzagx2);
        this.zzg.put(zzagx2, new zzagw((zzhh)zzhb2, (zzhg)zzagu2, zzagv2));
        zzhb2.zzk(new Handler(zzamq.zzk(), null), (zzhp)zzagv2);
        zzhb2.zzm(new Handler(zzamq.zzk(), null), (zzfb)zzagv2);
        zzhb2.zzo((zzhg)zzagu2, this.zzj);
    }

    private final void zzu(zzagx zzagx2) {
        if (!zzagx2.zze) return;
        if (!zzagx2.zzc.isEmpty()) return;
        zzagw zzagw2 = this.zzg.remove(zzagx2);
        if (zzagw2 == null) throw null;
        zzagw2.zza.zzr(zzagw2.zzb);
        zzagw2.zza.zzl((zzhp)zzagw2.zzc);
        zzagw2.zza.zzn((zzfb)zzagw2.zzc);
        this.zzh.remove(zzagx2);
    }

    public final boolean zzc() {
        return this.zzi;
    }

    public final int zzd() {
        return this.zza.size();
    }

    public final void zze(zzay zzay2) {
        zzakt.zzd((boolean)(this.zzi ^ true));
        this.zzj = zzay2;
        int n = 0;
        while (true) {
            if (n >= this.zza.size()) {
                this.zzi = true;
                return;
            }
            zzay2 = this.zza.get(n);
            this.zzt((zzagx)zzay2);
            this.zzh.add((zzagx)zzay2);
            ++n;
        }
    }

    public final void zzf(zzhe zzhe2) {
        zzagx zzagx2 = this.zzb.remove(zzhe2);
        if (zzagx2 == null) throw null;
        zzagx2.zza.zzA(zzhe2);
        zzagx2.zzc.remove(((zzgy)zzhe2).zza);
        if (!this.zzb.isEmpty()) {
            this.zzp();
        }
        this.zzu(zzagx2);
    }

    public final void zzg() {
        Iterator<zzagw> iterator = this.zzg.values().iterator();
        while (true) {
            if (!iterator.hasNext()) {
                this.zzg.clear();
                this.zzh.clear();
                this.zzi = false;
                return;
            }
            zzagw zzagw2 = iterator.next();
            try {
                zzagw2.zza.zzr(zzagw2.zzb);
            }
            catch (RuntimeException runtimeException) {
                zzaln.zzb((String)"MediaSourceList", (String)"Failed to release child source.", (Throwable)runtimeException);
            }
            zzagw2.zza.zzl((zzhp)zzagw2.zzc);
            zzagw2.zza.zzn((zzfb)zzagw2.zzc);
        }
    }

    public final zzaiq zzh() {
        if (this.zza.isEmpty()) return zzaiq.zzc;
        int n = 0;
        int n2 = 0;
        while (n < this.zza.size()) {
            zzagx zzagx2 = this.zza.get(n);
            zzagx2.zzd = n2;
            n2 += zzagx2.zza.zzy().zza();
            ++n;
        }
        return new zzaht(this.zza, this.zzk, null);
    }

    final /* synthetic */ void zzi(zzhh zzhh2, zzaiq zzaiq2) {
        this.zzd.zzl();
    }

    public final zzaiq zzj(List<zzagx> list, zzix zzix2) {
        this.zzr(0, this.zza.size());
        return this.zzk(this.zza.size(), list, zzix2);
    }

    public final zzaiq zzk(int n, List<zzagx> list, zzix zzix2) {
        if (list.isEmpty()) return this.zzh();
        this.zzk = zzix2;
        int n2 = n;
        while (n2 < list.size() + n) {
            zzix2 = list.get(n2 - n);
            if (n2 > 0) {
                zzagx zzagx2 = this.zza.get(n2 - 1);
                zzaiq zzaiq2 = zzagx2.zza.zzy();
                zzix2.zza(zzagx2.zzd + zzaiq2.zza());
            } else {
                zzix2.zza(0);
            }
            this.zzs(n2, zzix2.zza.zzy().zza());
            this.zza.add(n2, (zzagx)zzix2);
            this.zzc.put(zzix2.zzb, (zzagx)zzix2);
            if (this.zzi) {
                this.zzt((zzagx)zzix2);
                if (this.zzb.isEmpty()) {
                    this.zzh.add((zzagx)zzix2);
                } else {
                    this.zzq((zzagx)zzix2);
                }
            }
            ++n2;
        }
        return this.zzh();
    }

    public final zzaiq zzl(int n, int n2, zzix zzix2) {
        boolean bl;
        boolean bl2 = bl = false;
        if (n >= 0) {
            bl2 = bl;
            if (n <= n2) {
                bl2 = bl;
                if (n2 <= this.zzd()) {
                    bl2 = true;
                }
            }
        }
        zzakt.zza((boolean)bl2);
        this.zzk = zzix2;
        this.zzr(n, n2);
        return this.zzh();
    }

    public final zzaiq zzm(int n, int n2, int n3, zzix zzix2) {
        boolean bl = this.zzd() >= 0;
        zzakt.zza((boolean)bl);
        this.zzk = null;
        return this.zzh();
    }

    public final zzaiq zzn(zzix zzix2) {
        int n = this.zzd();
        zzix zzix3 = zzix2;
        if (zzix2.zza() != n) {
            zzix3 = zzix2.zzh().zzf(0, n);
        }
        this.zzk = zzix3;
        return this.zzh();
    }

    public final zzhe zzo(zzhf zzhf2, zzko zzko2, long l) {
        Object object = ((Pair)zzhf2.zza).first;
        zzhf2 = zzhf2.zzc(((Pair)zzhf2.zza).second);
        if ((object = this.zzc.get(object)) == null) throw null;
        this.zzh.add((zzagx)object);
        zzagw zzagw2 = this.zzg.get(object);
        if (zzagw2 != null) {
            zzagw2.zza.zzp(zzagw2.zzb);
        }
        ((zzagx)object).zzc.add(zzhf2);
        zzhf2 = ((zzagx)object).zza.zzB(zzhf2, zzko2, l);
        this.zzb.put((zzhe)zzhf2, (zzagx)object);
        this.zzp();
        return zzhf2;
    }
}
