/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.os.IBinder
 *  android.os.Parcel
 *  android.os.Parcelable$Creator
 *  com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable
 *  com.google.android.gms.common.internal.safeparcel.SafeParcelWriter
 *  com.google.android.gms.common.zzo
 *  com.google.android.gms.dynamic.IObjectWrapper
 *  com.google.android.gms.dynamic.IObjectWrapper$Stub
 *  com.google.android.gms.dynamic.ObjectWrapper
 */
package com.google.android.gms.common;

import android.content.Context;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.zzo;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;

public final class zzn
extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzn> CREATOR = new zzo();
    private final String zza;
    private final boolean zzb;
    private final boolean zzc;
    private final Context zzd;
    private final boolean zze;

    zzn(String string, boolean bl, boolean bl2, IBinder iBinder, boolean bl3) {
        this.zza = string;
        this.zzb = bl;
        this.zzc = bl2;
        this.zzd = (Context)ObjectWrapper.unwrap((IObjectWrapper)IObjectWrapper.Stub.asInterface((IBinder)iBinder));
        this.zze = bl3;
    }

    public final void writeToParcel(Parcel parcel, int n) {
        n = SafeParcelWriter.beginObjectHeader((Parcel)parcel);
        SafeParcelWriter.writeString((Parcel)parcel, (int)1, (String)this.zza, (boolean)false);
        SafeParcelWriter.writeBoolean((Parcel)parcel, (int)2, (boolean)this.zzb);
        SafeParcelWriter.writeBoolean((Parcel)parcel, (int)3, (boolean)this.zzc);
        SafeParcelWriter.writeIBinder((Parcel)parcel, (int)4, (IBinder)ObjectWrapper.wrap((Object)this.zzd), (boolean)false);
        SafeParcelWriter.writeBoolean((Parcel)parcel, (int)5, (boolean)this.zze);
        SafeParcelWriter.finishObjectHeader((Parcel)parcel, (int)n);
    }
}
