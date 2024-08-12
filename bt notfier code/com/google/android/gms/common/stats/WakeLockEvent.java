/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Parcel
 *  android.os.Parcelable$Creator
 *  android.text.TextUtils
 *  com.google.android.gms.common.internal.safeparcel.SafeParcelWriter
 *  com.google.android.gms.common.stats.StatsEvent
 *  com.google.android.gms.common.stats.zza
 */
package com.google.android.gms.common.stats;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.stats.StatsEvent;
import com.google.android.gms.common.stats.zza;
import java.util.List;
import javax.annotation.Nullable;

@Deprecated
public final class WakeLockEvent
extends StatsEvent {
    public static final Parcelable.Creator<WakeLockEvent> CREATOR = new zza();
    final int zza;
    private final long zzb;
    private int zzc;
    private final String zzd;
    private final String zze;
    private final String zzf;
    private final int zzg;
    @Nullable
    private final List<String> zzh;
    private final String zzi;
    private final long zzj;
    private int zzk;
    private final String zzl;
    private final float zzm;
    private final long zzn;
    private final boolean zzo;
    private long zzp;

    WakeLockEvent(int n, long l, int n2, String string, int n3, @Nullable List<String> list, String string2, long l2, int n4, String string3, String string4, float f, long l3, String string5, boolean bl) {
        this.zza = n;
        this.zzb = l;
        this.zzc = n2;
        this.zzd = string;
        this.zze = string3;
        this.zzf = string5;
        this.zzg = n3;
        this.zzp = -1L;
        this.zzh = list;
        this.zzi = string2;
        this.zzj = l2;
        this.zzk = n4;
        this.zzl = string4;
        this.zzm = f;
        this.zzn = l3;
        this.zzo = bl;
    }

    public final void writeToParcel(Parcel parcel, int n) {
        n = SafeParcelWriter.beginObjectHeader((Parcel)parcel);
        SafeParcelWriter.writeInt((Parcel)parcel, (int)1, (int)this.zza);
        SafeParcelWriter.writeLong((Parcel)parcel, (int)2, (long)this.zzb);
        SafeParcelWriter.writeString((Parcel)parcel, (int)4, (String)this.zzd, (boolean)false);
        SafeParcelWriter.writeInt((Parcel)parcel, (int)5, (int)this.zzg);
        SafeParcelWriter.writeStringList((Parcel)parcel, (int)6, this.zzh, (boolean)false);
        SafeParcelWriter.writeLong((Parcel)parcel, (int)8, (long)this.zzj);
        SafeParcelWriter.writeString((Parcel)parcel, (int)10, (String)this.zze, (boolean)false);
        SafeParcelWriter.writeInt((Parcel)parcel, (int)11, (int)this.zzc);
        SafeParcelWriter.writeString((Parcel)parcel, (int)12, (String)this.zzi, (boolean)false);
        SafeParcelWriter.writeString((Parcel)parcel, (int)13, (String)this.zzl, (boolean)false);
        SafeParcelWriter.writeInt((Parcel)parcel, (int)14, (int)this.zzk);
        SafeParcelWriter.writeFloat((Parcel)parcel, (int)15, (float)this.zzm);
        SafeParcelWriter.writeLong((Parcel)parcel, (int)16, (long)this.zzn);
        SafeParcelWriter.writeString((Parcel)parcel, (int)17, (String)this.zzf, (boolean)false);
        SafeParcelWriter.writeBoolean((Parcel)parcel, (int)18, (boolean)this.zzo);
        SafeParcelWriter.finishObjectHeader((Parcel)parcel, (int)n);
    }

    public final long zza() {
        return this.zzb;
    }

    public final int zzb() {
        return this.zzc;
    }

    public final long zzc() {
        return this.zzp;
    }

    public final String zzd() {
        String string;
        Object object = this.zzh;
        String string2 = this.zzd;
        int n = this.zzg;
        String string3 = "";
        object = object == null ? "" : TextUtils.join((CharSequence)",", (Iterable)object);
        int n2 = this.zzk;
        String string4 = string = this.zze;
        if (string == null) {
            string4 = "";
        }
        CharSequence charSequence = this.zzl;
        string = charSequence;
        if (charSequence == null) {
            string = "";
        }
        float f = this.zzm;
        charSequence = this.zzf;
        if (charSequence != null) {
            string3 = charSequence;
        }
        boolean bl = this.zzo;
        charSequence = new StringBuilder(String.valueOf(string2).length() + 51 + String.valueOf(object).length() + string4.length() + string.length() + string3.length());
        ((StringBuilder)charSequence).append("\t");
        ((StringBuilder)charSequence).append(string2);
        ((StringBuilder)charSequence).append("\t");
        ((StringBuilder)charSequence).append(n);
        ((StringBuilder)charSequence).append("\t");
        ((StringBuilder)charSequence).append((String)object);
        ((StringBuilder)charSequence).append("\t");
        ((StringBuilder)charSequence).append(n2);
        ((StringBuilder)charSequence).append("\t");
        ((StringBuilder)charSequence).append(string4);
        ((StringBuilder)charSequence).append("\t");
        ((StringBuilder)charSequence).append(string);
        ((StringBuilder)charSequence).append("\t");
        ((StringBuilder)charSequence).append(f);
        ((StringBuilder)charSequence).append("\t");
        ((StringBuilder)charSequence).append(string3);
        ((StringBuilder)charSequence).append("\t");
        ((StringBuilder)charSequence).append(bl);
        return ((StringBuilder)charSequence).toString();
    }
}
