/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Parcel
 *  android.os.Parcelable$Creator
 *  com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable
 *  com.google.android.gms.common.internal.safeparcel.SafeParcelWriter
 *  com.google.android.gms.internal.ads.zzfjt
 *  com.google.android.gms.internal.ads.zzgfm
 *  com.google.android.gms.internal.ads.zzggm
 *  com.google.android.gms.internal.ads.zzyz
 */
package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.internal.ads.zzfjt;
import com.google.android.gms.internal.ads.zzgfm;
import com.google.android.gms.internal.ads.zzggm;
import com.google.android.gms.internal.ads.zzyz;

public final class zzfjs
extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzfjs> CREATOR = new zzfjt();
    public final int zza;
    private zzyz zzb;
    private byte[] zzc;

    zzfjs(int n, byte[] byArray) {
        this.zza = n;
        this.zzb = null;
        this.zzc = byArray;
        this.zzb();
    }

    private final void zzb() {
        zzyz zzyz2 = this.zzb;
        if (zzyz2 == null) {
            if (this.zzc != null) return;
        }
        if (zzyz2 != null) {
            if (this.zzc == null) return;
        }
        if (zzyz2 != null) {
            if (this.zzc != null) throw new IllegalStateException("Invalid internal representation - full");
        }
        if (zzyz2 != null) throw new IllegalStateException("Impossible");
        if (this.zzc != null) throw new IllegalStateException("Impossible");
        throw new IllegalStateException("Invalid internal representation - empty");
    }

    public final void writeToParcel(Parcel parcel, int n) {
        n = SafeParcelWriter.beginObjectHeader((Parcel)parcel);
        SafeParcelWriter.writeInt((Parcel)parcel, (int)1, (int)this.zza);
        byte[] byArray = this.zzc;
        if (byArray == null) {
            byArray = this.zzb.zzao();
        }
        SafeParcelWriter.writeByteArray((Parcel)parcel, (int)2, (byte[])byArray, (boolean)false);
        SafeParcelWriter.finishObjectHeader((Parcel)parcel, (int)n);
    }

    /*
     * WARNING - void declaration
     */
    public final zzyz zza() {
        block4: {
            if (this.zzb == null) {
                void var1_3;
                try {
                    this.zzb = zzyz.zzh((byte[])this.zzc, (zzgfm)zzgfm.zza());
                    this.zzc = null;
                    break block4;
                }
                catch (NullPointerException nullPointerException) {
                }
                catch (zzggm zzggm2) {
                    // empty catch block
                }
                throw new IllegalStateException((Throwable)var1_3);
            }
        }
        this.zzb();
        return this.zzb;
    }
}
