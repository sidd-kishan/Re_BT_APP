/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Parcel
 *  android.os.RemoteException
 *  com.google.android.gms.internal.ads.zzadk
 *  com.google.android.gms.internal.ads.zzcbz
 */
package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.internal.ads.zzadk;
import com.google.android.gms.internal.ads.zzcbz;

public abstract class zzcby
extends zzadk
implements zzcbz {
    public zzcby() {
        super("com.google.android.gms.ads.internal.reward.client.IRewardItem");
    }

    protected final boolean zzbz(int n, Parcel object, Parcel parcel, int n2) throws RemoteException {
        if (n != 1) {
            if (n != 2) {
                return false;
            }
            n = this.zzc();
            parcel.writeNoException();
            parcel.writeInt(n);
        } else {
            object = this.zzb();
            parcel.writeNoException();
            parcel.writeString((String)object);
        }
        return true;
    }
}
