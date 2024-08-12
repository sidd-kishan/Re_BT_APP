/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.IBinder
 *  android.os.IInterface
 *  android.os.Parcel
 *  android.os.RemoteException
 *  com.google.android.gms.internal.ads.zzadk
 *  com.google.android.gms.internal.ads.zzbmz
 *  com.google.android.gms.internal.ads.zzbnb
 *  com.google.android.gms.internal.ads.zzbnm
 *  com.google.android.gms.internal.ads.zzbno
 */
package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.internal.ads.zzadk;
import com.google.android.gms.internal.ads.zzbmz;
import com.google.android.gms.internal.ads.zzbnb;
import com.google.android.gms.internal.ads.zzbnm;
import com.google.android.gms.internal.ads.zzbno;

public abstract class zzbnn
extends zzadk
implements zzbno {
    public zzbnn() {
        super("com.google.android.gms.ads.internal.formats.client.IOnCustomTemplateAdLoadedListener");
    }

    public static zzbno zzb(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface iInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.formats.client.IOnCustomTemplateAdLoadedListener");
        if (!(iInterface instanceof zzbno)) return new zzbnm(iBinder);
        return (zzbno)iInterface;
    }

    protected final boolean zzbz(int n, Parcel object, Parcel parcel, int n2) throws RemoteException {
        if (n != 1) return false;
        IBinder iBinder = object.readStrongBinder();
        object = iBinder == null ? null : ((object = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.formats.client.INativeCustomTemplateAd")) instanceof zzbnb ? (zzbnb)object : new zzbmz(iBinder));
        this.zze((zzbnb)object);
        parcel.writeNoException();
        return true;
    }
}
