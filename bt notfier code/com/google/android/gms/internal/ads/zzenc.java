/*
 * Decompiled with CFR 0.152.
 */
package com.google.android.gms.internal.ads;

import java.util.concurrent.atomic.AtomicBoolean;

public final class zzenc {
    private final AtomicBoolean zza = new AtomicBoolean(false);

    public final void zza(boolean bl) {
        this.zza.set(true);
    }

    public final boolean zzb() {
        return this.zza.get();
    }
}
