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
 *  com.google.android.gms.dynamic.IObjectWrapper
 *  com.google.android.gms.dynamic.IObjectWrapper$Stub
 *  com.google.android.gms.internal.ads.zzadk
 *  com.google.android.gms.internal.ads.zzadl
 *  com.google.android.gms.internal.ads.zzbdg
 *  com.google.android.gms.internal.ads.zzbdl
 *  com.google.android.gms.internal.ads.zzblv
 *  com.google.android.gms.internal.ads.zzbvl
 *  com.google.android.gms.internal.ads.zzbwz
 *  com.google.android.gms.internal.ads.zzbxb
 *  com.google.android.gms.internal.ads.zzbxc
 *  com.google.android.gms.internal.ads.zzbxe
 *  com.google.android.gms.internal.ads.zzbxf
 *  com.google.android.gms.internal.ads.zzbxh
 *  com.google.android.gms.internal.ads.zzbxi
 *  com.google.android.gms.internal.ads.zzbxk
 *  com.google.android.gms.internal.ads.zzbxl
 *  com.google.android.gms.internal.ads.zzbxn
 *  com.google.android.gms.internal.ads.zzbxo
 *  com.google.android.gms.internal.ads.zzbxq
 */
package com.google.android.gms.internal.ads;

import android.os.Bundle;
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
import com.google.android.gms.internal.ads.zzbvl;
import com.google.android.gms.internal.ads.zzbwz;
import com.google.android.gms.internal.ads.zzbxb;
import com.google.android.gms.internal.ads.zzbxc;
import com.google.android.gms.internal.ads.zzbxe;
import com.google.android.gms.internal.ads.zzbxf;
import com.google.android.gms.internal.ads.zzbxh;
import com.google.android.gms.internal.ads.zzbxi;
import com.google.android.gms.internal.ads.zzbxk;
import com.google.android.gms.internal.ads.zzbxl;
import com.google.android.gms.internal.ads.zzbxn;
import com.google.android.gms.internal.ads.zzbxo;
import com.google.android.gms.internal.ads.zzbxq;

public abstract class zzbxm
extends zzadk
implements zzbxn {
    public zzbxm() {
        super("com.google.android.gms.ads.internal.mediation.client.rtb.IRtbAdapter");
    }

    public static zzbxn zzb(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface iInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.mediation.client.rtb.IRtbAdapter");
        if (!(iInterface instanceof zzbxn)) return new zzbxl(iBinder);
        return (zzbxn)iInterface;
    }

    protected final boolean zzbz(int n, Parcel object, Parcel parcel, int n2) throws RemoteException {
        Object object2 = null;
        Object object3 = null;
        String string = null;
        String string2 = null;
        Object object4 = null;
        Object object5 = null;
        Object var12_11 = null;
        if (n != 1) {
            if (n != 2) {
                if (n != 3) {
                    if (n != 5) {
                        if (n != 10) {
                            if (n != 11) {
                                switch (n) {
                                    default: {
                                        return false;
                                    }
                                    case 22: {
                                        string = object.readString();
                                        object3 = object.readString();
                                        object5 = (zzbdg)zzadl.zzc((Parcel)object, (Parcelable.Creator)zzbdg.CREATOR);
                                        object4 = IObjectWrapper.Stub.asInterface((IBinder)object.readStrongBinder());
                                        object2 = object.readStrongBinder();
                                        object2 = object2 == null ? var12_11 : ((string2 = object2.queryLocalInterface("com.google.android.gms.ads.internal.mediation.client.rtb.INativeCallback")) instanceof zzbxh ? (zzbxh)string2 : new zzbxf((IBinder)object2));
                                        this.zzr(string, (String)object3, (zzbdg)object5, (IObjectWrapper)object4, (zzbxh)object2, zzbvl.zzb((IBinder)object.readStrongBinder()), (zzblv)zzadl.zzc((Parcel)object, (Parcelable.Creator)zzblv.CREATOR));
                                        parcel.writeNoException();
                                        break;
                                    }
                                    case 21: {
                                        object5 = object.readString();
                                        object4 = object.readString();
                                        string = (zzbdg)zzadl.zzc((Parcel)object, (Parcelable.Creator)zzbdg.CREATOR);
                                        object3 = IObjectWrapper.Stub.asInterface((IBinder)object.readStrongBinder());
                                        string2 = object.readStrongBinder();
                                        if (string2 != null) {
                                            object2 = string2.queryLocalInterface("com.google.android.gms.ads.internal.mediation.client.rtb.IBannerCallback");
                                            object2 = object2 instanceof zzbxb ? (zzbxb)object2 : new zzbwz((IBinder)string2);
                                        }
                                        this.zzq((String)object5, (String)object4, (zzbdg)string, (IObjectWrapper)object3, (zzbxb)object2, zzbvl.zzb((IBinder)object.readStrongBinder()), (zzbdl)zzadl.zzc((Parcel)object, (Parcelable.Creator)zzbdl.CREATOR));
                                        parcel.writeNoException();
                                        break;
                                    }
                                    case 20: {
                                        object4 = object.readString();
                                        object5 = object.readString();
                                        string2 = (zzbdg)zzadl.zzc((Parcel)object, (Parcelable.Creator)zzbdg.CREATOR);
                                        string = IObjectWrapper.Stub.asInterface((IBinder)object.readStrongBinder());
                                        object2 = object.readStrongBinder();
                                        object2 = object2 == null ? object3 : ((object3 = object2.queryLocalInterface("com.google.android.gms.ads.internal.mediation.client.rtb.IRewardedCallback")) instanceof zzbxk ? (zzbxk)object3 : new zzbxi((IBinder)object2));
                                        this.zzp((String)object4, (String)object5, (zzbdg)string2, (IObjectWrapper)string, (zzbxk)object2, zzbvl.zzb((IBinder)object.readStrongBinder()));
                                        parcel.writeNoException();
                                        break;
                                    }
                                    case 19: {
                                        this.zzo(object.readString());
                                        parcel.writeNoException();
                                        break;
                                    }
                                    case 18: {
                                        object3 = object.readString();
                                        object5 = object.readString();
                                        string2 = (zzbdg)zzadl.zzc((Parcel)object, (Parcelable.Creator)zzbdg.CREATOR);
                                        object4 = IObjectWrapper.Stub.asInterface((IBinder)object.readStrongBinder());
                                        object2 = object.readStrongBinder();
                                        object2 = object2 == null ? string : ((string = object2.queryLocalInterface("com.google.android.gms.ads.internal.mediation.client.rtb.INativeCallback")) instanceof zzbxh ? (zzbxh)string : new zzbxf((IBinder)object2));
                                        this.zzn((String)object3, (String)object5, (zzbdg)string2, (IObjectWrapper)object4, (zzbxh)object2, zzbvl.zzb((IBinder)object.readStrongBinder()));
                                        parcel.writeNoException();
                                        break;
                                    }
                                    case 17: {
                                        boolean bl = this.zzm(IObjectWrapper.Stub.asInterface((IBinder)object.readStrongBinder()));
                                        parcel.writeNoException();
                                        zzadl.zzb((Parcel)parcel, (boolean)bl);
                                        break;
                                    }
                                    case 16: {
                                        object4 = object.readString();
                                        string = object.readString();
                                        object3 = (zzbdg)zzadl.zzc((Parcel)object, (Parcelable.Creator)zzbdg.CREATOR);
                                        object5 = IObjectWrapper.Stub.asInterface((IBinder)object.readStrongBinder());
                                        object2 = object.readStrongBinder();
                                        object2 = object2 == null ? string2 : ((string2 = object2.queryLocalInterface("com.google.android.gms.ads.internal.mediation.client.rtb.IRewardedCallback")) instanceof zzbxk ? (zzbxk)string2 : new zzbxi((IBinder)object2));
                                        this.zzl((String)object4, string, (zzbdg)object3, (IObjectWrapper)object5, (zzbxk)object2, zzbvl.zzb((IBinder)object.readStrongBinder()));
                                        parcel.writeNoException();
                                        break;
                                    }
                                    case 15: {
                                        boolean bl = this.zzk(IObjectWrapper.Stub.asInterface((IBinder)object.readStrongBinder()));
                                        parcel.writeNoException();
                                        zzadl.zzb((Parcel)parcel, (boolean)bl);
                                        break;
                                    }
                                    case 14: {
                                        string = object.readString();
                                        object5 = object.readString();
                                        object3 = (zzbdg)zzadl.zzc((Parcel)object, (Parcelable.Creator)zzbdg.CREATOR);
                                        string2 = IObjectWrapper.Stub.asInterface((IBinder)object.readStrongBinder());
                                        object2 = object.readStrongBinder();
                                        object2 = object2 == null ? object4 : ((object4 = object2.queryLocalInterface("com.google.android.gms.ads.internal.mediation.client.rtb.IInterstitialCallback")) instanceof zzbxe ? (zzbxe)object4 : new zzbxc((IBinder)object2));
                                        this.zzj(string, (String)object5, (zzbdg)object3, (IObjectWrapper)string2, (zzbxe)object2, zzbvl.zzb((IBinder)object.readStrongBinder()));
                                        parcel.writeNoException();
                                        break;
                                    }
                                    case 13: {
                                        string2 = object.readString();
                                        object4 = object.readString();
                                        string = (zzbdg)zzadl.zzc((Parcel)object, (Parcelable.Creator)zzbdg.CREATOR);
                                        object3 = IObjectWrapper.Stub.asInterface((IBinder)object.readStrongBinder());
                                        object2 = object.readStrongBinder();
                                        object2 = object2 == null ? object5 : ((object5 = object2.queryLocalInterface("com.google.android.gms.ads.internal.mediation.client.rtb.IBannerCallback")) instanceof zzbxb ? (zzbxb)object5 : new zzbwz((IBinder)object2));
                                        this.zzi(string2, (String)object4, (zzbdg)string, (IObjectWrapper)object3, (zzbxb)object2, zzbvl.zzb((IBinder)object.readStrongBinder()), (zzbdl)zzadl.zzc((Parcel)object, (Parcelable.Creator)zzbdl.CREATOR));
                                        parcel.writeNoException();
                                        break;
                                    }
                                }
                            } else {
                                object.createStringArray();
                                object = (IInterface)object.createTypedArray(Bundle.CREATOR);
                                parcel.writeNoException();
                            }
                        } else {
                            IObjectWrapper.Stub.asInterface((IBinder)object.readStrongBinder());
                            parcel.writeNoException();
                        }
                    } else {
                        object = this.zzh();
                        parcel.writeNoException();
                        zzadl.zzf((Parcel)parcel, (IInterface)object);
                    }
                } else {
                    object = this.zzg();
                    parcel.writeNoException();
                    zzadl.zze((Parcel)parcel, (Parcelable)object);
                }
            } else {
                object = this.zzf();
                parcel.writeNoException();
                zzadl.zze((Parcel)parcel, (Parcelable)object);
            }
        } else {
            object5 = IObjectWrapper.Stub.asInterface((IBinder)object.readStrongBinder());
            object2 = object.readString();
            object4 = (Bundle)zzadl.zzc((Parcel)object, (Parcelable.Creator)Bundle.CREATOR);
            object3 = (Bundle)zzadl.zzc((Parcel)object, (Parcelable.Creator)Bundle.CREATOR);
            string = (zzbdl)zzadl.zzc((Parcel)object, (Parcelable.Creator)zzbdl.CREATOR);
            string2 = object.readStrongBinder();
            object = string2 == null ? null : ((object = string2.queryLocalInterface("com.google.android.gms.ads.internal.mediation.client.rtb.ISignalsCallback")) instanceof zzbxq ? (zzbxq)object : new zzbxo((IBinder)string2));
            this.zze((IObjectWrapper)object5, (String)object2, (Bundle)object4, (Bundle)object3, (zzbdl)string, (zzbxq)object);
            parcel.writeNoException();
        }
        return true;
    }
}
