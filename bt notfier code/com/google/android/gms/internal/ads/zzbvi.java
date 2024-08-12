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
 *  com.google.android.gms.dynamic.IObjectWrapper
 *  com.google.android.gms.dynamic.IObjectWrapper$Stub
 *  com.google.android.gms.internal.ads.zzadk
 *  com.google.android.gms.internal.ads.zzadl
 *  com.google.android.gms.internal.ads.zzbdg
 *  com.google.android.gms.internal.ads.zzbdl
 *  com.google.android.gms.internal.ads.zzblv
 *  com.google.android.gms.internal.ads.zzbro
 *  com.google.android.gms.internal.ads.zzbrv
 *  com.google.android.gms.internal.ads.zzbvj
 *  com.google.android.gms.internal.ads.zzbvk
 *  com.google.android.gms.internal.ads.zzbvm
 *  com.google.android.gms.internal.ads.zzccj
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
import com.google.android.gms.internal.ads.zzbdl;
import com.google.android.gms.internal.ads.zzblv;
import com.google.android.gms.internal.ads.zzbro;
import com.google.android.gms.internal.ads.zzbrv;
import com.google.android.gms.internal.ads.zzbvj;
import com.google.android.gms.internal.ads.zzbvk;
import com.google.android.gms.internal.ads.zzbvm;
import com.google.android.gms.internal.ads.zzccj;

public abstract class zzbvi
extends zzadk
implements zzbvj {
    public zzbvi() {
        super("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
    }

    protected final boolean zzbz(int n, Parcel object, Parcel parcel, int n2) throws RemoteException {
        Object var12_5 = null;
        String string = null;
        Object object2 = null;
        Object object3 = null;
        Object object4 = null;
        Object var13_10 = null;
        IObjectWrapper iObjectWrapper = null;
        Object object5 = null;
        switch (n) {
            default: {
                return false;
            }
            case 37: {
                this.zzL(IObjectWrapper.Stub.asInterface((IBinder)object.readStrongBinder()));
                parcel.writeNoException();
                break;
            }
            case 36: {
                object = this.zzK();
                parcel.writeNoException();
                zzadl.zzf((Parcel)parcel, (IInterface)object);
                break;
            }
            case 35: {
                iObjectWrapper = IObjectWrapper.Stub.asInterface((IBinder)object.readStrongBinder());
                object2 = (zzbdl)zzadl.zzc((Parcel)object, (Parcelable.Creator)zzbdl.CREATOR);
                string = (zzbdg)zzadl.zzc((Parcel)object, (Parcelable.Creator)zzbdg.CREATOR);
                object3 = object.readString();
                object4 = object.readString();
                object = object.readStrongBinder();
                object = object == null ? object5 : ((object5 = object.queryLocalInterface("com.google.android.gms.ads.internal.mediation.client.IMediationAdapterListener")) instanceof zzbvm ? (zzbvm)object5 : new zzbvk((IBinder)object));
                this.zzJ(iObjectWrapper, (zzbdl)object2, (zzbdg)string, (String)object3, (String)object4, (zzbvm)object);
                parcel.writeNoException();
                break;
            }
            case 34: {
                object = this.zzI();
                parcel.writeNoException();
                zzadl.zze((Parcel)parcel, (Parcelable)object);
                break;
            }
            case 33: {
                object = this.zzH();
                parcel.writeNoException();
                zzadl.zze((Parcel)parcel, (Parcelable)object);
                break;
            }
            case 32: {
                object5 = IObjectWrapper.Stub.asInterface((IBinder)object.readStrongBinder());
                object2 = (zzbdg)zzadl.zzc((Parcel)object, (Parcelable.Creator)zzbdg.CREATOR);
                object4 = object.readString();
                object = object.readStrongBinder();
                object = object == null ? var12_5 : ((object3 = object.queryLocalInterface("com.google.android.gms.ads.internal.mediation.client.IMediationAdapterListener")) instanceof zzbvm ? (zzbvm)object3 : new zzbvk((IBinder)object));
                this.zzG((IObjectWrapper)object5, (zzbdg)object2, (String)object4, (zzbvm)object);
                parcel.writeNoException();
                break;
            }
            case 31: {
                this.zzF(IObjectWrapper.Stub.asInterface((IBinder)object.readStrongBinder()), zzbro.zzb((IBinder)object.readStrongBinder()), object.createTypedArrayList(zzbrv.CREATOR));
                parcel.writeNoException();
                break;
            }
            case 30: {
                this.zzE(IObjectWrapper.Stub.asInterface((IBinder)object.readStrongBinder()));
                parcel.writeNoException();
                break;
            }
            case 28: {
                object2 = IObjectWrapper.Stub.asInterface((IBinder)object.readStrongBinder());
                object5 = (zzbdg)zzadl.zzc((Parcel)object, (Parcelable.Creator)zzbdg.CREATOR);
                object4 = object.readString();
                object = object.readStrongBinder();
                object = object == null ? string : ((object3 = object.queryLocalInterface("com.google.android.gms.ads.internal.mediation.client.IMediationAdapterListener")) instanceof zzbvm ? (zzbvm)object3 : new zzbvk((IBinder)object));
                this.zzD((IObjectWrapper)object2, (zzbdg)object5, (String)object4, (zzbvm)object);
                parcel.writeNoException();
                break;
            }
            case 27: {
                object = this.zzC();
                parcel.writeNoException();
                zzadl.zzf((Parcel)parcel, (IInterface)object);
                break;
            }
            case 26: {
                object = this.zzB();
                parcel.writeNoException();
                zzadl.zzf((Parcel)parcel, (IInterface)object);
                break;
            }
            case 25: {
                this.zzA(zzadl.zza((Parcel)object));
                parcel.writeNoException();
                break;
            }
            case 24: {
                object = this.zzz();
                parcel.writeNoException();
                zzadl.zzf((Parcel)parcel, (IInterface)object);
                break;
            }
            case 23: {
                this.zzy(IObjectWrapper.Stub.asInterface((IBinder)object.readStrongBinder()), zzccj.zzb((IBinder)object.readStrongBinder()), object.createStringArrayList());
                parcel.writeNoException();
                break;
            }
            case 22: {
                parcel.writeNoException();
                zzadl.zzb((Parcel)parcel, (boolean)false);
                break;
            }
            case 21: {
                this.zzw(IObjectWrapper.Stub.asInterface((IBinder)object.readStrongBinder()));
                parcel.writeNoException();
                break;
            }
            case 20: {
                this.zzv((zzbdg)zzadl.zzc((Parcel)object, (Parcelable.Creator)zzbdg.CREATOR), object.readString(), object.readString());
                parcel.writeNoException();
                break;
            }
            case 19: {
                object = this.zzu();
                parcel.writeNoException();
                zzadl.zze((Parcel)parcel, (Parcelable)object);
                break;
            }
            case 18: {
                object = this.zzt();
                parcel.writeNoException();
                zzadl.zze((Parcel)parcel, (Parcelable)object);
                break;
            }
            case 17: {
                object = this.zzs();
                parcel.writeNoException();
                zzadl.zze((Parcel)parcel, (Parcelable)object);
                break;
            }
            case 16: {
                parcel.writeNoException();
                zzadl.zzf((Parcel)parcel, null);
                break;
            }
            case 15: {
                parcel.writeNoException();
                zzadl.zzf((Parcel)parcel, null);
                break;
            }
            case 14: {
                object5 = IObjectWrapper.Stub.asInterface((IBinder)object.readStrongBinder());
                iObjectWrapper = (zzbdg)zzadl.zzc((Parcel)object, (Parcelable.Creator)zzbdg.CREATOR);
                string = object.readString();
                object3 = object.readString();
                object4 = object.readStrongBinder();
                object4 = object4 == null ? object2 : ((object2 = object4.queryLocalInterface("com.google.android.gms.ads.internal.mediation.client.IMediationAdapterListener")) instanceof zzbvm ? (zzbvm)object2 : new zzbvk((IBinder)object4));
                this.zzr((IObjectWrapper)object5, (zzbdg)iObjectWrapper, string, (String)object3, (zzbvm)object4, (zzblv)zzadl.zzc((Parcel)object, (Parcelable.Creator)zzblv.CREATOR), object.createStringArrayList());
                parcel.writeNoException();
                break;
            }
            case 13: {
                boolean bl = this.zzq();
                parcel.writeNoException();
                zzadl.zzb((Parcel)parcel, (boolean)bl);
                break;
            }
            case 12: {
                this.zzp();
                parcel.writeNoException();
                break;
            }
            case 11: {
                this.zzo((zzbdg)zzadl.zzc((Parcel)object, (Parcelable.Creator)zzbdg.CREATOR), object.readString());
                parcel.writeNoException();
                break;
            }
            case 10: {
                this.zzn(IObjectWrapper.Stub.asInterface((IBinder)object.readStrongBinder()), (zzbdg)zzadl.zzc((Parcel)object, (Parcelable.Creator)zzbdg.CREATOR), object.readString(), zzccj.zzb((IBinder)object.readStrongBinder()), object.readString());
                parcel.writeNoException();
                break;
            }
            case 9: {
                this.zzm();
                parcel.writeNoException();
                break;
            }
            case 8: {
                this.zzl();
                parcel.writeNoException();
                break;
            }
            case 7: {
                iObjectWrapper = IObjectWrapper.Stub.asInterface((IBinder)object.readStrongBinder());
                object2 = (zzbdg)zzadl.zzc((Parcel)object, (Parcelable.Creator)zzbdg.CREATOR);
                object5 = object.readString();
                object4 = object.readString();
                object = object.readStrongBinder();
                object = object == null ? object3 : ((object3 = object.queryLocalInterface("com.google.android.gms.ads.internal.mediation.client.IMediationAdapterListener")) instanceof zzbvm ? (zzbvm)object3 : new zzbvk((IBinder)object));
                this.zzk(iObjectWrapper, (zzbdg)object2, (String)object5, (String)object4, (zzbvm)object);
                parcel.writeNoException();
                break;
            }
            case 6: {
                object3 = IObjectWrapper.Stub.asInterface((IBinder)object.readStrongBinder());
                iObjectWrapper = (zzbdl)zzadl.zzc((Parcel)object, (Parcelable.Creator)zzbdl.CREATOR);
                object5 = (zzbdg)zzadl.zzc((Parcel)object, (Parcelable.Creator)zzbdg.CREATOR);
                string = object.readString();
                object2 = object.readString();
                object = object.readStrongBinder();
                object = object == null ? object4 : ((object4 = object.queryLocalInterface("com.google.android.gms.ads.internal.mediation.client.IMediationAdapterListener")) instanceof zzbvm ? (zzbvm)object4 : new zzbvk((IBinder)object));
                this.zzj((IObjectWrapper)object3, (zzbdl)iObjectWrapper, (zzbdg)object5, string, (String)object2, (zzbvm)object);
                parcel.writeNoException();
                break;
            }
            case 5: {
                this.zzi();
                parcel.writeNoException();
                break;
            }
            case 4: {
                this.zzh();
                parcel.writeNoException();
                break;
            }
            case 3: {
                object2 = IObjectWrapper.Stub.asInterface((IBinder)object.readStrongBinder());
                object5 = (zzbdg)zzadl.zzc((Parcel)object, (Parcelable.Creator)zzbdg.CREATOR);
                object4 = object.readString();
                object = object.readStrongBinder();
                object = object == null ? var13_10 : ((object3 = object.queryLocalInterface("com.google.android.gms.ads.internal.mediation.client.IMediationAdapterListener")) instanceof zzbvm ? (zzbvm)object3 : new zzbvk((IBinder)object));
                this.zzg((IObjectWrapper)object2, (zzbdg)object5, (String)object4, (zzbvm)object);
                parcel.writeNoException();
                break;
            }
            case 2: {
                object = this.zzf();
                parcel.writeNoException();
                zzadl.zzf((Parcel)parcel, (IInterface)object);
                break;
            }
            case 1: {
                object4 = IObjectWrapper.Stub.asInterface((IBinder)object.readStrongBinder());
                object2 = (zzbdl)zzadl.zzc((Parcel)object, (Parcelable.Creator)zzbdl.CREATOR);
                object3 = (zzbdg)zzadl.zzc((Parcel)object, (Parcelable.Creator)zzbdg.CREATOR);
                object5 = object.readString();
                object = object.readStrongBinder();
                object = object == null ? iObjectWrapper : ((iObjectWrapper = object.queryLocalInterface("com.google.android.gms.ads.internal.mediation.client.IMediationAdapterListener")) instanceof zzbvm ? (zzbvm)iObjectWrapper : new zzbvk((IBinder)object));
                this.zze((IObjectWrapper)object4, (zzbdl)object2, (zzbdg)object3, (String)object5, (zzbvm)object);
                parcel.writeNoException();
            }
        }
        return true;
    }
}
