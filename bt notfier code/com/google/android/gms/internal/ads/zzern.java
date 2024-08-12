/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.pm.ApplicationInfo
 *  com.google.android.gms.ads.internal.util.zzad
 *  com.google.android.gms.ads.internal.util.zzs
 *  com.google.android.gms.ads.internal.zzt
 *  com.google.android.gms.common.wrappers.Wrappers
 *  com.google.android.gms.dynamite.DynamiteModule
 *  com.google.android.gms.internal.ads.zzcgz
 *  com.google.android.gms.internal.ads.zzerm
 *  com.google.android.gms.internal.ads.zzero
 *  com.google.android.gms.internal.ads.zzery
 *  com.google.android.gms.internal.ads.zzfsm
 *  com.google.android.gms.internal.ads.zzfsn
 */
package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import com.google.android.gms.ads.internal.util.zzad;
import com.google.android.gms.ads.internal.util.zzs;
import com.google.android.gms.ads.internal.zzt;
import com.google.android.gms.common.wrappers.Wrappers;
import com.google.android.gms.dynamite.DynamiteModule;
import com.google.android.gms.internal.ads.zzcgz;
import com.google.android.gms.internal.ads.zzerm;
import com.google.android.gms.internal.ads.zzero;
import com.google.android.gms.internal.ads.zzery;
import com.google.android.gms.internal.ads.zzfsm;
import com.google.android.gms.internal.ads.zzfsn;
import java.util.concurrent.Callable;

public final class zzern
implements zzery<zzero> {
    private final zzfsn zza;
    private final Context zzb;
    private final zzcgz zzc;

    public zzern(zzfsn zzfsn2, Context context, zzcgz zzcgz2) {
        this.zza = zzfsn2;
        this.zzb = context;
        this.zzc = zzcgz2;
    }

    public final zzfsm<zzero> zza() {
        return this.zza.zzb((Callable)new zzerm(this));
    }

    final /* synthetic */ zzero zzb() throws Exception {
        boolean bl = Wrappers.packageManager((Context)this.zzb).isCallerInstantApp();
        zzt.zzc();
        boolean bl2 = zzs.zzH((Context)this.zzb);
        String string = this.zzc.zza;
        zzt.zze();
        boolean bl3 = zzad.zzu();
        zzt.zzc();
        ApplicationInfo applicationInfo = this.zzb.getApplicationInfo();
        int n = applicationInfo == null ? 0 : applicationInfo.targetSdkVersion;
        return new zzero(bl, bl2, string, bl3, n, DynamiteModule.getRemoteVersion((Context)this.zzb, (String)"com.google.android.gms.ads.dynamite"), DynamiteModule.getLocalVersion((Context)this.zzb, (String)"com.google.android.gms.ads.dynamite"));
    }
}
