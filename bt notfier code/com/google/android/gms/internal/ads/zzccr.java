/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.IBinder
 *  android.os.IInterface
 *  android.os.Parcel
 *  android.os.Parcelable
 *  android.os.Parcelable$Creator
 *  android.os.RemoteException
 *  com.google.android.gms.dynamic.IObjectWrapper$Stub
 *  com.google.android.gms.internal.ads.zzadk
 *  com.google.android.gms.internal.ads.zzadl
 *  com.google.android.gms.internal.ads.zzbdg
 *  com.google.android.gms.internal.ads.zzbgs
 *  com.google.android.gms.internal.ads.zzbgv
 *  com.google.android.gms.internal.ads.zzccq
 *  com.google.android.gms.internal.ads.zzccs
 *  com.google.android.gms.internal.ads.zzcct
 *  com.google.android.gms.internal.ads.zzccv
 *  com.google.android.gms.internal.ads.zzccx
 *  com.google.android.gms.internal.ads.zzccz
 *  com.google.android.gms.internal.ads.zzcda
 *  com.google.android.gms.internal.ads.zzcdg
 */
package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.internal.ads.zzadk;
import com.google.android.gms.internal.ads.zzadl;
import com.google.android.gms.internal.ads.zzbdg;
import com.google.android.gms.internal.ads.zzbgs;
import com.google.android.gms.internal.ads.zzbgv;
import com.google.android.gms.internal.ads.zzccq;
import com.google.android.gms.internal.ads.zzccs;
import com.google.android.gms.internal.ads.zzcct;
import com.google.android.gms.internal.ads.zzccv;
import com.google.android.gms.internal.ads.zzccx;
import com.google.android.gms.internal.ads.zzccz;
import com.google.android.gms.internal.ads.zzcda;
import com.google.android.gms.internal.ads.zzcdg;

public abstract class zzccr
extends zzadk
implements zzccs {
    public zzccr() {
        super("com.google.android.gms.ads.internal.rewarded.client.IRewardedAd");
    }

    public static zzccs zzq(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface iInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.rewarded.client.IRewardedAd");
        if (!(iInterface instanceof zzccs)) return new zzccq(iBinder);
        return (zzccs)iInterface;
    }

    protected final boolean zzbz(int n, Parcel object, Parcel parcel, int n2) throws RemoteException {
        Object var8_5 = null;
        Object var9_6 = null;
        zzbdg zzbdg2 = null;
        zzbdg zzbdg3 = null;
        switch (n) {
            default: {
                return false;
            }
            case 15: {
                this.zzo(zzadl.zza((Parcel)object));
                parcel.writeNoException();
                break;
            }
            case 14: {
                zzbdg2 = (zzbdg)zzadl.zzc((Parcel)object, (Parcelable.Creator)zzbdg.CREATOR);
                object = object.readStrongBinder();
                object = object == null ? zzbdg3 : ((zzbdg3 = object.queryLocalInterface("com.google.android.gms.ads.internal.rewarded.client.IRewardedAdLoadCallback")) instanceof zzccz ? (zzccz)zzbdg3 : new zzccx((IBinder)object));
                this.zzd(zzbdg2, (zzccz)object);
                parcel.writeNoException();
                break;
            }
            case 13: {
                this.zzn(zzbgv.zzb((IBinder)object.readStrongBinder()));
                parcel.writeNoException();
                break;
            }
            case 12: {
                object = this.zzm();
                parcel.writeNoException();
                zzadl.zzf((Parcel)parcel, (IInterface)object);
                break;
            }
            case 11: {
                object = this.zzl();
                parcel.writeNoException();
                zzadl.zzf((Parcel)parcel, (IInterface)object);
                break;
            }
            case 10: {
                this.zzk(IObjectWrapper.Stub.asInterface((IBinder)object.readStrongBinder()), zzadl.zza((Parcel)object));
                parcel.writeNoException();
                break;
            }
            case 9: {
                object = this.zzg();
                parcel.writeNoException();
                zzadl.zze((Parcel)parcel, (Parcelable)object);
                break;
            }
            case 8: {
                this.zzf(zzbgs.zzb((IBinder)object.readStrongBinder()));
                parcel.writeNoException();
                break;
            }
            case 7: {
                this.zzh((zzcdg)zzadl.zzc((Parcel)object, (Parcelable.Creator)zzcdg.CREATOR));
                parcel.writeNoException();
                break;
            }
            case 6: {
                object = object.readStrongBinder();
                object = object == null ? var8_5 : ((zzbdg2 = object.queryLocalInterface("com.google.android.gms.ads.internal.rewarded.client.IRewardedAdSkuListener")) instanceof zzcda ? (zzcda)zzbdg2 : new zzcda((IBinder)object));
                this.zzp((zzcda)object);
                parcel.writeNoException();
                break;
            }
            case 5: {
                this.zzb(IObjectWrapper.Stub.asInterface((IBinder)object.readStrongBinder()));
                parcel.writeNoException();
                break;
            }
            case 4: {
                object = this.zzj();
                parcel.writeNoException();
                parcel.writeString((String)object);
                break;
            }
            case 3: {
                boolean bl = this.zzi();
                parcel.writeNoException();
                zzadl.zzb((Parcel)parcel, (boolean)bl);
                break;
            }
            case 2: {
                object = object.readStrongBinder();
                object = object == null ? var9_6 : ((zzbdg2 = object.queryLocalInterface("com.google.android.gms.ads.internal.rewarded.client.IRewardedAdCallback")) instanceof zzccv ? (zzccv)zzbdg2 : new zzcct((IBinder)object));
                this.zze((zzccv)object);
                parcel.writeNoException();
                break;
            }
            case 1: {
                zzbdg3 = (zzbdg)zzadl.zzc((Parcel)object, (Parcelable.Creator)zzbdg.CREATOR);
                object = object.readStrongBinder();
                object = object == null ? zzbdg2 : ((zzbdg2 = object.queryLocalInterface("com.google.android.gms.ads.internal.rewarded.client.IRewardedAdLoadCallback")) instanceof zzccz ? (zzccz)zzbdg2 : new zzccx((IBinder)object));
                this.zzc(zzbdg3, (zzccz)object);
                parcel.writeNoException();
            }
        }
        return true;
    }
}
