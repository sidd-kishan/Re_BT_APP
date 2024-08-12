/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzgdx
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzgdx;
import java.io.PrintWriter;

final class zzgec
extends zzgdx {
    zzgec() {
    }

    public final void zza(Throwable throwable, Throwable throwable2) {
        throwable.addSuppressed(throwable2);
    }

    public final void zzb(Throwable throwable) {
        throwable.printStackTrace();
    }

    public final void zzc(Throwable throwable, PrintWriter printWriter) {
        throwable.printStackTrace(printWriter);
    }
}
