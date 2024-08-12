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
 *  com.google.android.gms.internal.ads.zzfii
 *  com.google.android.gms.internal.ads.zzfjp
 *  com.google.android.gms.internal.ads.zzfju
 *  com.google.android.gms.internal.ads.zzfjz
 *  com.google.android.gms.internal.ads.zzfkb
 */
package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.HandlerThread;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.BaseGmsClient;
import com.google.android.gms.internal.ads.zzfii;
import com.google.android.gms.internal.ads.zzfjp;
import com.google.android.gms.internal.ads.zzfju;
import com.google.android.gms.internal.ads.zzfjz;
import com.google.android.gms.internal.ads.zzfkb;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

final class zzfir
implements BaseGmsClient.BaseConnectionCallbacks,
BaseGmsClient.BaseOnConnectionFailedListener {
    protected final zzfjp zza;
    private final String zzb;
    private final String zzc;
    private final LinkedBlockingQueue<zzfkb> zzd;
    private final HandlerThread zze;
    private final zzfii zzf;
    private final long zzg;
    private final int zzh;

    public zzfir(Context context, int n, int n2, String string, String string2, String string3, zzfii zzfii2) {
        this.zzb = string;
        this.zzh = n2;
        this.zzc = string2;
        this.zzf = zzfii2;
        string = new HandlerThread("GassDGClient");
        this.zze = string;
        string.start();
        this.zzg = System.currentTimeMillis();
        this.zza = new zzfjp(context, this.zze.getLooper(), (BaseGmsClient.BaseConnectionCallbacks)this, (BaseGmsClient.BaseOnConnectionFailedListener)this, 19621000);
        this.zzd = new LinkedBlockingQueue();
        this.zza.checkAvailabilityAndConnect();
    }

    static zzfkb zzc() {
        return new zzfkb(null, 1);
    }

    private final void zze(int n, long l, Exception exception) {
        this.zzf.zzc(n, System.currentTimeMillis() - l, exception);
    }

    /*
     * Enabled force condition propagation
     */
    public final void onConnected(Bundle bundle) {
        bundle = this.zzd();
        if (bundle == null) return;
        try {
            zzfjz zzfjz2 = new zzfjz(1, this.zzh, this.zzb, this.zzc);
            bundle = bundle.zzg(zzfjz2);
            this.zze(5011, this.zzg, null);
            this.zzd.put((zzfkb)bundle);
            return;
        }
        catch (Throwable throwable) {
            try {
                Exception exception = new Exception(throwable);
                this.zze(2010, this.zzg, exception);
                return;
            }
            finally {
                this.zzb();
                this.zze.quit();
            }
        }
    }

    /*
     * Enabled force condition propagation
     */
    public final void onConnectionFailed(ConnectionResult connectionResult) {
        try {
            this.zze(4012, this.zzg, null);
            this.zzd.put(zzfir.zzc());
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
            this.zze(4011, this.zzg, null);
            this.zzd.put(zzfir.zzc());
            return;
        }
        catch (InterruptedException interruptedException) {
            return;
        }
    }

    public final zzfkb zza(int n) {
        zzfkb zzfkb2;
        try {
            zzfkb2 = this.zzd.poll(50000L, TimeUnit.MILLISECONDS);
        }
        catch (InterruptedException interruptedException) {
            this.zze(2009, this.zzg, interruptedException);
            zzfkb2 = null;
        }
        this.zze(3004, this.zzg, null);
        if (zzfkb2 != null) {
            if (zzfkb2.zzc == 7) {
                zzfii.zzg((int)3);
            } else {
                zzfii.zzg((int)2);
            }
        }
        if (zzfkb2 != null) return zzfkb2;
        return zzfir.zzc();
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
