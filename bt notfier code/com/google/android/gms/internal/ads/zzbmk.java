/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.IBinder
 *  android.os.IInterface
 *  android.os.Parcel
 *  android.os.RemoteException
 *  com.google.android.gms.dynamic.IObjectWrapper$Stub
 *  com.google.android.gms.internal.ads.zzadk
 *  com.google.android.gms.internal.ads.zzadl
 *  com.google.android.gms.internal.ads.zzbmc
 *  com.google.android.gms.internal.ads.zzbme
 *  com.google.android.gms.internal.ads.zzbmj
 *  com.google.android.gms.internal.ads.zzbml
 */
package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.internal.ads.zzadk;
import com.google.android.gms.internal.ads.zzadl;
import com.google.android.gms.internal.ads.zzbmc;
import com.google.android.gms.internal.ads.zzbme;
import com.google.android.gms.internal.ads.zzbmj;
import com.google.android.gms.internal.ads.zzbml;

public abstract class zzbmk
extends zzadk
implements zzbml {
    public zzbmk() {
        super("com.google.android.gms.ads.internal.formats.client.INativeAdViewDelegate");
    }

    public static zzbml zzby(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface iInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.formats.client.INativeAdViewDelegate");
        if (!(iInterface instanceof zzbml)) return new zzbmj(iBinder);
        return (zzbml)iInterface;
    }

    protected final boolean zzbz(int n, Parcel object, Parcel parcel, int n2) throws RemoteException {
        switch (n) {
            default: {
                return false;
            }
            case 9: {
                this.zzbu(IObjectWrapper.Stub.asInterface((IBinder)object.readStrongBinder()));
                parcel.writeNoException();
                break;
            }
            case 8: {
                IBinder iBinder = object.readStrongBinder();
                object = iBinder == null ? null : ((object = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.formats.client.IMediaContent")) instanceof zzbme ? (zzbme)object : new zzbmc(iBinder));
                this.zzbw((zzbme)object);
                parcel.writeNoException();
                break;
            }
            case 7: {
                this.zzbv(IObjectWrapper.Stub.asInterface((IBinder)object.readStrongBinder()));
                parcel.writeNoException();
                break;
            }
            case 6: {
                this.zzg(IObjectWrapper.Stub.asInterface((IBinder)object.readStrongBinder()));
                parcel.writeNoException();
                break;
            }
            case 5: {
                IObjectWrapper.Stub.asInterface((IBinder)object.readStrongBinder());
                object.readInt();
                parcel.writeNoException();
                break;
            }
            case 4: {
                this.zze();
                parcel.writeNoException();
                break;
            }
            case 3: {
                this.zzd(IObjectWrapper.Stub.asInterface((IBinder)object.readStrongBinder()));
                parcel.writeNoException();
                break;
            }
            case 2: {
                object = this.zzc(object.readString());
                parcel.writeNoException();
                zzadl.zzf((Parcel)parcel, (IInterface)object);
                break;
            }
            case 1: {
                this.zzb(object.readString(), IObjectWrapper.Stub.asInterface((IBinder)object.readStrongBinder()));
                parcel.writeNoException();
            }
        }
        return true;
    }
}
