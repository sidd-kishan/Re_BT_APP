/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.os.Bundle
 *  android.os.DeadObjectException
 *  android.os.HandlerThread
 *  com.google.android.gms.common.ConnectionResult
 *  com.google.android.gms.common.internal.BaseGmsClient$BaseConnectionCallbacks
 *  com.google.android.gms.common.internal.BaseGmsClient$BaseOnConnectionFailedListener
 *  com.google.android.gms.internal.ads.zzfjp
 *  com.google.android.gms.internal.ads.zzfjq
 *  com.google.android.gms.internal.ads.zzfju
 *  com.google.android.gms.internal.ads.zzyj
 *  com.google.android.gms.internal.ads.zzyz
 */
package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.HandlerThread;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.BaseGmsClient;
import com.google.android.gms.internal.ads.zzfjp;
import com.google.android.gms.internal.ads.zzfjq;
import com.google.android.gms.internal.ads.zzfju;
import com.google.android.gms.internal.ads.zzyj;
import com.google.android.gms.internal.ads.zzyz;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

final class zzfip
implements BaseGmsClient.BaseConnectionCallbacks,
BaseGmsClient.BaseOnConnectionFailedListener {
    protected final zzfjp zza;
    private final String zzb;
    private final String zzc;
    private final LinkedBlockingQueue<zzyz> zzd;
    private final HandlerThread zze;

    public zzfip(Context context, String string, String string2) {
        this.zzb = string;
        this.zzc = string2;
        string = new HandlerThread("GassClient");
        this.zze = string;
        string.start();
        this.zza = new zzfjp(context, this.zze.getLooper(), (BaseGmsClient.BaseConnectionCallbacks)this, (BaseGmsClient.BaseOnConnectionFailedListener)this, 9200000);
        this.zzd = new LinkedBlockingQueue();
        this.zza.checkAvailabilityAndConnect();
    }

    static zzyz zzc() {
        zzyj zzyj2 = zzyz.zzi();
        zzyj2.zzl(32768L);
        return (zzyz)zzyj2.zzah();
    }

    /*
     * Unable to fully structure code
     */
    public final void onConnected(Bundle var1_1) {
        var1_1 = this.zzd();
        if (var1_1 == null) return;
        try {
            var2_5 = new zzfjq(this.zzb, this.zzc);
            var1_1 = var1_1.zze(var2_5).zza();
            this.zzd.put((zzyz)var1_1);
lbl7:
            // 3 sources

            while (true) {
                this.zzb();
                break;
            }
        }
        catch (Throwable var1_2) {
            try {
                this.zzd.put(zzfip.zzc());
                ** GOTO lbl7
            }
            catch (Throwable var1_3) {
                this.zzb();
                this.zze.quit();
                throw var1_3;
            }
            catch (InterruptedException var1_4) {
                ** continue;
            }
        }
        this.zze.quit();
    }

    /*
     * Enabled force condition propagation
     */
    public final void onConnectionFailed(ConnectionResult connectionResult) {
        try {
            this.zzd.put(zzfip.zzc());
            return;
        }
        catch (InterruptedException interruptedException) {
            return;
        }
    }

    /*
     * Enabled force condition propagation
     */
    public final void onConnectionSuspended(int n) {
        try {
            this.zzd.put(zzfip.zzc());
            return;
        }
        catch (InterruptedException interruptedException) {
            return;
        }
    }

    public final zzyz zza(int n) {
        zzyz zzyz2;
        try {
            zzyz2 = this.zzd.poll(5000L, TimeUnit.MILLISECONDS);
        }
        catch (InterruptedException interruptedException) {
            zzyz2 = null;
        }
        zzyz zzyz3 = zzyz2;
        if (zzyz2 != null) return zzyz3;
        zzyz3 = zzfip.zzc();
        return zzyz3;
    }

    public final void zzb() {
        zzfjp zzfjp2 = this.zza;
        if (zzfjp2 == null) return;
        if (!zzfjp2.isConnected()) {
            if (!this.zza.isConnecting()) return;
        }
        this.zza.disconnect();
    }

    protected final zzfju zzd() {
        try {
            zzfju zzfju2 = this.zza.zzp();
            return zzfju2;
        }
        catch (DeadObjectException | IllegalStateException throwable) {
            return null;
        }
    }
}
