/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.RemoteException
 *  com.google.android.gms.ads.mediation.InitializationCompleteCallback
 *  com.google.android.gms.internal.ads.zzbrp
 *  com.google.android.gms.internal.ads.zzbwf
 *  com.google.android.gms.internal.ads.zzcgt
 */
package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.android.gms.ads.mediation.InitializationCompleteCallback;
import com.google.android.gms.internal.ads.zzbrp;
import com.google.android.gms.internal.ads.zzbwf;
import com.google.android.gms.internal.ads.zzcgt;

final class zzbwa
implements InitializationCompleteCallback {
    final zzbrp zza;

    zzbwa(zzbwf zzbwf2, zzbrp zzbrp2) {
        this.zza = zzbrp2;
    }

    public final void onInitializationFailed(String string) {
        try {
            this.zza.zzf(string);
            return;
        }
        catch (RemoteException remoteException) {
            zzcgt.zzg((String)"", (Throwable)remoteException);
            return;
        }
    }

    public final void onInitializationSucceeded() {
        try {
            this.zza.zze();
            return;
        }
        catch (RemoteException remoteException) {
            zzcgt.zzg((String)"", (Throwable)remoteException);
            return;
        }
    }
}
