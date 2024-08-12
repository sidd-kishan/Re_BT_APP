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
 *  com.google.android.gms.internal.ads.zzbxk
 */
package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import com.google.android.gms.internal.ads.zzadk;
import com.google.android.gms.internal.ads.zzadl;
import com.google.android.gms.internal.ads.zzbcz;
import com.google.android.gms.internal.ads.zzbxk;

public abstract class zzbxj
extends zzadk
implements zzbxk {
    public zzbxj() {
        super("com.google.android.gms.ads.internal.mediation.client.rtb.IRewardedCallback");
    }

    protected final boolean zzbz(int n, Parcel parcel, Parcel parcel2, int n2) throws RemoteException {
        if (n != 2) {
            if (n != 3) {
                if (n != 4) {
                    return false;
                }
                this.zzg((zzbcz)zzadl.zzc((Parcel)parcel, (Parcelable.Creator)zzbcz.CREATOR));
            } else {
                this.zzf(parcel.readString());
            }
        } else {
            this.zze();
        }
        parcel2.writeNoException();
        return true;
    }
}
