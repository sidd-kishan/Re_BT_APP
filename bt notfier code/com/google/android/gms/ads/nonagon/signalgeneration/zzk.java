/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.net.Uri
 *  com.google.android.gms.ads.nonagon.signalgeneration.zzv
 *  com.google.android.gms.internal.ads.zzfrk
 *  com.google.android.gms.internal.ads.zzfsm
 */
package com.google.android.gms.ads.nonagon.signalgeneration;

import android.net.Uri;
import com.google.android.gms.ads.nonagon.signalgeneration.zzv;
import com.google.android.gms.internal.ads.zzfrk;
import com.google.android.gms.internal.ads.zzfsm;

final class zzk
implements zzfrk {
    private final zzv zza;

    zzk(zzv zzv2) {
        this.zza = zzv2;
    }

    public final zzfsm zza(Object object) {
        return this.zza.zzB((Uri)object);
    }
}
