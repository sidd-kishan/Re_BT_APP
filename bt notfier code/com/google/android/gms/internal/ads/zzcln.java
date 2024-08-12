/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzclp
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzclp;
import java.util.concurrent.Callable;

final class zzcln
implements Callable {
    private final zzclp zza;

    zzcln(zzclp zzclp2) {
        this.zza = zzclp2;
    }

    public final Object call() {
        return this.zza.zzq();
    }
}
