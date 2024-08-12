/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Binder
 *  com.google.android.gms.ads.internal.util.zze
 *  com.google.android.gms.common.ConnectionResult
 *  com.google.android.gms.common.internal.BaseGmsClient$BaseConnectionCallbacks
 *  com.google.android.gms.common.internal.BaseGmsClient$BaseOnConnectionFailedListener
 *  com.google.android.gms.internal.ads.zzcau
 *  com.google.android.gms.internal.ads.zzcbj
 *  com.google.android.gms.internal.ads.zzchl
 *  com.google.android.gms.internal.ads.zzeap
 */
package com.google.android.gms.internal.ads;

import android.os.Binder;
import com.google.android.gms.ads.internal.util.zze;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.BaseGmsClient;
import com.google.android.gms.internal.ads.zzcau;
import com.google.android.gms.internal.ads.zzcbj;
import com.google.android.gms.internal.ads.zzchl;
import com.google.android.gms.internal.ads.zzeap;
import java.io.InputStream;

public abstract class zzeaa
implements BaseGmsClient.BaseConnectionCallbacks,
BaseGmsClient.BaseOnConnectionFailedListener {
    protected final zzchl<InputStream> zza = new zzchl();
    protected final Object zzb = new Object();
    protected boolean zzc = false;
    protected boolean zzd = false;
    protected zzcbj zze;
    protected zzcau zzf;

    public void onConnectionFailed(ConnectionResult connectionResult) {
        com.google.android.gms.ads.internal.util.zze.zzd((String)"Disconnected from remote ad request service.");
        this.zza.zzd((Throwable)new zzeap(1));
    }

    public final void onConnectionSuspended(int n) {
        com.google.android.gms.ads.internal.util.zze.zzd((String)"Cannot connect to remote service, fallback to local instance.");
    }

    protected final void zza() {
        Object object = this.zzb;
        synchronized (object) {
            this.zzd = true;
            if (this.zzf.isConnected() || this.zzf.isConnecting()) {
                this.zzf.disconnect();
            }
            Binder.flushPendingCommands();
            return;
        }
    }
}
