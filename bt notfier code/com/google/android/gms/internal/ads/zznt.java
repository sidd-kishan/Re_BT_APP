/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzafv
 *  com.google.android.gms.internal.ads.zzah
 *  com.google.android.gms.internal.ads.zzamf
 *  com.google.android.gms.internal.ads.zzov
 *  com.google.android.gms.internal.ads.zzow
 *  com.google.android.gms.internal.ads.zzox
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzafv;
import com.google.android.gms.internal.ads.zzah;
import com.google.android.gms.internal.ads.zzamf;
import com.google.android.gms.internal.ads.zzov;
import com.google.android.gms.internal.ads.zzow;
import com.google.android.gms.internal.ads.zzox;
import java.io.EOFException;
import java.io.IOException;

public final class zznt
implements zzox {
    private final byte[] zza = new byte[4096];

    public final void zzs(zzafv zzafv2) {
    }

    public final int zzt(zzah zzah2, int n, boolean bl, int n2) throws IOException {
        n = Math.min(4096, n);
        if ((n = zzah2.zzg(this.zza, 0, n)) != -1) return n;
        if (!bl) throw new EOFException();
        return -1;
    }

    public final void zzu(zzamf zzamf2, int n, int n2) {
        zzamf2.zzk(n);
    }

    public final void zzv(long l, int n, int n2, int n3, zzow zzow2) {
    }

    public final int zzx(zzah zzah2, int n, boolean bl) throws IOException {
        return zzov.zza((zzox)this, (zzah)zzah2, (int)n, (boolean)true);
    }

    public final void zzy(zzamf zzamf2, int n) {
        zzov.zzb((zzox)this, (zzamf)zzamf2, (int)n);
    }
}
