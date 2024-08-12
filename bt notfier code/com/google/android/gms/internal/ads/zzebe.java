/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Bundle
 *  com.google.android.gms.ads.internal.zzt
 *  com.google.android.gms.internal.ads.zzesq
 *  com.google.android.gms.internal.ads.zzfrk
 *  com.google.android.gms.internal.ads.zzfsm
 */
package com.google.android.gms.internal.ads;

import android.os.Bundle;
import com.google.android.gms.ads.internal.zzt;
import com.google.android.gms.internal.ads.zzesq;
import com.google.android.gms.internal.ads.zzfrk;
import com.google.android.gms.internal.ads.zzfsm;

final class zzebe
implements zzfrk {
    private final zzesq zza;

    zzebe(zzesq zzesq2) {
        this.zza = zzesq2;
    }

    public final zzfsm zza(Object object) {
        zzesq zzesq2 = this.zza;
        object = (Bundle)object;
        return zzesq2.zza().zza((Object)zzt.zzc().zzl((Bundle)object));
    }
}
