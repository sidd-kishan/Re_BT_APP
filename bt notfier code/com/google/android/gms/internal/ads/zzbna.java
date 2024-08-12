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
 *  com.google.android.gms.internal.ads.zzbmz
 *  com.google.android.gms.internal.ads.zzbnb
 */
package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.internal.ads.zzadk;
import com.google.android.gms.internal.ads.zzadl;
import com.google.android.gms.internal.ads.zzbmz;
import com.google.android.gms.internal.ads.zzbnb;
import java.util.List;

public abstract class zzbna
extends zzadk
implements zzbnb {
    public zzbna() {
        super("com.google.android.gms.ads.internal.formats.client.INativeCustomTemplateAd");
    }

    public static zzbnb zzb(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface iInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.formats.client.INativeCustomTemplateAd");
        if (!(iInterface instanceof zzbnb)) return new zzbmz(iBinder);
        return (zzbnb)iInterface;
    }

    protected final boolean zzbz(int n, Parcel object, Parcel parcel, int n2) throws RemoteException {
        switch (n) {
            default: {
                return false;
            }
            case 15: {
                this.zzr();
                parcel.writeNoException();
                break;
            }
            case 14: {
                this.zzq(IObjectWrapper.Stub.asInterface((IBinder)object.readStrongBinder()));
                parcel.writeNoException();
                break;
            }
            case 13: {
                boolean bl = this.zzp();
                parcel.writeNoException();
                zzadl.zzb((Parcel)parcel, (boolean)bl);
                break;
            }
            case 12: {
                boolean bl = this.zzo();
                parcel.writeNoException();
                zzadl.zzb((Parcel)parcel, (boolean)bl);
                break;
            }
            case 11: {
                parcel.writeNoException();
                zzadl.zzf((Parcel)parcel, null);
                break;
            }
            case 10: {
                boolean bl = this.zzn(IObjectWrapper.Stub.asInterface((IBinder)object.readStrongBinder()));
                parcel.writeNoException();
                zzadl.zzb((Parcel)parcel, (boolean)bl);
                break;
            }
            case 9: {
                object = this.zzm();
                parcel.writeNoException();
                zzadl.zzf((Parcel)parcel, (IInterface)object);
                break;
            }
            case 8: {
                this.zzl();
                parcel.writeNoException();
                break;
            }
            case 7: {
                object = this.zzk();
                parcel.writeNoException();
                zzadl.zzf((Parcel)parcel, (IInterface)object);
                break;
            }
            case 6: {
                this.zzj();
                parcel.writeNoException();
                break;
            }
            case 5: {
                this.zzi(object.readString());
                parcel.writeNoException();
                break;
            }
            case 4: {
                object = this.zzh();
                parcel.writeNoException();
                parcel.writeString((String)object);
                break;
            }
            case 3: {
                object = this.zzg();
                parcel.writeNoException();
                parcel.writeStringList((List)object);
                break;
            }
            case 2: {
                object = this.zzf(object.readString());
                parcel.writeNoException();
                zzadl.zzf((Parcel)parcel, (IInterface)object);
                break;
            }
            case 1: {
                object = this.zze(object.readString());
                parcel.writeNoException();
                parcel.writeString((String)object);
            }
        }
        return true;
    }
}
