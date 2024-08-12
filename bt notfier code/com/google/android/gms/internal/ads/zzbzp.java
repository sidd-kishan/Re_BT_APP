/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Intent
 *  android.os.Bundle
 *  android.os.IBinder
 *  android.os.IInterface
 *  android.os.Parcel
 *  android.os.Parcelable
 *  android.os.Parcelable$Creator
 *  android.os.RemoteException
 *  com.google.android.gms.dynamic.IObjectWrapper$Stub
 *  com.google.android.gms.internal.ads.zzadk
 *  com.google.android.gms.internal.ads.zzadl
 *  com.google.android.gms.internal.ads.zzbzo
 *  com.google.android.gms.internal.ads.zzbzq
 */
package com.google.android.gms.internal.ads;

import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.internal.ads.zzadk;
import com.google.android.gms.internal.ads.zzadl;
import com.google.android.gms.internal.ads.zzbzo;
import com.google.android.gms.internal.ads.zzbzq;

public abstract class zzbzp
extends zzadk
implements zzbzq {
    public zzbzp() {
        super("com.google.android.gms.ads.internal.overlay.client.IAdOverlay");
    }

    public static zzbzq zzF(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface iInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.overlay.client.IAdOverlay");
        if (!(iInterface instanceof zzbzq)) return new zzbzo(iBinder);
        return (zzbzq)iInterface;
    }

    protected final boolean zzbz(int n, Parcel parcel, Parcel parcel2, int n2) throws RemoteException {
        switch (n) {
            default: {
                return false;
            }
            case 14: {
                this.zzf();
                parcel2.writeNoException();
                break;
            }
            case 13: {
                this.zzn(IObjectWrapper.Stub.asInterface((IBinder)parcel.readStrongBinder()));
                parcel2.writeNoException();
                break;
            }
            case 12: {
                parcel.readInt();
                parcel.readInt();
                parcel = (Intent)zzadl.zzc((Parcel)parcel, (Parcelable.Creator)Intent.CREATOR);
                parcel2.writeNoException();
                break;
            }
            case 11: {
                boolean bl = this.zzg();
                parcel2.writeNoException();
                zzadl.zzb((Parcel)parcel2, (boolean)bl);
                break;
            }
            case 10: {
                this.zze();
                parcel2.writeNoException();
                break;
            }
            case 9: {
                this.zzs();
                parcel2.writeNoException();
                break;
            }
            case 8: {
                this.zzq();
                parcel2.writeNoException();
                break;
            }
            case 7: {
                this.zzp();
                parcel2.writeNoException();
                break;
            }
            case 6: {
                parcel = (Bundle)zzadl.zzc((Parcel)parcel, (Parcelable.Creator)Bundle.CREATOR);
                this.zzo((Bundle)parcel);
                parcel2.writeNoException();
                zzadl.zze((Parcel)parcel2, (Parcelable)parcel);
                break;
            }
            case 5: {
                this.zzl();
                parcel2.writeNoException();
                break;
            }
            case 4: {
                this.zzk();
                parcel2.writeNoException();
                break;
            }
            case 3: {
                this.zzj();
                parcel2.writeNoException();
                break;
            }
            case 2: {
                parcel2.writeNoException();
                break;
            }
            case 1: {
                this.zzh((Bundle)zzadl.zzc((Parcel)parcel, (Parcelable.Creator)Bundle.CREATOR));
                parcel2.writeNoException();
            }
        }
        return true;
    }
}
