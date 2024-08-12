/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.IBinder
 *  android.os.IInterface
 *  android.os.Parcel
 *  android.os.Parcelable
 *  android.os.RemoteException
 *  com.google.android.gms.internal.ads.zzadj
 *  com.google.android.gms.internal.ads.zzadl
 *  com.google.android.gms.internal.ads.zzbcz
 *  com.google.android.gms.internal.ads.zzbvv
 *  com.google.android.gms.internal.ads.zzbxh
 */
package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import com.google.android.gms.internal.ads.zzadj;
import com.google.android.gms.internal.ads.zzadl;
import com.google.android.gms.internal.ads.zzbcz;
import com.google.android.gms.internal.ads.zzbvv;
import com.google.android.gms.internal.ads.zzbxh;

public final class zzbxf
extends zzadj
implements zzbxh {
    zzbxf(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.mediation.client.rtb.INativeCallback");
    }

    public final void zze(zzbvv zzbvv2) throws RemoteException {
        Parcel parcel = this.zza();
        zzadl.zzf((Parcel)parcel, (IInterface)zzbvv2);
        this.zzbj(1, parcel);
    }

    public final void zzf(String string) throws RemoteException {
        string = this.zza();
        string.writeString("Adapter returned null.");
        this.zzbj(2, (Parcel)string);
    }

    public final void zzg(zzbcz zzbcz2) throws RemoteException {
        Parcel parcel = this.zza();
        zzadl.zzd((Parcel)parcel, (Parcelable)zzbcz2);
        this.zzbj(3, parcel);
    }
}
