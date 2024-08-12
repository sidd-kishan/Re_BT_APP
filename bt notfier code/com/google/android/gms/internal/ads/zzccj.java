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
 *  com.google.android.gms.dynamic.IObjectWrapper$Stub
 *  com.google.android.gms.internal.ads.zzadk
 *  com.google.android.gms.internal.ads.zzadl
 *  com.google.android.gms.internal.ads.zzcci
 *  com.google.android.gms.internal.ads.zzcck
 *  com.google.android.gms.internal.ads.zzccl
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
import com.google.android.gms.internal.ads.zzcci;
import com.google.android.gms.internal.ads.zzcck;
import com.google.android.gms.internal.ads.zzccl;

public abstract class zzccj
extends zzadk
implements zzcck {
    public zzccj() {
        super("com.google.android.gms.ads.internal.reward.mediation.client.IMediationRewardedVideoAdListener");
    }

    public static zzcck zzb(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface iInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.reward.mediation.client.IMediationRewardedVideoAdListener");
        if (!(iInterface instanceof zzcck)) return new zzcci(iBinder);
        return (zzcck)iInterface;
    }

    protected final boolean zzbz(int n, Parcel parcel, Parcel parcel2, int n2) throws RemoteException {
        switch (n) {
            default: {
                return false;
            }
            case 12: {
                parcel = (Bundle)zzadl.zzc((Parcel)parcel, (Parcelable.Creator)Bundle.CREATOR);
                break;
            }
            case 11: {
                this.zzo(IObjectWrapper.Stub.asInterface((IBinder)parcel.readStrongBinder()));
                break;
            }
            case 10: {
                this.zzn(IObjectWrapper.Stub.asInterface((IBinder)parcel.readStrongBinder()));
                break;
            }
            case 9: {
                this.zzm(IObjectWrapper.Stub.asInterface((IBinder)parcel.readStrongBinder()), parcel.readInt());
                break;
            }
            case 8: {
                this.zzl(IObjectWrapper.Stub.asInterface((IBinder)parcel.readStrongBinder()));
                break;
            }
            case 7: {
                this.zzk(IObjectWrapper.Stub.asInterface((IBinder)parcel.readStrongBinder()), (zzccl)zzadl.zzc((Parcel)parcel, (Parcelable.Creator)zzccl.CREATOR));
                break;
            }
            case 6: {
                this.zzj(IObjectWrapper.Stub.asInterface((IBinder)parcel.readStrongBinder()));
                break;
            }
            case 5: {
                this.zzi(IObjectWrapper.Stub.asInterface((IBinder)parcel.readStrongBinder()));
                break;
            }
            case 4: {
                this.zzh(IObjectWrapper.Stub.asInterface((IBinder)parcel.readStrongBinder()));
                break;
            }
            case 3: {
                this.zzg(IObjectWrapper.Stub.asInterface((IBinder)parcel.readStrongBinder()));
                break;
            }
            case 2: {
                this.zzf(IObjectWrapper.Stub.asInterface((IBinder)parcel.readStrongBinder()), parcel.readInt());
                break;
            }
            case 1: {
                this.zze(IObjectWrapper.Stub.asInterface((IBinder)parcel.readStrongBinder()));
            }
        }
        parcel2.writeNoException();
        return true;
    }
}
