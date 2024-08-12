/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.os.Bundle
 *  com.google.android.gms.internal.ads.zzfie
 *  com.google.android.gms.internal.ads.zzfii
 *  com.google.android.gms.internal.ads.zzfil
 *  com.google.android.gms.internal.ads.zzfjv
 *  com.google.android.gms.internal.ads.zzfjw
 *  com.google.android.gms.internal.ads.zzfkf
 *  com.google.android.gms.internal.ads.zzfkh
 *  dalvik.system.DexClassLoader
 */
package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import com.google.android.gms.internal.ads.zzfie;
import com.google.android.gms.internal.ads.zzfii;
import com.google.android.gms.internal.ads.zzfil;
import com.google.android.gms.internal.ads.zzfjv;
import com.google.android.gms.internal.ads.zzfjw;
import com.google.android.gms.internal.ads.zzfkf;
import com.google.android.gms.internal.ads.zzfkh;
import dalvik.system.DexClassLoader;
import java.io.File;
import java.io.Serializable;
import java.security.GeneralSecurityException;
import java.util.HashMap;

public final class zzfkg {
    private static final HashMap<String, Class<?>> zza = new HashMap();
    private final Context zzb;
    private final zzfkh zzc;
    private final zzfii zzd;
    private final zzfie zze;
    private zzfjv zzf;
    private final Object zzg = new Object();

    public zzfkg(Context context, zzfkh zzfkh2, zzfii zzfii2, zzfie zzfie2) {
        this.zzb = context;
        this.zzc = zzfkh2;
        this.zzd = zzfii2;
        this.zze = zzfie2;
    }

    /*
     * WARNING - void declaration
     * Enabled unnecessary exception pruning
     */
    private final Class<?> zzd(zzfjw object) throws zzfkf {
        synchronized (this) {
            block12: {
                void var1_6;
                Class clazz;
                String string = object.zza().zza();
                Serializable serializable = zza.get(string);
                if (serializable != null) {
                    return serializable;
                }
                try {
                    boolean bl = this.zze.zza(object.zzb());
                    if (!bl) break block12;
                }
                catch (GeneralSecurityException generalSecurityException) {
                    string = new zzfkf(2026, (Throwable)generalSecurityException);
                    throw string;
                }
                try {
                    serializable = object.zzc();
                    if (!((File)serializable).exists()) {
                        ((File)serializable).mkdirs();
                    }
                    DexClassLoader dexClassLoader = new DexClassLoader(object.zzb().getAbsolutePath(), ((File)serializable).getAbsolutePath(), null, this.zzb.getClassLoader());
                    clazz = dexClassLoader.loadClass("com.google.ccc.abuse.droidguard.DroidGuard");
                }
                catch (IllegalArgumentException illegalArgumentException) {
                }
                catch (SecurityException securityException) {
                }
                catch (ClassNotFoundException classNotFoundException) {
                    // empty catch block
                }
                zza.put(string, clazz);
                return clazz;
                string = new zzfkf(2008, (Throwable)var1_6);
                throw string;
            }
            zzfkf zzfkf2 = new zzfkf(2026, "VM did not pass signature verification");
            throw zzfkf2;
        }
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Unable to fully structure code
     * Enabled unnecessary exception pruning
     */
    public final boolean zza(zzfjw var1_1) {
        block14: {
            block15: {
                var3_5 = System.currentTimeMillis();
                try {
                    var5_6 = this.zzd(var1_1 /* !! */ );
                }
                catch (Exception var1_3) {
                    this.zzd.zzc(4010, System.currentTimeMillis() - var3_5, var1_3);
                    return false;
                }
                catch (zzfkf var1_4) {
                    this.zzd.zzc(var1_4.zza(), System.currentTimeMillis() - var3_5, (Exception)var1_4);
                    return false;
                }
                try {
                    var5_6 = var5_6.getDeclaredConstructor(new Class[]{Context.class, String.class, byte[].class, Object.class, Bundle.class, Integer.TYPE});
                    var7_7 = this.zzb;
                    var6_8 /* !! */  = var1_1 /* !! */ .zzd();
                    var8_10 = new Bundle();
                    var6_8 /* !! */  = (byte[])var5_6.newInstance(new Object[]{var7_7, "msa-r", var6_8 /* !! */ , null, var8_10, 2});
                }
                catch (Exception var1_2) {
                    var5_6 = new zzfkf(2004, (Throwable)var1_2);
                    throw var5_6;
                }
                {
                    var5_6 = new zzfjv((Object)var6_8 /* !! */ , var1_1 /* !! */ , this.zzc, this.zzd);
                    if (!var5_6.zzf()) break block14;
                    var2_11 = var5_6.zzh();
                    if (var2_11 != 0) break block15;
                    var1_1 /* !! */  = this.zzg;
                    ** synchronized (var1_1 /* !! */ )
                }
lbl-1000:
                // 1 sources

                {
                    var6_8 /* !! */  = (byte[])this.zzf;
                    if (var6_8 /* !! */  != null) {
                        try {
                            var6_8 /* !! */ .zzg();
                        }
                        catch (zzfkf var6_9) {
                            this.zzd.zzc(var6_9.zza(), -1L, (Exception)var6_9);
                        }
                    }
                    this.zzf = var5_6;
                }
                {
                    this.zzd.zzb(3000, System.currentTimeMillis() - var3_5);
                    return true;
                }
            }
            var5_6 = new StringBuilder(15);
            var5_6.append("ci: ");
            var5_6.append(var2_11);
            var1_1 /* !! */  = new zzfkf(4001, var5_6.toString());
            throw var1_1 /* !! */ ;
        }
        var1_1 /* !! */  = new zzfkf(4000, "init failed");
        throw var1_1 /* !! */ ;
    }

    public final zzfil zzb() {
        Object object = this.zzg;
        synchronized (object) {
            zzfjv zzfjv2 = this.zzf;
            return zzfjv2;
        }
    }

    public final zzfjw zzc() {
        Object object = this.zzg;
        synchronized (object) {
            zzfjv zzfjv2 = this.zzf;
            if (zzfjv2 == null) return null;
            zzfjv2 = zzfjv2.zze();
            return zzfjv2;
        }
    }
}
