/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.IBinder
 *  android.os.IInterface
 *  android.os.Parcel
 *  android.os.Parcelable$Creator
 *  android.os.RemoteException
 *  com.google.android.gms.dynamic.IObjectWrapper$Stub
 *  com.google.android.gms.internal.ads.zzadk
 *  com.google.android.gms.internal.ads.zzadl
 *  com.google.android.gms.internal.ads.zzbdl
 *  com.google.android.gms.internal.ads.zzbfx
 *  com.google.android.gms.internal.ads.zzbql
 *  com.google.android.gms.internal.ads.zzbvf
 */
package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.internal.ads.zzadk;
import com.google.android.gms.internal.ads.zzadl;
import com.google.android.gms.internal.ads.zzbdl;
import com.google.android.gms.internal.ads.zzbfx;
import com.google.android.gms.internal.ads.zzbql;
import com.google.android.gms.internal.ads.zzbvf;

public abstract class zzbfw
extends zzadk
implements zzbfx {
    public zzbfw() {
        super("com.google.android.gms.ads.internal.client.IClientApi");
    }

    protected final boolean zzbz(int n, Parcel parcel, Parcel parcel2, int n2) throws RemoteException {
        switch (n) {
            default: {
                return false;
            }
            case 16: {
                parcel = this.zzo(IObjectWrapper.Stub.asInterface((IBinder)parcel.readStrongBinder()), zzbvf.zzg((IBinder)parcel.readStrongBinder()), parcel.readInt(), zzbql.zzc((IBinder)parcel.readStrongBinder()));
                parcel2.writeNoException();
                zzadl.zzf((Parcel)parcel2, (IInterface)parcel);
                break;
            }
            case 15: {
                parcel = this.zzn(IObjectWrapper.Stub.asInterface((IBinder)parcel.readStrongBinder()), zzbvf.zzg((IBinder)parcel.readStrongBinder()), parcel.readInt());
                parcel2.writeNoException();
                zzadl.zzf((Parcel)parcel2, (IInterface)parcel);
                break;
            }
            case 14: {
                parcel = this.zzm(IObjectWrapper.Stub.asInterface((IBinder)parcel.readStrongBinder()), zzbvf.zzg((IBinder)parcel.readStrongBinder()), parcel.readInt());
                parcel2.writeNoException();
                zzadl.zzf((Parcel)parcel2, (IInterface)parcel);
                break;
            }
            case 13: {
                parcel = this.zzl(IObjectWrapper.Stub.asInterface((IBinder)parcel.readStrongBinder()), (zzbdl)zzadl.zzc((Parcel)parcel, (Parcelable.Creator)zzbdl.CREATOR), parcel.readString(), zzbvf.zzg((IBinder)parcel.readStrongBinder()), parcel.readInt());
                parcel2.writeNoException();
                zzadl.zzf((Parcel)parcel2, (IInterface)parcel);
                break;
            }
            case 12: {
                parcel = this.zzk(IObjectWrapper.Stub.asInterface((IBinder)parcel.readStrongBinder()), parcel.readString(), zzbvf.zzg((IBinder)parcel.readStrongBinder()), parcel.readInt());
                parcel2.writeNoException();
                zzadl.zzf((Parcel)parcel2, (IInterface)parcel);
                break;
            }
            case 11: {
                parcel = this.zzj(IObjectWrapper.Stub.asInterface((IBinder)parcel.readStrongBinder()), IObjectWrapper.Stub.asInterface((IBinder)parcel.readStrongBinder()), IObjectWrapper.Stub.asInterface((IBinder)parcel.readStrongBinder()));
                parcel2.writeNoException();
                zzadl.zzf((Parcel)parcel2, (IInterface)parcel);
                break;
            }
            case 10: {
                parcel = this.zzi(IObjectWrapper.Stub.asInterface((IBinder)parcel.readStrongBinder()), (zzbdl)zzadl.zzc((Parcel)parcel, (Parcelable.Creator)zzbdl.CREATOR), parcel.readString(), parcel.readInt());
                parcel2.writeNoException();
                zzadl.zzf((Parcel)parcel2, (IInterface)parcel);
                break;
            }
            case 9: {
                parcel = this.zzh(IObjectWrapper.Stub.asInterface((IBinder)parcel.readStrongBinder()), parcel.readInt());
                parcel2.writeNoException();
                zzadl.zzf((Parcel)parcel2, (IInterface)parcel);
                break;
            }
            case 8: {
                parcel = this.zzg(IObjectWrapper.Stub.asInterface((IBinder)parcel.readStrongBinder()));
                parcel2.writeNoException();
                zzadl.zzf((Parcel)parcel2, (IInterface)parcel);
                break;
            }
            case 7: {
                IObjectWrapper.Stub.asInterface((IBinder)parcel.readStrongBinder());
                parcel2.writeNoException();
                zzadl.zzf((Parcel)parcel2, null);
                break;
            }
            case 6: {
                parcel = this.zzf(IObjectWrapper.Stub.asInterface((IBinder)parcel.readStrongBinder()), zzbvf.zzg((IBinder)parcel.readStrongBinder()), parcel.readInt());
                parcel2.writeNoException();
                zzadl.zzf((Parcel)parcel2, (IInterface)parcel);
                break;
            }
            case 5: {
                parcel = this.zze(IObjectWrapper.Stub.asInterface((IBinder)parcel.readStrongBinder()), IObjectWrapper.Stub.asInterface((IBinder)parcel.readStrongBinder()));
                parcel2.writeNoException();
                zzadl.zzf((Parcel)parcel2, (IInterface)parcel);
                break;
            }
            case 4: {
                IObjectWrapper.Stub.asInterface((IBinder)parcel.readStrongBinder());
                parcel2.writeNoException();
                zzadl.zzf((Parcel)parcel2, null);
                break;
            }
            case 3: {
                parcel = this.zzd(IObjectWrapper.Stub.asInterface((IBinder)parcel.readStrongBinder()), parcel.readString(), zzbvf.zzg((IBinder)parcel.readStrongBinder()), parcel.readInt());
                parcel2.writeNoException();
                zzadl.zzf((Parcel)parcel2, (IInterface)parcel);
                break;
            }
            case 2: {
                parcel = this.zzc(IObjectWrapper.Stub.asInterface((IBinder)parcel.readStrongBinder()), (zzbdl)zzadl.zzc((Parcel)parcel, (Parcelable.Creator)zzbdl.CREATOR), parcel.readString(), zzbvf.zzg((IBinder)parcel.readStrongBinder()), parcel.readInt());
                parcel2.writeNoException();
                zzadl.zzf((Parcel)parcel2, (IInterface)parcel);
                break;
            }
            case 1: {
                parcel = this.zzb(IObjectWrapper.Stub.asInterface((IBinder)parcel.readStrongBinder()), (zzbdl)zzadl.zzc((Parcel)parcel, (Parcelable.Creator)zzbdl.CREATOR), parcel.readString(), zzbvf.zzg((IBinder)parcel.readStrongBinder()), parcel.readInt());
                parcel2.writeNoException();
                zzadl.zzf((Parcel)parcel2, (IInterface)parcel);
            }
        }
        return true;
    }
}
