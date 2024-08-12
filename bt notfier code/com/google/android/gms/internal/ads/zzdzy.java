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
 *  com.google.android.gms.internal.ads.zzchl
 *  com.google.android.gms.internal.ads.zzdzz
 *  com.google.android.gms.internal.ads.zzeaa
 *  com.google.android.gms.internal.ads.zzeap
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
import com.google.android.gms.internal.ads.zzchl;
import com.google.android.gms.internal.ads.zzdzz;
import com.google.android.gms.internal.ads.zzeaa;
import com.google.android.gms.internal.ads.zzeap;

public final class zzdzy
extends zzeaa {
    public zzdzy(Context context) {
        this.zzf = new zzcau(context, zzt.zzq().zza(), (BaseGmsClient.BaseConnectionCallbacks)this, (BaseGmsClient.BaseOnConnectionFailedListener)this);
    }

    /*
     * Enabled unnecessary exception pruning
     */
    public final void onConnected(Bundle object) {
        object = this.zzb;
        synchronized (object) {
            if (this.zzd) return;
            this.zzd = true;
            try {
                zzcbb zzcbb2 = this.zzf.zzp();
                zzcbj zzcbj2 = this.zze;
                zzdzz zzdzz2 = new zzdzz((zzeaa)this);
                zzcbb2.zze(zzcbj2, (zzcbf)zzdzz2);
            }
            catch (Throwable throwable) {
                zzt.zzg().zzk(throwable, "RemoteAdRequestClientTask.onConnected");
                zzchl zzchl2 = this.zza;
                zzeap zzeap2 = new zzeap(1);
                zzchl2.zzd((Throwable)zzeap2);
            }
            catch (RemoteException | IllegalArgumentException throwable) {
                zzchl zzchl3 = this.zza;
                zzeap zzeap3 = new zzeap(1);
                zzchl3.zzd((Throwable)zzeap3);
            }
            return;
        }
    }

    public final void onConnectionFailed(ConnectionResult connectionResult) {
        zze.zzd((String)"Cannot connect to remote service, fallback to local instance.");
        this.zza.zzd((Throwable)new zzeap(1));
    }
}
