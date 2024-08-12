/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.RemoteException
 *  com.google.android.gms.internal.ads.zzbgl
 */
package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.android.gms.internal.ads.zzbgl;

public final class zzbhu
extends zzbgl {
    private final String zza;
    private final String zzb;

    public zzbhu(String string, String string2) {
        this.zza = string;
        this.zzb = string2;
    }

    public final String zze() throws RemoteException {
        return this.zza;
    }

    public final String zzf() throws RemoteException {
        return this.zzb;
    }
}
