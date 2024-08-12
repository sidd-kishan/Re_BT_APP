/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  com.google.android.gms.ads.internal.util.zzch
 */
package com.google.android.gms.ads.internal.util;

import android.content.Context;
import com.google.android.gms.ads.internal.util.zzch;
import java.util.concurrent.Callable;

final class zzcg
implements Callable<String> {
    final Context zza;
    final Context zzb;

    zzcg(zzch zzch2, Context context, Context context2) {
        this.zza = context;
        this.zzb = context2;
    }
}
