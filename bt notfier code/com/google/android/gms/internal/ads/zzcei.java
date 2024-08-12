/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.text.TextUtils
 *  com.google.android.gms.ads.internal.zzt
 *  com.google.android.gms.internal.ads.zzawc
 *  com.google.android.gms.internal.ads.zzawd
 */
package com.google.android.gms.internal.ads;

import android.content.Context;
import android.text.TextUtils;
import com.google.android.gms.ads.internal.zzt;
import com.google.android.gms.internal.ads.zzawc;
import com.google.android.gms.internal.ads.zzawd;

public final class zzcei
implements zzawd {
    private final Context zza;
    private final Object zzb;
    private final String zzc;
    private boolean zzd;

    public zzcei(Context context, String string) {
        Context context2 = context;
        if (context.getApplicationContext() != null) {
            context2 = context.getApplicationContext();
        }
        this.zza = context2;
        this.zzc = string;
        this.zzd = false;
        this.zzb = new Object();
    }

    public final void zza(boolean bl) {
        if (!zzt.zzA().zzb(this.zza)) {
            return;
        }
        Object object = this.zzb;
        synchronized (object) {
            if (this.zzd == bl) {
                return;
            }
            this.zzd = bl;
            if (TextUtils.isEmpty((CharSequence)this.zzc)) {
                return;
            }
            if (this.zzd) {
                zzt.zzA().zzf(this.zza, this.zzc);
            } else {
                zzt.zzA().zzg(this.zza, this.zzc);
            }
            return;
        }
    }

    public final String zzb() {
        return this.zzc;
    }

    public final void zzc(zzawc zzawc2) {
        this.zza(zzawc2.zzj);
    }
}
