/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Bundle
 *  com.google.android.gms.common.util.Clock
 *  com.google.android.gms.internal.ads.zzbdg
 *  com.google.android.gms.internal.ads.zzcfx
 *  com.google.android.gms.internal.ads.zzcgi
 */
package com.google.android.gms.internal.ads;

import android.os.Bundle;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.internal.ads.zzbdg;
import com.google.android.gms.internal.ads.zzcfx;
import com.google.android.gms.internal.ads.zzcgi;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

public final class zzcfy {
    private final Clock zza;
    private final zzcgi zzb;
    private final LinkedList<zzcfx> zzc;
    private final Object zzd = new Object();
    private final String zze;
    private final String zzf;
    private long zzg = -1L;
    private long zzh = -1L;
    private long zzi = 0L;
    private long zzj = -1L;
    private long zzk = -1L;

    zzcfy(Clock clock, zzcgi zzcgi2, String string, String string2) {
        this.zza = clock;
        this.zzb = zzcgi2;
        this.zze = string;
        this.zzf = string2;
        this.zzc = new LinkedList();
    }

    static /* synthetic */ Clock zza(zzcfy zzcfy2) {
        return zzcfy2.zza;
    }

    public final void zzb(zzbdg zzbdg2) {
        Object object = this.zzd;
        synchronized (object) {
            long l;
            this.zzj = l = this.zza.elapsedRealtime();
            this.zzb.zzf(zzbdg2, l);
            return;
        }
    }

    public final void zzc() {
        Object object = this.zzd;
        synchronized (object) {
            this.zzb.zzg();
            return;
        }
    }

    public final void zzd() {
        Object object = this.zzd;
        synchronized (object) {
            this.zzb.zzh();
            return;
        }
    }

    public final void zze(long l) {
        Object object = this.zzd;
        synchronized (object) {
            this.zzk = l;
            if (l == -1L) return;
            this.zzb.zzb(this);
            return;
        }
    }

    public final void zzf() {
        Object object = this.zzd;
        synchronized (object) {
            if (this.zzk != -1L && this.zzg == -1L) {
                this.zzg = this.zza.elapsedRealtime();
                this.zzb.zzb(this);
            }
            this.zzb.zze();
            return;
        }
    }

    public final void zzg() {
        Object object = this.zzd;
        synchronized (object) {
            if (this.zzk == -1L) return;
            zzcfx zzcfx2 = new zzcfx(this);
            zzcfx2.zzc();
            this.zzc.add(zzcfx2);
            ++this.zzi;
            this.zzb.zzd();
            this.zzb.zzb(this);
            return;
        }
    }

    public final void zzh() {
        Object object = this.zzd;
        synchronized (object) {
            if (this.zzk == -1L) return;
            if (this.zzc.isEmpty()) return;
            zzcfx zzcfx2 = this.zzc.getLast();
            if (zzcfx2.zza() != -1L) return;
            zzcfx2.zzb();
            this.zzb.zzb(this);
            return;
        }
    }

    public final void zzi(boolean bl) {
        Object object = this.zzd;
        synchronized (object) {
            if (this.zzk == -1L) return;
            this.zzh = this.zza.elapsedRealtime();
            return;
        }
    }

    public final Bundle zzj() {
        Object object = this.zzd;
        synchronized (object) {
            try {
                Bundle bundle = new Bundle();
                bundle.putString("seq_num", this.zze);
                bundle.putString("slotid", this.zzf);
                bundle.putBoolean("ismediation", false);
                bundle.putLong("treq", this.zzj);
                bundle.putLong("tresponse", this.zzk);
                bundle.putLong("timp", this.zzg);
                bundle.putLong("tload", this.zzh);
                bundle.putLong("pcc", this.zzi);
                bundle.putLong("tfetch", -1L);
                ArrayList<Bundle> arrayList = new ArrayList<Bundle>();
                Iterator iterator = this.zzc.iterator();
                while (true) {
                    if (!iterator.hasNext()) {
                        bundle.putParcelableArrayList("tclick", arrayList);
                        return bundle;
                    }
                    arrayList.add(((zzcfx)iterator.next()).zzd());
                }
            }
            catch (Throwable throwable) {
                throw throwable;
            }
        }
    }

    public final String zzk() {
        return this.zze;
    }
}
