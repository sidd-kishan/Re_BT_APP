/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.net.Uri
 *  com.google.android.gms.ads.internal.util.zze
 *  com.google.android.gms.internal.ads.zzcms
 *  com.google.android.gms.internal.ads.zzfrz
 */
package com.google.android.gms.internal.ads;

import android.net.Uri;
import com.google.android.gms.ads.internal.util.zze;
import com.google.android.gms.internal.ads.zzcms;
import com.google.android.gms.internal.ads.zzfrz;
import java.util.List;
import java.util.Map;

final class zzcmq
implements zzfrz<Map<String, String>> {
    final List zza;
    final String zzb;
    final Uri zzc;
    final zzcms zzd;

    zzcmq(zzcms zzcms2, List list, String string, Uri uri) {
        this.zzd = zzcms2;
        this.zza = list;
        this.zzb = string;
        this.zzc = uri;
    }

    public final void zza(Throwable object) {
        object = String.valueOf(this.zzc);
        String.valueOf(object).length();
        zze.zzi((String)"Failed to parse gmsg params for: ".concat(String.valueOf(object)));
    }
}
