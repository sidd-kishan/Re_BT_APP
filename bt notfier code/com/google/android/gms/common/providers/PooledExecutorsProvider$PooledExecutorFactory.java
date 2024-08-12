/*
 * Decompiled with CFR 0.152.
 */
package com.google.android.gms.common.providers;

import java.util.concurrent.ScheduledExecutorService;

public static interface PooledExecutorsProvider.PooledExecutorFactory {
    @Deprecated
    public ScheduledExecutorService newSingleThreadScheduledExecutor();
}
