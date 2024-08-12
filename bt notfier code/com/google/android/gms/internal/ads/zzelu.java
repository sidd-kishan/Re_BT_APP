/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.RemoteException
 *  com.google.android.gms.internal.ads.zzbcz
 *  com.google.android.gms.internal.ads.zzbsg
 *  com.google.android.gms.internal.ads.zzcgt
 *  com.google.android.gms.internal.ads.zzdbf
 *  com.google.android.gms.internal.ads.zzeli
 */
package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.android.gms.internal.ads.zzbcz;
import com.google.android.gms.internal.ads.zzbsg;
import com.google.android.gms.internal.ads.zzcgt;
import com.google.android.gms.internal.ads.zzdbf;
import com.google.android.gms.internal.ads.zzeli;

final class zzelu
implements zzdbf {
    private final zzeli zza;
    private final zzbsg zzb;

    zzelu(zzeli zzeli2, zzbsg zzbsg2) {
        this.zza = zzeli2;
        this.zzb = zzbsg2;
    }

    public final void zzbD(zzbcz zzbcz2) {
        zzeli zzeli2 = this.zza;
        zzbsg zzbsg2 = this.zzb;
        zzeli2.zzbD(zzbcz2);
        if (zzbsg2 != null) {
            try {
                zzbsg2.zzg(zzbcz2);
            }
            catch (RemoteException remoteException) {
                zzcgt.zzl((String)"#007 Could not call remote method.", (Throwable)remoteException);
            }
        }
        if (zzbsg2 == null) return;
        try {
            zzbsg2.zzf(zzbcz2.zza);
            return;
        }
        catch (RemoteException remoteException) {
            zzcgt.zzl((String)"#007 Could not call remote method.", (Throwable)remoteException);
        }
    }
}
