/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.IBinder
 *  android.os.IInterface
 *  android.os.Parcel
 *  android.os.Parcelable
 *  android.os.RemoteException
 *  com.google.android.gms.ads.formats.AdManagerAdViewOptions
 *  com.google.android.gms.ads.formats.PublisherAdViewOptions
 *  com.google.android.gms.internal.ads.zzadj
 *  com.google.android.gms.internal.ads.zzadl
 *  com.google.android.gms.internal.ads.zzbdl
 *  com.google.android.gms.internal.ads.zzbfa
 *  com.google.android.gms.internal.ads.zzbfe
 *  com.google.android.gms.internal.ads.zzbfg
 *  com.google.android.gms.internal.ads.zzbfj
 *  com.google.android.gms.internal.ads.zzbfy
 *  com.google.android.gms.internal.ads.zzblv
 *  com.google.android.gms.internal.ads.zzbnf
 *  com.google.android.gms.internal.ads.zzbni
 *  com.google.android.gms.internal.ads.zzbnl
 *  com.google.android.gms.internal.ads.zzbno
 *  com.google.android.gms.internal.ads.zzbns
 *  com.google.android.gms.internal.ads.zzbnv
 *  com.google.android.gms.internal.ads.zzbrx
 *  com.google.android.gms.internal.ads.zzbsg
 */
package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import com.google.android.gms.ads.formats.AdManagerAdViewOptions;
import com.google.android.gms.ads.formats.PublisherAdViewOptions;
import com.google.android.gms.internal.ads.zzadj;
import com.google.android.gms.internal.ads.zzadl;
import com.google.android.gms.internal.ads.zzbdl;
import com.google.android.gms.internal.ads.zzbfa;
import com.google.android.gms.internal.ads.zzbfe;
import com.google.android.gms.internal.ads.zzbfg;
import com.google.android.gms.internal.ads.zzbfj;
import com.google.android.gms.internal.ads.zzbfy;
import com.google.android.gms.internal.ads.zzblv;
import com.google.android.gms.internal.ads.zzbnf;
import com.google.android.gms.internal.ads.zzbni;
import com.google.android.gms.internal.ads.zzbnl;
import com.google.android.gms.internal.ads.zzbno;
import com.google.android.gms.internal.ads.zzbns;
import com.google.android.gms.internal.ads.zzbnv;
import com.google.android.gms.internal.ads.zzbrx;
import com.google.android.gms.internal.ads.zzbsg;

public final class zzbfh
extends zzadj
implements zzbfj {
    zzbfh(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.client.IAdLoaderBuilder");
    }

    public final zzbfg zze() throws RemoteException {
        IInterface iInterface;
        Parcel parcel = this.zzbi(1, this.zza());
        Object object = parcel.readStrongBinder();
        object = object == null ? null : ((iInterface = object.queryLocalInterface("com.google.android.gms.ads.internal.client.IAdLoader")) instanceof zzbfg ? (zzbfg)iInterface : new zzbfe(object));
        parcel.recycle();
        return object;
    }

    public final void zzf(zzbfa zzbfa2) throws RemoteException {
        Parcel parcel = this.zza();
        zzadl.zzf((Parcel)parcel, (IInterface)zzbfa2);
        this.zzbj(2, parcel);
    }

    public final void zzg(zzbnf zzbnf2) throws RemoteException {
        throw null;
    }

    public final void zzh(zzbni zzbni2) throws RemoteException {
        throw null;
    }

    public final void zzi(String string, zzbno zzbno2, zzbnl zzbnl2) throws RemoteException {
        Parcel parcel = this.zza();
        parcel.writeString(string);
        zzadl.zzf((Parcel)parcel, (IInterface)zzbno2);
        zzadl.zzf((Parcel)parcel, (IInterface)zzbnl2);
        this.zzbj(5, parcel);
    }

    public final void zzj(zzblv zzblv2) throws RemoteException {
        Parcel parcel = this.zza();
        zzadl.zzd((Parcel)parcel, (Parcelable)zzblv2);
        this.zzbj(6, parcel);
    }

    public final void zzk(zzbns zzbns2, zzbdl zzbdl2) throws RemoteException {
        Parcel parcel = this.zza();
        zzadl.zzf((Parcel)parcel, (IInterface)zzbns2);
        zzadl.zzd((Parcel)parcel, (Parcelable)zzbdl2);
        this.zzbj(8, parcel);
    }

    public final void zzl(PublisherAdViewOptions publisherAdViewOptions) throws RemoteException {
        throw null;
    }

    public final void zzm(zzbnv zzbnv2) throws RemoteException {
        Parcel parcel = this.zza();
        zzadl.zzf((Parcel)parcel, (IInterface)zzbnv2);
        this.zzbj(10, parcel);
    }

    public final void zzn(zzbrx zzbrx2) throws RemoteException {
        throw null;
    }

    public final void zzo(zzbsg zzbsg2) throws RemoteException {
        throw null;
    }

    public final void zzp(AdManagerAdViewOptions adManagerAdViewOptions) throws RemoteException {
        Parcel parcel = this.zza();
        zzadl.zzd((Parcel)parcel, (Parcelable)adManagerAdViewOptions);
        this.zzbj(15, parcel);
    }

    public final void zzq(zzbfy zzbfy2) throws RemoteException {
        throw null;
    }
}
