/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.os.IBinder
 *  com.google.android.gms.dynamite.DynamiteModule
 *  com.google.android.gms.dynamite.DynamiteModule$VersionPolicy
 *  com.google.android.gms.internal.ads.zzcgv
 *  com.google.android.gms.internal.ads.zzcgw
 */
package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.IBinder;
import com.google.android.gms.dynamite.DynamiteModule;
import com.google.android.gms.internal.ads.zzcgv;
import com.google.android.gms.internal.ads.zzcgw;

public final class zzcgx {
    public static <T> T zza(Context object, String string, zzcgv<IBinder, T> zzcgv2) throws zzcgw {
        try {
            object = zzcgv2.zza((Object)zzcgx.zzc(object).instantiate(string));
        }
        catch (Exception exception) {
            throw new zzcgw((Throwable)exception);
        }
        return (T)object;
    }

    public static Context zzb(Context context) throws zzcgw {
        return zzcgx.zzc(context).getModuleContext();
    }

    private static DynamiteModule zzc(Context context) throws zzcgw {
        try {
            context = DynamiteModule.load((Context)context, (DynamiteModule.VersionPolicy)DynamiteModule.PREFER_REMOTE, (String)"com.google.android.gms.ads.dynamite");
            return context;
        }
        catch (Exception exception) {
            throw new zzcgw((Throwable)exception);
        }
    }
}
