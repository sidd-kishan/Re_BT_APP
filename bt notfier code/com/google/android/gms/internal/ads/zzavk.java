/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.graphics.SurfaceTexture
 *  android.opengl.EGL14
 *  android.opengl.EGLDisplay
 *  android.view.Surface
 *  com.google.android.gms.internal.ads.zzaup
 *  com.google.android.gms.internal.ads.zzave
 *  com.google.android.gms.internal.ads.zzavi
 *  com.google.android.gms.internal.ads.zzavj
 */
package com.google.android.gms.internal.ads;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.opengl.EGL14;
import android.opengl.EGLDisplay;
import android.view.Surface;
import com.google.android.gms.internal.ads.zzaup;
import com.google.android.gms.internal.ads.zzave;
import com.google.android.gms.internal.ads.zzavi;
import com.google.android.gms.internal.ads.zzavj;

public final class zzavk
extends Surface {
    private static boolean zza;
    private static boolean zzb;
    private final zzavi zzc;
    private boolean zzd;

    /* synthetic */ zzavk(zzavi zzavi2, SurfaceTexture surfaceTexture, boolean bl, zzavj zzavj2) {
        super(surfaceTexture);
        this.zzc = zzavi2;
    }

    public static boolean zza(Context context) {
        synchronized (zzavk.class) {
            boolean bl;
            if (!zzb) {
                if (zzave.zza >= 17) {
                    boolean bl2 = false;
                    String string = EGL14.eglQueryString((EGLDisplay)EGL14.eglGetDisplay((int)0), (int)12373);
                    bl = bl2;
                    if (string != null) {
                        bl = bl2;
                        if (string.contains("EGL_EXT_protected_content")) {
                            bl = zzave.zza == 24 && (zzave.zzd.startsWith("SM-G950") || zzave.zzd.startsWith("SM-G955")) && !context.getPackageManager().hasSystemFeature("android.hardware.vr.high_performance") ? bl2 : true;
                        }
                    }
                    zza = bl;
                }
                zzb = true;
            }
            bl = zza;
            return bl;
        }
    }

    public static zzavk zzb(Context context, boolean bl) {
        boolean bl2;
        if (zzave.zza < 17) throw new UnsupportedOperationException("Unsupported prior to API level 17");
        boolean bl3 = bl2 = true;
        if (bl) {
            bl3 = zzavk.zza(context) ? bl2 : false;
        }
        zzaup.zzd((boolean)bl3);
        return new zzavi().zza(bl);
    }

    public final void release() {
        super.release();
        zzavi zzavi2 = this.zzc;
        synchronized (zzavi2) {
            if (this.zzd) return;
            this.zzc.zzb();
            this.zzd = true;
            return;
        }
    }
}
