/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.media.AudioManager
 *  android.media.AudioManager$OnAudioFocusChangeListener
 *  com.google.android.gms.internal.ads.zzcje
 */
package com.google.android.gms.internal.ads;

import android.content.Context;
import android.media.AudioManager;
import com.google.android.gms.internal.ads.zzcje;

public final class zzcjf
implements AudioManager.OnAudioFocusChangeListener {
    private final AudioManager zza;
    private final zzcje zzb;
    private boolean zzc;
    private boolean zzd;
    private boolean zze;
    private float zzf = 1.0f;

    public zzcjf(Context context, zzcje zzcje2) {
        this.zza = (AudioManager)context.getSystemService("audio");
        this.zzb = zzcje2;
    }

    private final void zzf() {
        boolean bl = this.zzd;
        boolean bl2 = false;
        boolean bl3 = false;
        if (bl && !this.zze && this.zzf > 0.0f) {
            if (this.zzc) return;
            AudioManager audioManager = this.zza;
            if (audioManager != null) {
                bl2 = bl3;
                if (audioManager.requestAudioFocus((AudioManager.OnAudioFocusChangeListener)this, 3, 2) == 1) {
                    bl2 = true;
                }
                this.zzc = bl2;
            }
            this.zzb.zzt();
            return;
        }
        if (!this.zzc) return;
        AudioManager audioManager = this.zza;
        if (audioManager != null) {
            if (audioManager.abandonAudioFocus((AudioManager.OnAudioFocusChangeListener)this) == 0) {
                bl2 = true;
            }
            this.zzc = bl2;
        }
        this.zzb.zzt();
    }

    public final void onAudioFocusChange(int n) {
        boolean bl = n > 0;
        this.zzc = bl;
        this.zzb.zzt();
    }

    public final void zza(boolean bl) {
        this.zze = bl;
        this.zzf();
    }

    public final void zzb(float f) {
        this.zzf = f;
        this.zzf();
    }

    public final float zzc() {
        float f = this.zze ? 0.0f : this.zzf;
        if (!this.zzc) return 0.0f;
        return f;
    }

    public final void zzd() {
        this.zzd = true;
        this.zzf();
    }

    public final void zze() {
        this.zzd = false;
        this.zzf();
    }
}
