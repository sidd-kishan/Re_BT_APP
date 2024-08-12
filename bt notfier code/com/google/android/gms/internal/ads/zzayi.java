/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.common.ConnectionResult
 *  com.google.android.gms.common.internal.BaseGmsClient$BaseOnConnectionFailedListener
 *  com.google.android.gms.internal.ads.zzayj
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.BaseGmsClient;
import com.google.android.gms.internal.ads.zzayj;

final class zzayi
implements BaseGmsClient.BaseOnConnectionFailedListener {
    final zzayj zza;

    zzayi(zzayj zzayj2) {
        this.zza = zzayj2;
    }

    public final void onConnectionFailed(ConnectionResult object) {
        object = zzayj.zza((zzayj)this.zza);
        synchronized (object) {
            zzayj.zzk((zzayj)this.zza, null);
            if (zzayj.zzb((zzayj)this.zza) != null) {
                zzayj.zzc((zzayj)this.zza, null);
            }
            zzayj.zza((zzayj)this.zza).notifyAll();
            return;
        }
    }
}
