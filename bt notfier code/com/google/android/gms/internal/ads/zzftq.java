/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzftp
 *  com.google.android.gms.internal.ads.zzfum
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzftp;
import com.google.android.gms.internal.ads.zzfum;
import java.security.GeneralSecurityException;

public final class zzftq {
    public static zzftp zza(String string) throws GeneralSecurityException {
        if (zzfum.zzm().containsKey(string)) return (zzftp)zzfum.zzm().get(string);
        string = string.length() != 0 ? "cannot find key template: ".concat(string) : new String("cannot find key template: ");
        throw new GeneralSecurityException(string);
    }
}
