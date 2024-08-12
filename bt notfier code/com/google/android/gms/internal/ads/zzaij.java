/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.BroadcastReceiver
 *  android.content.Context
 *  android.content.IntentFilter
 *  android.media.AudioManager
 *  android.os.Handler
 *  com.google.android.gms.internal.ads.zzaee
 *  com.google.android.gms.internal.ads.zzahl
 *  com.google.android.gms.internal.ads.zzaib
 *  com.google.android.gms.internal.ads.zzaie
 *  com.google.android.gms.internal.ads.zzaif
 *  com.google.android.gms.internal.ads.zzaii
 *  com.google.android.gms.internal.ads.zzakt
 *  com.google.android.gms.internal.ads.zzaln
 *  com.google.android.gms.internal.ads.zzamq
 */
package com.google.android.gms.internal.ads;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.media.AudioManager;
import android.os.Handler;
import com.google.android.gms.internal.ads.zzaee;
import com.google.android.gms.internal.ads.zzahl;
import com.google.android.gms.internal.ads.zzaib;
import com.google.android.gms.internal.ads.zzaie;
import com.google.android.gms.internal.ads.zzaif;
import com.google.android.gms.internal.ads.zzaii;
import com.google.android.gms.internal.ads.zzakt;
import com.google.android.gms.internal.ads.zzaln;
import com.google.android.gms.internal.ads.zzamq;
import java.util.Iterator;

final class zzaij {
    private final Context zza;
    private final Handler zzb;
    private final zzaif zzc;
    private final AudioManager zzd;
    private zzaii zze;
    private int zzf;
    private int zzg;
    private boolean zzh;

    public zzaij(Context context, Handler handler, zzaif zzaif2) {
        this.zza = context = context.getApplicationContext();
        this.zzb = handler;
        this.zzc = zzaif2;
        context = (AudioManager)context.getSystemService("audio");
        zzakt.zze((Object)context);
        this.zzd = context;
        this.zzf = 3;
        this.zzg = zzaij.zzh((AudioManager)context, 3);
        this.zzh = zzaij.zzi(this.zzd, this.zzf);
        context = new zzaii(this, null);
        handler = new IntentFilter("android.media.VOLUME_CHANGED_ACTION");
        try {
            this.zza.registerReceiver((BroadcastReceiver)context, (IntentFilter)handler);
            this.zze = context;
            return;
        }
        catch (RuntimeException runtimeException) {
            zzaln.zza((String)"StreamVolumeManager", (String)"Error registering stream volume receiver", (Throwable)runtimeException);
            return;
        }
    }

    static /* synthetic */ Handler zza(zzaij zzaij2) {
        return zzaij2.zzb;
    }

    static /* synthetic */ void zzf(zzaij zzaij2) {
        zzaij2.zzg();
    }

    private final void zzg() {
        int n = zzaij.zzh(this.zzd, this.zzf);
        boolean bl = zzaij.zzi(this.zzd, this.zzf);
        if (this.zzg == n) {
            if (this.zzh == bl) return;
        }
        this.zzg = n;
        this.zzh = bl;
        Iterator iterator = zzaie.zze((zzaie)((zzaib)this.zzc).zza).iterator();
        while (iterator.hasNext()) {
            ((zzahl)iterator.next()).zzad(n, bl);
        }
    }

    private static int zzh(AudioManager audioManager, int n) {
        try {
            int n2 = audioManager.getStreamVolume(n);
            return n2;
        }
        catch (RuntimeException runtimeException) {
            StringBuilder stringBuilder = new StringBuilder(60);
            stringBuilder.append("Could not retrieve stream volume for stream type ");
            stringBuilder.append(n);
            zzaln.zza((String)"StreamVolumeManager", (String)stringBuilder.toString(), (Throwable)runtimeException);
            return audioManager.getStreamMaxVolume(n);
        }
    }

    private static boolean zzi(AudioManager audioManager, int n) {
        if (zzamq.zza >= 23) {
            return audioManager.isStreamMute(n);
        }
        if (zzaij.zzh(audioManager, n) != 0) return false;
        return true;
    }

    public final void zzb(int n) {
        if (this.zzf == 3) {
            return;
        }
        this.zzf = 3;
        this.zzg();
        Object object = (zzaib)this.zzc;
        zzaee zzaee2 = zzaie.zzZ((zzaij)zzaie.zzg((zzaie)((zzaib)object).zza));
        if (zzaee2.equals((Object)zzaie.zzs((zzaie)((zzaib)object).zza))) return;
        zzaie.zzt((zzaie)((zzaib)object).zza, (zzaee)zzaee2);
        object = zzaie.zze((zzaie)((zzaib)object).zza).iterator();
        while (object.hasNext()) {
            ((zzahl)object.next()).zzac(zzaee2);
        }
    }

    public final int zzc() {
        if (zzamq.zza < 28) return 0;
        return this.zzd.getStreamMinVolume(this.zzf);
    }

    public final int zzd() {
        return this.zzd.getStreamMaxVolume(this.zzf);
    }

    public final void zze() {
        zzaii zzaii2 = this.zze;
        if (zzaii2 == null) return;
        try {
            this.zza.unregisterReceiver((BroadcastReceiver)zzaii2);
        }
        catch (RuntimeException runtimeException) {
            zzaln.zza((String)"StreamVolumeManager", (String)"Error unregistering stream volume receiver", (Throwable)runtimeException);
        }
        this.zze = null;
    }
}
