/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.pm.ApplicationInfo
 *  android.content.pm.PackageInfo
 *  android.os.Bundle
 *  android.os.Parcel
 *  android.os.Parcelable
 *  android.os.Parcelable$Creator
 *  com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable
 *  com.google.android.gms.common.internal.safeparcel.SafeParcelWriter
 *  com.google.android.gms.internal.ads.zzbdg
 *  com.google.android.gms.internal.ads.zzbdl
 *  com.google.android.gms.internal.ads.zzbhg
 *  com.google.android.gms.internal.ads.zzblv
 *  com.google.android.gms.internal.ads.zzbrx
 *  com.google.android.gms.internal.ads.zzcaw
 *  com.google.android.gms.internal.ads.zzcgz
 */
package com.google.android.gms.internal.ads;

import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.internal.ads.zzbdg;
import com.google.android.gms.internal.ads.zzbdl;
import com.google.android.gms.internal.ads.zzbhg;
import com.google.android.gms.internal.ads.zzblv;
import com.google.android.gms.internal.ads.zzbrx;
import com.google.android.gms.internal.ads.zzcaw;
import com.google.android.gms.internal.ads.zzcgz;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
public final class zzcav
extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzcav> CREATOR = new zzcaw();
    public final long zzA;
    public final String zzB;
    public final float zzC;
    public final int zzD;
    public final int zzE;
    public final boolean zzF;
    public final String zzG;
    public final boolean zzH;
    public final String zzI;
    public final boolean zzJ;
    public final int zzK;
    public final Bundle zzL;
    public final String zzM;
    public final zzbhg zzN;
    public final boolean zzO;
    public final Bundle zzP;
    public final String zzQ;
    public final String zzR;
    public final String zzS;
    public final boolean zzT;
    public final List<Integer> zzU;
    public final String zzV;
    public final List<String> zzW;
    public final int zzX;
    public final boolean zzY;
    public final boolean zzZ;
    public final int zza;
    public final boolean zzaa;
    public final ArrayList<String> zzab;
    public final String zzac;
    public final zzbrx zzad;
    public final String zzae;
    public final Bundle zzaf;
    public final Bundle zzb;
    public final zzbdg zzc;
    public final zzbdl zzd;
    public final String zze;
    public final ApplicationInfo zzf;
    public final PackageInfo zzg;
    public final String zzh;
    public final String zzi;
    public final String zzj;
    public final zzcgz zzk;
    public final Bundle zzl;
    public final int zzm;
    public final List<String> zzn;
    public final Bundle zzo;
    public final boolean zzp;
    public final int zzq;
    public final int zzr;
    public final float zzs;
    public final String zzt;
    public final long zzu;
    public final String zzv;
    public final List<String> zzw;
    public final String zzx;
    public final zzblv zzy;
    public final List<String> zzz;

    zzcav(int n, Bundle object, zzbdg zzbdg2, zzbdl zzbdl2, String string, ApplicationInfo applicationInfo, PackageInfo packageInfo, String string2, String string3, String string4, zzcgz zzcgz2, Bundle bundle, int n2, List<String> list, Bundle bundle2, boolean bl, int n3, int n4, float f, String string5, long l, String string6, List<String> list2, String string7, zzblv zzblv2, List<String> list3, long l2, String string8, float f2, boolean bl2, int n5, int n6, boolean bl3, String string9, String string10, boolean bl4, int n7, Bundle bundle3, String string11, zzbhg zzbhg2, boolean bl5, Bundle bundle4, String string12, String string13, String string14, boolean bl6, List<Integer> list4, String string15, List<String> list5, int n8, boolean bl7, boolean bl8, boolean bl9, ArrayList<String> arrayList, String string16, zzbrx zzbrx2, String string17, Bundle bundle5) {
        this.zza = n;
        this.zzb = object;
        this.zzc = zzbdg2;
        this.zzd = zzbdl2;
        this.zze = string;
        this.zzf = applicationInfo;
        this.zzg = packageInfo;
        this.zzh = string2;
        this.zzi = string3;
        this.zzj = string4;
        this.zzk = zzcgz2;
        this.zzl = bundle;
        this.zzm = n2;
        this.zzn = list;
        object = list3 == null ? Collections.emptyList() : Collections.unmodifiableList(list3);
        this.zzz = object;
        this.zzo = bundle2;
        this.zzp = bl;
        this.zzq = n3;
        this.zzr = n4;
        this.zzs = f;
        this.zzt = string5;
        this.zzu = l;
        this.zzv = string6;
        object = list2 == null ? Collections.emptyList() : Collections.unmodifiableList(list2);
        this.zzw = object;
        this.zzx = string7;
        this.zzy = zzblv2;
        this.zzA = l2;
        this.zzB = string8;
        this.zzC = f2;
        this.zzH = bl2;
        this.zzD = n5;
        this.zzE = n6;
        this.zzF = bl3;
        this.zzG = string9;
        this.zzI = string10;
        this.zzJ = bl4;
        this.zzK = n7;
        this.zzL = bundle3;
        this.zzM = string11;
        this.zzN = zzbhg2;
        this.zzO = bl5;
        this.zzP = bundle4;
        this.zzQ = string12;
        this.zzR = string13;
        this.zzS = string14;
        this.zzT = bl6;
        this.zzU = list4;
        this.zzV = string15;
        this.zzW = list5;
        this.zzX = n8;
        this.zzY = bl7;
        this.zzZ = bl8;
        this.zzaa = bl9;
        this.zzab = arrayList;
        this.zzac = string16;
        this.zzad = zzbrx2;
        this.zzae = string17;
        this.zzaf = bundle5;
    }

    public final void writeToParcel(Parcel parcel, int n) {
        int n2 = SafeParcelWriter.beginObjectHeader((Parcel)parcel);
        SafeParcelWriter.writeInt((Parcel)parcel, (int)1, (int)this.zza);
        SafeParcelWriter.writeBundle((Parcel)parcel, (int)2, (Bundle)this.zzb, (boolean)false);
        SafeParcelWriter.writeParcelable((Parcel)parcel, (int)3, (Parcelable)this.zzc, (int)n, (boolean)false);
        SafeParcelWriter.writeParcelable((Parcel)parcel, (int)4, (Parcelable)this.zzd, (int)n, (boolean)false);
        SafeParcelWriter.writeString((Parcel)parcel, (int)5, (String)this.zze, (boolean)false);
        SafeParcelWriter.writeParcelable((Parcel)parcel, (int)6, (Parcelable)this.zzf, (int)n, (boolean)false);
        SafeParcelWriter.writeParcelable((Parcel)parcel, (int)7, (Parcelable)this.zzg, (int)n, (boolean)false);
        SafeParcelWriter.writeString((Parcel)parcel, (int)8, (String)this.zzh, (boolean)false);
        SafeParcelWriter.writeString((Parcel)parcel, (int)9, (String)this.zzi, (boolean)false);
        SafeParcelWriter.writeString((Parcel)parcel, (int)10, (String)this.zzj, (boolean)false);
        SafeParcelWriter.writeParcelable((Parcel)parcel, (int)11, (Parcelable)this.zzk, (int)n, (boolean)false);
        SafeParcelWriter.writeBundle((Parcel)parcel, (int)12, (Bundle)this.zzl, (boolean)false);
        SafeParcelWriter.writeInt((Parcel)parcel, (int)13, (int)this.zzm);
        SafeParcelWriter.writeStringList((Parcel)parcel, (int)14, this.zzn, (boolean)false);
        SafeParcelWriter.writeBundle((Parcel)parcel, (int)15, (Bundle)this.zzo, (boolean)false);
        SafeParcelWriter.writeBoolean((Parcel)parcel, (int)16, (boolean)this.zzp);
        SafeParcelWriter.writeInt((Parcel)parcel, (int)18, (int)this.zzq);
        SafeParcelWriter.writeInt((Parcel)parcel, (int)19, (int)this.zzr);
        SafeParcelWriter.writeFloat((Parcel)parcel, (int)20, (float)this.zzs);
        SafeParcelWriter.writeString((Parcel)parcel, (int)21, (String)this.zzt, (boolean)false);
        SafeParcelWriter.writeLong((Parcel)parcel, (int)25, (long)this.zzu);
        SafeParcelWriter.writeString((Parcel)parcel, (int)26, (String)this.zzv, (boolean)false);
        SafeParcelWriter.writeStringList((Parcel)parcel, (int)27, this.zzw, (boolean)false);
        SafeParcelWriter.writeString((Parcel)parcel, (int)28, (String)this.zzx, (boolean)false);
        SafeParcelWriter.writeParcelable((Parcel)parcel, (int)29, (Parcelable)this.zzy, (int)n, (boolean)false);
        SafeParcelWriter.writeStringList((Parcel)parcel, (int)30, this.zzz, (boolean)false);
        SafeParcelWriter.writeLong((Parcel)parcel, (int)31, (long)this.zzA);
        SafeParcelWriter.writeString((Parcel)parcel, (int)33, (String)this.zzB, (boolean)false);
        SafeParcelWriter.writeFloat((Parcel)parcel, (int)34, (float)this.zzC);
        SafeParcelWriter.writeInt((Parcel)parcel, (int)35, (int)this.zzD);
        SafeParcelWriter.writeInt((Parcel)parcel, (int)36, (int)this.zzE);
        SafeParcelWriter.writeBoolean((Parcel)parcel, (int)37, (boolean)this.zzF);
        SafeParcelWriter.writeString((Parcel)parcel, (int)39, (String)this.zzG, (boolean)false);
        SafeParcelWriter.writeBoolean((Parcel)parcel, (int)40, (boolean)this.zzH);
        SafeParcelWriter.writeString((Parcel)parcel, (int)41, (String)this.zzI, (boolean)false);
        SafeParcelWriter.writeBoolean((Parcel)parcel, (int)42, (boolean)this.zzJ);
        SafeParcelWriter.writeInt((Parcel)parcel, (int)43, (int)this.zzK);
        SafeParcelWriter.writeBundle((Parcel)parcel, (int)44, (Bundle)this.zzL, (boolean)false);
        SafeParcelWriter.writeString((Parcel)parcel, (int)45, (String)this.zzM, (boolean)false);
        SafeParcelWriter.writeParcelable((Parcel)parcel, (int)46, (Parcelable)this.zzN, (int)n, (boolean)false);
        SafeParcelWriter.writeBoolean((Parcel)parcel, (int)47, (boolean)this.zzO);
        SafeParcelWriter.writeBundle((Parcel)parcel, (int)48, (Bundle)this.zzP, (boolean)false);
        SafeParcelWriter.writeString((Parcel)parcel, (int)49, (String)this.zzQ, (boolean)false);
        SafeParcelWriter.writeString((Parcel)parcel, (int)50, (String)this.zzR, (boolean)false);
        SafeParcelWriter.writeString((Parcel)parcel, (int)51, (String)this.zzS, (boolean)false);
        SafeParcelWriter.writeBoolean((Parcel)parcel, (int)52, (boolean)this.zzT);
        SafeParcelWriter.writeIntegerList((Parcel)parcel, (int)53, this.zzU, (boolean)false);
        SafeParcelWriter.writeString((Parcel)parcel, (int)54, (String)this.zzV, (boolean)false);
        SafeParcelWriter.writeStringList((Parcel)parcel, (int)55, this.zzW, (boolean)false);
        SafeParcelWriter.writeInt((Parcel)parcel, (int)56, (int)this.zzX);
        SafeParcelWriter.writeBoolean((Parcel)parcel, (int)57, (boolean)this.zzY);
        SafeParcelWriter.writeBoolean((Parcel)parcel, (int)58, (boolean)this.zzZ);
        SafeParcelWriter.writeBoolean((Parcel)parcel, (int)59, (boolean)this.zzaa);
        SafeParcelWriter.writeStringList((Parcel)parcel, (int)60, this.zzab, (boolean)false);
        SafeParcelWriter.writeString((Parcel)parcel, (int)61, (String)this.zzac, (boolean)false);
        SafeParcelWriter.writeParcelable((Parcel)parcel, (int)63, (Parcelable)this.zzad, (int)n, (boolean)false);
        SafeParcelWriter.writeString((Parcel)parcel, (int)64, (String)this.zzae, (boolean)false);
        SafeParcelWriter.writeBundle((Parcel)parcel, (int)65, (Bundle)this.zzaf, (boolean)false);
        SafeParcelWriter.finishObjectHeader((Parcel)parcel, (int)n2);
    }
}
