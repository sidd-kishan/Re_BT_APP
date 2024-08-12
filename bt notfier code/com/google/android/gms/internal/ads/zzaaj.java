/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzaal
 *  com.google.android.gms.internal.ads.zzfie
 *  com.google.android.gms.internal.ads.zzfkd
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzaal;
import com.google.android.gms.internal.ads.zzfie;
import com.google.android.gms.internal.ads.zzfkd;
import java.io.File;
import java.security.GeneralSecurityException;

final class zzaaj
implements zzfkd {
    final zzfie zza;

    zzaaj(zzaal zzaal2, zzfie zzfie2) {
        this.zza = zzfie2;
    }

    public final boolean zza(File file) {
        try {
            boolean bl = this.zza.zza(file);
            return bl;
        }
        catch (GeneralSecurityException generalSecurityException) {
            return false;
        }
    }
}
