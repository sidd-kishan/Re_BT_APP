/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.ads.internal.zzt
 *  com.google.android.gms.internal.ads.zzepa
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.zzt;
import com.google.android.gms.internal.ads.zzepa;
import java.util.concurrent.Callable;

final class zzeoy
implements Callable {
    static final Callable zza = new zzeoy();

    private zzeoy() {
    }

    public final Object call() {
        return new zzepa(zzt.zzm().zzi(), zzt.zzm().zzm());
    }
}
