/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.media.AudioManager
 */
package com.google.android.gms.ads.internal.util;

import android.content.Context;
import android.media.AudioManager;

public final class zzae {
    private boolean zza = false;
    private float zzb = 1.0f;

    public static float zze(Context context) {
        if ((context = (AudioManager)context.getSystemService("audio")) == null) {
            return 0.0f;
        }
        int n = context.getStreamMaxVolume(3);
        int n2 = context.getStreamVolume(3);
        if (n != 0) return (float)n2 / (float)n;
        return 0.0f;
    }

    private final boolean zzf() {
        synchronized (this) {
            float f = this.zzb;
            boolean bl = f >= 0.0f;
            return bl;
        }
    }

    public final void zza(float f) {
        synchronized (this) {
            this.zzb = f;
            return;
        }
    }

    public final float zzb() {
        synchronized (this) {
            if (!this.zzf()) return 1.0f;
            float f = this.zzb;
            return f;
        }
    }

    public final void zzc(boolean bl) {
        synchronized (this) {
            this.zza = bl;
            return;
        }
    }

    public final boolean zzd() {
        synchronized (this) {
            boolean bl = this.zza;
            return bl;
        }
    }
}
