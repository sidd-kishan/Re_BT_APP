/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.net.Uri
 *  com.google.android.gms.internal.ads.zzagd
 *  com.google.android.gms.internal.ads.zzage
 *  com.google.android.gms.internal.ads.zzagh
 *  com.google.android.gms.internal.ads.zzagj
 *  com.google.android.gms.internal.ads.zzagk
 *  com.google.android.gms.internal.ads.zzago
 */
package com.google.android.gms.internal.ads;

import android.net.Uri;
import com.google.android.gms.internal.ads.zzagd;
import com.google.android.gms.internal.ads.zzage;
import com.google.android.gms.internal.ads.zzagh;
import com.google.android.gms.internal.ads.zzagj;
import com.google.android.gms.internal.ads.zzagk;
import com.google.android.gms.internal.ads.zzago;
import java.util.Collections;
import java.util.List;

public final class zzagb {
    private String zza;
    private Uri zzb;
    private final zzage zzc = new zzage(null);
    private final List zzd = Collections.emptyList();
    private final List zze = Collections.emptyList();

    public final zzagb zza(String string) {
        this.zza = string;
        return this;
    }

    public final zzagb zzb(Uri uri) {
        this.zzb = uri;
        return this;
    }

    public final zzagk zzc() {
        String string;
        Object object = this.zzb;
        object = object != null ? new zzagj(object, null, null, null, this.zzd, null, this.zze, null, null) : null;
        String string2 = string = this.zza;
        if (string != null) return new zzagk(string2, new zzagd(0L, Long.MIN_VALUE, false, false, false, null), (zzagj)object, new zzagh(-9223372036854775807L, -9223372036854775807L, -9223372036854775807L, -3.4028235E38f, -3.4028235E38f), zzago.zza, null);
        string2 = "";
        return new zzagk(string2, new zzagd(0L, Long.MIN_VALUE, false, false, false, null), (zzagj)object, new zzagh(-9223372036854775807L, -9223372036854775807L, -9223372036854775807L, -3.4028235E38f, -3.4028235E38f), zzago.zza, null);
    }
}
