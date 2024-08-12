/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.os.Bundle
 *  android.os.RemoteException
 *  com.google.android.gms.ads.internal.util.zze
 *  com.google.android.gms.ads.internal.zzt
 *  com.google.android.gms.common.ConnectionResult
 *  com.google.android.gms.common.internal.BaseGmsClient$BaseConnectionCallbacks
 *  com.google.android.gms.common.internal.BaseGmsClient$BaseOnConnectionFailedListener
 *  com.google.android.gms.internal.ads.zzcau
 *  com.google.android.gms.internal.ads.zzcbb
 *  com.google.android.gms.internal.ads.zzcbf
 *  com.google.android.gms.internal.ads.zzcbj
 *  com.google.android.gms.internal.ads.zzchg
 *  com.google.android.gms.internal.ads.zzchl
 *  com.google.android.gms.internal.ads.zzdzz
 *  com.google.android.gms.internal.ads.zzeaa
 *  com.google.android.gms.internal.ads.zzeae
 *  com.google.android.gms.internal.ads.zzeaf
 *  com.google.android.gms.internal.ads.zzeap
 *  com.google.android.gms.internal.ads.zzfsd
 *  com.google.android.gms.internal.ads.zzfsm
 */
package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.ads.internal.util.zze;
import com.google.android.gms.ads.internal.zzt;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.BaseGmsClient;
import com.google.android.gms.internal.ads.zzcau;
import com.google.android.gms.internal.ads.zzcbb;
import com.google.android.gms.internal.ads.zzcbf;
import com.google.android.gms.internal.ads.zzcbj;
import com.google.android.gms.internal.ads.zzchg;
import com.google.android.gms.internal.ads.zzchl;
import com.google.android.gms.internal.ads.zzdzz;
import com.google.android.gms.internal.ads.zzeaa;
import com.google.android.gms.internal.ads.zzeae;
import com.google.android.gms.internal.ads.zzeaf;
import com.google.android.gms.internal.ads.zzeap;
import com.google.android.gms.internal.ads.zzfsd;
import com.google.android.gms.internal.ads.zzfsm;
import java.io.InputStream;
import java.util.concurrent.Executor;

public final class zzeag
extends zzeaa {
    private String zzg;
    private int zzh = 1;

    public zzeag(Context context) {
        this.zzf = new zzcau(context, zzt.zzq().zza(), (BaseGmsClient.BaseConnectionCallbacks)this, (BaseGmsClient.BaseOnConnectionFailedListener)this);
    }

    /*
     * Enabled unnecessary exception pruning
     */
    public final void onConnected(Bundle object) {
        object = this.zzb;
        synchronized (object) {
            block9: {
                if (this.zzd) return;
                this.zzd = true;
                try {
                    int n = this.zzh;
                    if (n == 2) {
                        zzcbb zzcbb2 = this.zzf.zzp();
                        zzcbj zzcbj2 = this.zze;
                        zzdzz zzdzz2 = new zzdzz((zzeaa)this);
                        zzcbb2.zzg(zzcbj2, (zzcbf)zzdzz2);
                        break block9;
                    }
                    if (n == 3) {
                        zzcbb zzcbb3 = this.zzf.zzp();
                        String string = this.zzg;
                        zzdzz zzdzz3 = new zzdzz((zzeaa)this);
                        zzcbb3.zzh(string, (zzcbf)zzdzz3);
                    } else {
                        zzchl zzchl2 = this.zza;
                        zzeap zzeap2 = new zzeap(1);
                        zzchl2.zzd((Throwable)zzeap2);
                    }
                }
                catch (Throwable throwable) {
                    zzt.zzg().zzk(throwable, "RemoteUrlAndCacheKeyClientTask.onConnected");
                    zzchl zzchl3 = this.zza;
                    zzeap zzeap3 = new zzeap(1);
                    zzchl3.zzd((Throwable)zzeap3);
                }
                catch (RemoteException | IllegalArgumentException throwable) {
                    zzchl zzchl4 = this.zza;
                    zzeap zzeap4 = new zzeap(1);
                    zzchl4.zzd((Throwable)zzeap4);
                }
            }
            return;
        }
    }

    public final void onConnectionFailed(ConnectionResult connectionResult) {
        zze.zzd((String)"Cannot connect to remote service, fallback to local instance.");
        this.zza.zzd((Throwable)new zzeap(1));
    }

    public final zzfsm<InputStream> zzb(zzcbj zzcbj2) {
        Object object = this.zzb;
        synchronized (object) {
            int n = this.zzh;
            if (n != 1 && n != 2) {
                zzcbj2 = new zzeap(2);
                zzcbj2 = zzfsd.zzc((Throwable)zzcbj2);
                return zzcbj2;
            }
            if (this.zzc) {
                zzcbj2 = this.zza;
                return zzcbj2;
            }
            this.zzh = 2;
            this.zzc = true;
            this.zze = zzcbj2;
            this.zzf.checkAvailabilityAndConnect();
            zzchl zzchl2 = this.zza;
            zzcbj2 = new zzeae(this);
            zzchl2.zze((Runnable)zzcbj2, (Executor)zzchg.zzf);
            zzcbj2 = this.zza;
            return zzcbj2;
        }
    }

    public final zzfsm<InputStream> zzc(String string) {
        Object object = this.zzb;
        synchronized (object) {
            int n = this.zzh;
            if (n != 1 && n != 3) {
                string = new zzeap(2);
                string = zzfsd.zzc((Throwable)((Object)string));
                return string;
            }
            if (this.zzc) {
                string = this.zza;
                return string;
            }
            this.zzh = 3;
            this.zzc = true;
            this.zzg = string;
            this.zzf.checkAvailabilityAndConnect();
            string = this.zza;
            zzeaf zzeaf2 = new zzeaf(this);
            string.zze((Runnable)zzeaf2, (Executor)zzchg.zzf);
            string = this.zza;
            return string;
        }
    }
}
