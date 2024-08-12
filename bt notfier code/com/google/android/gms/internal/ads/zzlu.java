/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.graphics.SurfaceTexture
 *  android.opengl.EGL14
 *  android.opengl.EGLDisplay
 *  android.view.Surface
 *  com.google.android.gms.internal.ads.zzakt
 *  com.google.android.gms.internal.ads.zzamq
 *  com.google.android.gms.internal.ads.zzls
 *  com.google.android.gms.internal.ads.zzlt
 */
package com.google.android.gms.internal.ads;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.opengl.EGL14;
import android.opengl.EGLDisplay;
import android.view.Surface;
import com.google.android.gms.internal.ads.zzakt;
import com.google.android.gms.internal.ads.zzamq;
import com.google.android.gms.internal.ads.zzls;
import com.google.android.gms.internal.ads.zzlt;

public final class zzlu
extends Surface {
    private static int zzb;
    private static boolean zzc;
    public final boolean zza;
    private final zzls zzd;
    private boolean zze;

    /* synthetic */ zzlu(zzls zzls2, SurfaceTexture surfaceTexture, boolean bl, zzlt zzlt2) {
        super(surfaceTexture);
        this.zzd = zzls2;
        this.zza = bl;
    }

    /*
     * Enabled unnecessary exception pruning
     */
    public static boolean zza(Context object) {
        synchronized (zzlu.class) {
            int n;
            block6: {
                block9: {
                    int n2;
                    block8: {
                        block7: {
                            if (zzc) break block6;
                            n = zzamq.zza;
                            n2 = 2;
                            if (n < 24 || zzamq.zza < 26 && ("samsung".equals(zzamq.zzc) || "XT1650".equals(zzamq.zzd)) || zzamq.zza < 26 && !object.getPackageManager().hasSystemFeature("android.hardware.vr.high_performance") || (object = EGL14.eglQueryString((EGLDisplay)EGL14.eglGetDisplay((int)0), (int)12373)) == null || !((String)object).contains("EGL_EXT_protected_content")) break block7;
                            if (zzamq.zza >= 17) break block8;
                            n = n2;
                            break block9;
                        }
                        n = 0;
                        break block9;
                    }
                    object = EGL14.eglQueryString((EGLDisplay)EGL14.eglGetDisplay((int)0), (int)12373);
                    n = n2;
                    if (object != null) {
                        n = n2;
                        if (((String)object).contains("EGL_KHR_surfaceless_context")) {
                            n = 1;
                        }
                    }
                }
                zzb = n;
                zzc = true;
            }
            n = zzb;
            if (n == 0) return false;
            return true;
            finally {
            }
        }
    }

    public static zzlu zzb(Context context, boolean bl) {
        boolean bl2;
        int n = 0;
        boolean bl3 = bl2 = true;
        if (bl) {
            bl3 = zzlu.zza(context) ? bl2 : false;
        }
        zzakt.zzd((boolean)bl3);
        context = new zzls();
        if (!bl) return context.zza(n);
        n = zzb;
        return context.zza(n);
    }

    public final void release() {
        super.release();
        zzls zzls2 = this.zzd;
        synchronized (zzls2) {
            if (this.zze) return;
            this.zzd.zzb();
            this.zze = true;
            return;
        }
    }
}
