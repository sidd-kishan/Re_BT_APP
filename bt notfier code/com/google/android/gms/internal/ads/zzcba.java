/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.IBinder
 *  android.os.Parcel
 *  android.os.Parcelable$Creator
 *  android.os.RemoteException
 *  com.google.android.gms.internal.ads.zzadk
 *  com.google.android.gms.internal.ads.zzadl
 *  com.google.android.gms.internal.ads.zzcav
 *  com.google.android.gms.internal.ads.zzcbb
 *  com.google.android.gms.internal.ads.zzcbc
 *  com.google.android.gms.internal.ads.zzcbd
 *  com.google.android.gms.internal.ads.zzcbf
 *  com.google.android.gms.internal.ads.zzcbj
 */
package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import com.google.android.gms.internal.ads.zzadk;
import com.google.android.gms.internal.ads.zzadl;
import com.google.android.gms.internal.ads.zzcav;
import com.google.android.gms.internal.ads.zzcbb;
import com.google.android.gms.internal.ads.zzcbc;
import com.google.android.gms.internal.ads.zzcbd;
import com.google.android.gms.internal.ads.zzcbf;
import com.google.android.gms.internal.ads.zzcbj;

public abstract class zzcba
extends zzadk
implements zzcbb {
    public zzcba() {
        super("com.google.android.gms.ads.internal.request.IAdRequestService");
    }

    protected final boolean zzbz(int n, Parcel object, Parcel parcel, int n2) throws RemoteException {
        String string = null;
        Object var7_6 = null;
        Object var8_7 = null;
        zzcav zzcav2 = null;
        if (n != 1) {
            if (n != 2) {
                if (n != 4) {
                    if (n != 5) {
                        if (n != 6) {
                            if (n != 7) {
                                return false;
                            }
                            string = object.readString();
                            object = (object = object.readStrongBinder()) == null ? zzcav2 : ((zzcav2 = object.queryLocalInterface("com.google.android.gms.ads.internal.request.INonagonStreamingResponseListener")) instanceof zzcbf ? (zzcbf)zzcav2 : new zzcbd((IBinder)object));
                            this.zzh(string, (zzcbf)object);
                            parcel.writeNoException();
                        } else {
                            zzcav2 = (zzcbj)zzadl.zzc((Parcel)object, (Parcelable.Creator)zzcbj.CREATOR);
                            object = (object = object.readStrongBinder()) == null ? string : ((string = object.queryLocalInterface("com.google.android.gms.ads.internal.request.INonagonStreamingResponseListener")) instanceof zzcbf ? (zzcbf)string : new zzcbd((IBinder)object));
                            this.zzg((zzcbj)zzcav2, (zzcbf)object);
                            parcel.writeNoException();
                        }
                    } else {
                        zzcav2 = (zzcbj)zzadl.zzc((Parcel)object, (Parcelable.Creator)zzcbj.CREATOR);
                        object = (object = object.readStrongBinder()) == null ? var7_6 : ((string = object.queryLocalInterface("com.google.android.gms.ads.internal.request.INonagonStreamingResponseListener")) instanceof zzcbf ? (zzcbf)string : new zzcbd((IBinder)object));
                        this.zzf((zzcbj)zzcav2, (zzcbf)object);
                        parcel.writeNoException();
                    }
                } else {
                    zzcav2 = (zzcbj)zzadl.zzc((Parcel)object, (Parcelable.Creator)zzcbj.CREATOR);
                    object = (object = object.readStrongBinder()) == null ? var8_7 : ((string = object.queryLocalInterface("com.google.android.gms.ads.internal.request.INonagonStreamingResponseListener")) instanceof zzcbf ? (zzcbf)string : new zzcbd((IBinder)object));
                    this.zze((zzcbj)zzcav2, (zzcbf)object);
                    parcel.writeNoException();
                }
            } else {
                zzcav2 = (zzcav)zzadl.zzc((Parcel)object, (Parcelable.Creator)zzcav.CREATOR);
                zzcav2 = object.readStrongBinder();
                if (zzcav2 != null) {
                    object = zzcav2.queryLocalInterface("com.google.android.gms.ads.internal.request.IAdResponseListener");
                    if (object instanceof zzcbc) {
                        object = (zzcbc)object;
                    } else {
                        new zzcbc((IBinder)zzcav2);
                    }
                }
                parcel.writeNoException();
            }
        } else {
            object = (zzcav)zzadl.zzc((Parcel)object, (Parcelable.Creator)zzcav.CREATOR);
            parcel.writeNoException();
            zzadl.zze((Parcel)parcel, null);
        }
        return true;
    }
}
