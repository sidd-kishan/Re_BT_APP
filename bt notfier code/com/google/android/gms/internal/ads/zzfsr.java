/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzfmk
 *  com.google.android.gms.internal.ads.zzfqw$zzj
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzfmk;
import com.google.android.gms.internal.ads.zzfqw;

final class zzfsr
extends zzfqw.zzj<Void>
implements Runnable {
    private final Runnable zza;

    public zzfsr(Runnable runnable) {
        if (runnable == null) throw null;
        this.zza = runnable;
    }

    @Override
    public final void run() {
        try {
            this.zza.run();
            return;
        }
        catch (Throwable throwable) {
            this.zzq(throwable);
            zzfmk.zza((Throwable)throwable);
            throw new RuntimeException(throwable);
        }
    }

    protected final String zzc() {
        String string = String.valueOf(this.zza);
        StringBuilder stringBuilder = new StringBuilder(String.valueOf(string).length() + 7);
        stringBuilder.append("task=[");
        stringBuilder.append(string);
        stringBuilder.append("]");
        return stringBuilder.toString();
    }
}
