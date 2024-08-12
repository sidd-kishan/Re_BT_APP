/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.common.zzi
 *  com.google.android.gms.common.zzm
 */
package com.google.android.gms.common;

import com.google.android.gms.common.zzi;
import com.google.android.gms.common.zzm;
import java.util.concurrent.Callable;

final class zzd
implements Callable {
    private final boolean zza;
    private final String zzb;
    private final zzi zzc;

    zzd(boolean bl, String string, zzi zzi2) {
        this.zza = bl;
        this.zzb = string;
        this.zzc = zzi2;
    }

    public final Object call() {
        return zzm.zze((boolean)this.zza, (String)this.zzb, (zzi)this.zzc);
    }
}
