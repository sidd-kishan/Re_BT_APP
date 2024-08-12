/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.IBinder
 *  android.os.Parcel
 *  android.os.RemoteException
 *  com.google.android.gms.internal.ads.zzadj
 *  com.google.android.gms.internal.ads.zzbdp
 *  com.google.android.gms.internal.ads.zzbgz
 */
package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.internal.ads.zzadj;
import com.google.android.gms.internal.ads.zzbdp;
import com.google.android.gms.internal.ads.zzbgz;
import java.util.ArrayList;
import java.util.List;

public final class zzbgx
extends zzadj
implements zzbgz {
    zzbgx(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.client.IResponseInfo");
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

    public final List<zzbdp> zzg() throws RemoteException {
        Parcel parcel = this.zzbi(3, this.zza());
        ArrayList arrayList = parcel.createTypedArrayList(zzbdp.CREATOR);
        parcel.recycle();
        return arrayList;
    }
}
