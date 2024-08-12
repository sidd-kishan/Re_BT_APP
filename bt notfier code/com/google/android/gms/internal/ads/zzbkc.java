/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.IBinder
 *  android.os.Parcel
 *  android.os.RemoteException
 *  com.google.android.gms.dynamic.IObjectWrapper$Stub
 *  com.google.android.gms.internal.ads.zzadk
 *  com.google.android.gms.internal.ads.zzbkd
 */
package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.internal.ads.zzadk;
import com.google.android.gms.internal.ads.zzbkd;

public abstract class zzbkc
extends zzadk
implements zzbkd {
    public zzbkc() {
        super("com.google.android.gms.ads.internal.customrenderedad.client.ICustomRenderedAd");
    }

    protected final boolean zzbz(int n, Parcel object, Parcel parcel, int n2) throws RemoteException {
        if (n != 1) {
            if (n != 2) {
                if (n != 3) {
                    if (n != 4) {
                        if (n != 5) {
                            return false;
                        }
                        this.zzf();
                        parcel.writeNoException();
                    } else {
                        this.zze();
                        parcel.writeNoException();
                    }
                } else {
                    this.zzd(IObjectWrapper.Stub.asInterface((IBinder)object.readStrongBinder()));
                    parcel.writeNoException();
                }
            } else {
                object = this.zzc();
                parcel.writeNoException();
                parcel.writeString((String)object);
            }
        } else {
            object = this.zzb();
            parcel.writeNoException();
            parcel.writeString((String)object);
        }
        return true;
    }
}
