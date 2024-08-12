/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.IBinder
 *  android.os.Parcel
 *  android.os.RemoteException
 *  com.google.android.gms.internal.ads.zzadj
 *  com.google.android.gms.internal.ads.zzccp
 */
package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.internal.ads.zzadj;
import com.google.android.gms.internal.ads.zzccp;

public final class zzccn
extends zzadj
implements zzccp {
    zzccn(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.rewarded.client.IRewardItem");
    }

    public final String zze() throws RemoteException {
        Parcel parcel = this.zzbi(1, this.zza());
        String string = parcel.readString();
        parcel.recycle();
        return string;
    }

    public final int zzf() throws RemoteException {
        Parcel parcel = this.zzbi(2, this.zza());
        int n = parcel.readInt();
        parcel.recycle();
        return n;
    }
}
