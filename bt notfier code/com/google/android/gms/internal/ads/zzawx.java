/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.app.Application
 *  android.content.Context
 *  com.google.android.gms.ads.internal.util.zze
 *  com.google.android.gms.internal.ads.zzawv
 *  com.google.android.gms.internal.ads.zzaww
 */
package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import com.google.android.gms.ads.internal.util.zze;
import com.google.android.gms.internal.ads.zzawv;
import com.google.android.gms.internal.ads.zzaww;
import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
public final class zzawx {
    private final Object zza = new Object();
    private zzawv zzb = null;
    private boolean zzc = false;

    public final void zza(Context context) {
        Object object = this.zza;
        synchronized (object) {
            Context context2;
            if (this.zzc) return;
            Object object2 = context2 = context.getApplicationContext();
            if (context2 == null) {
                object2 = context;
            }
            if ((object2 = object2 instanceof Application ? (Application)object2 : null) == null) {
                zze.zzi((String)"Can not cast Context to Application");
                return;
            }
            if (this.zzb == null) {
                context2 = new zzawv();
                this.zzb = context2;
            }
            this.zzb.zzf((Application)object2, context);
            this.zzc = true;
            return;
        }
    }

    public final void zzb(zzaww zzaww2) {
        Object object = this.zza;
        synchronized (object) {
            if (this.zzb == null) {
                zzawv zzawv2;
                this.zzb = zzawv2 = new zzawv();
            }
            this.zzb.zzg(zzaww2);
            return;
        }
    }

    public final void zzc(zzaww zzaww2) {
        Object object = this.zza;
        synchronized (object) {
            zzawv zzawv2 = this.zzb;
            if (zzawv2 == null) {
                return;
            }
            zzawv2.zzh(zzaww2);
            return;
        }
    }

    public final Activity zzd() {
        Object object = this.zza;
        synchronized (object) {
            zzawv zzawv2 = this.zzb;
            if (zzawv2 == null) return null;
            zzawv2 = zzawv2.zzi();
            return zzawv2;
        }
    }

    public final Context zze() {
        Object object = this.zza;
        synchronized (object) {
            zzawv zzawv2 = this.zzb;
            if (zzawv2 == null) return null;
            zzawv2 = zzawv2.zzj();
            return zzawv2;
        }
    }
}
