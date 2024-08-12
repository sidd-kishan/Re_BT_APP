/*
 * Decompiled with CFR 0.152.
 */
package com.google.android.gms.internal.ads;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.logging.Level;
import java.util.logging.Logger;

public final class zzfvx {
    private static final Logger zza = Logger.getLogger(zzfvx.class.getName());
    private static final AtomicBoolean zzb = new AtomicBoolean(false);

    private zzfvx() {
    }

    public static boolean zza() {
        if (!zzb.get()) return false;
        return true;
    }

    static Boolean zzb() {
        try {
            Boolean bl = (Boolean)Class.forName("org.conscrypt.Conscrypt").getMethod("isBoringSslFIPSBuild", new Class[0]).invoke(null, new Object[0]);
            return bl;
        }
        catch (Exception exception) {
            zza.logp(Level.INFO, "com.google.crypto.tink.config.internal.TinkFipsUtil", "checkConscryptIsAvailableAndUsesFipsBoringSsl", "Conscrypt is not available or does not support checking for FIPS build.");
            return false;
        }
    }
}
