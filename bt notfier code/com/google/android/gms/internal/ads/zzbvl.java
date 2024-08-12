/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Bundle
 *  android.os.IBinder
 *  android.os.IInterface
 *  android.os.Parcel
 *  android.os.Parcelable$Creator
 *  android.os.RemoteException
 *  com.google.android.gms.internal.ads.zzadk
 *  com.google.android.gms.internal.ads.zzadl
 *  com.google.android.gms.internal.ads.zzbcz
 *  com.google.android.gms.internal.ads.zzbna
 *  com.google.android.gms.internal.ads.zzbvk
 *  com.google.android.gms.internal.ads.zzbvm
 *  com.google.android.gms.internal.ads.zzbvq
 *  com.google.android.gms.internal.ads.zzccl
 *  com.google.android.gms.internal.ads.zzcco
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
import com.google.android.gms.internal.ads.zzbcz;
import com.google.android.gms.internal.ads.zzbna;
import com.google.android.gms.internal.ads.zzbvk;
import com.google.android.gms.internal.ads.zzbvm;
import com.google.android.gms.internal.ads.zzbvq;
import com.google.android.gms.internal.ads.zzccl;
import com.google.android.gms.internal.ads.zzcco;

public abstract class zzbvl
extends zzadk
implements zzbvm {
    public zzbvl() {
        super("com.google.android.gms.ads.internal.mediation.client.IMediationAdapterListener");
    }

    public static zzbvm zzb(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface iInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.mediation.client.IMediationAdapterListener");
        if (!(iInterface instanceof zzbvm)) return new zzbvk(iBinder);
        return (zzbvm)iInterface;
    }

    protected final boolean zzbz(int n, Parcel parcel, Parcel parcel2, int n2) throws RemoteException {
        switch (n) {
            default: {
                return false;
            }
            case 24: {
                this.zzy((zzbcz)zzadl.zzc((Parcel)parcel, (Parcelable.Creator)zzbcz.CREATOR));
                break;
            }
            case 23: {
                this.zzx((zzbcz)zzadl.zzc((Parcel)parcel, (Parcelable.Creator)zzbcz.CREATOR));
                break;
            }
            case 22: {
                this.zzw(parcel.readInt(), parcel.readString());
                break;
            }
            case 21: {
                this.zzv(parcel.readString());
                break;
            }
            case 20: {
                this.zzu();
                break;
            }
            case 19: {
                parcel = (Bundle)zzadl.zzc((Parcel)parcel, (Parcelable.Creator)Bundle.CREATOR);
                break;
            }
            case 18: {
                this.zzt();
                break;
            }
            case 17: {
                this.zzs(parcel.readInt());
                break;
            }
            case 16: {
                this.zzr(zzcco.zzb((IBinder)parcel.readStrongBinder()));
                break;
            }
            case 15: {
                this.zzq();
                break;
            }
            case 14: {
                this.zzp((zzccl)zzadl.zzc((Parcel)parcel, (Parcelable.Creator)zzccl.CREATOR));
                break;
            }
            case 13: {
                this.zzo();
                break;
            }
            case 12: {
                parcel.readString();
                break;
            }
            case 11: {
                this.zzn();
                break;
            }
            case 10: {
                zzbna.zzb((IBinder)parcel.readStrongBinder());
                parcel.readString();
                break;
            }
            case 9: {
                this.zzl(parcel.readString(), parcel.readString());
                break;
            }
            case 8: {
                this.zzk();
                break;
            }
            case 7: {
                IBinder iBinder = parcel.readStrongBinder();
                if (iBinder == null) break;
                parcel = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.mediation.client.IMediationResponseMetadata");
                if (parcel instanceof zzbvq) {
                    parcel = (zzbvq)parcel;
                    break;
                }
                new zzbvq(iBinder);
                break;
            }
            case 6: {
                this.zzj();
                break;
            }
            case 5: {
                this.zzi();
                break;
            }
            case 4: {
                this.zzh();
                break;
            }
            case 3: {
                this.zzg(parcel.readInt());
                break;
            }
            case 2: {
                this.zzf();
                break;
            }
            case 1: {
                this.zze();
            }
        }
        parcel2.writeNoException();
        return true;
    }
}
