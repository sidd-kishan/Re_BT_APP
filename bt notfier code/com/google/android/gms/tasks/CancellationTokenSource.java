/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.tasks.CancellationToken
 *  com.google.android.gms.tasks.zzb
 */
package com.google.android.gms.tasks;

import com.google.android.gms.tasks.CancellationToken;
import com.google.android.gms.tasks.zzb;

public class CancellationTokenSource {
    private final zzb zza = new zzb();

    public void cancel() {
        this.zza.zza();
    }

    public CancellationToken getToken() {
        return this.zza;
    }
}
