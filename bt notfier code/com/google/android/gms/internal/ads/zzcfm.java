/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.net.Uri
 *  android.os.IBinder
 *  android.os.IInterface
 *  android.os.Parcel
 *  android.os.Parcelable$Creator
 *  android.os.RemoteException
 *  com.google.android.gms.dynamic.IObjectWrapper
 *  com.google.android.gms.dynamic.IObjectWrapper$Stub
 *  com.google.android.gms.internal.ads.zzadk
 *  com.google.android.gms.internal.ads.zzadl
 *  com.google.android.gms.internal.ads.zzcae
 *  com.google.android.gms.internal.ads.zzcam
 *  com.google.android.gms.internal.ads.zzcfi
 *  com.google.android.gms.internal.ads.zzcfk
 *  com.google.android.gms.internal.ads.zzcfl
 *  com.google.android.gms.internal.ads.zzcfn
 *  com.google.android.gms.internal.ads.zzcfr
 */
package com.google.android.gms.internal.ads;

import android.net.Uri;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.internal.ads.zzadk;
import com.google.android.gms.internal.ads.zzadl;
import com.google.android.gms.internal.ads.zzcae;
import com.google.android.gms.internal.ads.zzcam;
import com.google.android.gms.internal.ads.zzcfi;
import com.google.android.gms.internal.ads.zzcfk;
import com.google.android.gms.internal.ads.zzcfl;
import com.google.android.gms.internal.ads.zzcfn;
import com.google.android.gms.internal.ads.zzcfr;

public abstract class zzcfm
extends zzadk
implements zzcfn {
    public zzcfm() {
        super("com.google.android.gms.ads.internal.signals.ISignalGenerator");
    }

    public static zzcfn zzb(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface iInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.signals.ISignalGenerator");
        if (!(iInterface instanceof zzcfn)) return new zzcfl(iBinder);
        return (zzcfn)iInterface;
    }

    protected final boolean zzbz(int n, Parcel object, Parcel parcel, int n2) throws RemoteException {
        IInterface iInterface = null;
        switch (n) {
            default: {
                return false;
            }
            case 8: {
                this.zzj(IObjectWrapper.Stub.asInterface((IBinder)object.readStrongBinder()));
                parcel.writeNoException();
                break;
            }
            case 7: {
                this.zzi((zzcam)zzadl.zzc((Parcel)object, (Parcelable.Creator)zzcam.CREATOR));
                parcel.writeNoException();
                break;
            }
            case 6: {
                this.zzh(object.createTypedArrayList(Uri.CREATOR), IObjectWrapper.Stub.asInterface((IBinder)object.readStrongBinder()), zzcae.zzb((IBinder)object.readStrongBinder()));
                parcel.writeNoException();
                break;
            }
            case 5: {
                this.zzg(object.createTypedArrayList(Uri.CREATOR), IObjectWrapper.Stub.asInterface((IBinder)object.readStrongBinder()), zzcae.zzb((IBinder)object.readStrongBinder()));
                parcel.writeNoException();
                break;
            }
            case 4: {
                IObjectWrapper.Stub.asInterface((IBinder)object.readStrongBinder());
                parcel.writeNoException();
                zzadl.zzf((Parcel)parcel, null);
                break;
            }
            case 3: {
                IObjectWrapper.Stub.asInterface((IBinder)object.readStrongBinder());
                IObjectWrapper.Stub.asInterface((IBinder)object.readStrongBinder());
                parcel.writeNoException();
                zzadl.zzf((Parcel)parcel, null);
                break;
            }
            case 2: {
                this.zzf(IObjectWrapper.Stub.asInterface((IBinder)object.readStrongBinder()));
                parcel.writeNoException();
                break;
            }
            case 1: {
                IObjectWrapper iObjectWrapper = IObjectWrapper.Stub.asInterface((IBinder)object.readStrongBinder());
                zzcfr zzcfr2 = (zzcfr)zzadl.zzc((Parcel)object, (Parcelable.Creator)zzcfr.CREATOR);
                object = object.readStrongBinder();
                object = object == null ? iInterface : ((iInterface = object.queryLocalInterface("com.google.android.gms.ads.internal.signals.ISignalCallback")) instanceof zzcfk ? (zzcfk)iInterface : new zzcfi((IBinder)object));
                this.zze(iObjectWrapper, zzcfr2, (zzcfk)object);
                parcel.writeNoException();
            }
        }
        return true;
    }
}
