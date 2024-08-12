/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.net.Uri
 *  com.google.android.gms.internal.ads.zzag
 *  com.google.android.gms.internal.ads.zzak
 *  com.google.android.gms.internal.ads.zzakt
 *  com.google.android.gms.internal.ads.zzan
 */
package com.google.android.gms.internal.ads;

import android.net.Uri;
import com.google.android.gms.internal.ads.zzag;
import com.google.android.gms.internal.ads.zzak;
import com.google.android.gms.internal.ads.zzakt;
import com.google.android.gms.internal.ads.zzan;
import java.io.IOException;

public final class zzkj
extends zzag {
    private final byte[] zza;
    private Uri zzb;
    private int zzc;
    private int zzd;
    private boolean zze;

    public zzkj(byte[] byArray) {
        boolean bl = false;
        super(false);
        if (byArray == null) throw null;
        if (byArray.length > 0) {
            bl = true;
        }
        zzakt.zza((boolean)bl);
        this.zza = byArray;
    }

    public final int zzg(byte[] byArray, int n, int n2) {
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
        this.zzd(n2);
        return n2;
    }

    public final long zzh(zzan zzan2) throws IOException {
        int n;
        this.zzb = zzan2.zza;
        this.zzb(zzan2);
        long l = zzan2.zzf;
        int n2 = this.zza.length;
        if (l > (long)n2) throw new zzak(2008);
        this.zzc = n = (int)l;
        this.zzd = n = n2 - n;
        l = zzan2.zzg;
        if (l != -1L) {
            this.zzd = (int)Math.min((long)n, l);
        }
        this.zze = true;
        this.zzc(zzan2);
        l = zzan2.zzg;
        if (l == -1L) return this.zzd;
        return l;
    }

    public final Uri zzi() {
        return this.zzb;
    }

    public final void zzj() {
        if (this.zze) {
            this.zze = false;
            this.zze();
        }
        this.zzb = null;
    }
}
