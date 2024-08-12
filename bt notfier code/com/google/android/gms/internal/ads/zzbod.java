/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Bundle
 *  android.os.IBinder
 *  android.os.IInterface
 *  android.os.Parcel
 *  android.os.Parcelable
 *  android.os.Parcelable$Creator
 *  android.os.RemoteException
 *  com.google.android.gms.internal.ads.zzadk
 *  com.google.android.gms.internal.ads.zzadl
 *  com.google.android.gms.internal.ads.zzbgh
 *  com.google.android.gms.internal.ads.zzbgl
 *  com.google.android.gms.internal.ads.zzbgv
 *  com.google.android.gms.internal.ads.zzbnz
 *  com.google.android.gms.internal.ads.zzbob
 *  com.google.android.gms.internal.ads.zzboe
 */
package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import com.google.android.gms.internal.ads.zzadk;
import com.google.android.gms.internal.ads.zzadl;
import com.google.android.gms.internal.ads.zzbgh;
import com.google.android.gms.internal.ads.zzbgl;
import com.google.android.gms.internal.ads.zzbgv;
import com.google.android.gms.internal.ads.zzbnz;
import com.google.android.gms.internal.ads.zzbob;
import com.google.android.gms.internal.ads.zzboe;
import java.util.List;

public abstract class zzbod
extends zzadk
implements zzboe {
    public zzbod() {
        super("com.google.android.gms.ads.internal.formats.client.IUnifiedNativeAd");
    }

    protected final boolean zzbz(int n, Parcel object, Parcel parcel, int n2) throws RemoteException {
        switch (n) {
            default: {
                return false;
            }
            case 32: {
                this.zzI(zzbgv.zzb((IBinder)object.readStrongBinder()));
                parcel.writeNoException();
                break;
            }
            case 31: {
                object = this.zzH();
                parcel.writeNoException();
                zzadl.zzf((Parcel)parcel, (IInterface)object);
                break;
            }
            case 30: {
                boolean bl = this.zzG();
                parcel.writeNoException();
                zzadl.zzb((Parcel)parcel, (boolean)bl);
                break;
            }
            case 29: {
                object = this.zzF();
                parcel.writeNoException();
                zzadl.zzf((Parcel)parcel, (IInterface)object);
                break;
            }
            case 28: {
                this.zzE();
                parcel.writeNoException();
                break;
            }
            case 27: {
                this.zzD();
                parcel.writeNoException();
                break;
            }
            case 26: {
                this.zzC(zzbgh.zzb((IBinder)object.readStrongBinder()));
                parcel.writeNoException();
                break;
            }
            case 25: {
                this.zzB(zzbgl.zzb((IBinder)object.readStrongBinder()));
                parcel.writeNoException();
                break;
            }
            case 24: {
                boolean bl = this.zzA();
                parcel.writeNoException();
                zzadl.zzb((Parcel)parcel, (boolean)bl);
                break;
            }
            case 23: {
                object = this.zzz();
                parcel.writeNoException();
                parcel.writeList((List)object);
                break;
            }
            case 22: {
                this.zzy();
                parcel.writeNoException();
                break;
            }
            case 21: {
                IInterface iInterface;
                object = object.readStrongBinder();
                object = object == null ? null : ((iInterface = object.queryLocalInterface("com.google.android.gms.ads.internal.formats.client.IUnconfirmedClickListener")) instanceof zzbob ? (zzbob)iInterface : new zzbnz((IBinder)object));
                this.zzx((zzbob)object);
                parcel.writeNoException();
                break;
            }
            case 20: {
                object = this.zzw();
                parcel.writeNoException();
                zzadl.zze((Parcel)parcel, (Parcelable)object);
                break;
            }
            case 19: {
                object = this.zzv();
                parcel.writeNoException();
                zzadl.zzf((Parcel)parcel, (IInterface)object);
                break;
            }
            case 18: {
                object = this.zzu();
                parcel.writeNoException();
                zzadl.zzf((Parcel)parcel, (IInterface)object);
                break;
            }
            case 17: {
                this.zzt((Bundle)zzadl.zzc((Parcel)object, (Parcelable.Creator)Bundle.CREATOR));
                parcel.writeNoException();
                break;
            }
            case 16: {
                boolean bl = this.zzs((Bundle)zzadl.zzc((Parcel)object, (Parcelable.Creator)Bundle.CREATOR));
                parcel.writeNoException();
                zzadl.zzb((Parcel)parcel, (boolean)bl);
                break;
            }
            case 15: {
                this.zzr((Bundle)zzadl.zzc((Parcel)object, (Parcelable.Creator)Bundle.CREATOR));
                parcel.writeNoException();
                break;
            }
            case 14: {
                object = this.zzq();
                parcel.writeNoException();
                zzadl.zzf((Parcel)parcel, (IInterface)object);
                break;
            }
            case 13: {
                this.zzp();
                parcel.writeNoException();
                break;
            }
            case 12: {
                object = this.zzo();
                parcel.writeNoException();
                parcel.writeString((String)object);
                break;
            }
            case 11: {
                object = this.zzn();
                parcel.writeNoException();
                zzadl.zzf((Parcel)parcel, (IInterface)object);
                break;
            }
            case 10: {
                object = this.zzm();
                parcel.writeNoException();
                parcel.writeString((String)object);
                break;
            }
            case 9: {
                object = this.zzl();
                parcel.writeNoException();
                parcel.writeString((String)object);
                break;
            }
            case 8: {
                double d = this.zzk();
                parcel.writeNoException();
                parcel.writeDouble(d);
                break;
            }
            case 7: {
                object = this.zzj();
                parcel.writeNoException();
                parcel.writeString((String)object);
                break;
            }
            case 6: {
                object = this.zzi();
                parcel.writeNoException();
                parcel.writeString((String)object);
                break;
            }
            case 5: {
                object = this.zzh();
                parcel.writeNoException();
                zzadl.zzf((Parcel)parcel, (IInterface)object);
                break;
            }
            case 4: {
                object = this.zzg();
                parcel.writeNoException();
                parcel.writeString((String)object);
                break;
            }
            case 3: {
                object = this.zzf();
                parcel.writeNoException();
                parcel.writeList((List)object);
                break;
            }
            case 2: {
                object = this.zze();
                parcel.writeNoException();
                parcel.writeString((String)object);
            }
        }
        return true;
    }
}
