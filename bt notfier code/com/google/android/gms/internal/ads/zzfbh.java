/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  com.google.android.gms.ads.internal.util.zze
 *  com.google.android.gms.ads.internal.zzt
 *  com.google.android.gms.internal.ads.zzber
 *  com.google.android.gms.internal.ads.zzcgm
 */
package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.util.zze;
import com.google.android.gms.ads.internal.zzt;
import com.google.android.gms.internal.ads.zzber;
import com.google.android.gms.internal.ads.zzcgm;

public final class zzfbh {
    public static void zza(int n, Throwable throwable, String string) {
        StringBuilder stringBuilder = new StringBuilder(31);
        stringBuilder.append("Ad failed to load : ");
        stringBuilder.append(n);
        zze.zzh((String)stringBuilder.toString());
        zze.zzb((String)string, (Throwable)throwable);
        if (n == 3) {
            return;
        }
        zzt.zzg().zzl(throwable, string);
    }

    public static void zzb(Context object, boolean bl) {
        if (bl) {
            zze.zzh((String)"This request is sent from a test device.");
            return;
        }
        zzber.zza();
        object = zzcgm.zzt((Context)object);
        StringBuilder stringBuilder = new StringBuilder(String.valueOf(object).length() + 102);
        stringBuilder.append("Use RequestConfiguration.Builder().setTestDeviceIds(Arrays.asList(\"");
        stringBuilder.append((String)object);
        stringBuilder.append("\")) to get test ads on this device.");
        zze.zzh((String)stringBuilder.toString());
    }
}
