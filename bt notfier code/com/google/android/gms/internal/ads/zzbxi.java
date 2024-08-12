/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.IBinder
 *  android.os.Parcel
 *  android.os.Parcelable
 *  android.os.RemoteException
 *  com.google.android.gms.internal.ads.zzadj
 *  com.google.android.gms.internal.ads.zzadl
 *  com.google.android.gms.internal.ads.zzbcz
 *  com.google.android.gms.internal.ads.zzbxk
 */
package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import com.google.android.gms.internal.ads.zzadj;
import com.google.android.gms.internal.ads.zzadl;
import com.google.android.gms.internal.ads.zzbcz;
import com.google.android.gms.internal.ads.zzbxk;

public final class zzbxi
extends zzadj
implements zzbxk {
    zzbxi(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.mediation.client.rtb.IRewardedCallback");
    }

    public final void zze() throws RemoteException {
        this.zzbj(2, this.zza());
    }

    public final void zzf(String string) throws RemoteException {
        string = this.zza();
        string.writeString("Adapter returned null.");
        this.zzbj(3, (Parcel)string);
    }

    public final void zzg(zzbcz zzbcz2) throws RemoteException {
        Parcel parcel = this.zza();
        zzadl.zzd((Parcel)parcel, (Parcelable)zzbcz2);
        this.zzbj(4, parcel);
    }
}
