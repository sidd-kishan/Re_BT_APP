/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.IBinder
 *  android.os.IInterface
 *  android.os.Parcel
 *  android.os.Parcelable
 *  android.os.RemoteException
 *  com.google.android.gms.dynamic.IObjectWrapper
 *  com.google.android.gms.internal.ads.zzadj
 *  com.google.android.gms.internal.ads.zzadl
 *  com.google.android.gms.internal.ads.zzbdl
 *  com.google.android.gms.internal.ads.zzbvg
 */
package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.internal.ads.zzadj;
import com.google.android.gms.internal.ads.zzadl;
import com.google.android.gms.internal.ads.zzbdl;
import com.google.android.gms.internal.ads.zzbvg;

public final class zzbfo
extends zzadj
implements IInterface {
    zzbfo(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.client.IAdManagerCreator");
    }

    public final IBinder zze(IObjectWrapper iObjectWrapper, zzbdl zzbdl2, String string, zzbvg zzbvg2, int n, int n2) throws RemoteException {
        Parcel parcel = this.zza();
        zzadl.zzf((Parcel)parcel, (IInterface)iObjectWrapper);
        zzadl.zzd((Parcel)parcel, (Parcelable)zzbdl2);
        parcel.writeString(string);
        zzadl.zzf((Parcel)parcel, (IInterface)zzbvg2);
        parcel.writeInt(213806000);
        parcel.writeInt(n2);
        iObjectWrapper = this.zzbi(2, parcel);
        zzbdl2 = iObjectWrapper.readStrongBinder();
        iObjectWrapper.recycle();
        return zzbdl2;
    }
}
