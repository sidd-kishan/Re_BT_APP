/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.IBinder
 *  android.os.IInterface
 *  android.os.Parcel
 *  android.os.RemoteException
 *  com.google.android.gms.internal.ads.zzadk
 *  com.google.android.gms.internal.ads.zzadl
 *  com.google.android.gms.internal.ads.zzbve
 *  com.google.android.gms.internal.ads.zzbvg
 */
package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.internal.ads.zzadk;
import com.google.android.gms.internal.ads.zzadl;
import com.google.android.gms.internal.ads.zzbve;
import com.google.android.gms.internal.ads.zzbvg;

public abstract class zzbvf
extends zzadk
implements zzbvg {
    public zzbvf() {
        super("com.google.android.gms.ads.internal.mediation.client.IAdapterCreator");
    }

    public static zzbvg zzg(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface iInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.mediation.client.IAdapterCreator");
        if (!(iInterface instanceof zzbvg)) return new zzbve(iBinder);
        return (zzbvg)iInterface;
    }

    protected final boolean zzbz(int n, Parcel parcel, Parcel parcel2, int n2) throws RemoteException {
        if (n != 1) {
            if (n != 2) {
                if (n != 3) {
                    if (n != 4) {
                        return false;
                    }
                    boolean bl = this.zzd(parcel.readString());
                    parcel2.writeNoException();
                    zzadl.zzb((Parcel)parcel2, (boolean)bl);
                } else {
                    parcel = this.zzf(parcel.readString());
                    parcel2.writeNoException();
                    zzadl.zzf((Parcel)parcel2, (IInterface)parcel);
                }
            } else {
                boolean bl = this.zzc(parcel.readString());
                parcel2.writeNoException();
                zzadl.zzb((Parcel)parcel2, (boolean)bl);
            }
        } else {
            parcel = this.zzb(parcel.readString());
            parcel2.writeNoException();
            zzadl.zzf((Parcel)parcel2, (IInterface)parcel);
        }
        return true;
    }
}
