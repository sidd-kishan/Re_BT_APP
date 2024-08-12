/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.os.Bundle
 *  android.os.IBinder
 *  android.os.RemoteException
 *  com.google.android.gms.dynamite.DynamiteModule
 *  com.google.android.gms.internal.ads.zzbep
 *  com.google.android.gms.internal.ads.zzber
 *  com.google.android.gms.internal.ads.zzbfv
 *  com.google.android.gms.internal.ads.zzbfx
 *  com.google.android.gms.internal.ads.zzbjl
 *  com.google.android.gms.internal.ads.zzbku
 *  com.google.android.gms.internal.ads.zzblf
 *  com.google.android.gms.internal.ads.zzcgm
 *  com.google.android.gms.internal.ads.zzcgt
 */
package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import com.google.android.gms.dynamite.DynamiteModule;
import com.google.android.gms.internal.ads.zzbep;
import com.google.android.gms.internal.ads.zzber;
import com.google.android.gms.internal.ads.zzbfv;
import com.google.android.gms.internal.ads.zzbfx;
import com.google.android.gms.internal.ads.zzbjl;
import com.google.android.gms.internal.ads.zzbku;
import com.google.android.gms.internal.ads.zzblf;
import com.google.android.gms.internal.ads.zzcgm;
import com.google.android.gms.internal.ads.zzcgt;

abstract class zzbeq<T> {
    private static final zzbfx zza;

    static {
        Object var0;
        block4: {
            Object object;
            var0 = null;
            try {
                object = zzbep.class.getClassLoader().loadClass("com.google.android.gms.ads.internal.ClientApi").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
                if (!(object instanceof IBinder)) {
                    zzcgt.zzi((String)"ClientApi class is not an instance of IBinder.");
                    break block4;
                }
                IBinder iBinder = (IBinder)object;
                if (iBinder == null) break block4;
                object = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IClientApi");
                if (object instanceof zzbfx) {
                    object = (zzbfx)object;
                    var0 = object;
                    break block4;
                }
                object = new zzbfv(iBinder);
            }
            catch (Exception exception) {
                zzcgt.zzi((String)"Failed to instantiate ClientApi class.");
                break block4;
            }
            var0 = object;
        }
        zza = var0;
    }

    zzbeq() {
    }

    private final T zze() {
        Object object = zza;
        if (object == null) {
            zzcgt.zzi((String)"ClientApi class cannot be loaded.");
            return null;
        }
        try {
            object = this.zzc((zzbfx)object);
        }
        catch (RemoteException remoteException) {
            zzcgt.zzj((String)"Cannot invoke local loader using ClientApi class.", (Throwable)remoteException);
            return null;
        }
        return (T)object;
    }

    private final T zzf() {
        T t;
        try {
            t = this.zzb();
        }
        catch (RemoteException remoteException) {
            zzcgt.zzj((String)"Cannot invoke remote loader.", (Throwable)remoteException);
            return null;
        }
        return t;
    }

    protected abstract T zza();

    protected abstract T zzb() throws RemoteException;

    protected abstract T zzc(zzbfx var1) throws RemoteException;

    /*
     * Unable to fully structure code
     * Could not resolve type clashes
     */
    public final T zzd(Context var1_1, boolean var2_2) {
        block10: {
            var6_3 = var2_2;
            if (!var2_2) {
                zzber.zza();
                var6_3 = var2_2;
                if (!zzcgm.zzn((Context)var1_1 /* !! */ , (int)12451000)) {
                    zzcgt.zzd((String)"Google Play Services is not available.");
                    var6_3 = 1;
                }
            }
            var3_4 = DynamiteModule.getLocalVersion((Context)var1_1 /* !! */ , (String)"com.google.android.gms.ads.dynamite");
            var5_5 = DynamiteModule.getRemoteVersion((Context)var1_1 /* !! */ , (String)"com.google.android.gms.ads.dynamite");
            var4_6 = 0;
            var3_4 = var3_4 > var5_5 ? 0 : 1;
            zzbjl.zza((Context)var1_1 /* !! */ );
            if (!((Boolean)zzbku.zza.zze()).booleanValue()) break block10;
            var3_4 = var4_6;
            ** GOTO lbl23
        }
        if (((Boolean)zzbku.zzb.zze()).booleanValue()) {
            var4_6 = 1;
            var3_4 = 1;
        } else {
            var3_4 = var6_3 | var3_4 ^ 1;
lbl23:
            // 2 sources

            var4_6 = 0;
        }
        if (var3_4 != 0) {
            var7_7 /* !! */  = this.zze();
            var1_1 /* !! */  = var7_7 /* !! */ ;
            if (var7_7 /* !! */  == null) {
                var1_1 /* !! */  = var7_7 /* !! */ ;
                if (var4_6 == 0) {
                    var1_1 /* !! */  = this.zzf();
                }
            }
        } else {
            var7_7 /* !! */  = this.zzf();
            if (var7_7 /* !! */  == null) {
                var3_4 = ((Long)zzblf.zza.zze()).intValue();
                if (zzber.zze().nextInt(var3_4) == 0) {
                    var8_8 = new Bundle();
                    var8_8.putString("action", "dynamite_load");
                    var8_8.putInt("is_missing", 1);
                    zzber.zza().zze(var1_1 /* !! */ , zzber.zzd().zza, "gmob-apps", var8_8, true);
                }
            }
            var1_1 /* !! */  = var7_7 /* !! */  == null ? this.zze() : var7_7 /* !! */ ;
        }
        var7_7 /* !! */  = var1_1 /* !! */ ;
        if (var1_1 /* !! */  != null) return var7_7 /* !! */ ;
        var7_7 /* !! */  = this.zza();
        return var7_7 /* !! */ ;
    }
}
