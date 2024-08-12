/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.IBinder
 *  android.os.IInterface
 *  android.os.Parcel
 *  android.os.Parcelable$Creator
 *  android.os.RemoteException
 *  com.google.android.gms.ads.formats.AdManagerAdViewOptions
 *  com.google.android.gms.ads.formats.PublisherAdViewOptions
 *  com.google.android.gms.internal.ads.zzadk
 *  com.google.android.gms.internal.ads.zzadl
 *  com.google.android.gms.internal.ads.zzbdl
 *  com.google.android.gms.internal.ads.zzbey
 *  com.google.android.gms.internal.ads.zzbfa
 *  com.google.android.gms.internal.ads.zzbfj
 *  com.google.android.gms.internal.ads.zzbfy
 *  com.google.android.gms.internal.ads.zzblv
 *  com.google.android.gms.internal.ads.zzbne
 *  com.google.android.gms.internal.ads.zzbnh
 *  com.google.android.gms.internal.ads.zzbnk
 *  com.google.android.gms.internal.ads.zzbnn
 *  com.google.android.gms.internal.ads.zzbnr
 *  com.google.android.gms.internal.ads.zzbnu
 *  com.google.android.gms.internal.ads.zzbrx
 *  com.google.android.gms.internal.ads.zzbsf
 */
package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import com.google.android.gms.ads.formats.AdManagerAdViewOptions;
import com.google.android.gms.ads.formats.PublisherAdViewOptions;
import com.google.android.gms.internal.ads.zzadk;
import com.google.android.gms.internal.ads.zzadl;
import com.google.android.gms.internal.ads.zzbdl;
import com.google.android.gms.internal.ads.zzbey;
import com.google.android.gms.internal.ads.zzbfa;
import com.google.android.gms.internal.ads.zzbfj;
import com.google.android.gms.internal.ads.zzbfy;
import com.google.android.gms.internal.ads.zzblv;
import com.google.android.gms.internal.ads.zzbne;
import com.google.android.gms.internal.ads.zzbnh;
import com.google.android.gms.internal.ads.zzbnk;
import com.google.android.gms.internal.ads.zzbnn;
import com.google.android.gms.internal.ads.zzbnr;
import com.google.android.gms.internal.ads.zzbnu;
import com.google.android.gms.internal.ads.zzbrx;
import com.google.android.gms.internal.ads.zzbsf;

public abstract class zzbfi
extends zzadk
implements zzbfj {
    public zzbfi() {
        super("com.google.android.gms.ads.internal.client.IAdLoaderBuilder");
    }

    protected final boolean zzbz(int n, Parcel object, Parcel parcel, int n2) throws RemoteException {
        IInterface iInterface = null;
        Object var6_6 = null;
        switch (n) {
            default: {
                return false;
            }
            case 15: {
                this.zzp((AdManagerAdViewOptions)zzadl.zzc((Parcel)object, (Parcelable.Creator)AdManagerAdViewOptions.CREATOR));
                parcel.writeNoException();
                break;
            }
            case 14: {
                this.zzo(zzbsf.zzb((IBinder)object.readStrongBinder()));
                parcel.writeNoException();
                break;
            }
            case 13: {
                this.zzn((zzbrx)zzadl.zzc((Parcel)object, (Parcelable.Creator)zzbrx.CREATOR));
                parcel.writeNoException();
                break;
            }
            case 10: {
                this.zzm(zzbnu.zzb((IBinder)object.readStrongBinder()));
                parcel.writeNoException();
                break;
            }
            case 9: {
                this.zzl((PublisherAdViewOptions)zzadl.zzc((Parcel)object, (Parcelable.Creator)PublisherAdViewOptions.CREATOR));
                parcel.writeNoException();
                break;
            }
            case 8: {
                this.zzk(zzbnr.zzb((IBinder)object.readStrongBinder()), (zzbdl)zzadl.zzc((Parcel)object, (Parcelable.Creator)zzbdl.CREATOR));
                parcel.writeNoException();
                break;
            }
            case 7: {
                object = object.readStrongBinder();
                object = object == null ? var6_6 : ((iInterface = object.queryLocalInterface("com.google.android.gms.ads.internal.client.ICorrelationIdProvider")) instanceof zzbfy ? (zzbfy)iInterface : new zzbfy((IBinder)object));
                this.zzq((zzbfy)object);
                parcel.writeNoException();
                break;
            }
            case 6: {
                this.zzj((zzblv)zzadl.zzc((Parcel)object, (Parcelable.Creator)zzblv.CREATOR));
                parcel.writeNoException();
                break;
            }
            case 5: {
                this.zzi(object.readString(), zzbnn.zzb((IBinder)object.readStrongBinder()), zzbnk.zzb((IBinder)object.readStrongBinder()));
                parcel.writeNoException();
                break;
            }
            case 4: {
                this.zzh(zzbnh.zzb((IBinder)object.readStrongBinder()));
                parcel.writeNoException();
                break;
            }
            case 3: {
                this.zzg(zzbne.zzb((IBinder)object.readStrongBinder()));
                parcel.writeNoException();
                break;
            }
            case 2: {
                object = object.readStrongBinder();
                object = object == null ? iInterface : ((iInterface = object.queryLocalInterface("com.google.android.gms.ads.internal.client.IAdListener")) instanceof zzbfa ? (zzbfa)iInterface : new zzbey((IBinder)object));
                this.zzf((zzbfa)object);
                parcel.writeNoException();
                break;
            }
            case 1: {
                object = this.zze();
                parcel.writeNoException();
                zzadl.zzf((Parcel)parcel, (IInterface)object);
            }
        }
        return true;
    }
}
