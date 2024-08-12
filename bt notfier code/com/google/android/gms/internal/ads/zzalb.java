/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.graphics.SurfaceTexture
 *  android.graphics.SurfaceTexture$OnFrameAvailableListener
 *  android.opengl.EGL14
 *  android.opengl.EGLConfig
 *  android.opengl.EGLContext
 *  android.opengl.EGLDisplay
 *  android.opengl.EGLSurface
 *  android.opengl.GLES20
 *  android.opengl.GLU
 *  android.os.Handler
 *  android.util.Log
 *  com.google.android.gms.internal.ads.zzaky
 *  com.google.android.gms.internal.ads.zzala
 *  com.google.android.gms.internal.ads.zzamq
 */
package com.google.android.gms.internal.ads;

import android.graphics.SurfaceTexture;
import android.opengl.EGL14;
import android.opengl.EGLConfig;
import android.opengl.EGLContext;
import android.opengl.EGLDisplay;
import android.opengl.EGLSurface;
import android.opengl.GLES20;
import android.opengl.GLU;
import android.os.Handler;
import android.util.Log;
import com.google.android.gms.internal.ads.zzaky;
import com.google.android.gms.internal.ads.zzala;
import com.google.android.gms.internal.ads.zzamq;

public final class zzalb
implements SurfaceTexture.OnFrameAvailableListener,
Runnable {
    private static final int[] zza = new int[]{12352, 4, 12324, 8, 12323, 8, 12322, 8, 12321, 8, 12325, 0, 12327, 12344, 12339, 4, 12344};
    private final Handler zzb;
    private final int[] zzc;
    private EGLDisplay zzd;
    private EGLContext zze;
    private EGLSurface zzf;
    private SurfaceTexture zzg;

    public zzalb(Handler handler, zzala zzala2) {
        this.zzb = handler;
        this.zzc = new int[1];
    }

    public final void onFrameAvailable(SurfaceTexture surfaceTexture) {
        this.zzb.post((Runnable)this);
    }

    /*
     * Enabled force condition propagation
     */
    @Override
    public final void run() {
        SurfaceTexture surfaceTexture = this.zzg;
        if (surfaceTexture == null) return;
        try {
            surfaceTexture.updateTexImage();
            return;
        }
        catch (RuntimeException runtimeException) {
            return;
        }
    }

    public final void zza(int n) {
        int n2;
        Object object = EGL14.eglGetDisplay((int)0);
        if (object == null) {
            zzaky zzaky2 = new zzaky("eglGetDisplay failed", null);
            throw zzaky2;
        }
        Object object2 = new int[2];
        if (!EGL14.eglInitialize((EGLDisplay)object, (int[])object2, (int)0, (int[])object2, (int)1)) throw new zzaky("eglInitialize failed", null);
        this.zzd = object;
        object2 = new EGLConfig[1];
        Object object3 = new int[1];
        boolean bl = EGL14.eglChooseConfig((EGLDisplay)object, (int[])zza, (int)0, (EGLConfig[])object2, (int)0, (int)1, (int[])object3, (int)0);
        if (!bl || object3[0] <= 0 || (object = (Object)object2[0]) == null) throw new zzaky(zzamq.zzv((String)"eglChooseConfig failed: success=%b, numConfigs[0]=%d, configs[0]=%s", (Object[])new Object[]{bl, object3[0], object2[0]}), null);
        object3 = this.zzd;
        if (n == 0) {
            object2 = new int[3];
            Object[] objectArray = object2;
            object2[0] = 12440;
            objectArray[1] = 2;
            objectArray[2] = 12344;
        } else {
            object2 = new int[5];
            Object[] objectArray = object2;
            object2[0] = 12440;
            objectArray[1] = 2;
            objectArray[2] = 12992;
            objectArray[3] = 1;
            objectArray[4] = 12344;
        }
        object3 = EGL14.eglCreateContext((EGLDisplay)object3, (EGLConfig)object, (EGLContext)EGL14.EGL_NO_CONTEXT, (int[])object2, (int)0);
        if (object3 == null) throw new zzaky("eglCreateContext failed", null);
        this.zze = (EGLContext)object3;
        EGLDisplay eGLDisplay = this.zzd;
        if (n == 1) {
            object2 = EGL14.EGL_NO_SURFACE;
        } else {
            if (n == 2) {
                object2 = new int[7];
                Object object4 = object2;
                object2[0] = 12375;
                object4[1] = 1;
                object4[2] = 12374;
                object4[3] = 1;
                object4[4] = 12992;
                object4[5] = 1;
                object4[6] = 12344;
            } else {
                object2 = new int[5];
                Object object5 = object2;
                object2[0] = 12375;
                object5[1] = 1;
                object5[2] = 12374;
                object5[3] = 1;
                object5[4] = 12344;
            }
            object2 = EGL14.eglCreatePbufferSurface((EGLDisplay)eGLDisplay, (EGLConfig)object, (int[])object2, (int)0);
            if (object2 == null) throw new zzaky("eglCreatePbufferSurface failed", null);
        }
        if (!EGL14.eglMakeCurrent((EGLDisplay)eGLDisplay, (EGLSurface)object2, (EGLSurface)object2, (EGLContext)object3)) throw new zzaky("eglMakeCurrent failed", null);
        this.zzf = (EGLSurface)object2;
        GLES20.glGenTextures((int)1, (int[])this.zzc, (int)0);
        n = 0;
        while ((n2 = GLES20.glGetError()) != 0) {
            object2 = String.valueOf(GLU.gluErrorString((int)n2));
            object2 = object2.length() != 0 ? "glError ".concat((String)object2) : new String("glError ");
            Log.e((String)"GlUtil", (String)object2);
            n = n2;
        }
        if (n != 0) {
            object2 = String.valueOf(GLU.gluErrorString((int)n));
            object2 = object2.length() != 0 ? "glError ".concat((String)object2) : new String("glError ");
            Log.e((String)"GlUtil", (String)object2);
        }
        object2 = new SurfaceTexture(this.zzc[0]);
        this.zzg = object2;
        object2.setOnFrameAvailableListener((SurfaceTexture.OnFrameAvailableListener)this);
    }

    public final void zzb() {
        SurfaceTexture surfaceTexture;
        block13: {
            this.zzb.removeCallbacks((Runnable)this);
            try {
                surfaceTexture = this.zzg;
                if (surfaceTexture != null) {
                    surfaceTexture.release();
                    GLES20.glDeleteTextures((int)1, (int[])this.zzc, (int)0);
                }
                if ((surfaceTexture = this.zzd) == null) break block13;
            }
            catch (Throwable throwable) {
                EGLDisplay eGLDisplay = this.zzd;
                if (eGLDisplay != null && !eGLDisplay.equals((Object)EGL14.EGL_NO_DISPLAY)) {
                    EGL14.eglMakeCurrent((EGLDisplay)this.zzd, (EGLSurface)EGL14.EGL_NO_SURFACE, (EGLSurface)EGL14.EGL_NO_SURFACE, (EGLContext)EGL14.EGL_NO_CONTEXT);
                }
                if ((eGLDisplay = this.zzf) != null && !eGLDisplay.equals((Object)EGL14.EGL_NO_SURFACE)) {
                    EGL14.eglDestroySurface((EGLDisplay)this.zzd, (EGLSurface)this.zzf);
                }
                if ((eGLDisplay = this.zze) != null) {
                    EGL14.eglDestroyContext((EGLDisplay)this.zzd, (EGLContext)eGLDisplay);
                }
                if (zzamq.zza >= 19) {
                    EGL14.eglReleaseThread();
                }
                if ((eGLDisplay = this.zzd) != null && !eGLDisplay.equals((Object)EGL14.EGL_NO_DISPLAY)) {
                    EGL14.eglTerminate((EGLDisplay)this.zzd);
                }
                this.zzd = null;
                this.zze = null;
                this.zzf = null;
                this.zzg = null;
                throw throwable;
            }
            if (!surfaceTexture.equals((Object)EGL14.EGL_NO_DISPLAY)) {
                EGL14.eglMakeCurrent((EGLDisplay)this.zzd, (EGLSurface)EGL14.EGL_NO_SURFACE, (EGLSurface)EGL14.EGL_NO_SURFACE, (EGLContext)EGL14.EGL_NO_CONTEXT);
            }
        }
        if ((surfaceTexture = this.zzf) != null && !surfaceTexture.equals((Object)EGL14.EGL_NO_SURFACE)) {
            EGL14.eglDestroySurface((EGLDisplay)this.zzd, (EGLSurface)this.zzf);
        }
        if ((surfaceTexture = this.zze) != null) {
            EGL14.eglDestroyContext((EGLDisplay)this.zzd, (EGLContext)surfaceTexture);
        }
        if (zzamq.zza >= 19) {
            EGL14.eglReleaseThread();
        }
        if ((surfaceTexture = this.zzd) != null && !surfaceTexture.equals((Object)EGL14.EGL_NO_DISPLAY)) {
            EGL14.eglTerminate((EGLDisplay)this.zzd);
        }
        this.zzd = null;
        this.zze = null;
        this.zzf = null;
        this.zzg = null;
    }

    public final SurfaceTexture zzc() {
        SurfaceTexture surfaceTexture = this.zzg;
        if (surfaceTexture == null) throw null;
        return surfaceTexture;
    }
}
