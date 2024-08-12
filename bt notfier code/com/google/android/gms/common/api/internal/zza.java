/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Bundle
 *  com.google.android.gms.common.api.internal.LifecycleCallback
 *  com.google.android.gms.common.api.internal.zzb
 */
package com.google.android.gms.common.api.internal;

import android.os.Bundle;
import com.google.android.gms.common.api.internal.LifecycleCallback;
import com.google.android.gms.common.api.internal.zzb;

final class zza
implements Runnable {
    final LifecycleCallback zza;
    final String zzb;
    final zzb zzc;

    zza(zzb zzb2, LifecycleCallback lifecycleCallback, String string) {
        this.zzc = zzb2;
        this.zza = lifecycleCallback;
        this.zzb = string;
    }

    @Override
    public final void run() {
        if (com.google.android.gms.common.api.internal.zzb.zzb((zzb)this.zzc) > 0) {
            LifecycleCallback lifecycleCallback = this.zza;
            Bundle bundle = com.google.android.gms.common.api.internal.zzb.zzc((zzb)this.zzc) != null ? com.google.android.gms.common.api.internal.zzb.zzc((zzb)this.zzc).getBundle(this.zzb) : null;
            lifecycleCallback.onCreate(bundle);
        }
        if (com.google.android.gms.common.api.internal.zzb.zzb((zzb)this.zzc) >= 2) {
            this.zza.onStart();
        }
        if (com.google.android.gms.common.api.internal.zzb.zzb((zzb)this.zzc) >= 3) {
            this.zza.onResume();
        }
        if (com.google.android.gms.common.api.internal.zzb.zzb((zzb)this.zzc) >= 4) {
            this.zza.onStop();
        }
        if (com.google.android.gms.common.api.internal.zzb.zzb((zzb)this.zzc) < 5) return;
        this.zza.onDestroy();
    }
}
