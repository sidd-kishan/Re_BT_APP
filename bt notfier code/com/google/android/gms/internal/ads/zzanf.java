/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Handler
 *  android.os.Looper
 *  android.os.Message
 *  android.util.Log
 *  com.google.android.gms.internal.ads.zzamx
 *  com.google.android.gms.internal.ads.zzamy
 *  com.google.android.gms.internal.ads.zzamz
 *  com.google.android.gms.internal.ads.zzanb
 *  com.google.android.gms.internal.ads.zzanc
 *  com.google.android.gms.internal.ads.zzane
 *  com.google.android.gms.internal.ads.zzanh
 *  com.google.android.gms.internal.ads.zzanj
 *  com.google.android.gms.internal.ads.zzank
 *  com.google.android.gms.internal.ads.zzano
 *  com.google.android.gms.internal.ads.zzanq
 *  com.google.android.gms.internal.ads.zzanr
 *  com.google.android.gms.internal.ads.zzanv
 *  com.google.android.gms.internal.ads.zzanw
 *  com.google.android.gms.internal.ads.zzanx
 *  com.google.android.gms.internal.ads.zzasr
 *  com.google.android.gms.internal.ads.zzatg
 *  com.google.android.gms.internal.ads.zzatk
 *  com.google.android.gms.internal.ads.zzats
 *  com.google.android.gms.internal.ads.zzatu
 *  com.google.android.gms.internal.ads.zzatv
 *  com.google.android.gms.internal.ads.zzave
 *  com.google.android.gms.internal.ads.zzcjy
 */
package com.google.android.gms.internal.ads;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import com.google.android.gms.internal.ads.zzamx;
import com.google.android.gms.internal.ads.zzamy;
import com.google.android.gms.internal.ads.zzamz;
import com.google.android.gms.internal.ads.zzanb;
import com.google.android.gms.internal.ads.zzanc;
import com.google.android.gms.internal.ads.zzane;
import com.google.android.gms.internal.ads.zzanh;
import com.google.android.gms.internal.ads.zzanj;
import com.google.android.gms.internal.ads.zzank;
import com.google.android.gms.internal.ads.zzano;
import com.google.android.gms.internal.ads.zzanq;
import com.google.android.gms.internal.ads.zzanr;
import com.google.android.gms.internal.ads.zzanv;
import com.google.android.gms.internal.ads.zzanw;
import com.google.android.gms.internal.ads.zzanx;
import com.google.android.gms.internal.ads.zzasr;
import com.google.android.gms.internal.ads.zzatg;
import com.google.android.gms.internal.ads.zzatk;
import com.google.android.gms.internal.ads.zzats;
import com.google.android.gms.internal.ads.zzatu;
import com.google.android.gms.internal.ads.zzatv;
import com.google.android.gms.internal.ads.zzave;
import com.google.android.gms.internal.ads.zzcjy;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArraySet;

final class zzanf
implements zzanc {
    private final zzanr[] zza;
    private final zzatu zzb;
    private final zzats zzc;
    private final Handler zzd;
    private final zzank zze;
    private final CopyOnWriteArraySet<zzamz> zzf;
    private final zzanw zzg;
    private final zzanv zzh;
    private boolean zzi;
    private boolean zzj;
    private int zzk;
    private int zzl;
    private int zzm;
    private boolean zzn;
    private zzanx zzo;
    private Object zzp;
    private zzatg zzq;
    private zzats zzr;
    private zzanq zzs;
    private zzanh zzt;
    private long zzu;

    public zzanf(zzanr[] zzanrArray, zzatu zzatu2, zzcjy zzcjy2, byte[] object) {
        object = zzave.zze;
        StringBuilder stringBuilder = new StringBuilder(String.valueOf(object).length() + 26);
        stringBuilder.append("Init ExoPlayerLib/2.4.2 [");
        stringBuilder.append((String)object);
        stringBuilder.append("]");
        Log.i((String)"ExoPlayerImpl", (String)stringBuilder.toString());
        this.zza = zzanrArray;
        if (zzatu2 == null) throw null;
        this.zzb = zzatu2;
        this.zzj = false;
        this.zzk = 1;
        this.zzf = new CopyOnWriteArraySet();
        this.zzc = new zzats(new zzatk[2], null);
        this.zzo = zzanx.zza;
        this.zzg = new zzanw();
        this.zzh = new zzanv();
        this.zzq = zzatg.zza;
        this.zzr = this.zzc;
        this.zzs = zzanq.zza;
        object = Looper.myLooper() != null ? (Object)Looper.myLooper() : (Object)Looper.getMainLooper();
        this.zzd = new zzane(this, (Looper)object);
        object = new zzanh(0, 0L);
        this.zzt = (zzanh)object;
        this.zze = new zzank(zzanrArray, zzatu2, zzcjy2, this.zzj, 0, this.zzd, (zzanh)object, (zzanc)this, null);
    }

    public final void zza(zzamz zzamz2) {
        this.zzf.add(zzamz2);
    }

    public final void zzb(zzamz zzamz2) {
        this.zzf.remove(zzamz2);
    }

    public final int zzc() {
        return this.zzk;
    }

    public final void zzd(zzasr zzasr2) {
        Iterator<zzamz> iterator;
        if (!this.zzo.zzf() || this.zzp != null) {
            this.zzo = zzanx.zza;
            this.zzp = null;
            iterator = this.zzf.iterator();
            while (iterator.hasNext()) {
                iterator.next().zza(this.zzo, this.zzp);
            }
        }
        if (this.zzi) {
            this.zzi = false;
            this.zzq = zzatg.zza;
            this.zzr = this.zzc;
            this.zzb.zze(null);
            iterator = this.zzf.iterator();
            while (iterator.hasNext()) {
                iterator.next().zzb(this.zzq, this.zzr);
            }
        }
        ++this.zzm;
        this.zze.zzb(zzasr2, true);
    }

    public final void zze(boolean bl) {
        if (this.zzj == bl) return;
        this.zzj = bl;
        this.zze.zzc(bl);
        Iterator<zzamz> iterator = this.zzf.iterator();
        while (iterator.hasNext()) {
            iterator.next().zzd(bl, this.zzk);
        }
    }

    public final boolean zzf() {
        return this.zzj;
    }

    public final void zzg(long l) {
        this.zzr();
        if (!this.zzo.zzf()) {
            if (this.zzo.zza() <= 0) throw new zzano(this.zzo, 0, l);
        }
        ++this.zzl;
        if (!this.zzo.zzf()) {
            this.zzo.zzg(0, this.zzg, false);
            zzamx.zzb((long)l);
            long l2 = this.zzo.zzd((int)0, (zzanv)this.zzh, (boolean)false).zzc;
            if (l2 != -9223372036854775807L) {
                // empty if block
            }
        }
        this.zzu = l;
        this.zze.zzd(this.zzo, 0, zzamx.zzb((long)l));
        Iterator<zzamz> iterator = this.zzf.iterator();
        while (iterator.hasNext()) {
            iterator.next().zzf();
        }
    }

    public final void zzh() {
        this.zze.zze();
    }

    public final void zzi() {
        this.zze.zzh();
        this.zzd.removeCallbacksAndMessages(null);
    }

    public final void zzj(zzanb ... zzanbArray) {
        this.zze.zzf(zzanbArray);
    }

    public final void zzk(zzanb ... zzanbArray) {
        this.zze.zzg(zzanbArray);
    }

    public final long zzl() {
        if (this.zzo.zzf()) {
            return -9223372036854775807L;
        }
        zzanx zzanx2 = this.zzo;
        this.zzr();
        return zzamx.zza((long)zzanx2.zzg((int)0, (zzanw)this.zzg, (boolean)false).zza);
    }

    public final long zzm() {
        if (this.zzo.zzf()) return this.zzu;
        if (this.zzl > 0) {
            return this.zzu;
        }
        this.zzo.zzd(this.zzt.zza, this.zzh, false);
        return zzamx.zza((long)0L) + zzamx.zza((long)this.zzt.zzc);
    }

    public final long zzn() {
        if (this.zzo.zzf()) return this.zzu;
        if (this.zzl > 0) {
            return this.zzu;
        }
        this.zzo.zzd(this.zzt.zza, this.zzh, false);
        return zzamx.zza((long)0L) + zzamx.zza((long)this.zzt.zzd);
    }

    public final void zzo() {
        this.zze.zza();
    }

    public final void zzp(int n) {
        this.zze.zzl(n);
    }

    public final void zzq(int n) {
        this.zze.zzm(n);
    }

    public final int zzr() {
        if (this.zzo.zzf()) return 0;
        if (this.zzl > 0) return 0;
        this.zzo.zzd(this.zzt.zza, this.zzh, false);
        return 0;
    }

    final void zzs(Message object) {
        int n = ((Message)object).what;
        boolean bl = true;
        switch (n) {
            default: {
                throw new IllegalStateException();
            }
            case 8: {
                object = (zzamy)((Message)object).obj;
                Iterator<zzamz> iterator = this.zzf.iterator();
                while (iterator.hasNext()) {
                    iterator.next().zze((zzamy)object);
                }
                return;
            }
            case 7: {
                zzanq zzanq2 = (zzanq)((Message)object).obj;
                if (this.zzs.equals((Object)zzanq2)) return;
                this.zzs = zzanq2;
                object = this.zzf.iterator();
                while (object.hasNext()) {
                    ((zzamz)object.next()).zzg(zzanq2);
                }
                return;
            }
            case 6: {
                object = (zzanj)((Message)object).obj;
                this.zzl -= ((zzanj)object).zzd;
                if (this.zzm != 0) return;
                this.zzo = ((zzanj)object).zza;
                this.zzp = ((zzanj)object).zzb;
                this.zzt = ((zzanj)object).zzc;
                object = this.zzf.iterator();
                while (object.hasNext()) {
                    ((zzamz)object.next()).zza(this.zzo, this.zzp);
                }
                return;
            }
            case 5: {
                if (this.zzl != 0) return;
                this.zzt = (zzanh)((Message)object).obj;
                object = this.zzf.iterator();
                while (object.hasNext()) {
                    ((zzamz)object.next()).zzf();
                }
                return;
            }
            case 4: {
                this.zzl = n = this.zzl - 1;
                if (n != 0) return;
                this.zzt = (zzanh)((Message)object).obj;
                if (((Message)object).arg1 == 0) return;
                object = this.zzf.iterator();
                while (object.hasNext()) {
                    ((zzamz)object.next()).zzf();
                }
                return;
            }
            case 3: {
                if (this.zzm != 0) return;
                object = (zzatv)((Message)object).obj;
                this.zzi = true;
                this.zzq = ((zzatv)object).zza;
                this.zzr = ((zzatv)object).zzb;
                this.zzb.zze(((zzatv)object).zzc);
                object = this.zzf.iterator();
                while (object.hasNext()) {
                    ((zzamz)object.next()).zzb(this.zzq, this.zzr);
                }
                return;
            }
            case 2: {
                if (((Message)object).arg1 == 0) {
                    bl = false;
                }
                this.zzn = bl;
                object = this.zzf.iterator();
                while (object.hasNext()) {
                    ((zzamz)object.next()).zzc(this.zzn);
                }
                return;
            }
            case 1: {
                this.zzk = ((Message)object).arg1;
                object = this.zzf.iterator();
                while (object.hasNext()) {
                    ((zzamz)object.next()).zzd(this.zzj, this.zzk);
                }
                return;
            }
            case 0: 
        }
        --this.zzm;
    }
}
