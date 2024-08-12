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
 *  com.google.android.gms.internal.ads.zzbfq
 *  com.google.android.gms.internal.ads.zzcca
 *  com.google.android.gms.internal.ads.zzccc
 *  com.google.android.gms.internal.ads.zzccd
 *  com.google.android.gms.internal.ads.zzccf
 *  com.google.android.gms.internal.ads.zzccg
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
import com.google.android.gms.internal.ads.zzbfq;
import com.google.android.gms.internal.ads.zzcca;
import com.google.android.gms.internal.ads.zzccc;
import com.google.android.gms.internal.ads.zzccd;
import com.google.android.gms.internal.ads.zzccf;
import com.google.android.gms.internal.ads.zzccg;

public abstract class zzccb
extends zzadk
implements zzccc {
    public zzccb() {
        super("com.google.android.gms.ads.internal.reward.client.IRewardedVideoAd");
    }

    protected final boolean zzbz(int n, Parcel object, Parcel parcel, int n2) throws RemoteException {
        if (n != 1) {
            if (n != 2) {
                IInterface iInterface = null;
                Object var7_6 = null;
                if (n != 3) {
                    if (n != 34) {
                        switch (n) {
                            default: {
                                return false;
                            }
                            case 21: {
                                object = this.zzt();
                                parcel.writeNoException();
                                zzadl.zzf((Parcel)parcel, (IInterface)object);
                                break;
                            }
                            case 20: {
                                boolean bl = this.zzs();
                                parcel.writeNoException();
                                zzadl.zzb((Parcel)parcel, (boolean)bl);
                                break;
                            }
                            case 19: {
                                this.zzq(object.readString());
                                parcel.writeNoException();
                                break;
                            }
                            case 18: {
                                this.zzp(IObjectWrapper.Stub.asInterface((IBinder)object.readStrongBinder()));
                                parcel.writeNoException();
                                break;
                            }
                            case 17: {
                                object.readString();
                                parcel.writeNoException();
                                break;
                            }
                            case 16: {
                                object = object.readStrongBinder();
                                object = object == null ? var7_6 : ((iInterface = object.queryLocalInterface("com.google.android.gms.ads.internal.reward.client.IRewardedAdSkuListener")) instanceof zzcca ? (zzcca)iInterface : new zzcca((IBinder)object));
                                this.zzu((zzcca)object);
                                parcel.writeNoException();
                                break;
                            }
                            case 15: {
                                object = this.zzo();
                                parcel.writeNoException();
                                zzadl.zze((Parcel)parcel, (Parcelable)object);
                                break;
                            }
                            case 14: {
                                this.zzn(zzbfq.zzb((IBinder)object.readStrongBinder()));
                                parcel.writeNoException();
                                break;
                            }
                            case 13: {
                                this.zzm(object.readString());
                                parcel.writeNoException();
                                break;
                            }
                            case 12: {
                                object = this.zzl();
                                parcel.writeNoException();
                                parcel.writeString((String)object);
                                break;
                            }
                            case 11: {
                                this.zzk(IObjectWrapper.Stub.asInterface((IBinder)object.readStrongBinder()));
                                parcel.writeNoException();
                                break;
                            }
                            case 10: {
                                this.zzj(IObjectWrapper.Stub.asInterface((IBinder)object.readStrongBinder()));
                                parcel.writeNoException();
                                break;
                            }
                            case 9: {
                                this.zzi(IObjectWrapper.Stub.asInterface((IBinder)object.readStrongBinder()));
                                parcel.writeNoException();
                                break;
                            }
                            case 8: {
                                this.zzh();
                                parcel.writeNoException();
                                break;
                            }
                            case 7: {
                                this.zzg();
                                parcel.writeNoException();
                                break;
                            }
                            case 6: {
                                this.zzf();
                                parcel.writeNoException();
                                break;
                            }
                            case 5: {
                                boolean bl = this.zze();
                                parcel.writeNoException();
                                zzadl.zzb((Parcel)parcel, (boolean)bl);
                                break;
                            }
                        }
                    } else {
                        this.zzr(zzadl.zza((Parcel)object));
                        parcel.writeNoException();
                    }
                } else {
                    object = (object = object.readStrongBinder()) == null ? iInterface : ((iInterface = object.queryLocalInterface("com.google.android.gms.ads.internal.reward.client.IRewardedVideoAdListener")) instanceof zzccf ? (zzccf)iInterface : new zzccd((IBinder)object));
                    this.zzd((zzccf)object);
                    parcel.writeNoException();
                }
            } else {
                this.zzc();
                parcel.writeNoException();
            }
        } else {
            this.zzb((zzccg)zzadl.zzc((Parcel)object, (Parcelable.Creator)zzccg.CREATOR));
            parcel.writeNoException();
        }
        return true;
    }
}
