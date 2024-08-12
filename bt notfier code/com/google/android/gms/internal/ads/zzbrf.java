/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.ParcelFileDescriptor
 *  android.os.RemoteException
 *  com.google.android.gms.internal.ads.zzbrc
 *  com.google.android.gms.internal.ads.zzbrg
 *  com.google.android.gms.internal.ads.zzchl
 */
package com.google.android.gms.internal.ads;

import android.os.ParcelFileDescriptor;
import android.os.RemoteException;
import com.google.android.gms.internal.ads.zzbrc;
import com.google.android.gms.internal.ads.zzbrg;
import com.google.android.gms.internal.ads.zzchl;

final class zzbrf
extends zzbrc {
    final zzchl zza;

    zzbrf(zzbrg zzbrg2, zzchl zzchl2) {
        this.zza = zzchl2;
    }

    public final void zzb(ParcelFileDescriptor parcelFileDescriptor) throws RemoteException {
        this.zza.zzc((Object)parcelFileDescriptor);
    }
}
