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
 *  com.google.android.gms.internal.ads.zzbvg
 *  com.google.android.gms.internal.ads.zzbzc
 *  com.google.android.gms.internal.ads.zzbze
 *  com.google.android.gms.internal.ads.zzbzh
 */
package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.internal.ads.zzadj;
import com.google.android.gms.internal.ads.zzadl;
import com.google.android.gms.internal.ads.zzbvg;
import com.google.android.gms.internal.ads.zzbzc;
import com.google.android.gms.internal.ads.zzbze;
import com.google.android.gms.internal.ads.zzbzh;

public final class zzbzf
extends zzadj
implements zzbzh {
    zzbzf(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.offline.IOfflineUtilsCreator");
    }

    public final zzbze zze(IObjectWrapper object, zzbvg zzbvg2, int n) throws RemoteException {
        Parcel parcel = this.zza();
        zzadl.zzf((Parcel)parcel, (IInterface)object);
        zzadl.zzf((Parcel)parcel, (IInterface)zzbvg2);
        parcel.writeInt(213806000);
        zzbvg2 = this.zzbi(1, parcel);
        object = zzbvg2.readStrongBinder();
        object = object == null ? null : ((parcel = object.queryLocalInterface("com.google.android.gms.ads.internal.offline.IOfflineUtils")) instanceof zzbze ? (zzbze)parcel : new zzbzc((IBinder)object));
        zzbvg2.recycle();
        return object;
    }
}
