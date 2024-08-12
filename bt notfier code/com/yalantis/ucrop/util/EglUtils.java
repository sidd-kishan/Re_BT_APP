/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.opengl.EGL14
 *  android.opengl.EGLConfig
 *  android.opengl.EGLContext
 *  android.opengl.EGLDisplay
 *  android.opengl.EGLSurface
 *  android.opengl.GLES10
 *  android.opengl.GLES20
 *  android.os.Build$VERSION
 *  android.util.Log
 *  javax.microedition.khronos.egl.EGL10
 *  javax.microedition.khronos.egl.EGLConfig
 *  javax.microedition.khronos.egl.EGLContext
 *  javax.microedition.khronos.egl.EGLDisplay
 *  javax.microedition.khronos.egl.EGLSurface
 */
package com.yalantis.ucrop.util;

import android.opengl.EGL14;
import android.opengl.EGLConfig;
import android.opengl.EGLContext;
import android.opengl.EGLDisplay;
import android.opengl.GLES10;
import android.opengl.GLES20;
import android.os.Build;
import android.util.Log;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLSurface;

public class EglUtils {
    private static final String TAG = "EglUtils";

    private EglUtils() {
    }

    private static int getMaxTextureEgl10() {
        EGL10 eGL10 = (EGL10)javax.microedition.khronos.egl.EGLContext.getEGL();
        javax.microedition.khronos.egl.EGLDisplay eGLDisplay = eGL10.eglGetDisplay(EGL10.EGL_DEFAULT_DISPLAY);
        eGL10.eglInitialize(eGLDisplay, new int[2]);
        EGLSurface eGLSurface = new javax.microedition.khronos.egl.EGLConfig[1];
        Object object = new int[1];
        eGL10.eglChooseConfig(eGLDisplay, new int[]{12351, 12430, 12329, 0, 12339, 1, 12344}, (javax.microedition.khronos.egl.EGLConfig[])eGLSurface, 1, object);
        if (object[0] == 0) {
            return 0;
        }
        object = eGLSurface[0];
        eGLSurface = eGL10.eglCreatePbufferSurface(eGLDisplay, (javax.microedition.khronos.egl.EGLConfig)object, new int[]{12375, 64, 12374, 64, 12344});
        object = eGL10.eglCreateContext(eGLDisplay, (javax.microedition.khronos.egl.EGLConfig)object, EGL10.EGL_NO_CONTEXT, new int[]{12440, 1, 12344});
        eGL10.eglMakeCurrent(eGLDisplay, eGLSurface, eGLSurface, (javax.microedition.khronos.egl.EGLContext)object);
        int[] nArray = new int[1];
        GLES10.glGetIntegerv((int)3379, (int[])nArray, (int)0);
        eGL10.eglMakeCurrent(eGLDisplay, EGL10.EGL_NO_SURFACE, EGL10.EGL_NO_SURFACE, EGL10.EGL_NO_CONTEXT);
        eGL10.eglDestroySurface(eGLDisplay, eGLSurface);
        eGL10.eglDestroyContext(eGLDisplay, (javax.microedition.khronos.egl.EGLContext)object);
        eGL10.eglTerminate(eGLDisplay);
        return nArray[0];
    }

    private static int getMaxTextureEgl14() {
        EGLDisplay eGLDisplay = EGL14.eglGetDisplay((int)0);
        Object object = new int[2];
        EGL14.eglInitialize((EGLDisplay)eGLDisplay, (int[])object, (int)0, (int[])object, (int)1);
        object = new EGLConfig[1];
        Object object2 = new int[1];
        EGL14.eglChooseConfig((EGLDisplay)eGLDisplay, (int[])new int[]{12351, 12430, 12329, 0, 12352, 4, 12339, 1, 12344}, (int)0, (EGLConfig[])object, (int)0, (int)1, (int[])object2, (int)0);
        if (object2[0] == 0) {
            return 0;
        }
        object2 = object[0];
        object = EGL14.eglCreatePbufferSurface((EGLDisplay)eGLDisplay, (EGLConfig)object2, (int[])new int[]{12375, 64, 12374, 64, 12344}, (int)0);
        object2 = EGL14.eglCreateContext((EGLDisplay)eGLDisplay, (EGLConfig)object2, (EGLContext)EGL14.EGL_NO_CONTEXT, (int[])new int[]{12440, 2, 12344}, (int)0);
        EGL14.eglMakeCurrent((EGLDisplay)eGLDisplay, (android.opengl.EGLSurface)object, (android.opengl.EGLSurface)object, (EGLContext)object2);
        int[] nArray = new int[1];
        GLES20.glGetIntegerv((int)3379, (int[])nArray, (int)0);
        EGL14.eglMakeCurrent((EGLDisplay)eGLDisplay, (android.opengl.EGLSurface)EGL14.EGL_NO_SURFACE, (android.opengl.EGLSurface)EGL14.EGL_NO_SURFACE, (EGLContext)EGL14.EGL_NO_CONTEXT);
        EGL14.eglDestroySurface((EGLDisplay)eGLDisplay, (android.opengl.EGLSurface)object);
        EGL14.eglDestroyContext((EGLDisplay)eGLDisplay, (EGLContext)object2);
        EGL14.eglTerminate((EGLDisplay)eGLDisplay);
        return nArray[0];
    }

    public static int getMaxTextureSize() {
        try {
            if (Build.VERSION.SDK_INT >= 17) {
                return EglUtils.getMaxTextureEgl14();
            }
            int n = EglUtils.getMaxTextureEgl10();
            return n;
        }
        catch (Exception exception) {
            Log.d((String)TAG, (String)"getMaxTextureSize: ", (Throwable)exception);
            return 0;
        }
    }
}
