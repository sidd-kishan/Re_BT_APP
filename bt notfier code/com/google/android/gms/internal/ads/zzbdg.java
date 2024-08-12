/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.location.Location
 *  android.os.Bundle
 *  android.os.Parcel
 *  android.os.Parcelable
 *  android.os.Parcelable$Creator
 *  com.google.android.gms.common.internal.Objects
 *  com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable
 *  com.google.android.gms.common.internal.safeparcel.SafeParcelWriter
 *  com.google.android.gms.internal.ads.zzbcx
 *  com.google.android.gms.internal.ads.zzbdi
 *  com.google.android.gms.internal.ads.zzbio
 *  com.google.android.gms.internal.ads.zzcgu
 */
package com.google.android.gms.internal.ads;

import android.location.Location;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.internal.ads.zzbcx;
import com.google.android.gms.internal.ads.zzbdi;
import com.google.android.gms.internal.ads.zzbio;
import com.google.android.gms.internal.ads.zzcgu;
import java.util.ArrayList;
import java.util.List;

public final class zzbdg
extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzbdg> CREATOR = new zzbdi();
    public final int zza;
    @Deprecated
    public final long zzb;
    public final Bundle zzc;
    @Deprecated
    public final int zzd;
    public final List<String> zze;
    public final boolean zzf;
    public final int zzg;
    public final boolean zzh;
    public final String zzi;
    public final zzbio zzj;
    public final Location zzk;
    public final String zzl;
    public final Bundle zzm;
    public final Bundle zzn;
    public final List<String> zzo;
    public final String zzp;
    public final String zzq;
    @Deprecated
    public final boolean zzr;
    public final zzbcx zzs;
    public final int zzt;
    public final String zzu;
    public final List<String> zzv;
    public final int zzw;
    public final String zzx;

    public zzbdg(int n, long l, Bundle bundle, int n2, List<String> list, boolean bl, int n3, boolean bl2, String string, zzbio zzbio2, Location location, String string2, Bundle bundle2, Bundle bundle3, List<String> list2, String string3, String string4, boolean bl3, zzbcx zzbcx2, int n4, String string5, List<String> list3, int n5, String string6) {
        this.zza = n;
        this.zzb = l;
        if (bundle == null) {
            bundle = new Bundle();
        }
        this.zzc = bundle;
        this.zzd = n2;
        this.zze = list;
        this.zzf = bl;
        this.zzg = n3;
        this.zzh = bl2;
        this.zzi = string;
        this.zzj = zzbio2;
        this.zzk = location;
        this.zzl = string2;
        if (bundle2 == null) {
            bundle2 = new Bundle();
        }
        this.zzm = bundle2;
        this.zzn = bundle3;
        this.zzo = list2;
        this.zzp = string3;
        this.zzq = string4;
        this.zzr = bl3;
        this.zzs = zzbcx2;
        this.zzt = n4;
        this.zzu = string5;
        if (list3 == null) {
            list3 = new ArrayList<String>();
        }
        this.zzv = list3;
        this.zzw = n5;
        this.zzx = string6;
    }

    public final boolean equals(Object object) {
        if (!(object instanceof zzbdg)) {
            return false;
        }
        object = (zzbdg)((Object)object);
        if (this.zza != ((zzbdg)((Object)object)).zza) return false;
        if (this.zzb != ((zzbdg)((Object)object)).zzb) return false;
        if (!zzcgu.zza((Bundle)this.zzc, (Bundle)((zzbdg)((Object)object)).zzc)) return false;
        if (this.zzd != ((zzbdg)((Object)object)).zzd) return false;
        if (!Objects.equal(this.zze, ((zzbdg)((Object)object)).zze)) return false;
        if (this.zzf != ((zzbdg)((Object)object)).zzf) return false;
        if (this.zzg != ((zzbdg)((Object)object)).zzg) return false;
        if (this.zzh != ((zzbdg)((Object)object)).zzh) return false;
        if (!Objects.equal((Object)this.zzi, (Object)((zzbdg)((Object)object)).zzi)) return false;
        if (!Objects.equal((Object)this.zzj, (Object)((zzbdg)((Object)object)).zzj)) return false;
        if (!Objects.equal((Object)this.zzk, (Object)((zzbdg)((Object)object)).zzk)) return false;
        if (!Objects.equal((Object)this.zzl, (Object)((zzbdg)((Object)object)).zzl)) return false;
        if (!zzcgu.zza((Bundle)this.zzm, (Bundle)((zzbdg)((Object)object)).zzm)) return false;
        if (!zzcgu.zza((Bundle)this.zzn, (Bundle)((zzbdg)((Object)object)).zzn)) return false;
        if (!Objects.equal(this.zzo, ((zzbdg)((Object)object)).zzo)) return false;
        if (!Objects.equal((Object)this.zzp, (Object)((zzbdg)((Object)object)).zzp)) return false;
        if (!Objects.equal((Object)this.zzq, (Object)((zzbdg)((Object)object)).zzq)) return false;
        if (this.zzr != ((zzbdg)((Object)object)).zzr) return false;
        if (this.zzt != ((zzbdg)((Object)object)).zzt) return false;
        if (!Objects.equal((Object)this.zzu, (Object)((zzbdg)((Object)object)).zzu)) return false;
        if (!Objects.equal(this.zzv, ((zzbdg)((Object)object)).zzv)) return false;
        if (this.zzw != ((zzbdg)((Object)object)).zzw) return false;
        if (!Objects.equal((Object)this.zzx, (Object)((zzbdg)((Object)object)).zzx)) return false;
        return true;
    }

    public final int hashCode() {
        return Objects.hashCode((Object[])new Object[]{this.zza, this.zzb, this.zzc, this.zzd, this.zze, this.zzf, this.zzg, this.zzh, this.zzi, this.zzj, this.zzk, this.zzl, this.zzm, this.zzn, this.zzo, this.zzp, this.zzq, this.zzr, this.zzt, this.zzu, this.zzv, this.zzw, this.zzx});
    }

    public final void writeToParcel(Parcel parcel, int n) {
        int n2 = SafeParcelWriter.beginObjectHeader((Parcel)parcel);
        SafeParcelWriter.writeInt((Parcel)parcel, (int)1, (int)this.zza);
        SafeParcelWriter.writeLong((Parcel)parcel, (int)2, (long)this.zzb);
        SafeParcelWriter.writeBundle((Parcel)parcel, (int)3, (Bundle)this.zzc, (boolean)false);
        SafeParcelWriter.writeInt((Parcel)parcel, (int)4, (int)this.zzd);
        SafeParcelWriter.writeStringList((Parcel)parcel, (int)5, this.zze, (boolean)false);
        SafeParcelWriter.writeBoolean((Parcel)parcel, (int)6, (boolean)this.zzf);
        SafeParcelWriter.writeInt((Parcel)parcel, (int)7, (int)this.zzg);
        SafeParcelWriter.writeBoolean((Parcel)parcel, (int)8, (boolean)this.zzh);
        SafeParcelWriter.writeString((Parcel)parcel, (int)9, (String)this.zzi, (boolean)false);
        SafeParcelWriter.writeParcelable((Parcel)parcel, (int)10, (Parcelable)this.zzj, (int)n, (boolean)false);
        SafeParcelWriter.writeParcelable((Parcel)parcel, (int)11, (Parcelable)this.zzk, (int)n, (boolean)false);
        SafeParcelWriter.writeString((Parcel)parcel, (int)12, (String)this.zzl, (boolean)false);
        SafeParcelWriter.writeBundle((Parcel)parcel, (int)13, (Bundle)this.zzm, (boolean)false);
        SafeParcelWriter.writeBundle((Parcel)parcel, (int)14, (Bundle)this.zzn, (boolean)false);
        SafeParcelWriter.writeStringList((Parcel)parcel, (int)15, this.zzo, (boolean)false);
        SafeParcelWriter.writeString((Parcel)parcel, (int)16, (String)this.zzp, (boolean)false);
        SafeParcelWriter.writeString((Parcel)parcel, (int)17, (String)this.zzq, (boolean)false);
        SafeParcelWriter.writeBoolean((Parcel)parcel, (int)18, (boolean)this.zzr);
        SafeParcelWriter.writeParcelable((Parcel)parcel, (int)19, (Parcelable)this.zzs, (int)n, (boolean)false);
        SafeParcelWriter.writeInt((Parcel)parcel, (int)20, (int)this.zzt);
        SafeParcelWriter.writeString((Parcel)parcel, (int)21, (String)this.zzu, (boolean)false);
        SafeParcelWriter.writeStringList((Parcel)parcel, (int)22, this.zzv, (boolean)false);
        SafeParcelWriter.writeInt((Parcel)parcel, (int)23, (int)this.zzw);
        SafeParcelWriter.writeString((Parcel)parcel, (int)24, (String)this.zzx, (boolean)false);
        SafeParcelWriter.finishObjectHeader((Parcel)parcel, (int)n2);
    }
}
