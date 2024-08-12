/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.net.Uri
 *  com.google.android.gms.internal.ads.zzagb
 *  com.google.android.gms.internal.ads.zzagh
 *  com.google.android.gms.internal.ads.zzagk
 *  com.google.android.gms.internal.ads.zzain
 *  com.google.android.gms.internal.ads.zzaip
 *  com.google.android.gms.internal.ads.zzaiq
 *  com.google.android.gms.internal.ads.zzakt
 *  com.google.android.gms.internal.ads.zzd
 */
package com.google.android.gms.internal.ads;

import android.net.Uri;
import com.google.android.gms.internal.ads.zzagb;
import com.google.android.gms.internal.ads.zzagh;
import com.google.android.gms.internal.ads.zzagk;
import com.google.android.gms.internal.ads.zzain;
import com.google.android.gms.internal.ads.zzaip;
import com.google.android.gms.internal.ads.zzaiq;
import com.google.android.gms.internal.ads.zzakt;
import com.google.android.gms.internal.ads.zzd;

public final class zziy
extends zzaiq {
    private static final Object zza = new Object();
    private static final zzagk zzb;
    private final long zze;
    private final long zzf;
    private final boolean zzg;
    private final zzagk zzh;
    private final zzagh zzi;

    static {
        zzagb zzagb2 = new zzagb();
        zzagb2.zza("SinglePeriodTimeline");
        zzagb2.zzb(Uri.EMPTY);
        zzb = zzagb2.zzc();
    }

    public zziy(long l, long l2, long l3, long l4, long l5, long l6, long l7, boolean bl, boolean bl2, boolean bl3, Object object, zzagk zzagk2, zzagh zzagh2) {
        this.zze = l4;
        this.zzf = l5;
        this.zzg = bl;
        this.zzh = zzagk2;
        this.zzi = zzagh2;
    }

    public final int zza() {
        return 1;
    }

    public final zzaip zzf(int n, zzaip zzaip2, long l) {
        zzakt.zzc((int)n, (int)0, (int)1);
        zzaip2.zza(zzaip.zza, this.zzh, null, -9223372036854775807L, -9223372036854775807L, -9223372036854775807L, this.zzg, false, this.zzi, 0L, this.zzf, 0, 0, 0L);
        return zzaip2;
    }

    public final int zzg() {
        return 1;
    }

    public final zzain zzh(int n, zzain zzain2, boolean bl) {
        zzakt.zzc((int)n, (int)0, (int)1);
        Object object = bl ? zza : null;
        zzain2.zza(null, object, 0, this.zze, 0L, zzd.zza, false);
        return zzain2;
    }

    public final int zzi(Object object) {
        if (!zza.equals(object)) return -1;
        return 0;
    }

    public final Object zzj(int n) {
        zzakt.zzc((int)n, (int)0, (int)1);
        return zza;
    }
}
