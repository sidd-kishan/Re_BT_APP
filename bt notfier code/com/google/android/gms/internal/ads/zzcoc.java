/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Bundle
 *  android.os.IBinder
 *  android.os.Parcel
 *  android.os.Parcelable
 *  android.os.Parcelable$Creator
 *  android.os.RemoteException
 *  com.google.android.gms.dynamic.IObjectWrapper$Stub
 *  com.google.android.gms.internal.ads.zzadk
 *  com.google.android.gms.internal.ads.zzadl
 *  com.google.android.gms.internal.ads.zzcod
 */
package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.internal.ads.zzadk;
import com.google.android.gms.internal.ads.zzadl;
import com.google.android.gms.internal.ads.zzcod;
import java.util.List;
import java.util.Map;

public abstract class zzcoc
extends zzadk
implements zzcod {
    public zzcoc() {
        super("com.google.android.gms.ads.measurement.IAppMeasurementProxy");
    }

    protected final boolean zzbz(int n, Parcel object, Parcel parcel, int n2) throws RemoteException {
        switch (n) {
            default: {
                return false;
            }
            case 19: {
                this.zzp((Bundle)zzadl.zzc((Parcel)object, (Parcelable.Creator)Bundle.CREATOR));
                parcel.writeNoException();
                break;
            }
            case 18: {
                object = this.zzt();
                parcel.writeNoException();
                parcel.writeString((String)object);
                break;
            }
            case 17: {
                object = this.zzs();
                parcel.writeNoException();
                parcel.writeString((String)object);
                break;
            }
            case 16: {
                object = this.zzr();
                parcel.writeNoException();
                parcel.writeString((String)object);
                break;
            }
            case 15: {
                this.zzq(IObjectWrapper.Stub.asInterface((IBinder)object.readStrongBinder()), object.readString(), object.readString());
                parcel.writeNoException();
                break;
            }
            case 14: {
                this.zzo(object.readString());
                parcel.writeNoException();
                break;
            }
            case 13: {
                this.zzn(object.readString());
                parcel.writeNoException();
                break;
            }
            case 12: {
                long l = this.zzm();
                parcel.writeNoException();
                parcel.writeLong(l);
                break;
            }
            case 11: {
                object = this.zzl();
                parcel.writeNoException();
                parcel.writeString((String)object);
                break;
            }
            case 10: {
                object = this.zzk();
                parcel.writeNoException();
                parcel.writeString((String)object);
                break;
            }
            case 9: {
                object = this.zzj(object.readString(), object.readString());
                parcel.writeNoException();
                parcel.writeList((List)object);
                break;
            }
            case 8: {
                this.zzi(object.readString(), object.readString(), (Bundle)zzadl.zzc((Parcel)object, (Parcelable.Creator)Bundle.CREATOR));
                parcel.writeNoException();
                break;
            }
            case 7: {
                this.zzh((Bundle)zzadl.zzc((Parcel)object, (Parcelable.Creator)Bundle.CREATOR));
                parcel.writeNoException();
                break;
            }
            case 6: {
                n = this.zzg(object.readString());
                parcel.writeNoException();
                parcel.writeInt(n);
                break;
            }
            case 5: {
                object = this.zzf(object.readString(), object.readString(), zzadl.zza((Parcel)object));
                parcel.writeNoException();
                parcel.writeMap((Map)object);
                break;
            }
            case 4: {
                this.zze(object.readString(), object.readString(), IObjectWrapper.Stub.asInterface((IBinder)object.readStrongBinder()));
                parcel.writeNoException();
                break;
            }
            case 3: {
                this.zzd(object.readString(), object.readString(), (Bundle)zzadl.zzc((Parcel)object, (Parcelable.Creator)Bundle.CREATOR));
                parcel.writeNoException();
                break;
            }
            case 2: {
                object = this.zzc((Bundle)zzadl.zzc((Parcel)object, (Parcelable.Creator)Bundle.CREATOR));
                parcel.writeNoException();
                zzadl.zze((Parcel)parcel, (Parcelable)object);
                break;
            }
            case 1: {
                this.zzb((Bundle)zzadl.zzc((Parcel)object, (Parcelable.Creator)Bundle.CREATOR));
                parcel.writeNoException();
            }
        }
        return true;
    }
}
