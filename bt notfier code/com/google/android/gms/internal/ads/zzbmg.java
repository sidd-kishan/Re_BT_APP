/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.IBinder
 *  android.os.IInterface
 *  android.os.Parcel
 *  android.os.Parcelable
 *  android.os.RemoteException
 *  com.google.android.gms.internal.ads.zzadk
 *  com.google.android.gms.internal.ads.zzadl
 *  com.google.android.gms.internal.ads.zzbmf
 *  com.google.android.gms.internal.ads.zzbmh
 */
package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import com.google.android.gms.internal.ads.zzadk;
import com.google.android.gms.internal.ads.zzadl;
import com.google.android.gms.internal.ads.zzbmf;
import com.google.android.gms.internal.ads.zzbmh;

public abstract class zzbmg
extends zzadk
implements zzbmh {
    public zzbmg() {
        super("com.google.android.gms.ads.internal.formats.client.INativeAdImage");
    }

    public static zzbmh zzg(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface iInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.formats.client.INativeAdImage");
        if (!(iInterface instanceof zzbmh)) return new zzbmf(iBinder);
        return (zzbmh)iInterface;
    }

    protected final boolean zzbz(int n, Parcel parcel, Parcel parcel2, int n2) throws RemoteException {
        if (n != 1) {
            if (n != 2) {
                if (n != 3) {
                    if (n != 4) {
                        if (n != 5) {
                            return false;
                        }
                        n = this.zzf();
                        parcel2.writeNoException();
                        parcel2.writeInt(n);
                    } else {
                        n = this.zze();
                        parcel2.writeNoException();
                        parcel2.writeInt(n);
                    }
                } else {
                    double d = this.zzd();
                    parcel2.writeNoException();
                    parcel2.writeDouble(d);
                }
            } else {
                parcel = this.zzc();
                parcel2.writeNoException();
                zzadl.zze((Parcel)parcel2, (Parcelable)parcel);
            }
        } else {
            parcel = this.zzb();
            parcel2.writeNoException();
            zzadl.zzf((Parcel)parcel2, (IInterface)parcel);
        }
        return true;
    }
}
