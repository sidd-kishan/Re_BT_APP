/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Bundle
 *  com.google.android.gms.common.internal.BaseGmsClient$BaseConnectionCallbacks
 *  com.google.android.gms.internal.ads.zzaym
 *  com.google.android.gms.internal.ads.zzayn
 *  com.google.android.gms.internal.ads.zzays
 *  com.google.android.gms.internal.ads.zzayt
 *  com.google.android.gms.internal.ads.zzayx
 *  com.google.android.gms.internal.ads.zzchg
 *  com.google.android.gms.internal.ads.zzchl
 *  com.google.android.gms.internal.ads.zzfsn
 */
package com.google.android.gms.internal.ads;

import android.os.Bundle;
import com.google.android.gms.common.internal.BaseGmsClient;
import com.google.android.gms.internal.ads.zzaym;
import com.google.android.gms.internal.ads.zzayn;
import com.google.android.gms.internal.ads.zzays;
import com.google.android.gms.internal.ads.zzayt;
import com.google.android.gms.internal.ads.zzayx;
import com.google.android.gms.internal.ads.zzchg;
import com.google.android.gms.internal.ads.zzchl;
import com.google.android.gms.internal.ads.zzfsn;
import java.util.concurrent.Executor;
import java.util.concurrent.Future;

final class zzayv
implements BaseGmsClient.BaseConnectionCallbacks {
    public static final int zzd = 0;
    final zzayn zza;
    final zzchl zzb;
    final zzayx zzc;

    zzayv(zzayx zzayx2, zzayn zzayn2, zzchl zzchl2) {
        this.zzc = zzayx2;
        this.zza = zzayn2;
        this.zzb = zzchl2;
    }

    public final void onConnected(Bundle object) {
        object = zzayx.zzd((zzayx)this.zzc);
        synchronized (object) {
            if (zzayx.zzb((zzayx)this.zzc)) {
                return;
            }
            zzayx.zzc((zzayx)this.zzc, (boolean)true);
            zzaym zzaym2 = zzayx.zza((zzayx)this.zzc);
            if (zzaym2 == null) {
                return;
            }
            zzfsn zzfsn2 = zzchg.zza;
            zzays zzays2 = new zzays(this, zzaym2, this.zza, this.zzb);
            zzfsn2 = zzfsn2.zza((Runnable)zzays2);
            zzaym2 = this.zzb;
            zzays2 = new zzayt((zzchl)zzaym2, (Future)zzfsn2);
            zzaym2.zze((Runnable)zzays2, (Executor)zzchg.zzf);
            return;
        }
    }

    public final void onConnectionSuspended(int n) {
    }
}
