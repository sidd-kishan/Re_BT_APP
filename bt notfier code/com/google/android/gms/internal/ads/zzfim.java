/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzfij
 *  com.google.android.gms.internal.ads.zzfik
 *  com.google.android.gms.internal.ads.zzfio
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzfij;
import com.google.android.gms.internal.ads.zzfik;
import com.google.android.gms.internal.ads.zzfio;

final class zzfim
extends zzfij {
    private String zza;
    private Boolean zzb;
    private Boolean zzc;

    zzfim() {
    }

    public final zzfij zza(String string) {
        if (string == null) throw new NullPointerException("Null clientVersion");
        this.zza = string;
        return this;
    }

    public final zzfij zzb(boolean bl) {
        this.zzb = bl;
        return this;
    }

    public final zzfij zzc(boolean bl) {
        this.zzc = true;
        return this;
    }

    public final zzfik zzd() {
        Boolean bl;
        CharSequence charSequence = this.zza;
        if (charSequence != null && (bl = this.zzb) != null) {
            if (this.zzc != null) return new zzfio((String)charSequence, bl.booleanValue(), this.zzc.booleanValue(), null);
        }
        charSequence = new StringBuilder();
        if (this.zza == null) {
            ((StringBuilder)charSequence).append(" clientVersion");
        }
        if (this.zzb == null) {
            ((StringBuilder)charSequence).append(" shouldGetAdvertisingId");
        }
        if (this.zzc != null) throw new IllegalStateException("Missing required properties:".concat(charSequence.toString()));
        ((StringBuilder)charSequence).append(" isGooglePlayServicesAvailable");
        throw new IllegalStateException("Missing required properties:".concat(charSequence.toString()));
    }
}
