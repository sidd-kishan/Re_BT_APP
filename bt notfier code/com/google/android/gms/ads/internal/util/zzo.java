/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.net.ConnectivityManager$NetworkCallback
 *  android.net.Network
 *  com.google.android.gms.ads.internal.util.zzs
 */
package com.google.android.gms.ads.internal.util;

import android.net.ConnectivityManager;
import android.net.Network;
import com.google.android.gms.ads.internal.util.zzs;

final class zzo
extends ConnectivityManager.NetworkCallback {
    zzo(zzs zzs2) {
    }

    public final void onAvailable(Network network) {
        synchronized (zzs.class) {
            zzs.zza((boolean)true);
            return;
        }
    }

    public final void onLost(Network network) {
        synchronized (zzs.class) {
            zzs.zza((boolean)false);
            return;
        }
    }
}
