/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.IBinder
 *  android.os.Parcel
 *  android.os.RemoteException
 *  com.google.android.gms.internal.ads.zzadj
 *  com.google.android.gms.internal.ads.zzadl
 *  com.google.android.gms.internal.ads.zzblz
 *  com.google.android.gms.internal.ads.zzbmh
 */
package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.internal.ads.zzadj;
import com.google.android.gms.internal.ads.zzadl;
import com.google.android.gms.internal.ads.zzblz;
import com.google.android.gms.internal.ads.zzbmh;
import java.util.ArrayList;
import java.util.List;

public final class zzblx
extends zzadj
implements zzblz {
    zzblx(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.formats.client.IAttributionInfo");
    }

    public final String zzb() throws RemoteException {
        Parcel parcel = this.zzbi(2, this.zza());
        String string = parcel.readString();
        parcel.recycle();
        return string;
    }

    public final List<zzbmh> zzc() throws RemoteException {
        Parcel parcel = this.zzbi(3, this.zza());
        ArrayList arrayList = zzadl.zzg((Parcel)parcel);
        parcel.recycle();
        return arrayList;
    }
}
