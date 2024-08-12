/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.os.StrictMode
 *  android.os.StrictMode$ThreadPolicy
 *  android.os.StrictMode$ThreadPolicy$Builder
 *  com.google.android.gms.ads.internal.zza
 *  com.google.android.gms.ads.internal.zzl
 *  com.google.android.gms.internal.ads.zzaas
 *  com.google.android.gms.internal.ads.zzazb
 *  com.google.android.gms.internal.ads.zzbjl
 *  com.google.android.gms.internal.ads.zzbka
 *  com.google.android.gms.internal.ads.zzbkk
 *  com.google.android.gms.internal.ads.zzcgz
 *  com.google.android.gms.internal.ads.zzchg
 *  com.google.android.gms.internal.ads.zzcml
 *  com.google.android.gms.internal.ads.zzcmt
 *  com.google.android.gms.internal.ads.zzcmu
 *  com.google.android.gms.internal.ads.zzcmw
 *  com.google.android.gms.internal.ads.zzcob
 *  com.google.android.gms.internal.ads.zzezz
 *  com.google.android.gms.internal.ads.zzfac
 *  com.google.android.gms.internal.ads.zzfrj
 *  com.google.android.gms.internal.ads.zzfsd
 *  com.google.android.gms.internal.ads.zzfsm
 */
package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.StrictMode;
import com.google.android.gms.ads.internal.zza;
import com.google.android.gms.ads.internal.zzl;
import com.google.android.gms.internal.ads.zzaas;
import com.google.android.gms.internal.ads.zzazb;
import com.google.android.gms.internal.ads.zzbjl;
import com.google.android.gms.internal.ads.zzbka;
import com.google.android.gms.internal.ads.zzbkk;
import com.google.android.gms.internal.ads.zzcgz;
import com.google.android.gms.internal.ads.zzchg;
import com.google.android.gms.internal.ads.zzcml;
import com.google.android.gms.internal.ads.zzcmt;
import com.google.android.gms.internal.ads.zzcmu;
import com.google.android.gms.internal.ads.zzcmw;
import com.google.android.gms.internal.ads.zzcob;
import com.google.android.gms.internal.ads.zzezz;
import com.google.android.gms.internal.ads.zzfac;
import com.google.android.gms.internal.ads.zzfrj;
import com.google.android.gms.internal.ads.zzfsd;
import com.google.android.gms.internal.ads.zzfsm;
import java.util.concurrent.Executor;
import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
public final class zzcmx {
    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     */
    public static final zzcml zza(Context context, zzcob object, String string, boolean bl, boolean bl2, zzaas zzaas2, zzbkk zzbkk2, zzcgz zzcgz2, zzbka zzbka2, zzl zzl2, zza zza2, zzazb zzazb2, zzezz zzezz2, zzfac zzfac2) throws zzcmw {
        zzbjl.zza((Context)context);
        try {
            zzbka2 = new zzcmu(context, object, string, bl, bl2, zzaas2, zzbkk2, zzcgz2, null, zzl2, zza2, zzazb2, zzezz2, zzfac2);
            context = StrictMode.getThreadPolicy();
        }
        catch (Throwable throwable) {
            throw new zzcmw("Webview initialization failed.", throwable);
        }
        try {
            object = new StrictMode.ThreadPolicy.Builder((StrictMode.ThreadPolicy)context);
            StrictMode.setThreadPolicy((StrictMode.ThreadPolicy)object.permitDiskReads().permitDiskWrites().build());
            object = zzbka2.zza();
        }
        finally {
            StrictMode.setThreadPolicy((StrictMode.ThreadPolicy)context);
        }
        return object;
    }

    public static final zzfsm<zzcml> zzb(Context context, zzcgz zzcgz2, String string, zzaas zzaas2, zza zza2) {
        return zzfsd.zze((zzfrj)new zzcmt(context, zzaas2, zzcgz2, zza2, string), (Executor)zzchg.zze);
    }
}
