/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzaal
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzaal;

final class zzaak
implements Runnable {
    final zzaal zza;

    zzaak(zzaal zzaal2) {
        this.zza = zzaal2;
    }

    @Override
    public final void run() {
        Object object = zzaal.zzb((zzaal)this.zza);
        synchronized (object) {
            if (zzaal.zzc((zzaal)this.zza)) return;
            zzaal.zzd((zzaal)this.zza, (boolean)true);
        }
        try {
            zzaal.zzi((zzaal)this.zza);
        }
        catch (Exception exception) {
            zzaal.zza((zzaal)this.zza).zzc(2023, -1L, exception);
        }
        object = zzaal.zzb((zzaal)this.zza);
        synchronized (object) {
            zzaal.zzd((zzaal)this.zza, (boolean)false);
            return;
        }
    }
}
