/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.IBinder
 *  android.os.Parcel
 *  android.os.Parcelable$Creator
 *  android.os.RemoteException
 *  com.google.android.gms.internal.ads.zzadk
 *  com.google.android.gms.internal.ads.zzadl
 *  com.google.android.gms.internal.ads.zzbcz
 *  com.google.android.gms.internal.ads.zzbvu
 *  com.google.android.gms.internal.ads.zzbxh
 */
package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import com.google.android.gms.internal.ads.zzadk;
import com.google.android.gms.internal.ads.zzadl;
import com.google.android.gms.internal.ads.zzbcz;
import com.google.android.gms.internal.ads.zzbvu;
import com.google.android.gms.internal.ads.zzbxh;

public abstract class zzbxg
extends zzadk
implements zzbxh {
    public zzbxg() {
        super("com.google.android.gms.ads.internal.mediation.client.rtb.INativeCallback");
    }

    protected final boolean zzbz(int n, Parcel parcel, Parcel parcel2, int n2) throws RemoteException {
        if (n != 1) {
            if (n != 2) {
                if (n != 3) {
                    return false;
                }
                this.zzg((zzbcz)zzadl.zzc((Parcel)parcel, (Parcelable.Creator)zzbcz.CREATOR));
            } else {
                this.zzf(parcel.readString());
            }
        } else {
            this.zze(zzbvu.zzb((IBinder)parcel.readStrongBinder()));
        }
        parcel2.writeNoException();
        return true;
    }
}
