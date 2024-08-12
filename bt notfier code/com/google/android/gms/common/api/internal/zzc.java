/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Bundle
 *  com.google.android.gms.common.api.internal.LifecycleCallback
 *  com.google.android.gms.common.api.internal.zzd
 */
package com.google.android.gms.common.api.internal;

import android.os.Bundle;
import com.google.android.gms.common.api.internal.LifecycleCallback;
import com.google.android.gms.common.api.internal.zzd;

final class zzc
implements Runnable {
    final LifecycleCallback zza;
    final String zzb;
    final zzd zzc;

    zzc(zzd zzd2, LifecycleCallback lifecycleCallback, String string) {
        this.zzc = zzd2;
        this.zza = lifecycleCallback;
        this.zzb = string;
    }

    @Override
    public final void run() {
        if (zzd.zzb((zzd)this.zzc) > 0) {
            LifecycleCallback lifecycleCallback = this.zza;
            Bundle bundle = zzd.zzc((zzd)this.zzc) != null ? zzd.zzc((zzd)this.zzc).getBundle(this.zzb) : null;
            lifecycleCallback.onCreate(bundle);
        }
        if (zzd.zzb((zzd)this.zzc) >= 2) {
            this.zza.onStart();
        }
        if (zzd.zzb((zzd)this.zzc) >= 3) {
            this.zza.onResume();
        }
        if (zzd.zzb((zzd)this.zzc) >= 4) {
            this.zza.onStop();
        }
        if (zzd.zzb((zzd)this.zzc) < 5) return;
        this.zza.onDestroy();
    }
}
