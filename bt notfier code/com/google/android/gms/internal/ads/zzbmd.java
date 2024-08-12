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
 *  com.google.android.gms.internal.ads.zzbme
 *  com.google.android.gms.internal.ads.zzbnp
 */
package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.internal.ads.zzadk;
import com.google.android.gms.internal.ads.zzadl;
import com.google.android.gms.internal.ads.zzbme;
import com.google.android.gms.internal.ads.zzbnp;

public abstract class zzbmd
extends zzadk
implements zzbme {
    public zzbmd() {
        super("com.google.android.gms.ads.internal.formats.client.IMediaContent");
    }

    protected final boolean zzbz(int n, Parcel object, Parcel parcel, int n2) throws RemoteException {
        switch (n) {
            default: {
                return false;
            }
            case 9: {
                IInterface iInterface;
                object = object.readStrongBinder();
                object = object == null ? null : ((iInterface = object.queryLocalInterface("com.google.android.gms.ads.internal.formats.client.IOnMediaContentChangedListener")) instanceof zzbnp ? (zzbnp)iInterface : new zzbnp((IBinder)object));
                this.zzl((zzbnp)object);
                parcel.writeNoException();
                break;
            }
            case 8: {
                boolean bl = this.zzk();
                parcel.writeNoException();
                zzadl.zzb((Parcel)parcel, (boolean)bl);
                break;
            }
            case 7: {
                object = this.zzj();
                parcel.writeNoException();
                zzadl.zzf((Parcel)parcel, (IInterface)object);
                break;
            }
            case 6: {
                float f = this.zzi();
                parcel.writeNoException();
                parcel.writeFloat(f);
                break;
            }
            case 5: {
                float f = this.zzh();
                parcel.writeNoException();
                parcel.writeFloat(f);
                break;
            }
            case 4: {
                object = this.zzg();
                parcel.writeNoException();
                zzadl.zzf((Parcel)parcel, (IInterface)object);
                break;
            }
            case 3: {
                this.zzf(IObjectWrapper.Stub.asInterface((IBinder)object.readStrongBinder()));
                parcel.writeNoException();
                break;
            }
            case 2: {
                float f = this.zze();
                parcel.writeNoException();
                parcel.writeFloat(f);
            }
        }
        return true;
    }
}
