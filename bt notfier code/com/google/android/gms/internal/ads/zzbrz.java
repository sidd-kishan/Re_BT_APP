/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.IBinder
 *  android.os.IInterface
 *  android.os.Parcel
 *  android.os.RemoteException
 *  com.google.android.gms.dynamic.IObjectWrapper
 *  com.google.android.gms.dynamic.IObjectWrapper$Stub
 *  com.google.android.gms.internal.ads.zzadk
 *  com.google.android.gms.internal.ads.zzadl
 *  com.google.android.gms.internal.ads.zzbsa
 *  com.google.android.gms.internal.ads.zzbsb
 *  com.google.android.gms.internal.ads.zzbsd
 */
package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.internal.ads.zzadk;
import com.google.android.gms.internal.ads.zzadl;
import com.google.android.gms.internal.ads.zzbsa;
import com.google.android.gms.internal.ads.zzbsb;
import com.google.android.gms.internal.ads.zzbsd;

public abstract class zzbrz
extends zzadk
implements zzbsa {
    public zzbrz() {
        super("com.google.android.gms.ads.internal.instream.client.IInstreamAd");
    }

    protected final boolean zzbz(int n, Parcel object, Parcel parcel, int n2) throws RemoteException {
        if (n != 3) {
            if (n != 4) {
                if (n != 5) {
                    if (n != 6) {
                        if (n != 7) {
                            return false;
                        }
                        object = this.zzf();
                        parcel.writeNoException();
                        zzadl.zzf((Parcel)parcel, (IInterface)object);
                    } else {
                        this.zze(IObjectWrapper.Stub.asInterface((IBinder)object.readStrongBinder()));
                        parcel.writeNoException();
                    }
                } else {
                    IInterface iInterface;
                    IObjectWrapper iObjectWrapper = IObjectWrapper.Stub.asInterface((IBinder)object.readStrongBinder());
                    object = (object = object.readStrongBinder()) == null ? null : ((iInterface = object.queryLocalInterface("com.google.android.gms.ads.internal.instream.client.IInstreamAdCallback")) instanceof zzbsd ? (zzbsd)iInterface : new zzbsb((IBinder)object));
                    this.zzd(iObjectWrapper, (zzbsd)object);
                    parcel.writeNoException();
                }
            } else {
                this.zzc();
                parcel.writeNoException();
            }
        } else {
            object = this.zzb();
            parcel.writeNoException();
            zzadl.zzf((Parcel)parcel, (IInterface)object);
        }
        return true;
    }
}
