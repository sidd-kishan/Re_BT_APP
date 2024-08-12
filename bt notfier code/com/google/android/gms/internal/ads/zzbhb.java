/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.IBinder
 *  android.os.IInterface
 *  android.os.Parcel
 *  android.os.RemoteException
 *  com.google.android.gms.internal.ads.zzadk
 *  com.google.android.gms.internal.ads.zzadl
 *  com.google.android.gms.internal.ads.zzbha
 *  com.google.android.gms.internal.ads.zzbhc
 *  com.google.android.gms.internal.ads.zzbhd
 *  com.google.android.gms.internal.ads.zzbhf
 */
package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.internal.ads.zzadk;
import com.google.android.gms.internal.ads.zzadl;
import com.google.android.gms.internal.ads.zzbha;
import com.google.android.gms.internal.ads.zzbhc;
import com.google.android.gms.internal.ads.zzbhd;
import com.google.android.gms.internal.ads.zzbhf;

public abstract class zzbhb
extends zzadk
implements zzbhc {
    public zzbhb() {
        super("com.google.android.gms.ads.internal.client.IVideoController");
    }

    public static zzbhc zzb(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface iInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IVideoController");
        if (!(iInterface instanceof zzbhc)) return new zzbha(iBinder);
        return (zzbhc)iInterface;
    }

    protected final boolean zzbz(int n, Parcel object, Parcel parcel, int n2) throws RemoteException {
        switch (n) {
            default: {
                return false;
            }
            case 13: {
                this.zzq();
                parcel.writeNoException();
                break;
            }
            case 12: {
                boolean bl = this.zzp();
                parcel.writeNoException();
                zzadl.zzb((Parcel)parcel, (boolean)bl);
                break;
            }
            case 11: {
                object = this.zzo();
                parcel.writeNoException();
                zzadl.zzf((Parcel)parcel, (IInterface)object);
                break;
            }
            case 10: {
                boolean bl = this.zzn();
                parcel.writeNoException();
                zzadl.zzb((Parcel)parcel, (boolean)bl);
                break;
            }
            case 9: {
                float f = this.zzm();
                parcel.writeNoException();
                parcel.writeFloat(f);
                break;
            }
            case 8: {
                IInterface iInterface;
                object = object.readStrongBinder();
                object = object == null ? null : ((iInterface = object.queryLocalInterface("com.google.android.gms.ads.internal.client.IVideoLifecycleCallbacks")) instanceof zzbhf ? (zzbhf)iInterface : new zzbhd((IBinder)object));
                this.zzl((zzbhf)object);
                parcel.writeNoException();
                break;
            }
            case 7: {
                float f = this.zzk();
                parcel.writeNoException();
                parcel.writeFloat(f);
                break;
            }
            case 6: {
                float f = this.zzj();
                parcel.writeNoException();
                parcel.writeFloat(f);
                break;
            }
            case 5: {
                n = this.zzi();
                parcel.writeNoException();
                parcel.writeInt(n);
                break;
            }
            case 4: {
                boolean bl = this.zzh();
                parcel.writeNoException();
                zzadl.zzb((Parcel)parcel, (boolean)bl);
                break;
            }
            case 3: {
                this.zzg(zzadl.zza((Parcel)object));
                parcel.writeNoException();
                break;
            }
            case 2: {
                this.zzf();
                parcel.writeNoException();
                break;
            }
            case 1: {
                this.zze();
                parcel.writeNoException();
            }
        }
        return true;
    }
}
