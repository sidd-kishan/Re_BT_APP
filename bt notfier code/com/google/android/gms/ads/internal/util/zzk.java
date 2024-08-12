/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.net.Uri
 *  com.google.android.gms.ads.internal.util.zzs
 *  com.google.android.gms.ads.internal.zzt
 *  com.google.android.gms.internal.ads.zzfla
 */
package com.google.android.gms.ads.internal.util;

import android.net.Uri;
import com.google.android.gms.ads.internal.util.zzs;
import com.google.android.gms.ads.internal.zzt;
import com.google.android.gms.internal.ads.zzfla;
import java.util.concurrent.Callable;

final class zzk
implements Callable {
    private final Uri zza;

    zzk(Uri uri) {
        this.zza = uri;
    }

    public final Object call() {
        Uri uri = this.zza;
        zzfla zzfla2 = zzs.zza;
        zzt.zzc();
        return zzs.zzR((Uri)uri);
    }
}
