/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.IBinder
 *  android.os.IInterface
 *  android.os.Parcel
 *  android.os.RemoteException
 *  com.google.android.gms.internal.ads.zzadk
 *  com.google.android.gms.internal.ads.zzbgg
 *  com.google.android.gms.internal.ads.zzbgi
 */
package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.internal.ads.zzadk;
import com.google.android.gms.internal.ads.zzbgg;
import com.google.android.gms.internal.ads.zzbgi;

public abstract class zzbgh
extends zzadk
implements zzbgi {
    public zzbgh() {
        super("com.google.android.gms.ads.internal.client.IMuteThisAdListener");
    }

    public static zzbgi zzb(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface iInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IMuteThisAdListener");
        if (!(iInterface instanceof zzbgi)) return new zzbgg(iBinder);
        return (zzbgi)iInterface;
    }

    protected final boolean zzbz(int n, Parcel parcel, Parcel parcel2, int n2) throws RemoteException {
        if (n != 1) return false;
        this.zze();
        parcel2.writeNoException();
        return true;
    }
}
