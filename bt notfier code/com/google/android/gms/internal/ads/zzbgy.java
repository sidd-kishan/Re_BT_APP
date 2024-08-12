/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.IBinder
 *  android.os.IInterface
 *  android.os.Parcel
 *  android.os.RemoteException
 *  com.google.android.gms.internal.ads.zzadk
 *  com.google.android.gms.internal.ads.zzbgx
 *  com.google.android.gms.internal.ads.zzbgz
 */
package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.internal.ads.zzadk;
import com.google.android.gms.internal.ads.zzbgx;
import com.google.android.gms.internal.ads.zzbgz;
import java.util.List;

public abstract class zzbgy
extends zzadk
implements zzbgz {
    public zzbgy() {
        super("com.google.android.gms.ads.internal.client.IResponseInfo");
    }

    public static zzbgz zzb(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface iInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IResponseInfo");
        if (!(iInterface instanceof zzbgz)) return new zzbgx(iBinder);
        return (zzbgz)iInterface;
    }

    protected final boolean zzbz(int n, Parcel object, Parcel parcel, int n2) throws RemoteException {
        if (n != 1) {
            if (n != 2) {
                if (n != 3) {
                    return false;
                }
                object = this.zzg();
                parcel.writeNoException();
                parcel.writeTypedList((List)object);
            } else {
                object = this.zzf();
                parcel.writeNoException();
                parcel.writeString((String)object);
            }
        } else {
            object = this.zze();
            parcel.writeNoException();
            parcel.writeString((String)object);
        }
        return true;
    }
}
