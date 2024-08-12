/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Bundle
 *  com.google.android.gms.common.ConnectionResult
 *  com.google.android.gms.common.internal.BaseGmsClient
 *  com.google.android.gms.common.internal.zzc
 */
package com.google.android.gms.common.internal;

import android.os.Bundle;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.BaseGmsClient;
import com.google.android.gms.common.internal.zzc;

abstract class zza
extends zzc<Boolean> {
    public final int zza;
    public final Bundle zzb;
    final BaseGmsClient zzc;

    protected zza(BaseGmsClient baseGmsClient, int n, Bundle bundle) {
        this.zzc = baseGmsClient;
        super(baseGmsClient, (Object)true);
        this.zza = n;
        this.zzb = bundle;
    }

    protected abstract boolean zza();

    protected abstract void zzb(ConnectionResult var1);

    protected final void zzc() {
    }
}
