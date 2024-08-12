/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Parcel
 *  android.os.ParcelFileDescriptor
 *  android.os.ParcelFileDescriptor$AutoCloseInputStream
 *  android.os.Parcelable
 *  android.os.Parcelable$Creator
 *  com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable
 *  com.google.android.gms.common.internal.safeparcel.SafeParcelWriter
 *  com.google.android.gms.internal.ads.zzayl
 */
package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.internal.ads.zzayl;
import java.io.InputStream;

public final class zzayk
extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzayk> CREATOR = new zzayl();
    private ParcelFileDescriptor zza;
    private final boolean zzb;
    private final boolean zzc;
    private final long zzd;
    private final boolean zze;

    public zzayk() {
        this(null, false, false, 0L, false);
    }

    public zzayk(ParcelFileDescriptor parcelFileDescriptor, boolean bl, boolean bl2, long l, boolean bl3) {
        this.zza = parcelFileDescriptor;
        this.zzb = bl;
        this.zzc = bl2;
        this.zzd = l;
        this.zze = bl3;
    }

    public final void writeToParcel(Parcel parcel, int n) {
        int n2 = SafeParcelWriter.beginObjectHeader((Parcel)parcel);
        SafeParcelWriter.writeParcelable((Parcel)parcel, (int)2, (Parcelable)this.zzc(), (int)n, (boolean)false);
        SafeParcelWriter.writeBoolean((Parcel)parcel, (int)3, (boolean)this.zzd());
        SafeParcelWriter.writeBoolean((Parcel)parcel, (int)4, (boolean)this.zze());
        SafeParcelWriter.writeLong((Parcel)parcel, (int)5, (long)this.zzf());
        SafeParcelWriter.writeBoolean((Parcel)parcel, (int)6, (boolean)this.zzg());
        SafeParcelWriter.finishObjectHeader((Parcel)parcel, (int)n2);
    }

    public final boolean zza() {
        synchronized (this) {
            ParcelFileDescriptor parcelFileDescriptor = this.zza;
            boolean bl = parcelFileDescriptor != null;
            return bl;
        }
    }

    /*
     * Enabled unnecessary exception pruning
     */
    public final InputStream zzb() {
        synchronized (this) {
            ParcelFileDescriptor parcelFileDescriptor = this.zza;
            if (parcelFileDescriptor == null) {
                return null;
            }
            ParcelFileDescriptor.AutoCloseInputStream autoCloseInputStream = new ParcelFileDescriptor.AutoCloseInputStream(parcelFileDescriptor);
            this.zza = null;
            return autoCloseInputStream;
        }
    }

    final ParcelFileDescriptor zzc() {
        synchronized (this) {
            ParcelFileDescriptor parcelFileDescriptor = this.zza;
            return parcelFileDescriptor;
        }
    }

    public final boolean zzd() {
        synchronized (this) {
            boolean bl = this.zzb;
            return bl;
        }
    }

    public final boolean zze() {
        synchronized (this) {
            boolean bl = this.zzc;
            return bl;
        }
    }

    public final long zzf() {
        synchronized (this) {
            long l = this.zzd;
            return l;
        }
    }

    public final boolean zzg() {
        synchronized (this) {
            boolean bl = this.zze;
            return bl;
        }
    }
}
