/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.net.ConnectivityManager$NetworkCallback
 *  android.net.Network
 *  android.net.NetworkCapabilities
 *  com.google.android.gms.internal.ads.zzaav
 */
package com.google.android.gms.internal.ads;

import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import com.google.android.gms.internal.ads.zzaav;

final class zzaau
extends ConnectivityManager.NetworkCallback {
    final zzaav zza;

    zzaau(zzaav zzaav2) {
        this.zza = zzaav2;
    }

    public final void onCapabilitiesChanged(Network network, NetworkCapabilities networkCapabilities) {
        synchronized (zzaav.class) {
            zzaav.zza((zzaav)this.zza, (NetworkCapabilities)networkCapabilities);
            return;
        }
    }

    public final void onLost(Network network) {
        synchronized (zzaav.class) {
            zzaav.zza((zzaav)this.zza, null);
            return;
        }
    }
}
