/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzdym
 *  com.google.android.gms.internal.ads.zzfrk
 *  com.google.android.gms.internal.ads.zzfsd
 *  com.google.android.gms.internal.ads.zzfsm
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzdym;
import com.google.android.gms.internal.ads.zzfrk;
import com.google.android.gms.internal.ads.zzfsd;
import com.google.android.gms.internal.ads.zzfsm;
import java.util.concurrent.TimeoutException;

final class zzdzn
implements zzfrk {
    static final zzfrk zza = new zzdzn();

    private zzdzn() {
    }

    public final zzfsm zza(Object object) {
        object = (TimeoutException)object;
        return zzfsd.zzc((Throwable)new zzdym(5));
    }
}
