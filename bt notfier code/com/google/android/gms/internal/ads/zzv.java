/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.os.Looper
 *  android.view.accessibility.CaptioningManager
 *  com.google.android.gms.internal.ads.zzamq
 *  com.google.android.gms.internal.ads.zzfoj
 *  com.google.android.gms.internal.ads.zzfot
 *  com.google.android.gms.internal.ads.zzw
 */
package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Looper;
import android.view.accessibility.CaptioningManager;
import com.google.android.gms.internal.ads.zzamq;
import com.google.android.gms.internal.ads.zzfoj;
import com.google.android.gms.internal.ads.zzfot;
import com.google.android.gms.internal.ads.zzw;
import java.util.Locale;

public class zzv {
    private int zza;
    private int zzb;
    private boolean zzc;
    private final zzfoj<String> zzd;
    private final zzfoj<String> zze;
    private final zzfoj<String> zzf;
    private zzfoj<String> zzg;
    private int zzh;
    private final zzfot<Integer> zzi;

    @Deprecated
    public zzv() {
        this.zza = Integer.MAX_VALUE;
        this.zzb = Integer.MAX_VALUE;
        this.zzc = true;
        this.zzd = zzfoj.zzi();
        this.zze = zzfoj.zzi();
        this.zzf = zzfoj.zzi();
        this.zzg = zzfoj.zzi();
        this.zzh = 0;
        this.zzi = zzfot.zzh();
    }

    protected zzv(zzw zzw2) {
        this.zza = zzw2.zzk;
        this.zzb = zzw2.zzl;
        this.zzc = zzw2.zzm;
        this.zzd = zzw2.zzn;
        this.zze = zzw2.zzo;
        this.zzf = zzw2.zzs;
        this.zzg = zzw2.zzt;
        this.zzh = zzw2.zzu;
        this.zzi = zzw2.zzy;
    }

    static /* synthetic */ int zza(zzv zzv2) {
        return zzv2.zza;
    }

    static /* synthetic */ int zzb(zzv zzv2) {
        return zzv2.zzb;
    }

    static /* synthetic */ boolean zzc(zzv zzv2) {
        return zzv2.zzc;
    }

    static /* synthetic */ zzfoj zzd(zzv zzv2) {
        return zzv2.zzd;
    }

    static /* synthetic */ zzfoj zze(zzv zzv2) {
        return zzv2.zze;
    }

    static /* synthetic */ zzfoj zzf(zzv zzv2) {
        return zzv2.zzf;
    }

    static /* synthetic */ zzfoj zzg(zzv zzv2) {
        return zzv2.zzg;
    }

    static /* synthetic */ int zzh(zzv zzv2) {
        return zzv2.zzh;
    }

    static /* synthetic */ zzfot zzi(zzv zzv2) {
        return zzv2.zzi;
    }

    public zzv zzj(int n, int n2, boolean bl) {
        this.zza = n;
        this.zzb = n2;
        this.zzc = true;
        return this;
    }

    public final zzv zzk(Context object) {
        if (zzamq.zza < 19) return this;
        if (zzamq.zza < 23) {
            if (Looper.myLooper() == null) return this;
        }
        if ((object = (CaptioningManager)object.getSystemService("captioning")) == null) return this;
        if (!object.isEnabled()) return this;
        this.zzh = 1088;
        if ((object = object.getLocale()) == null) return this;
        this.zzg = zzfoj.zzj((Object)zzamq.zzp((Locale)object));
        return this;
    }
}
