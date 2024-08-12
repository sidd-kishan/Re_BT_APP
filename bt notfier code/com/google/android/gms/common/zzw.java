/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.util.Log
 *  com.google.android.gms.common.internal.Preconditions
 *  com.google.android.gms.common.util.AndroidUtilsLight
 *  com.google.android.gms.common.util.Hex
 *  com.google.android.gms.common.zzi
 *  com.google.android.gms.common.zzv
 */
package com.google.android.gms.common;

import android.util.Log;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.AndroidUtilsLight;
import com.google.android.gms.common.util.Hex;
import com.google.android.gms.common.zzi;
import com.google.android.gms.common.zzv;
import java.security.MessageDigest;
import java.util.concurrent.Callable;
import javax.annotation.CheckReturnValue;
import javax.annotation.Nullable;

@CheckReturnValue
class zzw {
    private static final zzw zzd = new zzw(true, null, null);
    final boolean zza;
    @Nullable
    final String zzb;
    @Nullable
    final Throwable zzc;

    zzw(boolean bl, @Nullable String string, @Nullable Throwable throwable) {
        this.zza = bl;
        this.zzb = string;
        this.zzc = throwable;
    }

    static zzw zzb() {
        return zzd;
    }

    static zzw zzc(Callable<String> callable) {
        return new zzv(callable, null);
    }

    static zzw zzd(String string) {
        return new zzw(false, string, null);
    }

    static zzw zze(String string, Throwable throwable) {
        return new zzw(false, string, throwable);
    }

    static String zzg(String string, zzi zzi2, boolean bl, boolean bl2) {
        String string2 = true != bl2 ? "not allowed" : "debug cert rejected";
        MessageDigest messageDigest = AndroidUtilsLight.zza((String)"SHA-1");
        Preconditions.checkNotNull((Object)messageDigest);
        return String.format("%s: pkg=%s, sha1=%s, atk=%s, ver=%s", string2, string, Hex.bytesToStringLowercase((byte[])messageDigest.digest(zzi2.zzc())), bl, "12451000.false");
    }

    @Nullable
    String zza() {
        return this.zzb;
    }

    final void zzf() {
        if (this.zza) return;
        if (!Log.isLoggable((String)"GoogleCertificatesRslt", (int)3)) return;
        if (this.zzc != null) {
            Log.d((String)"GoogleCertificatesRslt", (String)this.zza(), (Throwable)this.zzc);
            return;
        }
        Log.d((String)"GoogleCertificatesRslt", (String)this.zza());
    }
}
