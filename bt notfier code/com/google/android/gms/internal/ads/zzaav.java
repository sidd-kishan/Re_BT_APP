/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.net.ConnectivityManager
 *  android.net.ConnectivityManager$NetworkCallback
 *  android.net.NetworkCapabilities
 *  android.os.Build$VERSION
 *  com.google.android.gms.internal.ads.zzaau
 */
package com.google.android.gms.internal.ads;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkCapabilities;
import android.os.Build;
import com.google.android.gms.internal.ads.zzaau;

public final class zzaav {
    private NetworkCapabilities zza;

    zzaav(ConnectivityManager connectivityManager) {
        if (connectivityManager == null) return;
        if (Build.VERSION.SDK_INT < 24) {
            return;
        }
        try {
            zzaau zzaau2 = new zzaau(this);
            connectivityManager.registerDefaultNetworkCallback((ConnectivityManager.NetworkCallback)zzaau2);
            return;
        }
        catch (RuntimeException runtimeException) {
            synchronized (zzaav.class) {
                this.zza = null;
                return;
            }
        }
    }

    static /* synthetic */ NetworkCapabilities zza(zzaav zzaav2, NetworkCapabilities networkCapabilities) {
        zzaav2.zza = networkCapabilities;
        return networkCapabilities;
    }

    public static zzaav zzb(Context context) {
        if (context == null) return null;
        return new zzaav((ConnectivityManager)context.getSystemService("connectivity"));
    }

    public final NetworkCapabilities zzc() {
        return this.zza;
    }

    public final long zzd() {
        synchronized (zzaav.class) {
            NetworkCapabilities networkCapabilities = this.zza;
            if (networkCapabilities == null) return -1L;
            if (networkCapabilities.hasTransport(4)) {
                return 2L;
            }
            if (this.zza.hasTransport(1)) {
                return 1L;
            }
            if (!this.zza.hasTransport(0)) return -1L;
            return 0L;
        }
    }
}
