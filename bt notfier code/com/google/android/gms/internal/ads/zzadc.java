/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.pm.PackageManager$NameNotFoundException
 *  android.content.pm.PackageManager$OnChecksumsReadyListener
 *  android.os.Build$VERSION
 *  com.google.android.gms.internal.ads.zzadb
 *  com.google.android.gms.internal.ads.zzfsu
 */
package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import com.google.android.gms.internal.ads.zzadb;
import com.google.android.gms.internal.ads.zzfsu;
import java.security.cert.Certificate;
import java.security.cert.CertificateEncodingException;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;

public final class zzadc {
    public static String zza(Context context, String string, List<Certificate> list, Executor executor) throws CertificateEncodingException, PackageManager.NameNotFoundException, InterruptedException, ExecutionException {
        if (Build.VERSION.SDK_INT <= 30 && !Build.VERSION.CODENAME.equals("S")) {
            return null;
        }
        executor = zzfsu.zza();
        context.getPackageManager().requestChecksums(string, false, 8, list, (PackageManager.OnChecksumsReadyListener)new zzadb((zzfsu)executor));
        return (String)executor.get();
    }
}
