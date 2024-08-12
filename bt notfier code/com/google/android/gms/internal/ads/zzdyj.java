/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.os.RemoteException
 *  com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel
 *  com.google.android.gms.ads.internal.overlay.zzm
 *  com.google.android.gms.ads.internal.overlay.zzo
 *  com.google.android.gms.ads.internal.util.zze
 *  com.google.android.gms.ads.internal.zzt
 *  com.google.android.gms.internal.ads.zzazb
 *  com.google.android.gms.internal.ads.zzbet
 *  com.google.android.gms.internal.ads.zzbgq
 *  com.google.android.gms.internal.ads.zzbjd
 *  com.google.android.gms.internal.ads.zzbjl
 *  com.google.android.gms.internal.ads.zzbps
 *  com.google.android.gms.internal.ads.zzcgz
 *  com.google.android.gms.internal.ads.zzchg
 *  com.google.android.gms.internal.ads.zzcml
 *  com.google.android.gms.internal.ads.zzcmw
 *  com.google.android.gms.internal.ads.zzcmx
 *  com.google.android.gms.internal.ads.zzcnx
 *  com.google.android.gms.internal.ads.zzcob
 *  com.google.android.gms.internal.ads.zzdyc
 *  com.google.android.gms.internal.ads.zzdyi
 *  com.google.android.gms.internal.ads.zzfbm
 *  com.google.android.gms.internal.ads.zzfsn
 */
package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel;
import com.google.android.gms.ads.internal.overlay.zzm;
import com.google.android.gms.ads.internal.overlay.zzo;
import com.google.android.gms.ads.internal.util.zze;
import com.google.android.gms.ads.internal.zzt;
import com.google.android.gms.internal.ads.zzazb;
import com.google.android.gms.internal.ads.zzbet;
import com.google.android.gms.internal.ads.zzbgq;
import com.google.android.gms.internal.ads.zzbjd;
import com.google.android.gms.internal.ads.zzbjl;
import com.google.android.gms.internal.ads.zzbps;
import com.google.android.gms.internal.ads.zzcgz;
import com.google.android.gms.internal.ads.zzchg;
import com.google.android.gms.internal.ads.zzcml;
import com.google.android.gms.internal.ads.zzcmw;
import com.google.android.gms.internal.ads.zzcmx;
import com.google.android.gms.internal.ads.zzcnx;
import com.google.android.gms.internal.ads.zzcob;
import com.google.android.gms.internal.ads.zzdyc;
import com.google.android.gms.internal.ads.zzdyi;
import com.google.android.gms.internal.ads.zzfbm;
import com.google.android.gms.internal.ads.zzfsn;

public final class zzdyj
implements zzo,
zzcnx {
    private final Context zza;
    private final zzcgz zzb;
    private zzdyc zzc;
    private zzcml zzd;
    private boolean zze;
    private boolean zzf;
    private long zzg;
    private zzbgq zzh;
    private boolean zzi;

    zzdyj(Context context, zzcgz zzcgz2) {
        this.zza = context;
        this.zzb = zzcgz2;
    }

    /*
     * Loose catch block
     * Enabled unnecessary exception pruning
     * Converted monitor instructions to comments
     */
    private final boolean zzj(zzbgq zzbgq2) {
        // MONITORENTER : this
        zzbjd zzbjd2 = zzbjl.zzgp;
        if (!((Boolean)zzbet.zzc().zzc(zzbjd2)).booleanValue()) {
            com.google.android.gms.ads.internal.util.zze.zzi((String)"Ad inspector had an internal error.");
            zzbgq2.zze(zzfbm.zzd((int)16, null, null));
            // MONITOREXIT : this
            return false;
        }
        if (this.zzc == null) {
            com.google.android.gms.ads.internal.util.zze.zzi((String)"Ad inspector had an internal error.");
            zzbgq2.zze(zzfbm.zzd((int)16, null, null));
            // MONITOREXIT : this
            return false;
        }
        if (!this.zze && !this.zzf) {
            long l = zzt.zzj().currentTimeMillis();
            long l2 = this.zzg;
            zzbjd2 = zzbjl.zzgs;
            int n = (Integer)zzbet.zzc().zzc(zzbjd2);
            if (l >= l2 + (long)n) {
                // MONITOREXIT : this
                return true;
            }
        }
        com.google.android.gms.ads.internal.util.zze.zzi((String)"Ad inspector cannot be opened because it is already open.");
        try {
            zzbgq2.zze(zzfbm.zzd((int)19, null, null));
            // MONITOREXIT : this
            return false;
        }
        catch (RemoteException remoteException) {
            return false;
        }
        catch (RemoteException remoteException) {
            return false;
        }
        catch (RemoteException remoteException) {
            return false;
        }
    }

    private final void zzk() {
        synchronized (this) {
            if (!this.zze) return;
            if (!this.zzf) {
                return;
            }
            zzfsn zzfsn2 = zzchg.zze;
            zzdyi zzdyi2 = new zzdyi(this);
            zzfsn2.execute((Runnable)zzdyi2);
            return;
        }
    }

    /*
     * Unable to fully structure code
     */
    public final void zza(boolean var1_1) {
        synchronized (this) {
            block7: {
                if (!var1_1) ** GOTO lbl8
                com.google.android.gms.ads.internal.util.zze.zza((String)"Ad inspector loaded.");
                this.zze = true;
                this.zzk();
                return;
lbl8:
                // 1 sources

                com.google.android.gms.ads.internal.util.zze.zzi((String)"Ad inspector failed to load.");
                var2_2 = this.zzh;
                if (var2_2 != null) {
                    var2_2.zze(zzfbm.zzd((int)17, null, null));
                }
lbl13:
                // 4 sources

                while (true) {
                    this.zzi = true;
                    break block7;
                    break;
                }
                catch (RemoteException var2_4) {
                    ** continue;
                }
            }
            this.zzd.destroy();
            return;
        }
    }

    public final void zzbp() {
        synchronized (this) {
            this.zzf = true;
            this.zzk();
            return;
        }
    }

    public final void zzbq() {
    }

    public final void zzbr() {
    }

    public final void zzbs(int n) {
        synchronized (this) {
            this.zzd.destroy();
            if (!this.zzi) {
                com.google.android.gms.ads.internal.util.zze.zza((String)"Inspector closed.");
                zzbgq zzbgq2 = this.zzh;
                if (zzbgq2 != null) {
                    try {
                        zzbgq2.zze(null);
                    }
                    catch (RemoteException remoteException) {}
                }
            }
            this.zzf = false;
            this.zze = false;
            this.zzg = 0L;
            this.zzi = false;
            this.zzh = null;
            return;
        }
    }

    public final void zzd() {
    }

    public final void zze() {
    }

    public final void zzg(zzdyc zzdyc2) {
        this.zzc = zzdyc2;
    }

    /*
     * Enabled unnecessary exception pruning
     */
    public final void zzh(zzbgq zzbgq2, zzbps object2) {
        synchronized (this) {
            Context context;
            boolean bl = this.zzj(zzbgq2);
            if (!bl) {
                return;
            }
            try {
                zzt.zzd();
                context = this.zza;
                zzcgz zzcgz2 = this.zzb;
                context = zzcmx.zza((Context)context, (zzcob)zzcob.zzb(), (String)"", (boolean)false, (boolean)false, null, null, (zzcgz)zzcgz2, null, null, null, (zzazb)zzazb.zza(), null, null);
                this.zzd = context;
            }
            catch (zzcmw object2) {
                com.google.android.gms.ads.internal.util.zze.zzj((String)"Failed to obtain a web view for the ad inspector", (Throwable)object2);
                try {
                    zzbgq2.zze(zzfbm.zzd((int)17, (String)"Failed to obtain a web view for the ad inspector", null));
                    return;
                }
                catch (RemoteException remoteException) {
                    return;
                }
            }
            context = context.zzR();
            if (context != null) {
                zzcml zzcml2;
                this.zzh = zzbgq2;
                context.zzL(null, null, null, null, null, false, null, null, null, null, null, null, null, null, (zzbps)zzcml2, null);
                context.zzy((zzcnx)this);
                zzcml2 = this.zzd;
                zzbgq2 = zzbjl.zzgq;
                zzcml2.loadUrl((String)zzbet.zzc().zzc((zzbjd)zzbgq2));
                zzt.zzb();
                zzcml2 = this.zza;
                zzbgq2 = new AdOverlayInfoParcel((zzo)this, this.zzd, 1, this.zzb);
                zzm.zza((Context)zzcml2, (AdOverlayInfoParcel)zzbgq2, (boolean)true);
                this.zzg = zzt.zzj().currentTimeMillis();
                return;
            }
            com.google.android.gms.ads.internal.util.zze.zzi((String)"Failed to obtain a web view for the ad inspector");
            try {
                zzbgq2.zze(zzfbm.zzd((int)17, (String)"Failed to obtain a web view for the ad inspector", null));
                return;
            }
            catch (RemoteException remoteException) {
                return;
            }
        }
    }

    final /* synthetic */ void zzi() {
        this.zzd.zzbl("window.inspectorInfo", this.zzc.zzm().toString());
    }
}
