/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.media.AudioManager$OnAudioFocusChangeListener
 *  android.os.Handler
 *  com.google.android.gms.internal.ads.zzadq
 *  com.google.android.gms.internal.ads.zzadt
 */
package com.google.android.gms.internal.ads;

import android.media.AudioManager;
import android.os.Handler;
import com.google.android.gms.internal.ads.zzadq;
import com.google.android.gms.internal.ads.zzadt;

final class zzadr
implements AudioManager.OnAudioFocusChangeListener {
    final zzadt zza;
    private final Handler zzb;

    public zzadr(zzadt zzadt2, Handler handler) {
        this.zza = zzadt2;
        this.zzb = handler;
    }

    public final void onAudioFocusChange(int n) {
        this.zzb.post((Runnable)new zzadq(this, n));
    }
}
