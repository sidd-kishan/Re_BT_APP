/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Parcel
 *  android.os.ParcelFileDescriptor
 *  android.os.Parcelable$Creator
 *  android.os.RemoteException
 *  com.google.android.gms.ads.internal.util.zzbc
 *  com.google.android.gms.internal.ads.zzadk
 *  com.google.android.gms.internal.ads.zzadl
 *  com.google.android.gms.internal.ads.zzcbf
 */
package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable;
import android.os.RemoteException;
import com.google.android.gms.ads.internal.util.zzbc;
import com.google.android.gms.internal.ads.zzadk;
import com.google.android.gms.internal.ads.zzadl;
import com.google.android.gms.internal.ads.zzcbf;

public abstract class zzcbe
extends zzadk
implements zzcbf {
    public zzcbe() {
        super("com.google.android.gms.ads.internal.request.INonagonStreamingResponseListener");
    }

    protected final boolean zzbz(int n, Parcel parcel, Parcel parcel2, int n2) throws RemoteException {
        if (n != 1) {
            if (n != 2) {
                return false;
            }
            this.zzf((zzbc)zzadl.zzc((Parcel)parcel, (Parcelable.Creator)zzbc.CREATOR));
        } else {
            this.zze((ParcelFileDescriptor)zzadl.zzc((Parcel)parcel, (Parcelable.Creator)ParcelFileDescriptor.CREATOR));
        }
        parcel2.writeNoException();
        return true;
    }
}
