/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.ads.nonagon.signalgeneration.zze
 *  com.google.android.gms.internal.ads.zzepc
 *  com.google.android.gms.internal.ads.zzepe
 *  com.google.android.gms.internal.ads.zzery
 *  com.google.android.gms.internal.ads.zzfar
 *  com.google.android.gms.internal.ads.zzfsm
 *  com.google.android.gms.internal.ads.zzfsn
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.nonagon.signalgeneration.zze;
import com.google.android.gms.internal.ads.zzepc;
import com.google.android.gms.internal.ads.zzepe;
import com.google.android.gms.internal.ads.zzery;
import com.google.android.gms.internal.ads.zzfar;
import com.google.android.gms.internal.ads.zzfsm;
import com.google.android.gms.internal.ads.zzfsn;
import java.util.concurrent.Callable;

public final class zzepd
implements zzery<zzepe> {
    private final zzfsn zza;
    private final zzfar zzb;

    zzepd(zzfsn zzfsn2, zzfar zzfar2) {
        this.zza = zzfsn2;
        this.zzb = zzfar2;
    }

    public final zzfsm<zzepe> zza() {
        return this.zza.zzb((Callable)new zzepc(this));
    }

    final /* synthetic */ zzepe zzb() throws Exception {
        return new zzepe("requester_type_2".equals(zze.zzd((zzfar)this.zzb)));
    }
}
