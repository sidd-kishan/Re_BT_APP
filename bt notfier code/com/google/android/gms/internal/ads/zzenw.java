/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.media.AudioManager
 *  com.google.android.gms.ads.internal.zzt
 *  com.google.android.gms.internal.ads.zzenv
 *  com.google.android.gms.internal.ads.zzenx
 *  com.google.android.gms.internal.ads.zzery
 *  com.google.android.gms.internal.ads.zzfsm
 *  com.google.android.gms.internal.ads.zzfsn
 */
package com.google.android.gms.internal.ads;

import android.content.Context;
import android.media.AudioManager;
import com.google.android.gms.ads.internal.zzt;
import com.google.android.gms.internal.ads.zzenv;
import com.google.android.gms.internal.ads.zzenx;
import com.google.android.gms.internal.ads.zzery;
import com.google.android.gms.internal.ads.zzfsm;
import com.google.android.gms.internal.ads.zzfsn;
import java.util.concurrent.Callable;

public final class zzenw
implements zzery<zzenx> {
    private final zzfsn zza;
    private final Context zzb;

    public zzenw(zzfsn zzfsn2, Context context) {
        this.zza = zzfsn2;
        this.zzb = context;
    }

    public final zzfsm<zzenx> zza() {
        return this.zza.zzb((Callable)new zzenv(this));
    }

    final /* synthetic */ zzenx zzb() throws Exception {
        AudioManager audioManager = (AudioManager)this.zzb.getSystemService("audio");
        return new zzenx(audioManager.getMode(), audioManager.isMusicActive(), audioManager.isSpeakerphoneOn(), audioManager.getStreamVolume(3), audioManager.getRingerMode(), audioManager.getStreamVolume(2), zzt.zzh().zzb(), zzt.zzh().zzd());
    }
}
