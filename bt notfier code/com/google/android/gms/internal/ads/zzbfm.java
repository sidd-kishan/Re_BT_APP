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
 *  com.google.android.gms.internal.ads.zzaxy
 *  com.google.android.gms.internal.ads.zzbdg
 *  com.google.android.gms.internal.ads.zzbdl
 *  com.google.android.gms.internal.ads.zzbdr
 *  com.google.android.gms.internal.ads.zzbev
 *  com.google.android.gms.internal.ads.zzbex
 *  com.google.android.gms.internal.ads.zzbey
 *  com.google.android.gms.internal.ads.zzbfa
 *  com.google.android.gms.internal.ads.zzbfb
 *  com.google.android.gms.internal.ads.zzbfd
 *  com.google.android.gms.internal.ads.zzbfl
 *  com.google.android.gms.internal.ads.zzbfn
 *  com.google.android.gms.internal.ads.zzbfp
 *  com.google.android.gms.internal.ads.zzbfr
 *  com.google.android.gms.internal.ads.zzbfs
 *  com.google.android.gms.internal.ads.zzbfu
 *  com.google.android.gms.internal.ads.zzbfy
 *  com.google.android.gms.internal.ads.zzbfz
 *  com.google.android.gms.internal.ads.zzbgb
 *  com.google.android.gms.internal.ads.zzbgu
 *  com.google.android.gms.internal.ads.zzbgw
 *  com.google.android.gms.internal.ads.zzbhg
 *  com.google.android.gms.internal.ads.zzbis
 *  com.google.android.gms.internal.ads.zzbkf
 *  com.google.android.gms.internal.ads.zzbzy
 *  com.google.android.gms.internal.ads.zzcab
 *  com.google.android.gms.internal.ads.zzcce
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
import com.google.android.gms.internal.ads.zzaxy;
import com.google.android.gms.internal.ads.zzbdg;
import com.google.android.gms.internal.ads.zzbdl;
import com.google.android.gms.internal.ads.zzbdr;
import com.google.android.gms.internal.ads.zzbev;
import com.google.android.gms.internal.ads.zzbex;
import com.google.android.gms.internal.ads.zzbey;
import com.google.android.gms.internal.ads.zzbfa;
import com.google.android.gms.internal.ads.zzbfb;
import com.google.android.gms.internal.ads.zzbfd;
import com.google.android.gms.internal.ads.zzbfl;
import com.google.android.gms.internal.ads.zzbfn;
import com.google.android.gms.internal.ads.zzbfp;
import com.google.android.gms.internal.ads.zzbfr;
import com.google.android.gms.internal.ads.zzbfs;
import com.google.android.gms.internal.ads.zzbfu;
import com.google.android.gms.internal.ads.zzbfy;
import com.google.android.gms.internal.ads.zzbfz;
import com.google.android.gms.internal.ads.zzbgb;
import com.google.android.gms.internal.ads.zzbgu;
import com.google.android.gms.internal.ads.zzbgw;
import com.google.android.gms.internal.ads.zzbhg;
import com.google.android.gms.internal.ads.zzbis;
import com.google.android.gms.internal.ads.zzbkf;
import com.google.android.gms.internal.ads.zzbzy;
import com.google.android.gms.internal.ads.zzcab;
import com.google.android.gms.internal.ads.zzcce;

public abstract class zzbfm
extends zzadk
implements zzbfn {
    public zzbfm() {
        super("com.google.android.gms.ads.internal.client.IAdManager");
    }

    public static zzbfn zzac(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface iInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IAdManager");
        if (!(iInterface instanceof zzbfn)) return new zzbfl(iBinder);
        return (zzbfn)iInterface;
    }

    protected final boolean zzbz(int n, Parcel object, Parcel parcel, int n2) throws RemoteException {
        IInterface iInterface = null;
        zzbdg zzbdg2 = null;
        Object var12_7 = null;
        Object var10_8 = null;
        Object var13_9 = null;
        Object var9_10 = null;
        Object var11_11 = null;
        Object var8_12 = null;
        switch (n) {
            default: {
                return false;
            }
            case 45: {
                object = object.readStrongBinder();
                object = object == null ? var8_12 : ((iInterface = object.queryLocalInterface("com.google.android.gms.ads.internal.client.IFullScreenContentCallback")) instanceof zzbgb ? (zzbgb)iInterface : new zzbfz((IBinder)object));
                this.zzaa((zzbgb)object);
                parcel.writeNoException();
                break;
            }
            case 44: {
                this.zzZ(IObjectWrapper.Stub.asInterface((IBinder)object.readStrongBinder()));
                parcel.writeNoException();
                break;
            }
            case 43: {
                zzbdg2 = (zzbdg)zzadl.zzc((Parcel)object, (Parcelable.Creator)zzbdg.CREATOR);
                object = object.readStrongBinder();
                object = object == null ? iInterface : ((iInterface = object.queryLocalInterface("com.google.android.gms.ads.internal.client.IAdLoadCallback")) instanceof zzbfd ? (zzbfd)iInterface : new zzbfb((IBinder)object));
                this.zzY(zzbdg2, (zzbfd)object);
                parcel.writeNoException();
                break;
            }
            case 42: {
                object = object.readStrongBinder();
                object = object == null ? zzbdg2 : ((iInterface = object.queryLocalInterface("com.google.android.gms.ads.internal.client.IOnPaidEventListener")) instanceof zzbgw ? (zzbgw)iInterface : new zzbgu((IBinder)object));
                this.zzX((zzbgw)object);
                parcel.writeNoException();
                break;
            }
            case 41: {
                object = this.zzA();
                parcel.writeNoException();
                zzadl.zzf((Parcel)parcel, (IInterface)object);
                break;
            }
            case 40: {
                this.zzP(zzaxy.zze((IBinder)object.readStrongBinder()));
                parcel.writeNoException();
                break;
            }
            case 39: {
                this.zzO((zzbdr)zzadl.zzc((Parcel)object, (Parcelable.Creator)zzbdr.CREATOR));
                parcel.writeNoException();
                break;
            }
            case 38: {
                this.zzK(object.readString());
                parcel.writeNoException();
                break;
            }
            case 37: {
                object = this.zzr();
                parcel.writeNoException();
                zzadl.zze((Parcel)parcel, (Parcelable)object);
                break;
            }
            case 36: {
                object = object.readStrongBinder();
                object = object == null ? var12_7 : ((iInterface = object.queryLocalInterface("com.google.android.gms.ads.internal.client.IAdMetadataListener")) instanceof zzbfr ? (zzbfr)iInterface : new zzbfp((IBinder)object));
                this.zzq((zzbfr)object);
                parcel.writeNoException();
                break;
            }
            case 35: {
                object = this.zzz();
                parcel.writeNoException();
                parcel.writeString((String)object);
                break;
            }
            case 34: {
                this.zzQ(zzadl.zza((Parcel)object));
                parcel.writeNoException();
                break;
            }
            case 33: {
                object = this.zzD();
                parcel.writeNoException();
                zzadl.zzf((Parcel)parcel, (IInterface)object);
                break;
            }
            case 32: {
                object = this.zzC();
                parcel.writeNoException();
                zzadl.zzf((Parcel)parcel, (IInterface)object);
                break;
            }
            case 31: {
                object = this.zzB();
                parcel.writeNoException();
                parcel.writeString((String)object);
                break;
            }
            case 30: {
                this.zzN((zzbhg)zzadl.zzc((Parcel)object, (Parcelable.Creator)zzbhg.CREATOR));
                parcel.writeNoException();
                break;
            }
            case 29: {
                this.zzM((zzbis)zzadl.zzc((Parcel)object, (Parcelable.Creator)zzbis.CREATOR));
                parcel.writeNoException();
                break;
            }
            case 26: {
                object = this.zzL();
                parcel.writeNoException();
                zzadl.zzf((Parcel)parcel, (IInterface)object);
                break;
            }
            case 25: {
                this.zzJ(object.readString());
                parcel.writeNoException();
                break;
            }
            case 24: {
                this.zzI(zzcce.zzb((IBinder)object.readStrongBinder()));
                parcel.writeNoException();
                break;
            }
            case 23: {
                boolean bl = this.zzH();
                parcel.writeNoException();
                zzadl.zzb((Parcel)parcel, (boolean)bl);
                break;
            }
            case 22: {
                this.zzG(zzadl.zza((Parcel)object));
                parcel.writeNoException();
                break;
            }
            case 21: {
                object = object.readStrongBinder();
                object = object == null ? var10_8 : ((iInterface = object.queryLocalInterface("com.google.android.gms.ads.internal.client.ICorrelationIdProvider")) instanceof zzbfy ? (zzbfy)iInterface : new zzbfy((IBinder)object));
                this.zzab((zzbfy)object);
                parcel.writeNoException();
                break;
            }
            case 20: {
                object = object.readStrongBinder();
                object = object == null ? var13_9 : ((iInterface = object.queryLocalInterface("com.google.android.gms.ads.internal.client.IAdClickListener")) instanceof zzbex ? (zzbex)iInterface : new zzbev((IBinder)object));
                this.zzF((zzbex)object);
                parcel.writeNoException();
                break;
            }
            case 19: {
                this.zzE(zzbkf.zzb((IBinder)object.readStrongBinder()));
                parcel.writeNoException();
                break;
            }
            case 18: {
                object = this.zzy();
                parcel.writeNoException();
                parcel.writeString((String)object);
                break;
            }
            case 15: {
                this.zzx(zzcab.zzb((IBinder)object.readStrongBinder()), object.readString());
                parcel.writeNoException();
                break;
            }
            case 14: {
                this.zzw(zzbzy.zzb((IBinder)object.readStrongBinder()));
                parcel.writeNoException();
                break;
            }
            case 13: {
                this.zzv((zzbdl)zzadl.zzc((Parcel)object, (Parcelable.Creator)zzbdl.CREATOR));
                parcel.writeNoException();
                break;
            }
            case 12: {
                object = this.zzu();
                parcel.writeNoException();
                zzadl.zze((Parcel)parcel, (Parcelable)object);
                break;
            }
            case 11: {
                this.zzt();
                parcel.writeNoException();
                break;
            }
            case 10: {
                parcel.writeNoException();
                break;
            }
            case 9: {
                this.zzs();
                parcel.writeNoException();
                break;
            }
            case 8: {
                object = object.readStrongBinder();
                object = object == null ? var9_10 : ((iInterface = object.queryLocalInterface("com.google.android.gms.ads.internal.client.IAppEventListener")) instanceof zzbfu ? (zzbfu)iInterface : new zzbfs((IBinder)object));
                this.zzp((zzbfu)object);
                parcel.writeNoException();
                break;
            }
            case 7: {
                object = object.readStrongBinder();
                object = object == null ? var11_11 : ((iInterface = object.queryLocalInterface("com.google.android.gms.ads.internal.client.IAdListener")) instanceof zzbfa ? (zzbfa)iInterface : new zzbey((IBinder)object));
                this.zzo((zzbfa)object);
                parcel.writeNoException();
                break;
            }
            case 6: {
                this.zzn();
                parcel.writeNoException();
                break;
            }
            case 5: {
                this.zzm();
                parcel.writeNoException();
                break;
            }
            case 4: {
                boolean bl = this.zzl((zzbdg)zzadl.zzc((Parcel)object, (Parcelable.Creator)zzbdg.CREATOR));
                parcel.writeNoException();
                zzadl.zzb((Parcel)parcel, (boolean)bl);
                break;
            }
            case 3: {
                boolean bl = this.zzk();
                parcel.writeNoException();
                zzadl.zzb((Parcel)parcel, (boolean)bl);
                break;
            }
            case 2: {
                this.zzj();
                parcel.writeNoException();
                break;
            }
            case 1: {
                object = this.zzi();
                parcel.writeNoException();
                zzadl.zzf((Parcel)parcel, (IInterface)object);
            }
        }
        return true;
    }
}
