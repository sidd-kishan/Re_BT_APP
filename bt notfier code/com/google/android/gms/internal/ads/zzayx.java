/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.os.Binder
 *  com.google.android.gms.ads.internal.zzt
 *  com.google.android.gms.common.internal.BaseGmsClient$BaseConnectionCallbacks
 *  com.google.android.gms.common.internal.BaseGmsClient$BaseOnConnectionFailedListener
 *  com.google.android.gms.internal.ads.zzaym
 *  com.google.android.gms.internal.ads.zzayn
 *  com.google.android.gms.internal.ads.zzayr
 *  com.google.android.gms.internal.ads.zzayv
 *  com.google.android.gms.internal.ads.zzayw
 *  com.google.android.gms.internal.ads.zzayz
 *  com.google.android.gms.internal.ads.zzchl
 */
package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Binder;
import com.google.android.gms.ads.internal.zzt;
import com.google.android.gms.common.internal.BaseGmsClient;
import com.google.android.gms.internal.ads.zzaym;
import com.google.android.gms.internal.ads.zzayn;
import com.google.android.gms.internal.ads.zzayr;
import com.google.android.gms.internal.ads.zzayv;
import com.google.android.gms.internal.ads.zzayw;
import com.google.android.gms.internal.ads.zzayz;
import com.google.android.gms.internal.ads.zzchl;
import java.util.concurrent.Future;

public final class zzayx {
    private zzaym zza;
    private boolean zzb;
    private final Context zzc;
    private final Object zzd = new Object();

    zzayx(Context context) {
        this.zzc = context;
    }

    static /* synthetic */ zzaym zza(zzayx zzayx2) {
        return zzayx2.zza;
    }

    static /* synthetic */ boolean zzb(zzayx zzayx2) {
        return zzayx2.zzb;
    }

    static /* synthetic */ boolean zzc(zzayx zzayx2, boolean bl) {
        zzayx2.zzb = true;
        return true;
    }

    static /* synthetic */ Object zzd(zzayx zzayx2) {
        return zzayx2.zzd;
    }

    static /* synthetic */ void zzf(zzayx zzayx2) {
        Object object = zzayx2.zzd;
        synchronized (object) {
            zzaym zzaym2 = zzayx2.zza;
            if (zzaym2 == null) {
                return;
            }
            zzaym2.disconnect();
            zzayx2.zza = null;
            Binder.flushPendingCommands();
            return;
        }
    }

    final Future<zzayz> zze(zzayn object) {
        zzayr zzayr2 = new zzayr(this);
        zzayv zzayv2 = new zzayv(this, object, (zzchl)zzayr2);
        zzayw zzayw2 = new zzayw(this, (zzchl)zzayr2);
        object = this.zzd;
        synchronized (object) {
            zzaym zzaym2;
            this.zza = zzaym2 = new zzaym(this.zzc, zzt.zzq().zza(), (BaseGmsClient.BaseConnectionCallbacks)zzayv2, (BaseGmsClient.BaseOnConnectionFailedListener)zzayw2);
            zzaym2.checkAvailabilityAndConnect();
            return zzayr2;
        }
    }
}
