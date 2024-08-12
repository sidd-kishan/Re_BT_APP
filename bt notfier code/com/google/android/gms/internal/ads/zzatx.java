/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.net.Uri
 *  com.google.android.gms.internal.ads.zzatz
 *  com.google.android.gms.internal.ads.zzaub
 *  com.google.android.gms.internal.ads.zzaup
 */
package com.google.android.gms.internal.ads;

import android.net.Uri;
import com.google.android.gms.internal.ads.zzatz;
import com.google.android.gms.internal.ads.zzaub;
import com.google.android.gms.internal.ads.zzaup;
import java.io.IOException;

public final class zzatx
implements zzatz {
    private final byte[] zza;
    private Uri zzb;
    private int zzc;
    private int zzd;

    public zzatx(byte[] byArray) {
        if (byArray == null) throw null;
        boolean bl = byArray.length > 0;
        zzaup.zza((boolean)bl);
        this.zza = byArray;
    }

    public final long zza(zzaub object) throws IOException {
        int n;
        int n2;
        this.zzb = ((zzaub)object).zza;
        long l = ((zzaub)object).zzc;
        this.zzc = n2 = (int)l;
        long l2 = ((zzaub)object).zzd;
        l = l2 == -1L ? (long)this.zza.length - l : l2;
        this.zzd = n = (int)l;
        if (n > 0 && n2 + n <= this.zza.length) {
            return n;
        }
        n = this.zza.length;
        object = new StringBuilder(77);
        ((StringBuilder)object).append("Unsatisfiable range: [");
        ((StringBuilder)object).append(n2);
        ((StringBuilder)object).append(", ");
        ((StringBuilder)object).append(l2);
        ((StringBuilder)object).append("], length: ");
        ((StringBuilder)object).append(n);
        throw new IOException(((StringBuilder)object).toString());
    }

    public final int zzb(byte[] byArray, int n, int n2) throws IOException {
        if (n2 == 0) {
            return 0;
        }
        int n3 = this.zzd;
        if (n3 == 0) {
            return -1;
        }
        n2 = Math.min(n2, n3);
        System.arraycopy(this.zza, this.zzc, byArray, n, n2);
        this.zzc += n2;
        this.zzd -= n2;
        return n2;
    }

    public final Uri zzc() {
        return this.zzb;
    }

    public final void zzd() throws IOException {
        this.zzb = null;
    }
}
