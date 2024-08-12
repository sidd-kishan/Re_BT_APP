/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.IBinder
 *  android.os.Parcel
 *  android.os.RemoteException
 *  com.google.android.gms.internal.ads.zzadj
 *  com.google.android.gms.internal.ads.zzbfu
 */
package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.internal.ads.zzadj;
import com.google.android.gms.internal.ads.zzbfu;

public final class zzbfs
extends zzadj
implements zzbfu {
    zzbfs(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.client.IAppEventListener");
    }

    public final void zzb(String string, String string2) throws RemoteException {
        Parcel parcel = this.zza();
        parcel.writeString(string);
        parcel.writeString(string2);
        this.zzbj(1, parcel);
    }
}
