/*
 * Decompiled with CFR 0.152.
 */
package com.google.android.gms.internal.ads;

import java.util.concurrent.atomic.AtomicBoolean;

public final class zzbpu {
    private boolean zza = false;
    private boolean zzb = false;
    private float zzc = 0.0f;
    private final AtomicBoolean zzd = new AtomicBoolean(false);

    public final void zza(boolean bl) {
        synchronized (this) {
            this.zza = bl;
            this.zzd.set(true);
            return;
        }
    }

    public final void zzb(boolean bl, float f) {
        synchronized (this) {
            this.zzb = bl;
            this.zzc = f;
            return;
        }
    }

    public final boolean zzc(boolean bl) {
        synchronized (this) {
            if (!this.zzd.get()) return bl;
            bl = this.zza;
            return bl;
        }
    }

    public final boolean zzd() {
        synchronized (this) {
            boolean bl = this.zzb;
            return bl;
        }
    }

    public final float zze() {
        synchronized (this) {
            float f = this.zzc;
            return f;
        }
    }
}
