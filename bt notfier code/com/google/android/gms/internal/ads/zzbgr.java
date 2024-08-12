/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.IBinder
 *  android.os.RemoteException
 *  com.google.android.gms.internal.ads.zzadj
 *  com.google.android.gms.internal.ads.zzbgt
 */
package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.RemoteException;
import com.google.android.gms.internal.ads.zzadj;
import com.google.android.gms.internal.ads.zzbgt;

public final class zzbgr
extends zzadj
implements zzbgt {
    zzbgr(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.client.IOnAdMetadataChangedListener");
    }

    public final void zze() throws RemoteException {
        this.zzbj(1, this.zza());
    }
}
