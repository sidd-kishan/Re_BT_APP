/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzgks
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzgks;
import java.util.logging.Level;
import java.util.logging.Logger;

public final class zzgkp
extends zzgks {
    final Logger zza;

    public zzgkp(String string) {
        this.zza = Logger.getLogger(string);
    }

    public final void zza(String string) {
        this.zza.logp(Level.FINE, "com.googlecode.mp4parser.util.JuliLogger", "logDebug", string);
    }
}
