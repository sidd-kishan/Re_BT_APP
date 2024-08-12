/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.pm.PackageInfo
 *  android.util.Base64
 *  com.google.android.gms.ads.identifier.AdvertisingIdClient
 *  com.google.android.gms.ads.identifier.AdvertisingIdClient$Info
 *  com.google.android.gms.internal.ads.zzfii
 *  com.google.android.gms.internal.ads.zzfik
 *  com.google.android.gms.internal.ads.zzfiq
 *  com.google.android.gms.internal.ads.zzfiv
 *  com.google.android.gms.internal.ads.zzfiw
 *  com.google.android.gms.internal.ads.zzfix
 *  com.google.android.gms.internal.ads.zzfiy
 *  com.google.android.gms.internal.ads.zzfiz
 *  com.google.android.gms.internal.ads.zzfja
 *  com.google.android.gms.internal.ads.zzyj
 *  com.google.android.gms.internal.ads.zzyz
 *  com.google.android.gms.tasks.OnFailureListener
 *  com.google.android.gms.tasks.Task
 *  com.google.android.gms.tasks.Tasks
 */
package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.util.Base64;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import com.google.android.gms.internal.ads.zzfii;
import com.google.android.gms.internal.ads.zzfik;
import com.google.android.gms.internal.ads.zzfiq;
import com.google.android.gms.internal.ads.zzfiv;
import com.google.android.gms.internal.ads.zzfiw;
import com.google.android.gms.internal.ads.zzfix;
import com.google.android.gms.internal.ads.zzfiy;
import com.google.android.gms.internal.ads.zzfiz;
import com.google.android.gms.internal.ads.zzfja;
import com.google.android.gms.internal.ads.zzyj;
import com.google.android.gms.internal.ads.zzyz;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import java.nio.ByteBuffer;
import java.util.UUID;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;

public final class zzfjb {
    private final Context zza;
    private final Executor zzb;
    private final zzfii zzc;
    private final zzfik zzd;
    private final zzfja zze;
    private final zzfja zzf;
    private Task<zzyz> zzg;
    private Task<zzyz> zzh;

    zzfjb(Context context, Executor executor, zzfii zzfii2, zzfik zzfik2, zzfiy zzfiy2, zzfiz zzfiz2) {
        this.zza = context;
        this.zzb = executor;
        this.zzc = zzfii2;
        this.zzd = zzfik2;
        this.zze = zzfiy2;
        this.zzf = zzfiz2;
    }

    public static zzfjb zza(Context object, Executor executor, zzfii zzfii2, zzfik zzfik2) {
        object = new zzfjb((Context)object, executor, zzfii2, zzfik2, new zzfiy(), new zzfiz());
        ((zzfjb)object).zzg = ((zzfjb)object).zzd.zzb() ? super.zzg((Callable<zzyz>)new zzfiv((zzfjb)object)) : Tasks.forResult((Object)((zzfjb)object).zze.zza());
        ((zzfjb)object).zzh = super.zzg((Callable<zzyz>)new zzfiw((zzfjb)object));
        return object;
    }

    private final Task<zzyz> zzg(Callable<zzyz> callable) {
        return Tasks.call((Executor)this.zzb, callable).addOnFailureListener(this.zzb, (OnFailureListener)new zzfix(this));
    }

    private static zzyz zzh(Task<zzyz> task, zzyz zzyz2) {
        if (task.isSuccessful()) return (zzyz)task.getResult();
        return zzyz2;
    }

    public final zzyz zzb() {
        return zzfjb.zzh(this.zzg, this.zze.zza());
    }

    public final zzyz zzc() {
        return zzfjb.zzh(this.zzh, this.zzf.zza());
    }

    final /* synthetic */ void zzd(Exception exception) {
        if (exception instanceof InterruptedException) {
            Thread.currentThread().interrupt();
        }
        this.zzc.zzc(2025, -1L, exception);
    }

    final /* synthetic */ zzyz zze() throws Exception {
        Context context = this.zza;
        PackageInfo packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
        return zzfiq.zza((Context)context, (String)context.getPackageName(), (String)Integer.toString(packageInfo.versionCode));
    }

    final /* synthetic */ zzyz zzf() throws Exception {
        Object object;
        Object object2 = this.zza;
        zzyj zzyj2 = zzyz.zzi();
        AdvertisingIdClient.Info info = AdvertisingIdClient.getAdvertisingIdInfo((Context)object2);
        object2 = object = info.getId();
        if (object != null) {
            object2 = object;
            if (((String)object).matches("^[a-fA-F0-9]{8}-([a-fA-F0-9]{4}-){3}[a-fA-F0-9]{12}$")) {
                object2 = UUID.fromString((String)object);
                byte[] byArray = new byte[16];
                object = ByteBuffer.wrap(byArray);
                ((ByteBuffer)object).putLong(((UUID)object2).getMostSignificantBits());
                ((ByteBuffer)object).putLong(((UUID)object2).getLeastSignificantBits());
                object2 = Base64.encodeToString((byte[])byArray, (int)11);
            }
        }
        if (object2 == null) return (zzyz)zzyj2.zzah();
        zzyj2.zzS((String)object2);
        zzyj2.zzT(info.isLimitAdTrackingEnabled());
        zzyj2.zzaa(6);
        return (zzyz)zzyj2.zzah();
    }
}
