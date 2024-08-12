/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Handler
 *  android.os.Message
 *  com.google.android.gms.internal.ads.zzalf
 *  com.google.android.gms.internal.ads.zzamj
 *  com.google.android.gms.internal.ads.zzaml
 */
package com.google.android.gms.internal.ads;

import android.os.Handler;
import android.os.Message;
import com.google.android.gms.internal.ads.zzalf;
import com.google.android.gms.internal.ads.zzamj;
import com.google.android.gms.internal.ads.zzaml;

final class zzamk
implements zzalf {
    private Message zza;
    private zzaml zzb;

    private zzamk() {
    }

    /* synthetic */ zzamk(zzamj zzamj2) {
    }

    private final void zzd() {
        this.zza = null;
        this.zzb = null;
        zzaml.zzk((zzamk)this);
    }

    public final void zza() {
        Message message = this.zza;
        if (message == null) throw null;
        message.sendToTarget();
        this.zzd();
    }

    public final zzamk zzb(Message message, zzaml zzaml2) {
        this.zza = message;
        this.zzb = zzaml2;
        return this;
    }

    public final boolean zzc(Handler handler) {
        Message message = this.zza;
        if (message == null) throw null;
        boolean bl = handler.sendMessageAtFrontOfQueue(message);
        this.zzd();
        return bl;
    }
}
