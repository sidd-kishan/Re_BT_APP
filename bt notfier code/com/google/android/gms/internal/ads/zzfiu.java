/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.os.Binder
 *  android.os.Bundle
 *  android.os.Looper
 *  com.google.android.gms.common.ConnectionResult
 *  com.google.android.gms.common.internal.BaseGmsClient$BaseConnectionCallbacks
 *  com.google.android.gms.common.internal.BaseGmsClient$BaseOnConnectionFailedListener
 *  com.google.android.gms.internal.ads.zzfjj
 *  com.google.android.gms.internal.ads.zzfjn
 *  com.google.android.gms.internal.ads.zzfjp
 */
package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Binder;
import android.os.Bundle;
import android.os.Looper;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.BaseGmsClient;
import com.google.android.gms.internal.ads.zzfjj;
import com.google.android.gms.internal.ads.zzfjn;
import com.google.android.gms.internal.ads.zzfjp;

final class zzfiu
implements BaseGmsClient.BaseConnectionCallbacks,
BaseGmsClient.BaseOnConnectionFailedListener {
    private final zzfjp zza;
    private final zzfjj zzb;
    private final Object zzc = new Object();
    private boolean zzd = false;
    private boolean zze = false;

    zzfiu(Context context, Looper looper, zzfjj zzfjj2) {
        this.zzb = zzfjj2;
        this.zza = new zzfjp(context, looper, (BaseGmsClient.BaseConnectionCallbacks)this, (BaseGmsClient.BaseOnConnectionFailedListener)this, 12800000);
    }

    private final void zzb() {
        Object object = this.zzc;
        synchronized (object) {
            if (this.zza.isConnected() || this.zza.isConnecting()) {
                this.zza.disconnect();
            }
            Binder.flushPendingCommands();
            return;
        }
    }

    /*
     * Unable to fully structure code
     * Enabled unnecessary exception pruning
     */
    public final void onConnected(Bundle var1_1) {
        var1_1 /* !! */  = this.zzc;
        synchronized (var1_1 /* !! */ ) {
            if (this.zze) {
                return;
            }
            this.zze = true;
            try {
                var3_2 = this.zza.zzp();
                var2_3 = new zzfjn(this.zzb.zzao());
                var3_2.zzf(var2_3);
lbl10:
                // 2 sources

                while (true) {
                    this.zzb();
                    break;
                }
            }
            catch (Throwable var2_4) {
                this.zzb();
                throw var2_4;
            }
            catch (Exception var2_5) {
                ** continue;
            }
            return;
        }
    }

    public final void onConnectionFailed(ConnectionResult connectionResult) {
    }

    public final void onConnectionSuspended(int n) {
    }

    final void zza() {
        Object object = this.zzc;
        synchronized (object) {
            if (this.zzd) return;
            this.zzd = true;
            this.zza.checkAvailabilityAndConnect();
            return;
        }
    }
}
