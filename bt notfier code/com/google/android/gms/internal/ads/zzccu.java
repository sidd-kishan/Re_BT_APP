/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.IBinder
 *  android.os.IInterface
 *  android.os.Parcel
 *  android.os.Parcelable$Creator
 *  android.os.RemoteException
 *  com.google.android.gms.internal.ads.zzadk
 *  com.google.android.gms.internal.ads.zzadl
 *  com.google.android.gms.internal.ads.zzbcz
 *  com.google.android.gms.internal.ads.zzccn
 *  com.google.android.gms.internal.ads.zzccp
 *  com.google.android.gms.internal.ads.zzccv
 */
package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import com.google.android.gms.internal.ads.zzadk;
import com.google.android.gms.internal.ads.zzadl;
import com.google.android.gms.internal.ads.zzbcz;
import com.google.android.gms.internal.ads.zzccn;
import com.google.android.gms.internal.ads.zzccp;
import com.google.android.gms.internal.ads.zzccv;

public abstract class zzccu
extends zzadk
implements zzccv {
    public zzccu() {
        super("com.google.android.gms.ads.internal.rewarded.client.IRewardedAdCallback");
    }

    protected final boolean zzbz(int n, Parcel object, Parcel parcel, int n2) throws RemoteException {
        switch (n) {
            default: {
                return false;
            }
            case 7: {
                this.zzk();
                break;
            }
            case 6: {
                this.zzj();
                break;
            }
            case 5: {
                this.zzi((zzbcz)zzadl.zzc((Parcel)object, (Parcelable.Creator)zzbcz.CREATOR));
                break;
            }
            case 4: {
                this.zzh(object.readInt());
                break;
            }
            case 3: {
                IInterface iInterface;
                object = object.readStrongBinder();
                object = object == null ? null : ((iInterface = object.queryLocalInterface("com.google.android.gms.ads.internal.rewarded.client.IRewardItem")) instanceof zzccp ? (zzccp)iInterface : new zzccn((IBinder)object));
                this.zzg((zzccp)object);
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
        parcel.writeNoException();
        return true;
    }
}
