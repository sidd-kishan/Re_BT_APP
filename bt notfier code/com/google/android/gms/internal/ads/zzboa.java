/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Parcel
 *  android.os.RemoteException
 *  com.google.android.gms.internal.ads.zzadk
 *  com.google.android.gms.internal.ads.zzbob
 */
package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.internal.ads.zzadk;
import com.google.android.gms.internal.ads.zzbob;

public abstract class zzboa
extends zzadk
implements zzbob {
    public zzboa() {
        super("com.google.android.gms.ads.internal.formats.client.IUnconfirmedClickListener");
    }

    protected final boolean zzbz(int n, Parcel parcel, Parcel parcel2, int n2) throws RemoteException {
        if (n != 1) {
            if (n != 2) {
                return false;
            }
            this.zzf();
        } else {
            this.zze(parcel.readString());
        }
        parcel2.writeNoException();
        return true;
    }
}
