/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzfqw
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzfqw;
import javax.annotation.CheckForNull;

final class zzfqw$zzl {
    static final zzfqw$zzl zza = new zzfqw$zzl(false);
    @CheckForNull
    volatile zzfqw$zzl next;
    @CheckForNull
    volatile Thread thread;

    zzfqw$zzl() {
        zzfqw.zzg().zza(this, Thread.currentThread());
    }

    zzfqw$zzl(boolean bl) {
    }
}
