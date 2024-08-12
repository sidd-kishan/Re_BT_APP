/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.IBinder
 *  android.os.Parcel
 *  android.os.RemoteException
 *  com.google.android.gms.internal.ads.zzadj
 *  com.google.android.gms.internal.ads.zzbgm
 */
package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.internal.ads.zzadj;
import com.google.android.gms.internal.ads.zzbgm;

public final class zzbgk
extends zzadj
implements zzbgm {
    zzbgk(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.client.IMuteThisAdReason");
    }

    public final String zze() throws RemoteException {
        Parcel parcel = this.zzbi(1, this.zza());
        String string = parcel.readString();
        parcel.recycle();
        return string;
    }

    public final String zzf() throws RemoteException {
        Parcel parcel = this.zzbi(2, this.zza());
        String string = parcel.readString();
        parcel.recycle();
        return string;
    }
}
