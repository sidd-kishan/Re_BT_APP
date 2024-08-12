/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.IBinder
 *  android.os.IInterface
 *  android.os.Parcel
 *  android.os.RemoteException
 *  com.google.android.gms.internal.ads.zzadk
 *  com.google.android.gms.internal.ads.zzbgk
 *  com.google.android.gms.internal.ads.zzbgm
 */
package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.internal.ads.zzadk;
import com.google.android.gms.internal.ads.zzbgk;
import com.google.android.gms.internal.ads.zzbgm;

public abstract class zzbgl
extends zzadk
implements zzbgm {
    public zzbgl() {
        super("com.google.android.gms.ads.internal.client.IMuteThisAdReason");
    }

    public static zzbgm zzb(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface iInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IMuteThisAdReason");
        if (!(iInterface instanceof zzbgm)) return new zzbgk(iBinder);
        return (zzbgm)iInterface;
    }

    protected final boolean zzbz(int n, Parcel object, Parcel parcel, int n2) throws RemoteException {
        if (n != 1) {
            if (n != 2) {
                return false;
            }
            object = this.zzf();
            parcel.writeNoException();
            parcel.writeString((String)object);
        } else {
            object = this.zze();
            parcel.writeNoException();
            parcel.writeString((String)object);
        }
        return true;
    }
}
