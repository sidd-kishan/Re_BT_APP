/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.IBinder
 *  android.os.Parcel
 *  android.os.Parcelable$Creator
 *  android.os.RemoteException
 *  com.google.android.gms.dynamic.IObjectWrapper$Stub
 *  com.google.android.gms.internal.ads.zzadk
 *  com.google.android.gms.internal.ads.zzadl
 *  com.google.android.gms.internal.ads.zzbge
 *  com.google.android.gms.internal.ads.zzbgo
 *  com.google.android.gms.internal.ads.zzbgq
 *  com.google.android.gms.internal.ads.zzbim
 *  com.google.android.gms.internal.ads.zzbrr
 *  com.google.android.gms.internal.ads.zzbvf
 */
package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.internal.ads.zzadk;
import com.google.android.gms.internal.ads.zzadl;
import com.google.android.gms.internal.ads.zzbge;
import com.google.android.gms.internal.ads.zzbgo;
import com.google.android.gms.internal.ads.zzbgq;
import com.google.android.gms.internal.ads.zzbim;
import com.google.android.gms.internal.ads.zzbrr;
import com.google.android.gms.internal.ads.zzbvf;
import java.util.List;

public abstract class zzbgd
extends zzadk
implements zzbge {
    public zzbgd() {
        super("com.google.android.gms.ads.internal.client.IMobileAdsSettingManager");
    }

    protected final boolean zzbz(int n, Parcel object, Parcel parcel, int n2) throws RemoteException {
        switch (n) {
            default: {
                return false;
            }
            case 16: {
                IBinder iBinder = object.readStrongBinder();
                object = iBinder == null ? null : ((object = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IOnAdInspectorClosedListener")) instanceof zzbgq ? (zzbgq)object : new zzbgo(iBinder));
                this.zzt((zzbgq)object);
                parcel.writeNoException();
                break;
            }
            case 15: {
                this.zzs();
                parcel.writeNoException();
                break;
            }
            case 14: {
                this.zzr((zzbim)zzadl.zzc((Parcel)object, (Parcelable.Creator)zzbim.CREATOR));
                parcel.writeNoException();
                break;
            }
            case 13: {
                object = this.zzq();
                parcel.writeNoException();
                parcel.writeTypedList((List)object);
                break;
            }
            case 12: {
                this.zzp(zzbrr.zzc((IBinder)object.readStrongBinder()));
                parcel.writeNoException();
                break;
            }
            case 11: {
                this.zzo(zzbvf.zzg((IBinder)object.readStrongBinder()));
                parcel.writeNoException();
                break;
            }
            case 10: {
                this.zzn(object.readString());
                parcel.writeNoException();
                break;
            }
            case 9: {
                object = this.zzm();
                parcel.writeNoException();
                parcel.writeString((String)object);
                break;
            }
            case 8: {
                boolean bl = this.zzl();
                parcel.writeNoException();
                zzadl.zzb((Parcel)parcel, (boolean)bl);
                break;
            }
            case 7: {
                float f = this.zzk();
                parcel.writeNoException();
                parcel.writeFloat(f);
                break;
            }
            case 6: {
                this.zzj(object.readString(), IObjectWrapper.Stub.asInterface((IBinder)object.readStrongBinder()));
                parcel.writeNoException();
                break;
            }
            case 5: {
                this.zzi(IObjectWrapper.Stub.asInterface((IBinder)object.readStrongBinder()), object.readString());
                parcel.writeNoException();
                break;
            }
            case 4: {
                this.zzh(zzadl.zza((Parcel)object));
                parcel.writeNoException();
                break;
            }
            case 3: {
                this.zzg(object.readString());
                parcel.writeNoException();
                break;
            }
            case 2: {
                this.zzf(object.readFloat());
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
