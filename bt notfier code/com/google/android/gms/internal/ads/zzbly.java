/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.IBinder
 *  android.os.IInterface
 *  android.os.Parcel
 *  android.os.RemoteException
 *  com.google.android.gms.internal.ads.zzadk
 *  com.google.android.gms.internal.ads.zzblx
 *  com.google.android.gms.internal.ads.zzblz
 */
package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.internal.ads.zzadk;
import com.google.android.gms.internal.ads.zzblx;
import com.google.android.gms.internal.ads.zzblz;
import java.util.List;

public abstract class zzbly
extends zzadk
implements zzblz {
    public zzbly() {
        super("com.google.android.gms.ads.internal.formats.client.IAttributionInfo");
    }

    public static zzblz zzj(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface iInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.formats.client.IAttributionInfo");
        if (!(iInterface instanceof zzblz)) return new zzblx(iBinder);
        return (zzblz)iInterface;
    }

    protected final boolean zzbz(int n, Parcel object, Parcel parcel, int n2) throws RemoteException {
        if (n != 2) {
            if (n != 3) {
                return false;
            }
            object = this.zzc();
            parcel.writeNoException();
            parcel.writeList((List)object);
        } else {
            object = this.zzb();
            parcel.writeNoException();
            parcel.writeString((String)object);
        }
        return true;
    }
}
