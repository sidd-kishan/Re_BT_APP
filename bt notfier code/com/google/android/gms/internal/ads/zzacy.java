/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzaaw
 *  com.google.android.gms.internal.ads.zzabr
 *  com.google.android.gms.internal.ads.zzacx
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzaaw;
import com.google.android.gms.internal.ads.zzabr;
import com.google.android.gms.internal.ads.zzacx;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Method;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public final class zzacy {
    protected static final String zza = zzacy.class.getSimpleName();
    private final zzabr zzb;
    private final String zzc;
    private final String zzd;
    private volatile Method zze = null;
    private final Class<?>[] zzf;
    private final CountDownLatch zzg = new CountDownLatch(1);

    public zzacy(zzabr zzabr2, String string, String string2, Class<?> ... classArray) {
        this.zzb = zzabr2;
        this.zzc = string;
        this.zzd = string2;
        this.zzf = classArray;
        zzabr2.zze().submit((Runnable)new zzacx(this));
    }

    /*
     * Enabled unnecessary exception pruning
     */
    static /* synthetic */ void zza(zzacy object) {
        block7: {
            block6: {
                Class clazz;
                block5: {
                    clazz = ((zzacy)object).zzb.zzf().loadClass(super.zzc(((zzacy)object).zzb.zzh(), ((zzacy)object).zzc));
                    if (clazz != null) break block5;
                    object = ((zzacy)object).zzg;
                    break block7;
                }
                try {
                    Method method = ((zzacy)object).zze = clazz.getMethod(super.zzc(((zzacy)object).zzb.zzh(), ((zzacy)object).zzd), ((zzacy)object).zzf);
                    if (method != null) break block6;
                }
                catch (Throwable throwable) {
                    ((zzacy)object).zzg.countDown();
                    throw throwable;
                }
                catch (NullPointerException nullPointerException) {
                    object = ((zzacy)object).zzg;
                    break block7;
                }
                catch (zzaaw | UnsupportedEncodingException | ClassNotFoundException | NoSuchMethodException throwable) {}
                object = ((zzacy)object).zzg;
                break block7;
            }
            object = ((zzacy)object).zzg;
        }
        ((CountDownLatch)object).countDown();
    }

    private final String zzc(byte[] byArray, String string) throws zzaaw, UnsupportedEncodingException {
        return new String(this.zzb.zzg().zzb(byArray, string), "UTF-8");
    }

    /*
     * Enabled force condition propagation
     */
    public final Method zzb() {
        if (this.zze != null) {
            return this.zze;
        }
        Method method = null;
        try {
            if (this.zzg.await(2L, TimeUnit.SECONDS)) Method method2;
            return method2 = this.zze;
            return null;
        }
        catch (InterruptedException interruptedException) {
            return method;
        }
    }
}
