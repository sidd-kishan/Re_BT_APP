/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.media.AudioManager
 *  android.media.AudioManager$OnAudioFocusChangeListener
 *  android.os.Handler
 *  android.util.Log
 *  com.google.android.gms.internal.ads.zzadr
 *  com.google.android.gms.internal.ads.zzads
 *  com.google.android.gms.internal.ads.zzaib
 *  com.google.android.gms.internal.ads.zzaie
 *  com.google.android.gms.internal.ads.zzamq
 */
package com.google.android.gms.internal.ads;

import android.content.Context;
import android.media.AudioManager;
import android.os.Handler;
import android.util.Log;
import com.google.android.gms.internal.ads.zzadr;
import com.google.android.gms.internal.ads.zzads;
import com.google.android.gms.internal.ads.zzaib;
import com.google.android.gms.internal.ads.zzaie;
import com.google.android.gms.internal.ads.zzamq;

final class zzadt {
    private final AudioManager zza;
    private final zzadr zzb;
    private zzads zzc;
    private int zzd;
    private float zze = 1.0f;

    public zzadt(Context context, Handler handler, zzads zzads2) {
        context = (AudioManager)context.getApplicationContext().getSystemService("audio");
        if (context == null) throw null;
        this.zza = context;
        this.zzc = zzads2;
        this.zzb = new zzadr(this, handler);
        this.zzd = 0;
    }

    static /* synthetic */ void zzd(zzadt object, int n) {
        if (n != -3 && n != -2) {
            if (n == -1) {
                ((zzadt)object).zzg(-1);
                ((zzadt)object).zze();
                return;
            }
            if (n != 1) {
                object = new StringBuilder(38);
                ((StringBuilder)object).append("Unknown focus change type: ");
                ((StringBuilder)object).append(n);
                Log.w((String)"AudioFocusManager", (String)((StringBuilder)object).toString());
                return;
            }
            ((zzadt)object).zzf(1);
            ((zzadt)object).zzg(1);
            return;
        }
        if (n != -2) {
            ((zzadt)object).zzf(3);
            return;
        }
        ((zzadt)object).zzg(0);
        ((zzadt)object).zzf(2);
    }

    private final void zze() {
        if (this.zzd == 0) {
            return;
        }
        if (zzamq.zza < 26) {
            this.zza.abandonAudioFocus((AudioManager.OnAudioFocusChangeListener)this.zzb);
        }
        this.zzf(0);
    }

    private final void zzf(int n) {
        if (this.zzd == n) {
            return;
        }
        this.zzd = n;
        float f = n == 3 ? 0.2f : 1.0f;
        if (this.zze == f) {
            return;
        }
        this.zze = f;
        zzads zzads2 = this.zzc;
        if (zzads2 == null) return;
        zzaie.zzV((zzaie)((zzaib)zzads2).zza);
    }

    private final void zzg(int n) {
        zzads zzads2 = this.zzc;
        if (zzads2 == null) return;
        zzads2 = (zzaib)zzads2;
        boolean bl = zzads2.zza.zzM();
        zzaie.zzX((zzaie)zzads2.zza, (boolean)bl, (int)n, (int)zzaie.zzaa((boolean)bl, (int)n));
    }

    public final float zza() {
        return this.zze;
    }

    public final int zzb(boolean bl, int n) {
        this.zze();
        if (!bl) return -1;
        return 1;
    }

    public final void zzc() {
        this.zzc = null;
        this.zze();
    }
}
