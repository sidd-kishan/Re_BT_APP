/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.content.Context
 *  android.util.Base64
 *  android.view.MotionEvent
 *  android.view.View
 *  com.google.android.gms.internal.ads.zzfii
 *  com.google.android.gms.internal.ads.zzfil
 *  com.google.android.gms.internal.ads.zzfjw
 *  com.google.android.gms.internal.ads.zzfkf
 *  com.google.android.gms.internal.ads.zzfkh
 *  com.google.android.gms.internal.ads.zzgex
 *  com.google.android.gms.internal.ads.zzzl
 *  com.google.android.gms.internal.ads.zzzm
 */
package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.util.Base64;
import android.view.MotionEvent;
import android.view.View;
import com.google.android.gms.internal.ads.zzfii;
import com.google.android.gms.internal.ads.zzfil;
import com.google.android.gms.internal.ads.zzfjw;
import com.google.android.gms.internal.ads.zzfkf;
import com.google.android.gms.internal.ads.zzfkh;
import com.google.android.gms.internal.ads.zzgex;
import com.google.android.gms.internal.ads.zzzl;
import com.google.android.gms.internal.ads.zzzm;
import java.util.HashMap;
import java.util.Map;

final class zzfjv
implements zzfil {
    private final Object zza;
    private final zzfjw zzb;
    private final zzfkh zzc;
    private final zzfii zzd;

    zzfjv(Object object, zzfjw zzfjw2, zzfkh zzfkh2, zzfii zzfii2) {
        this.zza = object;
        this.zzb = zzfjw2;
        this.zzc = zzfkh2;
        this.zzd = zzfii2;
    }

    private static String zzi(byte[] byArray) {
        if (byArray == null) {
            return null;
        }
        zzzl zzzl2 = zzzm.zza();
        zzzl2.zzc(5);
        zzzl2.zza(zzgex.zzt((byte[])byArray));
        return Base64.encodeToString((byte[])((zzzm)zzzl2.zzah()).zzao(), (int)11);
    }

    private final byte[] zzj(Map<String, String> object, Map<String, Object> map) {
        synchronized (this) {
            long l = System.currentTimeMillis();
            try {
                object = (byte[])this.zza.getClass().getDeclaredMethod("xss", Map.class, Map.class).invoke(this.zza, null, map);
                return object;
            }
            catch (Exception exception) {
                this.zzd.zzc(2007, System.currentTimeMillis() - l, exception);
                return null;
            }
        }
    }

    public final String zza(Context object, String object2) {
        synchronized (this) {
            object2 = this.zzc.zzb();
            object2.put("f", "q");
            object2.put("ctx", object);
            object2.put("aid", null);
            object = zzfjv.zzi(this.zzj(null, (Map<String, Object>)object2));
            return object;
        }
    }

    public final String zzb(Context object, String object2, View view, Activity activity) {
        synchronized (this) {
            object2 = this.zzc.zzc();
            object2.put("f", "v");
            object2.put("ctx", object);
            object2.put("aid", null);
            object2.put("view", view);
            object2.put("act", null);
            object = zzfjv.zzi(this.zzj(null, (Map<String, Object>)object2));
            return object;
        }
    }

    public final String zzc(Context object, String object2, String string, View view, Activity activity) {
        synchronized (this) {
            object2 = this.zzc.zzd();
            object2.put("f", "c");
            object2.put("ctx", object);
            object2.put("cs", string);
            object2.put("aid", null);
            object2.put("view", view);
            object2.put("act", activity);
            object = zzfjv.zzi(this.zzj(null, (Map<String, Object>)object2));
            return object;
        }
    }

    public final void zzd(String zzfkf2, MotionEvent motionEvent) throws zzfkf {
        synchronized (this) {
            try {
                try {
                    long l = System.currentTimeMillis();
                    zzfkf2 = new HashMap();
                    Throwable throwable = new Throwable();
                    zzfkf2.put("t", throwable);
                    zzfkf2.put("aid", null);
                    zzfkf2.put("evt", motionEvent);
                    this.zza.getClass().getDeclaredMethod("he", Map.class).invoke(this.zza, zzfkf2);
                    this.zzd.zzb(3003, System.currentTimeMillis() - l);
                    return;
                }
                catch (Exception exception) {
                    zzfkf2 = new zzfkf(2005, (Throwable)exception);
                    throw zzfkf2;
                }
            }
            catch (Throwable throwable) {}
            throw throwable;
        }
    }

    final zzfjw zze() {
        return this.zzb;
    }

    final boolean zzf() throws zzfkf {
        synchronized (this) {
            try {
                try {
                    boolean bl = (Boolean)this.zza.getClass().getDeclaredMethod("init", new Class[0]).invoke(this.zza, new Object[0]);
                    return bl;
                }
                catch (Exception exception) {
                    zzfkf zzfkf2 = new zzfkf(2001, (Throwable)exception);
                    throw zzfkf2;
                }
            }
            catch (Throwable throwable) {}
            throw throwable;
        }
    }

    public final void zzg() throws zzfkf {
        synchronized (this) {
            try {
                try {
                    long l = System.currentTimeMillis();
                    this.zza.getClass().getDeclaredMethod("close", new Class[0]).invoke(this.zza, new Object[0]);
                    this.zzd.zzb(3001, System.currentTimeMillis() - l);
                    return;
                }
                catch (Exception exception) {
                    zzfkf zzfkf2 = new zzfkf(2003, (Throwable)exception);
                    throw zzfkf2;
                }
            }
            catch (Throwable throwable) {}
            throw throwable;
        }
    }

    public final int zzh() throws zzfkf {
        synchronized (this) {
            try {
                try {
                    int n = (Integer)this.zza.getClass().getDeclaredMethod("lcs", new Class[0]).invoke(this.zza, new Object[0]);
                    return n;
                }
                catch (Exception exception) {
                    zzfkf zzfkf2 = new zzfkf(2006, (Throwable)exception);
                    throw zzfkf2;
                }
            }
            catch (Throwable throwable) {}
            throw throwable;
        }
    }
}
