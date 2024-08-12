/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.os.Parcel
 *  android.os.Parcelable$Creator
 *  com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable
 *  com.google.android.gms.common.internal.safeparcel.SafeParcelWriter
 *  com.google.android.gms.internal.ads.zzbet
 *  com.google.android.gms.internal.ads.zzbjd
 *  com.google.android.gms.internal.ads.zzbjl
 *  com.google.android.gms.internal.ads.zzfcg
 *  com.google.android.gms.internal.ads.zzfch
 *  com.google.android.gms.internal.ads.zzfci
 *  com.google.android.gms.internal.ads.zzfck
 */
package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.internal.ads.zzbet;
import com.google.android.gms.internal.ads.zzbjd;
import com.google.android.gms.internal.ads.zzbjl;
import com.google.android.gms.internal.ads.zzfcg;
import com.google.android.gms.internal.ads.zzfch;
import com.google.android.gms.internal.ads.zzfci;
import com.google.android.gms.internal.ads.zzfck;
import javax.annotation.Nullable;
import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
public final class zzfcj
extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzfcj> CREATOR = new zzfck();
    @Nullable
    public final Context zza;
    public final zzfcg zzb;
    public final int zzc;
    public final int zzd;
    public final int zze;
    public final String zzf;
    public final int zzg;
    private final zzfcg[] zzh = zzfcg.values();
    private final int zzi;
    private final int zzj;
    private final int zzk;
    private final int[] zzl = zzfch.zza();
    private final int[] zzm;

    public zzfcj(int n, int n2, int n3, int n4, String string, int n5, int n6) {
        int[] nArray = zzfci.zza();
        this.zzm = nArray;
        this.zza = null;
        this.zzi = n;
        this.zzb = this.zzh[n];
        this.zzc = n2;
        this.zzd = n3;
        this.zze = n4;
        this.zzf = string;
        this.zzj = n5;
        this.zzg = this.zzl[n5];
        this.zzk = n6;
        n = nArray[n6];
    }

    private zzfcj(@Nullable Context context, zzfcg zzfcg2, int n, int n2, int n3, String string, String string2, String string3) {
        this.zzm = zzfci.zza();
        this.zza = context;
        this.zzi = zzfcg2.ordinal();
        this.zzb = zzfcg2;
        this.zzc = n;
        this.zzd = n2;
        this.zze = n3;
        this.zzf = string;
        boolean bl = "oldest".equals(string2);
        n = 2;
        if (bl) {
            n = 1;
        } else if (!"lru".equals(string2) && "lfu".equals(string2)) {
            n = 3;
        }
        this.zzg = n;
        this.zzj = n - 1;
        "onAdClosed".equals(string3);
        this.zzk = 0;
    }

    public static zzfcj zza(zzfcg zzfcg2, Context context) {
        if (zzfcg2 == zzfcg.zza) {
            Object object = zzbjl.zzeH;
            int n = (Integer)zzbet.zzc().zzc(object);
            object = zzbjl.zzeN;
            int n2 = (Integer)zzbet.zzc().zzc(object);
            object = zzbjl.zzeP;
            int n3 = (Integer)zzbet.zzc().zzc(object);
            object = zzbjl.zzeR;
            object = (String)zzbet.zzc().zzc(object);
            zzbjd zzbjd2 = zzbjl.zzeJ;
            String string = (String)zzbet.zzc().zzc(zzbjd2);
            zzbjd2 = zzbjl.zzeL;
            return new zzfcj(context, zzfcg2, n, n2, n3, (String)object, string, (String)zzbet.zzc().zzc(zzbjd2));
        }
        if (zzfcg2 == zzfcg.zzb) {
            Object object = zzbjl.zzeI;
            int n = (Integer)zzbet.zzc().zzc(object);
            object = zzbjl.zzeO;
            int n4 = (Integer)zzbet.zzc().zzc(object);
            object = zzbjl.zzeQ;
            int n5 = (Integer)zzbet.zzc().zzc(object);
            object = zzbjl.zzeS;
            object = (String)zzbet.zzc().zzc(object);
            Object object2 = zzbjl.zzeK;
            object2 = (String)zzbet.zzc().zzc(object2);
            zzbjd zzbjd3 = zzbjl.zzeM;
            return new zzfcj(context, zzfcg2, n, n4, n5, (String)object, (String)object2, (String)zzbet.zzc().zzc(zzbjd3));
        }
        if (zzfcg2 != zzfcg.zzc) return null;
        Object object = zzbjl.zzeV;
        int n = (Integer)zzbet.zzc().zzc(object);
        object = zzbjl.zzeX;
        int n6 = (Integer)zzbet.zzc().zzc(object);
        object = zzbjl.zzeY;
        int n7 = (Integer)zzbet.zzc().zzc(object);
        object = zzbjl.zzeT;
        object = (String)zzbet.zzc().zzc(object);
        Object object3 = zzbjl.zzeU;
        object3 = (String)zzbet.zzc().zzc(object3);
        zzbjd zzbjd4 = zzbjl.zzeW;
        return new zzfcj(context, zzfcg2, n, n6, n7, (String)object, (String)object3, (String)zzbet.zzc().zzc(zzbjd4));
    }

    public final void writeToParcel(Parcel parcel, int n) {
        n = SafeParcelWriter.beginObjectHeader((Parcel)parcel);
        SafeParcelWriter.writeInt((Parcel)parcel, (int)1, (int)this.zzi);
        SafeParcelWriter.writeInt((Parcel)parcel, (int)2, (int)this.zzc);
        SafeParcelWriter.writeInt((Parcel)parcel, (int)3, (int)this.zzd);
        SafeParcelWriter.writeInt((Parcel)parcel, (int)4, (int)this.zze);
        SafeParcelWriter.writeString((Parcel)parcel, (int)5, (String)this.zzf, (boolean)false);
        SafeParcelWriter.writeInt((Parcel)parcel, (int)6, (int)this.zzj);
        SafeParcelWriter.writeInt((Parcel)parcel, (int)7, (int)this.zzk);
        SafeParcelWriter.finishObjectHeader((Parcel)parcel, (int)n);
    }
}
