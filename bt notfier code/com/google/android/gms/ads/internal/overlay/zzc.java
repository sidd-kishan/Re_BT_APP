/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Intent
 *  android.os.IBinder
 *  android.os.Parcel
 *  android.os.Parcelable
 *  android.os.Parcelable$Creator
 *  com.google.android.gms.ads.internal.overlay.zzb
 *  com.google.android.gms.ads.internal.overlay.zzt
 *  com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable
 *  com.google.android.gms.common.internal.safeparcel.SafeParcelWriter
 *  com.google.android.gms.dynamic.IObjectWrapper
 *  com.google.android.gms.dynamic.IObjectWrapper$Stub
 *  com.google.android.gms.dynamic.ObjectWrapper
 */
package com.google.android.gms.ads.internal.overlay;

import android.content.Intent;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.ads.internal.overlay.zzb;
import com.google.android.gms.ads.internal.overlay.zzt;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;

public final class zzc
extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzc> CREATOR = new zzb();
    public final String zza;
    public final String zzb;
    public final String zzc;
    public final String zzd;
    public final String zze;
    public final String zzf;
    public final String zzg;
    public final Intent zzh;
    public final zzt zzi;
    public final boolean zzj;

    public zzc(Intent intent, zzt zzt2) {
        this(null, null, null, null, null, null, null, intent, ObjectWrapper.wrap((Object)zzt2).asBinder(), false);
    }

    public zzc(String string, String string2, String string3, String string4, String string5, String string6, String string7, Intent intent, IBinder iBinder, boolean bl) {
        this.zza = string;
        this.zzb = string2;
        this.zzc = string3;
        this.zzd = string4;
        this.zze = string5;
        this.zzf = string6;
        this.zzg = string7;
        this.zzh = intent;
        this.zzi = (zzt)ObjectWrapper.unwrap((IObjectWrapper)IObjectWrapper.Stub.asInterface((IBinder)iBinder));
        this.zzj = bl;
    }

    public zzc(String string, String string2, String string3, String string4, String string5, String string6, String string7, zzt zzt2) {
        this(string, string2, string3, string4, string5, string6, string7, null, ObjectWrapper.wrap((Object)zzt2).asBinder(), false);
    }

    public final void writeToParcel(Parcel parcel, int n) {
        int n2 = SafeParcelWriter.beginObjectHeader((Parcel)parcel);
        SafeParcelWriter.writeString((Parcel)parcel, (int)2, (String)this.zza, (boolean)false);
        SafeParcelWriter.writeString((Parcel)parcel, (int)3, (String)this.zzb, (boolean)false);
        SafeParcelWriter.writeString((Parcel)parcel, (int)4, (String)this.zzc, (boolean)false);
        SafeParcelWriter.writeString((Parcel)parcel, (int)5, (String)this.zzd, (boolean)false);
        SafeParcelWriter.writeString((Parcel)parcel, (int)6, (String)this.zze, (boolean)false);
        SafeParcelWriter.writeString((Parcel)parcel, (int)7, (String)this.zzf, (boolean)false);
        SafeParcelWriter.writeString((Parcel)parcel, (int)8, (String)this.zzg, (boolean)false);
        SafeParcelWriter.writeParcelable((Parcel)parcel, (int)9, (Parcelable)this.zzh, (int)n, (boolean)false);
        SafeParcelWriter.writeIBinder((Parcel)parcel, (int)10, (IBinder)ObjectWrapper.wrap((Object)this.zzi).asBinder(), (boolean)false);
        SafeParcelWriter.writeBoolean((Parcel)parcel, (int)11, (boolean)this.zzj);
        SafeParcelWriter.finishObjectHeader((Parcel)parcel, (int)n2);
    }
}
