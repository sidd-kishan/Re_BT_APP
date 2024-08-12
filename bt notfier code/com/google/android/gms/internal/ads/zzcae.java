/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.net.Uri
 *  android.os.IBinder
 *  android.os.IInterface
 *  android.os.Parcel
 *  android.os.RemoteException
 *  com.google.android.gms.internal.ads.zzadk
 *  com.google.android.gms.internal.ads.zzcad
 *  com.google.android.gms.internal.ads.zzcaf
 */
package com.google.android.gms.internal.ads;

import android.net.Uri;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.internal.ads.zzadk;
import com.google.android.gms.internal.ads.zzcad;
import com.google.android.gms.internal.ads.zzcaf;

public abstract class zzcae
extends zzadk
implements zzcaf {
    public zzcae() {
        super("com.google.android.gms.ads.internal.query.IUpdateUrlsCallback");
    }

    public static zzcaf zzb(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface iInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.query.IUpdateUrlsCallback");
        if (!(iInterface instanceof zzcaf)) return new zzcad(iBinder);
        return (zzcaf)iInterface;
    }

    protected final boolean zzbz(int n, Parcel parcel, Parcel parcel2, int n2) throws RemoteException {
        if (n != 1) {
            if (n != 2) {
                return false;
            }
            this.zzf(parcel.readString());
        } else {
            this.zze(parcel.createTypedArrayList(Uri.CREATOR));
        }
        parcel2.writeNoException();
        return true;
    }
}
