/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Intent
 *  android.os.IBinder
 *  android.os.IInterface
 *  android.os.Parcel
 *  android.os.Parcelable
 *  android.os.Parcelable$Creator
 *  android.os.RemoteException
 *  com.google.android.gms.dynamic.IFragmentWrapper
 *  com.google.android.gms.dynamic.IObjectWrapper$Stub
 *  com.google.android.gms.dynamic.zza
 *  com.google.android.gms.internal.common.zzb
 *  com.google.android.gms.internal.common.zzc
 */
package com.google.android.gms.dynamic;

import android.content.Intent;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IFragmentWrapper;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.zza;
import com.google.android.gms.internal.common.zzb;
import com.google.android.gms.internal.common.zzc;

public static abstract class IFragmentWrapper.Stub
extends zzb
implements IFragmentWrapper {
    public IFragmentWrapper.Stub() {
        super("com.google.android.gms.dynamic.IFragmentWrapper");
    }

    public static IFragmentWrapper asInterface(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface iInterface = iBinder.queryLocalInterface("com.google.android.gms.dynamic.IFragmentWrapper");
        if (!(iInterface instanceof IFragmentWrapper)) return new zza(iBinder);
        return (IFragmentWrapper)iInterface;
    }

    protected final boolean zza(int n, Parcel object, Parcel parcel, int n2) throws RemoteException {
        switch (n) {
            default: {
                return false;
            }
            case 27: {
                this.zzA(IObjectWrapper.Stub.asInterface((IBinder)object.readStrongBinder()));
                parcel.writeNoException();
                break;
            }
            case 26: {
                this.zzz((Intent)zzc.zzc((Parcel)object, (Parcelable.Creator)Intent.CREATOR), object.readInt());
                parcel.writeNoException();
                break;
            }
            case 25: {
                this.zzy((Intent)zzc.zzc((Parcel)object, (Parcelable.Creator)Intent.CREATOR));
                parcel.writeNoException();
                break;
            }
            case 24: {
                this.zzx(zzc.zza((Parcel)object));
                parcel.writeNoException();
                break;
            }
            case 23: {
                this.zzw(zzc.zza((Parcel)object));
                parcel.writeNoException();
                break;
            }
            case 22: {
                this.zzv(zzc.zza((Parcel)object));
                parcel.writeNoException();
                break;
            }
            case 21: {
                this.zzu(zzc.zza((Parcel)object));
                parcel.writeNoException();
                break;
            }
            case 20: {
                this.zzt(IObjectWrapper.Stub.asInterface((IBinder)object.readStrongBinder()));
                parcel.writeNoException();
                break;
            }
            case 19: {
                boolean bl = this.zzs();
                parcel.writeNoException();
                zzc.zzb((Parcel)parcel, (boolean)bl);
                break;
            }
            case 18: {
                boolean bl = this.zzr();
                parcel.writeNoException();
                zzc.zzb((Parcel)parcel, (boolean)bl);
                break;
            }
            case 17: {
                boolean bl = this.zzq();
                parcel.writeNoException();
                zzc.zzb((Parcel)parcel, (boolean)bl);
                break;
            }
            case 16: {
                boolean bl = this.zzp();
                parcel.writeNoException();
                zzc.zzb((Parcel)parcel, (boolean)bl);
                break;
            }
            case 15: {
                boolean bl = this.zzo();
                parcel.writeNoException();
                zzc.zzb((Parcel)parcel, (boolean)bl);
                break;
            }
            case 14: {
                boolean bl = this.zzn();
                parcel.writeNoException();
                zzc.zzb((Parcel)parcel, (boolean)bl);
                break;
            }
            case 13: {
                boolean bl = this.zzm();
                parcel.writeNoException();
                zzc.zzb((Parcel)parcel, (boolean)bl);
                break;
            }
            case 12: {
                object = this.zzl();
                parcel.writeNoException();
                zzc.zzf((Parcel)parcel, (IInterface)object);
                break;
            }
            case 11: {
                boolean bl = this.zzk();
                parcel.writeNoException();
                zzc.zzb((Parcel)parcel, (boolean)bl);
                break;
            }
            case 10: {
                n = this.zzj();
                parcel.writeNoException();
                parcel.writeInt(n);
                break;
            }
            case 9: {
                object = this.zzi();
                parcel.writeNoException();
                zzc.zzf((Parcel)parcel, (IInterface)object);
                break;
            }
            case 8: {
                object = this.zzh();
                parcel.writeNoException();
                parcel.writeString((String)object);
                break;
            }
            case 7: {
                boolean bl = this.zzg();
                parcel.writeNoException();
                zzc.zzb((Parcel)parcel, (boolean)bl);
                break;
            }
            case 6: {
                object = this.zzf();
                parcel.writeNoException();
                zzc.zzf((Parcel)parcel, (IInterface)object);
                break;
            }
            case 5: {
                object = this.zze();
                parcel.writeNoException();
                zzc.zzf((Parcel)parcel, (IInterface)object);
                break;
            }
            case 4: {
                n = this.zzd();
                parcel.writeNoException();
                parcel.writeInt(n);
                break;
            }
            case 3: {
                object = this.zzc();
                parcel.writeNoException();
                zzc.zze((Parcel)parcel, (Parcelable)object);
                break;
            }
            case 2: {
                object = this.zzb();
                parcel.writeNoException();
                zzc.zzf((Parcel)parcel, (IInterface)object);
            }
        }
        return true;
    }
}
