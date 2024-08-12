/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzflu
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzflu;
import java.util.logging.Logger;
import javax.annotation.CheckForNull;

final class zzflw {
    private static final Logger zza = Logger.getLogger(zzflw.class.getName());
    private static final zzflu zzb = new zzflu(null);

    private zzflw() {
    }

    static boolean zza(@CheckForNull String string) {
        if (string == null) return true;
        if (!string.isEmpty()) return false;
        return true;
    }

    static String zzb(@CheckForNull String string) {
        String string2 = string;
        if (string != null) return string2;
        string2 = "";
        return string2;
    }
}
