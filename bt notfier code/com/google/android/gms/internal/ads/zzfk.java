/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.util.Log
 *  com.google.android.gms.internal.ads.zzaf
 *  com.google.android.gms.internal.ads.zzafv
 *  com.google.android.gms.internal.ads.zzoo
 */
package com.google.android.gms.internal.ads;

import android.util.Log;
import com.google.android.gms.internal.ads.zzaf;
import com.google.android.gms.internal.ads.zzafv;
import com.google.android.gms.internal.ads.zzoo;
import java.nio.ByteBuffer;

final class zzfk {
    private long zza;
    private long zzb;
    private boolean zzc;

    zzfk() {
    }

    private final long zzd(long l) {
        return this.zza + Math.max(0L, (this.zzb - 529L) * 1000000L / l);
    }

    public final void zza() {
        this.zza = 0L;
        this.zzb = 0L;
        this.zzc = false;
    }

    public final long zzb(zzafv zzafv2, zzaf zzaf2) {
        if (this.zzb == 0L) {
            this.zza = zzaf2.zzd;
        }
        if (this.zzc) {
            return zzaf2.zzd;
        }
        ByteBuffer byteBuffer = zzaf2.zzb;
        if (byteBuffer == null) throw null;
        int n = 0;
        for (int i = 0; i < 4; ++i) {
            n = n << 8 | byteBuffer.get(i) & 0xFF;
        }
        if ((n = zzoo.zzi((int)n)) == -1) {
            this.zzc = true;
            this.zzb = 0L;
            this.zza = zzaf2.zzd;
            Log.w((String)"C2Mp3TimestampTracker", (String)"MPEG audio header is invalid.");
            return zzaf2.zzd;
        }
        long l = this.zzd(zzafv2.zzz);
        this.zzb += (long)n;
        return l;
    }

    public final long zzc(zzafv zzafv2) {
        return this.zzd(zzafv2.zzz);
    }
}
