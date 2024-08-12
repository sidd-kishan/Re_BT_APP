/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.IBinder
 *  android.os.IInterface
 *  android.os.RemoteException
 *  com.google.android.gms.internal.ads.zzadj
 */
package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.internal.ads.zzadj;

public final class zzbnp
extends zzadj
implements IInterface {
    zzbnp(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.formats.client.IOnMediaContentChangedListener");
    }

    public final void zze() throws RemoteException {
        this.zzbj(2, this.zza());
    }
}
