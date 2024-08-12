/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Parcel
 *  android.os.Parcelable$Creator
 *  android.os.RemoteException
 *  com.google.android.gms.internal.ads.zzadk
 *  com.google.android.gms.internal.ads.zzadl
 *  com.google.android.gms.internal.ads.zzbcz
 *  com.google.android.gms.internal.ads.zzbfd
 */
package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import com.google.android.gms.internal.ads.zzadk;
import com.google.android.gms.internal.ads.zzadl;
import com.google.android.gms.internal.ads.zzbcz;
import com.google.android.gms.internal.ads.zzbfd;

public abstract class zzbfc
extends zzadk
implements zzbfd {
    public zzbfc() {
        super("com.google.android.gms.ads.internal.client.IAdLoadCallback");
    }

    protected final boolean zzbz(int n, Parcel parcel, Parcel parcel2, int n2) throws RemoteException {
        if (n != 1) {
            if (n != 2) {
                return false;
            }
            this.zzc((zzbcz)zzadl.zzc((Parcel)parcel, (Parcelable.Creator)zzbcz.CREATOR));
        } else {
            this.zzb();
        }
        parcel2.writeNoException();
        return true;
    }
}
