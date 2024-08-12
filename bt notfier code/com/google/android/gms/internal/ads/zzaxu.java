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
 *  com.google.android.gms.internal.ads.zzaxw
 *  com.google.android.gms.internal.ads.zzaya
 *  com.google.android.gms.internal.ads.zzayd
 *  com.google.android.gms.internal.ads.zzbfn
 *  com.google.android.gms.internal.ads.zzbgw
 *  com.google.android.gms.internal.ads.zzbgy
 *  com.google.android.gms.internal.ads.zzbgz
 */
package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.internal.ads.zzadj;
import com.google.android.gms.internal.ads.zzadl;
import com.google.android.gms.internal.ads.zzaxw;
import com.google.android.gms.internal.ads.zzaya;
import com.google.android.gms.internal.ads.zzayd;
import com.google.android.gms.internal.ads.zzbfn;
import com.google.android.gms.internal.ads.zzbgw;
import com.google.android.gms.internal.ads.zzbgy;
import com.google.android.gms.internal.ads.zzbgz;

public final class zzaxu
extends zzadj
implements zzaxw {
    zzaxu(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.appopen.client.IAppOpenAd");
    }

    public final zzbfn zze() throws RemoteException {
        throw null;
    }

    public final void zzf(IObjectWrapper iObjectWrapper, zzayd zzayd2) throws RemoteException {
        Parcel parcel = this.zza();
        zzadl.zzf((Parcel)parcel, (IInterface)iObjectWrapper);
        zzadl.zzf((Parcel)parcel, (IInterface)zzayd2);
        this.zzbj(4, parcel);
    }

    public final zzbgz zzg() throws RemoteException {
        Parcel parcel = this.zzbi(5, this.zza());
        zzbgz zzbgz2 = zzbgy.zzb((IBinder)parcel.readStrongBinder());
        parcel.recycle();
        return zzbgz2;
    }

    public final void zzh(boolean bl) throws RemoteException {
        Parcel parcel = this.zza();
        zzadl.zzb((Parcel)parcel, (boolean)bl);
        this.zzbj(6, parcel);
    }

    public final void zzi(zzbgw zzbgw2) throws RemoteException {
        Parcel parcel = this.zza();
        zzadl.zzf((Parcel)parcel, (IInterface)zzbgw2);
        this.zzbj(7, parcel);
    }

    public final void zzj(zzaya zzaya2) throws RemoteException {
        throw null;
    }
}
