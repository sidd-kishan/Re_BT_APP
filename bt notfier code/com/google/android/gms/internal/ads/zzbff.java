/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Parcel
 *  android.os.Parcelable$Creator
 *  android.os.RemoteException
 *  com.google.android.gms.internal.ads.zzadk
 *  com.google.android.gms.internal.ads.zzadl
 *  com.google.android.gms.internal.ads.zzbdg
 *  com.google.android.gms.internal.ads.zzbfg
 */
package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import com.google.android.gms.internal.ads.zzadk;
import com.google.android.gms.internal.ads.zzadl;
import com.google.android.gms.internal.ads.zzbdg;
import com.google.android.gms.internal.ads.zzbfg;

public abstract class zzbff
extends zzadk
implements zzbfg {
    public zzbff() {
        super("com.google.android.gms.ads.internal.client.IAdLoader");
    }

    protected final boolean zzbz(int n, Parcel object, Parcel parcel, int n2) throws RemoteException {
        if (n != 1) {
            if (n != 2) {
                if (n != 3) {
                    if (n != 4) {
                        if (n != 5) {
                            return false;
                        }
                        this.zzi((zzbdg)zzadl.zzc((Parcel)object, (Parcelable.Creator)zzbdg.CREATOR), object.readInt());
                        parcel.writeNoException();
                    } else {
                        object = this.zzh();
                        parcel.writeNoException();
                        parcel.writeString((String)object);
                    }
                } else {
                    boolean bl = this.zzg();
                    parcel.writeNoException();
                    zzadl.zzb((Parcel)parcel, (boolean)bl);
                }
            } else {
                object = this.zzf();
                parcel.writeNoException();
                parcel.writeString((String)object);
            }
        } else {
            this.zze((zzbdg)zzadl.zzc((Parcel)object, (Parcelable.Creator)zzbdg.CREATOR));
            parcel.writeNoException();
        }
        return true;
    }
}
