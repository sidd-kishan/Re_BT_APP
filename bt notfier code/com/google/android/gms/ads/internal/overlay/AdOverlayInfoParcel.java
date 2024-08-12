/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Intent
 *  android.os.IBinder
 *  android.os.Parcel
 *  android.os.Parcelable
 *  android.os.Parcelable$Creator
 *  com.google.android.gms.ads.internal.overlay.zzc
 *  com.google.android.gms.ads.internal.overlay.zzn
 *  com.google.android.gms.ads.internal.overlay.zzo
 *  com.google.android.gms.ads.internal.overlay.zzv
 *  com.google.android.gms.ads.internal.util.zzbu
 *  com.google.android.gms.ads.internal.zzj
 *  com.google.android.gms.common.internal.ReflectedParcelable
 *  com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable
 *  com.google.android.gms.common.internal.safeparcel.SafeParcelWriter
 *  com.google.android.gms.dynamic.IObjectWrapper
 *  com.google.android.gms.dynamic.IObjectWrapper$Stub
 *  com.google.android.gms.dynamic.ObjectWrapper
 *  com.google.android.gms.internal.ads.zzbcv
 *  com.google.android.gms.internal.ads.zzbor
 *  com.google.android.gms.internal.ads.zzbot
 *  com.google.android.gms.internal.ads.zzcgz
 *  com.google.android.gms.internal.ads.zzcml
 *  com.google.android.gms.internal.ads.zzdbp
 *  com.google.android.gms.internal.ads.zzdio
 *  com.google.android.gms.internal.ads.zzdvi
 *  com.google.android.gms.internal.ads.zzedq
 *  com.google.android.gms.internal.ads.zzffc
 */
package com.google.android.gms.ads.internal.overlay;

import android.content.Intent;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.ads.internal.overlay.zzc;
import com.google.android.gms.ads.internal.overlay.zzn;
import com.google.android.gms.ads.internal.overlay.zzo;
import com.google.android.gms.ads.internal.overlay.zzv;
import com.google.android.gms.ads.internal.util.zzbu;
import com.google.android.gms.ads.internal.zzj;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.internal.ads.zzbcv;
import com.google.android.gms.internal.ads.zzbor;
import com.google.android.gms.internal.ads.zzbot;
import com.google.android.gms.internal.ads.zzcgz;
import com.google.android.gms.internal.ads.zzcml;
import com.google.android.gms.internal.ads.zzdbp;
import com.google.android.gms.internal.ads.zzdio;
import com.google.android.gms.internal.ads.zzdvi;
import com.google.android.gms.internal.ads.zzedq;
import com.google.android.gms.internal.ads.zzffc;

public final class AdOverlayInfoParcel
extends AbstractSafeParcelable
implements ReflectedParcelable {
    public static final Parcelable.Creator<AdOverlayInfoParcel> CREATOR = new zzn();
    public final zzc zza;
    public final zzbcv zzb;
    public final zzo zzc;
    public final zzcml zzd;
    public final zzbot zze;
    public final String zzf;
    public final boolean zzg;
    public final String zzh;
    public final zzv zzi;
    public final int zzj;
    public final int zzk;
    public final String zzl;
    public final zzcgz zzm;
    public final String zzn;
    public final zzj zzo;
    public final zzbor zzp;
    public final String zzq;
    public final zzedq zzr;
    public final zzdvi zzs;
    public final zzffc zzt;
    public final zzbu zzu;
    public final String zzv;
    public final String zzw;
    public final zzdbp zzx;
    public final zzdio zzy;

    AdOverlayInfoParcel(zzc zzc2, IBinder iBinder, IBinder iBinder2, IBinder iBinder3, IBinder iBinder4, String string, boolean bl, String string2, IBinder iBinder5, int n, int n2, String string3, zzcgz zzcgz2, String string4, zzj zzj2, IBinder iBinder6, String string5, IBinder iBinder7, IBinder iBinder8, IBinder iBinder9, IBinder iBinder10, String string6, String string7, IBinder iBinder11, IBinder iBinder12) {
        this.zza = zzc2;
        this.zzb = (zzbcv)ObjectWrapper.unwrap((IObjectWrapper)IObjectWrapper.Stub.asInterface((IBinder)iBinder));
        this.zzc = (zzo)ObjectWrapper.unwrap((IObjectWrapper)IObjectWrapper.Stub.asInterface((IBinder)iBinder2));
        this.zzd = (zzcml)ObjectWrapper.unwrap((IObjectWrapper)IObjectWrapper.Stub.asInterface((IBinder)iBinder3));
        this.zzp = (zzbor)ObjectWrapper.unwrap((IObjectWrapper)IObjectWrapper.Stub.asInterface((IBinder)iBinder6));
        this.zze = (zzbot)ObjectWrapper.unwrap((IObjectWrapper)IObjectWrapper.Stub.asInterface((IBinder)iBinder4));
        this.zzf = string;
        this.zzg = bl;
        this.zzh = string2;
        this.zzi = (zzv)ObjectWrapper.unwrap((IObjectWrapper)IObjectWrapper.Stub.asInterface((IBinder)iBinder5));
        this.zzj = n;
        this.zzk = n2;
        this.zzl = string3;
        this.zzm = zzcgz2;
        this.zzn = string4;
        this.zzo = zzj2;
        this.zzq = string5;
        this.zzv = string6;
        this.zzr = (zzedq)ObjectWrapper.unwrap((IObjectWrapper)IObjectWrapper.Stub.asInterface((IBinder)iBinder7));
        this.zzs = (zzdvi)ObjectWrapper.unwrap((IObjectWrapper)IObjectWrapper.Stub.asInterface((IBinder)iBinder8));
        this.zzt = (zzffc)ObjectWrapper.unwrap((IObjectWrapper)IObjectWrapper.Stub.asInterface((IBinder)iBinder9));
        this.zzu = (zzbu)ObjectWrapper.unwrap((IObjectWrapper)IObjectWrapper.Stub.asInterface((IBinder)iBinder10));
        this.zzw = string7;
        this.zzx = (zzdbp)ObjectWrapper.unwrap((IObjectWrapper)IObjectWrapper.Stub.asInterface((IBinder)iBinder11));
        this.zzy = (zzdio)ObjectWrapper.unwrap((IObjectWrapper)IObjectWrapper.Stub.asInterface((IBinder)iBinder12));
    }

    public AdOverlayInfoParcel(zzc zzc2, zzbcv zzbcv2, zzo zzo2, zzv zzv2, zzcgz zzcgz2, zzcml zzcml2, zzdio zzdio2) {
        this.zza = zzc2;
        this.zzb = zzbcv2;
        this.zzc = zzo2;
        this.zzd = zzcml2;
        this.zzp = null;
        this.zze = null;
        this.zzf = null;
        this.zzg = false;
        this.zzh = null;
        this.zzi = zzv2;
        this.zzj = -1;
        this.zzk = 4;
        this.zzl = null;
        this.zzm = zzcgz2;
        this.zzn = null;
        this.zzo = null;
        this.zzq = null;
        this.zzv = null;
        this.zzr = null;
        this.zzs = null;
        this.zzt = null;
        this.zzu = null;
        this.zzw = null;
        this.zzx = null;
        this.zzy = zzdio2;
    }

    public AdOverlayInfoParcel(zzo zzo2, zzcml zzcml2, int n, zzcgz zzcgz2) {
        this.zzc = zzo2;
        this.zzd = zzcml2;
        this.zzj = 1;
        this.zzm = zzcgz2;
        this.zza = null;
        this.zzb = null;
        this.zzp = null;
        this.zze = null;
        this.zzf = null;
        this.zzg = false;
        this.zzh = null;
        this.zzi = null;
        this.zzk = 1;
        this.zzl = null;
        this.zzn = null;
        this.zzo = null;
        this.zzq = null;
        this.zzv = null;
        this.zzr = null;
        this.zzs = null;
        this.zzt = null;
        this.zzu = null;
        this.zzw = null;
        this.zzx = null;
        this.zzy = null;
    }

    public AdOverlayInfoParcel(zzbcv zzbcv2, zzo zzo2, zzv zzv2, zzcml zzcml2, int n, zzcgz zzcgz2, String string, zzj zzj2, String string2, String string3, String string4, zzdbp zzdbp2) {
        this.zza = null;
        this.zzb = null;
        this.zzc = zzo2;
        this.zzd = zzcml2;
        this.zzp = null;
        this.zze = null;
        this.zzf = string2;
        this.zzg = false;
        this.zzh = string3;
        this.zzi = null;
        this.zzj = n;
        this.zzk = 1;
        this.zzl = null;
        this.zzm = zzcgz2;
        this.zzn = string;
        this.zzo = zzj2;
        this.zzq = null;
        this.zzv = null;
        this.zzr = null;
        this.zzs = null;
        this.zzt = null;
        this.zzu = null;
        this.zzw = string4;
        this.zzx = zzdbp2;
        this.zzy = null;
    }

    public AdOverlayInfoParcel(zzbcv zzbcv2, zzo zzo2, zzv zzv2, zzcml zzcml2, boolean bl, int n, zzcgz zzcgz2, zzdio zzdio2) {
        this.zza = null;
        this.zzb = zzbcv2;
        this.zzc = zzo2;
        this.zzd = zzcml2;
        this.zzp = null;
        this.zze = null;
        this.zzf = null;
        this.zzg = bl;
        this.zzh = null;
        this.zzi = zzv2;
        this.zzj = n;
        this.zzk = 2;
        this.zzl = null;
        this.zzm = zzcgz2;
        this.zzn = null;
        this.zzo = null;
        this.zzq = null;
        this.zzv = null;
        this.zzr = null;
        this.zzs = null;
        this.zzt = null;
        this.zzu = null;
        this.zzw = null;
        this.zzx = null;
        this.zzy = zzdio2;
    }

    public AdOverlayInfoParcel(zzbcv zzbcv2, zzo zzo2, zzbor zzbor2, zzbot zzbot2, zzv zzv2, zzcml zzcml2, boolean bl, int n, String string, zzcgz zzcgz2, zzdio zzdio2) {
        this.zza = null;
        this.zzb = zzbcv2;
        this.zzc = zzo2;
        this.zzd = zzcml2;
        this.zzp = zzbor2;
        this.zze = zzbot2;
        this.zzf = null;
        this.zzg = bl;
        this.zzh = null;
        this.zzi = zzv2;
        this.zzj = n;
        this.zzk = 3;
        this.zzl = string;
        this.zzm = zzcgz2;
        this.zzn = null;
        this.zzo = null;
        this.zzq = null;
        this.zzv = null;
        this.zzr = null;
        this.zzs = null;
        this.zzt = null;
        this.zzu = null;
        this.zzw = null;
        this.zzx = null;
        this.zzy = zzdio2;
    }

    public AdOverlayInfoParcel(zzbcv zzbcv2, zzo zzo2, zzbor zzbor2, zzbot zzbot2, zzv zzv2, zzcml zzcml2, boolean bl, int n, String string, String string2, zzcgz zzcgz2, zzdio zzdio2) {
        this.zza = null;
        this.zzb = zzbcv2;
        this.zzc = zzo2;
        this.zzd = zzcml2;
        this.zzp = zzbor2;
        this.zze = zzbot2;
        this.zzf = string2;
        this.zzg = bl;
        this.zzh = string;
        this.zzi = zzv2;
        this.zzj = n;
        this.zzk = 3;
        this.zzl = null;
        this.zzm = zzcgz2;
        this.zzn = null;
        this.zzo = null;
        this.zzq = null;
        this.zzv = null;
        this.zzr = null;
        this.zzs = null;
        this.zzt = null;
        this.zzu = null;
        this.zzw = null;
        this.zzx = null;
        this.zzy = zzdio2;
    }

    public AdOverlayInfoParcel(zzcml zzcml2, zzcgz zzcgz2, zzbu zzbu2, zzedq zzedq2, zzdvi zzdvi2, zzffc zzffc2, String string, String string2, int n) {
        this.zza = null;
        this.zzb = null;
        this.zzc = null;
        this.zzd = zzcml2;
        this.zzp = null;
        this.zze = null;
        this.zzf = null;
        this.zzg = false;
        this.zzh = null;
        this.zzi = null;
        this.zzj = n;
        this.zzk = 5;
        this.zzl = null;
        this.zzm = zzcgz2;
        this.zzn = null;
        this.zzo = null;
        this.zzq = string;
        this.zzv = string2;
        this.zzr = zzedq2;
        this.zzs = zzdvi2;
        this.zzt = zzffc2;
        this.zzu = zzbu2;
        this.zzw = null;
        this.zzx = null;
        this.zzy = null;
    }

    public static AdOverlayInfoParcel zza(Intent object) {
        try {
            object = object.getBundleExtra("com.google.android.gms.ads.inernal.overlay.AdOverlayInfo");
            object.setClassLoader(AdOverlayInfoParcel.class.getClassLoader());
            object = (AdOverlayInfoParcel)object.getParcelable("com.google.android.gms.ads.inernal.overlay.AdOverlayInfo");
            return object;
        }
        catch (Exception exception) {
            return null;
        }
    }

    public final void writeToParcel(Parcel parcel, int n) {
        int n2 = SafeParcelWriter.beginObjectHeader((Parcel)parcel);
        SafeParcelWriter.writeParcelable((Parcel)parcel, (int)2, (Parcelable)this.zza, (int)n, (boolean)false);
        SafeParcelWriter.writeIBinder((Parcel)parcel, (int)3, (IBinder)ObjectWrapper.wrap((Object)this.zzb).asBinder(), (boolean)false);
        SafeParcelWriter.writeIBinder((Parcel)parcel, (int)4, (IBinder)ObjectWrapper.wrap((Object)this.zzc).asBinder(), (boolean)false);
        SafeParcelWriter.writeIBinder((Parcel)parcel, (int)5, (IBinder)ObjectWrapper.wrap((Object)this.zzd).asBinder(), (boolean)false);
        SafeParcelWriter.writeIBinder((Parcel)parcel, (int)6, (IBinder)ObjectWrapper.wrap((Object)this.zze).asBinder(), (boolean)false);
        SafeParcelWriter.writeString((Parcel)parcel, (int)7, (String)this.zzf, (boolean)false);
        SafeParcelWriter.writeBoolean((Parcel)parcel, (int)8, (boolean)this.zzg);
        SafeParcelWriter.writeString((Parcel)parcel, (int)9, (String)this.zzh, (boolean)false);
        SafeParcelWriter.writeIBinder((Parcel)parcel, (int)10, (IBinder)ObjectWrapper.wrap((Object)this.zzi).asBinder(), (boolean)false);
        SafeParcelWriter.writeInt((Parcel)parcel, (int)11, (int)this.zzj);
        SafeParcelWriter.writeInt((Parcel)parcel, (int)12, (int)this.zzk);
        SafeParcelWriter.writeString((Parcel)parcel, (int)13, (String)this.zzl, (boolean)false);
        SafeParcelWriter.writeParcelable((Parcel)parcel, (int)14, (Parcelable)this.zzm, (int)n, (boolean)false);
        SafeParcelWriter.writeString((Parcel)parcel, (int)16, (String)this.zzn, (boolean)false);
        SafeParcelWriter.writeParcelable((Parcel)parcel, (int)17, (Parcelable)this.zzo, (int)n, (boolean)false);
        SafeParcelWriter.writeIBinder((Parcel)parcel, (int)18, (IBinder)ObjectWrapper.wrap((Object)this.zzp).asBinder(), (boolean)false);
        SafeParcelWriter.writeString((Parcel)parcel, (int)19, (String)this.zzq, (boolean)false);
        SafeParcelWriter.writeIBinder((Parcel)parcel, (int)20, (IBinder)ObjectWrapper.wrap((Object)this.zzr).asBinder(), (boolean)false);
        SafeParcelWriter.writeIBinder((Parcel)parcel, (int)21, (IBinder)ObjectWrapper.wrap((Object)this.zzs).asBinder(), (boolean)false);
        SafeParcelWriter.writeIBinder((Parcel)parcel, (int)22, (IBinder)ObjectWrapper.wrap((Object)this.zzt).asBinder(), (boolean)false);
        SafeParcelWriter.writeIBinder((Parcel)parcel, (int)23, (IBinder)ObjectWrapper.wrap((Object)this.zzu).asBinder(), (boolean)false);
        SafeParcelWriter.writeString((Parcel)parcel, (int)24, (String)this.zzv, (boolean)false);
        SafeParcelWriter.writeString((Parcel)parcel, (int)25, (String)this.zzw, (boolean)false);
        SafeParcelWriter.writeIBinder((Parcel)parcel, (int)26, (IBinder)ObjectWrapper.wrap((Object)this.zzx).asBinder(), (boolean)false);
        SafeParcelWriter.writeIBinder((Parcel)parcel, (int)27, (IBinder)ObjectWrapper.wrap((Object)this.zzy).asBinder(), (boolean)false);
        SafeParcelWriter.finishObjectHeader((Parcel)parcel, (int)n2);
    }
}
