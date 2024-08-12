/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.os.Bundle
 *  android.os.RemoteException
 *  com.google.android.gms.ads.internal.overlay.zzo
 *  com.google.android.gms.ads.internal.util.zze
 *  com.google.android.gms.ads.internal.util.zzs
 *  com.google.android.gms.ads.internal.zzt
 *  com.google.android.gms.common.internal.Preconditions
 *  com.google.android.gms.dynamic.IObjectWrapper
 *  com.google.android.gms.internal.ads.zzaww
 *  com.google.android.gms.internal.ads.zzaxq
 *  com.google.android.gms.internal.ads.zzaxz
 *  com.google.android.gms.internal.ads.zzbdg
 *  com.google.android.gms.internal.ads.zzbdl
 *  com.google.android.gms.internal.ads.zzbdr
 *  com.google.android.gms.internal.ads.zzbex
 *  com.google.android.gms.internal.ads.zzbfa
 *  com.google.android.gms.internal.ads.zzbfd
 *  com.google.android.gms.internal.ads.zzbfm
 *  com.google.android.gms.internal.ads.zzbfr
 *  com.google.android.gms.internal.ads.zzbfu
 *  com.google.android.gms.internal.ads.zzbfy
 *  com.google.android.gms.internal.ads.zzbgb
 *  com.google.android.gms.internal.ads.zzbgw
 *  com.google.android.gms.internal.ads.zzbgz
 *  com.google.android.gms.internal.ads.zzbhc
 *  com.google.android.gms.internal.ads.zzbhg
 *  com.google.android.gms.internal.ads.zzbis
 *  com.google.android.gms.internal.ads.zzbkg
 *  com.google.android.gms.internal.ads.zzbzz
 *  com.google.android.gms.internal.ads.zzcac
 *  com.google.android.gms.internal.ads.zzccf
 *  com.google.android.gms.internal.ads.zzcoj
 *  com.google.android.gms.internal.ads.zzcuc
 *  com.google.android.gms.internal.ads.zzcva
 *  com.google.android.gms.internal.ads.zzelw
 *  com.google.android.gms.internal.ads.zzelx
 *  com.google.android.gms.internal.ads.zzevv
 *  com.google.android.gms.internal.ads.zzevx
 *  com.google.android.gms.internal.ads.zzevz
 *  com.google.android.gms.internal.ads.zzewa
 *  com.google.android.gms.internal.ads.zzewb
 *  com.google.android.gms.internal.ads.zzewc
 *  com.google.android.gms.internal.ads.zzfbm
 */
package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.ads.internal.overlay.zzo;
import com.google.android.gms.ads.internal.util.zze;
import com.google.android.gms.ads.internal.util.zzs;
import com.google.android.gms.ads.internal.zzt;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.internal.ads.zzaww;
import com.google.android.gms.internal.ads.zzaxq;
import com.google.android.gms.internal.ads.zzaxz;
import com.google.android.gms.internal.ads.zzbdg;
import com.google.android.gms.internal.ads.zzbdl;
import com.google.android.gms.internal.ads.zzbdr;
import com.google.android.gms.internal.ads.zzbex;
import com.google.android.gms.internal.ads.zzbfa;
import com.google.android.gms.internal.ads.zzbfd;
import com.google.android.gms.internal.ads.zzbfm;
import com.google.android.gms.internal.ads.zzbfr;
import com.google.android.gms.internal.ads.zzbfu;
import com.google.android.gms.internal.ads.zzbfy;
import com.google.android.gms.internal.ads.zzbgb;
import com.google.android.gms.internal.ads.zzbgw;
import com.google.android.gms.internal.ads.zzbgz;
import com.google.android.gms.internal.ads.zzbhc;
import com.google.android.gms.internal.ads.zzbhg;
import com.google.android.gms.internal.ads.zzbis;
import com.google.android.gms.internal.ads.zzbkg;
import com.google.android.gms.internal.ads.zzbzz;
import com.google.android.gms.internal.ads.zzcac;
import com.google.android.gms.internal.ads.zzccf;
import com.google.android.gms.internal.ads.zzcoj;
import com.google.android.gms.internal.ads.zzcuc;
import com.google.android.gms.internal.ads.zzcva;
import com.google.android.gms.internal.ads.zzelw;
import com.google.android.gms.internal.ads.zzelx;
import com.google.android.gms.internal.ads.zzevv;
import com.google.android.gms.internal.ads.zzevx;
import com.google.android.gms.internal.ads.zzevz;
import com.google.android.gms.internal.ads.zzewa;
import com.google.android.gms.internal.ads.zzewb;
import com.google.android.gms.internal.ads.zzewc;
import com.google.android.gms.internal.ads.zzfbm;
import java.util.concurrent.atomic.AtomicBoolean;

public final class zzewd
extends zzbfm
implements zzo,
zzaxq {
    protected zzcva zza;
    private final zzcoj zzb;
    private final Context zzc;
    private AtomicBoolean zzd = new AtomicBoolean();
    private final String zze;
    private final zzevx zzf;
    private final zzevv zzg;
    private long zzh = -1L;
    private zzcuc zzi;

    public zzewd(zzcoj zzcoj2, Context context, String string, zzevx zzevx2, zzevv zzevv2) {
        this.zzb = zzcoj2;
        this.zzc = context;
        this.zze = string;
        this.zzf = zzevx2;
        this.zzg = zzevv2;
        zzevv2.zzk((zzo)this);
    }

    private final void zzS(int n) {
        synchronized (this) {
            if (!this.zzd.compareAndSet(false, true)) return;
            this.zzg.zzp();
            zzcuc zzcuc2 = this.zzi;
            if (zzcuc2 != null) {
                zzt.zzf().zzc((zzaww)zzcuc2);
            }
            if (this.zza != null) {
                long l = this.zzh;
                long l2 = -1L;
                if (l != -1L) {
                    l2 = zzt.zzj().elapsedRealtime() - this.zzh;
                }
                this.zza.zze(l2, n);
            }
            this.zzj();
            return;
        }
    }

    static /* synthetic */ zzevv zzg(zzewd zzewd2) {
        return zzewd2.zzg;
    }

    /*
     * Converted monitor instructions to comments
     */
    public final zzbgz zzA() {
        // MONITORENTER : this
        // MONITOREXIT : this
        return null;
    }

    public final String zzB() {
        synchronized (this) {
            String string = this.zze;
            return string;
        }
    }

    public final zzbfu zzC() {
        return null;
    }

    public final zzbfa zzD() {
        return null;
    }

    /*
     * Converted monitor instructions to comments
     */
    public final void zzE(zzbkg zzbkg2) {
        // MONITORENTER : this
        // MONITOREXIT : this
    }

    public final void zzF(zzbex zzbex2) {
    }

    /*
     * Converted monitor instructions to comments
     */
    public final void zzG(boolean bl) {
        // MONITORENTER : this
        // MONITOREXIT : this
    }

    public final boolean zzH() {
        synchronized (this) {
            boolean bl = this.zzf.zzb();
            return bl;
        }
    }

    public final void zzI(zzccf zzccf2) {
    }

    public final void zzJ(String string) {
    }

    public final void zzK(String string) {
    }

    /*
     * Converted monitor instructions to comments
     */
    public final zzbhc zzL() {
        // MONITORENTER : this
        // MONITOREXIT : this
        return null;
    }

    /*
     * Converted monitor instructions to comments
     */
    public final void zzM(zzbis zzbis2) {
        // MONITORENTER : this
        // MONITOREXIT : this
    }

    public final void zzN(zzbhg zzbhg2) {
    }

    public final void zzO(zzbdr zzbdr2) {
        this.zzf.zzi(zzbdr2);
    }

    public final void zzP(zzaxz zzaxz2) {
        this.zzg.zzh(zzaxz2);
    }

    public final void zzQ(boolean bl) {
    }

    final /* synthetic */ void zzR() {
        this.zzS(5);
    }

    public final void zzX(zzbgw zzbgw2) {
    }

    public final void zzY(zzbdg zzbdg2, zzbfd zzbfd2) {
    }

    public final void zzZ(IObjectWrapper iObjectWrapper) {
    }

    public final void zza() {
        this.zzS(3);
    }

    public final void zzaa(zzbgb zzbgb2) {
    }

    /*
     * Converted monitor instructions to comments
     */
    public final void zzab(zzbfy zzbfy2) {
        // MONITORENTER : this
        // MONITOREXIT : this
    }

    /*
     * Enabled unnecessary exception pruning
     */
    public final void zzbp() {
        synchronized (this) {
            zzcuc zzcuc2;
            zzcva zzcva2 = this.zza;
            if (zzcva2 == null) {
                return;
            }
            this.zzh = zzt.zzj().elapsedRealtime();
            int n = this.zza.zzc();
            if (n <= 0) {
                return;
            }
            this.zzi = zzcuc2 = new zzcuc(this.zzb.zzf(), zzt.zzj());
            zzcva2 = new zzewa(this);
            zzcuc2.zzb(n, (Runnable)zzcva2);
            return;
        }
    }

    public final void zzbq() {
    }

    public final void zzbr() {
    }

    public final void zzbs(int n) {
        int n2 = n - 1;
        if (n == 0) throw null;
        if (n2 == 0) {
            this.zzS(2);
            return;
        }
        if (n2 == 1) {
            this.zzS(4);
            return;
        }
        if (n2 == 2) {
            this.zzS(3);
            return;
        }
        if (n2 != 3) {
            return;
        }
        this.zzS(6);
    }

    public final void zzd() {
    }

    public final void zze() {
        synchronized (this) {
            zzcva zzcva2 = this.zza;
            if (zzcva2 == null) return;
            zzcva2.zze(zzt.zzj().elapsedRealtime() - this.zzh, 1);
            return;
        }
    }

    public final void zzh() {
        this.zzb.zze().execute((Runnable)new zzevz(this));
    }

    public final IObjectWrapper zzi() {
        return null;
    }

    public final void zzj() {
        synchronized (this) {
            Preconditions.checkMainThread((String)"destroy must be called on the main UI thread.");
            zzcva zzcva2 = this.zza;
            if (zzcva2 == null) return;
            zzcva2.zzT();
            return;
        }
    }

    public final boolean zzk() {
        return false;
    }

    /*
     * Enabled unnecessary exception pruning
     */
    public final boolean zzl(zzbdg zzbdg2) throws RemoteException {
        synchronized (this) {
            AtomicBoolean atomicBoolean;
            Preconditions.checkMainThread((String)"loadAd must be called on the main UI thread.");
            zzt.zzc();
            if (zzs.zzK((Context)this.zzc) && zzbdg2.zzs == null) {
                com.google.android.gms.ads.internal.util.zze.zzf((String)"Failed to load the ad because app ID is missing.");
                this.zzg.zzbD(zzfbm.zzd((int)4, null, null));
                return false;
            }
            boolean bl = this.zzH();
            if (bl) {
                return false;
            }
            this.zzd = atomicBoolean = new AtomicBoolean();
            zzewb zzewb2 = new zzewb(this);
            zzevx zzevx2 = this.zzf;
            String string = this.zze;
            atomicBoolean = new zzewc(this);
            return zzevx2.zza(zzbdg2, string, (zzelw)zzewb2, (zzelx)atomicBoolean);
        }
    }

    public final void zzm() {
        synchronized (this) {
            Preconditions.checkMainThread((String)"pause must be called on the main UI thread.");
            return;
        }
    }

    public final void zzn() {
        synchronized (this) {
            Preconditions.checkMainThread((String)"resume must be called on the main UI thread.");
            return;
        }
    }

    public final void zzo(zzbfa zzbfa2) {
    }

    public final void zzp(zzbfu zzbfu2) {
    }

    public final void zzq(zzbfr zzbfr2) {
    }

    public final Bundle zzr() {
        return new Bundle();
    }

    /*
     * Converted monitor instructions to comments
     */
    public final void zzs() {
        // MONITORENTER : this
        // MONITOREXIT : this
    }

    /*
     * Converted monitor instructions to comments
     */
    public final void zzt() {
        // MONITORENTER : this
        // MONITOREXIT : this
    }

    /*
     * Converted monitor instructions to comments
     */
    public final zzbdl zzu() {
        // MONITORENTER : this
        // MONITOREXIT : this
        return null;
    }

    public final void zzv(zzbdl zzbdl2) {
        synchronized (this) {
            Preconditions.checkMainThread((String)"setAdSize must be called on the main UI thread.");
            return;
        }
    }

    public final void zzw(zzbzz zzbzz2) {
    }

    public final void zzx(zzcac zzcac2, String string) {
    }

    /*
     * Converted monitor instructions to comments
     */
    public final String zzy() {
        // MONITORENTER : this
        // MONITOREXIT : this
        return null;
    }

    /*
     * Converted monitor instructions to comments
     */
    public final String zzz() {
        // MONITORENTER : this
        // MONITOREXIT : this
        return null;
    }
}
