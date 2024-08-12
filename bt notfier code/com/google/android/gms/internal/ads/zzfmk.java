/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzged
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzged;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import javax.annotation.CheckForNull;

public final class zzfmk {
    @CheckForNull
    private static final Object zza;
    @CheckForNull
    private static final Method zzb;
    @CheckForNull
    private static final Method zzc;

    static {
        Object object;
        zza = object = zzfmk.zzc();
        Object var1_1 = null;
        object = object == null ? null : zzfmk.zze("getStackTraceElement", Throwable.class, Integer.TYPE);
        zzb = object;
        object = zza;
        object = object == null ? var1_1 : zzfmk.zzd(object);
        zzc = object;
    }

    public static void zza(Throwable throwable) {
        if (throwable instanceof RuntimeException) throw (RuntimeException)throwable;
        if (throwable instanceof Error) throw (Error)throwable;
    }

    public static String zzb(Throwable throwable) {
        StringWriter stringWriter = new StringWriter();
        zzged.zzc((Throwable)throwable, (PrintWriter)new PrintWriter(stringWriter));
        return stringWriter.toString();
    }

    /*
     * Enabled force condition propagation
     */
    @CheckForNull
    private static Object zzc() {
        Object object = null;
        try {
            Object object2 = Class.forName("sun.misc.SharedSecrets", false, null).getMethod("getJavaLangAccess", new Class[0]).invoke(null, new Object[0]);
            return object2;
        }
        catch (ThreadDeath threadDeath) {
            throw threadDeath;
        }
        catch (Throwable throwable) {
            return object;
        }
    }

    @CheckForNull
    private static Method zzd(Object object) {
        try {
            Method method = zzfmk.zze("getStackTraceDepth", Throwable.class);
            if (method == null) {
                return null;
            }
            Throwable throwable = new Throwable();
            method.invoke(object, throwable);
            return method;
        }
        catch (IllegalAccessException | UnsupportedOperationException | InvocationTargetException exception) {
            return null;
        }
    }

    @CheckForNull
    private static Method zze(String object, Class<?> ... classArray) throws ThreadDeath {
        try {
            object = Class.forName("sun.misc.JavaLangAccess", false, null).getMethod((String)object, classArray);
            return object;
        }
        catch (Throwable throwable) {
            return null;
        }
        catch (ThreadDeath threadDeath) {
            throw threadDeath;
        }
    }
}
