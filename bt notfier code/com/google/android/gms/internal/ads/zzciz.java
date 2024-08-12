/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.graphics.SurfaceTexture
 *  android.graphics.SurfaceTexture$OnFrameAvailableListener
 *  android.opengl.GLES20
 *  android.util.Log
 *  com.google.android.gms.internal.ads.zzcix
 *  com.google.android.gms.internal.ads.zzciy
 *  javax.microedition.khronos.egl.EGL10
 *  javax.microedition.khronos.egl.EGLContext
 *  javax.microedition.khronos.egl.EGLDisplay
 *  javax.microedition.khronos.egl.EGLSurface
 */
package com.google.android.gms.internal.ads;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.opengl.GLES20;
import android.util.Log;
import com.google.android.gms.internal.ads.zzcix;
import com.google.android.gms.internal.ads.zzciy;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.util.concurrent.CountDownLatch;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.egl.EGLDisplay;
import javax.microedition.khronos.egl.EGLSurface;

public final class zzciz
extends Thread
implements SurfaceTexture.OnFrameAvailableListener,
zzcix {
    private static final float[] zza = new float[]{-1.0f, -1.0f, -1.0f, 1.0f, -1.0f, -1.0f, -1.0f, 1.0f, -1.0f, 1.0f, 1.0f, -1.0f};
    private volatile boolean zzA;
    private volatile boolean zzB;
    private final zzciy zzb;
    private final float[] zzc;
    private final float[] zzd;
    private final float[] zze;
    private final float[] zzf;
    private final float[] zzg;
    private final float[] zzh;
    private final float[] zzi;
    private float zzj;
    private float zzk;
    private float zzl;
    private int zzm;
    private int zzn;
    private SurfaceTexture zzo;
    private SurfaceTexture zzp;
    private int zzq;
    private int zzr;
    private int zzs;
    private final FloatBuffer zzt;
    private final CountDownLatch zzu;
    private final Object zzv;
    private EGL10 zzw;
    private EGLDisplay zzx;
    private EGLContext zzy;
    private EGLSurface zzz;

    public zzciz(Context context) {
        super("SphericalVideoProcessor");
        FloatBuffer floatBuffer;
        int n = zza.length;
        this.zzt = floatBuffer = ByteBuffer.allocateDirect(48).order(ByteOrder.nativeOrder()).asFloatBuffer();
        floatBuffer.put(zza).position(0);
        this.zzc = new float[9];
        this.zzd = new float[9];
        this.zze = new float[9];
        this.zzf = new float[9];
        this.zzg = new float[9];
        this.zzh = new float[9];
        this.zzi = new float[9];
        this.zzj = Float.NaN;
        context = new zzciy(context);
        this.zzb = context;
        context.zzc((zzcix)this);
        this.zzu = new CountDownLatch(1);
        this.zzv = new Object();
    }

    private static final void zzh(String string) {
        int n = GLES20.glGetError();
        if (n == 0) return;
        StringBuilder stringBuilder = new StringBuilder(string.length() + 21);
        stringBuilder.append(string);
        stringBuilder.append(": glError ");
        stringBuilder.append(n);
        Log.e((String)"SphericalVideoRenderer", (String)stringBuilder.toString());
    }

    private static final void zzi(float[] fArray, float[] fArray2, float[] fArray3) {
        fArray[0] = fArray2[0] * fArray3[0] + fArray2[1] * fArray3[3] + fArray2[2] * fArray3[6];
        fArray[1] = fArray2[0] * fArray3[1] + fArray2[1] * fArray3[4] + fArray2[2] * fArray3[7];
        fArray[2] = fArray2[0] * fArray3[2] + fArray2[1] * fArray3[5] + fArray2[2] * fArray3[8];
        fArray[3] = fArray2[3] * fArray3[0] + fArray2[4] * fArray3[3] + fArray2[5] * fArray3[6];
        fArray[4] = fArray2[3] * fArray3[1] + fArray2[4] * fArray3[4] + fArray2[5] * fArray3[7];
        fArray[5] = fArray2[3] * fArray3[2] + fArray2[4] * fArray3[5] + fArray2[5] * fArray3[8];
        fArray[6] = fArray2[6] * fArray3[0] + fArray2[7] * fArray3[3] + fArray2[8] * fArray3[6];
        fArray[7] = fArray2[6] * fArray3[1] + fArray2[7] * fArray3[4] + fArray2[8] * fArray3[7];
        fArray[8] = fArray2[6] * fArray3[2] + fArray2[7] * fArray3[5] + fArray2[8] * fArray3[8];
    }

    private static final void zzj(float[] fArray, float f) {
        fArray[0] = 1.0f;
        fArray[1] = 0.0f;
        fArray[2] = 0.0f;
        fArray[3] = 0.0f;
        double d = f;
        fArray[4] = (float)Math.cos(d);
        fArray[5] = (float)(-Math.sin(d));
        fArray[6] = 0.0f;
        fArray[7] = (float)Math.sin(d);
        fArray[8] = (float)Math.cos(d);
    }

    private static final void zzk(float[] fArray, float f) {
        double d = f;
        fArray[0] = (float)Math.cos(d);
        fArray[1] = (float)(-Math.sin(d));
        fArray[2] = 0.0f;
        fArray[3] = (float)Math.sin(d);
        fArray[4] = (float)Math.cos(d);
        fArray[5] = 0.0f;
        fArray[6] = 0.0f;
        fArray[7] = 0.0f;
        fArray[8] = 1.0f;
    }

    private static final int zzl(int n, String object) {
        int n2 = GLES20.glCreateShader((int)n);
        zzciz.zzh("createShader");
        if (n2 == 0) return n2;
        GLES20.glShaderSource((int)n2, (String)object);
        zzciz.zzh("shaderSource");
        GLES20.glCompileShader((int)n2);
        zzciz.zzh("compileShader");
        object = new int[1];
        GLES20.glGetShaderiv((int)n2, (int)35713, (int[])object, (int)0);
        zzciz.zzh("getShaderiv");
        if (object[0] != false) return n2;
        object = new StringBuilder(37);
        ((StringBuilder)object).append("Could not compile shader ");
        ((StringBuilder)object).append(n);
        ((StringBuilder)object).append(":");
        Log.e((String)"SphericalVideoRenderer", (String)((StringBuilder)object).toString());
        Log.e((String)"SphericalVideoRenderer", (String)GLES20.glGetShaderInfoLog((int)n2));
        GLES20.glDeleteShader((int)n2);
        zzciz.zzh("deleteShader");
        return 0;
    }

    public final void onFrameAvailable(SurfaceTexture surfaceTexture) {
        ++this.zzs;
        Object object = this.zzv;
        synchronized (object) {
            this.zzv.notifyAll();
            return;
        }
    }

    /*
     * Exception decompiling
     */
    @Override
    public final void run() {
        /*
         * This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
         * 
         * org.benf.cfr.reader.util.ConfusedCFRException: Tried to end blocks [0[TRYBLOCK]], but top level block is 15[UNCONDITIONALDOLOOP]
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.processEndingBlocks(Op04StructuredStatement.java:435)
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.buildNestedBlocks(Op04StructuredStatement.java:484)
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op03SimpleStatement.createInitialStructuredBlock(Op03SimpleStatement.java:736)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisInner(CodeAnalyser.java:850)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisOrWrapFail(CodeAnalyser.java:278)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysis(CodeAnalyser.java:201)
         *     at org.benf.cfr.reader.entities.attributes.AttributeCode.analyse(AttributeCode.java:94)
         *     at org.benf.cfr.reader.entities.Method.analyse(Method.java:531)
         *     at org.benf.cfr.reader.entities.ClassFile.analyseMid(ClassFile.java:1055)
         *     at org.benf.cfr.reader.entities.ClassFile.analyseTop(ClassFile.java:942)
         *     at org.benf.cfr.reader.Driver.doClass(Driver.java:84)
         *     at org.benf.cfr.reader.CfrDriverImpl.analyse(CfrDriverImpl.java:78)
         *     at the.bytecode.club.bytecodeviewer.decompilers.impl.CFRDecompiler.decompile(CFRDecompiler.java:91)
         *     at the.bytecode.club.bytecodeviewer.decompilers.impl.CFRDecompiler.decompileToZip(CFRDecompiler.java:122)
         *     at the.bytecode.club.bytecodeviewer.resources.ResourceDecompiling.decompileSaveAll(ResourceDecompiling.java:262)
         *     at the.bytecode.club.bytecodeviewer.resources.ResourceDecompiling.lambda$decompileSaveAll$0(ResourceDecompiling.java:127)
         *     at java.lang.Thread.run(Unknown Source)
         */
        throw new IllegalStateException("Decompilation failed");
    }

    public final void zza() {
        Object object = this.zzv;
        synchronized (object) {
            this.zzv.notifyAll();
            return;
        }
    }

    public final void zzb(SurfaceTexture surfaceTexture, int n, int n2) {
        this.zzn = n;
        this.zzm = n2;
        this.zzp = surfaceTexture;
    }

    public final void zzc(int n, int n2) {
        Object object = this.zzv;
        synchronized (object) {
            this.zzn = n;
            this.zzm = n2;
            this.zzA = true;
            this.zzv.notifyAll();
            return;
        }
    }

    public final void zzd() {
        Object object = this.zzv;
        synchronized (object) {
            this.zzB = true;
            this.zzp = null;
            this.zzv.notifyAll();
            return;
        }
    }

    /*
     * Enabled force condition propagation
     */
    public final SurfaceTexture zze() {
        if (this.zzp == null) {
            return null;
        }
        try {
            this.zzu.await();
            return this.zzo;
        }
        catch (InterruptedException interruptedException) {
            return this.zzo;
        }
    }

    public final void zzf(float f, float f2) {
        int n = this.zzn;
        int n2 = this.zzm;
        float f3 = n > n2 ? (float)n : (float)n2;
        f = f * 1.7453293f / f3;
        f2 = f2 * 1.7453293f / f3;
        this.zzk -= f;
        this.zzl = f2 = this.zzl - f2;
        f = f2;
        if (f2 < -1.5707964f) {
            this.zzl = -1.5707964f;
            f = -1.5707964f;
        }
        if (!(f > 1.5707964f)) return;
        this.zzl = 1.5707964f;
    }

    final boolean zzg() {
        boolean bl;
        EGLSurface eGLSurface = this.zzz;
        boolean bl2 = bl = false;
        if (eGLSurface != null) {
            bl2 = bl;
            if (eGLSurface != EGL10.EGL_NO_SURFACE) {
                bl2 = this.zzw.eglMakeCurrent(this.zzx, EGL10.EGL_NO_SURFACE, EGL10.EGL_NO_SURFACE, EGL10.EGL_NO_CONTEXT);
                bl2 = this.zzw.eglDestroySurface(this.zzx, this.zzz) | bl2;
                this.zzz = null;
            }
        }
        eGLSurface = this.zzy;
        bl = bl2;
        if (eGLSurface != null) {
            bl = bl2 | this.zzw.eglDestroyContext(this.zzx, (EGLContext)eGLSurface);
            this.zzy = null;
        }
        if ((eGLSurface = this.zzx) == null) return bl;
        bl2 = this.zzw.eglTerminate((EGLDisplay)eGLSurface);
        this.zzx = null;
        return bl2 | bl;
    }
}
