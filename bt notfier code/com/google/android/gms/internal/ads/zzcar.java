/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.net.Uri$Builder
 *  android.os.Build
 *  android.os.Build$VERSION
 *  android.os.Looper
 *  android.text.TextUtils
 *  com.google.android.gms.common.GoogleApiAvailabilityLight
 *  com.google.android.gms.common.wrappers.Wrappers
 *  com.google.android.gms.internal.ads.zzbet
 *  com.google.android.gms.internal.ads.zzbjd
 *  com.google.android.gms.internal.ads.zzbjl
 *  com.google.android.gms.internal.ads.zzblf
 *  com.google.android.gms.internal.ads.zzcao
 *  com.google.android.gms.internal.ads.zzcap
 *  com.google.android.gms.internal.ads.zzcaq
 *  com.google.android.gms.internal.ads.zzcas
 *  com.google.android.gms.internal.ads.zzcat
 *  com.google.android.gms.internal.ads.zzcgm
 *  com.google.android.gms.internal.ads.zzcgt
 *  com.google.android.gms.internal.ads.zzcgy
 *  com.google.android.gms.internal.ads.zzcgz
 *  com.google.android.gms.internal.ads.zzfkz
 *  com.google.android.gms.internal.ads.zzged
 */
package com.google.android.gms.internal.ads;

import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.os.Looper;
import android.text.TextUtils;
import com.google.android.gms.common.GoogleApiAvailabilityLight;
import com.google.android.gms.common.wrappers.Wrappers;
import com.google.android.gms.internal.ads.zzbet;
import com.google.android.gms.internal.ads.zzbjd;
import com.google.android.gms.internal.ads.zzbjl;
import com.google.android.gms.internal.ads.zzblf;
import com.google.android.gms.internal.ads.zzcao;
import com.google.android.gms.internal.ads.zzcap;
import com.google.android.gms.internal.ads.zzcaq;
import com.google.android.gms.internal.ads.zzcas;
import com.google.android.gms.internal.ads.zzcat;
import com.google.android.gms.internal.ads.zzcgm;
import com.google.android.gms.internal.ads.zzcgt;
import com.google.android.gms.internal.ads.zzcgy;
import com.google.android.gms.internal.ads.zzcgz;
import com.google.android.gms.internal.ads.zzfkz;
import com.google.android.gms.internal.ads.zzged;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.WeakHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
public final class zzcar
implements zzcat {
    static zzcat zza;
    static zzcat zzb;
    private static final Object zzc;
    private final Object zzd = new Object();
    private final Context zze;
    private final WeakHashMap<Thread, Boolean> zzf = new WeakHashMap();
    private final ExecutorService zzg;
    private final zzcgz zzh;

    static {
        zzc = new Object();
        zza = null;
        zzb = null;
    }

    protected zzcar(Context context, zzcgz zzcgz2) {
        zzfkz.zza();
        this.zzg = Executors.unconfigurableExecutorService(Executors.newCachedThreadPool());
        Context context2 = context;
        if (context.getApplicationContext() != null) {
            context2 = context.getApplicationContext();
        }
        this.zze = context2;
        this.zzh = zzcgz2;
    }

    /*
     * Enabled unnecessary exception pruning
     * Converted monitor instructions to comments
     */
    public static zzcat zza(Context context) {
        Object object = zzc;
        // MONITORENTER : object
        if (zza == null) {
            if (((Boolean)zzblf.zze.zze()).booleanValue()) {
                zzbjd zzbjd2 = zzbjl.zzfz;
                if (!((Boolean)zzbet.zzc().zzc(zzbjd2)).booleanValue()) {
                    zzcar zzcar2 = new zzcar(context, zzcgz.zza());
                    zza = zzcar2;
                    return zza;
                }
            }
            context = new zzcas();
            zza = context;
        }
        // MONITOREXIT : object
        return zza;
    }

    /*
     * Enabled unnecessary exception pruning
     * Converted monitor instructions to comments
     */
    public static zzcat zzb(Context object, zzcgz object2) {
        Object object3 = zzc;
        // MONITORENTER : object3
        if (zzb == null) {
            if (((Boolean)zzblf.zze.zze()).booleanValue()) {
                Object object4 = zzbjl.zzfz;
                if (!((Boolean)zzbet.zzc().zzc(object4)).booleanValue()) {
                    object4 = new zzcar((Context)object, (zzcgz)object2);
                    object = Looper.getMainLooper().getThread();
                    if (object != null) {
                        object2 = object4.zzd;
                        // MONITORENTER : object2
                        object4.zzf.put((Thread)object, true);
                        // MONITOREXIT : object2
                        object2 = ((Thread)object).getUncaughtExceptionHandler();
                        zzcaq zzcaq2 = new zzcaq((zzcar)object4, (Thread.UncaughtExceptionHandler)object2);
                        ((Thread)object).setUncaughtExceptionHandler((Thread.UncaughtExceptionHandler)zzcaq2);
                    }
                    object2 = Thread.getDefaultUncaughtExceptionHandler();
                    object = new zzcap((zzcar)object4, (Thread.UncaughtExceptionHandler)object2);
                    Thread.setDefaultUncaughtExceptionHandler((Thread.UncaughtExceptionHandler)object);
                    zzb = object4;
                    return zzb;
                }
            }
            object = new zzcas();
            zzb = object;
        }
        // MONITOREXIT : object3
        return zzb;
    }

    protected final void zzc(Thread object, Throwable throwable) {
        if (throwable == null) return;
        object = throwable;
        boolean bl = false;
        boolean bl2 = false;
        while (true) {
            StackTraceElement stackTraceElement;
            if (object == null) {
                if (!bl) return;
                if (bl2) return;
                this.zze(throwable, "", 1.0f);
                return;
            }
            StackTraceElement[] stackTraceElementArray = ((Throwable)object).getStackTrace();
            int n = stackTraceElementArray.length;
            for (int i = 0; i < n; bl |= zzcgm.zzi((String)stackTraceElement.getClassName()), bl2 |= this.getClass().getName().equals(stackTraceElement.getClassName()), ++i) {
                stackTraceElement = stackTraceElementArray[i];
            }
            object = ((Throwable)object).getCause();
        }
    }

    public final void zzd(Throwable throwable, String string) {
        this.zze(throwable, string, 1.0f);
    }

    public final void zze(Throwable object, String object2, float f) {
        boolean bl;
        if (zzcgm.zzg((Throwable)object) == null) {
            return;
        }
        String string = object.getClass().getName();
        Object object3 = new StringWriter();
        zzged.zzc((Throwable)object, (PrintWriter)new PrintWriter((Writer)object3));
        String string2 = ((StringWriter)object3).toString();
        double d = f;
        double d2 = Math.random();
        int n = f > 0.0f ? (int)(1.0f / f) : 1;
        if (!(d2 < d)) return;
        ArrayList<String> arrayList = new ArrayList<String>();
        try {
            bl = Wrappers.packageManager((Context)this.zze).isCallerInstantApp();
        }
        catch (Throwable throwable) {
            zzcgt.zzg((String)"Error fetching instant app info", (Throwable)throwable);
            bl = false;
        }
        try {
            object = this.zze.getPackageName();
        }
        catch (Throwable throwable) {
            zzcgt.zzi((String)"Cannot obtain package name, proceeding.");
            object = "unknown";
        }
        Uri.Builder builder = new Uri.Builder().scheme("https").path("//pagead2.googlesyndication.com/pagead/gen_204").appendQueryParameter("is_aia", Boolean.toString(bl)).appendQueryParameter("id", "gmob-apps-report-exception").appendQueryParameter("os", Build.VERSION.RELEASE).appendQueryParameter("api", String.valueOf(Build.VERSION.SDK_INT));
        String string3 = Build.MANUFACTURER;
        object3 = Build.MODEL;
        if (!((String)object3).startsWith(string3)) {
            StringBuilder stringBuilder = new StringBuilder(String.valueOf(string3).length() + 1 + String.valueOf(object3).length());
            stringBuilder.append(string3);
            stringBuilder.append(" ");
            stringBuilder.append((String)object3);
            object3 = stringBuilder.toString();
        }
        object2 = builder.appendQueryParameter("device", (String)object3).appendQueryParameter("js", this.zzh.zza).appendQueryParameter("appid", (String)object).appendQueryParameter("exceptiontype", string).appendQueryParameter("stacktrace", string2).appendQueryParameter("eids", TextUtils.join((CharSequence)",", (Iterable)zzbjl.zzc())).appendQueryParameter("exceptionkey", (String)object2).appendQueryParameter("cl", "407425155").appendQueryParameter("rc", "dev").appendQueryParameter("sampling_rate", Integer.toString(n)).appendQueryParameter("pb_tm", String.valueOf(zzblf.zzc.zze())).appendQueryParameter("gmscv", String.valueOf(GoogleApiAvailabilityLight.getInstance().getApkVersion(this.zze)));
        object = true != this.zzh.zze ? "0" : "1";
        arrayList.add(object2.appendQueryParameter("lite", (String)object).toString());
        object2 = arrayList.iterator();
        while (object2.hasNext()) {
            object3 = (String)object2.next();
            object = new zzcgy(null);
            this.zzg.execute((Runnable)new zzcao((zzcgy)object, (String)object3));
        }
    }
}
