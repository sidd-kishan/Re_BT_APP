/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzgkl
 *  com.google.android.gms.internal.ads.zzgkm
 *  com.google.android.gms.internal.ads.zzxm
 *  com.google.android.gms.internal.ads.zzxp
 *  com.google.android.gms.internal.ads.zzxq
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzgkl;
import com.google.android.gms.internal.ads.zzgkm;
import com.google.android.gms.internal.ads.zzxm;
import com.google.android.gms.internal.ads.zzxp;
import com.google.android.gms.internal.ads.zzxq;
import java.io.IOException;
import java.nio.ByteBuffer;

public class zzgki
extends zzgkl
implements zzxp {
    zzxq zza;
    protected final String zzb;

    public zzgki(String string) {
        this.zzb = "moov";
    }

    public final void zza(zzxq zzxq2) {
        this.zza = zzxq2;
    }

    public final String zzb() {
        return this.zzb;
    }

    public final void zzc(zzgkm zzgkm2, ByteBuffer byteBuffer, long l, zzxm zzxm2) throws IOException {
        zzgkm2.zzc();
        byteBuffer.remaining();
        byteBuffer.remaining();
        this.zzd = zzgkm2;
        this.zzf = zzgkm2.zzc();
        zzgkm2.zzd(zzgkm2.zzc() + l);
        this.zzg = zzgkm2.zzc();
        this.zzc = zzxm2;
    }
}
