/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.common.internal.Preconditions
 *  com.google.android.gms.common.zzz
 *  com.google.android.gms.internal.common.zzu
 */
package com.google.android.gms.common;

import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.zzz;
import com.google.android.gms.internal.common.zzu;
import java.util.List;

final class zzy {
    private String zza = null;
    private long zzb = -1L;
    private zzu<byte[]> zzc = zzu.zzi();
    private zzu<byte[]> zzd = zzu.zzi();

    zzy() {
    }

    final zzy zza(String string) {
        this.zza = string;
        return this;
    }

    final zzy zzb(long l) {
        this.zzb = l;
        return this;
    }

    final zzy zzc(List<byte[]> list) {
        Preconditions.checkNotNull(list);
        this.zzc = zzu.zzm(list);
        return this;
    }

    final zzy zzd(List<byte[]> list) {
        Preconditions.checkNotNull(list);
        this.zzd = zzu.zzm(list);
        return this;
    }

    final zzz zze() {
        if (this.zza == null) throw new IllegalStateException("packageName must be defined");
        if (this.zzb < 0L) throw new IllegalStateException("minimumStampedVersionNumber must be greater than or equal to 0");
        if (!this.zzc.isEmpty()) return new zzz(this.zza, this.zzb, this.zzc, this.zzd, null);
        if (this.zzd.isEmpty()) throw new IllegalStateException("Either orderedTestCerts or orderedProdCerts must have at least one cert");
        return new zzz(this.zza, this.zzb, this.zzc, this.zzd, null);
    }
}
