/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzgkl
 *  com.google.android.gms.internal.ads.zzgkm
 *  com.google.android.gms.internal.ads.zzgks
 *  com.google.android.gms.internal.ads.zzxm
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzgkl;
import com.google.android.gms.internal.ads.zzgkm;
import com.google.android.gms.internal.ads.zzgks;
import com.google.android.gms.internal.ads.zzxm;
import java.io.Closeable;
import java.io.IOException;

public final class zzxn
extends zzgkl
implements Closeable {
    private static final zzgks zza = zzgks.zzb(zzxn.class);

    public zzxn(zzgkm zzgkm2, zzxm zzxm2) throws IOException {
        this.zze(zzgkm2, zzgkm2.zzb(), zzxm2);
    }

    @Override
    public final void close() throws IOException {
    }

    public final String toString() {
        String string = this.zzd.toString();
        StringBuilder stringBuilder = new StringBuilder(String.valueOf(string).length() + 7);
        stringBuilder.append("model(");
        stringBuilder.append(string);
        stringBuilder.append(")");
        return stringBuilder.toString();
    }
}
