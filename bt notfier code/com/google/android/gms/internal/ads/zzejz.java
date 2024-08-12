/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.RemoteException
 *  com.google.android.gms.ads.internal.util.zze
 *  com.google.android.gms.internal.ads.zzbxn
 *  com.google.android.gms.internal.ads.zzdtf
 */
package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.android.gms.ads.internal.util.zze;
import com.google.android.gms.internal.ads.zzbxn;
import com.google.android.gms.internal.ads.zzdtf;
import java.util.concurrent.ConcurrentHashMap;
import javax.annotation.CheckForNull;

public final class zzejz {
    private final ConcurrentHashMap<String, zzbxn> zza = new ConcurrentHashMap();
    private final zzdtf zzb;

    public zzejz(zzdtf zzdtf2) {
        this.zzb = zzdtf2;
    }

    public final void zza(String string) {
        try {
            zzbxn zzbxn2 = this.zzb.zzc(string);
            this.zza.put(string, zzbxn2);
            return;
        }
        catch (RemoteException remoteException) {
            zze.zzg((String)"Couldn't create RTB adapter : ", (Throwable)remoteException);
            return;
        }
    }

    @CheckForNull
    public final zzbxn zzb(String string) {
        if (!this.zza.containsKey(string)) return null;
        return this.zza.get(string);
    }
}
