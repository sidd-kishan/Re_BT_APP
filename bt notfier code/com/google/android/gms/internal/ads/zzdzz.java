/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.ParcelFileDescriptor
 *  android.os.ParcelFileDescriptor$AutoCloseInputStream
 *  com.google.android.gms.ads.internal.util.zzbb
 *  com.google.android.gms.ads.internal.util.zzbc
 *  com.google.android.gms.internal.ads.zzcbe
 *  com.google.android.gms.internal.ads.zzeaa
 */
package com.google.android.gms.internal.ads;

import android.os.ParcelFileDescriptor;
import com.google.android.gms.ads.internal.util.zzbb;
import com.google.android.gms.ads.internal.util.zzbc;
import com.google.android.gms.internal.ads.zzcbe;
import com.google.android.gms.internal.ads.zzeaa;

public final class zzdzz
extends zzcbe {
    final zzeaa zza;

    protected zzdzz(zzeaa zzeaa2) {
        this.zza = zzeaa2;
    }

    public final void zze(ParcelFileDescriptor parcelFileDescriptor) {
        this.zza.zza.zzc((Object)new ParcelFileDescriptor.AutoCloseInputStream(parcelFileDescriptor));
    }

    public final void zzf(zzbc zzbc2) {
        this.zza.zza.zzd((Throwable)new zzbb(zzbc2.zza, zzbc2.zzb));
    }
}
