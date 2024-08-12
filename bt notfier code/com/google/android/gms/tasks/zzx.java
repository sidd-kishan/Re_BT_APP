/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.tasks.zzw
 */
package com.google.android.gms.tasks;

import com.google.android.gms.tasks.zzw;
import java.util.concurrent.Callable;

final class zzx
implements Runnable {
    final zzw zza;
    final Callable zzb;

    zzx(zzw zzw2, Callable callable) {
        this.zza = zzw2;
        this.zzb = callable;
    }

    @Override
    public final void run() {
        try {
            this.zza.zza(this.zzb.call());
            return;
        }
        catch (Throwable throwable) {
            this.zza.zzc((Exception)new RuntimeException(throwable));
            return;
        }
        catch (Exception exception) {
            this.zza.zzc(exception);
            return;
        }
    }
}
