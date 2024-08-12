/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzayv
 *  com.google.android.gms.internal.ads.zzayx
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzayv;
import com.google.android.gms.internal.ads.zzayx;
import java.io.IOException;
import java.io.InputStream;
import java.io.PushbackInputStream;

final class zzayu
extends PushbackInputStream {
    final zzayv zza;

    zzayu(zzayv zzayv2, InputStream inputStream, int n) {
        this.zza = zzayv2;
        super(inputStream, 1);
    }

    @Override
    public final void close() throws IOException {
        synchronized (this) {
            zzayx.zzf((zzayx)this.zza.zzc);
            super.close();
            return;
        }
    }
}
