/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzasl
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzasl;
import java.io.IOException;

final class zzash
implements Runnable {
    final IOException zza;
    final zzasl zzb;

    zzash(zzasl zzasl2, IOException iOException) {
        this.zzb = zzasl2;
        this.zza = iOException;
    }

    @Override
    public final void run() {
        zzasl.zzd((zzasl)this.zzb).zzi(this.zza);
    }
}
