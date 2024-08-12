/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.common.providers.PooledExecutorsProvider$PooledExecutorFactory
 *  com.google.android.gms.common.providers.zza
 */
package com.google.android.gms.common.providers;

import com.google.android.gms.common.providers.PooledExecutorsProvider;
import com.google.android.gms.common.providers.zza;

@Deprecated
public class PooledExecutorsProvider {
    private static PooledExecutorFactory zza;

    private PooledExecutorsProvider() {
    }

    @Deprecated
    public static PooledExecutorFactory getInstance() {
        synchronized (PooledExecutorsProvider.class) {
            zza zza2;
            if (zza == null) {
                zza2 = new zza();
                zza = zza2;
            }
            zza2 = zza;
            return zza2;
        }
    }
}
