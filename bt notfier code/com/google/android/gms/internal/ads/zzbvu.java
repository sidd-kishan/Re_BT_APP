/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.IBinder
 *  android.os.IInterface
 *  android.os.Parcel
 *  android.os.Parcelable
 *  android.os.RemoteException
 *  com.google.android.gms.dynamic.IObjectWrapper$Stub
 *  com.google.android.gms.internal.ads.zzadk
 *  com.google.android.gms.internal.ads.zzadl
 *  com.google.android.gms.internal.ads.zzbvt
 *  com.google.android.gms.internal.ads.zzbvv
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
import com.google.android.gms.internal.ads.zzbvt;
import com.google.android.gms.internal.ads.zzbvv;
import java.util.List;

public abstract class zzbvu
extends zzadk
implements zzbvv {
    public zzbvu() {
        super("com.google.android.gms.ads.internal.mediation.client.IUnifiedNativeAdMapper");
    }

    public static zzbvv zzb(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface iInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.mediation.client.IUnifiedNativeAdMapper");
        if (!(iInterface instanceof zzbvv)) return new zzbvt(iBinder);
        return (zzbvv)iInterface;
    }

    protected final boolean zzbz(int n, Parcel object, Parcel parcel, int n2) throws RemoteException {
        switch (n) {
            default: {
                return false;
            }
            case 25: {
                float f = this.zzB();
                parcel.writeNoException();
                parcel.writeFloat(f);
                break;
            }
            case 24: {
                float f = this.zzA();
                parcel.writeNoException();
                parcel.writeFloat(f);
                break;
            }
            case 23: {
                float f = this.zzz();
                parcel.writeNoException();
                parcel.writeFloat(f);
                break;
            }
            case 22: {
                this.zzy(IObjectWrapper.Stub.asInterface((IBinder)object.readStrongBinder()));
                parcel.writeNoException();
                break;
            }
            case 21: {
                this.zzx(IObjectWrapper.Stub.asInterface((IBinder)object.readStrongBinder()), IObjectWrapper.Stub.asInterface((IBinder)object.readStrongBinder()), IObjectWrapper.Stub.asInterface((IBinder)object.readStrongBinder()));
                parcel.writeNoException();
                break;
            }
            case 20: {
                this.zzw(IObjectWrapper.Stub.asInterface((IBinder)object.readStrongBinder()));
                parcel.writeNoException();
                break;
            }
            case 19: {
                this.zzv();
                parcel.writeNoException();
                break;
            }
            case 18: {
                boolean bl = this.zzu();
                parcel.writeNoException();
                zzadl.zzb((Parcel)parcel, (boolean)bl);
                break;
            }
            case 17: {
                boolean bl = this.zzt();
                parcel.writeNoException();
                zzadl.zzb((Parcel)parcel, (boolean)bl);
                break;
            }
            case 16: {
                object = this.zzs();
                parcel.writeNoException();
                zzadl.zze((Parcel)parcel, (Parcelable)object);
                break;
            }
            case 15: {
                object = this.zzr();
                parcel.writeNoException();
                zzadl.zzf((Parcel)parcel, (IInterface)object);
                break;
            }
            case 14: {
                object = this.zzq();
                parcel.writeNoException();
                zzadl.zzf((Parcel)parcel, (IInterface)object);
                break;
            }
            case 13: {
                object = this.zzp();
                parcel.writeNoException();
                zzadl.zzf((Parcel)parcel, (IInterface)object);
                break;
            }
            case 12: {
                parcel.writeNoException();
                zzadl.zzf((Parcel)parcel, null);
                break;
            }
            case 11: {
                object = this.zzn();
                parcel.writeNoException();
                zzadl.zzf((Parcel)parcel, (IInterface)object);
                break;
            }
            case 10: {
                object = this.zzm();
                parcel.writeNoException();
                parcel.writeString((String)object);
                break;
            }
            case 9: {
                object = this.zzl();
                parcel.writeNoException();
                parcel.writeString((String)object);
                break;
            }
            case 8: {
                double d = this.zzk();
                parcel.writeNoException();
                parcel.writeDouble(d);
                break;
            }
            case 7: {
                object = this.zzj();
                parcel.writeNoException();
                parcel.writeString((String)object);
                break;
            }
            case 6: {
                object = this.zzi();
                parcel.writeNoException();
                parcel.writeString((String)object);
                break;
            }
            case 5: {
                object = this.zzh();
                parcel.writeNoException();
                zzadl.zzf((Parcel)parcel, (IInterface)object);
                break;
            }
            case 4: {
                object = this.zzg();
                parcel.writeNoException();
                parcel.writeString((String)object);
                break;
            }
            case 3: {
                object = this.zzf();
                parcel.writeNoException();
                parcel.writeList((List)object);
                break;
            }
            case 2: {
                object = this.zze();
                parcel.writeNoException();
                parcel.writeString((String)object);
            }
        }
        return true;
    }
}
