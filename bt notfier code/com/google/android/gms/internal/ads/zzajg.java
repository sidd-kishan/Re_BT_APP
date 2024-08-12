/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Parcel
 *  android.os.Parcelable$Creator
 *  com.google.android.gms.internal.ads.zzagm
 *  com.google.android.gms.internal.ads.zzaiu
 *  com.google.android.gms.internal.ads.zzajf
 *  com.google.android.gms.internal.ads.zzakt
 *  com.google.android.gms.internal.ads.zzamq
 */
package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.internal.ads.zzagm;
import com.google.android.gms.internal.ads.zzaiu;
import com.google.android.gms.internal.ads.zzajf;
import com.google.android.gms.internal.ads.zzakt;
import com.google.android.gms.internal.ads.zzamq;

public final class zzajg
implements zzaiu {
    public static final Parcelable.Creator<zzajg> CREATOR = new zzajf();
    public final int zza;
    public final String zzb;
    public final String zzc;
    public final String zzd;
    public final boolean zze;
    public final int zzf;

    public zzajg(int n, String string, String string2, String string3, boolean bl, int n2) {
        boolean bl2;
        boolean bl3 = bl2 = true;
        if (n2 != -1) {
            bl3 = n2 > 0 ? bl2 : false;
        }
        zzakt.zza((boolean)bl3);
        this.zza = n;
        this.zzb = string;
        this.zzc = string2;
        this.zzd = string3;
        this.zze = bl;
        this.zzf = n2;
    }

    zzajg(Parcel parcel) {
        this.zza = parcel.readInt();
        this.zzb = parcel.readString();
        this.zzc = parcel.readString();
        this.zzd = parcel.readString();
        this.zze = zzamq.zzn((Parcel)parcel);
        this.zzf = parcel.readInt();
    }

    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null) return false;
        if (this.getClass() != object.getClass()) {
            return false;
        }
        object = (zzajg)object;
        if (this.zza != ((zzajg)object).zza) return false;
        if (!zzamq.zzc((Object)this.zzb, (Object)((zzajg)object).zzb)) return false;
        if (!zzamq.zzc((Object)this.zzc, (Object)((zzajg)object).zzc)) return false;
        if (!zzamq.zzc((Object)this.zzd, (Object)((zzajg)object).zzd)) return false;
        if (this.zze != ((zzajg)object).zze) return false;
        if (this.zzf != ((zzajg)object).zzf) return false;
        return true;
    }

    public final int hashCode() {
        int n = this.zza;
        String string = this.zzb;
        int n2 = 0;
        int n3 = string != null ? string.hashCode() : 0;
        string = this.zzc;
        int n4 = string != null ? string.hashCode() : 0;
        string = this.zzd;
        if (string == null) return (((((n + 527) * 31 + n3) * 31 + n4) * 31 + n2) * 31 + this.zze) * 31 + this.zzf;
        n2 = string.hashCode();
        return (((((n + 527) * 31 + n3) * 31 + n4) * 31 + n2) * 31 + this.zze) * 31 + this.zzf;
    }

    public final String toString() {
        String string = this.zzc;
        String string2 = this.zzb;
        int n = this.zza;
        int n2 = this.zzf;
        StringBuilder stringBuilder = new StringBuilder(String.valueOf(string).length() + 80 + String.valueOf(string2).length());
        stringBuilder.append("IcyHeaders: name=\"");
        stringBuilder.append(string);
        stringBuilder.append("\", genre=\"");
        stringBuilder.append(string2);
        stringBuilder.append("\", bitrate=");
        stringBuilder.append(n);
        stringBuilder.append(", metadataInterval=");
        stringBuilder.append(n2);
        return stringBuilder.toString();
    }

    public final void writeToParcel(Parcel parcel, int n) {
        parcel.writeInt(this.zza);
        parcel.writeString(this.zzb);
        parcel.writeString(this.zzc);
        parcel.writeString(this.zzd);
        zzamq.zzo((Parcel)parcel, (boolean)this.zze);
        parcel.writeInt(this.zzf);
    }

    public final void zza(zzagm zzagm2) {
    }
}
