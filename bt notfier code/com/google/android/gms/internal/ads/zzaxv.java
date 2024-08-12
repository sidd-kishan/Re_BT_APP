/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.IBinder
 *  android.os.IInterface
 *  android.os.Parcel
 *  android.os.RemoteException
 *  com.google.android.gms.dynamic.IObjectWrapper
 *  com.google.android.gms.dynamic.IObjectWrapper$Stub
 *  com.google.android.gms.internal.ads.zzadk
 *  com.google.android.gms.internal.ads.zzadl
 *  com.google.android.gms.internal.ads.zzaxw
 *  com.google.android.gms.internal.ads.zzaya
 *  com.google.android.gms.internal.ads.zzayb
 *  com.google.android.gms.internal.ads.zzayd
 *  com.google.android.gms.internal.ads.zzbgv
 */
package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.internal.ads.zzadk;
import com.google.android.gms.internal.ads.zzadl;
import com.google.android.gms.internal.ads.zzaxw;
import com.google.android.gms.internal.ads.zzaya;
import com.google.android.gms.internal.ads.zzayb;
import com.google.android.gms.internal.ads.zzayd;
import com.google.android.gms.internal.ads.zzbgv;

public abstract class zzaxv
extends zzadk
implements zzaxw {
    public zzaxv() {
        super("com.google.android.gms.ads.internal.appopen.client.IAppOpenAd");
    }

    protected final boolean zzbz(int n, Parcel object, Parcel parcel, int n2) throws RemoteException {
        IObjectWrapper iObjectWrapper = null;
        IInterface iInterface = null;
        switch (n) {
            default: {
                return false;
            }
            case 7: {
                this.zzi(zzbgv.zzb((IBinder)object.readStrongBinder()));
                parcel.writeNoException();
                break;
            }
            case 6: {
                this.zzh(zzadl.zza((Parcel)object));
                parcel.writeNoException();
                break;
            }
            case 5: {
                object = this.zzg();
                parcel.writeNoException();
                zzadl.zzf((Parcel)parcel, (IInterface)object);
                break;
            }
            case 4: {
                iObjectWrapper = IObjectWrapper.Stub.asInterface((IBinder)object.readStrongBinder());
                object = object.readStrongBinder();
                object = object == null ? iInterface : ((iInterface = object.queryLocalInterface("com.google.android.gms.ads.internal.appopen.client.IAppOpenFullScreenContentCallback")) instanceof zzayd ? (zzayd)iInterface : new zzayb((IBinder)object));
                this.zzf(iObjectWrapper, (zzayd)object);
                parcel.writeNoException();
                break;
            }
            case 3: {
                object = object.readStrongBinder();
                object = object == null ? iObjectWrapper : ((iInterface = object.queryLocalInterface("com.google.android.gms.ads.internal.appopen.client.IAppOpenAdPresentationCallback")) instanceof zzaya ? (zzaya)iInterface : new zzaya((IBinder)object));
                this.zzj((zzaya)object);
                parcel.writeNoException();
                break;
            }
            case 2: {
                object = this.zze();
                parcel.writeNoException();
                zzadl.zzf((Parcel)parcel, (IInterface)object);
            }
        }
        return true;
    }
}
