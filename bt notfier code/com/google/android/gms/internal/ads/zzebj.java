/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Bundle
 *  com.google.android.gms.ads.internal.zzt
 *  com.google.android.gms.internal.ads.zzesb
 *  com.google.android.gms.internal.ads.zzfrk
 *  com.google.android.gms.internal.ads.zzfsm
 */
package com.google.android.gms.internal.ads;

import android.os.Bundle;
import com.google.android.gms.ads.internal.zzt;
import com.google.android.gms.internal.ads.zzesb;
import com.google.android.gms.internal.ads.zzfrk;
import com.google.android.gms.internal.ads.zzfsm;

final class zzebj
implements zzfrk {
    private final zzesb zza;

    zzebj(zzesb zzesb2) {
        this.zza = zzesb2;
    }

    public final zzfsm zza(Object object) {
        zzesb zzesb2 = this.zza;
        object = (Bundle)object;
        return zzesb2.zza((Object)zzt.zzc().zzl((Bundle)object));
    }
}
