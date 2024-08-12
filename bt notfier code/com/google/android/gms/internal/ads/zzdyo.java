/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzfrk
 *  com.google.android.gms.internal.ads.zzfsd
 *  com.google.android.gms.internal.ads.zzfsm
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzfrk;
import com.google.android.gms.internal.ads.zzfsd;
import com.google.android.gms.internal.ads.zzfsm;
import java.util.concurrent.ExecutionException;

final class zzdyo
implements zzfrk {
    static final zzfrk zza = new zzdyo();

    private zzdyo() {
    }

    public final zzfsm zza(Object object) {
        return zzfsd.zzc((Throwable)((ExecutionException)object).getCause());
    }
}
