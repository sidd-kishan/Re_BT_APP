/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.view.TextureView
 *  com.google.android.gms.internal.ads.zzcih
 *  com.google.android.gms.internal.ads.zzciv
 *  com.google.android.gms.internal.ads.zzcje
 *  com.google.android.gms.internal.ads.zzcjf
 */
package com.google.android.gms.internal.ads;

import android.content.Context;
import android.view.TextureView;
import com.google.android.gms.internal.ads.zzcih;
import com.google.android.gms.internal.ads.zzciv;
import com.google.android.gms.internal.ads.zzcje;
import com.google.android.gms.internal.ads.zzcjf;

public abstract class zzcii
extends TextureView
implements zzcje {
    protected final zzciv zza = new zzciv();
    protected final zzcjf zzb;

    public zzcii(Context context) {
        super(context);
        this.zzb = new zzcjf(context, (zzcje)this);
    }

    public void zzA(int n) {
    }

    public void zzB(int n) {
    }

    public abstract String zzd();

    public abstract void zze(zzcih var1);

    public abstract void zzf(String var1);

    public abstract void zzg();

    public abstract void zzh();

    public abstract void zzi();

    public abstract int zzj();

    public abstract int zzk();

    public abstract void zzl(int var1);

    public abstract void zzm(float var1, float var2);

    public abstract int zzn();

    public abstract int zzo();

    public abstract long zzp();

    public abstract long zzq();

    public abstract long zzr();

    public abstract int zzs();

    public abstract void zzt();

    public void zzw(String string, String[] stringArray) {
        this.zzf(string);
    }

    public void zzx(int n) {
    }

    public void zzy(int n) {
    }

    public void zzz(int n) {
    }
}
