/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.IBinder
 *  android.os.IInterface
 *  android.os.Parcel
 *  android.os.Parcelable$Creator
 *  android.os.RemoteException
 *  com.google.android.gms.internal.ads.zzadk
 *  com.google.android.gms.internal.ads.zzadl
 *  com.google.android.gms.internal.ads.zzaxu
 *  com.google.android.gms.internal.ads.zzaxw
 *  com.google.android.gms.internal.ads.zzaxx
 *  com.google.android.gms.internal.ads.zzaxz
 *  com.google.android.gms.internal.ads.zzbcz
 */
package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import com.google.android.gms.internal.ads.zzadk;
import com.google.android.gms.internal.ads.zzadl;
import com.google.android.gms.internal.ads.zzaxu;
import com.google.android.gms.internal.ads.zzaxw;
import com.google.android.gms.internal.ads.zzaxx;
import com.google.android.gms.internal.ads.zzaxz;
import com.google.android.gms.internal.ads.zzbcz;

public abstract class zzaxy
extends zzadk
implements zzaxz {
    public zzaxy() {
        super("com.google.android.gms.ads.internal.appopen.client.IAppOpenAdLoadCallback");
    }

    public static zzaxz zze(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface iInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.appopen.client.IAppOpenAdLoadCallback");
        if (!(iInterface instanceof zzaxz)) return new zzaxx(iBinder);
        return (zzaxz)iInterface;
    }

    protected final boolean zzbz(int n, Parcel object, Parcel parcel, int n2) throws RemoteException {
        if (n != 1) {
            if (n != 2) {
                if (n != 3) {
                    return false;
                }
                this.zzd((zzbcz)zzadl.zzc((Parcel)object, (Parcelable.Creator)zzbcz.CREATOR));
            } else {
                object.readInt();
            }
        } else {
            IInterface iInterface;
            object = (object = object.readStrongBinder()) == null ? null : ((iInterface = object.queryLocalInterface("com.google.android.gms.ads.internal.appopen.client.IAppOpenAd")) instanceof zzaxw ? (zzaxw)iInterface : new zzaxu((IBinder)object));
            this.zzb((zzaxw)object);
        }
        parcel.writeNoException();
        return true;
    }
}
