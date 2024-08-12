/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.IBinder
 *  android.os.Parcel
 *  android.os.RemoteException
 *  com.google.android.gms.internal.ads.zzadj
 *  com.google.android.gms.internal.ads.zzbob
 */
package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.internal.ads.zzadj;
import com.google.android.gms.internal.ads.zzbob;

public final class zzbnz
extends zzadj
implements zzbob {
    zzbnz(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.formats.client.IUnconfirmedClickListener");
    }

    public final void zze(String string) throws RemoteException {
        Parcel parcel = this.zza();
        parcel.writeString(string);
        this.zzbj(1, parcel);
    }

    public final void zzf() throws RemoteException {
        this.zzbj(2, this.zza());
    }
}
