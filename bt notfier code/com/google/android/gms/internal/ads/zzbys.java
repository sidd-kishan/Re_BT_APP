/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.RemoteException
 *  android.view.View
 *  com.google.android.gms.ads.nativead.NativeCustomFormatAd$DisplayOpenMeasurement
 *  com.google.android.gms.dynamic.ObjectWrapper
 *  com.google.android.gms.internal.ads.zzbnb
 *  com.google.android.gms.internal.ads.zzcgt
 */
package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import android.view.View;
import com.google.android.gms.ads.nativead.NativeCustomFormatAd;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.internal.ads.zzbnb;
import com.google.android.gms.internal.ads.zzcgt;

public final class zzbys
implements NativeCustomFormatAd.DisplayOpenMeasurement {
    private final zzbnb zza;

    public zzbys(zzbnb zzbnb2) {
        this.zza = zzbnb2;
        try {
            zzbnb2.zzr();
            return;
        }
        catch (RemoteException remoteException) {
            zzcgt.zzg((String)"", (Throwable)remoteException);
            return;
        }
    }

    public final void setView(View view) {
        try {
            this.zza.zzq(ObjectWrapper.wrap((Object)view));
            return;
        }
        catch (RemoteException remoteException) {
            zzcgt.zzg((String)"", (Throwable)remoteException);
            return;
        }
    }

    public final boolean start() {
        try {
            boolean bl = this.zza.zzp();
            return bl;
        }
        catch (RemoteException remoteException) {
            zzcgt.zzg((String)"", (Throwable)remoteException);
            return false;
        }
    }
}
