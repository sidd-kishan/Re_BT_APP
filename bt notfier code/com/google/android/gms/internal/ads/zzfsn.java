/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzfsm
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzfsm;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;

public interface zzfsn
extends ExecutorService {
    public zzfsm<?> zza(Runnable var1);

    public <T> zzfsm<T> zzb(Callable<T> var1);
}
