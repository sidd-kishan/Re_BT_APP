/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.view.View
 *  com.google.android.gms.internal.ads.zzefn
 *  com.google.android.gms.internal.ads.zzezz
 *  com.google.android.gms.internal.ads.zzfrk
 *  com.google.android.gms.internal.ads.zzfsm
 */
package com.google.android.gms.internal.ads;

import android.view.View;
import com.google.android.gms.internal.ads.zzefn;
import com.google.android.gms.internal.ads.zzezz;
import com.google.android.gms.internal.ads.zzfrk;
import com.google.android.gms.internal.ads.zzfsm;

final class zzefk
implements zzfrk {
    private final zzefn zza;
    private final View zzb;
    private final zzezz zzc;

    zzefk(zzefn zzefn2, View view, zzezz zzezz2) {
        this.zza = zzefn2;
        this.zzb = view;
        this.zzc = zzezz2;
    }

    public final zzfsm zza(Object object) {
        return this.zza.zze(this.zzb, this.zzc, object);
    }
}
