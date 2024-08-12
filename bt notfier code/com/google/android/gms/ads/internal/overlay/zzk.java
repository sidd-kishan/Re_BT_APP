/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.content.Context
 *  android.graphics.Bitmap
 *  android.graphics.drawable.Drawable
 *  com.google.android.gms.ads.internal.overlay.zzi
 *  com.google.android.gms.ads.internal.overlay.zzj
 *  com.google.android.gms.ads.internal.overlay.zzl
 *  com.google.android.gms.ads.internal.util.zzad
 *  com.google.android.gms.ads.internal.util.zzb
 *  com.google.android.gms.ads.internal.util.zzs
 *  com.google.android.gms.ads.internal.zzt
 */
package com.google.android.gms.ads.internal.overlay;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import com.google.android.gms.ads.internal.overlay.zzi;
import com.google.android.gms.ads.internal.overlay.zzj;
import com.google.android.gms.ads.internal.overlay.zzl;
import com.google.android.gms.ads.internal.util.zzad;
import com.google.android.gms.ads.internal.util.zzb;
import com.google.android.gms.ads.internal.util.zzs;
import com.google.android.gms.ads.internal.zzt;

final class zzk
extends zzb {
    final zzl zza;

    /* synthetic */ zzk(zzl zzl2, zzi zzi2) {
        this.zza = zzl2;
    }

    public final void zza() {
        Bitmap bitmap = zzt.zzv().zza(Integer.valueOf(this.zza.zzc.zzo.zzf));
        if (bitmap == null) return;
        zzad zzad2 = zzt.zze();
        zzl zzl2 = this.zza;
        Activity activity = zzl2.zzb;
        zzl2 = zzl2.zzc.zzo;
        activity = zzad2.zzd((Context)activity, bitmap, zzl2.zzd, zzl2.zze);
        zzs.zza.post((Runnable)new zzj(this, (Drawable)activity));
    }
}
