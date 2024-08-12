/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.IBinder
 *  android.os.Parcel
 *  android.os.RemoteException
 *  com.google.android.gms.dynamic.IObjectWrapper
 *  com.google.android.gms.dynamic.IObjectWrapper$Stub
 *  com.google.android.gms.internal.ads.zzadj
 *  com.google.android.gms.internal.ads.zzadl
 *  com.google.android.gms.internal.ads.zzbvp
 */
package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.internal.ads.zzadj;
import com.google.android.gms.internal.ads.zzadl;
import com.google.android.gms.internal.ads.zzbvp;

public final class zzbvn
extends zzadj
implements zzbvp {
    zzbvn(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.mediation.client.IMediationInterscrollerAd");
    }

    public final IObjectWrapper zze() throws RemoteException {
        Parcel parcel = this.zzbi(1, this.zza());
        IObjectWrapper iObjectWrapper = IObjectWrapper.Stub.asInterface((IBinder)parcel.readStrongBinder());
        parcel.recycle();
        return iObjectWrapper;
    }

    public final boolean zzf() throws RemoteException {
        Parcel parcel = this.zzbi(2, this.zza());
        boolean bl = zzadl.zza((Parcel)parcel);
        parcel.recycle();
        return bl;
    }
}
