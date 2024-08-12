/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.database.ContentObserver
 *  android.media.AudioManager
 *  android.os.Handler
 *  android.provider.Settings$System
 *  com.google.android.gms.internal.ads.zzfgn
 *  com.google.android.gms.internal.ads.zzfgy
 */
package com.google.android.gms.internal.ads;

import android.content.Context;
import android.database.ContentObserver;
import android.media.AudioManager;
import android.os.Handler;
import android.provider.Settings;
import com.google.android.gms.internal.ads.zzfgn;
import com.google.android.gms.internal.ads.zzfgy;

public final class zzfgp
extends ContentObserver {
    private final Context zza;
    private final AudioManager zzb;
    private final zzfgn zzc;
    private float zzd;
    private final zzfgy zze;

    public zzfgp(Handler handler, Context context, zzfgn zzfgn2, zzfgy zzfgy2, byte[] byArray) {
        super(handler);
        this.zza = context;
        this.zzb = (AudioManager)context.getSystemService("audio");
        this.zzc = zzfgn2;
        this.zze = zzfgy2;
    }

    private final float zzc() {
        int n = this.zzb.getStreamVolume(3);
        int n2 = this.zzb.getStreamMaxVolume(3);
        float f = 1.0f;
        if (n2 > 0 && n > 0) {
            float f2 = (float)n / (float)n2;
            if (!(f2 > 1.0f)) return f2;
        } else {
            f = 0.0f;
        }
        return f;
    }

    private final void zzd() {
        this.zze.zze(this.zzd);
    }

    public final void onChange(boolean bl) {
        super.onChange(bl);
        float f = this.zzc();
        if (f == this.zzd) return;
        this.zzd = f;
        this.zzd();
    }

    public final void zza() {
        this.zzd = this.zzc();
        this.zzd();
        this.zza.getContentResolver().registerContentObserver(Settings.System.CONTENT_URI, true, (ContentObserver)this);
    }

    public final void zzb() {
        this.zza.getContentResolver().unregisterContentObserver((ContentObserver)this);
    }
}
