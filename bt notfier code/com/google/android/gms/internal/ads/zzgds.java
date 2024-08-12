/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzgdr
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzgdr;
import java.security.SecureRandom;

public final class zzgds {
    private static final ThreadLocal<SecureRandom> zza = new zzgdr();

    public static byte[] zza(int n) {
        byte[] byArray = new byte[n];
        zza.get().nextBytes(byArray);
        return byArray;
    }
}
