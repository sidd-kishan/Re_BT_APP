/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Bundle
 *  com.google.android.gms.internal.ads.zzeqy
 *  com.google.android.gms.internal.ads.zzfrj
 *  com.google.android.gms.internal.ads.zzfsm
 */
package com.google.android.gms.internal.ads;

import android.os.Bundle;
import com.google.android.gms.internal.ads.zzeqy;
import com.google.android.gms.internal.ads.zzfrj;
import com.google.android.gms.internal.ads.zzfsm;
import java.util.List;

final class zzeqt
implements zzfrj {
    private final zzeqy zza;
    private final String zzb;
    private final List zzc;
    private final Bundle zzd;

    zzeqt(zzeqy zzeqy2, String string, List list, Bundle bundle) {
        this.zza = zzeqy2;
        this.zzb = string;
        this.zzc = list;
        this.zzd = bundle;
    }

    public final zzfsm zza() {
        return this.zza.zzc(this.zzb, this.zzc, this.zzd);
    }
}
