/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.IBinder
 *  android.os.IInterface
 *  android.os.Parcel
 *  android.os.RemoteException
 *  com.google.android.gms.common.internal.zzw
 *  com.google.android.gms.common.internal.zzy
 *  com.google.android.gms.internal.common.zzb
 *  com.google.android.gms.internal.common.zzc
 */
package com.google.android.gms.common.internal;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.common.internal.zzy;
import com.google.android.gms.internal.common.zzb;
import com.google.android.gms.internal.common.zzc;

public abstract class zzx
extends zzb
implements zzy {
    public zzx() {
        super("com.google.android.gms.common.internal.ICertData");
    }

    public static zzy zzg(IBinder iBinder) {
        IInterface iInterface = iBinder.queryLocalInterface("com.google.android.gms.common.internal.ICertData");
        if (!(iInterface instanceof zzy)) return new zzw(iBinder);
        return (zzy)iInterface;
    }

    protected final boolean zza(int n, Parcel parcel, Parcel parcel2, int n2) throws RemoteException {
        if (n != 1) {
            if (n != 2) {
                return false;
            }
            n = this.zze();
            parcel2.writeNoException();
            parcel2.writeInt(n);
        } else {
            parcel = this.zzd();
            parcel2.writeNoException();
            zzc.zzf((Parcel)parcel2, (IInterface)parcel);
        }
        return true;
    }
}
