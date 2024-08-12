/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Bundle
 *  android.os.DeadObjectException
 *  com.google.android.gms.ads.internal.util.zze
 *  com.google.android.gms.common.internal.BaseGmsClient$BaseConnectionCallbacks
 *  com.google.android.gms.internal.ads.zzayj
 *  com.google.android.gms.internal.ads.zzayp
 */
package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.DeadObjectException;
import com.google.android.gms.ads.internal.util.zze;
import com.google.android.gms.common.internal.BaseGmsClient;
import com.google.android.gms.internal.ads.zzayj;
import com.google.android.gms.internal.ads.zzayp;

final class zzayh
implements BaseGmsClient.BaseConnectionCallbacks {
    final zzayj zza;

    zzayh(zzayj zzayj2) {
        this.zza = zzayj2;
    }

    public final void onConnected(Bundle object) {
        object = zzayj.zza((zzayj)this.zza);
        synchronized (object) {
            try {
                try {
                    if (zzayj.zzb((zzayj)this.zza) != null) {
                        zzayj zzayj2 = this.zza;
                        zzayj.zzk((zzayj)zzayj2, (zzayp)zzayj.zzb((zzayj)zzayj2).zzq());
                    }
                }
                catch (DeadObjectException deadObjectException) {
                    zze.zzg((String)"Unable to obtain a cache service instance.", (Throwable)deadObjectException);
                    zzayj.zzj((zzayj)this.zza);
                }
                zzayj.zza((zzayj)this.zza).notifyAll();
                return;
            }
            catch (Throwable throwable) {}
            throw throwable;
        }
    }

    public final void onConnectionSuspended(int n) {
        Object object = zzayj.zza((zzayj)this.zza);
        synchronized (object) {
            zzayj.zzk((zzayj)this.zza, null);
            zzayj.zza((zzayj)this.zza).notifyAll();
            return;
        }
    }
}
