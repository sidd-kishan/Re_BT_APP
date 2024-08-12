/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Intent
 *  android.os.IBinder
 *  android.os.IInterface
 *  android.os.Parcel
 *  android.os.Parcelable$Creator
 *  android.os.RemoteException
 *  com.google.android.gms.dynamic.IObjectWrapper$Stub
 *  com.google.android.gms.internal.ads.zzadk
 *  com.google.android.gms.internal.ads.zzadl
 *  com.google.android.gms.internal.ads.zzbzc
 *  com.google.android.gms.internal.ads.zzbze
 */
package com.google.android.gms.internal.ads;

import android.content.Intent;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.internal.ads.zzadk;
import com.google.android.gms.internal.ads.zzadl;
import com.google.android.gms.internal.ads.zzbzc;
import com.google.android.gms.internal.ads.zzbze;

public abstract class zzbzd
extends zzadk
implements zzbze {
    public zzbzd() {
        super("com.google.android.gms.ads.internal.offline.IOfflineUtils");
    }

    public static zzbze zzb(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface iInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.offline.IOfflineUtils");
        if (!(iInterface instanceof zzbze)) return new zzbzc(iBinder);
        return (zzbze)iInterface;
    }

    protected final boolean zzbz(int n, Parcel parcel, Parcel parcel2, int n2) throws RemoteException {
        if (n != 1) {
            if (n != 2) {
                if (n != 3) {
                    return false;
                }
                this.zzg();
            } else {
                this.zzf(IObjectWrapper.Stub.asInterface((IBinder)parcel.readStrongBinder()), parcel.readString(), parcel.readString());
            }
        } else {
            this.zze((Intent)zzadl.zzc((Parcel)parcel, (Parcelable.Creator)Intent.CREATOR));
        }
        parcel2.writeNoException();
        return true;
    }
}
