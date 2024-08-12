/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.IBinder
 *  android.os.IInterface
 *  android.os.Parcel
 *  android.os.RemoteException
 *  com.google.android.gms.dynamic.IObjectWrapper
 *  com.google.android.gms.internal.ads.zzadj
 *  com.google.android.gms.internal.ads.zzadl
 *  com.google.android.gms.internal.ads.zzbqm
 *  com.google.android.gms.internal.ads.zzbqn
 *  com.google.android.gms.internal.ads.zzbqp
 *  com.google.android.gms.internal.ads.zzbqs
 *  com.google.android.gms.internal.ads.zzbvg
 */
package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.internal.ads.zzadj;
import com.google.android.gms.internal.ads.zzadl;
import com.google.android.gms.internal.ads.zzbqm;
import com.google.android.gms.internal.ads.zzbqn;
import com.google.android.gms.internal.ads.zzbqp;
import com.google.android.gms.internal.ads.zzbqs;
import com.google.android.gms.internal.ads.zzbvg;

public final class zzbqq
extends zzadj
implements zzbqs {
    zzbqq(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.h5.client.IH5AdsManagerCreator");
    }

    public final zzbqp zze(IObjectWrapper object, zzbvg zzbvg2, int n, zzbqm zzbqm2) throws RemoteException {
        Parcel parcel = this.zza();
        zzadl.zzf((Parcel)parcel, (IInterface)object);
        zzadl.zzf((Parcel)parcel, (IInterface)zzbvg2);
        parcel.writeInt(213806000);
        zzadl.zzf((Parcel)parcel, (IInterface)zzbqm2);
        zzbvg2 = this.zzbi(1, parcel);
        object = zzbvg2.readStrongBinder();
        object = object == null ? null : ((zzbqm2 = object.queryLocalInterface("com.google.android.gms.ads.internal.h5.client.IH5AdsManager")) instanceof zzbqp ? (zzbqp)zzbqm2 : new zzbqn((IBinder)object));
        zzbvg2.recycle();
        return object;
    }
}
